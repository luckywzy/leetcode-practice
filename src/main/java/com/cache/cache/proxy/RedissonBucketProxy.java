package com.cache.cache.proxy;

import com.cache.cache.pojo.LocalCache;
import com.cache.cache.pojo.SecondCache;
import com.github.benmanes.caffeine.cache.Cache;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.redisson.RedissonBucket;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.util.ObjectUtils;

/**
 * @Author: xiongjingyi
 * @Date: 2021/5/26
 */

@Slf4j
public class RedissonBucketProxy {

    public static Object get(Method method, Object[] objects, Object target, Object cacheKey,
            Cache caffeine, RedissonClient redissonClient) throws Throwable {

        if (ObjectUtils.isEmpty(cacheKey)) {
            cacheKey = Arrays.toString(objects);
        }

        // wrapper is null
        if (ObjectUtils.isEmpty(caffeine)) {
            return method.invoke(target, objects);
        }

        // 本地缓存对象  会触发 load reload  if value=null load if REFRESH_TIME reload
        LocalCache localCacheBean = (LocalCache) caffeine.get(cacheKey, (Object key) -> LocalCache.buildDefault((String) key));

        // 本地缓存为空 同步加载
        if (ObjectUtils.isEmpty(localCacheBean.getValue())) {
            return invokeRedissonGet(localCacheBean, method, objects, target, redissonClient);
        }

        // 刷新本地缓存
        if (localCacheBean.getNeedReload()) {
            // double check sync
            synchronized (localCacheBean) {
                if (localCacheBean.getNeedReload()) {
                    localCacheBean.setNeedReload(false);
                    // reload from redis to local
                    return invokeRedissonGet(localCacheBean, method, objects, target, redissonClient);
                }
            }
        }
        return localCacheBean.getValue();
    }

    public static Object set(Object[] objects, Object target, Object cacheKey, Cache caffeine) {
        // set 永不过期，手动控制过期时间
        RedissonBucket redissonBucket = (RedissonBucket) target;
        if (objects.length == 1) {
            redissonBucket.set(objects[0]);
        }
        //有过期时间
        if (objects.length >= 3) {
            SecondCache secondCache = new SecondCache();
            secondCache.setKey(cacheKey.toString());
            secondCache.setValue(objects[0]);
            long timeToLive = (long) objects[1];
            TimeUnit timeUnit = (TimeUnit) objects[2];
            secondCache.setTtl(timeUnit.toMillis(timeToLive));
            redissonBucket.set(secondCache);
        }
        log.debug("更新redis缓存 key={},value={}", cacheKey, objects[0]);

        // write local cache
        LocalCache localCacheBean = new LocalCache();
        localCacheBean.setKey(String.valueOf(cacheKey));
        localCacheBean.setValue(objects[0]);
        localCacheBean.setNeedReload(false);
        caffeine.put(cacheKey, localCacheBean);
        log.debug("更新本地缓存 key={},value={}", cacheKey, localCacheBean);
        return null;
    }


    public static Object invokeRedissonGet(LocalCache localCacheBean, Method method,
            Object[] objects, Object target, RedissonClient redissonClient) throws Throwable {
        // 执行redis get
        Object obj = method.invoke(target, objects);

        // 首次访问
        if (ObjectUtils.isEmpty(obj) && ObjectUtils.isEmpty(localCacheBean.getValue())) {
            log.debug("first load. localCacheBean=null,secondCache=null");
            return null;
        }

        // secondCache is not empty , load from redis to local
        if (!ObjectUtils.isEmpty(obj)) {
            log.debug("load from redis to local. secondCache={}", obj);
            if (obj instanceof SecondCache){
                localCacheBean.setValue(((SecondCache)obj).getValue());
            }else {
                localCacheBean.setValue(obj);
            }
        }

        //if secondCache needReload
        //set（v）这种是没有secondCache的，直接是Object的，这种类型不会触发reload
        //set（v, ttl, timeunit）这种是有secondCache的，实际永不过期，手动控制过期
        //SecondCache才需要告诉业务null,让业务去加载DB的数据，因为只有过期二级缓存才会走到这一步
        if (obj instanceof SecondCache && (ObjectUtils.isEmpty(obj) || ((SecondCache)obj).getNeedReload())) {
            //  set nx 1  放1线程，其他返回一级缓存，
            RBucket<Object> lock = redissonClient.getBucket(localCacheBean.getKey() + "_lock");
            if (lock.trySet(1, 2L, TimeUnit.SECONDS)) {
                log.debug("reload secondCache key={}", localCacheBean.getKey());
                return null;
            }
        }

        localCacheBean.setNeedReload(false);
        return localCacheBean.getValue();
    }


}
