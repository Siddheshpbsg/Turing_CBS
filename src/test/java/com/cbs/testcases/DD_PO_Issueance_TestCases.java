package com.cbs.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.cbs.base.TestBase;
import com.cbs.pages.DD_PO_Issueance;
import com.cbs.pages.Homepage;
import com.cbs.pages.LoginPage;

public class DD_PO_Issueance_TestCases extends TestBase
{
	LoginPage loginpage;
	Homepage homepage;
	DD_PO_Issueance dd_po_issueance;
	public DD_PO_Issueance_TestCases()
	{
		super();
	}
	
	@BeforeTest
	public void setUp() throws Exception
	{
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin1(properties.getProperty("maker1"),properties.getProperty("maker_password1"));
		dd_po_issueance=homepage.dd_po_issueance();
		Thread.sleep(3000);
	}
	
	
	@Test(priority = 1)
	public void dd_Issue()
	{
		try 
		{
			dd_po_issueance.dd_PO_Stock_Maintanence();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority = 2)
	public void dd_Auth()
	{
		try 
		{
			loginpage=new LoginPage();
			homepage=loginpage.checkerLogin1(properties.getProperty("checker1"),properties.getProperty("checker_password1"));
			dd_po_issueance=homepage.dd_po_issueance();
			Thread.sleep(3000);
			dd_po_issueance.auth_dd_PO_Stock_Maintanence();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void tearDown()
	{
		System.out.println("Siddhesh");
		//driver.quit();
	}

}
