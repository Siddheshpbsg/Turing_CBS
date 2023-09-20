package com.cbs.pages;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.cbs.base.TestBase;
import com.cbs.util.TestUtil;

public class TDCreationPage extends TestBase
{
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static Row row;
	String location = "D:\\SidheshP\\Siddhesh Training Document\\Automation_For_CBS\\Excel\\Sanket Excel\\CBS_Automation.xlsx";
	public static String New_TD_Account;
	public static String New_Cash_TD_Account;
	public static String New_Transfer_TD_Account;
	public static String New_RD_Account;
	public static String New_Bulk_TD_Account;
	public static String New_Bulk_TD_Accounts;
	public static String Account_Numbers;
	public static String Refference_No;

	TestUtil util=new TestUtil();

	@FindBy(xpath="//*[@onchange='showButtons()']")
	WebElement TDdropdownElement; 

	@FindBy(xpath="//span[contains(text(),'Primary Applicant Details')]")
	WebElement Primary_Applicant_Details;

	@FindBy(xpath="//button[@id='btnNew']")
	WebElement NewAccount;

	@FindBy(xpath="//input[@id='id_txtCustomernumber']")
	WebElement Customer_id;

	@FindBy(xpath="//*[@id='id_customerid']")
	WebElement WitnessCustomer_id;

	@FindBy(xpath="//input[@id='id_rate_of_interest']")
	WebElement Rate_Of_Interest;

	@FindBy(xpath="//*[@id='id_search']")
	WebElement Master_search;

	@FindBy(xpath="//select[@id='id_ProductCode']")
	WebElement TD_Product_Code;

	@FindBy(xpath="//input[@id='id_tdAmount']")
	WebElement Term_Deposit_Amount;

	@FindBy(xpath="//input[@id='id_DepositTenureDays']")
	WebElement Term_Deposit_Tenure_Days;

	@FindBy(xpath="//input[@id='id_DepositTenureMonths']")
	WebElement Term_Deposit_Tenure_Month;

	@FindBy(xpath="//input[@id='id_DepositTenureYears']")
	WebElement Term_Deposit_Tenure_Year;

	@FindBy(xpath="//select[@id='id_customerProfile']")
	WebElement customerProfile;

	@FindBy(xpath="//select[@id='id_OperatingInstructionInd']")
	WebElement Operating_Instruction;

	@FindBy(xpath="//button[@id='id_SubmitCompanyDetail']")
	WebElement SubmitPrimaryDetail;

	@FindBy(xpath="//div[@id='error_message_master']")
	WebElement Error_message_master;

	@FindBy(xpath="//a[@id='id_closeErrorMessage']")
	WebElement CloseErrorMessage;

	@FindBy(xpath="//*[@id=\"id_closeModal\"]")
	WebElement close;

	@FindBy(xpath="//span[contains(text(),'Deposit Detail')]")
	WebElement Deposit_Detail;

	@FindBy(xpath="//*[@id='id_SubmitDepositDetail']")
	WebElement SubmitDepositDetail;

	@FindBy(xpath="//span[contains(text(),'Interest Payout')]")
	WebElement Interest_Payout;

	@FindBy(xpath="//span[contains(text(),'Joint Holder Detail')]")
	WebElement Joint_Holder_Details;

	@FindBy(xpath="//select[@id='id_GuardianRelationType']")
	WebElement Joint_Ralation;

	@FindBy(xpath="//button[@id='id_joint_add']")
	WebElement Joint_Add;

	@FindBy(xpath="//button[@id='id_joint_submit']")
	WebElement Joint_Submit;

	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[5]/button[contains(text(),'View')]")
	WebElement Joint_View;

	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[6]/button[contains(text(),'Verify')]")
	WebElement Joint_Verify;

	@FindBy(xpath="//span[contains(text(),'Nominee Detail')]")
	WebElement Nominee_Detail;

	@FindBy(xpath="//select[@id='id_NomineeRelationType']")
	WebElement Relation;

	@FindBy(xpath="//button[@id='id_nominee_add']")
	WebElement Nominee_Add;

	@FindBy(xpath="//button[@id='id_nominee_submit']")
	WebElement Nominee_Submit;

	@FindBy(xpath="//span[contains(text(),'Witness Detail')]")
	WebElement Witness_Detail;

	@FindBy(xpath="//input[@id='id_customerid']")
	WebElement Witness_Customer_id;

	@FindBy(xpath="//button[@id='id_witness_add']")
	WebElement Witness_Add;

	@FindBy(xpath="//button[@id='id_witness_submit']")
	WebElement Witness_Submit;

	@FindBy(xpath="//span[contains(text(),'Payin Details')]")
	WebElement Payin_Detail;

	@FindBy(xpath="//input[@id='id_accountno']")
	WebElement Account_No;

	@FindBy(xpath="//select[@id='id_branch']")
	WebElement Branch;

	@FindBy(xpath="//select[@id='id_activity']")
	WebElement Activity;

	@FindBy(xpath="//input[@id='id_txtInstrumentNumber']")
	WebElement Instrument_Number;

	@FindBy(xpath="//input[@id='id_narration']")
	WebElement Narration;

	@FindBy(xpath="//*[@id=\"id_skip_3\"]")
	WebElement SkipPayin;

	@FindBy(xpath="//*[@id='id_master_sendtoverify']")
	WebElement SendtoVerify;

	@FindBy(xpath="//button[@id='id_submitPayinDetails']")
	WebElement Payin_Submit;

	@FindBy(xpath="//span[contains(text(),'Account Master TD')]")
	WebElement TD_Creation;

	@FindBy(xpath="//input[@id='id_masterAccountNo']")
	WebElement Pri_Account_No;

	@FindBy(xpath="//button[@id='id_master_search']")
	WebElement Search;

	@FindBy(xpath="//button[@id='id_master_sendtoverify']")
	WebElement SendToVerify;

	@FindBy(xpath="//img[@id='id_emp_photo']")
	WebElement emp_photo;

	@FindBy(xpath="//a[@id='id_logout']")
	WebElement logout;

	@FindBy(xpath="//button[@id='btnAuthorize']")
	WebElement Authorize;

	@FindBy(xpath="//button[@id='btnVerify']")
	WebElement Verify;

	@FindBy(xpath="//*[@id=\"row0\"]/td[6]/button")
	WebElement Nom_View;

	@FindBy(xpath="//* [@onclick='verify()']")
	WebElement Nom_Verify;	

	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[4]/button[contains(text(),'View')]")
	WebElement Witness_View;

	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[5]/button[contains(text(),'Verify')]")
	WebElement Witness_Verify;

	@FindBy(xpath="//button[@id='id_master_authorize']")
	WebElement Authorized;

	@FindBy(xpath="//button[@id='id_skip_2']")
	WebElement Interest_skip;

	@FindBy(xpath="//button[@id='id_skip_4']")
	WebElement Joint_skip;

	@FindBy(xpath="//button[@id='id_skip_5']")
	WebElement Nom_skip;

	@FindBy(xpath="//button[@id='id_skip_6']")
	WebElement Wit_skip;

	@FindBy(xpath="//button[@id='id_skip_3']")
	WebElement Payin_skip;

	@FindBy(xpath="//input[@id='id_txtAccountNumber']")
	WebElement Cash_Account_No;

	@FindBy(xpath="//input[@id='id_txtAccountNumber']")
	WebElement Transfer_Account_No;

	@FindBy(xpath="//select[@id='id_activitySubTypeId']")
	WebElement Cash_Tranfer_Activity;

	@FindBy(xpath="//select[@id='id_activitySubTypeId']")
	WebElement Transaction_Nature;

	@FindBy(xpath="//input[@id='id_txtInstrumentNumber']")
	WebElement Instrument_No;

	@FindBy(xpath="//button[@id='id_button_add_cash']")
	WebElement Add_Cash;

	@FindBy(xpath="//button[@id='btnSubmitCash']")
	WebElement Submit_Cash;

	@FindBy(xpath="//a[contains(text(),'Pending Denominations')]")
	WebElement Pending_Denominations;

	@FindBy(xpath="//select[@id='id_txn_nature']")
	WebElement transaction_Nature;

	@FindBy(xpath="//button[@id='id_search_pending_denominations']")
	WebElement Cash_Search;

	@FindBy(xpath="//*[@id=\"id_result\"]/table/tbody/tr[1]/td[6]/button")
	WebElement Add_Denominations;

	@FindBy(xpath="//input[@id='id_Deno1']")
	WebElement New_quantity;

	@FindBy(xpath="//input[@id='id_Deno0_Total']")
	WebElement old_quantity;

	@FindBy(xpath="//button[@id='id_submit_token_denoms']")
	WebElement Submit_denom;

	@FindBy(xpath="//li[@id='id_authorization_cash']/a[contains(text(),'Authorization')]")
	WebElement Authorization_cash;

	@FindBy(xpath="//a[@id='reference_no0']")
	WebElement Cash_link;

	@FindBy(xpath="//button[@id='id_authorizeBtn']")
	WebElement Cash_Transfer_Auth;

	@FindBy(xpath="//input[@id='id_txtTxnDate']")
	WebElement Trans_date;

	@FindBy(xpath="//button[@id='btnAddTransfer']")
	WebElement Add_Transfer;

	@FindBy(xpath="//input[@id='id_txtAmount']")
	WebElement Transfer_Amount;

	@FindBy(xpath="//button[@id='btnSubmitTransfer']")
	WebElement SubmitTransfer;

	@FindBy(xpath="//li[@id='id_authorization_transfer']/a[contains(text(),'Authorization')]")
	WebElement Authorization_Transfer;

	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[1]/a")
	WebElement Ref_no_Transfer;

	@FindBy(xpath="//select[@id='id_tdMasterType']")
	WebElement TD_MasterType;

	@FindBy(xpath="//input[@id='id_CustomerId']")
	WebElement Bulk_Customer_id;

	@FindBy(xpath="//input[@id='id_CustomerName']")
	WebElement Bulk_CustomerName;

	@FindBy(xpath="//input[@id='id_TotalAmount']")
	WebElement Bulk_TD_Amount;

	@FindBy(xpath="//button[@id='id_btnAdditionalInput']")
	WebElement Bulk_Submit;

	@FindBy(xpath="//input[@id='id_amt']")
	WebElement Bulk_Amount;

	@FindBy(xpath="//select[@id='id_accountType']")
	WebElement AccountType;

	@FindBy(xpath="//input[@id='id_depositTenureDays']")
	WebElement Deposit_Tenure_Days;

	@FindBy(xpath="//input[@id='id_depositTenureMonths']")
	WebElement Deposit_Tenure_Month;

	@FindBy(xpath="//input[@id='id_depositTenureYears']")
	WebElement Deposit_Tenure_Year;

	@FindBy(xpath="//button[@id='id_btnAddRow']")
	WebElement Add_Bulk;

	@FindBy(xpath="//button[@id='id_submit']")
	WebElement submit;

