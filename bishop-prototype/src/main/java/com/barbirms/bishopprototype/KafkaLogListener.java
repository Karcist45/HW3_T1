package com.barbirms.bishopprototype;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class KafkaLogListener {
    @KafkaListener(topics = "audit-topic")
    public void listen(String message) {
        System.out.println("I, KAFKA LISTENER, RECEIVED THIS MESSAGE \n" +
                message);
    }
}
