package com.example;

import com.example.DemoConfig;
import com.example.aopDao.AccountDAO;
import com.example.aopDao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {

        //read spring config file
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);

        MembershipDAO theMembershipDAO = context.getBean("membershipDAO",MembershipDAO.class);
        //call the business method
        Account myAccount = new Account();
        myAccount.setName("Rafath Ali");
        myAccount.setLevel("Diamond");
        theAccountDAO.addAccount(myAccount, true);
        theAccountDAO.doWork();

        // call the accountDao getter/setter methods
        theAccountDAO.setName("gold");
        theAccountDAO.setServiceCode("Price: 50,000");

        String name = theAccountDAO.getName();
        String code = theAccountDAO.getServiceCode();

        theMembershipDAO.addAccount();
        theMembershipDAO.goToSleep();

        //close the context
        context.close();
    }
}
