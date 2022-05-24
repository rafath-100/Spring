package com.rafath.demo;

import com.rafath.demo.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
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

            int sixth = 6;
            int seventh =7;
            int ninth=9;

            Student sixthStudent = session.get(Student.class, sixth);
            Student seventhStudent = session.get(Student.class,seventh);
            Student ninthStudent = session.get(Student.class,ninth);

            System.out.println("Student is:" + sixthStudent);
            System.out.print("Student is: "+seventhStudent);


            sixthStudent.setFirstName("Alex");
            sixthStudent.setEmail("alexhales@gmail.com");
            sixthStudent.setLastName("Hales");

            seventhStudent.setFirstName("Chris");
            seventhStudent.setLastName("Gayle");
            seventhStudent.setEmail("chrisgayle@mra.com");

            ninthStudent.setId(8);


            session.getTransaction().commit();

            System.out.println("Done");


            // start a new transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            session.createQuery("UPDATE Student SET email=REPLACE(email, SUBSTRING(email,INSTR(email,'@')+1),\n" +
                    "'yahoo.com')").executeUpdate();


            session.getTransaction().commit();


            System.out.println("Done");

        }
        finally {
            session.close();
        }
    }
}