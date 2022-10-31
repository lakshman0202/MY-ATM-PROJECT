package com.ATMbankingTestcasesjunit5;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;

import com.ATMbankingDatabaseConnection.DatabaseServiceLayer;

public class TestingFunctionality {
	static  DatabaseServiceLayer layer;
	@Test
	public void testDepositMethod1() throws SQLException
	{
		double newBalance=DatabaseServiceLayer.deposityourAmount(3000, 1111);
		assertEquals(30000, newBalance);

}@Test
	public void testDepositMethod2() throws SQLException
	{
		double newBalance=DatabaseServiceLayer.deposityourAmount(3000, 1111);
		assertNotEquals(30000, newBalance);

}@Test
	public void teswithdrawMethod1() throws SQLException
	{
		double newBalance=DatabaseServiceLayer.withdrawlyourAmount(3000, 1111);
		assertEquals(30000, newBalance);

}@Test
	public void testwithdrawMethod2() throws SQLException
	{
		double newBalance=DatabaseServiceLayer.withdrawlyourAmount(3000, 1111);
		assertNotEquals(30000, newBalance);



	}@Test
	public void testbalencewMethod1() throws SQLException
	{
		double currentBalance=DatabaseServiceLayer.balanceCheck(3000);
		assertEquals(30000, currentBalance);

}@Test
	public void  balencecheckMethod2() throws SQLException
	{
		double currentBalance=DatabaseServiceLayer.balanceCheck(3000);
		assertNotEquals(30000, currentBalance);


	}@Test
	
	public void testAccountdetailesMethod1() throws SQLException
	{
		ResultSet AccountId=DatabaseServiceLayer.checkAccountDetails(1111);
		assertEquals(1111, AccountId);

}
	@Test
	public void testAccountdetailesMethod2 () throws SQLException
	{
		ResultSet AccountId=DatabaseServiceLayer.checkAccountDetails(3000);
		assertNotEquals(30000,AccountId );
}@Test
	public void testLastTransactionsMethod1() throws SQLException
	{
		ResultSet Transactionid=DatabaseServiceLayer.LastTransactions(3000);
		assertEquals(30000, Transactionid);

}@Test
	public void testLastTransactionsMethod2 () throws SQLException
	{
		ResultSet Transactionid=DatabaseServiceLayer.LastTransactions(3000);
		assertNotEquals(30000, Transactionid);
	
}}
