package com.cache.cache;


import com.google.common.collect.Collections2;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.redisson.api.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Redis 操作封装service
 *
 * @author wanglizheng
 * @date 2/17/21
 **/
@Slf4j
@Service
public class CacheOpHandler {

    /**
     * Redis操作框架
     */
    @Resource(name = "redisson")
    private RedissonClient redissonClient;

    @Resource
    private FusionOpHandler fusionOpHandler;

    @Resource
    private RedissonPlus redissonPlus;

    //@SentinelResource(value = "redisInvoker", blockHandler = "blockToFusionHandler")
    public <T> T getSimpleKey(String key) {
        RBucket<T> bucket = redissonClient.getBucket(key);
        if (bucket != null) {
            return bucket.get();
        }
        return null;
    }

    //@SentinelResource(value = "redisInvoker", blockHandler = "blockToFusionHandler")
    public <T> T getSimpleKeyFromLocal(String key) {
        RBucket<T> bucket = redissonPlus.getBucketEx(key);
        if (bucket != null) {
            return bucket.get();
        }
        return null;
    }

    public <T> void set(String key, T value) {
        RBucket<T> bucket = redissonClient.getBucket(key);
        if (bucket != null) {
            bucket.set(value);
        }
    }

    public <T> void setToLocal(String key, T value) {
        RBucket<T> bucket = redissonPlus.getBucketEx(key);
        if (bucket != null) {
            bucket.set(value);
        }
    }

    public <T> void setToLocal(String key, T value, long timeToLive, TimeUnit timeUnit) {
        RBucket<T> bucket = redissonPlus.getBucketEx(key);
        if (bucket != null) {
            bucket.set(value, timeToLive, timeUnit);
        }
    }

    public <T> void set(String key, T value, long timeToLive, TimeUnit timeUnit) {

        RBucket<T> bucket = redissonClient.getBucket(key);
        if (bucket != null) {
            bucket.set(value, timeToLive, timeUnit);
        }
    }

    /**
     * 获取redis内key-value结构数据
     *
     * @param cacheKeys 缓存查询多key
     * @param <T>       返回结果类型
     * @return key-value映射数据
     */
    //@SentinelResource(value = "redisMultiInvoker", blockHandler = "blockMultiToFusionHandler")
    public <T> Map<String, T> getMultiCache(String[] cacheKeys) {
        if (ArrayUtils.isEmpty(cacheKeys)) {
            return Collections.EMPTY_MAP;
        }

        RBuckets buckets = redissonClient.getBuckets();
        return buckets.get(cacheKeys);
    }

    //@SentinelResource(value = "redisMultiInvoker", blockHandler = "blockMultiToFusionHandler")
    public <T> Map<String, T> getMultiCacheFromLocal(String[] cacheKeys) {
        if (ArrayUtils.isEmpty(cacheKeys)) {
            return Collections.EMPTY_MAP;
        }

        RBuckets buckets = redissonPlus.getBucketsEx();
        return buckets.get(cacheKeys);
    }

    /**
     * 批量设置redis内key-value缓存数据
     *
     * @param cacheMap 需要更新的缓存
     * @param <T>      存入的数据类型
     */
    public <T> void setMultiCache(Map<String, T> cacheMap) {
        if (CollectionUtils.isEmpty(cacheMap)) {
            return;
        }
        RBuckets buckets = redissonClient.getBuckets();
        buckets.set(cacheMap);
    }

    public <T> void setMultiCacheToLocal(Map<String, T> cacheMap) {
        if (CollectionUtils.isEmpty(cacheMap)) {
            return;
        }
        RBuckets buckets = redissonPlus.getBucketsEx();
        buckets.set(cacheMap);
    }

    /**
     * 批量设置redis内key-value缓存数据(带有效期)
     *
     * @param <T>
     * @param cacheMap
     * @param timeToLive
     * @param timeUnit
     */
    public <T> void setExBatchCache(Map<String, T> cacheMap, long timeToLive, TimeUnit timeUnit) {
        if (CollectionUtils.isEmpty(cacheMap)) {
            return;
        }
        RBatch batch = redissonClient.createBatch();

        cacheMap.forEach((k, v) -> {
            batch.getBucket(k).setAsync(v, timeToLive, timeUnit);
        });
        //异步
        RFuture<BatchResult<?>> res = batch.executeAsync();
    }

    public <T> void setExBatchCacheToLocal(Map<String, T> cacheMap, long timeToLive, TimeUnit timeUnit) {
        if (CollectionUtils.isEmpty(cacheMap)) {
            return;
        }
        RBuckets buckets = redissonPlus.getBucketsEx(timeToLive, timeUnit);
        buckets.set(cacheMap);
    }

    /**
     * 删除对应key
     *
     * @param key 待删除key
     */
    public void delSimpleKey(String key) {
        if (key == null) {
            return;
        }
        redissonClient.getBucket(key).delete();
        fusionOpHandler.del(key);
    }

