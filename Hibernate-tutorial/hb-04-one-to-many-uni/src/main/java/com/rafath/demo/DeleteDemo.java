package com.rafath.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

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

            //get instructor by id and delete the instructor
            int id=3;
            Instructor tempInstructor=session.get(Instructor.class,id);

            System.out.println("Found instructor: "+tempInstructor);
            //delete the instructor
            if(tempInstructor!=null){
                System.out.println("deleting: "+tempInstructor);
                //associate data("details") will also be deleted due to cascadeType
                session.delete(tempInstructor);
            }
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
