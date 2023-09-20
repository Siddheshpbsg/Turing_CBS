package com.cbs.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.cbs.base.TestBase;
import com.cbs.pages.Homepage;
import com.cbs.pages.IndividualcustomerPage;
import com.cbs.pages.LoginPage;
import com.cbs.util.TestUtil;

public class IndividualcustomerTestCases1 extends TestBase
{
/*	LoginPage loginpage;
	Homepage homepage;
	IndividualcustomerPage individualcustomerPage;
	TestUtil util;
	
	public IndividualcustomerTestCases1()
	{
		super();
	}
	
	@BeforeTest
	public void setUp() throws Exception
	{
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		individualcustomerPage=homepage.clickOnCustomerCreationInd();
		Thread.sleep(3000);
	}
	
	@Test(priority=1)
	public void createCustomerIndv() throws Exception
	{
		individualcustomerPage.createIndividualCustomer();
	}
	
	@Test(priority=2)
	public void authorizeCustomerIndv() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		individualcustomerPage=homepage.clickOnCustomerCreationInd();
		individualcustomerPage.authorizedCustomer();
	}
	
	@Test(priority=3)
	public void indvCustomerKYC() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		Thread.sleep(3000);
		individualcustomerPage.customer_kyc_Details();
	}
	
	@Test(priority=4)
	public void auth_CustomerKYC() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		individualcustomerPage.authCustomerMaitenance();
	}
	
	/*@Test(priority=3)
	public void viewIndvCust() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		individualcustomerPage=homepage.clickOnCustomerCreationInd();
		individualcustomerPage.viewIndvCustomer();
	}
	
	@Test(priority=4)
	public void editCustomerIndv() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		individualcustomerPage=homepage.clickOnCustomerCreationInd();
		individualcustomerPage.editIndvCustomer("987545","cust@gmail.com");
	}
	
	@Test(priority=5)
	public void editAuthIndv() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		individualcustomerPage=homepage.clickOnCustomerCreationInd();
		individualcustomerPage.editAuthIndv();
	}
	
	@Test(priority=6)
	public void viewIndvCust1() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		individualcustomerPage=homepage.clickOnCustomerCreationInd();
		individualcustomerPage.viewIndvCustomer();
	}
	
	/*@Test(priority=7)
	public void indvCustomerKYC() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		Thread.sleep(3000);
		individualcustomerPage.customer_kyc_Details();
	}
	
	@Test(priority=8)
	public void auth_CustomerKYC() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		individualcustomerPage.authCustomerMaitenance();
	}*/
	
	
	/*@Test(priority=4)
	public void createMinorCustomerIndv() throws Exception
	{
		individualcustomerPage.createMinorIndvCust();
	}
	
	@Test(priority=5)
	public void authorizeMinorIndvCust() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		individualcustomerPage=homepage.clickOnCustomerCreationInd();
		individualcustomerPage.authorizedminorCustomer();
	}
	
	@Test(priority=6)
	public void createStaffCustomerIndv() throws Exception
	{
		individualcustomerPage.createStaffIndvCust();
	}
	
	@Test(priority=7)
	public void authorizeStaffIndvCust() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		individualcustomerPage=homepage.clickOnCustomerCreationInd();
		individualcustomerPage.authorizedStaffCustomer();
	}
	
	@Test(priority=8)
	public void createSrcitizenCustIndv() throws Exception
	{
		individualcustomerPage.createSrcitizenCust();
	}
	
	@Test(priority=9)
	public void authorizeSrcitizenCustIndv() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		individualcustomerPage=homepage.clickOnCustomerCreationInd();
		individualcustomerPage.authorizedSrcitizenCust();
	}
	
	/*@Test(priority=3)
	public void indvCustomerKYC() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		Thread.sleep(3000);
		individualcustomerPage.customer_kyc_Details();
	}
	
	@Test(priority=4)
	public void auth_CustomerKYC() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		individualcustomerPage.authCustomerMaitenance();
	}
	
	/*@Test(priority=1)
	public void createCustomerIndv() throws Exception
	{
		individualcustomerPage.createIndividualCustomer();
	}
	
	@Test(priority=2)
	public void authorizeCustomerIndv() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		individualcustomerPage=homepage.clickOnCustomerCreationInd();
		individualcustomerPage.authorizedCustomer();
	}
	
	*/
	
