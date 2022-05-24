package com.rafath.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

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
            //create objects
//            Instructor tempInstructor = new Instructor("Alex","Hales","alexhales@gmail.com");
//            InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.telusko.com/youtube","Telusko !");

            //Instructor tempInstructor = new Instructor("Jonny","Bairstow","jonnybairstow@gmail.com");
            //InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.englandcricket.com/youtube","Cricket !");

            Instructor tempInstructor = new Instructor("David","Malan","davidmalan@gmail.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com/malan","Volleyball!");


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
            session.close();
        }
    }
}
