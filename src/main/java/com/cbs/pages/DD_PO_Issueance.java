package com.cbs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cbs.base.TestBase;

public class DD_PO_Issueance extends TestBase
{
	Actions action;
	@FindBy(xpath="//span[contains(text(),'Remittance')]")
	WebElement Remittance;
	
	@FindBy(xpath="//a[contains(text(),'DD/PO Stock Maintenance')]")
	WebElement DD_PO_StockMaintenance;
	
	@FindBy(xpath="//button[@id='btnNew']")
	WebElement NewCustomer;
	
	@FindBy(xpath="//button[@id='btnAuthorize']")
	WebElement Authorize;
	
	@FindBy(xpath="//input[@id='id_internalproduct']")
	WebElement ProductCode;
	
	@FindBy(xpath="//span[@id='id_search']")
	WebElement Search;
	
	@FindBy(xpath="//input[@id='id_fromcheque']")
	WebElement FromChequeNo;
	
	@FindBy(xpath="//input[@id='id_tocheque']")
	WebElement ToChequeNo;
	
	@FindBy(xpath="//input[@id='id_fromamt']")
	WebElement FromAmount;
	
	@FindBy(xpath="//input[@id='id_toamt']")
	WebElement ToAmount;
	
	@FindBy(xpath="//button[@id='btnSubmitForm']")
	WebElement Submit;
	
	@FindBy(xpath="//a[@id='id_closeErrorMessage']")
	WebElement Close;
	
	@FindBy(xpath="//select[@id='id_pendingInternalProducts']")
	WebElement ProductCode1;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[14]/button[@type='button']")
	WebElement View;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[15]/button[@onclick='verify()']")
	WebElement Auth;
	
	@FindBy(xpath="//img[@id='id_emp_photo']")
	WebElement emp_photo;
	
	@FindBy(xpath="//a[@id='id_logout']")
	WebElement logout;
	
	public DD_PO_Issueance()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void dd_PO_Stock_Maintanence() throws Exception
	{
		Remittance.click();
		Thread.sleep(1000);
		DD_PO_StockMaintenance.click();
		Thread.sleep(1000);
		NewCustomer.click();
		Thread.sleep(1000);
		ProductCode.sendKeys("7198");
		Search.click();
		Thread.sleep(1000);
		FromChequeNo.sendKeys("654");
		ToChequeNo.sendKeys("660");
		FromAmount.sendKeys("10");
		ToAmount.sendKeys("2000");
		Submit.click();
		Close.click();
		emp_photo.click();
		logout.click();
		Thread.sleep(2000);
	}
	
	public void auth_dd_PO_Stock_Maintanence() throws Exception
	{
		Remittance.click();
		Thread.sleep(1000);
		DD_PO_StockMaintenance.click();
		Thread.sleep(1000);
		Authorize.click();
		Thread.sleep(1000);
		Select productcode =new Select(ProductCode1);
		productcode.selectByVisibleText("7198");
		View.click();
		Thread.sleep(1000);
		Auth.click();
		Thread.sleep(1000);
		Close.click();
		emp_photo.click();
		logout.click();
		Thread.sleep(2000);
	}
}
