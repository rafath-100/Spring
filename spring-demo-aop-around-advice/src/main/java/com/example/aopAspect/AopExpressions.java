package com.example.aopAspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.example.aopDao.*.*(..))")
    public void forDaoPackage(){}

    //@Before advice

    //@Before("execution(* add*(..))") //can take now any no. of parameters

    //pointcut for getter methods
    @Pointcut("execution(* com.example.aopDao.*.get*(..))")
    public void getter(){}

    //pointcut for setter methods
    @Pointcut("execution(* com.example.aopDao.*.set*(..))")
    public void setter(){}

    //pointcut: including package and excluding getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetSet(){}
}
