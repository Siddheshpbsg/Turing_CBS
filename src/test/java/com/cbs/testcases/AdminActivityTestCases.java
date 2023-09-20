package com.cbs.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cbs.base.TestBase;
import com.cbs.pages.AdminActivity;
import com.cbs.pages.Homepage;
import com.cbs.pages.LoginPage;

public class AdminActivityTestCases extends TestBase
{
	LoginPage loginpage;
	Homepage homepage;
	AdminActivity adminActivity;
	
	public AdminActivityTestCases()
	{
		super();
	}
	
	@BeforeTest
	public void setUp() throws Exception
	{
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin1(properties.getProperty("maker1"),properties.getProperty("maker_password1"));
		adminActivity=homepage.adminActivity();
		Thread.sleep(3000);
	}
	
	@Test(priority=1)
	public void userCreation() throws Exception
	{
		adminActivity.userCreation();
	}
	
	@Test(priority=2)
	public void userAuthorization() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin1(properties.getProperty("checker1"),properties.getProperty("checker_password1"));
		adminActivity=homepage.adminActivity();
		Thread.sleep(2000);
		adminActivity.userAuthorization();
	}
	
	@AfterTest
	public void tearDown()
	{
		System.out.println("Siddhesh");
	}
}
