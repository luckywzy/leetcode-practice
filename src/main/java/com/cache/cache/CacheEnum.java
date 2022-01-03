package com.cache.cache;

/**
 * 缓存类型
 * @author xiongjingyi
 */

public enum CacheEnum {

    EXPIRE_ON_TIME(1, "本地缓存定时过期，定时淘汰"),

    RELOAD_ON_TIME(2, "本地缓存定时加载，永不淘汰，除非触发淘汰策略");

    private int type;
    private String desc;

    CacheEnum(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public int getType() {
        return type;
    }

}
