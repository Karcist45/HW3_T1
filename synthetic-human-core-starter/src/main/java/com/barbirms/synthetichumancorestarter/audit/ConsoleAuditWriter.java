package com.barbirms.synthetichumancorestarter.audit;

import org.springframework.stereotype.Component;

@Component
public class ConsoleAuditWriter implements AuditWriter {
    @Override
    public void writeAudit(String info) {
        System.out.println(info);
    }
}
