package com.tackit.utils;

import java.sql.Connection;
import java.sql.DriverManager;

import com.google.appengine.api.rdbms.AppEngineDriver;

public class DBManager {

	
	private static String userName;
	private static String password;
	private static String url;

	public static Connection getConnection() {
		Connection con = null;

		
		try {
			DriverManager.registerDriver(new AppEngineDriver());
			con = DriverManager.getConnection("jdbc:google:rdbms://my-cmpe-272:db/tackit");

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		
		return con;
	}
	
	
}
