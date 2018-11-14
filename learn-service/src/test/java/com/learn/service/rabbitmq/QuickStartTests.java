package com.learn.service.rabbitmq;

import com.rabbitmq.client.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/27 0027 17:57
 */
public class QuickStartTests {

    private static final Logger log = LoggerFactory.getLogger(QuickStartTests.class);

    @Test
    public void testPublish() throws IOException, TimeoutException {
       QueueUtils.executor((channel) -> {

           String queueName = "learn";
           String routingKey = "learn-*";

           String exchangeName = "learn-1";
           channel.exchangeDeclare(exchangeName, ExchangeTypes.DIRECT, true);
           channel.queueDeclare(queueName, true, false, false, null);
           channel.queueBind(queueName, exchangeName, routingKey);



           byte[] messageBodyBytes = "Hello, world!".getBytes();
//           channel.basicPublish(exchangeName, routingKey, null, messageBodyBytes);
           channel.basicPublish(exchangeName, routingKey, MessageProperties.PERSISTENT_TEXT_PLAIN, messageBodyBytes);

       });
    }

    @Test
    public void testConsume() {
        QueueUtils.executor((channel -> {

            String queueName = "learn";
//            String exchangeName = "learn-1";
//            String routingKey = "learn-*";

            boolean autoAck = true;

            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope,
                                           AMQP.BasicProperties properties, byte[] body)
                        throws IOException {
                    log.info("consume consumerTag: " + consumerTag);

                    String routingKey = envelope.getRoutingKey();
                    log.info("consume routingKey: " + routingKey);
                    String contentType = properties.getContentType();
                    log.info("consume contentType: " + contentType);
                    long deliveryTag = envelope.getDeliveryTag();
                    log.info("consume deliveryTag: " + deliveryTag);

                    String message = new String(body, "UTF-8");
                    System.out.println(" [x] Received '" + message + "'");
                }
            };
            channel.basicConsume(queueName, autoAck, consumer);

        }));
    }

}
