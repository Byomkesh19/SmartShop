package com.cognizant.smartshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class ConnectionHandler {
	public static Connection getConnection() throws Exception
	{
		 
			ResourceBundle bundle = ResourceBundle.getBundle("connection");
			String myDriver = bundle.getString("driver");
			String url = bundle.getString("url");
			String user = bundle.getString("user");
			String password = bundle.getString("password");
			Class.forName(myDriver);
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
	}
}
