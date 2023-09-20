package com.cbs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection
{
	static Connection con ;
	public static Connection getconnection ()
	{
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        //con=DriverManager.getConnection("jdbc:sqlserver://10.10.30.111:1437;databaseName=BSGCRM","sa","Turing_2@!2");
			con=DriverManager.getConnection("jdbc:sqlserver://10.10.10.201:1440;databaseName=BSGCRM","sa","Turing_2@!2");
	          	//System.out.println("connection created");
	    } 
		catch (Exception e)
		{
			System.out.println(e);
	    }
	    return con;
	    }
	    
	public static String getMigratedIndividualCustomer() throws SQLException
	{
		String id=null;
	    Connection con =JDBCConnection.getconnection();
	    String q = "select * from BSGACCOUNTING..customer_view where classification_id=2 and account_status_id=1";

	    Statement statement=con.createStatement();
	    ResultSet result = statement.executeQuery(q);
	    while(result.next())
	    {
	        id=result.getString("customer_id");
	        //System.out.println(id);
	    }
	    	return id;
		} 
	  
	public static String getMigratedCorpCustomer() throws SQLException
	{
		String id=null;
	    Connection con =JDBCConnection.getconnection();
	    String q = "select * from BSGACCOUNTING..customer_view where classification_id=1 and account_status_id=1 and customer_id='320268'";

	    Statement statement=con.createStatement();
	    ResultSet result = statement.executeQuery(q);
	    while(result.next())
	    {
	        id=result.getString("customer_id");
	        //System.out.println(id);
	    }
	    	return id;
		} 
	
	public static String getMigratedCurrentAccount() throws SQLException
	{
		String Current_Account=null;
	    Connection con =JDBCConnection.getconnection();
	    String q = "select * from BSGACCOUNTING..customer_view where classification_id=1 and account_status_id=1 and branch_code=1004 and \r\n"
	    		   + "account_id='428140'";

	    Statement statement=con.createStatement();
	    ResultSet result = statement.executeQuery(q);
	    while(result.next())
	    {
	    	Current_Account=result.getString("account_no");
	        System.out.println(Current_Account);
	    }
	    	return Current_Account;
		} 
	
	public static String getMigratedSavingAccount() throws SQLException
	{
		String Saving_Account=null;
	    Connection con =JDBCConnection.getconnection();
	    String q = "select * from BSGACCOUNTING..customer_view where classification_id=2 and account_status_id=1 and branch_code=1004 and \r\n"
	    		+ "account_id='428453'";

	    Statement statement=con.createStatement();
	    ResultSet result = statement.executeQuery(q);
	    while(result.next())
	    {
	    	Saving_Account=result.getString("account_no");
	        System.out.println(Saving_Account);
	    }
	    	return Saving_Account;
		} 
	
	       
	    public static void main(String[] args) throws Exception
	    {
	    	getconnection();
	    	getMigratedIndividualCustomer();
	    	getMigratedCorpCustomer();
		}   
}

/* String name=result.getString(2);
String email=result.getString(3);
String city =result.getString(4);
String mobile=result.getString(5);
String password=result.getString(6);
System.out.println("id =>"+id+" "+"name =>"+name+" "+"email =>"+email+" "+"city =>"+city+" "+"mobiel =>"+mobile+" "+"password =>"+password);*/





