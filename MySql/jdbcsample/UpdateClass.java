package com.jdbcsample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class UpdateClass {
public static void main(String[] args) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcsample","root","root");
		Statement stmt=con.createStatement();  
		int res=stmt.executeUpdate("insert into emp values (2,'mano',35)");
		
		System.out.println(res>0?"value inserted":"value not inserted");	
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
}

}
