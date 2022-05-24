package com.example.aopAspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class PerformAnalytics {

    @Before("com.example.aopAspect.AopExpressions.forDaoPackageNoGetSet()")
    public void performAnalytics(){
        System.out.println("\n ===>>> performing Analytics");

    }
}
