package com.example.aopAspect;

import com.example.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    //Below we have 3 Aspects, and we will be defining Order for them to execute
    @Before("com.example.aopAspect.AopExpressions.forDaoPackageNoGetSet()")
    public void beforeAddAccountAdvice(JoinPoint theJoin){
        System.out.println("\n =====> @Before advice on addAccount()");


        //display the method signature
        MethodSignature methodSig = (MethodSignature) theJoin.getSignature();
        System.out.println("Method: "+methodSig);

        //display the method arguments

        //getargs
        Object[] args= theJoin.getArgs();

        //loop thru args
        for (Object temp: args){
            System.out.println(temp);

            if(temp instanceof Account){

                // downcast and print Account stuff
                Account theAccount = (Account) temp;

                System.out.println("Account name: "+theAccount.getName());
                System.out.println("Account level: "+theAccount.getLevel());
            }
        }
    }
}
