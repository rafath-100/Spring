package com.rafath.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session object
        Session session = factory.getCurrentSession();
        try{

            // begin the transaction
            System.out.println("Starting the transaction");
            session.beginTransaction();

            int theId=2;
            InstructorDetail temp=session.get(InstructorDetail.class, theId);
            System.out.println("Instructor Detail: "+temp.getYoutubeChannel());
            System.out.println("Associated instructor: "+temp.getInstructor());


            // commit the transaction
            System.out.println("Committing the changes");
            session.getTransaction().commit();

            System.out.println("Done");

        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {

            session.close();
            factory.close();
        }
    }
}
