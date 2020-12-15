package io.github.suxil.core.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/8/5 0005 9:55
 */
public class LearnInvocationHandler implements InvocationHandler {

    private Hello hello;

    public LearnInvocationHandler(Hello hello) {
        this.hello = hello;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       // System.out.println(proxy);
        System.out.println(method);
        System.out.println(Arrays.toString(args));
        return method.invoke(hello, args);
    }

}
