package com.cbs.testcases;

import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.cbs.base.TestBase;
import com.cbs.pages.Homepage;
import com.cbs.pages.LoginPage;
import com.cbs.pages.TDCreationPage;

public class TdCreationTestCases extends TestBase
{
	LoginPage loginpage;
	Homepage homepage;
	TDCreationPage tdCreationPage;
	public TdCreationTestCases()
	{
		super();
	}

	@BeforeTest
	public void setUp() throws Exception
	{
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		tdCreationPage=homepage.clickOnTDCreation();
		Thread.sleep(3000);
	}

	
	////////////////////////////////SANKET////////////////////////////////
	@Test(priority=1)
	public void createNewTDAccount() throws Exception
	{
		//tdCreationPage.createNewTDAccount("12", "200000", "120","11","14","000320111000035","000000","00");
		tdCreationPage.createNewTDAccount();
	}

	@Test(priority=2)
	public void authCreatedNewTDAccount() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		tdCreationPage=homepage.clickOnTDCreation();
		Thread.sleep(2000);
		tdCreationPage.authNewTDAccount();
	}
	
	@Test(priority=3)
	public void createNewRDAccount() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		tdCreationPage=homepage.clickOnTDCreation();
		Thread.sleep(2000);
		tdCreationPage.NewRDAccount();
	}
	
	@Test(priority=4)
	public void authNewRDAccount() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		tdCreationPage=homepage.clickOnTDCreation();
		Thread.sleep(2000);
		tdCreationPage.authNewRDAccount();
	}
	
	@Test(priority=5)
	public void cashRDActivity() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		homepage.clickOnCash();
		Thread.sleep(5000);
		tdCreationPage.RDcashpayin("000000","3");
	}
	
	@Test(priority=6)
	public void authCashRDActivity() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		homepage.clickOnCash();
		Thread.sleep(5000);
		tdCreationPage.authRDcashpayin();
	}
	
	
	@Test(priority=7)
	public void createNewBulkTDAccount() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		homepage.clickOnTDCreation();
		Thread.sleep(5000);
		tdCreationPage.creteBulkTDAccount();
	}

	@Test(priority=8)
	public void authCreatedNewBulkTDAccount() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		tdCreationPage=homepage.clickOnTDCreation();
		Thread.sleep(5000);
		tdCreationPage.authCretedBulkTDAccount();
	}
	
	@Test(priority=9)
	public void bulkTDTransfer() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		homepage.clickOnTransfer();
		Thread.sleep(5000);
		tdCreationPage.bulkTDTransfer();
	}
	
	@Test(priority=10)
	public void authbulkTDTransfer() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		homepage.clickOnTransfer();
		Thread.sleep(5000);
		tdCreationPage.authbulkTDTransfer();
	}
	
	@AfterTest
	public void tearDown()
	{
		System.out.println("After Test");
		//driver.quit();
	}
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@Test(priority=1)
	public void transferTDActivity() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		tdCreationPage=homepage.clickOnTDCreation();
		Thread.sleep(5000);
		tdCreationPage.transferTDPayin("18", "100000", "50");
	}

	@Test(priority=2)
	public void authTransferTDActivity() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		tdCreationPage=homepage.clickOnTDCreation();
		Thread.sleep(5000);
		tdCreationPage.authTransferTDPayin();
	}*/

	
	
	
	
	
	
	
	
	
	

	
	/*@Test(priority=1)
	public void createNewTDAccount() throws Exception
	{
		tdCreationPage.createNewTDAccount("12", "200000", "120","11","14","000320111000035","000000","00");
	}

	@Test(priority=2)
	public void authCreatedNewTDAccount() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		tdCreationPage=homepage.clickOnTDCreation();
		Thread.sleep(2000);
		tdCreationPage.authNewTDAccount();
	}*/

	/*@Test(priority=1)
	public void CreateTDThroughCash() throws Exception
	{
		/*loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		tdCreationPage=homepage.clickOnTDCreation();
		tdCreationPage.tdThroughCash("18","8000","60","13");
	}

	@Test(priority=2)
	public void authCreateTDThroughCash() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		tdCreationPage=homepage.clickOnTDCreation();
		Thread.sleep(2000);
		tdCreationPage.authCashTDAccount();
	}

	

	*/

	/*
	@Test(priority=3)
	public void payinTDThroughTransfer() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		homepage.clickOnTransfer();
		Thread.sleep(5000);
		tdCreationPage.payinThroughTransfer("000000","000220111000012","100000","000000");
	}

	@Test(priority=4)
	public void authPayinTDThroughTransfer() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		homepage.clickOnTransfer();
		Thread.sleep(5000);
		tdCreationPage.authPayinThroughTransfer();
	}/*

	/*@Test(priority=11)
	public void createNewRDAccount() throws Exception
	{
		tdCreationPage.createNewRDAccount("320461", "75000", "12","320285");
		//tdCreationPage.createNewTDAccount("320461", "200000", "12","320310","320291","100420011000587","000000","00");
	}

	@Test(priority=12)
	public void authCreatedNewRDAccount() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		tdCreationPage=homepage.clickOnTDCreation();
		Thread.sleep(5000);
		tdCreationPage.authCreatedNewRDAccount();
		//tdCreationPage.createNewTDAccount("320461", "200000", "12","320310","320291","100420011000587","000000","00");
	}*/

	














