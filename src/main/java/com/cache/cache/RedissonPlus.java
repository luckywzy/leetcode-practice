package com.cache.cache;

import com.github.benmanes.caffeine.cache.Cache;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.RedissonBucket;
import org.redisson.RedissonBuckets;
import org.redisson.api.RBucket;
import org.redisson.api.RBuckets;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

/**
 * @author xiongjingyi
 * @date 2021/5/25
 */
@Slf4j
@Component
public class RedissonPlus {

    @Resource
    private List<CacheManager> cacheManagers;

    private Map<CacheEnum, Cache> cacheMap;

    @Resource(name = "redisson")
    private RedissonClient redissonClient;

    @Value("${redisson.localcache}")
    private boolean initLocalCache;

    @Resource
    private ThreadPoolTaskExecutor poolTaskExecutor;

    @PostConstruct
    public void init() {
        cacheMap = cacheManagers.stream()
                .collect(Collectors.toMap(CacheManager::getCacheEnum, CacheManager::getCache));
    }

    private RedissonProxy createProxy() {
        RedissonProxy redissonProxy = new RedissonProxy();
        if (!initLocalCache) {
            return redissonProxy;
        }
        redissonProxy.setPoolTaskExecutor(poolTaskExecutor);
        return redissonProxy;
    }

    /*
    本地缓存定时过期类型
     */
    public <V> RBucket<V> getBucketEx(String key) {
        RBucket<V> bucket = redissonClient.getBucket(key);
        CacheEnum cacheEnum = CacheEnum.EXPIRE_ON_TIME;
        RedissonBucket bucket1 = (RedissonBucket) createProxy()
                .bind(bucket, (Redisson) redissonClient, cacheEnum, cacheMap.get(cacheEnum), null,
                        null);
        return (RBucket<V>) bucket1;
    }

    /*
    本地缓存定时过期类型
     */
    public RBuckets getBucketsEx(Long ttl, TimeUnit timeUnit) {
        RBuckets buckets = redissonClient.getBuckets();
        CacheEnum cacheEnum = CacheEnum.EXPIRE_ON_TIME;
        return (RedissonBuckets) createProxy().bind(buckets, (Redisson) redissonClient, cacheEnum,
                cacheMap.get(cacheEnum), ttl, timeUnit);
    }

    /*
    本地缓存定时过期类型
     */
    public RBuckets getBucketsEx() {
        return getBucketsEx(null, null);
    }

    /*
    本地缓存不过期类型
     */
    public <V> RBucket<V> getBucketReload(String key) {
        RBucket<V> bucket = redissonClient.getBucket(key);
        CacheEnum cacheEnum = CacheEnum.RELOAD_ON_TIME;
        RedissonBucket bucket1 = (RedissonBucket) createProxy()
                .bind(bucket, (Redisson) redissonClient, cacheEnum,
                        cacheMap.get(cacheEnum), null, null);
        return (RBucket<V>) bucket1;
    }

    /*
   本地缓存不过期类型
    */
    public RBuckets getBucketsReload(Long ttl, TimeUnit timeUnit) {
        RBuckets buckets = redissonClient.getBuckets();
        CacheEnum cacheEnum = CacheEnum.RELOAD_ON_TIME;
        return (RedissonBuckets) createProxy().bind(buckets, (Redisson) redissonClient, cacheEnum,
                cacheMap.get(cacheEnum), ttl, timeUnit);
    }

    /*
   本地缓存不过期类型
    */
    public RBuckets getBucketsReload() {
        return getBucketsReload(null, null);
    }

}
