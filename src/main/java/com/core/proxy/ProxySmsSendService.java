package com.core.proxy;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/12/28 10:57 下午
 */
public class ProxySmsSendService {

    public void before() {
        System.out.println("proxy before send!");
    }

    public void after() {
        System.out.println("proxy after send!");
    }
}
