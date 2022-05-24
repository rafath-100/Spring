package com.rafath.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        // create session object
        Session session = factory.getCurrentSession();
        try{
            // begin the transaction
            System.out.println("Starting the transaction");
            session.beginTransaction();

            //create a course
            Course temp = new Course("Mario -_-");

            //add some reviews
            temp.addReview(new Review(("Excellent !!")));
            temp.addReview(new Review(("Nice game!")));
            temp.addReview(new Review(("Wow!")));

            //save the course ... and leverage the cascade all
            System.out.println("saving the course");
            System.out.println(temp);
            System.out.println(temp.getReviews());

            session.save(temp);

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


