package com.example.aopAspect;

import com.example.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

   //add a new advice for @AfterReturning on the findAccounts method

//    @AfterReturning(
//            pointcut = "execution(* com.example.aopDao.*.*(..))",
//            returning = "result")
    @AfterThrowing(
            pointcut = "execution(* com.example.aopDao.*.*(..))",
            throwing = "result"
    )
    public void afterReturningFindAccountsAdvice(
            JoinPoint theJoinPoint, List<Account> result)
    {
        String method = theJoinPoint.getSignature().toString();
        //System.out.println("\n===>>> Executing @AfterReturning on method: "+method);
        System.out.println("\n===>>> Executing @AfterThrowing on method: "+method);

        System.out.print("\n===>>> result is: "+result);
    }
}
