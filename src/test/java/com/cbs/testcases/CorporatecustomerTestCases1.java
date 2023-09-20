package com.cbs.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cbs.base.TestBase;
import com.cbs.pages.CorparateCustomerPage;
import com.cbs.pages.Homepage;
import com.cbs.pages.LoginPage;

public class CorporatecustomerTestCases1 extends TestBase
{
	LoginPage loginpage;
	Homepage homepage;
	CorparateCustomerPage corparateCustomerPage;
	
	public CorporatecustomerTestCases1()
	{
		super();
	}
	
	@BeforeTest
	public void setUp() throws Exception
	{
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		corparateCustomerPage=homepage.clickOnCustomerCreationcorp();
		Thread.sleep(5000);
	}
	
	@Test(priority=1)
	public void createCorpCustomer() throws Exception
	{
		corparateCustomerPage.createCorpCustomer();
	}
	
	@AfterTest
	public void tearDown()
	{
		System.out.println("Siddhesh");
		//driver.quit();
	}
	
	/*@Test(priority=2)
	public void authorizeCorpCustomer() throws Exception
	{
		loginpage=new LoginPage();
		Thread.sleep(3000);
		homepage=loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		corparateCustomerPage=homepage.clickOnCustomerCreationcorp();
		corparateCustomerPage.authCorpCustomer();
	}
	
	@Test(priority=3)
	public void corpCustomerKYC() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		Thread.sleep(3000);
		corparateCustomerPage.customer_kyc_Details();
	}
	
	@Test(priority=4)
	public void auth_CustomerKYC() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		corparateCustomerPage.authCustomerMaitenance();
	}
	
	/*@Test(priority=3)
	public void viewCorpCust() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		corparateCustomerPage=homepage.clickOnCustomerCreationcorp();
		corparateCustomerPage.viewCorpCustomer();
	}
	
	@Test(priority=4)
	public void editCorpCustomer() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		corparateCustomerPage=homepage.clickOnCustomerCreationcorp();
		corparateCustomerPage.editCorpCustomer();
	}
	
	@Test(priority=5)
	public void editAuthCorpCustomer() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		corparateCustomerPage=homepage.clickOnCustomerCreationcorp();
		corparateCustomerPage.editAuthcorp();
	}
	
	@Test(priority=6)
	public void viewCorpCust1() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		corparateCustomerPage=homepage.clickOnCustomerCreationcorp();
		corparateCustomerPage.viewCorpCustomer();
	}
	
	/*@Test(priority=7)
	public void corpCustomerKYC() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		corparateCustomerPage.customer_kyc_Details("4578","30-Jul-2022","Customer Kyc");
	}
	
	@Test(priority=8)
	public void auth_CustomerKYC() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		corparateCustomerPage.authCustomerMaitenance();
	}
	
	/*@Test(priority=6)
	public void eidtMigratedCorpCustomerDetails() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		corparateCustomerPage=homepage.clickOnCustomerCreationcorp();
		Thread.sleep(2000);
		corparateCustomerPage.editMigratedCorpCustomer("123654","tenterprise@gmail.com");
	}
	
	@Test(priority=7)
	public void authMigratedCorpCustomerDetails() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		corparateCustomerPage=homepage.clickOnCustomerCreationcorp();
		Thread.sleep(2000);
		corparateCustomerPage.authMigratedCorpCustomer();
	}
	
	@Test(priority=8)
	public void viewMigratedCorpCustomerDetails() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		corparateCustomerPage=homepage.clickOnCustomerCreationcorp();
		Thread.sleep(2000);
		corparateCustomerPage.viewMigratedCorpCustomer();
	}*/
	
}
