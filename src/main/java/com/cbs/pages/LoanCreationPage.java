package com.cbs.pages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.model.Themes;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.checkerframework.common.value.qual.IntVal;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cbs.base.TestBase;
import com.cbs.util.TestUtil;

public class LoanCreationPage extends TestBase
{
	TestUtil testutil=new TestUtil();
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static Row row;
	String location = "D:\\SidheshP\\Siddhesh Training Document\\Automation_For_CBS\\Excel\\CBS_Automation.xlsx";
	public static String New_Loan_Account;
	public static String New_CC_Account;
	Random rand = new Random();
	
	@FindBy(xpath="//select[@id='id_loan_type']")
	WebElement Loan_Type;
	
	@FindBy(xpath="//button[@id='btnNew']")
	WebElement NewAccount;
	
	@FindBy(xpath="//input[@id='id_customerno']")
	WebElement CustomerNo;
	
	@FindBy(xpath="//select[@id='id_singlejoint']")
	WebElement singlejoint;
	
	@FindBy(xpath="//select[@id='id_productcode']")
	WebElement LoanProductCode;
	
	@FindBy(xpath="//button[@id='btnSubmitForm']")
	WebElement SubmitForm;
	
	@FindBy(xpath="//img[@id='id_emp_photo']")
	WebElement emp_photo;
	
	@FindBy(xpath="//a[@id='id_logout']")
	WebElement logout;
	
	@FindBy(xpath="//div[@id='error_message_master']")
	WebElement Error_message_master;
	
	@FindBy(xpath="//a[@id='id_closeErrorMessage']")
	WebElement CloseErrorMessage;
	
	@FindBy(xpath="//input[@id='id_customername']")
	WebElement CustName;
	
	@FindBy(xpath="//span[contains(text(),'Basic Information')]")
	WebElement BasicInfo;
	
	@FindBy(xpath="//input[@id='id_loanamount']")
	WebElement SanctionAmount;
	
	@FindBy(xpath="//input[@id='id_loantenureyears']")
	WebElement Loan_Tenure_Year;
	
	@FindBy(xpath="//input[@id='id_loantenuremonths']")
	WebElement Loan_Tenure_Month;
	
	@FindBy(xpath="//input[@id='id_loantenuredays']")
	WebElement Loan_Tenure_Days;
	
	@FindBy(xpath="//input[@id='id_sanctioningAuthority']")
	WebElement SanctioningAuthority;
	
	@FindBy(xpath="//select[@id='id_disbursementtype']")
	WebElement DisbursementType;
	
	@FindBy(xpath="//input[@id='id_moratoriumperiod']")
	WebElement MoratoriumPeriod;
	
	@FindBy(xpath="//select[@id='id_moratoriumintrecoverymode']")
	WebElement MoratoriumInterestRecovery;
	
	@FindBy(xpath="//select[@id='id_installmentfrequency']")
	WebElement InstallmentFrequency;
	
	@FindBy(xpath="//select[@id='id_businesstype']")
	WebElement BusinessType;
	
	@FindBy(xpath="//select[@id='id_loanpurpose']")
	WebElement LoanPurpose;
	
	@FindBy(xpath="//input[@id='id_sharesobtained']")
	WebElement NoOfShares;
	
	@FindBy(xpath="//select[@id='id_sector']")
	WebElement Sector;
	
	@FindBy(xpath="//input[@id='id_docsubmissiondate']")
	WebElement DocumentSubmissionDate;
	
	@FindBy(xpath="//input[@id='id_docexpirydate']")
	WebElement DocumentExpiryDate;
	
	@FindBy(xpath="//select[@id='id_industry_type']")
	WebElement IndustryType;
	
	@FindBy(xpath="//select[@id='id_industry_sub_type']")
	WebElement IndustrySubtype;
	
	@FindBy(xpath="//select[@id='id_segment_type']")
	WebElement SegmentType;
	
	@FindBy(xpath="//select[@id='id_segment_sub_type']")
	WebElement SegmentSubtype;
	
	@FindBy(xpath="//select[@id='id_loanee_type']")
	WebElement LoaneeType;
	
	@FindBy(xpath="//select[@id='id_loan_category']")
	WebElement LoanCategory;
	
	@FindBy(xpath="//input[@id='id_membershipno']")
	WebElement Membershipnumber;
	
	@FindBy(xpath="//input[@name='disb_account_no']")
	WebElement DisbursmentAccountNo;
	
	@FindBy(xpath="//span[contains(text(),'Guarantor Mapping')]")
	WebElement GuarantorMapping;
	
	@FindBy(xpath="//input[@id='id_customerno']")
	WebElement GuarantorcustomerNo;
	
	@FindBy(xpath="//input[@id='id_accno']")
	WebElement LoanAccountNo;
	
	@FindBy(xpath="//input[@id='id_remarks']")
	WebElement Remarks;
	
	@FindBy(xpath="//button[@id='id_AddGuarantor']")
	WebElement AddGuarantor;
	
	@FindBy(xpath="//span[contains(text(),'Nominee Details')]")
	WebElement NomineeDetails;
	
	@FindBy(xpath="//input[@id='id_txtCustomernumber']")
	WebElement NomcustomerID;
	
