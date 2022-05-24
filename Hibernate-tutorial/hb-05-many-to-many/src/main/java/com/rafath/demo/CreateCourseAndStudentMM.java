package com.rafath.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseAndStudentMM {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class)
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

            //save the course
            System.out.println("Saving the course\n");
            session.save(temp);
            System.out.println("Saved the course....\n");

            //create the students
            Student s1=new Student("Akif","Ali","akif@mra.com");
            Student s2=new Student("Alex","Hales","alex@mra.com");
            Student s3=new Student("Sajjad","Ahmed","sajjad@mra.com");
            Student s4=new Student("David","Warner","warner@mra.com");

            //add students to course
            temp.addStudent(s1);
            temp.addStudent(s2);
            temp.addStudent(s3);
            temp.addStudent(s4);

            //save the students
            System.out.println("\nsaving students...\n");
            session.save(s1);
            session.save(s2);
            session.save(s3);
            session.save(s4);
            System.out.println("Saved students: "+temp.getStudents());


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

