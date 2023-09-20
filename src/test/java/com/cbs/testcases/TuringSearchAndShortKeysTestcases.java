package com.cbs.testcases;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cbs.base.TestBase;
import com.cbs.pages.Homepage;
import com.cbs.pages.LoginPage;
import com.cbs.pages.TuringSearchAndShortKeys;

public class TuringSearchAndShortKeysTestcases extends TestBase
{
	LoginPage loginpage;
	Homepage homepage;
	TuringSearchAndShortKeys turingSearchAndShortKeys;
	public TuringSearchAndShortKeysTestcases()
	{
		super();
	}
	
	@BeforeTest
	public void setUp() throws Exception
	{
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
		turingSearchAndShortKeys=homepage.turingSearchAndShortKeys();
		Thread.sleep(3000);
	}
	
	@Test(priority=1)
	public void shortKeys() throws Exception
	{
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_ALT);
		Thread.sleep(3000);
		ArrayList<String> switchTabs= new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(switchTabs.get(1));
		driver.close();
		Thread.sleep(3000);
		driver.switchTo().window(switchTabs.get(0));
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_F1);
		robot.keyRelease(KeyEvent.VK_F1);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_F2);
		robot.keyRelease(KeyEvent.VK_F2);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(3000);
		
	}
	
	@Test(priority=2)
	public void serachbyCustomerID() throws Exception
	{
		turingSearchAndShortKeys.serachByCustomerID();
	}
	
	@Test(priority=3)
	public void serachbyCustomerName() throws Exception
	{
		turingSearchAndShortKeys.serachByCustomerName();
	}
	
	@Test(priority=4)
	public void serachByCustomerAccountNumber() throws Exception
	{
		turingSearchAndShortKeys.serachByCustomerAccountNumber();
	}
	
	@Test(priority=5)
	public void serachByPANNumber() throws Exception
	{
		turingSearchAndShortKeys.serachByPANNumber();
	}
	
	@Test(priority=6)
	public void serachByAadhaarNumber() throws Exception
	{
		turingSearchAndShortKeys.serachByAadhaarNumber();
	}
	
	@Test(priority=7)
	public void serachByMobilenumber() throws Exception
	{
		turingSearchAndShortKeys.serachByMobilenumber();
	}
		
	@AfterTest
	public void tearDown()
	{
		System.out.println("Siddhesh");
		//driver.quit();
	}
}
