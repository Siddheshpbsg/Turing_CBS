package com.cbs.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cbs.base.TestBase;
import com.cbs.pages.CASACreationPage;
import com.cbs.pages.CorparateCustomerPage;
import com.cbs.pages.Homepage;
import com.cbs.pages.LoginPage;
import com.cbs.util.TestUtil;

public class CASATestCases extends TestBase 
{
	LoginPage loginpage;
	Homepage homepage;
	CASACreationPage casaCreationPage;

	public CASATestCases() 
	{
		super();
	}

//	===========================================================================

	@BeforeTest
	public void setUp() throws Exception 
	{
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("maker"), properties.getProperty("maker_password"));
		casaCreationPage = homepage.clickOnCASACreation();
		Thread.sleep(3000);
	}
	
// ==============================================================================================

// Current Account 	(NON- INDIVIDUAL)

// ==============================================================================================

	@Test(priority = 1)
	public void newCurrentAccount() throws Exception 
	{
//		setUp();
		casaCreationPage.currentAccountCreation();
		System.out.println("Current account created Successfully for Non-Individual");
	}

	@Test(priority = 2)
	public void authCurrentAccount() throws Exception 
	{
		Checkerlogin();
		Thread.sleep(2000);
		casaCreationPage.authorizedCurrentAccount();
		System.out.println("Current account Authorised Successfully for Non-Individual");
		driver.quit();
	}

// ==============================================================================================

// Saving Account (Regular)

// ==============================================================================================

	@Test(priority = 3)
	public void newSavingAccountDetails() throws Exception 
	{
		setUp();
		casaCreationPage.savingAccountCreation();
		System.out.println("Saving account created Successfully for Regular Customer");
	}

	@Test(priority = 4)
	public void authNewSavingAccountDeatils() throws Exception 
	{
		Checkerlogin();
		Thread.sleep(3000);
		casaCreationPage.authSavingAccountCreation();
		System.out.println("Saving account Authorised Successfully for Regular Customer");
		driver.quit();
	}

// ==============================================================================================

// Saving Account (Minor)

// ==============================================================================================

	@Test(priority = 5)
	public void SavingAccount_Minor() throws Exception 
	{
		setUp();
		casaCreationPage.savingAccountCreation_Minor();
		System.out.println("Saving account created Successfully for Minor Customer");
	}

	@Test(priority = 6)
	public void auth_SavingAccount_Minor() throws Exception 
	{
		Checkerlogin();
		Thread.sleep(3000);
		casaCreationPage.Auth__Saving_Account_minor();
		System.out.println("Saving account Authorised Successfully for Minor Customer");
		driver.quit();
	}

//	===========================================================================

// Saving Account (Sr_Citizen)

//	===========================================================================

	@Test(priority = 7)
	public void Saving_Account_sr_Citizen() throws Exception
	{
		setUp();
		casaCreationPage.saving_Account_sr_Citizen();
		System.out.println("Saving account created Successfully for sr_Citizen");
	}

	@Test(priority = 8)
	public void Auth_Saving_Account_sr_Citizen() throws Exception
	{
		Checkerlogin();
		Thread.sleep(3000);
		casaCreationPage.auth_Saving_Account_sr_Citizen();
		System.out.println("Saving account Authorised Successfully for sr_Citizen");
		driver.quit();
	}
	
//	===========================================================================
	
//	===========================================================================

	
	@AfterTest
	public void tearDown() {
		System.out.println("Casa Created Successfully...");
	}
	
//	===========================================================================

//	LOGIN (MAKER/CHECKER)
	
//	===========================================================================
	public void makerlogin() throws Exception 
	{
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("maker"), properties.getProperty("maker_password"));
		Thread.sleep(3000);
	}

	public void Checkerlogin() throws Exception
	{
		loginpage = new LoginPage();
		homepage = loginpage.checkerLogin(properties.getProperty("checker"),
				properties.getProperty("checker_password"));
		Thread.sleep(2000);
		casaCreationPage = homepage.clickOnCASACreation();
	}
	
}



