package com.cbs.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.cbs.base.TestBase;
import com.cbs.pages.Homepage;
import com.cbs.pages.IndividualcustomerPage;
import com.cbs.pages.LoginPage;
import com.cbs.util.TestUtil;

public class IndividualcustomerTestCases extends TestBase
{
	LoginPage loginpage;
	Homepage homepage;
	IndividualcustomerPage individualcustomerPage;
	TestUtil util;

	public IndividualcustomerTestCases()
	{
		super();
	}

	@BeforeTest
	public void setUp() throws Exception
	{
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		Thread.sleep(2000);
		individualcustomerPage = homepage.clickOnCustomerCreationInd();
		Thread.sleep(3000);
	}
	
	/*@Test(priority = 1)
	public void create_Customer_Indv() throws Exception
	{
		individualcustomerPage.createMultipleCustomers();
	}
	
	@Test(priority = 2)
	public void auth_multiple_Customer_Indv() throws Exception
	{
		loginpage = new LoginPage();
		homepage = loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		individualcustomerPage = homepage.clickOnCustomerCreationInd();
		Thread.sleep(2000);
		individualcustomerPage.authMulipleCustomers();
	}*/

//	===================================================
//  1)  Regular Customer
//	===================================================

	@Test(priority = 1)
	public void create_Customer_Indv() throws Exception
	{
		individualcustomerPage.createIndividualCustomer();
	}

	@Test(priority = 2) // Authorized Regular Customer
	public void Authorize_Customer_Indv() throws Exception
	{
		loginpage = new LoginPage();
		homepage = loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		individualcustomerPage = homepage.clickOnCustomerCreationInd();
		individualcustomerPage.authorizedCustomer();
	}

	@Test(priority = 3)
	public void Customer_KYC_Regular() throws Exception
	{
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		Thread.sleep(3000);
		individualcustomerPage.customer_kyc_Details();
		Thread.sleep(2000);
	}

	@Test(priority = 4)
	public void auth_KYC_Regular() throws Exception
	{
		loginpage = new LoginPage();
		homepage = loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		Thread.sleep(2000);
		individualcustomerPage.authCustomerMaitenance();
	}

//	======================================================
//   2) Minor Customer	
//	======================================================

	@Test(priority = 5) // Creation
	public void create_Minor_Cust() throws Exception
	{
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		Thread.sleep(2000);
		individualcustomerPage = homepage.clickOnCustomerCreationInd();
		individualcustomerPage.minor_cust();
	}

	@Test(priority = 6) // Authorized minor Customer
	public void Authorize_minor_cust() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		individualcustomerPage = homepage.clickOnCustomerCreationInd();
		individualcustomerPage.authorized_Minor_Cust();
		Thread.sleep(3000);
	}

	@Test(priority = 7)
	public void Customer_KYC_minor() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		Thread.sleep(3000);
		individualcustomerPage.customer_kyc_Details();
	}

	// Authorized KYC
	@Test(priority = 8)
	public void auth_Customer_KYC_minor() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		Thread.sleep(2000);
		individualcustomerPage.authCustomerMaitenance();
	}

//	====================================================
//   3)  Sr_Citizen
//	====================================================

	@Test(priority = 9)
	public void create_Sr_Citizen() throws Exception
	{
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		Thread.sleep(2000);
		individualcustomerPage = homepage.clickOnCustomerCreationInd();
		individualcustomerPage.Sr_Citizen();
	}

	@Test(priority = 10) // Authorized Sr_Citizen
	public void Authorize_Sr_Citizen() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		individualcustomerPage = homepage.clickOnCustomerCreationInd();
		individualcustomerPage.authorize_Sr_Citizen();
	}

	@Test(priority = 11)
	public void Customer_KYC_Sr_Citizen() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		Thread.sleep(3000);
		individualcustomerPage.customer_kyc_Details();
	}

	// Authorized KYC
	@Test(priority = 12)
	public void auth_Customer_KYC_Sr_Citizen() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		Thread.sleep(2000);
		individualcustomerPage.authCustomerMaitenance();
		Thread.sleep(2000);
	}

//////	====================================================
//////  4)  Staff_Customer_Creation
//////	====================================================

	@Test(priority = 13)
	public void create_Staff_Cust() throws Exception
	{
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		Thread.sleep(2000);
		individualcustomerPage = homepage.clickOnCustomerCreationInd();
		individualcustomerPage.Staff_Cust();
	}

	@Test(priority = 14)
	public void Authorize_Staff_Cust() throws Exception
	{
		loginpage = new LoginPage();
		homepage = loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		individualcustomerPage = homepage.clickOnCustomerCreationInd();
		individualcustomerPage.authorize_Staff_Cust();
	}

	@Test(priority = 15)
	public void Customer_KYC_Staff_Cust() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		Thread.sleep(3000);
		individualcustomerPage.customer_kyc_Details();
	}

	// Authorized KYC
	@Test(priority = 16)
	public void auth_Customer_KYC_Staff_Cust() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		Thread.sleep(2000);
		individualcustomerPage.authCustomerMaitenance();
	}

	@AfterTest
	public void tearDown() {
		System.out.println("Login Successfully");
		// driver.quit();
	}
}
