package com.project.employeepayroll.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class GeneralAspect {

    @Before(value = "execution(* com.project.employeepayroll.controller.*.*(..))")
    public void before(JoinPoint joinPoint) {
        log.info("Before method invoked : " + joinPoint.getSignature());
    }

    @After(value = "execution(* com.project.employeepayroll.controller.*.*(..))")
    public void after(JoinPoint joinPoint) {
        log.info("After method invoked : " + joinPoint.getSignature());
    }

}
