package com.ATMbankingOperations;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.ATMbankingExceptions.IllegalArgumentException;
import com.ATMbankingUtility.UserInputValidation;
import com.ATMbankingDatabaseConnection.DatabaseConnectivity;
import com.ATMbankingDatabaseConnection.DatabaseServiceLayer;


@SuppressWarnings("unused")
public class ATMoperations {

	private static long transactionid;
	private static boolean status;
	private static boolean True;
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException, SQLException, IllegalArgumentException  {
		Connection connectionobject=DatabaseConnectivity.databaseconnect();
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in)); 
        @SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);

		System.out.println("______________________.:::::::................... welcome to HDFC-ATM.......:::::.......::::.........______________");
		
			
				System.out.println("___________________________welcome to HDFC_______________:_______________");
				System.out.println("........................  ..............................");
				System.out.println("______________________________________________________________________");
				System.out.println("\t\t choose:1 for-Deposit the ammount.....................");  
				System.out.println("\t\t choose:2 for--Withdraw amount from savings...................");
				System.out.println("\t\t choose:3 for-- check you current Balance Amounnt.......................");
				System.out.println("\t\t choose:4 for--Check  your account details..................");
				System.out.println("\t\t choose:5 for-check your Transaction details......................");
				System.out.println("\t\t choose:6 for- deactivate your account......................");
				System.out.println("choose your option_: :");
				System.out.println("=========================================================================");
				int choice=Integer.parseInt(bufferedReader.readLine());
				try {
				switch(choice)
				{
				 case 1:System.out.println("Enter your account id:");
			 			long accountId=Integer.parseInt(bufferedReader.readLine());
					    System.out.println("Enter your deposit amount:");
				 		double depositAmount=Double.parseDouble(bufferedReader.readLine());
				 		double result=DatabaseServiceLayer.deposityourAmount(depositAmount, accountId);
				
				 		if(result>0.0)
				 		 {
				 			System.out.println("deposit is successfull!!");
				 			System.out.println("New Balance is :"+result);
				 		 }
				 		 else
				 		 {
				 			System.out.println("Transaction failed!!");
				 			System.out.println("Insufficient balance!!");
				 		 }
				 		 break;
				 		
				 		
				 		
				 		
				
				
				 case 2:
					 System.out.println("Enter the account id:");
		 			 long accountId1 =Integer.parseInt(bufferedReader.readLine());
				     System.out.println("Enter the withdraw amount:");
				     double withdrawalAmount=Double.parseDouble(bufferedReader.readLine());		
				     double result1=DatabaseServiceLayer.withdrawlyourAmount(withdrawalAmount, accountId1);
			 		 
			 		 if(result1>0.0)
			 		 {
			 			System.out.println("Transaction is successfull!!");
			 			System.out.println("New Balance is :"+result1);
			 		 }
			 		 else
			 		 {
			 			System.out.println("Transaction failed!!");
			 			System.out.println("Insufficient balance!!");
			 		 }
			 		 break;
				 case 3: 
					 System.out.println("Enter the account id:");
					 accountId=Integer.parseInt(bufferedReader.readLine());
					 double availableBalance=DatabaseServiceLayer.balanceCheck(accountId);
					 
					 if(availableBalance>0)
					 {
						 System.out.println("Available Balance is :"+availableBalance);
					 }
					 else
					 {
						 System.out.println("Enter valid account Id!!");
					 }
				 	 break;
				 case 4: 	 
					 System.out.println("Enter the account id:");
					 accountId=Integer.parseInt(bufferedReader.readLine());
					 ResultSet row=DatabaseServiceLayer.checkAccountDetails(accountId);
					 
					 if(row.next())
					 {
						 System.out.println("=========================================================================");
						 System.out.println("Account Information Details:");
						 System.out.println("=========================================================================");
						 System.out.println("Account Id: " +row.getLong(1));
						 System.out.println("Bank Name: " +row.getString(2));
						 System.out.println("Bank branch: " +row.getString(3));
						 System.out.println("Accounttype: " +row.getString(4));
						 System.out.println("TotalBalence " +row.getLong(5));
						 System.out.println("IFSC code: " +row.getString(6));
						 System.out.println("=========================================================================");

					 }else
					 {
						 System.out.println("Enter valid account Id!!");
					 }
					
					 break;
				 case 5: 	 
					 System.out.println("Enter the transaction id:");
					 transactionid=Integer.parseInt(bufferedReader.readLine());
					 ResultSet rows=DatabaseServiceLayer.LastTransactions(transactionid);
					 
					 if(rows.next())
					 {
						 System.out.println("=========================================================================");
						 System.out.println("your Transaction Details here!!:");
						 System.out.println("=========================================================================");
						 System.out.println("Account id : " +rows.getLong(1));
						 System.out.println("TransactionId " +rows.getString(2));
						 System.out.println("transactionAmount: " +rows.getString(3));
						 System.out.println("transactiondate: " +rows.getString(4));
						
					 }else
					 {
						throw new IllegalArgumentException("you are entered wromg transaction id");
					 }
					 
					 break;
				 case 6: System.out.println("Are you sure?");	
		 		 System.out.println("Y -> Yes / N -> No");
		 		 String response=bufferedReader.readLine();
		 		 if(UserInputValidation.checkString(response))
		 		 {
			 		 if(response.equals("y") || response.equals("Y"))
			 		 {
			 			status=True;
			 		 }
		 		 } {
		 			 System.out.println("=========================================================================");
		 			System.out.println("Logged out successfully!!");
		 			System.out.println("Good Bye!!");
		 			 System.out.println("=========================================================================");

		 		 }
		 		 break;
				
		 	
		 default:System.out.println("Wrong choice!!"); 		
		
				}}catch(NumberFormatException e) {
					 System.out.println("your are enter wrong data");
				}catch(SQLException e) {
					 System.out.println("your are enter wrong data");
				}
		}
				
		
	}
	
				
				
		    
		
		
	
				
	

	
				
			
		
			

	

	
