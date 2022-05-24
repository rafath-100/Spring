package com.rafath.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {
    public static void main(String[] args) {

        String jdbcUrl="jdbc:mysql://localhost:3306/?user=hbstudent?useSSL=false";
        String user = "hbstudent";
        String password = "Aakifali1@@";

        try{
            System.out.println("connecting to database: "+jdbcUrl);

            Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("Connection Successful..............");
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }
}


//jdbc:mysql://127.0.0.1:3306/?user=hbstudent