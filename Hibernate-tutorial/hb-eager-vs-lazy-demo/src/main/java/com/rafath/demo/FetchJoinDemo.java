package com.rafath.demo;

import org.hibernate.QueryException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {

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
            // begin the transaction
            System.out.println("Starting the transaction");
            session.beginTransaction();

            //option 2: Hibernate query with HQL

            //get the instructor from db
            int theId=1;

            Query<Instructor> query = session.createQuery("select i from Instructor i "
                                                        + "JOIN FETCH i.courses "
                                                        + "where i.id=:theInstructorId",
                    Instructor.class);

            query.setParameter("theInstructorId",theId);

            Instructor tempInstructor = query.getSingleResult();
            System.out.println("Loading Instructor: "+tempInstructor);

            // commit the transaction
            System.out.println("Committing the changes");
            session.getTransaction().commit();

            //close the session
            session.close();

            System.out.println("The session is closed!\n");
            System.out.println("Courses available: "+tempInstructor.getCourses());

            System.out.println("Done");

        }
        finally {

            //add clean up code
            session.close();

            factory.close();
        }
    }
}

