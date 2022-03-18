package com.topicdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	static Connection con =null;
	 static public Connection getDBconnect(){
		 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanagement","root","root");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
		
		
	}
	
}
