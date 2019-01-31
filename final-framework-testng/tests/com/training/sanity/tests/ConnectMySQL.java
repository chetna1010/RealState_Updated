package com.training.sanity.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class ConnectMySQL {
  @Test
  public void testDB() throws ClassNotFoundException, SQLException {
	  
	  Class.forName("com.mysql.jdbc.Driver");
	  
	  System.out.println("Driver Loaded");
	  
	Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/ramesh", "root", "Sailaja@1234");
	  
	System.out.println("connected to mysql db");
	
	Statement smt = con.createStatement();
	ResultSet rs = smt.executeQuery("select * from seleniumuser");
	
	while(rs.next())
	
	{
		String  firstname = rs.getString("firstname");
		System.out.println("database record is " + firstname);
		String emailaddress = rs.getString("email");
		System.out.println("database record is "+ emailaddress);
	}
  }
}
