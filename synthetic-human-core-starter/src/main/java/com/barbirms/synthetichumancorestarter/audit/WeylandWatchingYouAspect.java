package com.barbirms.synthetichumancorestarter.audit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class WeylandWatchingYouAspect {
    @Autowired
    AuditWriter auditWriter;

    @Around("@annotation(WeylandWatchingYou)")
    public Object weylandWatchingYou(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        Object result = joinPoint.proceed();
        auditWriter.writeAudit("---------------METHOD-------------" +
                "\nNAME: " + methodName  +
                "\nARGS: " + Arrays.toString(args) +
                "\nRESULT: " + result.toString() +
                "\n----------------------------------");
        return result;
    }
}
