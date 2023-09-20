package com.cbs.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cbs.base.TestBase;
import com.cbs.pages.CustomerMaitenancePage;
import com.cbs.pages.Homepage;
import com.cbs.pages.LoginPage;

public class CustomerMaitenaceTestCases extends TestBase
{
	LoginPage loginPage;
	Homepage homePage;
	CustomerMaitenancePage customerMaitenancePage;
	
	public CustomerMaitenaceTestCases()
	{
		super();
	}
	
	@BeforeTest
	public void setUp() throws Exception
	{
		initialization();
		loginPage=new LoginPage();
		homePage=loginPage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		customerMaitenancePage=homePage.clickOnCustomerMaintenance();
		Thread.sleep(2000);
	}
	
	@Test(priority=1)
	public void customerKYC() throws Exception
	{
		customerMaitenancePage.customerKYC("100048588","1245","30-Jul-2022","Customer Kyc");
	}
	
	/*@Test(priority=2)
	public void customerForm15AA()  throws Exception
	{
		customerMaitenancePage.form15AA("24-Jul-2022","25-Jul-2022","3","500000");
	}*/
	
	@Test(priority=2)
	public void customerMemo() throws Exception
	{
		customerMaitenancePage.customerMomoMaitenance("customer momo","25-Jul-2022","30-Jul-2022");
	}
	
	@Test(priority=3)
	public void customerchannelMobile() throws Exception
	{
		customerMaitenancePage.channelMobile("8476244327");
	}
	
	@Test(priority=4)
	public void customerTaxreturn() throws Exception
	{
		customerMaitenancePage.customerTaxReturn();
	}
	
	@Test(priority=5)
	public void authCustomermaitenance() throws Exception
	{
		loginPage=new LoginPage();
		homePage=loginPage.makerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		customerMaitenancePage=homePage.clickOnCustomerMaintenance();
		Thread.sleep(2000);
		customerMaitenancePage.authCustomerMaitenance();
	}
	
	@Test(priority=6)
	public void editCustomermaitenance() throws Exception
	{
		loginPage=new LoginPage();
		homePage=loginPage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		customerMaitenancePage=homePage.clickOnCustomerMaintenance();
		Thread.sleep(2000);
		customerMaitenancePage.editcustomerkyc("100048592","78452");
	}
	
	@Test(priority=7)
	public void authCustomermaitenance1() throws Exception
	{
		loginPage=new LoginPage();
		homePage=loginPage.makerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		customerMaitenancePage=homePage.clickOnCustomerMaintenance();
		Thread.sleep(2000);
		customerMaitenancePage.authcustomerkyc();
	}
	
	@AfterTest
	public void tearDown()
	{
		System.out.println("Siddhesh");
		//driver.quit();
	}
}
