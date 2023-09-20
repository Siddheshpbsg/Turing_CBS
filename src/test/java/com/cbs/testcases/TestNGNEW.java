package com.cbs.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGNEW
{
	@BeforeClass
	public void setUP()
	{
		System.out.println("Launch browser");
	}
	
	@Test(priority=1)
	public void login()
	{
		System.out.println("Login");
	}
	
	@Test(priority=2)
	public void crm()
	{
		System.out.println("Create customer");
	}
	
	@AfterClass
	public void tearDown()
	{
		System.out.println("Logout");
	}
	
}
