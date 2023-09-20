package com.cbs.testcases;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtil.XlUtil;

public class TestCaseLoginPage 
{	
	WebDriver driver;
	@BeforeTest
	public void setUp() throws Exception
	{
		ChromeOptions handlingSSL = new ChromeOptions(); //Create instance of ChromeOptions Class
		//Using the accept insecure cert method with true as parameter to accept the untrusted certificate
		handlingSSL.setAcceptInsecureCerts(true);		
		//Creating instance of Chrome driver by passing reference of ChromeOptions object
		System.setProperty("webdriver.chrome.driver","C:\\Siddhesh Training Document\\Automation_For_CBS\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver(handlingSSL);
		driver.get("https://10.10.30.110:8243/");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		Actions action=new Actions(driver);
		Robot rb=new Robot();
		for(int i=0;i<3;i++)
		{
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_SUBTRACT);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_SUBTRACT);
		}
		Thread.sleep(3000);
	}
	
	@Test(dataProvider="logindata")
	public void login(String user,String pass) throws Exception
	{
		driver.findElement(By.id("id_username")).sendKeys(user);
		driver.findElement(By.id("id_search_employee")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("id_password")).sendKeys(pass);
		driver.findElement(By.id("id_submit")).click();
	}
	
	@DataProvider(name="logindata")
	public String [][] getData() throws Exception
	{
		String path="C:\\Siddhesh Training Document\\Automation_For_CBS\\AppachePOI.xlsx";
		XlUtil xlutil=new XlUtil(path);
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcolumn=xlutil.getCellCount("Sheet1",1);
		String logindata[][]=new String[totalrows][totalcolumn];
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcolumn;j++)
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
		}
		return logindata;
	}
	
	@AfterTest
	public void tearDown()
	{
		System.out.println(" ");
		//driver.quit();
	}
}