    /**
     * ---- blockHandler-------
     */
    public <T> T blockToFusionHandler(String key) {
        log.warn("fusion-backup||redis is downgrade||get from fusion ||key={}", key);
        return fusionOpHandler.getFromFusion(key);
    }

    public <V> Map<String, V> blockMultiToFusionHandler(String[] keys) {
        log.warn("fusion-backup||redis is downgrade||get from fusion||keys={}", Arrays.toString(keys));
        return fusionOpHandler.getMultiKeysFromFusion(keys);
    }

    /**
     * ---- 以下为fusion相关 ----
     */

    public <T> T getFromFusion(String key) {
        return fusionOpHandler.getFromFusion(key);
    }

    public <T> void set2Fusion(String key, T value, long timeToLive, TimeUnit timeUnit) {
        fusionOpHandler.set2Fusion(key, value, timeToLive, timeUnit);
    }

    public <T> void set2Fusion(String key, T value) {
        fusionOpHandler.set2Fusion(key, value);
    }

    public <V> Map<String, V> getMultiKeysFromFusion(String[] keys) {
        return fusionOpHandler.getMultiKeysFromFusion(keys);
    }

    public <T> void setMulti2Fusion(Map<String, T> cacheMap) {
        fusionOpHandler.setMulti2Fusion(cacheMap);
    }

    public <T> void trySetMultiAsync2Fusion(Map<String, T> cacheMap, Integer expireTime, TimeUnit timeUnit) {
        fusionOpHandler.trySetMultiAsync2Fusion(cacheMap, expireTime, timeUnit);
    }


    @Component
    static
    class FusionOpHandler {

        /**
         * fusion
         */
        @Resource(name = "fusion")
        private RedissonClient fusion;

        /**
         * fusion调用
         *
         * @param key
         * @param <T>
         * @return
         */
        public <T> T getFromFusion(String key) {
            String key1 = renameKeyForFusion(key);
            RBucket<T> bucket = fusion.getBucket(key1);
            return bucket.get();
        }

        private <T> void setAsync2Fusion(String key, T value, long timeToLive, TimeUnit timeUnit) {
            try {
                RBucket<Object> bucket = fusion.getBucket(renameKeyForFusion(key));
                bucket.setAsync(value, timeToLive, timeUnit);
            } catch (Exception e) {

            }
        }

        public <T> void set2Fusion(String key, T value) {
            try {
                RBucket<Object> bucket = fusion.getBucket(renameKeyForFusion(key));
                bucket.set(value);
            } catch (Exception e) {

            }
        }

        public <T> void set2Fusion(String key, T value, long timeToLive, TimeUnit timeUnit) {
            try {
                RBucket<Object> bucket = fusion.getBucket(renameKeyForFusion(key));
                bucket.set(value, timeToLive, timeUnit);
            } catch (Exception e) {

            }
        }

        private <T> void trySetMultiAsync2Fusion(Map<String, T> cacheMap, long timeToLive, TimeUnit timeUnit) {
            RBatch batch = fusion.createBatch();
            cacheMap.forEach((k, v) -> {
                // fusion不支持 setAsync
                batch.getBucket(renameKeyForFusion(k)).trySetAsync(v, timeToLive, timeUnit);
            });
            //异步执行
            batch.executeAsync();
        }


        private <T> void setMulti2Fusion(Map<String, T> cacheMap) {
            RBuckets buckets = fusion.getBuckets();
            buckets.set(renameKeyForFusion(cacheMap));
        }


        /**
         * fusion multikey
         *
         * @param keys
         * @param <V>
         * @return
         */
        private <V> Map<String, V> getMultiKeysFromFusion(String[] keys) {
            String[] keys1 = renameKeyForFusion(keys);
            Map<String, V> stringObjectMap = fusion.getBuckets().get(keys1);
            if (CollectionUtils.isEmpty(stringObjectMap)) {
                return Collections.emptyMap();
            }

            Map<String, V> resultMap = Maps.newHashMapWithExpectedSize(stringObjectMap.size());
            stringObjectMap.forEach((k, v) -> resultMap.put(recoverKeyFromFusion(k), v));

            return resultMap;
        }

        private String renameKeyForFusion(String key) {
            return key.replace(":", "_");
        }

        private String recoverKeyFromFusion(String key) {
            return key.replace("_", ":");
        }


        private String[] renameKeyForFusion(String[] key) {
            String[] res = new String[key.length];
            return Arrays.stream((key))
                    .map(this::renameKeyForFusion)
                    .collect(Collectors.toList())
                    .toArray(res);
        }

        private <T> Map<String, T> renameKeyForFusion(Map<String, T> cacheMap) {
            return cacheMap.entrySet().stream()
                    .collect(Collectors.toMap(e -> renameKeyForFusion(e.getKey()), Map.Entry::getValue));
        }

        public <T> void setAsync2Fusion(String key, T value) {
            RBucket<Object> bucket = fusion.getBucket(renameKeyForFusion(key));
            bucket.setAsync(value);
        }

        public void del(String key) {
            if (key == null) {
                return;
            }
            fusion.getBucket(key).delete();
        }
    }


}
