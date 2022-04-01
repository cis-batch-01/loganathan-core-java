package com.technocis.bookauthor.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {

	public static Connection getDBConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://101.53.133.59/technocis_training_db", "cis_user",
					"cis_user");
			System.out.println("Connection Successfull");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
}
