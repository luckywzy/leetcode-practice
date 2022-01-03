package com.core.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/12/28 10:59 下午
 */
public class SmsInvocationHandler implements InvocationHandler {

    private final Object target;

    private final ProxySmsSendService proxySmsSendService;

    public SmsInvocationHandler(Object target, ProxySmsSendService proxySmsSendService) {
        this.target = target;
        this.proxySmsSendService = proxySmsSendService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before send!");
        System.out.println(proxy.getClass().getName());
        proxySmsSendService.before();
        Object invoke = method.invoke(target, args);
        System.out.println("after send!");
        proxySmsSendService.after();
        return invoke;
    }
}