	@FindBy(xpath="//span[contains(text(),'Maturity Payout')]")
	WebElement Maturity_Payout;

	@FindBy(xpath="//select[@id='id_payout_mode']")
	WebElement Payout_Mode;

	@FindBy(xpath="//input[@id='id_accountno']")
	WebElement Account_no;

	@FindBy(xpath="//input[@id='id_branch_name']")
	WebElement Branch_Name;

	@FindBy(xpath="//button[@id='id_SubmitMaturityPayout']")
	WebElement SubmitMaturity;

	@FindBy(xpath="//button[@class='btn btn-primary can-perform-verify']")
	WebElement Bulk_Verify;

	@FindBy(xpath="//*[@id='id_btnAddRow']")
	WebElement Add_Button;

	@FindBy(xpath="//*[@class='card col-md-6']")
	WebElement AccountNo_Table;

	@FindBy(xpath="//*[@id='id_txtAccountNumber']")
	WebElement Transfer_Acc_No;

	@FindBy(xpath="//*[@id='id_activitySubTypeId']")
	WebElement Tranfer_Activity;

	@FindBy(xpath="//*[@id='btnAddTransfer']")
	WebElement Add_Transfer_Button;

	@FindBy(xpath="//*[@id='id_txtAmount']")
	WebElement Amount_Bulk;

	@FindBy(xpath="//*[@id='btnSubmitTransfer']")
	WebElement Submit_transfer;

	@FindBy(xpath="//*[@id='id_closeModal']")
	WebElement Close_Transfer;

	@FindBy(xpath="//*[@id=\"divFormRow1\"]")
	WebElement block;

	@FindBy(xpath="//*[@data-originaltext='Authorization']")
	WebElement authTab;

	@FindBy(xpath="//*[@onclick='gettxnrefno(48394)']")
	WebElement refno;

	@FindBy(xpath="//*[@id='id_txtRefNo']")
	WebElement reffnomaker;

	@FindBy(xpath="//*[@id='id_authorizeBtn']")
	WebElement authbutton;

	@FindBy(xpath="//*[contains(@id,'reference_no')]")
	WebElement reffno;

	@FindBy(xpath="//*[@id='id_list_txn_ref_no']")
	WebElement reffno_textbox;

	@FindBy(xpath="//*[@id='btnSubmit']")
	WebElement search_reffNo;


	public TDCreationPage()
	{
		PageFactory.initElements(driver,this);
	}

	//------------------------------//TD Account (Auto PayIn)//-------------------------------------//

