package com.rafath.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCoursesDemo {

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

            //get the instructor from db
            int theId=1;
            Instructor tempInstructor = session.get(Instructor.class,theId);

            //for deleting a course:
            //int newID=10;
            //Course tempCourse = session.get(Course.class,newID);

            //delete course
            //System.out.println("deleteing: "+tempCourse);


            System.out.println("Instructor: "+tempInstructor);

            //get course for the instructor
            System.out.println("Courses: "+tempInstructor.getCourses());

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

