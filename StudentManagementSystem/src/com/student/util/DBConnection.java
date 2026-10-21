package com.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection getConnection()throws SQLException {
		String url = "jdbc:mysql://localhost:3306/student_management";
		String user="root";
		String password="Sreedhar@123";
	Connection con = DriverManager.getConnection(url,user,password);
   
   
   
    
    
    return con;
  }

}
