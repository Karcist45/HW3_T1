package com.barbirms.synthetichumancorestarter.audit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class KafkaAuditWriter implements AuditWriter {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaAuditWriter(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    @Override
    public void writeAudit(String info) {
        kafkaTemplate.send("audit-topic", info);
    }
}
