package com.cbs.testcases;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CashActivit1
{
	WebDriver driver;
	@BeforeTest
	public void beforeTest() throws Exception
	{
		ChromeOptions handlingSSL=new ChromeOptions();
		//handlingSSL.setAcceptInsecureCerts(true);
		System.setProperty("webdriver.chrome.driver","C:\\Siddhesh Training Document\\Automation_For_CBS\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(handlingSSL);
		driver.get("https://10.10.30.110:8243/");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Actions action=new Actions(driver);
		Robot rb=new Robot();
		for(int i=0;i<3;i++)
		{
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_SUBTRACT);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_SUBTRACT);
		}
	}
	@Test(priority=1)
	public void login() throws Exception 
	{
	    driver.findElement(By.xpath("//input[@id='id_username']")).sendKeys("sp-m");
		driver.findElement( By.xpath("//button[@id='id_search_employee']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='id_password']")).sendKeys("Turing@12345");
		driver.findElement(By.xpath("//button[@id='id_submit']")).click();
		Thread.sleep(5000);
	}

	@AfterTest
	public void afterTest()
	{
	  driver.close();
	}
}
