package com.cbs.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cbs.base.TestBase;

public class CustomerMaitenancePage extends TestBase
{
	public static String cust_id;
	public static String cust_id1;
	@FindBy(xpath="//button[@id='btnNewCustomer']")
	WebElement btnNewCustomer;
	
	@FindBy(xpath="//input[@id='id_txtCustomerNumber']")
	WebElement CustomerNumber;
	
	@FindBy(xpath="//button[@id='btnSearchRequest']")
	WebElement SearchRequest;
	
	@FindBy(xpath="//span[contains(text(),'KYC')]")
	WebElement KYC_tab;
	
	@FindBy(xpath="//select[@id='id_documentType']")
	WebElement Document_Type;
	
	@FindBy(xpath="//input[@id='id_docketNumber']")
	WebElement Docket_No;
	
	@FindBy(xpath="//input[@id='id_expiryDate']")
	WebElement Document_Expiry_Date;
	
	@FindBy(xpath="//input[@id='id_kycTypeFull']")
	WebElement KYC_Type;
	
	@FindBy(xpath="//button[@id='id_AddKYCDocumentDetails']")
	WebElement AddKYCDocumentDetails;
	
	@FindBy(xpath="//input[@id='id_remarks']")
	WebElement Remarks;
	
	@FindBy(xpath="//button[@id='id_SubmitKYCDocumentDetails']")
	WebElement SubmitKYCDocumentDetails;
	
	@FindBy(xpath="//div[@id='error_message_master']")
	WebElement Error_message_master;
	
	@FindBy(xpath="//a[@id='id_closeErrorMessage']")
	WebElement CloseErrorMessage;
	
	@FindBy(xpath="//span[contains(text(),'Form 15AA')]")
	WebElement Form15AA_tab;
	
	@FindBy(xpath="//select[@id='id_reason_code']")
	WebElement Reason_Code;
	
	@FindBy(xpath="//input[@id='id_txtDate']")
	WebElement Date_Of_Submission;
	
	@FindBy(xpath="//input[@id='id_expiryDate']")
	WebElement Expiry_Date;
	
	@FindBy(xpath="//input[@id='id_txtTdsPercentage']")
	WebElement TDS_percentage;
	
	@FindBy(xpath="//input[@id='id_uptoAmount']")
	WebElement Upto_Amount;
	
	@FindBy(xpath="//button[@id='id_SubmitCustomerTDS']")
	WebElement SubmitCustomerTDS;
	
	@FindBy(xpath="//span[contains(text(),'Customer Memo Maintenance')]")
	WebElement Customer_Memo_Maintenance;
	
	@FindBy(xpath="//select[@id='id_txt_CustomerMemoSeverityType']")
	WebElement Severity;
	
	@FindBy(xpath="//input[@id='id_txtCustomerMemoText']")
	WebElement Memo_Text;
	
	@FindBy(xpath="//input[@id='id_txtCustomerMemoStartDate']")
	WebElement Start_Date;
	
	@FindBy(xpath="//input[@id='id_txtCustomerMemoEndDate']")
	WebElement End_Date;
	
	@FindBy(xpath="//button[@id='id_addCustomerMemo']")
	WebElement AddCustomerMemo;
	
	@FindBy(xpath="//button[@id='id_SubmitCustomermemo']")
	WebElement SubmitCustomermemo;
	
	@FindBy(xpath="//span[contains(text(),'Channel Mobile')]")
	WebElement Channel_Mobile;
	
	@FindBy(xpath="//select[@id='id_channel']")
	WebElement Channel;
	
	@FindBy(xpath="//input[@id='id_mobile_no']")
	WebElement Mobile_Number;
	
	@FindBy(xpath="//button[@id='id_mobile_add']")
	WebElement Addchannel;
	
	@FindBy(xpath="//button[@id='id_mobile_submit']")
	WebElement Submitchannel;
	
	@FindBy(xpath="//a[contains(text(),'Tax Return')]")
	WebElement Tax_Return;
	
	@FindBy(xpath="//button[@id='id_addReturn']")
	WebElement addReturn;
	
	@FindBy(xpath="//button[@id='id_SubmitReturn']")
	WebElement SubmitReturn;
	
	@FindBy(xpath="//button[@id='btnSendForVerify']")
	WebElement SendForVerify;
	
