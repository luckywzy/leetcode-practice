package com.core.proxy;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/12/28 10:56 下午
 */
public class SmsSendServiceImpl implements SendService {

    @Override
    public void send(String msg) {
        System.out.println("send" + msg);
    }
}
