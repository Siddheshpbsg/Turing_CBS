package com.cbs.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cbs.base.TestBase;
import com.cbs.util.TestUtil;

public class Quicklinks extends TestBase
{
	LoginPage loginpage;
	@FindBy(xpath="//i[contains(text(),'add')]")
	WebElement Add_link;
	
	@FindBy(xpath="//i[contains(text(),'open_in_new')]")
	WebElement New_Tab;
	
	@FindBy(xpath="//i[contains(text(),'attach_money')]")
	WebElement GoldLoanAmountCalculator;
	
	@FindBy(xpath="//i[contains(text(),'account_balance')]")
	WebElement GetAccountClosureAmount;
	
	@FindBy(xpath="//i[contains(text(),'account_balance_wallet')]")
	WebElement AccountBalance;
	
	@FindBy(xpath="//i[contains(text(),'account_circle')]")
	WebElement AccountMapping;
	
	@FindBy(xpath="//i[contains(text(),'local_atm')]")
	WebElement TDInterestCalculator;
	
	@FindBy(xpath="//i[contains(text(),'dialpad')]")
	WebElement LoanEMICalculator;
	
	public Quicklinks()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickonaddlink() throws Exception
	{
		Add_link.click();
		Thread.sleep(5000);
	}
	
	public void clickonNewTablink() throws Exception
	{
		New_Tab.click();
		Thread.sleep(3000);
		ArrayList<String> switchTabs= new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(switchTabs.get(0));
		driver.close();
		Thread.sleep(3000);
		driver.switchTo().window(switchTabs.get(1));
	}
	
	public void clickonGoldLoanAmountCalculatorlink() throws Exception
	{
		Add_link.click();
		Thread.sleep(2000);
		GoldLoanAmountCalculator.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@id='id_closeModal_turing']")).click();
		Thread.sleep(3000);
	}
	
	public void clickonGetAccountClosureAmount() throws Exception
	{
		Add_link.click();
		Thread.sleep(2000);
		GetAccountClosureAmount.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@id='id_closeModal_turing']")).click();
		Thread.sleep(3000);
	}
	
	public void clickonGetAccountBalance() throws Exception
	{
		Add_link.click();
		Thread.sleep(2000);
		AccountBalance.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@id='id_closeModal_turing']")).click();
		Thread.sleep(3000);
	}
	
	public void clickonGetAccountMapping() throws Exception
	{
		Add_link.click();
		Thread.sleep(2000);
		AccountMapping.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@id='id_closeModal_turing']")).click();
		Thread.sleep(3000);
	}
	
	public void clickonTDInterestCalculator() throws Exception
	{
		Add_link.click();
		Thread.sleep(2000);
		TDInterestCalculator.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='id_closeModal_turing']")).click();
		Thread.sleep(3000);
	}
	
	public void clickonLoanEMICalculator() throws Exception
	{
		Add_link.click();
		Thread.sleep(2000);
		LoanEMICalculator.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='id_closeModal_turing']")).click();
		Thread.sleep(3000);
	}
}