	@FindBy(xpath="//img[@id='id_emp_photo']")
	WebElement emp_photo;
	
	@FindBy(xpath="//a[@id='id_logout']")
	WebElement logout;
	
	@FindBy(xpath="//button[@id='btnAuthorize']")
	WebElement Authorize;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[14]/button[contains(text(),'View')]")
	WebElement KYC_View;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[15]/button[contains(text(),'Verify')]")
	WebElement KYC_Verify;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[9]/button[contains(text(),'View')]")
	WebElement Memo_View;
	
	@FindBy(xpath="//button[@id='btnVerify']")
	WebElement btnVerify;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[4]/button[contains(text(),'View')]")
	WebElement Channel_View;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[5]/button[contains(text(),'Verify')]")
	WebElement Channel_Verify;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[6]/button[contains(text(),'View')]")
	WebElement Tax_View;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[7]/button[contains(text(),'Verify')]")
	WebElement Tax_Verify;
	
	@FindBy(xpath="//button[@id='btnAuthorize']")
	WebElement btnAuthorize;
	
	@FindBy(xpath="//button[@id='btnEdit']")
	WebElement Edit;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[14]/button[contains(text(),'Edit')]")
	WebElement Kyc_edit;
	
	@FindBy(xpath="//button[@id='id_UpdateKYCDocumentDetails']")
	WebElement Update;
	
	public CustomerMaitenancePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void customerKYC(String cust_id,String doc_no,String exp_date,String remark) throws Exception
	{
		btnNewCustomer.click();
		Thread.sleep(3000);
		CustomerNumber.sendKeys(cust_id);
		SearchRequest.click();
		Thread.sleep(2000);
		KYC_tab.click();
		Thread.sleep(3000);
		Select document_Type=new Select(Document_Type);
		document_Type.selectByIndex(1);
		//document_Type.selectByVisibleText("Loan Agreement");
		Docket_No.sendKeys(doc_no);
		Document_Expiry_Date.sendKeys(exp_date);
		KYC_Type.click();
		Remarks.sendKeys(remark);
		AddKYCDocumentDetails.click();
		Thread.sleep(2000);
		String MainWindow=driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();		
		Iterator<String> i=s.iterator();			
		while(i.hasNext())			
		{		
		    String ChildWindow=i.next();			
		    if(!MainWindow.equalsIgnoreCase(ChildWindow))			
		    {    		
		            // Switching to Child window
		            driver.switchTo().window(ChildWindow);	                                                                                                                         			
		            driver.findElement(By.xpath("//button[contains(text(),'confirm')]")).click();
		            driver.close();
		    }
		    driver.switchTo().window(MainWindow);
		    driver.findElement(By.xpath("//button[contains(text(),'confirm')]")).click();
		}
		Thread.sleep(2000);
		SubmitKYCDocumentDetails.click();
		Thread.sleep(2000);
		this.cust_id=Error_message_master.getText();
		//System.out.println(cust_id);
		this.cust_id = this.cust_id.replace("Successfully added Document details 1 for", "");
		this.cust_id = this.cust_id.replace("x", "");
		this.cust_id = this.cust_id.trim();
		System.out.println(this.cust_id);
		Thread.sleep(3000);
		CloseErrorMessage.click();
		Thread.sleep(3000);
	}
	public void form15AA(String submission_date,String expiry_date,String tds,String upto_amt) throws Exception
	{
		Form15AA_tab.click();
		Thread.sleep(2000);
		Select reason_code=new Select(Reason_Code);
		reason_code.selectByIndex(1);
		//reason_code.selectByVisibleText("Received");
		Date_Of_Submission.sendKeys(submission_date);
		Expiry_Date.sendKeys(expiry_date);
		TDS_percentage.sendKeys(tds);
		Upto_Amount.sendKeys(upto_amt);
		SubmitCustomerTDS.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(3000);
	}
	
	public void customerMomoMaitenance(String memo_text,String start_date,String end_date) throws Exception
	{
		Customer_Memo_Maintenance.click();
		Thread.sleep(3000);
		Select severity=new Select(Severity);
		severity.selectByIndex(1);
		//severity.selectByVisibleText("LOW");
		Memo_Text.sendKeys(memo_text);
		Start_Date.sendKeys(start_date);
		End_Date.sendKeys(end_date);
		Thread.sleep(2000);
		AddCustomerMemo.click();
		Thread.sleep(2000);
		SubmitCustomermemo.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(3000);
	}
	public void channelMobile(String mob) throws Exception
	{
		Channel_Mobile.click();
		Thread.sleep(2000);
		Mobile_Number.sendKeys(mob);
		Select channel=new Select(Channel);
		channel.selectByIndex(1);
		//channel.selectByVisibleText("Mobile Banking");
		Addchannel.click();
		Thread.sleep(2000);
		Submitchannel.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(3000);
	}
	
