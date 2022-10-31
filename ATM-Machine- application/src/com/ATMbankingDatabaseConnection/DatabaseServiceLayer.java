package com.ATMbankingDatabaseConnection;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.security.auth.login.AccountNotFoundException;




public class DatabaseServiceLayer {
	
	static Connection connectionobject=DatabaseConnectivity.databaseconnect();
	
	public static double deposityourAmount(double DepositAmount,long accountID)  throws SQLException
	{ if(DepositAmount>0)
	 {
			
			PreparedStatement statement=connectionobject.prepareStatement("select * from accountdetails where Account_id=?");
			statement.setLong(1, accountID);
			ResultSet result=statement.executeQuery();
			result.next();
			
			double availableBalance=result.getDouble(5);
			if(availableBalance>DepositAmount)
			{
				double newBalance=availableBalance - DepositAmount;
				statement=connectionobject.prepareStatement("update accountdetails set totalbalence=? where Account_id=?");
				statement.setDouble(1, newBalance);
				statement.setLong(2, accountID);
				
				statement.executeUpdate();	
				return newBalance;
			
			}
			{
				return 0.0;
			}
		}
		return 0.0;
	}
		
	
			
		
	
		
		
			
	
	public static double withdrawlyourAmount(double amount,long accountID) throws SQLException
	{
		if(amount>0)
		{
			PreparedStatement statement=connectionobject.prepareStatement("select * from accountdetails where Account_id=?");
			statement.setLong(1, accountID);
			ResultSet result=statement.executeQuery();
			result.next();
			
			double availableBalance=result.getDouble(5);
			if(availableBalance>amount)
			{
				double newBalance=availableBalance - amount;
				statement=connectionobject.prepareStatement("update accountdetails set totalbalence=? where Account_id=?");
				statement.setDouble(1, newBalance);
				statement.setLong(2, accountID);
				
				statement.executeUpdate();	
				return newBalance;
			}
			
			{
				return 0.0;
			}
		}
		return 0.0;
	}
	public static double balanceCheck(long accountId) throws SQLException
	{
		PreparedStatement statement=connectionobject.prepareStatement("select * from accountdetails where Account_id=?");
		statement.setLong(1, accountId);
		ResultSet result=statement.executeQuery();
		
		if(result.next())
		{
			return result.getDouble(5); 
			
		}
		else
		{
			 new AccountNotFoundException("Invalid account Id!!");
		}
		return 0.0;
		
		
	}
	public static ResultSet checkAccountDetails(long accountId)  throws SQLException {
		PreparedStatement statement=connectionobject.prepareStatement("select * from accountdetails where Account_id=?");
		statement.setLong(1, accountId);
		ResultSet result=statement.executeQuery();
		
		return result;
	}
	public static ResultSet LastTransactions(long transactionid) throws SQLException
	{    
		PreparedStatement statement=connectionobject.prepareStatement("select * from transactiondetails where transactionid=?");
		statement.setLong(1,transactionid );
		ResultSet result=statement.executeQuery();
		
		return result;
	
	}
	
	
}
	
