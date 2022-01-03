package com.cache.cache;

import com.cache.cache.pojo.LocalCache;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: xiongjingyi
 * @Date: 2021/5/24
 */

@Slf4j
@Configuration
public class CaffeineConf{

    private static final long CAFFEINE_REFRESH_TIME = 1;
    private static final long CAFFEINE_EXPIRE_TIME = 30;
    private static final long CAFFEINE_EXPIRE_MAXSIZE = 20000;
    private static final long CAFFEINE_RELOAD_MAXSIZE = 512;

    @Bean
    public CacheManager caffeineReload() {
        Cache cache = Caffeine.newBuilder()
                //创建或更新之后多久刷新,需要设置cacheLoader
                .refreshAfterWrite(CAFFEINE_REFRESH_TIME, TimeUnit.SECONDS)
                .maximumSize(CAFFEINE_RELOAD_MAXSIZE).build(new CacheLoader<Object, Object>() {

                    @Override
                    public Object load(Object key){
                        log.debug("cacheLoader load key={}", key);
                        LocalCache localCache = new LocalCache();
                        localCache.setKey(key.toString());
                        localCache.setValue(null);
                        localCache.setNeedReload(true);
                        return localCache;
                    }

                    // 重写这个方法将oldValue值返回回去，进而刷新缓存
                    @Override
                    public Object reload(Object key, Object oldValue){
                        log.debug("cacheLoader reload key={} oldValue={}", key, oldValue);
                        LocalCache localCache = (LocalCache) oldValue;
                        localCache.setNeedReload(true);
                        return localCache;
                    }
                });
        return new CacheManager()
                .setCache(cache)
                .setCacheEnum(CacheEnum.RELOAD_ON_TIME);
    }

    @Bean
    public CacheManager caffeineExpire() {
        Cache cache = Caffeine.newBuilder()
                //创建或更新之后多久刷新,需要设置cacheLoader
                .expireAfterWrite(CAFFEINE_EXPIRE_TIME, TimeUnit.SECONDS)
                .refreshAfterWrite(CAFFEINE_REFRESH_TIME, TimeUnit.SECONDS)
                .maximumSize(CAFFEINE_EXPIRE_MAXSIZE).build(new CacheLoader<Object, Object>() {

                    @Override
                    public Object load(Object key){
                        log.debug("cacheLoader load key={}", key);
                        LocalCache localCache = new LocalCache();
                        localCache.setKey(key.toString());
                        localCache.setValue(null);
                        localCache.setNeedReload(true);
                        return localCache;
                    }

                    // 重写这个方法将oldValue值返回回去，进而刷新缓存
                    @Override
                    public Object reload(Object key, Object oldValue){
                        log.debug("cacheLoader reload key={} oldValue={}", key, oldValue);
                        if (oldValue instanceof LocalCache) {
                            LocalCache localCache = (LocalCache) oldValue;
                            localCache.setNeedReload(true);
                            return localCache;
                        }
                        return oldValue;
                    }
                });
        return new CacheManager()
                .setCache(cache)
                .setCacheEnum(CacheEnum.EXPIRE_ON_TIME);
    }

    @Bean
    public Cache originCaffeine() {
        return Caffeine.newBuilder()
                .expireAfterWrite(CAFFEINE_EXPIRE_TIME, TimeUnit.SECONDS)
                .maximumSize(CAFFEINE_EXPIRE_MAXSIZE).build();
    }

}
