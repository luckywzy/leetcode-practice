package com.cache.cache.proxy;


import com.cache.cache.pojo.LocalCache;
import com.cache.cache.pojo.SecondCache;
import com.github.benmanes.caffeine.cache.Cache;
import lombok.extern.slf4j.Slf4j;
import org.redisson.RedissonBuckets;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Method;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * @Author: xiongjingyi
 * @Date: 2021/5/26
 */

@Slf4j
public class RedissonBucketsProxy{

    public static Object get(Method method, Object[] objects, Object target, Cache caffeine, RedissonClient redissonClient) throws Exception {

        // wrapper is null
        if (ObjectUtils.isEmpty(caffeine) || objects.length <= 0 || ((Object[])objects[0]).length <= 0) {
            return method.invoke(target, objects);
        }

        Set<String> cacheKeys = new HashSet<>(Arrays.asList(((String[])objects[0])));

        //存在于本地缓存的key
        Set<String> existedKeys = new HashSet<>(cacheKeys);
        Map<String, LocalCache> localCacheBeanMap = (Map<String, LocalCache>) caffeine.getAll(cacheKeys, (Object keys) -> {
            existedKeys.removeAll((Set<String>) keys);
            return invokeRedissonMultiGet(LocalCache.buildDefaults((Set<String>) keys), method, target, objects, redissonClient);
        });

        if (!CollectionUtils.isEmpty(existedKeys)) {
            Map<String, LocalCache> needReloadMap = new HashMap<>();
            List<LocalCache> lockedList = new ArrayList<>(existedKeys.size());
            try {
                existedKeys.forEach(k -> {
                    LocalCache localCacheBean = localCacheBeanMap.get(k);
                    // double check sync
                    if (localCacheBean.getNeedReload() && localCacheBean.tryLock()) {
                        if (localCacheBean.getNeedReload()) {
                            localCacheBean.setNeedReload(false);
                            needReloadMap.put(k, localCacheBean);
                        }
                        lockedList.add(localCacheBean);
                    }
                });
                // reload from redis to local
                invokeRedissonMultiGet(needReloadMap, method, target, objects, redissonClient);
            }finally {
                lockedList.forEach(ReentrantLock::unlock);
            }
        }

        return localCacheBeanMap.values().stream() .collect(Collectors.toMap(LocalCache::getKey, LocalCache::getValue, (o, n) -> n));
    }

    public static Object set(Object[] objects, Object target, Cache caffeine, Long ttl, TimeUnit timeUnit){
        // set 永不过期，手动控制过期时间
        RedissonBuckets redissonBuckets = (RedissonBuckets) target;

        Map<String, ?> map = (Map<String, ?>)objects[0];
        Map<String, LocalCache> localCacheMap = new HashMap<>();
        Map res ;
        //有过期时间
        if (ttl != null && timeUnit != null) {
            Map<String, Object> secondCacheMap = new HashMap<>();
            map.forEach((k, v) -> {
                SecondCache secondCache = new SecondCache();
                secondCache.setKey(k);
                secondCache.setValue(v);
                secondCache.setTtl(timeUnit.toMillis(ttl));
                secondCacheMap.put(k, secondCache);

                LocalCache localCacheBean = new LocalCache();
                localCacheBean.setKey(k);
                localCacheBean.setValue(v);
                localCacheBean.setNeedReload(false);
                localCacheMap.put(k, localCacheBean);
            });
            res = secondCacheMap;
        }else {
            res = map;
            map.forEach((k, v) -> {
                LocalCache localCacheBean = new LocalCache();
                localCacheBean.setKey(k);
                localCacheBean.setValue(v);
                localCacheBean.setNeedReload(false);
                localCacheMap.put(k, localCacheBean);
            });
        }

        redissonBuckets.set(res);
        log.debug("更新redis缓存 map={} ", res);
        // write local cache
        caffeine.putAll(localCacheMap);

        log.debug("更新本地缓存 map={}", localCacheMap);
        return null;
    }

    public static Map<String, LocalCache> invokeRedissonMultiGet(
            Map<String, LocalCache> localCacheMap,
            Method method, Object target, Object[] objects,
            RedissonClient redissonClient){

        if (CollectionUtils.isEmpty(localCacheMap)) {
            return Collections.EMPTY_MAP;
        }

        //需要重新加载的key
        objects[0] = localCacheMap.keySet().toArray(new String[0]);
        // 执行redis get
        Map<String, Object> objMap = null;
        try {
            objMap = (Map<String, Object>) method.invoke(target, objects);
        } catch (Exception e) {
            log.error("invokeRedissonMultiGet_error||err={}", e.getMessage(), e);
        }

        // 首次访问
        if (CollectionUtils.isEmpty(objMap)) {
            log.debug("first load. localCacheMap=null,secondCacheMap=null");
            return Collections.EMPTY_MAP;
        }
        Map<String, LocalCache> res = new HashMap<>();
        //if secondCache needReload
        //set（v）这种是没有secondCache的，直接是Object的，这种类型不会触发reload
        //set（v, ttl, timeunit）这种是有secondCache的，实际永不过期，手动控制过期
        //SecondCache才需要告诉业务null,让业务去加载DB的数据，因为只有过期二级缓存才会走到这一步
        if (!CollectionUtils.isEmpty(objMap)) {
            for (Entry<String, Object> entry : objMap.entrySet()) {
                String k = entry.getKey();
                Object v = entry.getValue();
                LocalCache localCache = localCacheMap.get(k);
                if (Objects.isNull(localCache)){
                    continue;
                }
                localCache.setNeedReload(false);

                if (v instanceof SecondCache) {
                    localCache.setValue(((SecondCache) v).getValue());
                    if (ObjectUtils.isEmpty(v) || ((SecondCache) v).getNeedReload()) {
                        //  set nx 1  放1线程，其他返回一级缓存，
                        RBucket<Object> lock = redissonClient
                                .getBucket(k + "_lock");
                        if (lock.trySet(1, 2L, TimeUnit.SECONDS)) {
                            log.debug("reload secondCache key={}", k);
                            //不放入map
                            continue;
                        }
                    }
                } else {
                    localCache.setValue(v);
                }
                res.put(k, localCache);
            }
        }
        return res;
    }
}