	@AfterTest
	public void tearDown()
	{
		System.out.println("Siddhesh");
		//driver.quit();
	}
	
	/*@Test(priority=3)
	public void viewIndvCust() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		individualcustomerPage=homepage.clickOnCustomerCreationInd();
		individualcustomerPage.viewIndvCustomer();
	}
	
	@Test(priority=4)
	public void editCustomerIndv() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		individualcustomerPage=homepage.clickOnCustomerCreationInd();
		individualcustomerPage.editIndvCustomer("987545","cust@gmail.com");
	}
	
	@Test(priority=5)
	public void editAuthIndv() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		individualcustomerPage=homepage.clickOnCustomerCreationInd();
		individualcustomerPage.editAuthIndv();
	}
	
	@Test(priority=6)
	public void viewIndvCust1() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		individualcustomerPage=homepage.clickOnCustomerCreationInd();
		individualcustomerPage.viewIndvCustomer();
	}
	
	@Test(priority=7)
	public void indvCustomerKYC() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		individualcustomerPage.customer_kyc_Details("69845","30-Jul-2022","Customer Kyc");
	}
	
	@Test(priority=8)
	public void auth_CustomerKYC() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		individualcustomerPage.authCustomerMaitenance();
	}
	
	/*@Test(priority=1)
	public void createCustomerIndv() throws Exception
	{
		individualcustomerPage.createindvcustomer("ERFTR7812G","320013044578","krishna","Dilip","Mahajan","Dilip","Vilas","Mahajan",
		"Pooja","Dilip","Mahajan","18-Dec-1987","8903038247","Sri Nagar","Vaishali nagar","Mulund West","786523","10-Dec-2021","TCS",
		"Thane","Navi Mumbai","Thane","Arun","Vikas","Mahajan","01-Jul-2022","75","741258","CITY");
	}
	
	@Test(priority=2)
	public void authorizeCustomerIndv() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		individualcustomerPage=homepage.clickOnCustomerCreationInd();
		individualcustomerPage.authorizedCustomer();
	}
	
	@Test(priority=3)
	public void editCustomerIndv() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		individualcustomerPage=homepage.clickOnCustomerCreationInd();
		individualcustomerPage.editIndvCustomer("987545","krishd@gmail.com");
	}
	
	@Test(priority=4)
	public void editAuthIndv() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		individualcustomerPage=homepage.clickOnCustomerCreationInd();
		individualcustomerPage.editAuthIndv();
	}
	
	@Test(priority=5)
	public void viewIndvCust() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		individualcustomerPage=homepage.clickOnCustomerCreationInd();
		individualcustomerPage.viewIndvCustomer();
	}
	
	@Test(priority=6)
	public void new_CustomerKYC() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		individualcustomerPage.customer_kyc_Details("J8369845","30-Jul-2022","Customer Kyc");
	}
	
	@Test(priority=7)
	public void auth_CustomerKYC() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		individualcustomerPage.authCustomerMaitenance();
	}*/
	
	/*@Test(priority=6)
	public void editMigratedCustomerDetails() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		individualcustomerPage=homepage.clickOnCustomerCreationInd();
		individualcustomerPage.editMigratedCustomer("0247788","goutamcj@gmail.com");
	}
	
	@Test(priority=7)
	public void authMigratedCustomerDetails() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		individualcustomerPage=homepage.clickOnCustomerCreationInd();
		individualcustomerPage.editAuthMigratedCustomer();
	}
	
	@Test(priority=8) 
	public void viewMigratedCustomerDetails() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		individualcustomerPage=homepage.clickOnCustomerCreationInd();
		individualcustomerPage.viewMigratedCustomer();
	}*/
}

