package com.example.aopAspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    //adding all our related advices for logging

    @Pointcut("execution(* com.example.aopDao.*.*(..))")
    private void forDaoPackage(){}

    //@Before advice

    //@Before("execution(* add*(..))") //can take now any no. of parameters

    //pointcut for getter methods
    @Pointcut("execution(* com.example.aopDao.*.get*(..))")
    private void getter(){}

    //pointcut for setter methods
    @Pointcut("execution(* com.example.aopDao.*.set*(..))")
    private void setter(){}

    //pointcut: including package and excluding getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetSet(){}

    @Before("forDaoPackageNoGetSet()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n =====> @Before advice on addAccount()");
    }

    @Before("forDaoPackageNoGetSet()")
    public void performAnalytics(){
        System.out.println("\n ===>>> performing Analytics");

    }
}
