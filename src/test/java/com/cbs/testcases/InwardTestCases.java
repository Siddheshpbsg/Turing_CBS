package com.cbs.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cbs.base.TestBase;
import com.cbs.pages.ClearingInwardPage;
import com.cbs.pages.Homepage;
import com.cbs.pages.LoginPage;

public class InwardTestCases extends TestBase
{
	LoginPage loginpage;
	Homepage homepage;
	ClearingInwardPage clearingInwardPage;
	
	public InwardTestCases()
	{
		super();
	}
	
	@BeforeTest
	public void setUp() throws Exception
	{
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin1(properties.getProperty("checker1"),properties.getProperty("checker_password1"));
		clearingInwardPage=homepage.clickOnClearingInward();
		Thread.sleep(3000);
	}
	
	@Test(priority=1)
	public void uploadInwardTransactionFile() throws Exception
	{
		clearingInwardPage.uploadInwardFile();
	}
	
	@AfterTest
	public void tearDown()
	{
		System.out.println("Siddhesh");
	}
}
