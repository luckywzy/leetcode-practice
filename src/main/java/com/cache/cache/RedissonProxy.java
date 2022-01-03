package com.cache.cache;

import com.cache.cache.proxy.ProxyDispatcher;
import com.github.benmanes.caffeine.cache.Cache;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.RedissonBucket;
import org.redisson.RedissonBuckets;
import org.redisson.RedissonList;
import org.redisson.api.RedissonClient;
import org.redisson.command.CommandAsyncExecutor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author xiongjingyi
 * @date 2021/5/25
 */
@Slf4j
public class RedissonProxy implements InvocationHandler {

    private RedissonClient redissonClient;

    private ThreadPoolTaskExecutor poolTaskExecutor;

    private Object target;

    private Object cacheKey;

    private CacheEnum cacheEnum;

    private Cache caffeine;

    private Long ttl;

    private TimeUnit timeUnit;

    public void setPoolTaskExecutor(ThreadPoolTaskExecutor poolTaskExecutor) {
        this.poolTaskExecutor = poolTaskExecutor;
    }

    public Object bind(Object target, Redisson redisson, CacheEnum cacheEnum,
            Cache cache, Long ttl, TimeUnit timeUnit) {
        if (ObjectUtils.isEmpty(cache)) {
            return target;
        }
        this.target = target;
        this.redissonClient = redisson;
        this. cacheEnum = cacheEnum;
        this.caffeine = cache;
        this.ttl = ttl;
        this.timeUnit = timeUnit;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        // 回调方法
        enhancer.setCallback(this);
        if (RedissonBucket.class.equals(this.target.getClass())) {
            RedissonBucket redissonBucket = (RedissonBucket) this.target;
            this.cacheKey = redissonBucket.getName();
            // 创建代理对象
            return enhancer.create(new Class[]{CommandAsyncExecutor.class, String.class},
                    new Object[]{redisson.getCommandExecutor(), this.cacheKey});
        }
        if (RedissonBuckets.class.equals(this.target.getClass())) {
            return enhancer.create(new Class[]{CommandAsyncExecutor.class},
                    new Object[]{redisson.getCommandExecutor()});
        }
        if (RedissonList.class.equals(this.target.getClass())) {
            RedissonList list = (RedissonList) this.target;
            this.cacheKey = list.getName();
            return enhancer.create(new Class[]{CommandAsyncExecutor.class, String.class,
                            RedissonClient.class},
                    new Object[]{redisson.getCommandExecutor(), this.cacheKey, redisson});
        }
        return this.target;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        // 未开启本地缓存
        if (Objects.isNull(this.caffeine)) {
            return method.invoke(target, objects);
        }
        return ProxyDispatcher.dispatch(this.target, method, objects, cacheKey, ttl, timeUnit, caffeine, this.redissonClient);
    }

}
