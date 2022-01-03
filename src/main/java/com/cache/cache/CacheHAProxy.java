package com.cache.cache;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author wangzongyu
 * @Description: 缓存代理 正常情况：同步写Redis，异步写fusion，fusion写入失败不影响正常流程 异常情况： 1. 网络抖动导致部分Redis请求超时，通过
 * SentinelResource 配置自动切换到 fusion 2. Redis不可用，通过 Apollo 配置手动切换到 fusion（此时为同步写入fusion）
 * 注：fusion中数据的过期时间是通过 Apollo 配置的
 * @date 2021/3/6 2:23 下午
 */
@Slf4j
@Component
public class CacheHAProxy {

    /**
     * cacheOp
     */
    @Resource
    private CacheOpHandler handler;

    /**
     * 故障切换开关
     */
    //@ApolloJsonValue(namespace = "limit-center", config = "redisFailOver", key = "failOverSwitch")
    private FailOverSwitch failOverSwitch = new FailOverSwitch();

    public <T> T get(String key) {
        if (failOverSwitch.close()) {
            return handler.getSimpleKey(key);
        }
        return handler.getFromFusion(key);
    }

    public <T> T getFromLocal(String key) {
        if (failOverSwitch.close()) {
            return handler.getSimpleKeyFromLocal(key);
        }
        return handler.getFromFusion(key);
    }

    public <T> void set(String key, T value) {
        if (failOverSwitch.open()) {
            handler.set2Fusion(key, value);
            return;
        }

        handler.set(key, value);
        //backup
        handler.set2Fusion(key, value);
    }

    public <T> void set(String key, T value, long timeToLive, TimeUnit timeUnit) {
        if (failOverSwitch.open()) {
            handler.set2Fusion(key, value, timeToLive, timeUnit);
            return;
        }

        handler.set(key, value, timeToLive, timeUnit);
        //backup
        handler.set2Fusion(key, value, timeToLive, timeUnit);
    }

    public <V> Map<String, V> getMulti(String[] keys) {

        if (failOverSwitch.close()) {
            return handler.getMultiCache(keys);
        }

        return handler.getMultiKeysFromFusion(keys);
    }


    public <V> Map<String, V> getMultiFromLocal(String[] keys) {
        if (failOverSwitch.close()) {
            return handler.getMultiCacheFromLocal(keys);
        }

        return handler.getMultiKeysFromFusion(keys);
    }


    public <T> void setMulti(Map<String, T> cacheMap) {
        if (failOverSwitch.open()) {
            //sync
            handler.setMulti2Fusion(cacheMap);
            return;
        }

        handler.setMultiCache(cacheMap);
    }

    public <T> void setMultiAsync(Map<String, T> cacheMap, long timeToLive, TimeUnit timeUnit) {
        if (failOverSwitch.open()) {
            handler.trySetMultiAsync2Fusion(cacheMap, (int) timeToLive, timeUnit);
            return;
        }

        handler.setExBatchCache(cacheMap, timeToLive, timeUnit);
        //async
        handler.trySetMultiAsync2Fusion(cacheMap, (int) timeToLive, timeUnit);
    }

    public void delKey(String key) {
        if (key == null) {
            return;
        }
        handler.delSimpleKey(key);
    }


    @Data
    static class FailOverSwitch implements Serializable {

        private Boolean failOver = false;

        public boolean open() {
            return failOver;
        }

        public boolean close() {
            return !failOver;
        }
    }
}
