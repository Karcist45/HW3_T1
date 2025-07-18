package com.barbirms.synthetichumancorestarter.audit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaAuditWriter implements AuditWriter {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void writeAudit(String info) {
        kafkaTemplate.send("audit", info);
    }
}
