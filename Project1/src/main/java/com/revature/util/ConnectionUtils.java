package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	public static Connection getConnection() throws SQLException
	{
		try {
			
			Class.forName("org.postgresql.Driver");
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		String url = System.getenv("URL");
		String username = System.getenv("DB_Username");
		String password = System.getenv("DB_password");
		
		
		
		return DriverManager.getConnection(url, username, password);
	}
	
	//	public static void main(String[] args) throws ClassNotFoundException
		//{
			//try (Connection conn = ConnectionUtils.getConnection()){
				
				//System.out.println("Connection Succcessful");
				
		//	} catch (Exception e) {
				// TODO: handle exception
			//}
		//}
	}



