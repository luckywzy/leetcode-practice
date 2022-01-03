package com.cache.cache.proxy;

import com.github.benmanes.caffeine.cache.Cache;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.redisson.RedissonBucket;
import org.redisson.RedissonBuckets;
import org.redisson.api.RedissonClient;

/**
 * @Author: xiongjingyi
 * @Date: 2021/6/4
 */
public class ProxyDispatcher {

    public static Object dispatch(Object target, Method method, Object[] objects
            , Object cacheKey, Long ttl, TimeUnit timeUnit, Cache caffeine,
            RedissonClient redissonClient) throws Throwable {
        //get simple key
        if (RedissonBucket.class.equals(target.getClass())) {

            if (method.getName().equalsIgnoreCase("get")) {
                return RedissonBucketProxy
                        .get(method, objects, target, cacheKey, caffeine, redissonClient);
            }

            if (method.getName().equalsIgnoreCase("set")) {
                return RedissonBucketProxy.set(objects, target, cacheKey, caffeine);
            }
        }
        //get batch of keys
        if (RedissonBuckets.class.equals(target.getClass())) {
            if (method.getName().equalsIgnoreCase("get")) {
                return RedissonBucketsProxy
                        .get(method, objects, target, caffeine, redissonClient);
            }

            if (method.getName().equalsIgnoreCase("set")) {
                return RedissonBucketsProxy.set(objects, target, caffeine, ttl, timeUnit);
            }
        }

        return method.invoke(target, objects);

    }

}
