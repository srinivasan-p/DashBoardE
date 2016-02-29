package com.dashboard.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtill {
	public static Connection getDBConnection() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3307/test","root","");
			return conn;
		} catch (Exception e) {
			return null;
		}

	}
}