/*	LoginPage loginpage;
	Homepage homepage;
	CASACreationPage casaCreationPage;
	
	public CASATestCases()
	{
		super();
	}
	
	@BeforeTest
	public void setUp() throws Exception
	{
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		casaCreationPage=homepage.clickOnCASACreation();
		Thread.sleep(3000);
	}
	
	@Test(priority=1)
	public void newCurrentAccount() throws Exception
	{
		casaCreationPage.currentAccountCreation();
	}
	
	@Test(priority=2)
	public void authCurrentAccount() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		casaCreationPage=homepage.clickOnCASACreation();
		Thread.sleep(2000);
		casaCreationPage.authorizedCurrentAccount();
	}
	
	/*@Test(priority=3)
	public void newSavingAccountDetails() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		casaCreationPage=homepage.clickOnCASACreation();
		Thread.sleep(3000);
		casaCreationPage.savingAccountCreation();
	}
	
	@Test(priority=4)
	public void authNewSavingAccountDeatils() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		casaCreationPage=homepage.clickOnCASACreation();
		Thread.sleep(3000);
		casaCreationPage.authSavingAccountCreation();
	}
	
	/*@Test(priority=3)
	public void viewNewSavingAccountDeatils() throws Exception
	{
		loginpage=new LoginPage();
		driver.navigate().refresh();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		casaCreationPage=homepage.clickOnCASACreation();
		Thread.sleep(3000);
		casaCreationPage.viewSavingAccount();
	}
	
	@AfterTest
	public void tearDown()
	{
		System.out.println("Siddhesh");
	}
	
	/*@Test(priority=1)
	public void newCurrentAccount() throws Exception
	{
		casaCreationPage.currentAccountCreation();
	}
	@Test(priority=2)
	public void authCurrentAccount() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		casaCreationPage=homepage.clickOnCASACreation();
		Thread.sleep(2000);
		casaCreationPage.authorizedCurrentAccount();
	}
	
	@Test(priority=3)
	public void viewNewCurrentAccount() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		casaCreationPage=homepage.clickOnCASACreation();
		Thread.sleep(2000);
		casaCreationPage.viewCurrentAccountDetails();
	}*/
	
	
	
	
	/*@DataProvider (name = "data-provider")
    public Object[][] dpMethod()
	{
		return new Object[][] {{"320367","320459","320457","40","Current Account"}};
    }*/
	
	/*@Test(priority=3)
	public void editNewCurrentAccount() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		casaCreationPage=homepage.clickOnCASACreation();
		Thread.sleep(2000);
		casaCreationPage.editCurrentAccount("10");
	}
	
	@Test(priority=4)
	public void authNewCurrentAccount() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		casaCreationPage=homepage.clickOnCASACreation();
		Thread.sleep(2000);
		casaCreationPage.authCurrentAccount();
	}
	
	@Test(priority=5)
	public void viewNewCurrentAccount() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		casaCreationPage=homepage.clickOnCASACreation();
		Thread.sleep(2000);
		casaCreationPage.viewCurrentAccountDetails();
	}
	
	/*@Test(priority=1)
	public void editMigratedCurrAccount() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		casaCreationPage=homepage.clickonCASACreation();
		Thread.sleep(2000);
		casaCreationPage.editMigratedCurrentAccount("320457");
	}
	
	@Test(priority=2)
	public void authMigratedCurrAccount() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		casaCreationPage=homepage.clickOnCASACreation();
		Thread.sleep(2000);
		casaCreationPage.authMigratedCurrentAccount();
	}*/
	
	/*@Test(priority=6)
	public void newSavingAccountDetails() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		casaCreationPage=homepage.clickOnCASACreation();
		Thread.sleep(3000);
		casaCreationPage.savingAccountCreation("12","14","40");
	}
	
	@Test(priority=7)
	public void authNewSavingAccountDeatils() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		casaCreationPage=homepage.clickOnCASACreation();
		Thread.sleep(3000);
		casaCreationPage.authSavingAccountCreation();
	}
	
	@Test(priority=8)
	public void editNewSavingAccountDetails() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		casaCreationPage=homepage.clickOnCASACreation();
		Thread.sleep(3000);
		casaCreationPage.editSavingAccount("25.00");
	}
	
	@Test(priority=9)
	public void authEditedNewSavingAccountDeatils() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		casaCreationPage=homepage.clickOnCASACreation();
		Thread.sleep(3000);
		casaCreationPage.autheditedSavingAccount();
	}
	
	@Test(priority=10)
	public void viewNewSavingAccountDeatils() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		casaCreationPage=homepage.clickOnCASACreation();
		Thread.sleep(3000);
		casaCreationPage.viewSavingAccount();
	}
	
	/*@Test(priority=13)
	public void editMigratedSavingAccountDeatils() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		casaCreationPage=homepage.clickOnCASACreation();
		Thread.sleep(2000);
		casaCreationPage.editMigratedSavingAccount();
	}
	
	@Test(priority=14)
	public void authMigratedSavingAccountDeatils() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		casaCreationPage=homepage.clickOnCASACreation();
		Thread.sleep(2000);
		casaCreationPage.authMigratedSavingAccount();
	}
	
	@Test(priority=15)
	public void viewMigratedSavingAccountDeatils() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		casaCreationPage=homepage.clickOnCASACreation();
		Thread.sleep(2000);
		casaCreationPage.viewMigratedSavingAccount();
	}*/
	

