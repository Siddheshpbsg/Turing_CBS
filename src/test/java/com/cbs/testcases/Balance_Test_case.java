package com.cbs.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cbs.base.TestBase;
import com.cbs.pages.BalancePage;
import com.cbs.pages.Homepage;
import com.cbs.pages.LoginPage;

public class Balance_Test_case 
{
	public class CASATestCases extends TestBase 
	{
		LoginPage loginpage;
		Homepage homepage;
		
		BalancePage balancePage;

		public CASATestCases() 
		{
			super();
		}
		
		@BeforeTest
		public void setUp() throws Exception 
		{
			initialization();
			loginpage = new LoginPage();
			homepage = loginpage.makerLogin(properties.getProperty("maker"), properties.getProperty("maker_password"));
			balancePage = homepage.clickOnBalance();
			Thread.sleep(3000);
		}
		
		@Test(priority = 1)
		public void Check_balance_saving_Account() throws Exception 
		
		{
//			setUp();
			balancePage.Balance_Check_Saving();
		}
		
		
		@Test(priority = 2)
		public void Check_balance_current_Account() throws Exception 
		{
			setUp();
			balancePage.Balance_Check_Current();
		}
		
		@Test(priority = 3)
		public void Check_balance_loan_Account() throws Exception 
		{
			setUp();
			balancePage.Balance_Check_Loan();
		}

		@AfterTest
		public void tearDown() 
		{
			System.out.println("Balance checked Successfully...");
		}
}
}
