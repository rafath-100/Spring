package com.example.aopAspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    //Below we have 3 Aspects, and we will be defining Order for them to execute
    @Before("com.example.aopAspect.AopExpressions.forDaoPackageNoGetSet()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n =====> @Before advice on addAccount()");
    }

//    @Before("forDaoPackageNoGetSet()")
//    public void performAnalytics(){
//        System.out.println("\n ===>>> performing Analytics");
//
//    }

//    @Before("forDaoPackageNoGetSet()")
//    public void logIntoCloud(){
//        System.out.println("\n ===>>> Logging into Cloud ");
//
//    }
}
