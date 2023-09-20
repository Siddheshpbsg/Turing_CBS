package com.cbs.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cbs.base.TestBase;
import com.cbs.pages.Homepage;
import com.cbs.pages.LoginPage;
import com.cbs.pages.Quicklinks;
import com.cbs.util.TestUtil;

public class Quicklinktestcases extends TestBase
{
	LoginPage loginpage;
	Homepage homepage;
	Quicklinks quicklinks;
	public Quicklinktestcases()
	{
		super();
	}
	
	@BeforeTest
	public void setUp() throws Exception
	{
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		quicklinks=homepage.clickOnQuicklinks();
		Thread.sleep(3000);
	}
	
	@Test(priority=1)
	public void clickonaddLink() throws Exception
	{
		quicklinks.clickonaddlink();
	}
	
	@Test(priority=2)
	public void clickonnewtabLink() throws Exception
	{
		quicklinks.clickonNewTablink();
	}
	
	@Test(priority=3)
	public void clickonGoldLoanAmountCalculatorLink() throws Exception
	{
		quicklinks.clickonGoldLoanAmountCalculatorlink();
	}
	
	@Test(priority=4)
	public void clickonGetAccountClosureAmountLink() throws Exception
	{
		quicklinks.clickonGetAccountClosureAmount();
	}
	
	@Test(priority=5)
	public void clickonGetAccountBalanceLink() throws Exception
	{
		quicklinks.clickonGetAccountBalance();
	}
	
	@Test(priority=6)
	public void clickonGetAccountMappingLink() throws Exception
	{
		quicklinks.clickonGetAccountMapping();
	}
	
	@Test(priority=7)
	public void clickonGetTDInterestCalculatorLink() throws Exception
	{
		quicklinks.clickonTDInterestCalculator();
	}
	
	@Test(priority=8)
	public void clickonGetLoanEMICalculatorLink() throws Exception
	{
		quicklinks.clickonLoanEMICalculator();
	}
	
	@Test(priority=9)
	public void logout() throws Exception
	{
		loginpage.userLogout();
	}
	
	@AfterTest
	public void tearDown()
	{
		//System.out.println("Siddhesh");
		driver.close();
	}
}
