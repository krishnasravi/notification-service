
package com.example.notification.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

@Service
public class NotificationService implements MessageListener {

    @KafkaListener(topics = "user-topic", groupId = "notify-group")
    public void listenKafka(String message) {
        System.out.println("Kafka Notification Received: " + message);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        System.out.println("Redis Notification Received: " + message.toString());
    }
}
