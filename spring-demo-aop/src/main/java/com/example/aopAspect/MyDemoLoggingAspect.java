package com.example.aopAspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    //adding all our related advices for logging

    //@Before advice

    //@Before("execution(* add*(..))") //can take now any no. of parameters

    @Before("execution(* com.example.aopDao.*.*(..))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n =====> @Before advice on addAccount()");
    }
}
