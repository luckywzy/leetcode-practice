package com.cache.cache.pojo;

import lombok.Data;
import org.springframework.util.ObjectUtils;

/**
 * @author liuzhongxu
 * @date 2020/9/8
 */
@Data
public class SecondCache {
    private String key;

    private Object value;

    private Long curTime = System.currentTimeMillis();

    private Long ttl;

    private volatile Boolean needReload;

    public Boolean getNeedReload() {
        if (ObjectUtils.isEmpty(ttl)) {
            return false;
        }
        return System.currentTimeMillis() > curTime + ttl;
    }
}
