package com.cbs.pages;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cbs.base.TestBase;

public class TellerPage extends TestBase
{
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static Row row;
	String location = "D:\\Siddhesh Training Document\\Automation_For_CBS\\Excel\\CBS_Automation.xlsx";
	
	@FindBy(xpath="//select[@id='id_txnNatureSelect']")
	WebElement Activity;
	
	@FindBy(xpath="//input[@id='id_Deno0']")
	WebElement Quantity1;
	
	@FindBy(xpath="//input[@id='id_Deno0_Total']")
	WebElement Value1;
	
	@FindBy(xpath="//input[@id='id_txtTxnDate']")
	WebElement Date;
	
	@FindBy(xpath="//input[@id='id_txtAmount']")
	WebElement Amount;
	
	@FindBy(xpath="//button[@id='btnSubmit']")
	WebElement Submit;
	
	@FindBy(xpath="//a[@id='id_closeErrorMessage']")
	WebElement CloseErrorMessage;
	
	@FindBy(xpath="//img[@id='id_emp_photo']")
	WebElement emp_photo;
	
	@FindBy(xpath="//a[@id='id_logout']")
	WebElement logout;
	
	@FindBy(xpath="//a[contains(text(),'Pending Vault Transaction')]")
	WebElement PendingVaultTransaction;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[8]/button[contains(text(),'Authorize')]")
	WebElement PendingVaultAuthorize;
	
	@FindBy(xpath="//a[contains(text(),'Authorized Vault Transaction')]")
	WebElement AuthorizedVaultTransaction;
	
	@FindBy(xpath="//a[contains(text(),'Exchange')]")
	WebElement ExchangeDenoms;
	
	@FindBy(xpath="//input[@id='id_RecievedDeno0']")
	WebElement Exchange1;
	
	@FindBy(xpath="//input[@id='id_ReturnedDeno0']")
	WebElement Exchange2;
	
	@FindBy(xpath="//input[@id='id_exchange_remark']")
	WebElement Remarks;
	
	@FindBy(xpath="//button[@id='btnSubmit']")
	WebElement Exchangebutton;
	
	@FindBy(xpath="//a[contains(text(),'Teller to Teller')]")
	WebElement TelleToTeller;
	
	@FindBy(xpath="//select[@id='id_teller2']")
	WebElement RecievingTeller;
	
	
	
	public TellerPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void vaultTransactionWithdraw() throws Exception
	{
			Select activity=new Select(Activity);
			activity.selectByIndex(2);
			Thread.sleep(5000);
			Quantity1.sendKeys("1");
			Quantity1.sendKeys(Keys.TAB);
			Amount.clear();
			Thread.sleep(2000);
			Amount.sendKeys("2000");
			Submit.click();
			Thread.sleep(1000);
			CloseErrorMessage.click();
			Thread.sleep(1000);
			emp_photo.click();
			Thread.sleep(2000);
			logout.click();
			Thread.sleep(3000);
	}
	
	public void authvaultTransactionWithdraw() throws Exception
	{
		PendingVaultTransaction.click();
		Thread.sleep(2000);
		PendingVaultAuthorize.click();
		CloseErrorMessage.click();
		Thread.sleep(1000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}
	
	public void vaultTransactionDeposite() throws Exception
	{
		Select activity=new Select(Activity);
		activity.selectByIndex(1);
		Thread.sleep(5000);
		Quantity1.sendKeys("1");
		Quantity1.sendKeys(Keys.TAB);
		Amount.clear();
		Thread.sleep(2000);
		Amount.sendKeys("2000");
		Submit.click();
		Thread.sleep(1000);
		CloseErrorMessage.click();
		Thread.sleep(1000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}
	
	public void authvaultTransactionDeposite() throws Exception
	{
		PendingVaultTransaction.click();
		Thread.sleep(2000);
		PendingVaultAuthorize.click();
		CloseErrorMessage.click();
		Thread.sleep(2000);
		AuthorizedVaultTransaction.click();
		Thread.sleep(3000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}
	
	public void authorizevaultTransactionAndExchange() throws Exception
	{
		ExchangeDenoms.click();
		Exchange1.clear();
		Exchange1.sendKeys("1");
		Exchange2.clear();
		Exchange2.sendKeys("1");
		Remarks.sendKeys("Exchange note");
		Exchangebutton.click();
		CloseErrorMessage.click();
		Thread.sleep(3000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}
	
	public void tellertoTeller() throws Exception
	{
		TelleToTeller.click();
		Thread.sleep(2000);
		Select recievingTeller=new Select(RecievingTeller);
		recievingTeller.selectByVisibleText("NN-M");
		driver.findElement(By.id("id_Deno0p")).sendKeys("1");
		driver.findElement(By.id("id_Deno0p")).sendKeys(Keys.TAB);
		Submit.click();
		Thread.sleep(1000);
		//driver.switchTo().alert().accept();
		Thread.sleep(1000);
		CloseErrorMessage.click();
		Thread.sleep(1000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}
}
