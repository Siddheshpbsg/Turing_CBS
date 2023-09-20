package com.cbs.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cbs.base.TestBase;
import com.cbs.pages.Homepage;
import com.cbs.pages.LoginPage;
import com.cbs.pages.TransferPage;

public class TransferTestCases extends TestBase
{
	LoginPage loginpage;
	Homepage homepage;
	TransferPage transferPage;
	
	public TransferTestCases()
	{
		super();
	}
	
	@BeforeTest
	public void setUp() throws Exception
	{
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		transferPage=homepage.clickOnTransfer();
		Thread.sleep(3000);
	}
	
	@Test(priority=1)
	public void tranfer() throws Exception
	{
		transferPage.multipleTransfer();
	}
	
	@Test(priority=2)
	public void authTranfer() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		transferPage=homepage.clickOnTransfer();
		Thread.sleep(3000);
		transferPage.authMultipleTransfer();
	}
	
	@AfterTest
	public void tearDown()
	{
		System.out.println("Siddhesh");
	}
}
