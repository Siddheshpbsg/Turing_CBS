package com.cbs.pages;


import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cbs.base.TestBase;
import com.cbs.util.TestUtil;

public class BalancePage extends TestBase
{
	TestUtil testutil=new TestUtil();
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static Row row;
	String location = "C:\\Users\\MayurNiwal\\eclipse-workspace\\TuringCBS_Selenium\\Folder\\excelfile\\CBS_Automation.xlsx";

	@FindBy(xpath = "(//*[contains(text(),'Balances')])[4]")
	WebElement Balance_Btn;

	@FindBy(xpath = "//*[@class='customnav active' and @id='id_account_balance']")
	WebElement Account_balance_tab;

	@FindBy(xpath = "//*[@name='txtAccountNumber' and @id='id_txtAccountNumber']")
	WebElement Account_Search;

	@FindBy(xpath = "//*[@type='button' and @id='btnSearch']")
	WebElement Search_Btn;

	@FindBy(xpath = "//*[@role='presentation' and @id='id_account_transactions']")
	WebElement Account_Transaction_Tab;

	@FindBy(xpath = "//*[@name='txtFromDate' and @id='id_txtFromDate']")
	WebElement From_Date;

	@FindBy(xpath = "//*[@name='txtToDate' and @id='id_txtToDate']")
	WebElement To_Date;

	@FindBy(xpath = "//*[@name='txtAccountNumber' and @id='id_txtAccountNumber']")
	WebElement Enter_accountNo;

	@FindBy(xpath = "//*[@type='button' and @id='btnSearch']")
	WebElement Searchbtn;

	@FindBy(xpath = "//*[text()='Balances' and @class='subMenuItem']")
	WebElement Balance_Tab;

	@FindBy(xpath = "//*[@name='txtAccountnumber' and @id='id_txtAccountNumber']")
	WebElement Account_No;

	@FindBy(xpath = "//*[@type='button' and @id='btnSearch']")
	WebElement Search_btn;

	@FindBy(xpath="//img[@id='id_emp_photo']")
	WebElement emp_photo;

	@FindBy(xpath="//a[@id='id_logout']")
	WebElement logout;

	public BalancePage()
	{
		PageFactory.initElements(driver, this);
	}

	public void Balance_Check_Saving() throws Exception 
	{
		//		Balance_Btn.click();
		//		System.out.println("Clicked on Balances menu");
		//		Thread.sleep(2000);

		Account_balance_tab.click();
		System.out.println("Clicked on Account Balance");
		Thread.sleep(2000);

		Account_Search.clear();
		Thread.sleep(2000);

		Account_Search.click();
		Thread.sleep(2000);

		Account_Search.sendKeys("999920021000018");
		System.out.println("Account No Entered");
		Thread.sleep(2000);


		Search_Btn.click();
		System.out.println("Clicked on search.");
		Thread.sleep(2000);


		Account_Transaction_Tab.click();
		System.out.println("Clicked on Account Transaction Tab");
		Thread.sleep(2000);

		From_Date.clear();
		From_Date.sendKeys("18-Jan-2023");
		System.out.println("from date entered..");
		Thread.sleep(2000);


		To_Date.clear();
		To_Date.sendKeys("28-Mar-2023");
		System.out.println("from date entered..");
		Thread.sleep(2000);


		Enter_accountNo.clear();
		Enter_accountNo.sendKeys("999920021000018");
		System.out.println("Account No Entered");
		Thread.sleep(2000);


		Searchbtn.click();
		System.out.println("Clicked on search.");
		Thread.sleep(3000);


	//	Balance_Tab.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Balance_Tab);
		System.out.println("Clicked on balance tab");
		Thread.sleep(2000);


		Account_No.clear();
		Account_No.sendKeys("999920021000018");
		System.out.println("Account No Entered");
		Thread.sleep(2000);

		Search_btn.click();
		Thread.sleep(2000);

		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
		driver.quit();


	}

	public void Balance_Check_Current() throws Exception 
	{
		
		Account_balance_tab.click();
		System.out.println("Clicked on Account Balance");
		Thread.sleep(2000);

		Account_Search.clear();
		Thread.sleep(2000);

		Account_Search.click();
		Thread.sleep(2000);

		Account_Search.sendKeys("100510011000016");
		System.out.println("Account No Entered");
		Thread.sleep(2000);


		Search_Btn.click();
		System.out.println("Clicked on search.");
		Thread.sleep(2000);


		Account_Transaction_Tab.click();
		System.out.println("Clicked on Account Transaction Tab");
		Thread.sleep(2000);

		From_Date.clear();
		From_Date.sendKeys("18-Jan-2023");
		System.out.println("from date entered..");
		Thread.sleep(2000);


		To_Date.clear();
		To_Date.sendKeys("28-Mar-2023");
		System.out.println("from date entered..");
		Thread.sleep(2000);


		Enter_accountNo.clear();
		Enter_accountNo.sendKeys("100510011000016");
		System.out.println("Account No Entered");
		Thread.sleep(2000);


		Searchbtn.click();
		System.out.println("Clicked on search.");
		Thread.sleep(3000);


	//	Balance_Tab.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Balance_Tab);
		System.out.println("Clicked on balance tab");
		Thread.sleep(2000);


		Account_No.clear();
		Account_No.sendKeys("100510011000016");
		System.out.println("Account No Entered");
		Thread.sleep(2000);

		Search_btn.click();
		Thread.sleep(2000);

		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
		driver.quit();


	}


	public void Balance_Check_Loan() throws Exception 
	{
		
		Account_balance_tab.click();
		System.out.println("Clicked on Account Balance");
		Thread.sleep(2000);

		Account_Search.clear();
		Thread.sleep(2000);

		Account_Search.click();
		Thread.sleep(2000);

		Account_Search.sendKeys("100530041000053");
		System.out.println("Account No Entered");
		Thread.sleep(2000);


		Search_Btn.click();
		System.out.println("Clicked on search.");
		Thread.sleep(2000);


		Account_Transaction_Tab.click();
		System.out.println("Clicked on Account Transaction Tab");
		Thread.sleep(2000);

		From_Date.clear();
		From_Date.sendKeys("18-Jan-2023");
		System.out.println("from date entered..");
		Thread.sleep(2000);


		To_Date.clear();
		To_Date.sendKeys("28-Mar-2023");
		System.out.println("from date entered..");
		Thread.sleep(2000);


		Enter_accountNo.clear();
		Enter_accountNo.sendKeys("100530041000053");
		System.out.println("Account No Entered");
		Thread.sleep(2000);


		Searchbtn.click();
		System.out.println("Clicked on search.");
		Thread.sleep(3000);


	//	Balance_Tab.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Balance_Tab);
		System.out.println("Clicked on balance tab");
		Thread.sleep(2000);


		Account_No.clear();
		Account_No.sendKeys("100530041000053");
		System.out.println("Account No Entered");
		Thread.sleep(2000);

		Search_btn.click();
		Thread.sleep(2000);

		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
		driver.quit();
	}
}

