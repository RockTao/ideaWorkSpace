package com.example.rabbitmqadvance.produceconfirm.confirmlistener;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * RabbitMQ 消息消费者
 *
 * @author huan.fu
 * @date 2018/10/15 - 10:00
 */
public class RabbitConsumer {

    private static final String QUEUE_NAME = "queue_demo";
    private static final String IP_ADDRESS = "192.168.2.81";
    private static final int PORT = 5672;

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Address[] addresses = new Address[]{new Address(IP_ADDRESS, PORT)};
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setVirtualHost("/");

        try (
                // 注意此时获取连接的方式和生产者略有不同
                Connection connection = connectionFactory.newConnection(addresses)
        ) {
            // 创建信道
            Channel channel = connection.createChannel();
            // 消费端消息限流。
            // 设置客户端最多接收未被ack的消息个数, 只有消息 手动签收  此参数才会生效。
            channel.basicQos(64);
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    System.err.println("接收到消息：" + new String(body, StandardCharsets.UTF_8));
                    System.err.println("deliveryTag:" + envelope.getDeliveryTag());
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            };

            channel.basicConsume(QUEUE_NAME, consumer);
            TimeUnit.SECONDS.sleep(10000000L);
        }
    }
}