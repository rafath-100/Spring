package com.example.aopAspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class LogIntoCloud {

    //defining Aspect in our new class
    @Before("com.example.aopAspect.AopExpressions.forDaoPackageNoGetSet()")
    public void logIntoCloud(){
        System.out.println("\n ===>>> Logging into Cloud ");

    }
}