	@FindBy(xpath="//span[@id='id_search']")
	WebElement Search;
	
	@FindBy(xpath="//select[@id='id_NomineeRelationType']")
	WebElement Relation;
	
	@FindBy(xpath="//input[@id='id_NomineePercentage']")
	WebElement NomineePercentage;
	
	@FindBy(xpath="//button[@id='id_nominee_add']")
	WebElement Nominee_Add;
	
	@FindBy(xpath="//button[@id='id_nominee_add']")
	WebElement Nominee_Submit;
	
	@FindBy(xpath="//button[@id='id_skip_5']")
	WebElement Nominee_Skip;
	
	@FindBy(xpath="//span[contains(text(),'Security Details')]")
	WebElement SecurityDetails;
	
	@FindBy(xpath="//select[@id='id_securitytype']")
	WebElement SecurityType;
	
	@FindBy(xpath="//textarea[@id='id_housedesc']")
	WebElement HouseDescription;
	
	@FindBy(xpath="//input[@id='id_agreementvalue']")
	WebElement AgreementValue;
	
	@FindBy(xpath="//input[@id='id_stampduty']")
	WebElement StampDuty;
	
	@FindBy(xpath="//input[@id='id_registrationcharges']")
	WebElement RegistrationCharges;
	
	@FindBy(xpath="//input[@id='id_advancepaid']")
	WebElement AdvancePaid;
	
	@FindBy(xpath="//input[@id='id_marketvalueonregistration']")
	WebElement Marketvalueonregistration;
	
	@FindBy(xpath="//input[@id='id_marketvalueonvalue']")
	WebElement Marketvalueonvalue;
	
	@FindBy(xpath="//input[@id='id_valuername']")
	WebElement ValuerName;
	
	@FindBy(xpath="//select[@id='id_valuer_name']")
	WebElement ValuerName1;
	
	@FindBy(xpath="//input[@id='id_totalvalue']")
	WebElement Totalvalue;
	
	@FindBy(xpath="//button[@id='idAddForm']")
	WebElement Add_Security;
	
	@FindBy(xpath="//button[@id='btnSendToVerify']")
	WebElement SendToVerify;
	
	@FindBy(xpath="//button[@id='btnAuthorize']")
	WebElement LoanAuthorize;
	
	@FindBy(xpath="//button[@id='id_authorize']")
	WebElement Verify;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[6]/button[contains(text(),'View')]")
	WebElement Guarantor_View;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[7]/button[contains(text(),'Verify')]")
	WebElement Guarantor_Verify;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[5]/button[@type='button']")
	WebElement Security_View;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[6]/button[text()='Authorize']")
	WebElement Security_Authorize;
	
	@FindBy(xpath="//span[contains(text(),'Cash')]")
	WebElement Cash;
	
	@FindBy(xpath="//span[contains(text(),'Transfer')]")
	WebElement Transfer;
	
	@FindBy(xpath = "//input[@id='id_txtAccountNumber']")
	WebElement AC_Product_Number;
	
	@FindBy(xpath = "//select[@id='id_activitySubTypeId']")
	WebElement Activity;
	
	@FindBy(xpath = "//input[@name='txtTxnDate']")
	WebElement Date;
	
	@FindBy(xpath = "//input[@name='token_no']")
	WebElement TokenNo;

	@FindBy(xpath = "//input[@id='id_txtInstrumentNumber']")
	WebElement InstrumentNumber;

	@FindBy(xpath = "//input[@name='txtAmount_display']")
	WebElement Amount;
	
	@FindBy(xpath = "//input[@id='id_txtAmount']")
	WebElement TransferAmount;
	
	@FindBy(xpath = "//button[@id='id_button_add_cash']")
	WebElement CashADD;
	
	@FindBy(xpath = "//button[@id='btnAddLoan']")
	WebElement AddLoan;
	
	@FindBy(xpath = "//button[@id='btnAddTransfer']")
	WebElement AddTransfer;

	@FindBy(xpath = "//button[@id='btnSubmitCash']")
	WebElement CashSubmit;
	