/*public class TdCreationTestCases extends TestBase
{
	LoginPage loginpage;
	Homepage homepage;
	TDCreationPage tdCreationPage;
	public TdCreationTestCases()
	{
		super();
	}
	
	@BeforeTest
	public void setUp() throws Exception
	{
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		tdCreationPage=homepage.clickOnTDCreation();
		Thread.sleep(3000);
	}
	
	@Test(priority=1)
	public void createNewTDAccount() throws Exception
	{
		//tdCreationPage.createNewTDAccount("12", "200000", "120","11","14","000320111000035","000000","00");
		tdCreationPage.createNewTDAccount();
	}
	
	@Test(priority=2)
	public void authCreatedNewTDAccount() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		tdCreationPage=homepage.clickOnTDCreation();
		Thread.sleep(2000);
		tdCreationPage.authNewTDAccount();
	}
	
	@Test(priority=1)
	public void createNewTDAccount() throws Exception
	{
		tdCreationPage.createNewTDAccount("12", "200000", "120","11","14","000320111000035","000000","00");
	}
	
	@Test(priority=2)
	public void authCreatedNewTDAccount() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		tdCreationPage=homepage.clickOnTDCreation();
		Thread.sleep(2000);
		tdCreationPage.authNewTDAccount();
	}
	
	@Test(priority=1)
	public void CreateTDThroughCash() throws Exception
	{
		/*loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		tdCreationPage=homepage.clickOnTDCreation();
		tdCreationPage.tdThroughCash("18","8000","60","13");
	}
	
	@Test(priority=2)
	public void authCreateTDThroughCash() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		tdCreationPage=homepage.clickOnTDCreation();
		Thread.sleep(2000);
		tdCreationPage.authCashTDAccount();
	}
	
	@Test(priority=3)
	public void cashTDActivity() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		homepage.clickOnCash();
		Thread.sleep(5000);
		tdCreationPage.TDcashpayin("000000","4");
	}
	
	@Test(priority=4)
	public void authCashTDActivity() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		homepage.clickOnCash();
		Thread.sleep(5000);
		tdCreationPage.authTDcashpayin();
	}
	
	@Test(priority=1)
	public void transferTDActivity() throws Exception
	{
		/*loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		tdCreationPage=homepage.clickOnTDCreation();
		Thread.sleep(5000);
		tdCreationPage.transferTDPayin("18", "100000", "50");
	}
	
	@Test(priority=2)
	public void authTransferTDActivity() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		tdCreationPage=homepage.clickOnTDCreation();
		Thread.sleep(5000);
		tdCreationPage.authTransferTDPayin();
	}
	
	@Test(priority=3)
	public void payinTDThroughTransfer() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		homepage.clickOnTransfer();
		Thread.sleep(5000);
		tdCreationPage.payinThroughTransfer("000000","000220111000012","100000","000000");
	}
	
	@Test(priority=4)
	public void authPayinTDThroughTransfer() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		homepage.clickOnTransfer();
		Thread.sleep(5000);
		tdCreationPage.authPayinThroughTransfer();
	}/*
	
	/*@Test(priority=11)
	public void createNewRDAccount() throws Exception
	{
		tdCreationPage.createNewRDAccount("320461", "75000", "12","320285");
		//tdCreationPage.createNewTDAccount("320461", "200000", "12","320310","320291","100420011000587","000000","00");
	}
	
	@Test(priority=12)
	public void authCreatedNewRDAccount() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		tdCreationPage=homepage.clickOnTDCreation();
		Thread.sleep(5000);
		tdCreationPage.authCreatedNewRDAccount();
		//tdCreationPage.createNewTDAccount("320461", "200000", "12","320310","320291","100420011000587","000000","00");
	}*/
	
	/*@Test(priority=1)
	public void createNewBulkTDAccount() throws Exception
	{
		tdCreationPage.creteBulkTDAccount("12", "200000","50","50000","30","35","50000","15","5","2","100000","000320111000011");
		//tdCreationPage.createNewTDAccount("320461", "200000", "12","320310","320291","100420011000587","000000","00");
	}
	
	@Test(priority=2)
	public void authCreatedNewBulkTDAccount() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		tdCreationPage=homepage.clickOnTDCreation();
		Thread.sleep(5000);
		tdCreationPage.authCretedBulkTDAccount();
	}
	
	@AfterTest
	public void tearDown()
	{
		System.out.println("Siddhesh");
		//driver.quit();
	}
}*/
