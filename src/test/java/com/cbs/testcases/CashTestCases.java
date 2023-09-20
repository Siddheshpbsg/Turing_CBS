package com.cbs.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cbs.base.TestBase;
import com.cbs.pages.CashPage;
import com.cbs.pages.CashPage1;
import com.cbs.pages.Homepage;
import com.cbs.pages.LoginPage;

public class CashTestCases extends TestBase
{
	
	LoginPage loginpage;
	Homepage homepage;
	CashPage cashPage;

	public CashTestCases()
	{
		super();
	}
	
	@BeforeTest
	public void setUp() throws Exception 
	{
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("maker"), properties.getProperty("maker_password"));
		cashPage = homepage.clickOnCash();
		Thread.sleep(2000);
	}
	
	@Test
	public void multiplecashauth() throws Exception
	{
		cashPage.addmultuiplecredit1();
	}
	
	@AfterTest
	public void tearDown()
	{
		System.out.println("Siddhesh");
		//driver.quit();
	}
}

//======================================CASA credit/Debit/Close ===============================================================

/*	@Test(priority = 1)
	public void cashCredit() throws Exception {
		cashPage.casaCredit();
	}

	@Test(priority = 2)
	public void authorizedcashCredit() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("checker"), properties.getProperty("checker_password"));
		cashPage = homepage.clickOnCash();
		Thread.sleep(4000);
		cashPage.authCasaCredit();
	}

	@Test(priority = 3)
	public void cashDebit() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("maker"), properties.getProperty("maker_password"));
		cashPage = homepage.clickOnCash();
		Thread.sleep(5000);
		cashPage.casaDebit();
	}

	@Test(priority = 4)
	public void authorizedCashDebit() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("checker"), properties.getProperty("checker_password"));
		cashPage = homepage.clickOnCash();
		Thread.sleep(5000);
		cashPage.authCasaDebit();
	}

	@Test(priority = 5)
	public void cashDebitPendingDenom() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("maker"), properties.getProperty("maker_password"));
		cashPage = homepage.clickOnCash();
		Thread.sleep(5000);
		cashPage.casaDebitPendingDenoms();
	}

	@Test(priority = 6)
	public void CasaClose() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("maker"), properties.getProperty("maker_password"));
		cashPage = homepage.clickOnCash();
		Thread.sleep(4000);
		cashPage.casaClose();
	}

	@Test(priority = 7)
	public void authorizedCasaClose() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("checker"), properties.getProperty("checker_password"));
		cashPage = homepage.clickOnCash();
		Thread.sleep(5000);
		cashPage.authClose();
	}

	@Test(priority = 8)
	public void cashClosePendingDenom() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("maker"), properties.getProperty("maker_password"));
		cashPage = homepage.clickOnCash();
		Thread.sleep(5000);
		cashPage.casaClosePendingDenoms();
	}

	// =====TD account Payout/payin/=====================

	@Test(priority = 9)
	public void TDaccountPayINTest() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("maker"), properties.getProperty("maker_password"));
		cashPage = homepage.clickOnCash();
		Thread.sleep(5000);
		cashPage.TDaccountPayIN();
	}

	@Test(priority = 10)
	public void authTDAccountPayINTest() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("checker"), properties.getProperty("checker_password"));
		cashPage = homepage.clickOnCash();
		Thread.sleep(5000);
		cashPage.authTDAccountPayIN();
	}

	@Test(priority = 11)
	public void TDaccountPayoutTest() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("maker"), properties.getProperty("maker_password"));
		cashPage = homepage.clickOnCash();
		Thread.sleep(5000);
		cashPage.TDaccountPayOut();
	}

	@Test(priority = 12)
	public void authTDAccountPayoutTest() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("checker"), properties.getProperty("checker_password"));
		cashPage = homepage.clickOnCash();
		Thread.sleep(5000);
		cashPage.authTDAccountPayout();
	}

	@Test(priority = 13)
	public void TDAccountPayoutPendingDenomsTest() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("maker"), properties.getProperty("maker_password"));
		cashPage = homepage.clickOnCash();
		Thread.sleep(5000);
		cashPage.TDAccountPayoutPendingDenoms();
	}

	// =======================loanACdisb======================================

	@Test(priority = 15)
	public void LaonACDisbursmentTest() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("maker"), properties.getProperty("maker_password"));
		cashPage = homepage.clickOnCash();
		Thread.sleep(5000);
		cashPage.LaonACDisbursment();
	}

	@Test(priority = 16)
	public void authLaonACDisbursmentTest() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("checker"), properties.getProperty("checker_password"));
		cashPage = homepage.clickOnCash();
		Thread.sleep(5000);
		cashPage.authLaonACDisbursment();
	}

	@Test(priority = 17)
	public void LaonACDisbursmentPendingDenomsTest() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("maker"), properties.getProperty("maker_password"));
		cashPage = homepage.clickOnCash();
		Thread.sleep(5000);
		cashPage.LaonACDisbursmentPendingDenoms();
	}

	@Test(priority = 18)
	public void LoanACInstallmentCreditTest() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("maker"), properties.getProperty("maker_password"));
		cashPage = homepage.clickOnCash();
		Thread.sleep(5000);
		cashPage.LoanACInstallmentCredit();
	}

	@Test(priority = 19)
	public void authLoanACInstallmentCreditTest() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("checker"), properties.getProperty("checker_password"));
		cashPage = homepage.clickOnCash();
		Thread.sleep(5000);
		cashPage.authLoanACInstallmentCredit();
	}

	@Test(priority = 21)
	public void LoanACCreditForClosureTest() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("maker"), properties.getProperty("maker_password"));
		cashPage = homepage.clickOnCash();
		Thread.sleep(5000);
		cashPage.LoanACCreditForClosure();
	}

	@Test(priority = 22)
	public void authLoanACCreditForClosureTest() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("checker"), properties.getProperty("checker_password"));
		cashPage = homepage.clickOnCash();
		Thread.sleep(5000);
		cashPage.authLoanACCreditForClosure();
	}

//============================================Internal Product/Account credit debit ====================================	

	@Test(priority = 23)
	public void InternalProductCreditTest() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("maker"), properties.getProperty("maker_password"));
		cashPage = homepage.clickOnCash();
		Thread.sleep(5000);
		cashPage.InternalProductCredit();
	}

	@Test(priority = 24)
	public void authInternalProductCreditTest() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("checker"), properties.getProperty("checker_password"));
		cashPage = homepage.clickOnCash();
		Thread.sleep(5000);
		cashPage.authInternalProductCredit();
	}

	@Test(priority = 26)
	public void InternalProductDebitTest() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("maker"), properties.getProperty("maker_password"));
		cashPage = homepage.clickOnCash();
		Thread.sleep(5000);
		cashPage.InternalProductDebit();
	}

	@Test(priority = 27)
	public void authInternalProductDebitTest() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("checker"), properties.getProperty("checker_password"));
		cashPage = homepage.clickOnCash();
		Thread.sleep(5000);
		cashPage.authInternalProductDebit();
	}

	@Test(priority = 28)
	public void InternalProductDebitPdendingDenomsTest() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("maker"), properties.getProperty("maker_password"));
		cashPage = homepage.clickOnCash();
		Thread.sleep(5000);
		cashPage.InternalProductDebitPdendingDenoms();
	}

	@Test(priority = 30)
	public void InternalACCreditTest() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("maker"), properties.getProperty("maker_password"));
		cashPage = homepage.clickOnCash();
		Thread.sleep(5000);
		cashPage.InternalACCredit();
	}

	@Test(priority = 31)
	public void authInternalACCreditTest() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("checker"), properties.getProperty("checker_password"));
		cashPage = homepage.clickOnCash();
		Thread.sleep(5000);
		cashPage.authInternalACCredit();
	}

	@Test(priority = 32)
	public void InternalACDebitTest() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("maker"), properties.getProperty("maker_password"));
		cashPage = homepage.clickOnCash();
		Thread.sleep(5000);
		cashPage.InternalACDebit();
	}

	@Test(priority = 33)
	public void authInternalACDebitTest() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("checker"), properties.getProperty("checker_password"));
		cashPage = homepage.clickOnCash();
		Thread.sleep(5000);
		cashPage.authInternalACDebit();
	}

	@Test(priority = 34)
	public void InternalACDebitPdendingDenomsTest() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("maker"), properties.getProperty("maker_password"));
		cashPage = homepage.clickOnCash();
		Thread.sleep(5000);
		cashPage.InternalACDebitPdendingDenoms();
	}

	// =================================================================================================================================

//	   @Test(priority = 6) // public void MultipleACCreditTest() throws Exception
//	  {  loginpage = new LoginPage(); // homepage =
//	  loginpage.makerLogin(properties.getProperty("maker"),
//	  properties.getProperty("maker_password")); // cashPage 
//	 homepage.clickOnCash(); // Thread.sleep(3000); //
//	  cashPage.MultipleACCredit(); // }
//	  
//	  
//	  @Test(priority=7) public void authMultipleACCreditTest() throws Exception {
//	  loginpage=new LoginPage();
//	  homepage=loginpage.makerLogin(properties.getProperty("checker"),properties.
//	  getProperty("checker_password")); cashPage=homepage.clickOnCash();
//	  Thread.sleep(5000); cashPage.authMultipleACCredit(); }

	@AfterTest
	public void tearDown() {
		System.out.println("Siddhesh");
		driver.quit();
	}
	
}


/*
LoginPage loginpage;
	Homepage homepage;
	CashPage cashPage;
	
	public CashTestCases()
	{
		super();
	}
	
	@BeforeTest
	public void setUp() throws Exception
	{
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		cashPage=homepage.clickOnCash();
		Thread.sleep(5000);
	}
	
	@Test(priority=1)
	public void cashCredit() throws Exception
	{
		cashPage.casaCredit();
	}
	
	@Test(priority=2)
	public void authorizedcashCredit() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		cashPage=homepage.clickOnCash();
		Thread.sleep(5000);
		cashPage.authCasaCredit();
	}
	
	@Test(priority=3)
	public void cashDebit() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		cashPage=homepage.clickOnCash();
		Thread.sleep(5000);
		cashPage.casaDebit();
	}
	
	@Test(priority=4)
	public void authorizedCashDebit() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		cashPage=homepage.clickOnCash();
		Thread.sleep(5000);
		cashPage.authCasaDebit();
	}
	
	@Test(priority=5)
	public void cashDebitPendingDenom() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		cashPage=homepage.clickOnCash();
		Thread.sleep(5000);
		cashPage.casaDebitPendingDenoms();
	}
	
	@AfterTest
	public void tearDown()
	{
		System.out.println("Siddhesh");
		//driver.quit();
	}

*/