	public void createNewTDAccount() throws Exception
	{
		Select dropdown = new Select(TDdropdownElement);
		Thread.sleep(2000);
		dropdown.selectByIndex(1);
		Thread.sleep(2000);
		NewAccount.click();
		Thread.sleep(3000);
		fis = new FileInputStream(location);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("TD");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(1).getLastCellNum();
		for (int i=1;i<=rowcount;i++)
		{
			row = sheet.getRow(i);
			for(int j=0;j<colcount;j++)
			{
				//XSSFCell cell=(XSSFCell) row.getCell(j);
				Long cust_id=(long) row.getCell(0).getNumericCellValue();
				Customer_id.sendKeys(String.valueOf(String.valueOf(cust_id)));
				Master_search.click();
				Thread.sleep(3000);
				Select td_Product_Code=new Select(TD_Product_Code);
				td_Product_Code.selectByIndex(2);
				Long term_Deposit_Amount=(long) row.getCell(1).getNumericCellValue();
				Term_Deposit_Amount.sendKeys(String.valueOf(String.valueOf(term_Deposit_Amount)));
				Term_Deposit_Tenure_Month.sendKeys(Keys.BACK_SPACE);
				int term_Deposit_Tenure_Month=(int) row.getCell(2).getNumericCellValue();
				Term_Deposit_Tenure_Month.sendKeys(String.valueOf(String.valueOf(term_Deposit_Tenure_Month)));
				Select customer_Profile=new Select(customerProfile);
				customer_Profile.selectByIndex(1);
				//customer_Profile.selectByVisibleText("Business");
				Select operating_Instruction=new Select(Operating_Instruction);
				operating_Instruction.selectByIndex(1);
				Thread.sleep(3000);
				//operating_Instruction.selectByVisibleText("Self");
				SubmitPrimaryDetail.click();
				Thread.sleep(5000);
				//util.handle_popop();
				New_TD_Account=Error_message_master.getText();
				New_TD_Account=New_TD_Account.replace("Account created successfully. Account No:","");
				New_TD_Account=New_TD_Account.replace("x", "");
				New_TD_Account=New_TD_Account.replace("Success", "");
				New_TD_Account=New_TD_Account.trim();
				System.out.println(New_TD_Account);
				CloseErrorMessage.click();
				Thread.sleep(3000);
				Deposit_Detail.click();
				Thread.sleep(2000);
				SubmitDepositDetail.click();
				Thread.sleep(2000);
				CloseErrorMessage.click();
				Thread.sleep(2000);
				Nominee_Detail.click();
				Thread.sleep(2000);
				Long cust_id2=(long) row.getCell(3).getNumericCellValue();
				Customer_id.sendKeys(String.valueOf(String.valueOf(cust_id2)));
				System.out.println("sent cust id");
				Thread.sleep(2000);
				Master_search.click();
				Thread.sleep(2000);
				Select relation=new Select(Relation);
				relation.selectByIndex(1);
				Nominee_Add.click();
				Thread.sleep(2000);
				Nominee_Submit.click();
				Thread.sleep(5000);
				CloseErrorMessage.click();
				Thread.sleep(2000);
				Witness_Detail.click();
				Thread.sleep(3000);
				Long cust_id3=(long) row.getCell(4).getNumericCellValue();
				WitnessCustomer_id.sendKeys(String.valueOf(String.valueOf(cust_id3)));
				Master_search.click();
				Thread.sleep(2000);
				Witness_Add.click();
				Thread.sleep(2000);
				Witness_Submit.click();
				Thread.sleep(2000);
				CloseErrorMessage.click();
				Thread.sleep(2000);
				Payin_Detail.click();
				Thread.sleep(3000);
				String AccNo=(String) row.getCell(5).getStringCellValue();
				Account_No.sendKeys(String.valueOf(String.valueOf(AccNo)));
				Branch.click();
				Thread.sleep(2000);
				Select activity=new Select(Activity);
				activity.selectByVisibleText("CASA_DEBIT");
				Instrument_Number.sendKeys("0");
				Payin_Submit.click();
				Thread.sleep(3000);
				CloseErrorMessage.click();
				Thread.sleep(2000);
				//SendtoVerify.click();

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();",SendtoVerify);
			
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

	//------------------------------//Authorize TD Account//-------------------------------------//

	public void authNewTDAccount() throws Exception
	{

		Select dropdown1 = new Select(TDdropdownElement);
		Thread.sleep(2000);
		dropdown1.selectByIndex(1);
		Authorize.click();
		Thread.sleep(4000);
		WebElement Account_no=driver.findElement(By.xpath("//select[@id='id_optMasterAccountNumber']"));
		//Account_no.click();
		List<WebElement> dropdown=Account_no.findElements(By.tagName("option"));
		for(int i=0;i<dropdown.size();i++)
		{
			//System.out.println(dropdown.get(i).getText());
			if(dropdown.get(i).getText().equals(New_TD_Account))
			{
				dropdown.get(i).click();
				break;
			}
		}
		Thread.sleep(10000);
		//util.handle_popop();
		Thread.sleep(2000);
		Verify.click();
		Thread.sleep(5000);
		//util.handle_popop();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Deposit_Detail.click();
		Thread.sleep(3000);
		Verify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Nominee_Detail.click();
		Thread.sleep(3000);
		Nom_View.click();
		Thread.sleep(2000);
		Nom_Verify.click();
		Thread.sleep(3000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Witness_Detail.click();
		Thread.sleep(3000);
		Witness_View.click();
		Thread.sleep(2000);
		Witness_Verify.click();
		Thread.sleep(3000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Payin_Detail.click();
		Thread.sleep(3000);
		Verify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Authorized.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}


	//------------------------------//RD Account//-------------------------------------//

	public void NewRDAccount () throws InterruptedException, IOException
	{

		Select dropdown = new Select(TDdropdownElement);
		Thread.sleep(2000);
		dropdown.selectByIndex(1);
		Thread.sleep(2000);
		NewAccount.click();
		Thread.sleep(3000);
		fis = new FileInputStream(location);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("RD");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(1).getLastCellNum();
		for (int i=1;i<=rowcount;i++)
		{
			row = sheet.getRow(i);
			for(int j=0;j<colcount;j++)
			{
				//	XSSFCell cell=(XSSFCell) row.getCell(j);
				Long cust_id=(long) row.getCell(0).getNumericCellValue();
				Customer_id.sendKeys(String.valueOf(String.valueOf(cust_id)));
				Master_search.click();
				Thread.sleep(3000);
				Select td_Product_Code=new Select(TD_Product_Code);
				//	td_Product_Code.selectByIndex(2);
				td_Product_Code.selectByVisibleText("4024-104121 - RECURRING DEPOSIT - OM");
				Long term_Deposit_Amount=(long) row.getCell(1).getNumericCellValue();
				Term_Deposit_Amount.sendKeys(String.valueOf(String.valueOf(term_Deposit_Amount)));
				Term_Deposit_Tenure_Month.sendKeys(Keys.BACK_SPACE);
				int term_Deposit_Tenure_Month=(int) row.getCell(2).getNumericCellValue();
				Term_Deposit_Tenure_Month.sendKeys(String.valueOf(String.valueOf(term_Deposit_Tenure_Month)));
				Select customer_Profile=new Select(customerProfile);
				customer_Profile.selectByIndex(1);
				//customer_Profile.selectByVisibleText("Business");
				Select operating_Instruction=new Select(Operating_Instruction);
				operating_Instruction.selectByIndex(1);
				Thread.sleep(3000);
				//operating_Instruction.selectByVisibleText("Self");
				SubmitPrimaryDetail.click();
				Thread.sleep(5000);
				//util.handle_popop();
				New_RD_Account=Error_message_master.getText();
				New_RD_Account=New_RD_Account.replace("Account created successfully. Account No:","");
				New_RD_Account=New_RD_Account.replace("x", "");
				New_RD_Account=New_RD_Account.replace("Success", "");
				New_RD_Account=New_RD_Account.trim();
				System.out.print("RD account Number : ");
				System.out.print(New_RD_Account);
				CloseErrorMessage.click();
				Thread.sleep(3000);
				Deposit_Detail.click();
				Thread.sleep(2000);
				SubmitDepositDetail.click();
				Thread.sleep(2000);
				CloseErrorMessage.click();
				Thread.sleep(2000);
				Nominee_Detail.click();
				Thread.sleep(2000);
				Long cust_id2=(long) row.getCell(3).getNumericCellValue();
				Customer_id.sendKeys(String.valueOf(String.valueOf(cust_id2)));
				System.out.println(" sent cust id");
				Thread.sleep(2000);
				Master_search.click();
				Thread.sleep(2000);
				Select relation=new Select(Relation);
				relation.selectByIndex(1);
				//relation.selectByVisibleText("Brother");
				Nominee_Add.click();
				Thread.sleep(2000);
				Nominee_Submit.click();
				Thread.sleep(5000);
				CloseErrorMessage.click();
				Thread.sleep(2000);
				Witness_Detail.click();
				Thread.sleep(3000);
				Long cust_id3=(long) row.getCell(4).getNumericCellValue();
				WitnessCustomer_id.sendKeys(String.valueOf(String.valueOf(cust_id3)));
				Master_search.click();
				Thread.sleep(2000);
				Witness_Add.click();
				Thread.sleep(2000);
				Witness_Submit.click();
				Thread.sleep(2000);
				CloseErrorMessage.click();
				Thread.sleep(2000);
				Payin_Detail.click();
				Thread.sleep(3000);
				SkipPayin.click();
				Thread.sleep(4000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();",SendtoVerify);
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

	//------------------------------//Authorize RD Account//-------------------------------------//

	public void authNewRDAccount() throws Exception
	{

		Select dropdown1 = new Select(TDdropdownElement);
		Thread.sleep(2000);
		dropdown1.selectByIndex(1);
		Authorize.click();
		Thread.sleep(4000);
		WebElement Account_no=driver.findElement(By.xpath("//select[@id='id_optMasterAccountNumber']"));
		//Account_no.click();
		List<WebElement> dropdown=Account_no.findElements(By.tagName("option"));
		for(int i=0;i<dropdown.size();i++)
		{
			//System.out.println(dropdown.get(i).getText());
			if(dropdown.get(i).getText().equals(New_RD_Account))
			{
				dropdown.get(i).click();
				break;
			}
		}
		Thread.sleep(10000);
		//util.handle_popop();
		Thread.sleep(2000);
		Verify.click();
		Thread.sleep(5000);
		//util.handle_popop();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Deposit_Detail.click();
		Thread.sleep(3000);
		Verify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Nominee_Detail.click();
		Thread.sleep(3000);
		Nom_View.click();
		Thread.sleep(2000);
		Nom_Verify.click();
		Thread.sleep(3000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Witness_Detail.click();
		Thread.sleep(3000);
		Witness_View.click();
		Thread.sleep(2000);
		Witness_Verify.click();
		Thread.sleep(3000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Authorized.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}


	//------------------------------//RD Cash Payin//-------------------------------------//

	public void RDcashpayin(String inst_no,String denom) throws Exception
	{
		Cash_Account_No.sendKeys(New_RD_Account);
		Transaction_Nature.click();
		Thread.sleep(5000);
		//util.handle_popop();
		//Thread.sleep(2000);
		Select cash_Activity=new Select(Cash_Tranfer_Activity);
		//cash_Activity.selectByVisibleText("TD_PAYIN");
		cash_Activity.selectByIndex(2);
		Instrument_No.sendKeys(inst_no);
		Add_Cash.click();
		Thread.sleep(2000);
		Submit_Cash.click();
		Thread.sleep(3000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Pending_Denominations.click();
		Thread.sleep(3000);
		Select trans_nature=new Select(transaction_Nature);
		trans_nature.selectByVisibleText("Credit");
		Cash_Search.click();
		Thread.sleep(3000);
		Add_Denominations.click();
		Thread.sleep(2000);
		New_quantity.sendKeys(denom);
		old_quantity.click();
		Thread.sleep(2000);
		Submit_denom.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}

	//------------------------------//Authorize RD Cash Paying//-------------------------------------//

	public void authRDcashpayin() throws Exception
	{
		Authorization_cash.click();
		Thread.sleep(3000);
		Cash_link.click();
		Thread.sleep(3000);
		//util.handle_popop();
		Cash_Transfer_Auth.click();
		util.handle_popop1();
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}

	//------------------------------//Bulk TD Creation//-------------------------------------//

	public void creteBulkTDAccount() throws Exception

	{
		Select dropdown = new Select(TDdropdownElement);
		Thread.sleep(2000);
		dropdown.selectByIndex(2);
		Thread.sleep(2000);
		NewAccount.click();
		Thread.sleep(3000);
		fis = new FileInputStream(location);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("BulkTD");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(1).getLastCellNum();
		for (int i=1;i<=rowcount;i++)
		{
			row = sheet.getRow(i);
			for(int j=0;j<colcount;j++)
			{
				
				Long custmore_id=(long) row.getCell(0).getNumericCellValue();
				Bulk_Customer_id.sendKeys(String.valueOf(String.valueOf(custmore_id)));
				Select td_Product_Code=new Select(TD_Product_Code);
				td_Product_Code.selectByIndex(3);
				Long TotalAmount=(long) row.getCell(1).getNumericCellValue();
				Bulk_TD_Amount.sendKeys(String.valueOf(String.valueOf(TotalAmount)));
				Bulk_Submit.click();
				Add_Bulk.click();
				Thread.sleep(2000);


				Long Tenure1=(long) row.getCell(2).getNumericCellValue();
				Deposit_Tenure_Month.sendKeys(String.valueOf(String.valueOf(Tenure1)));
				Long Amount1=(long) row.getCell(3).getNumericCellValue();
				Bulk_Amount.sendKeys(String.valueOf(String.valueOf(Amount1)));
				Thread.sleep(4000);
				driver.findElement(By.xpath("//*[@class='bsg-form__body p-a-4']")).click();
				Add_Button.click();
				Thread.sleep(4000);

				Long Tenure2=(long) row.getCell(4).getNumericCellValue();
				Deposit_Tenure_Month.sendKeys(String.valueOf(String.valueOf(Tenure2)));
				Long Amount2=(long) row.getCell(5).getNumericCellValue();
				Bulk_Amount.sendKeys(String.valueOf(String.valueOf(Amount2)));
				Thread.sleep(4000);
				driver.findElement(By.xpath("//*[@class='bsg-form__body p-a-4']")).click();
				Add_Button.click();
				Thread.sleep(4000);

				Long Tenure3=(long) row.getCell(6).getNumericCellValue();
				Deposit_Tenure_Month.sendKeys(String.valueOf(String.valueOf(Tenure3)));
				Long Amount3=(long) row.getCell(7).getNumericCellValue();
				Bulk_Amount.sendKeys(String.valueOf(String.valueOf(Amount3)));
				Thread.sleep(4000);
				driver.findElement(By.xpath("//*[@class='bsg-form__body p-a-4']")).click();
				Add_Button.click();
				Thread.sleep(2000);
				submit.click();
				Thread.sleep(3000);
				CloseErrorMessage.click();
				Thread.sleep(2000);

				Primary_Applicant_Details.click();
				Thread.sleep(3000);
				Select customer_Profile=new Select(customerProfile);
				//customer_Profile.selectByIndex(1);
				customer_Profile.selectByVisibleText("PROFESSIONAL");
				Select operating_Instruction=new Select(Operating_Instruction);
				//operating_Instruction.selectByVisibleText("Self");
				operating_Instruction.selectByIndex(1);
				SubmitPrimaryDetail.click();
				Thread.sleep(5000);
				//util.handle_popop();
				//Thread.sleep(2000);
				CloseErrorMessage.click();
				Thread.sleep(3000);


				Deposit_Detail.click();
				Thread.sleep(3000);

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();",SubmitDepositDetail);
				//SubmitDepositDetail.click();
				Thread.sleep(2000);
				CloseErrorMessage.click();
				Thread.sleep(2000);


				Maturity_Payout.click();
				Thread.sleep(2000);
				Select payout_Mode=new Select(Payout_Mode);
				payout_Mode.selectByIndex(1);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@class='bsg-form__body p-a-4']")).click();
				Thread.sleep(2000);
				String AccNo=(String) row.getCell(8).getStringCellValue();
				Account_no.sendKeys(String.valueOf(String.valueOf(AccNo)));
				Thread.sleep(2000);
				Branch_Name.click();
				Thread.sleep(5000);
				Select activity=new Select(Activity);
				activity.selectByIndex(1);
				//activity.selectByVisibleText("CASA CREDIT");
				SubmitMaturity.click();
				Thread.sleep(2000);
				CloseErrorMessage.click();
				Thread.sleep(2000);
				Joint_Holder_Details.click();
				Thread.sleep(2000);
				Joint_skip.click();
				Thread.sleep(4000);
				js.executeScript("arguments[0].click();",CloseErrorMessage);
				//	CloseErrorMessage.click();
				Nominee_Detail.click();
				Thread.sleep(3000);
				Nom_skip.click();
				Thread.sleep(4000);
				New_Bulk_TD_Account=Error_message_master.getText();
				New_Bulk_TD_Account=New_Bulk_TD_Account.replaceAll("[a-zA-Z]","");
				New_Bulk_TD_Account=New_Bulk_TD_Account.trim();
				System.out.println(New_Bulk_TD_Account);
				js.executeScript("arguments[0].click();",CloseErrorMessage);
				Thread.sleep(2000);
				Witness_Detail.click();
				Thread.sleep(3000);
				Wit_skip.click();
				Thread.sleep(4000);
				js.executeScript("arguments[0].click();",CloseErrorMessage);
				Thread.sleep(2000);
				Payin_Detail.click();
				Thread.sleep(5000);
				Payin_skip.click();
				Thread.sleep(4000);
				js.executeScript("arguments[0].click();",CloseErrorMessage);
				Thread.sleep(2000);
				SendToVerify.click();
				Thread.sleep(4000);
				js.executeScript("arguments[0].click();",CloseErrorMessage);
				Thread.sleep(2000);
				emp_photo.click();
				Thread.sleep(2000);
				logout.click();
				Thread.sleep(3000);
			}
		}
	}

	//------------------------------//Authorize Bulk TD Creation//-------------------------------------//

	public void authCretedBulkTDAccount() throws Exception
	{
		Select dropdown1 = new Select(TDdropdownElement);
		Thread.sleep(2000);
		dropdown1.selectByIndex(2);
		Thread.sleep(2000);
		Authorize.click();
		Thread.sleep(5000);
		WebElement Account_no=driver.findElement(By.xpath("//select[@id='id_optMasterAccountNumber']"));
		List<WebElement> dropdown=Account_no.findElements(By.tagName("option"));
		for(int i=0;i<dropdown.size();i++)
		{
			if(dropdown.get(i).getText().equals(New_Bulk_TD_Account))
			{
				dropdown.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		Bulk_Verify.click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",CloseErrorMessage);
		Thread.sleep(2000);
		Primary_Applicant_Details.click();
		Thread.sleep(3000);
		Verify.click();
		Thread.sleep(5000);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();",CloseErrorMessage);
		Thread.sleep(2000);
		Deposit_Detail.click();
		Thread.sleep(3000);
		Verify.click();
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();",CloseErrorMessage);
		Thread.sleep(2000);
		Maturity_Payout.click();
		Thread.sleep(3000);
		Verify.click();
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();",CloseErrorMessage);
		Thread.sleep(2000);
		Authorized.click();
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();",CloseErrorMessage);
		Thread.sleep(2000);

		New_Bulk_TD_Accounts=AccountNo_Table.getText();
		Pattern pattern = Pattern.compile("\\b\\d{10,20}\\b");
		Matcher matcher = pattern.matcher(New_Bulk_TD_Accounts);
		StringBuilder extractedNumbers = new StringBuilder();
		while (matcher.find()) {
			extractedNumbers.append(matcher.group()).append(" ");
		}
		if (extractedNumbers.length() > 0) {
			extractedNumbers.setLength(extractedNumbers.length() - 1);
			System.out.println("Bulk TD Account Numbers: " + extractedNumbers);
		}
		System.out.println("New TD :"+New_Bulk_TD_Account);

		Thread.sleep(5000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);

	}

	public void bulkTDTransfer() throws InterruptedException
	{
		Transfer_Acc_No.sendKeys(New_Bulk_TD_Account);
		Thread.sleep(2000);
		block.click();
		Thread.sleep(1000);
		Select Tranfer_activity = new Select(Tranfer_Activity);
		Tranfer_activity.selectByIndex(2);
		Instrument_No.sendKeys("000");
		Add_Transfer_Button.click();
		Thread.sleep(3000);
		String AccNo=(String) row.getCell(8).getStringCellValue();
		Transfer_Acc_No.sendKeys(String.valueOf(String.valueOf(AccNo)));
		Thread.sleep(2000);
		block.click();
		Thread.sleep(1000);
		Tranfer_activity.selectByIndex(1);
		Thread.sleep(2000);
		Long Amount1=(long) row.getCell(3).getNumericCellValue();
		Amount_Bulk.sendKeys(String.valueOf(String.valueOf(Amount1)));
		Instrument_No.sendKeys("000");
		Thread.sleep(2000);
		Add_Transfer_Button.click();
		Thread.sleep(2000);
		Submit_transfer.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		Refference_No=reffnomaker.getText();
		Thread.sleep(2000);
		System.out.println("Refference No :"+Refference_No);
		Thread.sleep(2000);
		Close_Transfer.click();
		Thread.sleep(4000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);

	}

	public void authbulkTDTransfer() throws InterruptedException
	{
		authTab.click();
		Thread.sleep(2000);
		reffno_textbox.sendKeys(Refference_No);
		Thread.sleep(2000);
		search_reffNo.click();
		Thread.sleep(2000);
		reffno.click();
		Thread.sleep(2000);
		authbutton.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		close.click();
		Thread.sleep(4000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();

	}






































	/*public void createNewTDAccount(String cust_id1,String amount,String tenure,String cust_id2,String cust_id3,String Acc_no,String ins_no,
			String narr) throws Exception
	{
		NewAccount.click();
		Thread.sleep(3000);
		Customer_id.sendKeys(cust_id1);
		Master_search.click();
		Thread.sleep(3000);
		//util.handle_popop();
		Select td_Product_Code=new Select(TD_Product_Code);
		td_Product_Code.selectByIndex(2);
		//td_Product_Code.selectByVisibleText("4016-Fixed Deposit Receipt-Yearly");
		Term_Deposit_Amount.sendKeys(amount);
		Term_Deposit_Tenure_Month.sendKeys(Keys.BACK_SPACE);
		Term_Deposit_Tenure_Month.sendKeys(tenure);
		Select customer_Profile=new Select(customerProfile);
		customer_Profile.selectByIndex(1);
		//customer_Profile.selectByVisibleText("Business");
		Select operating_Instruction=new Select(Operating_Instruction);
		operating_Instruction.selectByIndex(1);
		//operating_Instruction.selectByVisibleText("Self");
		SubmitPrimaryDetail.click();
		Thread.sleep(5000);
		//util.handle_popop();
		New_TD_Account=Error_message_master.getText();
		New_TD_Account=New_TD_Account.replace("Account created successfully. Account No:","");
		New_TD_Account=New_TD_Account.replace("x", "");
		New_TD_Account=New_TD_Account.trim();
		System.out.println(New_TD_Account);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		Deposit_Detail.click();
		Thread.sleep(2000);
		SubmitDepositDetail.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Nominee_Detail.click();
		Thread.sleep(2000);
		Customer_id.sendKeys(cust_id2);
		Master_search.click();
		Thread.sleep(2000);
		Select relation=new Select(Relation);
		relation.selectByIndex(1);
		//relation.selectByVisibleText("Brother");
		Nominee_Add.click();
		Thread.sleep(2000);
		Nominee_Submit.click();
		Thread.sleep(5000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Witness_Detail.click();
		Thread.sleep(3000);
		Witness_Customer_id.sendKeys(cust_id3);
		Master_search.click();
		Thread.sleep(2000);
		Witness_Add.click();
		Thread.sleep(2000);
		Witness_Submit.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Payin_Detail.click();
		Thread.sleep(3000);
		Account_No.sendKeys(Acc_no);
		Branch.click();
		Thread.sleep(2000);
		Select activity=new Select(Activity);
		activity.selectByVisibleText("CASA_DEBIT");
		Instrument_Number.sendKeys(ins_no);
		Narration.sendKeys(narr);
		Payin_Submit.click();
		Thread.sleep(3000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		TD_Creation.click();
		Thread.sleep(3000);
		NewAccount.click();
		Thread.sleep(5000);
		Pri_Account_No.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		Pri_Account_No.sendKeys(New_TD_Account);
		Thread.sleep(15000);
		Search.click();
		Thread.sleep(10000);
		//util.handle_popop();
		//Thread.sleep(5000);
		SendToVerify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}*/


	//TD payin through cash

	public void tdThroughCash(String cust_id1,String amount,String tenure,String cust_id2 ) throws Exception
	{
		NewAccount.click();
		Thread.sleep(3000);
		Customer_id.sendKeys(cust_id1);
		Master_search.click();
		Thread.sleep(3000);
		//util.handle_popop();
		Select td_Product_Code=new Select(TD_Product_Code);
		//td_Product_Code.selectByVisibleText("4014-Fixed Deposit Receipt-Quaterly");
		td_Product_Code.selectByIndex(2);
		Term_Deposit_Amount.sendKeys(amount);
		Term_Deposit_Tenure_Days.sendKeys(Keys.BACK_SPACE);
		Term_Deposit_Tenure_Days.sendKeys(tenure);
		Rate_Of_Interest.click();
		Thread.sleep(3000);
		Select customer_Profile=new Select(customerProfile);
		customer_Profile.selectByIndex(1);
		//customer_Profile.selectByVisibleText("Service");
		Select operating_Instruction=new Select(Operating_Instruction);
		operating_Instruction.selectByIndex(1);
		//operating_Instruction.selectByVisibleText("Self");
		SubmitPrimaryDetail.click();
		Thread.sleep(5000);
		//util.handle_popop();
		New_Cash_TD_Account=Error_message_master.getText();
		New_Cash_TD_Account=New_Cash_TD_Account.replace("Account created successfully. Account No:","");
		New_Cash_TD_Account=New_Cash_TD_Account.replace("x", "");
		New_Cash_TD_Account=New_Cash_TD_Account.trim();
		System.out.println(New_Cash_TD_Account);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		Deposit_Detail.click();
		Thread.sleep(2000);
		SubmitDepositDetail.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Nominee_Detail.click();
		Thread.sleep(2000);
		Customer_id.sendKeys(cust_id2);
		Master_search.click();
		Thread.sleep(2000);
		Select relation=new Select(Relation);
		relation.selectByIndex(2);
		//relation.selectByVisibleText("Uncle");
		Nominee_Add.click();
		Thread.sleep(2000);
		Nominee_Submit.click();
		Thread.sleep(5000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Witness_Detail.click();
		Thread.sleep(3000);
		Wit_skip.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Payin_Detail.click();
		Thread.sleep(3000);
		Payin_skip.click();
		CloseErrorMessage.click();
		Thread.sleep(2000);
		SendToVerify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}

	public void authCashTDAccount() throws Exception
	{
		Authorize.click();
		Thread.sleep(5000);
		WebElement Account_no=driver.findElement(By.xpath("//select[@id='id_optMasterAccountNumber']"));
		List<WebElement> dropdown=Account_no.findElements(By.tagName("option"));
		for(int i=0;i<dropdown.size();i++)
		{
			//System.out.println(dropdown.get(i).getText());
			if(dropdown.get(i).getText().equals(New_Cash_TD_Account))
			{
				dropdown.get(i).click();
				break;
			}
		}
		Thread.sleep(5000);
		//util.handle_popop();
		Thread.sleep(3000);
		Verify.click();
		Thread.sleep(3000);
		//util.handle_popop();
		Thread.sleep(3000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Deposit_Detail.click();
		Thread.sleep(3000);
		Verify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Nominee_Detail.click();
		Thread.sleep(3000);
		Nom_View.click();
		Thread.sleep(2000);
		Nom_Verify.click();
		Thread.sleep(3000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Authorized.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}





	//TD payin through Transfer
	public void transferTDPayin(String cust_id1, String amount, String tenure) throws Exception
	{
		NewAccount.click();
		Thread.sleep(3000);
		Customer_id.sendKeys(cust_id1);
		Master_search.click();
		Thread.sleep(3000);
		//util.handle_popop();
		Select td_Product_Code=new Select(TD_Product_Code);
		td_Product_Code.selectByIndex(2);
		//td_Product_Code.selectByVisibleText("4008-Fixed Deposit Receipt-Monthly");
		Term_Deposit_Amount.sendKeys(amount);
		Term_Deposit_Tenure_Month.sendKeys(Keys.BACK_SPACE);
		//Term_Deposit_Tenure_Year.sendKeys(Keys.BACK_SPACE);
		Term_Deposit_Tenure_Month.sendKeys(tenure);
		Rate_Of_Interest.click();
		Thread.sleep(3000);
		//Term_Deposit_Tenure_Year.sendKeys(tenure);
		Select customer_Profile=new Select(customerProfile);
		customer_Profile.selectByIndex(1);
		//customer_Profile.selectByVisibleText("Service");
		Select operating_Instruction=new Select(Operating_Instruction);
		operating_Instruction.selectByIndex(1);
		//operating_Instruction.selectByVisibleText("Self");
		SubmitPrimaryDetail.click();
		Thread.sleep(5000);
		//util.handle_popop();
		New_Transfer_TD_Account=Error_message_master.getText();
		New_Transfer_TD_Account=New_Transfer_TD_Account.replace("Account created successfully. Account No:","");
		New_Transfer_TD_Account=New_Transfer_TD_Account.replace("x", "");
		New_Transfer_TD_Account=New_Transfer_TD_Account.trim();
		System.out.println(New_Transfer_TD_Account);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		Deposit_Detail.click();
		Thread.sleep(2000);
		SubmitDepositDetail.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		/*Interest_Payout.click();
		Thread.sleep(2000);
		Interest_skip.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);*/
		Nominee_Detail.click();
		Thread.sleep(3000);
		Nom_skip.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Witness_Detail.click();
		Thread.sleep(3000);
		Wit_skip.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Payin_Detail.click();
		Thread.sleep(3000);
		Payin_skip.click();
		CloseErrorMessage.click();
		Thread.sleep(2000);
		SendToVerify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(5000);
	}

	public void authTransferTDPayin() throws Exception
	{
		Authorize.click();
		Thread.sleep(3000);
		WebElement Account_no=driver.findElement(By.xpath("//select[@id='id_optMasterAccountNumber']"));
		List<WebElement> dropdown=Account_no.findElements(By.tagName("option"));
		for(int i=0;i<dropdown.size();i++)
		{
			//System.out.println(dropdown.get(i).getText());
			if(dropdown.get(i).getText().equals(New_Transfer_TD_Account))
			{
				dropdown.get(i).click();
				break;
			}
		}
		Thread.sleep(5000);
		//util.handle_popop();
		//Thread.sleep(3000);
		Verify.click();
		Thread.sleep(3000);
		//util.handle_popop();
		//Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Deposit_Detail.click();
		Thread.sleep(3000);
		Verify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Authorized.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(5000);
	}

	public void  payinThroughTransfer(String inst_no,String account_no,String amount,String inst_num) throws Exception
	{
		Transfer_Account_No.sendKeys(New_Transfer_TD_Account);
		Trans_date.click();
		Thread.sleep(10000);
		//util.handle_popop();
		//Thread.sleep(2000);
		Select transfer_Activity=new Select(Cash_Tranfer_Activity);
		//transfer_Activity.selectByVisibleText("TD_PAYIN");
		transfer_Activity.selectByIndex(2);
		Instrument_No.sendKeys(inst_no);
		Add_Transfer.click();
		Thread.sleep(3000);
		Transfer_Account_No.sendKeys(account_no);
		Trans_date.click();
		Thread.sleep(5000);
		//util.handle_popop();
		Thread.sleep(2000);
		Select transfer_Activity1=new Select(Cash_Tranfer_Activity);
		transfer_Activity1.selectByVisibleText("CASA_DEBIT");
		Transfer_Amount.sendKeys(amount);
		Instrument_No.sendKeys(inst_num);
		Trans_date.click();
		Thread.sleep(3000);
		driver.findElement(By.id("id_closeModal")).click();
		Thread.sleep(2000);
		Add_Transfer.click();
		Thread.sleep(5000);
		SubmitTransfer.click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		driver.findElement(By.id("id_closeModal")).click();
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(5000);
	}

	public void  authPayinThroughTransfer() throws Exception
	{
		Authorization_Transfer.click();
		Thread.sleep(2000);
		Ref_no_Transfer.click();
		Thread.sleep(2000);
		Cash_Transfer_Auth.click();
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		driver.findElement(By.id("id_closeModal")).click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(5000);
	}

	public void createNewRDAccount(String cust_id, String amount, String tenure,String cust_id1) throws Exception
	{
		NewAccount.click();
		Thread.sleep(3000);
		Customer_id.sendKeys(cust_id);
		Master_search.click();
		Thread.sleep(3000);
		Select td_Product_Code=new Select(TD_Product_Code);
		td_Product_Code.selectByVisibleText("4013-Recurring Deposits");
		Term_Deposit_Amount.sendKeys(amount);
		Term_Deposit_Tenure_Month.sendKeys(Keys.BACK_SPACE);
		Term_Deposit_Tenure_Month.sendKeys(tenure);
		Select customer_Profile=new Select(customerProfile);
		customer_Profile.selectByVisibleText("Service");
		Select operating_Instruction=new Select(Operating_Instruction);
		operating_Instruction.selectByVisibleText("All Jointly");
		SubmitPrimaryDetail.click();
		Thread.sleep(5000);
		util.handle_popop();
		New_RD_Account=Error_message_master.getText();
		New_RD_Account=New_RD_Account.replace("Account created successfully. Account No:","");
		New_RD_Account=New_RD_Account.replace("x", "");
		New_RD_Account=New_RD_Account.trim();
		System.out.println(New_RD_Account);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		Deposit_Detail.click();
		Thread.sleep(2000);
		SubmitDepositDetail.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Joint_Holder_Details.click();
		Thread.sleep(2000);
		Customer_id.sendKeys(cust_id1);
		Master_search.click();
		Thread.sleep(3000);
		Select relation=new Select(Joint_Ralation);
		relation.selectByVisibleText("Son-in-Law");
		Joint_Add.click();
		Thread.sleep(2000);
		Joint_Submit.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Nominee_Detail.click();
		Thread.sleep(3000);
		Nom_skip.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Witness_Detail.click();
		Thread.sleep(3000);
		Wit_skip.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Payin_Detail.click();
		Thread.sleep(3000);
		Payin_skip.click();
		CloseErrorMessage.click();
		Thread.sleep(2000);
		SendToVerify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}

	public void authCreatedNewRDAccount() throws Exception
	{
		Authorize.click();
		Thread.sleep(5000);
		WebElement Account_no=driver.findElement(By.xpath("//select[@id='id_optMasterAccountNumber']"));
		List<WebElement> dropdown=Account_no.findElements(By.tagName("option"));
		for(int i=0;i<dropdown.size();i++)
		{
			//System.out.println(dropdown.get(i).getText());
			if(dropdown.get(i).getText().equals(New_RD_Account))
			{
				dropdown.get(i).click();
				break;
			}
		}
		Thread.sleep(10000);
		util.handle_popop();
		Thread.sleep(2000);
		Verify.click();
		Thread.sleep(5000);
		util.handle_popop();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Deposit_Detail.click();
		Thread.sleep(3000);
		Verify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Joint_Holder_Details.click();
		Thread.sleep(2000);
		Joint_View.click();
		Thread.sleep(2000);
		Joint_Verify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Authorized.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static Row row;
	String location = "D:\\Siddhesh Training Document\\Automation_For_CBS\\Excel\\CBS_Automation.xlsx";
	public static String New_TD_Account;
	public static String New_Cash_TD_Account;
	public static String New_Transfer_TD_Account;
	public static String New_RD_Account;
	public static String New_Bulk_TD_Account;
	
	TestUtil util=new TestUtil();
	
	@FindBy(xpath="//span[contains(text(),'Primary Applicant Details')]")
	WebElement Primary_Applicant_Details;
	
	@FindBy(xpath="//button[@id='btnNew']")
	WebElement NewAccount;
	
	@FindBy(xpath="//input[@id='id_txtCustomernumber']")
	WebElement Customer_id;
	
	@FindBy(xpath="//input[@id='id_rate_of_interest']")
	WebElement Rate_Of_Interest;
	
	@FindBy(xpath="//span[@id='id_search']")
	WebElement Master_search;
	
	@FindBy(xpath="//select[@id='id_ProductCode']")
	WebElement TD_Product_Code;
	
	@FindBy(xpath="//input[@id='id_tdAmount']")
	WebElement Term_Deposit_Amount;
	
	@FindBy(xpath="//input[@id='id_DepositTenureDays']")
	WebElement Term_Deposit_Tenure_Days;
	
	@FindBy(xpath="//input[@id='id_DepositTenureMonths']")
	WebElement Term_Deposit_Tenure_Month;
	
	@FindBy(xpath="//input[@id='id_DepositTenureYears']")
	WebElement Term_Deposit_Tenure_Year;
	
	@FindBy(xpath="//select[@id='id_customerProfile']")
	WebElement customerProfile;
	
	@FindBy(xpath="//select[@id='id_OperatingInstructionInd']")
	WebElement Operating_Instruction;
	
	@FindBy(xpath="//button[@id='id_SubmitCompanyDetail']")
	WebElement SubmitPrimaryDetail;
	
	@FindBy(xpath="//div[@id='error_message_master']")
	WebElement Error_message_master;
	
	@FindBy(xpath="//a[@id='id_closeErrorMessage']")
	WebElement CloseErrorMessage;
	
	@FindBy(xpath="//span[contains(text(),'Deposit Detail')]")
	WebElement Deposit_Detail;
	
	@FindBy(xpath="//button[@id='id_SubmitDepositDetail']")
	WebElement SubmitDepositDetail;
	
	@FindBy(xpath="//span[contains(text(),'Interest Payout')]")
	WebElement Interest_Payout;
	
	@FindBy(xpath="//span[contains(text(),'Joint Holder Detail')]")
	WebElement Joint_Holder_Details;
	
	@FindBy(xpath="//select[@id='id_GuardianRelationType']")
	WebElement Joint_Ralation;
	
	@FindBy(xpath="//button[@id='id_joint_add']")
	WebElement Joint_Add;
	
	@FindBy(xpath="//button[@id='id_joint_submit']")
	WebElement Joint_Submit;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[5]/button[contains(text(),'View')]")
	WebElement Joint_View;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[6]/button[contains(text(),'Verify')]")
	WebElement Joint_Verify;
	
	@FindBy(xpath="//span[contains(text(),'Nominee Detail')]")
	WebElement Nominee_Detail;
	
	@FindBy(xpath="//select[@id='id_NomineeRelationType']")
	WebElement Relation;
	
	@FindBy(xpath="//button[@id='id_nominee_add']")
	WebElement Nominee_Add;
	
	@FindBy(xpath="//button[@id='id_nominee_submit']")
	WebElement Nominee_Submit;
	
	@FindBy(xpath="//span[contains(text(),'Witness Detail')]")
	WebElement Witness_Detail;
	
	@FindBy(xpath="//input[@id='id_customerid']")
	WebElement Witness_Customer_id;
	
	@FindBy(xpath="//button[@id='id_witness_add']")
	WebElement Witness_Add;
	
	@FindBy(xpath="//button[@id='id_witness_submit']")
	WebElement Witness_Submit;
	
	@FindBy(xpath="//span[contains(text(),'Payin Details')]")
	WebElement Payin_Detail;
	
	@FindBy(xpath="//input[@id='id_accountno']")
	WebElement Account_No;
	
	@FindBy(xpath="//select[@id='id_branch']")
	WebElement Branch;
	
	@FindBy(xpath="//select[@id='id_activity']")
	WebElement Activity;
	
	@FindBy(xpath="//input[@id='id_txtInstrumentNumber']")
	WebElement Instrument_Number;
	
	@FindBy(xpath="//input[@id='id_narration']")
	WebElement Narration;
	
	@FindBy(xpath="//button[@id='id_submitPayinDetails']")
	WebElement Payin_Submit;
	
	@FindBy(xpath="//span[contains(text(),'Account Master TD')]")
	WebElement TD_Creation;
	
	@FindBy(xpath="//input[@id='id_masterAccountNo']")
	WebElement Pri_Account_No;
	
	@FindBy(xpath="//button[@id='id_master_search']")
	WebElement Search;
	
	@FindBy(xpath="//button[@id='id_master_sendtoverify']")
	WebElement SendToVerify;
	
	@FindBy(xpath="//img[@id='id_emp_photo']")
	WebElement emp_photo;
	
	@FindBy(xpath="//a[@id='id_logout']")
	WebElement logout;
	
	@FindBy(xpath="//button[@id='btnAuthorize']")
	WebElement Authorize;
	
	@FindBy(xpath="//button[@id='btnVerify']")
	WebElement Verify;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[6]/button[contains(text(),'View')]")
	WebElement Nom_View;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[7]/button[contains(text(),'Verify')]")
	WebElement Nom_Verify;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[4]/button[contains(text(),'View')]")
	WebElement Witness_View;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[5]/button[contains(text(),'Verify')]")
	WebElement Witness_Verify;
	
	@FindBy(xpath="//button[@id='id_master_authorize']")
	WebElement Authorized;
	
	@FindBy(xpath="//button[@id='id_skip_2']")
	WebElement Interest_skip;
	
	@FindBy(xpath="//button[@id='id_skip_4']")
	WebElement Joint_skip;
	
	@FindBy(xpath="//button[@id='id_skip_5']")
	WebElement Nom_skip;
	
	@FindBy(xpath="//button[@id='id_skip_6']")
	WebElement Wit_skip;
	
	@FindBy(xpath="//button[@id='id_skip_3']")
	WebElement Payin_skip;
	
	@FindBy(xpath="//input[@id='id_txtAccountNumber']")
	WebElement Cash_Account_No;
	
	@FindBy(xpath="//input[@id='id_txtAccountNumber']")
	WebElement Transfer_Account_No;
	
	@FindBy(xpath="//select[@id='id_activitySubTypeId']")
	WebElement Cash_Tranfer_Activity;
	
	@FindBy(xpath="//select[@id='id_activitySubTypeId']")
	WebElement Transaction_Nature;
	
	@FindBy(xpath="//input[@id='id_txtInstrumentNumber']")
	WebElement Instrument_No;
	
	@FindBy(xpath="//button[@id='id_button_add_cash']")
	WebElement Add_Cash;
	
	@FindBy(xpath="//button[@id='btnSubmitCash']")
	WebElement Submit_Cash;
	
	@FindBy(xpath="//a[contains(text(),'Pending Denominations')]")
	WebElement Pending_Denominations;
	
	@FindBy(xpath="//select[@id='id_txn_nature']")
	WebElement transaction_Nature;
	
	@FindBy(xpath="//button[@id='id_search_pending_denominations']")
	WebElement Cash_Search;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered ']/tbody/tr[1]/td[6]/button[contains(text(),'Add Denominations')]")
	WebElement Add_Denominations;
	
	@FindBy(xpath="//input[@id='id_Deno0']")
	WebElement New_quantity;
	
	@FindBy(xpath="//input[@id='id_Deno0_Total']")
	WebElement old_quantity;
	
	@FindBy(xpath="//button[@id='id_submit_token_denoms']")
	WebElement Submit_denom;
	
	@FindBy(xpath="//li[@id='id_authorization_cash']/a[contains(text(),'Authorization')]")
	WebElement Authorization_cash;
	
	@FindBy(xpath="//a[@id='reference_no0']")
	WebElement Cash_link;
	
	@FindBy(xpath="//button[@id='id_authorizeBtn']")
	WebElement Cash_Transfer_Auth;
	
	@FindBy(xpath="//input[@id='id_txtTxnDate']")
	WebElement Trans_date;
	
	@FindBy(xpath="//button[@id='btnAddTransfer']")
	WebElement Add_Transfer;
	
	@FindBy(xpath="//input[@id='id_txtAmount']")
	WebElement Transfer_Amount;
	
	@FindBy(xpath="//button[@id='btnSubmitTransfer']")
	WebElement SubmitTransfer;
	
	@FindBy(xpath="//li[@id='id_authorization_transfer']/a[contains(text(),'Authorization')]")
	WebElement Authorization_Transfer;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[1]/a")
	WebElement Ref_no_Transfer;
	
	@FindBy(xpath="//select[@id='id_tdMasterType']")
	WebElement TD_MasterType;
	
	@FindBy(xpath="//input[@id='id_CustomerId']")
	WebElement Bulk_Customer_id;
	
	@FindBy(xpath="//input[@id='id_CustomerName']")
	WebElement Bulk_CustomerName;
	
	@FindBy(xpath="//input[@id='id_TotalAmount']")
	WebElement Bulk_TD_Amount;
	
	@FindBy(xpath="//button[@id='id_btnAdditionalInput']")
	WebElement Bulk_Submit;
	
	@FindBy(xpath="//input[@id='id_amt']")
	WebElement Bulk_Amount;
	
	@FindBy(xpath="//select[@id='id_accountType']")
	WebElement AccountType;
	
	@FindBy(xpath="//input[@id='id_depositTenureDays']")
	WebElement Deposit_Tenure_Days;
	
	@FindBy(xpath="//input[@id='id_depositTenureMonths']")
	WebElement Deposit_Tenure_Month;
	
	@FindBy(xpath="//input[@id='id_depositTenureYears']")
	WebElement Deposit_Tenure_Year;
	
	@FindBy(xpath="//button[@id='id_btnAddRow']")
	WebElement Add_Bulk;
	
	@FindBy(xpath="//button[@id='id_submit']")
	WebElement submit;
	
	@FindBy(xpath="//span[contains(text(),'Maturity Payout')]")
	WebElement Maturity_Payout;
	
	@FindBy(xpath="//select[@id='id_payout_mode']")
	WebElement Payout_Mode;
	
	@FindBy(xpath="//input[@id='id_accountno']")
	WebElement Account_no;
	
	@FindBy(xpath="//input[@id='id_branch_name']")
	WebElement Branch_Name;
	
	@FindBy(xpath="//button[@id='id_SubmitMaturityPayout']")
	WebElement SubmitMaturity;
	
	@FindBy(xpath="//button[@class='btn btn-primary can-perform-verify']")
	WebElement Bulk_Verify;
	
	public TDCreationPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	//TD Auto-payin
	
	public void createNewTDAccount() throws Exception
	{
		NewAccount.click();
		Thread.sleep(3000);
		fis = new FileInputStream(location);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("TD");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(1).getLastCellNum();
		for (int i=1;i<=rowcount;i++)
		{
			row = sheet.getRow(i);
			for(int j=0;j<colcount;j++)
			{
				XSSFCell cell=(XSSFCell) row.getCell(j);
				Long cust_id=(long) row.getCell(0).getNumericCellValue();
				Customer_id.sendKeys(String.valueOf(String.valueOf(cust_id)));
				Master_search.click();
				Thread.sleep(3000);
				Select td_Product_Code=new Select(TD_Product_Code);
				td_Product_Code.selectByIndex(2);
				Long term_Deposit_Amount=(long) row.getCell(1).getNumericCellValue();
				Term_Deposit_Amount.sendKeys(String.valueOf(String.valueOf(term_Deposit_Amount)));
				Term_Deposit_Tenure_Month.sendKeys(Keys.BACK_SPACE);
				int term_Deposit_Tenure_Month=(int) row.getCell(2).getNumericCellValue();
				Term_Deposit_Tenure_Month.sendKeys(String.valueOf(String.valueOf(term_Deposit_Tenure_Month)));
				Select customer_Profile=new Select(customerProfile);
				customer_Profile.selectByIndex(1);
				//customer_Profile.selectByVisibleText("Business");
				Select operating_Instruction=new Select(Operating_Instruction);
				operating_Instruction.selectByIndex(1);
				//operating_Instruction.selectByVisibleText("Self");
				SubmitPrimaryDetail.click();
				Thread.sleep(5000);
				//util.handle_popop();
				New_TD_Account=Error_message_master.getText();
				New_TD_Account=New_TD_Account.replace("Account created successfully. Account No:","");
				New_TD_Account=New_TD_Account.replace("x", "");
				New_TD_Account=New_TD_Account.trim();
				System.out.println(New_TD_Account);
				CloseErrorMessage.click();
				Thread.sleep(3000);
				Deposit_Detail.click();
				Thread.sleep(2000);
				SubmitDepositDetail.click();
				Thread.sleep(2000);
				CloseErrorMessage.click();
				Thread.sleep(2000);
				Nominee_Detail.click();
				Thread.sleep(2000);
				Customer_id.sendKeys();
				Master_search.click();
				Thread.sleep(2000);
				Select relation=new Select(Relation);
				relation.selectByIndex(1);
				//relation.selectByVisibleText("Brother");
				Nominee_Add.click();
				Thread.sleep(2000);
				Nominee_Submit.click();
				Thread.sleep(5000);
				CloseErrorMessage.click();
				Thread.sleep(2000);
				Witness_Detail.click();
				Thread.sleep(3000);
				Witness_Customer_id.sendKeys();
				Master_search.click();
				Thread.sleep(2000);
				Witness_Add.click();
				Thread.sleep(2000);
				Witness_Submit.click();
				Thread.sleep(2000);
				CloseErrorMessage.click();
				Thread.sleep(2000);
				Payin_Detail.click();
				Thread.sleep(3000);
				Account_No.sendKeys();
				Branch.click();
				Thread.sleep(2000);
				Select activity=new Select(Activity);
				activity.selectByVisibleText("CASA_DEBIT");
				Instrument_Number.sendKeys();
				Narration.sendKeys();
				Payin_Submit.click();
				Thread.sleep(3000);
				CloseErrorMessage.click();
				Thread.sleep(2000);
				/*driver.navigate().refresh();
				Thread.sleep(5000);
				TD_Creation.click();
				Thread.sleep(3000);
				NewAccount.click();
				Thread.sleep(5000);
				Pri_Account_No.sendKeys(Keys.BACK_SPACE);
				Thread.sleep(2000);
				Pri_Account_No.sendKeys(New_TD_Account);
				Thread.sleep(15000);
				Search.click();
				Thread.sleep(10000);
				//util.handle_popop();
				//Thread.sleep(5000);
				SendToVerify.click();
				Thread.sleep(2000);
				CloseErrorMessage.click();
				Thread.sleep(2000);*/
				/*SendToVerify.click();
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
	
	
	/*public void createNewTDAccount(String cust_id1,String amount,String tenure,String cust_id2,String cust_id3,String Acc_no,String ins_no,
			String narr) throws Exception
	{
		NewAccount.click();
		Thread.sleep(3000);
		Customer_id.sendKeys(cust_id1);
		Master_search.click();
		Thread.sleep(3000);
		//util.handle_popop();
		Select td_Product_Code=new Select(TD_Product_Code);
		td_Product_Code.selectByIndex(2);
		//td_Product_Code.selectByVisibleText("4016-Fixed Deposit Receipt-Yearly");
		Term_Deposit_Amount.sendKeys(amount);
		Term_Deposit_Tenure_Month.sendKeys(Keys.BACK_SPACE);
		Term_Deposit_Tenure_Month.sendKeys(tenure);
		Select customer_Profile=new Select(customerProfile);
		customer_Profile.selectByIndex(1);
		//customer_Profile.selectByVisibleText("Business");
		Select operating_Instruction=new Select(Operating_Instruction);
		operating_Instruction.selectByIndex(1);
		//operating_Instruction.selectByVisibleText("Self");
		SubmitPrimaryDetail.click();
		Thread.sleep(5000);
		//util.handle_popop();
		New_TD_Account=Error_message_master.getText();
		New_TD_Account=New_TD_Account.replace("Account created successfully. Account No:","");
		New_TD_Account=New_TD_Account.replace("x", "");
		New_TD_Account=New_TD_Account.trim();
		System.out.println(New_TD_Account);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		Deposit_Detail.click();
		Thread.sleep(2000);
		SubmitDepositDetail.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Nominee_Detail.click();
		Thread.sleep(2000);
		Customer_id.sendKeys(cust_id2);
		Master_search.click();
		Thread.sleep(2000);
		Select relation=new Select(Relation);
		relation.selectByIndex(1);
		//relation.selectByVisibleText("Brother");
		Nominee_Add.click();
		Thread.sleep(2000);
		Nominee_Submit.click();
		Thread.sleep(5000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Witness_Detail.click();
		Thread.sleep(3000);
		Witness_Customer_id.sendKeys(cust_id3);
		Master_search.click();
		Thread.sleep(2000);
		Witness_Add.click();
		Thread.sleep(2000);
		Witness_Submit.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Payin_Detail.click();
		Thread.sleep(3000);
		Account_No.sendKeys(Acc_no);
		Branch.click();
		Thread.sleep(2000);
		Select activity=new Select(Activity);
		activity.selectByVisibleText("CASA_DEBIT");
		Instrument_Number.sendKeys(ins_no);
		Narration.sendKeys(narr);
		Payin_Submit.click();
		Thread.sleep(3000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		TD_Creation.click();
		Thread.sleep(3000);
		NewAccount.click();
		Thread.sleep(5000);
		Pri_Account_No.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		Pri_Account_No.sendKeys(New_TD_Account);
		Thread.sleep(15000);
		Search.click();
		Thread.sleep(10000);
		//util.handle_popop();
		//Thread.sleep(5000);
		SendToVerify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}*/
	
	/*public void authNewTDAccount() throws Exception
	{
		Authorize.click();
		Thread.sleep(5000);
		WebElement Account_no=driver.findElement(By.xpath("//select[@id='id_optMasterAccountNumber']"));
		List<WebElement> dropdown=Account_no.findElements(By.tagName("option"));
		for(int i=0;i<dropdown.size();i++)
		{
			//System.out.println(dropdown.get(i).getText());
			if(dropdown.get(i).getText().equals(New_TD_Account))
			{
				dropdown.get(i).click();
				break;
			}
		}
		Thread.sleep(10000);
		//util.handle_popop();
		Thread.sleep(2000);
		Verify.click();
		Thread.sleep(5000);
		//util.handle_popop();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Deposit_Detail.click();
		Thread.sleep(3000);
		Verify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Nominee_Detail.click();
		Thread.sleep(3000);
		Nom_View.click();
		Thread.sleep(2000);
		Nom_Verify.click();
		Thread.sleep(3000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Witness_Detail.click();
		Thread.sleep(3000);
		Witness_View.click();
		Thread.sleep(2000);
		Witness_Verify.click();
		Thread.sleep(3000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Payin_Detail.click();
		Thread.sleep(3000);
		Verify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Authorized.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}
	
	//TD payin through cash
	
	public void tdThroughCash(String cust_id1,String amount,String tenure,String cust_id2 ) throws Exception
	{
		NewAccount.click();
		Thread.sleep(3000);
		Customer_id.sendKeys(cust_id1);
		Master_search.click();
		Thread.sleep(3000);
		//util.handle_popop();
		Select td_Product_Code=new Select(TD_Product_Code);
		//td_Product_Code.selectByVisibleText("4014-Fixed Deposit Receipt-Quaterly");
		td_Product_Code.selectByIndex(2);
		Term_Deposit_Amount.sendKeys(amount);
		Term_Deposit_Tenure_Days.sendKeys(Keys.BACK_SPACE);
		Term_Deposit_Tenure_Days.sendKeys(tenure);
		Rate_Of_Interest.click();
		Thread.sleep(3000);
		Select customer_Profile=new Select(customerProfile);
		customer_Profile.selectByIndex(1);
		//customer_Profile.selectByVisibleText("Service");
		Select operating_Instruction=new Select(Operating_Instruction);
		operating_Instruction.selectByIndex(1);
		//operating_Instruction.selectByVisibleText("Self");
		SubmitPrimaryDetail.click();
		Thread.sleep(5000);
		//util.handle_popop();
		New_Cash_TD_Account=Error_message_master.getText();
		New_Cash_TD_Account=New_Cash_TD_Account.replace("Account created successfully. Account No:","");
		New_Cash_TD_Account=New_Cash_TD_Account.replace("x", "");
		New_Cash_TD_Account=New_Cash_TD_Account.trim();
		System.out.println(New_Cash_TD_Account);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		Deposit_Detail.click();
		Thread.sleep(2000);
		SubmitDepositDetail.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Nominee_Detail.click();
		Thread.sleep(2000);
		Customer_id.sendKeys(cust_id2);
		Master_search.click();
		Thread.sleep(2000);
		Select relation=new Select(Relation);
		relation.selectByIndex(2);
		//relation.selectByVisibleText("Uncle");
		Nominee_Add.click();
		Thread.sleep(2000);
		Nominee_Submit.click();
		Thread.sleep(5000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Witness_Detail.click();
		Thread.sleep(3000);
		Wit_skip.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Payin_Detail.click();
		Thread.sleep(3000);
		Payin_skip.click();
		CloseErrorMessage.click();
		Thread.sleep(2000);
		SendToVerify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}
	
	public void authCashTDAccount() throws Exception
	{
		Authorize.click();
		Thread.sleep(5000);
		WebElement Account_no=driver.findElement(By.xpath("//select[@id='id_optMasterAccountNumber']"));
		List<WebElement> dropdown=Account_no.findElements(By.tagName("option"));
		for(int i=0;i<dropdown.size();i++)
		{
			//System.out.println(dropdown.get(i).getText());
			if(dropdown.get(i).getText().equals(New_Cash_TD_Account))
			{
				dropdown.get(i).click();
				break;
			}
		}
		Thread.sleep(5000);
		//util.handle_popop();
		Thread.sleep(3000);
		Verify.click();
		Thread.sleep(3000);
		//util.handle_popop();
		Thread.sleep(3000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Deposit_Detail.click();
		Thread.sleep(3000);
		Verify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Nominee_Detail.click();
		Thread.sleep(3000);
		Nom_View.click();
		Thread.sleep(2000);
		Nom_Verify.click();
		Thread.sleep(3000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Authorized.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}
	
	public void TDcashpayin(String inst_no,String denom) throws Exception
	{
		Cash_Account_No.sendKeys(New_Cash_TD_Account);
		Transaction_Nature.click();
		Thread.sleep(5000);
		//util.handle_popop();
		//Thread.sleep(2000);
		Select cash_Activity=new Select(Cash_Tranfer_Activity);
		//cash_Activity.selectByVisibleText("TD_PAYIN");
		cash_Activity.selectByIndex(2);
		Instrument_No.sendKeys(inst_no);
		Add_Cash.click();
		Thread.sleep(2000);
		Submit_Cash.click();
		Thread.sleep(3000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Pending_Denominations.click();
		Thread.sleep(3000);
		Select trans_nature=new Select(transaction_Nature);
		trans_nature.selectByVisibleText("Credit");
		Cash_Search.click();
		Thread.sleep(3000);
		Add_Denominations.click();
		Thread.sleep(2000);
		New_quantity.sendKeys(denom);
		old_quantity.click();
		Thread.sleep(2000);
		Submit_denom.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}
	
	public void authTDcashpayin() throws Exception
	{
		Authorization_cash.click();
		Thread.sleep(3000);
		Cash_link.click();
		Thread.sleep(3000);
		//util.handle_popop();
		Cash_Transfer_Auth.click();
		util.handle_popop1();
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}
	
	//TD payin through Transfer
	public void transferTDPayin(String cust_id1, String amount, String tenure) throws Exception
	{
		NewAccount.click();
		Thread.sleep(3000);
		Customer_id.sendKeys(cust_id1);
		Master_search.click();
		Thread.sleep(3000);
		//util.handle_popop();
		Select td_Product_Code=new Select(TD_Product_Code);
		td_Product_Code.selectByIndex(2);
		//td_Product_Code.selectByVisibleText("4008-Fixed Deposit Receipt-Monthly");
		Term_Deposit_Amount.sendKeys(amount);
		Term_Deposit_Tenure_Month.sendKeys(Keys.BACK_SPACE);
		//Term_Deposit_Tenure_Year.sendKeys(Keys.BACK_SPACE);
		Term_Deposit_Tenure_Month.sendKeys(tenure);
		Rate_Of_Interest.click();
		Thread.sleep(3000);
		//Term_Deposit_Tenure_Year.sendKeys(tenure);
		Select customer_Profile=new Select(customerProfile);
		customer_Profile.selectByIndex(1);
		//customer_Profile.selectByVisibleText("Service");
		Select operating_Instruction=new Select(Operating_Instruction);
		operating_Instruction.selectByIndex(1);
		//operating_Instruction.selectByVisibleText("Self");
		SubmitPrimaryDetail.click();
		Thread.sleep(5000);
		//util.handle_popop();
		New_Transfer_TD_Account=Error_message_master.getText();
		New_Transfer_TD_Account=New_Transfer_TD_Account.replace("Account created successfully. Account No:","");
		New_Transfer_TD_Account=New_Transfer_TD_Account.replace("x", "");
		New_Transfer_TD_Account=New_Transfer_TD_Account.trim();
		System.out.println(New_Transfer_TD_Account);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		Deposit_Detail.click();
		Thread.sleep(2000);
		SubmitDepositDetail.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		/*Interest_Payout.click();
		Thread.sleep(2000);
		Interest_skip.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);*/
		/*Nominee_Detail.click();
		Thread.sleep(3000);
		Nom_skip.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Witness_Detail.click();
		Thread.sleep(3000);
		Wit_skip.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Payin_Detail.click();
		Thread.sleep(3000);
		Payin_skip.click();
		CloseErrorMessage.click();
		Thread.sleep(2000);
		SendToVerify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(5000);
	}
	
	public void authTransferTDPayin() throws Exception
	{
		Authorize.click();
		Thread.sleep(3000);
		WebElement Account_no=driver.findElement(By.xpath("//select[@id='id_optMasterAccountNumber']"));
		List<WebElement> dropdown=Account_no.findElements(By.tagName("option"));
		for(int i=0;i<dropdown.size();i++)
		{
			//System.out.println(dropdown.get(i).getText());
			if(dropdown.get(i).getText().equals(New_Transfer_TD_Account))
			{
				dropdown.get(i).click();
				break;
			}
		}
		Thread.sleep(5000);
		//util.handle_popop();
		//Thread.sleep(3000);
		Verify.click();
		Thread.sleep(3000);
		//util.handle_popop();
		//Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Deposit_Detail.click();
		Thread.sleep(3000);
		Verify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Authorized.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(5000);
	}
	
	public void  payinThroughTransfer(String inst_no,String account_no,String amount,String inst_num) throws Exception
	{
		Transfer_Account_No.sendKeys(New_Transfer_TD_Account);
		Trans_date.click();
		Thread.sleep(10000);
		//util.handle_popop();
		//Thread.sleep(2000);
		Select transfer_Activity=new Select(Cash_Tranfer_Activity);
		//transfer_Activity.selectByVisibleText("TD_PAYIN");
		transfer_Activity.selectByIndex(2);
		Instrument_No.sendKeys(inst_no);
		Add_Transfer.click();
		Thread.sleep(3000);
		Transfer_Account_No.sendKeys(account_no);
		Trans_date.click();
		Thread.sleep(5000);
		//util.handle_popop();
		Thread.sleep(2000);
		Select transfer_Activity1=new Select(Cash_Tranfer_Activity);
		transfer_Activity1.selectByVisibleText("CASA_DEBIT");
		Transfer_Amount.sendKeys(amount);
		Instrument_No.sendKeys(inst_num);
		Trans_date.click();
		Thread.sleep(3000);
		driver.findElement(By.id("id_closeModal")).click();
		Thread.sleep(2000);
		Add_Transfer.click();
		Thread.sleep(5000);
		SubmitTransfer.click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		driver.findElement(By.id("id_closeModal")).click();
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(5000);
	}
	
	public void  authPayinThroughTransfer() throws Exception
	{
		Authorization_Transfer.click();
		Thread.sleep(2000);
		Ref_no_Transfer.click();
		Thread.sleep(2000);
		Cash_Transfer_Auth.click();
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		driver.findElement(By.id("id_closeModal")).click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(5000);
	}
	
	public void createNewRDAccount(String cust_id, String amount, String tenure,String cust_id1) throws Exception
	{
		NewAccount.click();
		Thread.sleep(3000);
		Customer_id.sendKeys(cust_id);
		Master_search.click();
		Thread.sleep(3000);
		//util.handle_popop();
		Select td_Product_Code=new Select(TD_Product_Code);
		td_Product_Code.selectByVisibleText("4013-Recurring Deposits");
		Term_Deposit_Amount.sendKeys(amount);
		Term_Deposit_Tenure_Month.sendKeys(Keys.BACK_SPACE);
		Term_Deposit_Tenure_Month.sendKeys(tenure);
		Select customer_Profile=new Select(customerProfile);
		customer_Profile.selectByVisibleText("Service");
		Select operating_Instruction=new Select(Operating_Instruction);
		operating_Instruction.selectByVisibleText("All Jointly");
		SubmitPrimaryDetail.click();
		Thread.sleep(5000);
		util.handle_popop();
		New_RD_Account=Error_message_master.getText();
		New_RD_Account=New_RD_Account.replace("Account created successfully. Account No:","");
		New_RD_Account=New_RD_Account.replace("x", "");
		New_RD_Account=New_RD_Account.trim();
		System.out.println(New_RD_Account);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		Deposit_Detail.click();
		Thread.sleep(2000);
		SubmitDepositDetail.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Joint_Holder_Details.click();
		Thread.sleep(2000);
		Customer_id.sendKeys(cust_id1);
		Master_search.click();
		Thread.sleep(3000);
		Select relation=new Select(Joint_Ralation);
		relation.selectByVisibleText("Son-in-Law");
		Joint_Add.click();
		Thread.sleep(2000);
		Joint_Submit.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Nominee_Detail.click();
		Thread.sleep(3000);
		Nom_skip.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Witness_Detail.click();
		Thread.sleep(3000);
		Wit_skip.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Payin_Detail.click();
		Thread.sleep(3000);
		Payin_skip.click();
		CloseErrorMessage.click();
		Thread.sleep(2000);
		SendToVerify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}
	
	public void authCreatedNewRDAccount() throws Exception
	{
		Authorize.click();
		Thread.sleep(5000);
		WebElement Account_no=driver.findElement(By.xpath("//select[@id='id_optMasterAccountNumber']"));
		List<WebElement> dropdown=Account_no.findElements(By.tagName("option"));
		for(int i=0;i<dropdown.size();i++)
		{
			//System.out.println(dropdown.get(i).getText());
			if(dropdown.get(i).getText().equals(New_RD_Account))
			{
				dropdown.get(i).click();
				break;
			}
		}
		Thread.sleep(10000);
		util.handle_popop();
		Thread.sleep(2000);
		Verify.click();
		Thread.sleep(5000);
		util.handle_popop();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Deposit_Detail.click();
		Thread.sleep(3000);
		Verify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Joint_Holder_Details.click();
		Thread.sleep(2000);
		Joint_View.click();
		Thread.sleep(2000);
		Joint_Verify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Authorized.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}
	
	public void creteBulkTDAccount(String cust_id,String bulk_amount,String tenure,String amount,String tenure1,String tenure2,
									String amount1,String tenure3,String tenure4,String tenure5,String amount2,String acco_no) throws Exception
	{
		Select td_MasterType=new Select(TD_MasterType);
		td_MasterType.selectByVisibleText("Bulk TD");
		Thread.sleep(2000);
		NewAccount.click();
		Thread.sleep(3000);
		Bulk_Customer_id.sendKeys(cust_id);
		Bulk_CustomerName.click();
		//Master_search.click();
		Thread.sleep(5000);
		//CloseErrorMessage.click();
		//Thread.sleep(2000);
		//util.handle_popop();
		Select td_Product_Code=new Select(TD_Product_Code);
		td_Product_Code.selectByIndex(2);
		//td_Product_Code.selectByVisibleText("4018-Vardhaman Multiplier Deposit - (74) FD CUM MANNUAL");
		Bulk_TD_Amount.sendKeys(bulk_amount);
		Bulk_Submit.click();
		Thread.sleep(2000);
		Deposit_Tenure_Month.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		Deposit_Tenure_Month.sendKeys(tenure);
		Bulk_Amount.sendKeys(Keys.BACK_SPACE);
		Bulk_Amount.sendKeys(amount);
		AccountType.click();
		Thread.sleep(2000);
		Add_Bulk.click();
		Thread.sleep(2000);
		Deposit_Tenure_Days.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		Deposit_Tenure_Days.sendKeys(tenure1);
		Deposit_Tenure_Month.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		Deposit_Tenure_Month.sendKeys(tenure2);
		Bulk_Amount.sendKeys(Keys.BACK_SPACE);
		Bulk_Amount.sendKeys(amount1);
		AccountType.click();
		Thread.sleep(2000);
		Add_Bulk.click();
		Thread.sleep(2000);
		Deposit_Tenure_Days.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		Deposit_Tenure_Days.sendKeys(tenure3);
		Deposit_Tenure_Month.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		Deposit_Tenure_Month.sendKeys(tenure4);
		Deposit_Tenure_Year.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		Deposit_Tenure_Year.sendKeys(tenure5);
		Bulk_Amount.sendKeys(Keys.BACK_SPACE);
		Bulk_Amount.sendKeys(amount2);
		AccountType.click();
		Thread.sleep(2000);
		Add_Bulk.click();
		Thread.sleep(2000);
		submit.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Primary_Applicant_Details.click();
		Thread.sleep(3000);
		Select customer_Profile=new Select(customerProfile);
		customer_Profile.selectByIndex(1);
		//customer_Profile.selectByVisibleText("Business");
		Select operating_Instruction=new Select(Operating_Instruction);
		//operating_Instruction.selectByVisibleText("Self");
		operating_Instruction.selectByIndex(1);
		SubmitPrimaryDetail.click();
		Thread.sleep(5000);
		//util.handle_popop();
		//Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		Deposit_Detail.click();
		Thread.sleep(2000);
		SubmitDepositDetail.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Maturity_Payout.click();
		Thread.sleep(2000);
		Select payout_Mode=new Select(Payout_Mode);
		//payout_Mode.selectByVisibleText("Transfer");
		payout_Mode.selectByIndex(1);
		Thread.sleep(2000);
		Account_no.sendKeys(acco_no);
		Thread.sleep(2000);
		Branch_Name.click();
		Thread.sleep(5000);
		Select activity=new Select(Activity);
		activity.selectByIndex(1);
		//activity.selectByVisibleText("CASA CREDIT");
		SubmitMaturity.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Joint_Holder_Details.click();
		Thread.sleep(2000);
		Joint_skip.click();
		New_Bulk_TD_Account=Error_message_master.getText();
		New_Bulk_TD_Account=New_Bulk_TD_Account.replace("Successfully Skipped for","");
		New_Bulk_TD_Account=New_Bulk_TD_Account.replace("x", "");
		New_Bulk_TD_Account=New_Bulk_TD_Account.trim();
		System.out.println(New_Bulk_TD_Account);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Nominee_Detail.click();
		Thread.sleep(3000);
		Nom_skip.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Witness_Detail.click();
		Thread.sleep(3000);
		Wit_skip.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Payin_Detail.click();
		Thread.sleep(3000);
		Payin_skip.click();
		CloseErrorMessage.click();
		Thread.sleep(2000);
		SendToVerify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}
	
	public void authCretedBulkTDAccount() throws Exception
	{
		Select td_MasterType=new Select(TD_MasterType);
		td_MasterType.selectByVisibleText("Bulk TD");
		Thread.sleep(2000);
		Authorize.click();
		Thread.sleep(5000);
		WebElement Account_no=driver.findElement(By.xpath("//select[@id='id_optMasterAccountNumber']"));
		List<WebElement> dropdown=Account_no.findElements(By.tagName("option"));
		for(int i=0;i<dropdown.size();i++)
		{
			//System.out.println(dropdown.get(i).getText());
			if(dropdown.get(i).getText().equals(New_Bulk_TD_Account))
			{
				dropdown.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		Bulk_Verify.click();
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Primary_Applicant_Details.click();
		Thread.sleep(3000);
		Verify.click();
		Thread.sleep(5000);
		//util.handle_popop();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Deposit_Detail.click();
		Thread.sleep(3000);
		Verify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Maturity_Payout.click();
		Thread.sleep(3000);
		Verify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Authorized.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
	}*/