	@FindBy(xpath = "//button[@id='btnSubmitTransfer']")
	WebElement SubmitTransfer;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[7]/td/*[@id='id_available_balance_loan']")
	WebElement Available_Balance;
	
	@FindBy(xpath = "//input[@id='id_witnesscustid']")
	WebElement Witness_cust_no;
	
	@FindBy(xpath = "//input[@id='id_storagerefno']")
	WebElement Storage_ref_no;
	
	@FindBy(xpath = "//select[@id='id_valuer_name']")
	WebElement Valuer_name;
	
	@FindBy(xpath = "//textarea[@id='id_golddesc']")
	WebElement Item_Description;
	
	@FindBy(xpath = "//input[@id='id_item_weight']")
	WebElement Gold_Bag_Weight;
	
	@FindBy(xpath = "//input[@id='id_stone_weight']")
	WebElement StoneWt_WastageWt;
	
	@FindBy(xpath = "//select[@id='id_gold_purity']")
	WebElement Gold_purity;
	
	@FindBy(xpath = "//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[1]/a")
	WebElement Tranfer_ref_no;
	
	@FindBy(xpath = "//button[@id='id_authorizeBtn']")
	WebElement Tranfer_Auth;
	
	@FindBy(xpath="//input[@id='id_td_accounts']")
	WebElement FDAccountNo;
	
	@FindBy(xpath="//button[@id='id_AddBankDeposit']")
	WebElement AddBankDeposit;
	
	@FindBy(xpath="//button[@id='btnSubmitForm']")
	WebElement SubmitDeposite;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[9]/button[@type='button']")
	WebElement Security_Deposite_View;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[10]/button[text()='Authorize']")
	WebElement Security_Deposite_Authorize;
	
	TestUtil util=new TestUtil();
	
	public LoanCreationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void newLoanagainstFD() throws Exception
	{
		Select loan_type=new Select(Loan_Type);
		loan_type.selectByIndex(1);
		Thread.sleep(2000);
		NewAccount.click();
		Thread.sleep(2000);
		fis = new FileInputStream(location);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Loan Account");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(1).getLastCellNum();
		for (int i=7;i<=rowcount;i++)
		{
			row = sheet.getRow(i);
			for(int j=0;j<colcount;j++)
			{
				XSSFCell cell=(XSSFCell) row.getCell(j);
				int cust_no = (int) row.getCell(0).getNumericCellValue();
				//System.out.println("Customer_no" +cust_no);
				CustomerNo.sendKeys(String.valueOf(cust_no));
				CustName.click();
				Thread.sleep(2000);
				//util.handle_popop();
				Thread.sleep(2000);
				Select loan_product_code=new Select(LoanProductCode);
				loan_product_code.selectByIndex(7);
				SubmitForm.click();
				try
				{
					util.handle_popop();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				New_Loan_Account=Error_message_master.getText();
				New_Loan_Account=New_Loan_Account.replace("Success","");
				New_Loan_Account=New_Loan_Account.replace("Loan Account Master data submitted successfully! Account No:","");
				New_Loan_Account=New_Loan_Account.replace("x","");
				New_Loan_Account=New_Loan_Account.trim();
				System.out.println("Loan Account number: "+ New_Loan_Account);
				Thread.sleep(2000);
				CloseErrorMessage.click();
				Thread.sleep(2000);
				//util.handle_popop();
				Thread.sleep(2000);
				BasicInfo.click();
				Thread.sleep(2000);
				double loanamount = (double) row.getCell(1).getNumericCellValue();
				SanctionAmount.sendKeys(String.valueOf(loanamount));
				Loan_Tenure_Year.sendKeys(Keys.BACK_SPACE);
				int year = (int) row.getCell(3).getNumericCellValue();
				Loan_Tenure_Year.sendKeys(String.valueOf(year));
				Loan_Tenure_Month.sendKeys(Keys.BACK_SPACE);
				int month = (int) row.getCell(4).getNumericCellValue();
				Loan_Tenure_Month.sendKeys(String.valueOf(month));
				Loan_Tenure_Days.sendKeys(Keys.BACK_SPACE);
				int days = (int) row.getCell(5).getNumericCellValue();
				Loan_Tenure_Days.sendKeys(String.valueOf(days));
				//Select saction_auth=new Select(SanctioningAuthority);
				//saction_auth.selectByIndex(1);
				SanctioningAuthority.sendKeys("Branch Manager");
				
				/*Select disburst_type=new Select(DisbursementType);
				disburst_type.selectByIndex(1);
				int moratoriumperiod = (int) row.getCell(5).getNumericCellValue();
				MoratoriumPeriod.sendKeys(String.valueOf(moratoriumperiod));
				Select moratoriumintrecoverymode=new Select(MoratoriumInterestRecovery);
				moratoriumintrecoverymode.selectByIndex(2);
				Select installmentfrequency=new Select(InstallmentFrequency);
				installmentfrequency.selectByIndex(1);*/
				
