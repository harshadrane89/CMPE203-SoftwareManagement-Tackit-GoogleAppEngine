package com.tackit.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {

	
	private static String userName;
	private static String password;
	private static String url;

	public static Connection getConnection() {
		Connection conn = null;
		try {
			userName = "root";
			password = "root";
			url = "jdbc:mysql://localhost:3306/tackit";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, userName, password);
			System.out.println(conn.isClosed());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		return conn;
	}
	
	
}
