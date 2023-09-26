package com.cbs.testcases;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.cbs.base.TestBase;
import com.cbs.pages.Clearing_Outward;
import com.cbs.pages.Homepage;
import com.cbs.pages.LoginPage;

public class ClearingOutward_TestCases extends TestBase
{
	LoginPage loginpage;
	Homepage homepage;
	Clearing_Outward clearing_Outward;

	public ClearingOutward_TestCases()
	{
		super();
	}

	@BeforeTest
	public void setUp() throws Exception
	{
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		clearing_Outward=homepage.clickonClearingOutward();
		Thread.sleep(1000);
	}

	@Test(priority=1)
	public void postTransactionTestcCase() throws Exception
	{
		clearing_Outward.postTransaction();
	}

	@Test(priority=2)
	public void auth_postTransactionTestcCase() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
		clearing_Outward=homepage.clickonClearingOutward();
		Thread.sleep(1000);
		clearing_Outward.authTransaction();
	}

	@Test(priority=3)
	public void postDateUpdateDBTestcCase() throws Exception
	{
		clearing_Outward.postDateUpdateDB();
	}

	@Test(priority=4)
	public void Tplus0TestcCase() throws Exception
	{
		clearing_Outward.postingTplus0();
	}

	@Test(priority=5)
	public void fundDateUpdateDBTestcCase() throws Exception
	{
		clearing_Outward.fundDateUpdateDB();
	}

	@Test(priority=6)
	public void fundsReleaseTestcCase() throws Exception
	{
		clearing_Outward.fundsRelease();
	}

	@Test(priority=7)
	public void clearingFundedTestcCase() throws Exception
	{
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		clearing_Outward=homepage.clickonClearingOutward();
		Thread.sleep(1000);
		clearing_Outward.clearingFunded();

	}

}
