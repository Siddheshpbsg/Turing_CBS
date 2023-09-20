package com.cbs.testcases;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.cbs.base.TestBase;
import com.cbs.pages.ChequebookPage;
import com.cbs.pages.Homepage;
import com.cbs.pages.LoginPage;

public class ChequebookTestCases extends TestBase
{
	LoginPage loginpage;
	Homepage homepage;
	ChequebookPage chequebookPage;

	public ChequebookTestCases()
	{
		super();
	}

	@BeforeTest
	public void setUp() throws Exception
	{
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin1(properties.getProperty("maker1"),properties.getProperty("maker_password1"));
		chequebookPage=homepage.clickOnChequebook();
		Thread.sleep(1000);
	}

	@Test(priority=1)
	public void SA_Chequebook() throws Exception
	{
		chequebookPage.SA_Chequebook();
	}

	@Test(priority=2)
	public void auth_SA_Chequebook() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin1(properties.getProperty("checker1"),properties.getProperty("checker_password1"));
		chequebookPage=homepage.clickOnChequebook();
		Thread.sleep(1000);
		chequebookPage.auth_SA_Chequebook();
	}

	@Test(priority=3)
	public void CA_Chequebook() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin1(properties.getProperty("maker1"),properties.getProperty("maker_password1"));
		chequebookPage=homepage.clickOnChequebook();
		Thread.sleep(1000);
		chequebookPage.CA_Chequebook();
	}

	@Test(priority=4)
	public void auth_CA_Chequebook() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin1(properties.getProperty("checker1"),properties.getProperty("checker_password1"));
		chequebookPage=homepage.clickOnChequebook();
		Thread.sleep(1000);
		chequebookPage.auth_CA_Chequebook();
	}

	/*@Test(priority=5)
	public void CC_Chequebook() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin1(properties.getProperty("maker1"),properties.getProperty("maker_password1"));
		chequebookPage=homepage.clickOnChequebook();
		Thread.sleep(1000);
		chequebookPage.CC_Chequebook();
	}

	@Test(priority=6)
	public void auth_CC_Chequebook() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin1(properties.getProperty("checker1"),properties.getProperty("checker_password1"));
		chequebookPage=homepage.clickOnChequebook();
		Thread.sleep(1000);
		chequebookPage.auth_CC_Chequebook();

	}*/

	@Test(priority=5)
	public void generate_File() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin1(properties.getProperty("maker1"),properties.getProperty("maker_password1"));
		chequebookPage=homepage.clickOnChequebook();
		Thread.sleep(1000);
		chequebookPage.generate_File();
	}
	
	@Test(priority=6)
	public void chequebook_Maintenance() throws Exception
	{
		chequebookPage.chequebook_Maintenance();
	}
	
	@Test(priority=7)
	public void cancel_Cheque() throws Exception
	{
		chequebookPage.cancel_Cheque();
	}
	
	@Test(priority=8)
	public void auth_cancel_Cheque() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin1(properties.getProperty("checker1"),properties.getProperty("checker_password1"));
		chequebookPage=homepage.clickOnChequebook();
		Thread.sleep(1000);
		chequebookPage.auth_cancel_Cheque();
	}
}
