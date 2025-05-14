package com.kodilla.patterns2.facade.api;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void logBeforeProcessOrder(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println(">>> [LOG] Called method: " + joinPoint.getSignature().getName());

        if (args.length > 0) {
            System.out.println(">>> [LOG] Arguments:");
            for (Object arg : args) {
                System.out.println(">>> [LOG]   - " + arg);
            }
        } else {
            System.out.println(">>> [LOG] No arguments passed.");
        }
    }
}