package com.cbs.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.cbs.base.TestBase;
import com.cbs.pages.Homepage;
import com.cbs.pages.LoginPage;
import com.cbs.pages.TellerPage;

public class TellerTestCases extends TestBase
{
	LoginPage loginpage;
	Homepage homepage;
	TellerPage Tellerpage;
	
	public TellerTestCases()
	{
		super();
	}
	
	@BeforeTest
	public void setUp() throws Exception
	{
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		Tellerpage=homepage.clickOnTeller();
		Thread.sleep(3000);
	}
	@Test(priority = 1)
	public void vaultTransactions() throws Exception
	{
		Tellerpage.vaultTransactionWithdraw();
	}
	
	@Test(priority = 2)
	public void authvaultTransactions() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		Tellerpage=homepage.clickOnTeller();
		Tellerpage.authvaultTransactionWithdraw();
	}
	
	@Test(priority = 3)
	public void vaultTransactionDeposite() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		Tellerpage=homepage.clickOnTeller();
		Tellerpage.vaultTransactionDeposite();
	}
	
	@Test(priority = 4)
	public void authvaultTransactionDeposite() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		Tellerpage=homepage.clickOnTeller();
		Tellerpage.authvaultTransactionDeposite();
	}
	
	@Test(priority = 5)
	public void authorizevaultTransactionAndExchange() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		Tellerpage=homepage.clickOnTeller();
		Tellerpage.authorizevaultTransactionAndExchange();
	}
	
	@Test(priority = 6)
	public void tellerToTellerTransaction() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		Tellerpage=homepage.clickOnTeller();
		Tellerpage.tellertoTeller();
	}
	
	@AfterTest
	public void tearDown()
	{
		System.out.println("Siddhesh");
		//driver.quit();
	}
}
