package com.rafath.CRM.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    //setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    //setup pointcut declaration
    @Pointcut("execution(* com.rafath.CRM.controller.*.*(..))")
    private void forControllerPackage(){}

    //dp for service and dao
    @Pointcut("execution(* com.rafath.CRM.Service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* com.rafath.CRM.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("forControllerPackage() || forServicePAckage() || forDaoPackage()")
    private  void forAppFlow(){}

    //add @Before advice
    @Before("forAppFlow()")
    public  void before(JoinPoint theJoinPoint){

        //display the method
        String theMethod=theJoinPoint.getSignature().toShortString();
        myLogger.info("===>>> in @Before : calling method: "+theMethod);

        //display the arguments to the method
    }


}
