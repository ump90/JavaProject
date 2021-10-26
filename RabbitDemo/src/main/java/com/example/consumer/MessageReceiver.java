package com.example.consumer;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author UMP90
 * @date 2021/10/26
 */

public class MessageReceiver {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory=new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setVirtualHost("/");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setPort(5672);
        Connection connection=connectionFactory.newConnection();
        Channel channel= connection.createChannel();
        channel.queueDeclare("newQueue", false, false, false, null);
        channel.basicConsume("newQueue",true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message= new String(body);
                System.out.println(message);
            }
        });


    }
}
