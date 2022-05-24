package com.rafath.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create session object
        Session session = factory.getCurrentSession();
        try{
            //create objects

            Instructor tempInstructor = new Instructor("Rahul","Gandhi","rahul.gandhi@gmail.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com/gandhi","Golf!");


            //associate the objects
            tempInstructor.setInstructorDetail((tempInstructorDetail));

            // begin the transaction
            System.out.println("Starting the transaction");
            session.beginTransaction();

            //save the instructor
            System.out.println("Saving instructor: "+tempInstructor);
            session.save(tempInstructor);


            // commit the transaction
            System.out.println("Committing the changes");
            session.getTransaction().commit();

            System.out.println("Done");

        }
        finally {

            //add clean up code
            session.close();

            factory.close();
        }
    }
}
