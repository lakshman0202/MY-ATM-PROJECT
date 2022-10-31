package com.ATMbankingDatabaseConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectivity {
	static final String DB_URL="jdbc:mysql://localhost:3306/";
	 static final String DB_USER_NAME="lakshmi narayanan";
	 static final String DB_USER_PASSWORD="lash";
	 static final String DB_NAME="ATM_database";
	 
	 
	public static Connection databaseconnect()
	{
		Connection connectionobject=null;
		
		try
		{
			connectionobject=DriverManager.getConnection(DB_URL+DB_NAME, DB_USER_NAME, DB_USER_PASSWORD);
		
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		
		return connectionobject;
		
	}	
	

}



