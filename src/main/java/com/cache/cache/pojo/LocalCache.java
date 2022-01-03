package com.cache.cache.pojo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import lombok.Data;

/**
 * @author liuzhongxu
 * @date 2020/9/4
 */
@Data
public class LocalCache extends ReentrantLock {

    private String key;

    private Object value;

    private volatile Boolean needReload;

    public static LocalCache buildDefault(String key){
        LocalCache localCache = new LocalCache();
        localCache.setKey(key);
        localCache.setValue(null);
        localCache.setNeedReload(true);
        return localCache;
    }

    public static Map<String, LocalCache> buildDefaults(Set<String> keys){
        Map<String, LocalCache> localCacheMap = new HashMap<>();
        keys.forEach(k -> {
            LocalCache localCache = new LocalCache();
            localCache.setKey(k);
            localCache.setValue(null);
            localCache.setNeedReload(true);
            localCacheMap.put(k, localCache);
        });
        return localCacheMap;
    }

}
