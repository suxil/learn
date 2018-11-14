package com.learn.service.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/27 0027 18:52
 */
public class QueueUtils {

    public static void executor(QueueCallback action) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername(Config.USER_NAME);
        factory.setPassword(Config.PASSWORD);
        factory.setVirtualHost(Config.VIRTUAL_HOST);
        factory.setHost(Config.HOST);
        factory.setPort(Config.PORT);

        try (
            Connection conn = factory.newConnection();
            Channel channel = conn.createChannel();
        ) {
            if (action != null) {
                action.doQueueCallback(channel);
            }
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
