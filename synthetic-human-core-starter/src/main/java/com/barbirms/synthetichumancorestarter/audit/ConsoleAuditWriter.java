package com.barbirms.synthetichumancorestarter.audit;

public class ConsoleAuditWriter implements AuditWriter {
    @Override
    public void writeAudit(String info) {
        System.out.println(info);
    }
}
