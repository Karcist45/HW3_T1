package com.barbirms.synthetichumancorestarter;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "synthetic-human-core-starter")
public class StarterProperties {
    private String auditWriterType = "CONSOLE";

    public String getAuditWriterType() {
        return auditWriterType;
    }

    public void setAuditWriterType(String serviceType) {
        this.auditWriterType = serviceType;
    }
}