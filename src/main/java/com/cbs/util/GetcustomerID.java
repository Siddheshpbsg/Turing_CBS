package com.cbs.util;

public class GetcustomerID 
{
	public static void getdata() throws Exception
	{
		String cust_id=JDBCConnection.getMigratedIndividualCustomer();
		System.out.println("New customer_id"+cust_id);
	}
	public static void main(String[] args) throws Exception 
	{
		getdata();
	}

}
