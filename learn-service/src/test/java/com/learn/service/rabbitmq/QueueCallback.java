package com.learn.service.rabbitmq;

import com.rabbitmq.client.Channel;

import java.io.IOException;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/27 0027 18:48
 */
public interface QueueCallback {

    void doQueueCallback(Channel channel) throws IOException;

}
