package com.core.proxy;

import java.lang.reflect.Proxy;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/12/28 11:01 下午
 */
public class RunProxy {


    public static void main(String[] args) {
        SmsSendServiceImpl smsSendService = new SmsSendServiceImpl();
        SendService proxyInstance = (SendService) Proxy.newProxyInstance(smsSendService.getClass().getClassLoader(),
                smsSendService.getClass().getInterfaces(),
                new SmsInvocationHandler(smsSendService, new ProxySmsSendService()));


        proxyInstance.send("hello");
    }
}