				Select businesstype=new Select(BusinessType);
				businesstype.selectByIndex(4);
				Select loanpurpose=new Select(LoanPurpose);
				loanpurpose.selectByIndex(10);
				int noofshare = (int) row.getCell(6).getNumericCellValue();
				NoOfShares.sendKeys(String.valueOf(noofshare));
				Sector.click();
				Thread.sleep(2000);
				Select industry_type=new Select(IndustryType);
				industry_type.selectByIndex(2);
				Select industry_sub_type=new Select(IndustrySubtype);
				industry_sub_type.selectByIndex(1);
				Select segment_type=new Select(SegmentType);
				segment_type.selectByIndex(4);
				Select segment_sub_type=new Select(SegmentSubtype);
				segment_sub_type.selectByIndex(1);
				Select loanee_type=new Select(LoaneeType);
				loanee_type.selectByIndex(1);
				Select loan_category=new Select(LoanCategory);
				loan_category.selectByIndex(5);
				int membernum = (int) row.getCell(9).getNumericCellValue();
				Membershipnumber.sendKeys(String.valueOf(membernum));
				DisbursmentAccountNo.sendKeys(row.getCell(15).getStringCellValue());
				driver.findElement(By.xpath("//input[@id='id_disb_account_name']")).click();
				Thread.sleep(2000);
				SubmitForm.click();
				Thread.sleep(2000);
				CloseErrorMessage.click();
				Thread.sleep(2000);
				GuarantorMapping.click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[@id='id_skip_3']")).click();
				Thread.sleep(1000);
				/*int guarntorcustno = (int) row.getCell(10).getNumericCellValue();
				GuarantorcustomerNo.sendKeys(String.valueOf(guarntorcustno));
				LoanAccountNo.click();
				CloseErrorMessage.click();
				Thread.sleep(2000);
				Remarks.sendKeys(row.getCell(11).getStringCellValue());
				AddGuarantor.click();
				Thread.sleep(2000);
				SubmitForm.click();
				Thread.sleep(2000);*/
				CloseErrorMessage.click();
				Thread.sleep(2000);
				NomineeDetails.click();
				Thread.sleep(2000);
				Nominee_Skip.click();
				CloseErrorMessage.click();
				Thread.sleep(2000);
				SecurityDetails.click();
				Thread.sleep(2000);
				Select securitytype=new Select(SecurityType);
				securitytype.selectByIndex(2);
				Thread.sleep(2000);
				//long Account_No = (long) row.getCell(0).getNumericCellValue();
				//System.out.println("Customer_no" +cust_no);
				//CustomerNo.sendKeys(String.valueOf(cust_no));
				FDAccountNo.sendKeys(row.getCell(14).getStringCellValue());
				Thread.sleep(2000);
				try
				{
					util.handle_popop();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				driver.findElement(By.xpath("//input[@id='id_third_party_fd']")).click();
				Thread.sleep(2000);
				AddBankDeposit.click();
				Thread.sleep(2000);
				SubmitDeposite.click();
				Thread.sleep(2000);
				try
				{
					driver.switchTo().alert().accept();
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				CloseErrorMessage.click();
				NomineeDetails.click();
				Thread.sleep(2000);
				//NomineeDetails.click();
				//Thread.sleep(2000);
				SendToVerify.click();
				Thread.sleep(2000);
				CloseErrorMessage.click();
				Thread.sleep(2000);
				emp_photo.click();
				Thread.sleep(2000);
				logout.click();
				Thread.sleep(3000);
			}
		}
		
	}
	
	public void authLoanAgainstFD() throws Exception
	{
		Select loan_type=new Select(Loan_Type);
		loan_type.selectByIndex(1);
		Thread.sleep(2000);
		LoanAuthorize.click();
		WebElement Account_No=driver.findElement(By.xpath("//select[@id='id_optMasterAccountNumber']"));
		List<WebElement> dropdown=Account_No.findElements(By.tagName("option"));
		for(int i=0;i<dropdown.size();i++)
		{
			//System.out.println(dropdown.get(i).getText());
			if(dropdown.get(i).getText().equals(New_Loan_Account))
			{
				dropdown.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		Verify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		BasicInfo.click();
		Thread.sleep(2000);
		Verify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		/*GuarantorMapping.click();
		Thread.sleep(2000);
		Guarantor_View.click();
		Thread.sleep(1000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Guarantor_Verify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);*/
		SecurityDetails.click();
		Thread.sleep(2000);
		Select securitytype=new Select(SecurityType);
		securitytype.selectByIndex(1);
		Thread.sleep(2000);
		Security_Deposite_View.click();
		Thread.sleep(2000);
		try
		{
			util.handle_popop();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		Thread.sleep(5000);
		Security_Deposite_Authorize.click();
		Thread.sleep(5000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		LoanAuthorize.click();
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}
	
	
	public void newLoanAccount() throws Exception
	{
		Select loan_type=new Select(Loan_Type);
		loan_type.selectByIndex(1);
		Thread.sleep(2000);
		NewAccount.click();
		Thread.sleep(2000);
		fis = new FileInputStream(location);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Loan Account");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(1).getLastCellNum();
		for (int i=1;i<=rowcount;i++)
		{
			row = sheet.getRow(i);
			for(int j=0;j<colcount;j++)
			{
				XSSFCell cell=(XSSFCell) row.getCell(j);
				int cust_no = (int) row.getCell(0).getNumericCellValue();
				CustomerNo.sendKeys(String.valueOf(cust_no));
				CustName.click();
				Thread.sleep(2000);
				//util.handle_popop();
				Thread.sleep(2000);
				Select loan_product_code=new Select(LoanProductCode);
				loan_product_code.selectByIndex(1);
				SubmitForm.click();
				Thread.sleep(2000);
				New_Loan_Account=Error_message_master.getText();
				New_Loan_Account=New_Loan_Account.replace("Success","");
				New_Loan_Account=New_Loan_Account.replace("Loan Account Master data submitted successfully! Account No:","");
				New_Loan_Account=New_Loan_Account.replace("x","");
				New_Loan_Account=New_Loan_Account.trim();
				System.out.println("Loan Account number: "+ New_Loan_Account);
				Thread.sleep(2000);
				CloseErrorMessage.click();
				Thread.sleep(2000);
				//util.handle_popop();
				Thread.sleep(2000);
				BasicInfo.click();
				Thread.sleep(2000);
				double loanamount = (double) row.getCell(1).getNumericCellValue();
				SanctionAmount.sendKeys(String.valueOf(loanamount));
				Loan_Tenure_Year.sendKeys(Keys.BACK_SPACE);
				int year = (int) row.getCell(3).getNumericCellValue();
				Loan_Tenure_Year.sendKeys(String.valueOf(year));
				Loan_Tenure_Month.sendKeys(Keys.BACK_SPACE);
				int month = (int) row.getCell(4).getNumericCellValue();
				Loan_Tenure_Month.sendKeys(String.valueOf(month));
				Loan_Tenure_Days.sendKeys(Keys.BACK_SPACE);
				int days = (int) row.getCell(5).getNumericCellValue();
				Loan_Tenure_Days.sendKeys(String.valueOf(days));
				//Select saction_auth=new Select(SanctioningAuthority);
				//saction_auth.selectByIndex(1);
				SanctioningAuthority.sendKeys("Branch Manager");
				Select disburst_type=new Select(DisbursementType);
				disburst_type.selectByIndex(1);
				int moratoriumperiod = (int) row.getCell(5).getNumericCellValue();
				MoratoriumPeriod.sendKeys(String.valueOf(moratoriumperiod));
				Select moratoriumintrecoverymode=new Select(MoratoriumInterestRecovery);
				moratoriumintrecoverymode.selectByIndex(2);
				Select installmentfrequency=new Select(InstallmentFrequency);
				installmentfrequency.selectByIndex(1);
				Select businesstype=new Select(BusinessType);
				businesstype.selectByIndex(4);
				Select loanpurpose=new Select(LoanPurpose);
				loanpurpose.selectByIndex(10);
				int noofshare = (int) row.getCell(6).getNumericCellValue();
				NoOfShares.sendKeys(String.valueOf(noofshare));
				Sector.click();
				Thread.sleep(2000);
				//int docsubdate = (int) row.getCell(7).getNumericCellValue();
				//DocumentSubmissionDate.sendKeys(String.valueOf(docsubdate));
				//int docexpdate = (int) row.getCell(8).getNumericCellValue();
				//DocumentExpiryDate.sendKeys(String.valueOf(docexpdate));
				Select industry_type=new Select(IndustryType);
				industry_type.selectByIndex(2);
				Select industry_sub_type=new Select(IndustrySubtype);
				industry_sub_type.selectByIndex(1);
				Select segment_type=new Select(SegmentType);
				segment_type.selectByIndex(4);
				Select segment_sub_type=new Select(SegmentSubtype);
				segment_sub_type.selectByIndex(1);
				Select loanee_type=new Select(LoaneeType);
				loanee_type.selectByIndex(1);
				Select loan_category=new Select(LoanCategory);
				loan_category.selectByIndex(5);
				int membernum = (int) row.getCell(9).getNumericCellValue();
				Membershipnumber.sendKeys(String.valueOf(membernum));
				SubmitForm.click();
				Thread.sleep(2000);
				CloseErrorMessage.click();
				Thread.sleep(2000);
				GuarantorMapping.click();
				Thread.sleep(2000);
				int guarntorcustno = (int) row.getCell(10).getNumericCellValue();
				GuarantorcustomerNo.sendKeys(String.valueOf(guarntorcustno));
				LoanAccountNo.click();
				CloseErrorMessage.click();
				Thread.sleep(2000);
				Remarks.sendKeys(row.getCell(11).getStringCellValue());
				AddGuarantor.click();
				Thread.sleep(2000);
				SubmitForm.click();
				Thread.sleep(2000);
				CloseErrorMessage.click();
				Thread.sleep(2000);
				NomineeDetails.click();
				Thread.sleep(2000);
				Nominee_Skip.click();
				CloseErrorMessage.click();
				Thread.sleep(2000);
				/*int moncustomer = (int) row.getCell(12).getNumericCellValue();
				NomcustomerID.sendKeys(String.valueOf(moncustomer));
				Search.click();
				Thread.sleep(3000);
				Select relation=new Select(Relation);
				relation.selectByIndex(7);
				for(int m=1;m<=6;m++)
				{
					NomineePercentage.sendKeys(Keys.BACK_SPACE);
				}
				int nompercentage = (int) row.getCell(13).getNumericCellValue();
				NomineePercentage.sendKeys(String.valueOf(nompercentage));
				Nominee_Add.click();
				Thread.sleep(3000);
				Nominee_Submit.click();
				Thread.sleep(3000);
				CloseErrorMessage.click();
				Thread.sleep(3000);*/
				SecurityDetails.click();
				Thread.sleep(2000);
				Select securitytype=new Select(SecurityType);
				securitytype.selectByIndex(1);
				Thread.sleep(2000);
				HouseDescription.sendKeys(row.getCell(14).getStringCellValue());
				double Agreementvalue = (double) row.getCell(15).getNumericCellValue();
				AgreementValue.sendKeys(String.valueOf(Agreementvalue));
				int stampduty = (int) row.getCell(16).getNumericCellValue();
				StampDuty.sendKeys(String.valueOf(stampduty));
				int Regcharges = (int) row.getCell(17).getNumericCellValue();
				RegistrationCharges.sendKeys(String.valueOf(Regcharges));
				int advpaid = (int) row.getCell(18).getNumericCellValue();
				AdvancePaid.sendKeys(String.valueOf(advpaid));
				double marketvalueonregistration = (double) row.getCell(19).getNumericCellValue();
				Marketvalueonregistration.sendKeys(String.valueOf(marketvalueonregistration));
				double marketvalueonvalue = (double) row.getCell(20).getNumericCellValue();
				Marketvalueonvalue.sendKeys(String.valueOf(marketvalueonvalue));
				Totalvalue.click();
				Thread.sleep(2000);
				ValuerName.sendKeys(row.getCell(21).getStringCellValue());
				Add_Security.click();
				SubmitForm.click();
				Thread.sleep(2000);
				try
				{
					driver.switchTo().alert().accept();
					CloseErrorMessage.click();
				}
				catch(Exception e)
				{
					System.out.println("Alert is displayed or not");
				}
				Thread.sleep(2000);
				//NomineeDetails.click();
				//Thread.sleep(2000);
				SendToVerify.click();
				Thread.sleep(2000);
				CloseErrorMessage.click();
				Thread.sleep(2000);
				emp_photo.click();
				Thread.sleep(2000);
				logout.click();
				Thread.sleep(3000);
			}
		}
	}
	public void authNewLoanAccount() throws Exception
	{
		Select loan_type=new Select(Loan_Type);
		loan_type.selectByIndex(1);
		Thread.sleep(2000);
		LoanAuthorize.click();
		WebElement Account_No=driver.findElement(By.xpath("//select[@id='id_optMasterAccountNumber']"));
		List<WebElement> dropdown=Account_No.findElements(By.tagName("option"));
		for(int i=0;i<dropdown.size();i++)
		{
			//System.out.println(dropdown.get(i).getText());
			if(dropdown.get(i).getText().equals(New_Loan_Account))
			{
				dropdown.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		Verify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		BasicInfo.click();
		Thread.sleep(2000);
		Verify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		GuarantorMapping.click();
		Thread.sleep(2000);
		Guarantor_View.click();
		Thread.sleep(1000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Guarantor_Verify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		SecurityDetails.click();
		Thread.sleep(2000);
		Select securitytype=new Select(SecurityType);
		securitytype.selectByIndex(1);
		Thread.sleep(2000);
		Security_View.click();
		Thread.sleep(2000);
		Security_Authorize.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		LoanAuthorize.click();
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}
	
	public void loanAccountDisburst() throws Exception
	{
		Cash.click();
		Thread.sleep(2000);
		AC_Product_Number.sendKeys(New_Loan_Account);
		Date.click();
		Thread.sleep(2000);
		Select activity=new Select(Activity);
		activity.selectByVisibleText("LOAN_DISBURSMENT");
		int rand_token = rand.nextInt(150);
		TokenNo.sendKeys(String.valueOf(rand_token));
		String amount=Available_Balance.getText();
		Amount.sendKeys(amount);
		InstrumentNumber.sendKeys("00");
		CashADD.click();
		testutil.handle_popop1();
		Thread.sleep(2000);
		CashSubmit.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}
	
	public void authloanAccountDisburst() throws Exception
	{
		Cash.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/li[@id='id_authorization_cash']/a[contains(text(),'Authorization')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[1]/a[@id='reference_no0']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='id_authorizeBtn']")).click();
		Thread.sleep(2000);
		util.handle_popop1();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/li[@id='id_completed_cash']/a[contains(text(),'Completed Transactions')]")).click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}
	
	public void goldLoanAccount() throws Exception
	{
		Select loan_type=new Select(Loan_Type);
		loan_type.selectByIndex(1);
		Thread.sleep(2000);
		NewAccount.click();
		Thread.sleep(2000);
		fis = new FileInputStream(location);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Loan Account");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(1).getLastCellNum();
		for (int i=4;i<=rowcount;i++)
		{
			row = sheet.getRow(i);
			for(int j=0;j<colcount;j++)
			{
				XSSFCell cell=(XSSFCell) row.getCell(j);
				int cust_no = (int) row.getCell(0).getNumericCellValue();
				CustomerNo.sendKeys(String.valueOf(cust_no));
				CustName.click();
				Thread.sleep(2000);
				//util.handle_popop();
				Thread.sleep(2000);
				Select loan_product_code=new Select(LoanProductCode);
				loan_product_code.selectByIndex(3);
				SubmitForm.click();
				Thread.sleep(2000);
				New_Loan_Account=Error_message_master.getText();
				New_Loan_Account=New_Loan_Account.replace("Success","");
				New_Loan_Account=New_Loan_Account.replace("Loan Account Master data submitted successfully! Account No:","");
				New_Loan_Account=New_Loan_Account.replace("x","");
				New_Loan_Account=New_Loan_Account.trim();
				System.out.println("Loan Account number: "+ New_Loan_Account);
				Thread.sleep(2000);
				CloseErrorMessage.click();
				Thread.sleep(2000);
				//util.handle_popop();
				Thread.sleep(2000);
				BasicInfo.click();
				Thread.sleep(2000);
				double loanamount = (double) row.getCell(1).getNumericCellValue();
				SanctionAmount.sendKeys(String.valueOf(loanamount));
				Loan_Tenure_Year.sendKeys(Keys.BACK_SPACE);
				int year = (int) row.getCell(2).getNumericCellValue();
				Loan_Tenure_Year.sendKeys(String.valueOf(year));
				Loan_Tenure_Month.sendKeys(Keys.BACK_SPACE);
				int month = (int) row.getCell(3).getNumericCellValue();
				Loan_Tenure_Month.sendKeys(String.valueOf(month));
				Loan_Tenure_Days.sendKeys(Keys.BACK_SPACE);
				int days = (int) row.getCell(4).getNumericCellValue();
				Loan_Tenure_Days.sendKeys(String.valueOf(days));
				//Select saction_auth=new Select(SanctioningAuthority);
				//saction_auth.selectByIndex(1);
				SanctioningAuthority.sendKeys("Branch Manager");
				/*Select disburst_type=new Select(DisbursementType);
				disburst_type.selectByIndex(1);
				int moratoriumperiod = (int) row.getCell(5).getNumericCellValue();
				MoratoriumPeriod.sendKeys(String.valueOf(moratoriumperiod));
				Select moratoriumintrecoverymode=new Select(MoratoriumInterestRecovery);
				moratoriumintrecoverymode.selectByIndex(2);
				Select installmentfrequency=new Select(InstallmentFrequency);
				installmentfrequency.selectByIndex(1);*/
				
				Select businesstype=new Select(BusinessType);
				businesstype.selectByIndex(4);
				Select loanpurpose=new Select(LoanPurpose);
				loanpurpose.selectByIndex(5);
				int noofshare = (int) row.getCell(6).getNumericCellValue();
				NoOfShares.sendKeys(String.valueOf(noofshare));
				Sector.click();
				Thread.sleep(2000);
				//int docsubdate = (int) row.getCell(7).getNumericCellValue();
				//DocumentSubmissionDate.sendKeys(String.valueOf(docsubdate));
				//int docexpdate = (int) row.getCell(8).getNumericCellValue();
				//DocumentExpiryDate.sendKeys(String.valueOf(docexpdate));
				Select industry_type=new Select(IndustryType);
				industry_type.selectByIndex(2);
				Select industry_sub_type=new Select(IndustrySubtype);
				industry_sub_type.selectByIndex(1);
				Select segment_type=new Select(SegmentType);
				segment_type.selectByIndex(4);
				Select segment_sub_type=new Select(SegmentSubtype);
				segment_sub_type.selectByIndex(1);
				Select loanee_type=new Select(LoaneeType);
				loanee_type.selectByIndex(1);
				Select loan_category=new Select(LoanCategory);
				loan_category.selectByIndex(5);
				int membernum = (int) row.getCell(9).getNumericCellValue();
				Membershipnumber.sendKeys(String.valueOf(membernum));
				SubmitForm.click();
				Thread.sleep(2000);
				CloseErrorMessage.click();
				Thread.sleep(2000);
				GuarantorMapping.click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[@id='id_skip_3']")).click();
				Thread.sleep(1000);
				CloseErrorMessage.click();
				Thread.sleep(2000);
				/*int guarntorcustno = (int) row.getCell(10).getNumericCellValue();
				GuarantorcustomerNo.sendKeys(String.valueOf(guarntorcustno));
				LoanAccountNo.click();
				CloseErrorMessage.click();
				Thread.sleep(2000);
				Remarks.sendKeys(row.getCell(11).getStringCellValue());
				AddGuarantor.click();
				Thread.sleep(2000);
				SubmitForm.click();
				Thread.sleep(2000);
				CloseErrorMessage.click();
				Thread.sleep(2000);*/
				
				NomineeDetails.click();
				Thread.sleep(2000);
				Nominee_Skip.click();
				CloseErrorMessage.click();
				Thread.sleep(2000);
				/*int moncustomer = (int) row.getCell(12).getNumericCellValue();
				NomcustomerID.sendKeys(String.valueOf(moncustomer));
				Search.click();
				Thread.sleep(3000);
				Select relation=new Select(Relation);
				relation.selectByIndex(7);
				for(int m=1;m<=6;m++)
				{
					NomineePercentage.sendKeys(Keys.BACK_SPACE);
				}
				int nompercentage = (int) row.getCell(13).getNumericCellValue();
				NomineePercentage.sendKeys(String.valueOf(nompercentage));
				Nominee_Add.click();
				Thread.sleep(3000);
				Nominee_Submit.click();
				Thread.sleep(3000);
				CloseErrorMessage.click();
				Thread.sleep(3000);*/
				SecurityDetails.click();
				Thread.sleep(2000);
				Select securitytype=new Select(SecurityType);
				securitytype.selectByVisibleText("Gold/Jewellery");
				Thread.sleep(1000);
				int witnesscust_no = (int) row.getCell(14).getNumericCellValue();
				Witness_cust_no.sendKeys(String.valueOf(witnesscust_no));
				int storage_ref = (int) row.getCell(15).getNumericCellValue();
				Storage_ref_no.sendKeys(String.valueOf(storage_ref));
				Select Valuer_Name=new Select(ValuerName1);
				Valuer_Name.selectByVisibleText("Akshay M");
				Item_Description.sendKeys(row.getCell(16).getStringCellValue());
				int gold_bag = (int) row.getCell(17).getNumericCellValue();
				Gold_Bag_Weight.sendKeys(String.valueOf(gold_bag));
				int staone_wt = (int) row.getCell(18).getNumericCellValue();
				StoneWt_WastageWt.sendKeys(String.valueOf(staone_wt));
				Select Goldpurity=new Select(Gold_purity);
				Goldpurity.selectByVisibleText("22 carat");
				/*HouseDescription.sendKeys(row.getCell(14).getStringCellValue());
				double Agreementvalue = (double) row.getCell(15).getNumericCellValue();
				AgreementValue.sendKeys(String.valueOf(Agreementvalue));
				int stampduty = (int) row.getCell(16).getNumericCellValue();
				StampDuty.sendKeys(String.valueOf(stampduty));
				int Regcharges = (int) row.getCell(17).getNumericCellValue();
				RegistrationCharges.sendKeys(String.valueOf(Regcharges));
				int advpaid = (int) row.getCell(18).getNumericCellValue();
				AdvancePaid.sendKeys(String.valueOf(advpaid));
				double marketvalueonregistration = (double) row.getCell(19).getNumericCellValue();
				Marketvalueonregistration.sendKeys(String.valueOf(marketvalueonregistration));
				double marketvalueonvalue = (double) row.getCell(20).getNumericCellValue();
				Marketvalueonvalue.sendKeys(String.valueOf(marketvalueonvalue));
				Totalvalue.click();
				Thread.sleep(2000);
				ValuerName.sendKeys(row.getCell(21).getStringCellValue());*/
				Add_Security.click();
				SubmitForm.click();
				Thread.sleep(2000);
				CloseErrorMessage.click();
				Thread.sleep(1000);
				try
				{
					driver.switchTo().alert().accept();
					
				}
				catch(Exception e)
				{
					System.out.println("Alert is diplaed or not");
				}
				//Thread.sleep(2000);
				//NomineeDetails.click();
				//Thread.sleep(2000);
				SendToVerify.click();
				Thread.sleep(2000);
				CloseErrorMessage.click();
				Thread.sleep(2000);
				emp_photo.click();
				Thread.sleep(2000);
				logout.click();
				Thread.sleep(3000);
			}
		}
	}	
	
	
	public void authNewLoanGoldAccount() throws Exception
	{
		Select loan_type=new Select(Loan_Type);
		loan_type.selectByIndex(1);
		Thread.sleep(2000);
		LoanAuthorize.click();
		WebElement Account_No=driver.findElement(By.xpath("//select[@id='id_optMasterAccountNumber']"));
		List<WebElement> dropdown=Account_No.findElements(By.tagName("option"));
		for(int i=0;i<dropdown.size();i++)
		{
			//System.out.println(dropdown.get(i).getText());
			if(dropdown.get(i).getText().equals(New_Loan_Account))
			{
				dropdown.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		Verify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		BasicInfo.click();
		Thread.sleep(2000);
		Verify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		/*GuarantorMapping.click();
		Thread.sleep(2000);
		Guarantor_View.click();
		Thread.sleep(1000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Guarantor_Verify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);*/
		SecurityDetails.click();
		Thread.sleep(2000);
		Select securitytype=new Select(SecurityType);
		securitytype.selectByIndex(1);
		Thread.sleep(2000);
		Security_View.click();
		Thread.sleep(2000);
		Security_Authorize.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		LoanAuthorize.click();
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}
	
	public void goldLoanAccountDisburst() throws Exception
	{
		Transfer.click();
		Thread.sleep(2000);
		AC_Product_Number.sendKeys(New_Loan_Account);
		Date.click();
		Thread.sleep(2000);
		Select activity=new Select(Activity);
		activity.selectByVisibleText("LOAN_DISBURSMENT");
		Thread.sleep(1000);
		String amount=Available_Balance.getText();
		System.out.println(amount);
		TransferAmount.sendKeys(amount);
		InstrumentNumber.sendKeys("00");
		AddLoan.click();
		Thread.sleep(2000);
		AC_Product_Number.sendKeys("100020011000648");
		Date.click();
		Thread.sleep(2000);
		Select activity1=new Select(Activity);
		activity1.selectByVisibleText("CASA_CREDIT");
		TransferAmount.sendKeys(amount);
		InstrumentNumber.sendKeys("00");
		AddTransfer.click();
		Thread.sleep(2000);
		SubmitTransfer.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='id_closeModal']")).click();
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}
	
	public void authGoldAccountDisburst() throws Exception
	{
		Transfer.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@id='id_authorization_transfer']/a[contains(text(),'Authorization')]")).click();
		Thread.sleep(2000);
		Tranfer_ref_no.click();
		Thread.sleep(2000);
		Tranfer_Auth.click();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='id_closeModal']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@id='id_completed_transfer']/a[contains(text(),'Completed Transactions')]")).click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}
	
	public void New_CC_Account() throws Exception
	{
		Select loan_type=new Select(Loan_Type);
		loan_type.selectByIndex(2);
		Thread.sleep(1000);
		NewAccount.click();
		Thread.sleep(2000);
	}
}
