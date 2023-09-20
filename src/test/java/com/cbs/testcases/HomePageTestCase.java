package com.cbs.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cbs.base.TestBase;
import com.cbs.pages.Homepage;
import com.cbs.pages.LoginPage;

public class HomePageTestCase extends TestBase
{
	LoginPage loginpage;
	Homepage homepage;
	
	public HomePageTestCase()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("username"),properties.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyhomePageTitle() throws Exception
	{
		homepage=new Homepage();
		Thread.sleep(2000);
		String homePageTitle= driver.getTitle();
		Thread.sleep(2000);
		System.out.println("HomePage: "+homePageTitle);
		Assert.assertEquals(homePageTitle,"BSG CBS");
	}
	
	@Test(priority=2)
	public void clickCustomerCreationInd() throws Exception
	{
		homepage.clickOnCustomerCreationInd();
		Thread.sleep(2000);
		String CustomerCreationTitle= driver.getTitle();
		Thread.sleep(2000);
		System.out.println("CustomerTitle: "+CustomerCreationTitle);
		Assert.assertEquals(CustomerCreationTitle,"BSG CBS - Customer Information");
	}
	
	@Test(priority=3)
	public void clickCustomerCreationcorp() throws Exception
	{
		homepage.clickOnCustomerCreationcorp();
		Thread.sleep(2000);
		String CorpCustomerCreationTitle= driver.getTitle();
		Thread.sleep(2000);
		System.out.println("CorpCustomerTitle: "+CorpCustomerCreationTitle);
		Assert.assertEquals(CorpCustomerCreationTitle,"BSG CBS - Non-Individual Information");
	}
	
	@Test(priority=4)
	public void clickCustomerMaintenance() throws Exception
	{
		homepage.clickOnCustomerMaintenance();
		Thread.sleep(2000);
		String CustomerMaintenanceTitle= driver.getTitle();
		Thread.sleep(2000);
		System.out.println("CustomerMaintenanceTitle: "+CustomerMaintenanceTitle);
		Assert.assertEquals(CustomerMaintenanceTitle,"BSG CBS - Customer Maintenance");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
