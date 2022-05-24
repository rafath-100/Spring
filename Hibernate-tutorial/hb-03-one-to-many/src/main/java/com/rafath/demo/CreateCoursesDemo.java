package com.rafath.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {

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

            //create some courses
            Course tempCourse1 = new Course("Air Guitar - The Final Guide");
            Course tempCourse2 = new Course("The Pinball Masterclass");


            //add courses to instructor
            tempInstructor.add(tempCourse1);
            tempInstructor.add(tempCourse2);

            //save the courses
            session.save(tempCourse1);
            session.save(tempCourse2);

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

