package com.rafath.demo;

import com.rafath.demo.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).buildSessionFactory();

        // create session object
        Session session = factory.getCurrentSession();
        try{
            session = factory.getCurrentSession();
            session.beginTransaction();

            int primaryKey=8;

            Student myStudent = session.get(Student.class, primaryKey);

            System.out.println("Student is:" + myStudent);

            session.delete(myStudent);

            session.getTransaction().commit();

            System.out.println("Done");

            // deleting one more(id=7)

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            primaryKey = 7;
//
//            myStudent = session.get(Student.class, primaryKey);
//
//            System.out.println("Student is:" + myStudent);
//
//            session.createQuery("delete from Student where id=7").executeUpdate();
//
//            session.getTransaction().commit();
//
//            System.out.println("Done");


        }
        finally {
            session.close();
        }
    }
}