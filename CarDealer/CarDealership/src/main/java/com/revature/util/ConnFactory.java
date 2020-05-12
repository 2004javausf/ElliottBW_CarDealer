package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnFactory {
	
	private static ConnFactory cf = new ConnFactory();
	
	private ConnFactory() {
		super();
	}
	
	public static synchronized ConnFactory getInstance() {
		if(cf == null) {
			cf = new ConnFactory();
		}
		return cf;
	}
	
	public Connection getConnection() {
		
		String url = "jdbc:oracle:thin:@java2004usf.c92rutb9wwjb.us-east-2.rds.amazonaws.com:1521:ORCL";
		String username = "ebw";
		String password = "pass";
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
