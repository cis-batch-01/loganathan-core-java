package com.technocis.library.impl;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {
	
	public static Connection getDBconnect(){
		Connection con =null;
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_manager","root","root");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return con;
	}
}
