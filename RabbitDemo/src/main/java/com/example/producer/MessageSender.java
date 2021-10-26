package com.example.producer;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * @author UMP90
 * @date 2021/10/26
 */

public class MessageSender {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setPort(5672);
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setVirtualHost("/");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        String message = "Hello Rabbitmq";
        channel.queueDeclare("newQueue", false, false, false, null);
        channel.basicPublish("", "newQueue", null, "HelloWorld".getBytes(StandardCharsets.UTF_8));
        System.out.println("Send message successfully");
        channel.close();
        connection.close();

    }
}
