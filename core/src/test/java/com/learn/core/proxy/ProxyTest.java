package com.learn.core.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/8/5 0005 9:54
 */
public class ProxyTest {

    public static void main(String[] args) {
        InvocationHandler invocationHandler = new LearnInvocationHandler(new World());
        Hello hello = (Hello) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Hello.class}, invocationHandler);
        hello.hello("hello");
    }

}
