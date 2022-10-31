package com.ATMbankingDatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DatabaseUserChecking {
	public static boolean login(String loginId,String password) throws SQLException
	{
		
		Connection connectionobject=DatabaseConnectivity.databaseconnect();
		PreparedStatement statement=connectionobject.prepareStatement("select * from userdetails where loginId =?");
		statement.setString(1, loginId);
		ResultSet result=statement.executeQuery();
		result.next();
		
		if(result.getString(4).equals(password))
		{
			return true;
		}
		else
		{
			return false;
		}
			
	
}
		
	

}