	public void customerTaxReturn() throws Exception
	{
		Tax_Return.click();
		Thread.sleep(2000);
		addReturn.click();
		String MainWindow=driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();		
		Iterator<String> i=s.iterator();			
		while(i.hasNext())			
		{		
		    String ChildWindow=i.next();			
		    if(!MainWindow.equalsIgnoreCase(ChildWindow))			
		    {    		
		            // Switching to Child window
		            driver.switchTo().window(ChildWindow);	                                                                                                                         			
		            driver.findElement(By.xpath("//button[contains(text(),'confirm')]")).click();
		            driver.close();
		    }
		    driver.switchTo().window(MainWindow);
		    driver.findElement(By.xpath("//button[contains(text(),'confirm')]")).click();
		}
		Thread.sleep(2000);
		SubmitReturn.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		SendForVerify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}
	
	public void authCustomerMaitenance() throws Exception
	{
		Authorize.click();
		Thread.sleep(3000);
		WebElement customer_id=driver.findElement(By.xpath("//select[@id='id_optCustomerNumber']"));
		List<WebElement> dropdown=customer_id.findElements(By.tagName("option"));
		for(int i=0;i<dropdown.size();i++)
		{
			//System.out.println(cust_id);
			if(dropdown.get(i).getText().equals(cust_id))
			{
				dropdown.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		SearchRequest.click();
		Thread.sleep(3000);
		KYC_tab.click();
		Thread.sleep(3000);
		KYC_View.click();
		Thread.sleep(1000);
		KYC_Verify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Customer_Memo_Maintenance.click();
		Thread.sleep(3000);
		Memo_View.click();
		Thread.sleep(1000);
		btnVerify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Channel_Mobile.click();
		Thread.sleep(3000);
		Channel_View.click();
		Thread.sleep(2000);
		Channel_Verify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Tax_Return.click();
		Thread.sleep(3000);
		Tax_View.click();
		Thread.sleep(2000);
		Tax_Verify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		btnAuthorize.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}
	
	public void editcustomerkyc(String cust_id1,String doc_no1) throws Exception
	{
		Edit.click();
		Thread.sleep(2000);
		CustomerNumber.sendKeys(cust_id1);
		SearchRequest.click();
		Thread.sleep(2000);
		KYC_tab.click();
		Thread.sleep(2000);
		Kyc_edit.click();
		Thread.sleep(3000);
		Select document_Type=new Select(Document_Type);
		document_Type.selectByIndex(2);
		//document_Type.selectByVisibleText("Letter of Undertaking");
		Thread.sleep(2000);
		for(int i=0;i<=10;i++)
		{
			Docket_No.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		Docket_No.sendKeys(doc_no1);
		Update.click();
		Thread.sleep(2000);
		this.cust_id1=Error_message_master.getText();
		//System.out.println(cust_id);
		this.cust_id1 =this.cust_id1.replace("Successfully update document details for", "");
		this.cust_id1 =this.cust_id1.replace("x", "");
		this.cust_id1= this.cust_id1.trim();
		System.out.println(this.cust_id1);
		Thread.sleep(3000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		SendForVerify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}
	public void authcustomerkyc() throws Exception
	{
		Authorize.click();
		Thread.sleep(3000);
		WebElement customer_id=driver.findElement(By.xpath("//select[@id='id_optCustomerNumber']"));
		List<WebElement> dropdown=customer_id.findElements(By.tagName("option"));
		for(int i=0;i<dropdown.size();i++)
		{
			//System.out.println(cust_id1);
			if(dropdown.get(i).getText().equals(cust_id1))
			{
				dropdown.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		SearchRequest.click();
		Thread.sleep(3000);
		KYC_tab.click();
		Thread.sleep(3000);
		KYC_View.click();
		Thread.sleep(1000);
		KYC_Verify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		btnAuthorize.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}
}


