package com.cbs.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cbs.base.TestBase;
import com.cbs.pages.Homepage;
import com.cbs.pages.LoanCreationPage;
import com.cbs.pages.LoginPage;

public class LoanTestCases extends TestBase
{
	LoginPage loginpage;
	Homepage homepage;
	LoanCreationPage loanCreationPage;
	public LoanTestCases()
	{
		super();
	}
	
	@BeforeTest
	public void setUp() throws Exception
	{
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		loanCreationPage=homepage.clickOnLoanCreation();
		Thread.sleep(3000);
	}
	
	@Test(priority=1)
	public void createNewLoanAccount() throws Exception
	{
		loanCreationPage.newLoanAccount();
	}
	
	@Test(priority=2)
	public void authLoanAccount() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		loanCreationPage=homepage.clickOnLoanCreation();
		Thread.sleep(3000);
		loanCreationPage.authNewLoanAccount();
	}
	
	@Test(priority=3)
	public void loanAccountDisburtment() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		Thread.sleep(3000);
		loanCreationPage.loanAccountDisburst();
	}
	
	@Test(priority=4)
	public void authLoanAccountDisburtment() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		Thread.sleep(3000);
		loanCreationPage.authloanAccountDisburst();
	}
	
	@Test(priority=5)
	public void createNewGoldLoanAccount() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		loanCreationPage=homepage.clickOnLoanCreation();
		Thread.sleep(3000);
		loanCreationPage.goldLoanAccount();
	}
	
	@Test(priority=6)
	public void authGoldLoanAccount() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		loanCreationPage=homepage.clickOnLoanCreation();
		Thread.sleep(3000);
		loanCreationPage.authNewLoanGoldAccount();
	}
	
	@Test(priority=7)
	public void loanGoldAccountDisburtment() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		Thread.sleep(3000);
		loanCreationPage.goldLoanAccountDisburst();
	}
	
	@Test(priority=8)
	public void authGoldAccountDisburtment() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		Thread.sleep(3000);
		loanCreationPage.authGoldAccountDisburst();
	}
	
	@Test(priority=9)
	public void createLoanAgainstFDAccount() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		Thread.sleep(3000);
		loanCreationPage.newLoanagainstFD();
	}
	
	@Test(priority=10)
	public void authLoanAgainstFD() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		loanCreationPage=homepage.clickOnLoanCreation();
		Thread.sleep(3000);
		loanCreationPage.authLoanAgainstFD();
	}
	
	@AfterTest
	public void tearDown()
	{
		System.out.println("Siddhesh");
		//driver.quit();
	}
}
