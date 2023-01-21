package com.masai.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
 public static Connection provideConnection() {
	 Connection conn =null;
	 
	 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	 
	 String url = "jdbc:mysql://localhost:3306/onlinebankingsystem";
	 
	 try {
		conn = DriverManager.getConnection(url,"root","Tuesday@1384");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return conn;
	
}
}
