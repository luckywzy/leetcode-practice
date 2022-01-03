package com.cache.cache;

import com.github.benmanes.caffeine.cache.Cache;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: xiongjingyi
 * @Date: 2021/6/4
 */
@Data
@Accessors(chain = true)
public class CacheManager {

    private Cache cache;

    private CacheEnum cacheEnum;
}
