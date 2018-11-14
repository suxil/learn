package com.learn.core.proxy;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/8/5 0005 10:18
 */
public class Message implements Hello {
    @Override
    public void hello(String message) {
        System.out.println(message + ".");
    }
}
