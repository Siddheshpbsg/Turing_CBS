package com.cbs.pages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.crypto.Data;

import org.apache.poi.hssf.record.cf.DataBarFormatting;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cbs.base.TestBase;
import com.cbs.util.TestUtil;

public class CashPage extends TestBase {

	TestUtil testutil = new TestUtil();
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static Row row;
	CashPage cashPage;
	Homepage homepage;
	LoginPage loginpage;
	int mintoken = 001;
	int maxtoken = 300;
	String location = "C:\\Users\\AkashBorade\\Desktop\\Excel Autom\\CBS_Automation.xlsx";
	public static String OneRupeesNotes;
	public static String CCCloseAccount;
	public static String TDpayoutAmt;
	public static String TDReqAmount;
	public static String availableBalance;
	public static String requestAmount;
	public static String list_of_ref_nu;
	public static String ref_nu_postinTransit;
	public static String token_nu_postinTransit;
	public static String transit_ref_num;

	public String reversalToken = "Cannot add the transaction with invalid token";

	@FindBy(xpath = "//input[@id='id_txtAccountNumber']")
	WebElement AC_Product_Number;

	@FindBy(xpath = "//a[@title='Double Click to Auto-populate'][1]")
	WebElement InternalPriduct;

	@FindBy(xpath = "//select[@id='id_activitySubTypeId']")
	WebElement Activity;

	@FindBy(xpath = "//a[@id='id_closeModal']")
	WebElement CloseAccountDetails;

	@FindBy(xpath = "//input[@name='txtTxnDate']")
	WebElement Date;

	@FindBy(xpath = "//input[@id='id_txn_date']")
	WebElement transactionDate;

	@FindBy(xpath = "//select[@id='id_txnNatureSelect']")
	WebElement Transaction_Nature;

	@FindBy(xpath = "//input[@name='token_no']")
	WebElement TokenNo;

	@FindBy(xpath = "//input[@id='id_txtInstrumentNumber']")
	WebElement InstrumentNumber;

	@FindBy(xpath = "//input[@name='txtAmount_display']")
	WebElement Amount;

	@FindBy(xpath = "//td[@id='request_amt-0']")
	WebElement RequestAmount;

	@FindBy(xpath = "//label[@id='id_available_balance_loan']")
	WebElement AvailableBalance;

	@FindBy(xpath = "//td[@id='request_amt-0']")
	WebElement TotalAmount;

	@FindBy(xpath = "//label[@id='lblTotalAvilableBalance']")
	WebElement TotalPayoutAmount;

	@FindBy(xpath = "//td[@id='id_payout_amt_closure']")
	WebElement TDPayoutAmount;

	@FindBy(xpath = "//td[@id='request_amt-0']")
	WebElement TDRequestAmt;

	@FindBy(xpath = "//button[@id='id_button_add_cash']")
	WebElement ADD;

	@FindBy(xpath = "//button[@id='btnSubmitCash']")
	WebElement Submit;

	@FindBy(xpath = "//button[@id='btnSubmit']")
	WebElement Search1;

	@FindBy(xpath = "//a[@id='id_closeErrorMessage']")
	WebElement CloseErrorMessage;

	@FindBy(xpath = "//a[contains(text(),'Pending Denominations')]")
	WebElement Pending_Denominations;

	@FindBy(xpath = "//select[@id='id_txn_nature']")
	WebElement txn_nature;

	@FindBy(xpath = "//button[@id='id_search_pending_denominations']")
	WebElement Search_pending_denom;

	@FindBy(xpath = "//button[@class='btn btn-new btn-primary']")
	WebElement Add_denom;

	@FindBy(xpath = "//input[@id='id_Deno0']")
	WebElement New_quan;

	@FindBy(xpath = "//input[@id='id_Deno1']")
	WebElement New_quan1;

	@FindBy(xpath = "//input[@id='id_Old_Deno0']")
	WebElement Old_quan;

	@FindBy(xpath = "//input[@id='id_Deno9']")
	WebElement OneRupNotes;

	@FindBy(xpath = "//button[@id='id_submit_token_denoms']")
	WebElement submit_denoms;

	@FindBy(xpath = "//li[@id='id_authorization_cash']/a[contains(text(),'Authorization')]")
	WebElement Authorization;

	@FindBy(xpath = "(//table[1]/tbody/tr)[last()]/td[2]/a")
	WebElement expected_last_ref_nu;
	
	@FindBy(xpath = "(//table[@class='table table-striped table-bordered']/tbody/tr/td/a)[1]")
	WebElement Expected;

	@FindBy(xpath = "//a[@id='reference_no1']")
	WebElement Expected1;

	@FindBy(xpath = "//a[@id='reference_no2']")
	WebElement Expected2;

	@FindBy(xpath = "//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[1]/a[@id='reference_no0']")
	WebElement Actual;

	@FindBy(xpath = "//input[@id='id_txtRefNo']")
	WebElement Actual_ref_num;

	@FindBy(xpath = "//img[@id='id_emp_photo']")
	WebElement emp_photo;

	@FindBy(xpath = "//a[@id='id_logout']")
	WebElement logout;

	@FindBy(xpath = "//button[@id='id_authorizeBtn']")
	WebElement Cash_Auth;

	@FindBy(xpath = "//a[@id='id_closeModal']")
	WebElement ChequeList;

	@FindBy(xpath = "//button[@id='id_cancel']")
	WebElement cancalTransaction;

	@FindBy(xpath = "//button[@id='id_reject']")
	WebElement rejectTransaction;

	@FindBy(xpath = "//li[@id='id_post_transaction_cash']/a[contains(text(),'Post Transaction')]")
	WebElement PostTransaction;

	@FindBy(xpath = "//input[@id='id_list_txn_ref_no']")
	WebElement enterRef_number;

	@FindBy(xpath = "//button[@id='btnSubmit']")
	WebElement ref_num_Search;

	@FindBy(xpath = "//li[@id='id_completed_cash']")
	WebElement completed_cash;

	@FindBy(xpath = "//button[@id='id_reversal_btn']")
	WebElement reversal_btn;

	@FindBy(xpath = "//input[@id='id_token_no_for_reversal']")
	WebElement token_no_for_reversal;

	@FindBy(xpath = "//li[@id='id_pending_reversal_txns']")
	WebElement pending_reversal_txns;

	@FindBy(xpath = "//p[@style='font-size: 2vh;']")
	WebElement errorMessageToken;

	@FindBy(xpath = "//div[@id='error_message_master']")
	WebElement errorMessageToken1;

	@FindBy(xpath = "(//table[@class='table table-striped table-bordered']/tbody/tr/td)[1]")
	WebElement reversal_ref_number;

	@FindBy(xpath = "//input[@id='id_txtRefNo']")
	WebElement txtRefNo;

	@FindBy(xpath = "//button[@class='btn btn-default']")
	WebElement OkButton;

	@FindBy(xpath = "//li[@id='id_cash_in_transit']")
	WebElement post_transit;

	@FindBy(xpath = "//select[@id='id_branch_code']")
	WebElement selectActivity;

	@FindBy(xpath = "//input[@id='id_amount']")
	WebElement post_transit_amount;

	@FindBy(xpath = "//input[@id='id_transit_remark']")
	WebElement transit_Remark;

	@FindBy(xpath = "//button[@id='id_add_transit_credit_leg']")
	WebElement add_cashTransit;

	@FindBy(xpath = "//button[@id='id_add_transit_submit']")
	WebElement transit_Submit;

	@FindBy(xpath = "//li[@id='id_cash_in_transit_pending']")
	WebElement transit_Pending;

	@FindBy(xpath = "//li[@id='id_cash_in_transit_authorized']")
	WebElement transit_authorized;

	@FindBy(xpath = "//button[@id='receive']")
	WebElement cash_transitSend;

	@FindBy(xpath = "//select [@id='id_txn_nature']")
	WebElement select_txn_nature;

	// @FindBy(xpath = "(//button[@id='receive'])[1]")
	@FindBy(xpath = "(//table[1]/tbody/tr)[last()]/td[3]//button[@id='receive']")
	WebElement receive_pending_Transit;

	@FindBy(xpath = "//tbody[@id='id_cash_transit_data']/tr/td")
	WebElement cash_transit_data;

	@FindBy(xpath = "//table[@class='table table-striped table-bordered']") //// *[@id='id_cash_transit_data']/tr
	WebElement pendig_transit_Ref_num;

	@FindBy(xpath = "//table[@class='table table-striped table-bordered']/tbody/tr/td/a")
	WebElement pendingTransit_Ref_nu;

	@FindBy(xpath = "//label[@id='id_debit_token_label']")
	WebElement post_transit_Token;

	@FindBy(xpath = "//input[@id='pending_token_no']")
	WebElement pendig_Denoms_Token_No;

	public CashPage() {
		PageFactory.initElements(driver, this);
	}

	public void casaCredit() throws Exception {

		fis = new FileInputStream(location);
		// fis=new FileInputStream("");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Cash");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(1).getLastCellNum();
		for (int i = 1; i <= rowcount; i++) // for (int i = 1; i <= rowcount; i++)
		{
			row = sheet.getRow(i);
			for (int j = 0; j < colcount; j++)// for(int j=0;j<colcount;j++)
			{
				XSSFCell cell = (XSSFCell) row.getCell(j);
				AC_Product_Number.sendKeys(row.getCell(0).getStringCellValue());
				Date.click();
				Thread.sleep(5000);
				Select activity = new Select(Activity);
				activity.selectByVisibleText("CASA_CREDIT");
				// activity.selectByIndex(2);
				Transaction_Nature.click();
				Thread.sleep(1500);
				// long amount=(long) cell.getNumericCellValue();
				double amount = (double) row.getCell(2).getNumericCellValue();
				Amount.sendKeys(String.valueOf(amount));
				// double instnum = (double) row.getCell(2).getNumericCellValue();
				InstrumentNumber.sendKeys(row.getCell(3).getStringCellValue()); // Instrument
				ADD.click();
				Thread.sleep(1500);
				Submit.click();
				Thread.sleep(1500);
				CloseErrorMessage.click();
				Thread.sleep(1500);
				driver.findElement(By.xpath("//li[@id='id_post_transaction_cash']")).click();
				Pending_Denominations.click();
				Thread.sleep(3000);
				Select txnnature = new Select(txn_nature);
				txnnature.selectByVisibleText("Credit");
				// txnnature.selectByIndex(0);
				Search_pending_denom.click();
				Thread.sleep(1500);
				Add_denom.click();
				Thread.sleep(3000);
				int new_quan = (int) row.getCell(4).getNumericCellValue();
				New_quan.sendKeys(String.valueOf(new_quan));
				int new_quan1 = (int) row.getCell(5).getNumericCellValue();
				New_quan1.sendKeys(String.valueOf(new_quan1));
				Thread.sleep(1500);
				Old_quan.click();
				Thread.sleep(3000);
				submit_denoms.click();
				Thread.sleep(1500);
				CloseErrorMessage.click();
				Thread.sleep(3000);
				Authorization.click();
				Thread.sleep(3000);
				String exp_ref_no = Expected.getText();
				Thread.sleep(1500);
				System.out.println("Expected Result: " +exp_ref_no);
				row.createCell(6).setCellValue(exp_ref_no);
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				row.createCell(9).setCellValue(dtf.format(now));
				fos = new FileOutputStream(location);
				workbook.write(fos);
				// driver.findElement(By.xpath("//li[@id='id_post_transaction_cash']")).click();
				emp_photo.click();
				Thread.sleep(1500);
				logout.click();
				Thread.sleep(3000);
			}
		}
	}

	public void authCasaCredit() throws Exception {
		Authorization.click();
		Thread.sleep(3000);
		String actual_ref_no = Actual.getText();
		System.out.println("Actual Result: " + actual_ref_no);
		row.createCell(7).setCellValue(actual_ref_no);
		Thread.sleep(3000);
		Actual.click();
		Thread.sleep(3000);
		Cash_Auth.click();
		Thread.sleep(3000);
		testutil.handle_popop1();
		Thread.sleep(1500);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		if (row.getCell(6).getStringCellValue().equals(actual_ref_no)) {
			row.createCell(8).setCellValue("Pass");
		} else {
			row.createCell(8).setCellValue("Fail");
		}
		fos = new FileOutputStream(location);
		workbook.write(fos);
		emp_photo.click();
		Thread.sleep(1500);
		logout.click();
		Thread.sleep(3000);
	}

	public void casaDebit() throws Exception {
		fis = new FileInputStream(location);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Cash");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(2).getLastCellNum();
		for (int i = 2; i <= rowcount; i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < colcount; j++) {
				XSSFCell cell = (XSSFCell) row.getCell(j);
				AC_Product_Number.sendKeys(row.getCell(0).getStringCellValue());
				Date.click();
				Thread.sleep(5000);
				Select activity = new Select(Activity);
				activity.selectByVisibleText("CASA_DEBIT");
				Transaction_Nature.click();
				Thread.sleep(3000);
				
				int tokenrev = (int) (Math.random() * (maxtoken - mintoken + 1) + mintoken);
				TokenNo.sendKeys(tokenrev + "");
				
				//int Token = (int) row.getCell(1).getNumericCellValue();
				//TokenNo.sendKeys(String.valueOf(Token));
				
				
				double amount = (double) row.getCell(2).getNumericCellValue();
				Amount.sendKeys(String.valueOf(amount));
				InstrumentNumber.sendKeys(row.getCell(3).getStringCellValue());
				Date.click();
				Thread.sleep(3000);
				CloseAccountDetails.click();
				Thread.sleep(1500);
//				==================================================================
//						String tokenRepeate = errorMessageToken1.getText();
//				tokenRepeate = tokenRepeate.replace("Error", "");
//				tokenRepeate = tokenRepeate.replace("x", "");
//				tokenRepeate = tokenRepeate.trim();
//				System.out.println(tokenRepeate);
//				Thread.sleep(1500);
//				for (int a = 1; a <= 300; a++) {
//					if (tokenRepeate.equals(reversalToken)) {
//						CloseErrorMessage.click();
//						token_no_for_reversal.clear();
//						Thread.sleep(2000);
//						int tokenrevv = (int) (Math.random() * (maxtoken - mintoken + 1) + mintoken);
//						token_no_for_reversal.sendKeys(tokenrevv + "");
//						// token_no_for_reversal.sendKeys("1");
//						Thread.sleep(2000);
//						reversal_btn.click();
//					}
//					break;
//				}
//			   ===================================================================
				
				
				
				
				
				
				
				
				
				
				
				
				ADD.click();
				Thread.sleep(1500);
				Submit.click();
				Thread.sleep(1500);
				CloseErrorMessage.click();
				Thread.sleep(1500);
				Authorization.click();
				Thread.sleep(3000);
				String exp_ref_no = Expected.getText();
				Thread.sleep(1500);
				System.out.println("Expected Result: " + exp_ref_no);
				row.createCell(6).setCellValue(exp_ref_no);
				fos = new FileOutputStream(location);
				workbook.write(fos);
				emp_photo.click();
				Thread.sleep(1500);
				logout.click();
				Thread.sleep(3000);
			}
		}
	}

	public void authCasaDebit() throws Exception {
		Authorization.click();
		Thread.sleep(3000);
		String actual_ref_no = Actual.getText();
		System.out.println("Actual Result: " + actual_ref_no);
		row.createCell(7).setCellValue(actual_ref_no);
		Thread.sleep(3000);
		Actual.click();
		Thread.sleep(3000);
		Cash_Auth.click();
		Thread.sleep(3000);
		testutil.handle_popop1();
		Thread.sleep(1500);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		if (row.getCell(6).getStringCellValue().equals(actual_ref_no)) {
			row.createCell(8).setCellValue("Pass");
		} else {
			row.createCell(8).setCellValue("Fail");
		}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		row.createCell(9).setCellValue(dtf.format(now));
		fos = new FileOutputStream(location);
		workbook.write(fos);
		emp_photo.click();
		Thread.sleep(1500);
		logout.click();
		Thread.sleep(3000);
	}

	public void casaDebitPendingDenoms() throws Exception {
		Pending_Denominations.click();
		Thread.sleep(3000);
		Search_pending_denom.click();
		Thread.sleep(1500);
		Add_denom.click();
		Thread.sleep(3000);
		int new_quan = (int) row.getCell(4).getNumericCellValue();
		New_quan.sendKeys(String.valueOf(new_quan));
		Thread.sleep(1500);
		// New_quan1.sendKeys(row.getCell(4).getStringCellValue());
		Old_quan.click();
		Thread.sleep(3000);
		submit_denoms.click();
		Thread.sleep(1500);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		emp_photo.click();
		Thread.sleep(1500);
		logout.click();
	}

	// =========================================================================================================
	public void casaClose() throws Exception {
		fis = new FileInputStream(location);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Cash");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(3).getLastCellNum();
		for (int i = 3; i <= rowcount; i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < colcount; j++) {
				XSSFCell cell = (XSSFCell) row.getCell(j);
				AC_Product_Number.sendKeys(row.getCell(0).getStringCellValue());
				Thread.sleep(5000);
				Date.click();
				Select activity = new Select(Activity);
				activity.selectByVisibleText("CASA_CLOSURE");
				Thread.sleep(4000);
				// activity.selectByIndex(1);
				Thread.sleep(3000);
				CloseAccountDetails.click();
				Thread.sleep(3000);
				Transaction_Nature.click();
				Thread.sleep(3000);
				int Token = (int) row.getCell(1).getNumericCellValue();
				TokenNo.sendKeys(String.valueOf(Token));
				Thread.sleep(1500);
				// CloseAccountDetails.click();
				Thread.sleep(1500);
				InstrumentNumber.sendKeys(row.getCell(3).getStringCellValue());
				Date.click();
				Thread.sleep(1500);
				ChequeList.click();
				Thread.sleep(1500);
				OneRupeesNotes = TotalPayoutAmount.getText();
				OneRupeesNotes = OneRupeesNotes.substring(0, OneRupeesNotes.indexOf('.'));
				System.out.println("Account closing acount:" + OneRupeesNotes);
				Thread.sleep(2500);
				// CloseAccountDetails.click();
				Thread.sleep(1500);
				ADD.click();
				Thread.sleep(1500);
				Submit.click();
				Thread.sleep(1500);
				CloseErrorMessage.click();
				Thread.sleep(1500);
				Authorization.click();
				Thread.sleep(3000);
				String exp_ref_no = Expected.getText();
				Thread.sleep(1500);
				System.out.println("Expected Result: " + exp_ref_no);
				row.createCell(6).setCellValue(exp_ref_no);
				fos = new FileOutputStream(location);
				workbook.write(fos);
				emp_photo.click();
				Thread.sleep(1500);
				logout.click();
				Thread.sleep(3000);
			}
		}
	}

	public void authClose() throws Exception {
		Authorization.click();
		Thread.sleep(3000);
		String actual_ref_no = Actual.getText();
		System.out.println("Actual Result: " + actual_ref_no);
		row.createCell(7).setCellValue(actual_ref_no);
		Thread.sleep(3000);
		Actual.click();
		Thread.sleep(3000);
		Cash_Auth.click();
		Thread.sleep(3000);
		testutil.handle_popop1();
		Thread.sleep(1500);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		if (row.getCell(6).getStringCellValue().equals(actual_ref_no)) {
			row.createCell(8).setCellValue("Pass");
		} else {
			row.createCell(8).setCellValue("Fail");
		}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		row.createCell(9).setCellValue(dtf.format(now));
		fos = new FileOutputStream(location);
		workbook.write(fos);
		emp_photo.click();
		Thread.sleep(1500);
		logout.click();
		Thread.sleep(3000);
	}

	public void casaClosePendingDenoms() throws Exception {
		Pending_Denominations.click();
		Thread.sleep(3000);
		// Select txnnature = new Select(txn_nature);
		// txnnature.selectByIndex(0);
		Search_pending_denom.click();
		Thread.sleep(1500);
		Add_denom.click();
		Thread.sleep(3000);
		OneRupNotes.sendKeys(OneRupeesNotes);
		Thread.sleep(3000);
		submit_denoms.click();
		Thread.sleep(1500);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		emp_photo.click();
		Thread.sleep(1500);
		logout.click();
		// System.out.println("OneRupeesNotes before send "+OneRupeesNotes);
		// OneRupNotes.sendKeys(OneRupeesNotes);
		/*
		 * int new_quan = (int) row.getCell(4).getNumericCellValue();
		 * New_quan.sendKeys(String.valueOf(new_quan));
		 */
		// New_quan.sendKeys(row.getCell(3).getStringCellValue());
		// int new_quan1 = (int) row.getCell(5).getNumericCellValue();
		// New_quan1.sendKeys(String.valueOf(new_quan1));
		// Thread.sleep(1500);
		// New_quan1.sendKeys(row.getCell(4).getStringCellValue());
//		Old_quan.click();
		// Thread.sleep(3000);
		/*
		 * submit_denoms.click(); Thread.sleep(1500); CloseErrorMessage.click();
		 * Thread.sleep(3000); emp_photo.click(); Thread.sleep(1500); logout.click();
		 */
	}

//===============================TDAccountPayout===============================================================	
	public void TDaccountPayOut() throws Exception {
		fis = new FileInputStream(location);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Cash");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(4).getLastCellNum();
		for (int i = 4; i <= rowcount; i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < colcount; j++) {
				// XSSFCell cell=(XSSFCell) row.getCell(j);
				AC_Product_Number.sendKeys(row.getCell(0).getStringCellValue());
				Thread.sleep(4000);
				Date.click();
				Select activity = new Select(Activity);
				activity.selectByVisibleText("TD_PAYOUT");
				Thread.sleep(5000);
				String msg = CloseErrorMessage.getText();
				System.out.println(msg);
				if (msg.equals("x")) {
					CloseErrorMessage.click();
				} else {
					System.out.println("Message not found ");
				}
				Transaction_Nature.click();
				Thread.sleep(3000);
				int Token = (int) row.getCell(1).getNumericCellValue();
				TokenNo.sendKeys(String.valueOf(Token));
				Thread.sleep(3000);
				TDpayoutAmt = TDPayoutAmount.getText();
				Thread.sleep(3000);
				System.out.println(TDpayoutAmt + "TD payout amount ");
				InstrumentNumber.sendKeys(row.getCell(3).getStringCellValue());
				Date.click();
				Thread.sleep(1500);
				// ChequeList.click();
				Thread.sleep(1500);
				ADD.click();
				Thread.sleep(1500);
				Submit.click();
				Thread.sleep(1500);
				CloseErrorMessage.click();
				Thread.sleep(1500);
				Authorization.click();
				Thread.sleep(3000);
				String exp_ref_no = Expected.getText();
				Thread.sleep(1500);
				System.out.println("Expected Result: " + exp_ref_no);
				row.createCell(6).setCellValue(exp_ref_no);
				fos = new FileOutputStream(location);
				workbook.write(fos);
				emp_photo.click();
				Thread.sleep(1500);
				logout.click();
				Thread.sleep(3000);
			}
		}
	}

	public void authTDAccountPayout() throws Exception {
		Authorization.click();
		Thread.sleep(3000);
		String actual_ref_no = Actual.getText();
		System.out.println("Actual Result: " + actual_ref_no);
		row.createCell(7).setCellValue(actual_ref_no);
		Thread.sleep(3000);
		Actual.click();
		Thread.sleep(3000);
		Cash_Auth.click();
		Thread.sleep(3000);
		testutil.handle_popop1();
		Thread.sleep(1500);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		if (row.getCell(6).getStringCellValue().equals(actual_ref_no)) {
			row.createCell(8).setCellValue("Pass");
		} else {
			row.createCell(8).setCellValue("Fail");
		}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		row.createCell(9).setCellValue(dtf.format(now));
		fos = new FileOutputStream(location);
		workbook.write(fos);
		emp_photo.click();
		Thread.sleep(1500);
		logout.click();
		Thread.sleep(3000);
	}

	public void TDAccountPayoutPendingDenoms() throws Exception {
		Pending_Denominations.click();
		Thread.sleep(3000);
		Search_pending_denom.click();
		Thread.sleep(1500);
		Add_denom.click();
		Thread.sleep(3000);
		OneRupNotes.sendKeys(TDpayoutAmt);
		Thread.sleep(3000);
		submit_denoms.click();
		Thread.sleep(1500);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		emp_photo.click();
		Thread.sleep(1500);
		logout.click();
	}

//=============================================TD Account PayIn======================================
	public void TDaccountPayIN() throws Exception {
		fis = new FileInputStream(location);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Cash");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(5).getLastCellNum();
		for (int i = 5; i <= rowcount; i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < colcount; j++) {
				// XSSFCell cell=(XSSFCell) row.getCell(j);
				AC_Product_Number.sendKeys(row.getCell(0).getStringCellValue());
				Thread.sleep(4000);
				Date.click();
				Select activity = new Select(Activity);
				activity.selectByVisibleText("TD_PAYIN");
				Transaction_Nature.click();
				Thread.sleep(3000);
				InstrumentNumber.sendKeys(row.getCell(3).getStringCellValue());
				Date.click();
				// ChequeList.click();
				Thread.sleep(1500);
				ADD.click();
				Thread.sleep(1500);
				TDReqAmount = TDRequestAmt.getText();
				Submit.click();
				Thread.sleep(1500);
				CloseErrorMessage.click();
				Thread.sleep(1500);
				Pending_Denominations.click();
				Thread.sleep(3000);
				Select txnnature = new Select(txn_nature);
				txnnature.selectByVisibleText("Credit");
				Search_pending_denom.click();
				Thread.sleep(1500);
				Add_denom.click();
				OneRupNotes.sendKeys(TDReqAmount);
				submit_denoms.click();
				Thread.sleep(1500);
				CloseErrorMessage.click();
				Thread.sleep(1500);
				Authorization.click();
				Thread.sleep(3000);
				String exp_ref_no = Expected.getText();
				Thread.sleep(1500);
				System.out.println("Expected Result: " + exp_ref_no);
				row.createCell(6).setCellValue(exp_ref_no);
				fos = new FileOutputStream(location);
				workbook.write(fos);
				emp_photo.click();
				Thread.sleep(1500);
				logout.click();
				Thread.sleep(3000);
			}
		}
	}

	public void authTDAccountPayIN() throws Exception {
		Authorization.click();
		Thread.sleep(3000);
		String actual_ref_no = Actual.getText();
		System.out.println("Actual Result: " + actual_ref_no);
		row.createCell(7).setCellValue(actual_ref_no);
		Thread.sleep(3000);
		Actual.click();
		Thread.sleep(3000);
		Cash_Auth.click();
		Thread.sleep(3000);
		testutil.handle_popop1();
		Thread.sleep(1500);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		if (row.getCell(6).getStringCellValue().equals(actual_ref_no)) {
			row.createCell(8).setCellValue("Pass");
		} else {
			row.createCell(8).setCellValue("Fail");
		}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		row.createCell(9).setCellValue(dtf.format(now));
		fos = new FileOutputStream(location);
		workbook.write(fos);
		emp_photo.click();
		Thread.sleep(1500);
		logout.click();
		Thread.sleep(3000);
	}

//================================================LoanAccount Disbusment===============
	public void LaonACDisbursment() throws Exception {
		fis = new FileInputStream(location);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Cash");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(6).getLastCellNum();
		for (int i = 6; i <= rowcount; i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < colcount; j++) {
				XSSFCell cell = (XSSFCell) row.getCell(j);
				AC_Product_Number.sendKeys(row.getCell(0).getStringCellValue());
				Date.click();
				Thread.sleep(5000);
				Select activity = new Select(Activity);
				activity.selectByVisibleText("LOAN_DISBURSMENT");
				// activity.selectByIndex(1);
				Transaction_Nature.click();
				Thread.sleep(3000);
				int Token = (int) row.getCell(1).getNumericCellValue();
				TokenNo.sendKeys(String.valueOf(Token));
//				double amount = (double) row.getCell(2).getNumericCellValue();
				availableBalance = AvailableBalance.getText();
				Amount.sendKeys(availableBalance);
				availableBalance = availableBalance.substring(0, availableBalance.indexOf('.'));
				InstrumentNumber.sendKeys(row.getCell(3).getStringCellValue());
				Date.click();
				Thread.sleep(1500);
				ADD.click();
				Thread.sleep(1500);
				Submit.click();
				Thread.sleep(1500);
				CloseErrorMessage.click();
				Thread.sleep(1500);
				Authorization.click();
				Thread.sleep(3000);
				String exp_ref_no = Expected.getText();
				Thread.sleep(1500);
				System.out.println("Expected Result: " + exp_ref_no);
				row.createCell(6).setCellValue(exp_ref_no);
				fos = new FileOutputStream(location);
				workbook.write(fos);
				emp_photo.click();
				Thread.sleep(1500);
				logout.click();
				Thread.sleep(3000);
			}
		}
	}

	public void authLaonACDisbursment() throws Exception {
		Authorization.click();
		Thread.sleep(3000);
		String actual_ref_no = Actual.getText();
		System.out.println("Actual Result: " + actual_ref_no);
		row.createCell(7).setCellValue(actual_ref_no);
		Thread.sleep(3000);
		Actual.click();
		Thread.sleep(3000);
		Cash_Auth.click();
		Thread.sleep(3000);
		testutil.handle_popop1();
		Thread.sleep(1500);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		if (row.getCell(6).getStringCellValue().equals(actual_ref_no)) {
			row.createCell(8).setCellValue("Pass");
		} else {
			row.createCell(8).setCellValue("Fail");
		}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		row.createCell(9).setCellValue(dtf.format(now));
		fos = new FileOutputStream(location);
		workbook.write(fos);
		emp_photo.click();
		Thread.sleep(1500);
		logout.click();
		Thread.sleep(3000);
	}

	public void LaonACDisbursmentPendingDenoms() throws Exception {
		Pending_Denominations.click();
		Thread.sleep(3000);
		Search_pending_denom.click();
		Thread.sleep(1500);
		Add_denom.click();
		Thread.sleep(3000);
		OneRupNotes.sendKeys(availableBalance);
		Thread.sleep(3000);
		submit_denoms.click();
		Thread.sleep(1500);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		emp_photo.click();
		Thread.sleep(1500);
		logout.click();
	}

//=========================================LoanAc Installment credit==============================
	public void LoanACInstallmentCredit() throws Exception {

		fis = new FileInputStream(location);
		// fis=new FileInputStream("");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Cash");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(7).getLastCellNum();
		for (int i = 7; i <= rowcount; i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < colcount; j++) {
				XSSFCell cell = (XSSFCell) row.getCell(j);
				AC_Product_Number.sendKeys(row.getCell(0).getStringCellValue());
				Date.click();
				Thread.sleep(5000);
				Select activity = new Select(Activity);
				activity.selectByVisibleText("LOAN_INSTALLMENT_CREDIT");
				// activity.selectByIndex(2);
				Transaction_Nature.click();
				Thread.sleep(1500);
				// long amount=(long) cell.getNumericCellValue();
				double amount = (double) row.getCell(2).getNumericCellValue();
				Amount.sendKeys(String.valueOf(amount));
				// double instnum = (double) row.getCell(2).getNumericCellValue();
				InstrumentNumber.sendKeys(row.getCell(3).getStringCellValue()); // Instrument
				ADD.click();
				Thread.sleep(1500);
				Submit.click();
				Thread.sleep(1500);
				CloseErrorMessage.click();
				Thread.sleep(1500);
				Pending_Denominations.click();
				Thread.sleep(3000);
				Select txnnature = new Select(txn_nature);
				txnnature.selectByVisibleText("Credit");
				Search_pending_denom.click();
				Thread.sleep(1500);
				Add_denom.click();
				Thread.sleep(3000);
				int new_quan1 = (int) row.getCell(5).getNumericCellValue();
				New_quan1.sendKeys(String.valueOf(new_quan1));
				Thread.sleep(1500);
				Thread.sleep(3000);
				submit_denoms.click();
				Thread.sleep(1500);
				CloseErrorMessage.click();
				Thread.sleep(3000);
				Authorization.click();
				Thread.sleep(3000);
				String exp_ref_no = Expected.getText();
				Thread.sleep(1500);
				System.out.println("Expected Result: " + exp_ref_no);
				row.createCell(6).setCellValue(exp_ref_no);
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				row.createCell(9).setCellValue(dtf.format(now));
				fos = new FileOutputStream(location);
				workbook.write(fos);
				emp_photo.click();
				Thread.sleep(1500);
				logout.click();
				Thread.sleep(3000);
			}
		}
	}

	public void authLoanACInstallmentCredit() throws Exception {
		Authorization.click();
		Thread.sleep(3000);
		String actual_ref_no = Actual.getText();
		System.out.println("Actual Result: " + actual_ref_no);
		row.createCell(7).setCellValue(actual_ref_no);
		Thread.sleep(3000);
		Actual.click();
		Thread.sleep(3000);
		Cash_Auth.click();
		Thread.sleep(3000);
		testutil.handle_popop1();
		Thread.sleep(1500);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		if (row.getCell(6).getStringCellValue().equals(actual_ref_no)) {
			row.createCell(8).setCellValue("Pass");
		} else {
			row.createCell(8).setCellValue("Fail");
		}
		fos = new FileOutputStream(location);
		workbook.write(fos);
		emp_photo.click();
		Thread.sleep(1500);
		logout.click();
		Thread.sleep(3000);
	}

//===============================================loan Ac closure=====================
	public void LoanACCreditForClosure() throws Exception {
		fis = new FileInputStream(location);
		// fis=new FileInputStream("");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Cash");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(8).getLastCellNum();
		for (int i = 8; i <= rowcount; i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < colcount; j++) {
				XSSFCell cell = (XSSFCell) row.getCell(j);
				AC_Product_Number.sendKeys(row.getCell(0).getStringCellValue());
				Date.click();
				Thread.sleep(5000);
				Select activity = new Select(Activity);
				activity.selectByVisibleText("LOAN_ACCOUNT_CLOSURE");
				Thread.sleep(1500);
				CloseAccountDetails.click();
				Thread.sleep(1500);
				Transaction_Nature.click();
				Thread.sleep(1500);
				InstrumentNumber.sendKeys(row.getCell(3).getStringCellValue()); // Instrument
				ADD.click();
				Thread.sleep(1500);
				requestAmount = RequestAmount.getText();
				Submit.click();
				Thread.sleep(1500);
				CloseErrorMessage.click();
				Thread.sleep(1500);
				Pending_Denominations.click();
				Thread.sleep(3000);
				Select txnnature = new Select(txn_nature);
				txnnature.selectByVisibleText("Credit");
				// txnnature.selectByIndex(0);
				Search_pending_denom.click();
				Thread.sleep(1500);
				Add_denom.click();
				Thread.sleep(3000);
				OneRupNotes.sendKeys(requestAmount);
				Thread.sleep(3000);
				submit_denoms.click();
				Thread.sleep(1500);
				CloseErrorMessage.click();
				Thread.sleep(3000);
				Authorization.click();
				Thread.sleep(3000);
				String exp_ref_no = Expected.getText();
				Thread.sleep(1500);
				System.out.println("Expected Result: " + exp_ref_no);
				row.createCell(6).setCellValue(exp_ref_no);
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				row.createCell(9).setCellValue(dtf.format(now));
				fos = new FileOutputStream(location);
				workbook.write(fos);
				emp_photo.click();
				Thread.sleep(1500);
				logout.click();
				Thread.sleep(3000);
			}
		}
	}

	public void authLoanACCreditForClosure() throws Exception {
		Authorization.click();
		Thread.sleep(3000);
		String actual_ref_no = Actual.getText();
		System.out.println("Actual Result: " + actual_ref_no);
		row.createCell(7).setCellValue(actual_ref_no);
		Thread.sleep(3000);
		Actual.click();
		Thread.sleep(3000);
		Cash_Auth.click();
		Thread.sleep(3000);
		testutil.handle_popop1();
		Thread.sleep(1500);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		if (row.getCell(6).getStringCellValue().equals(actual_ref_no)) {
			row.createCell(8).setCellValue("Pass");
		} else {
			row.createCell(8).setCellValue("Fail");
		}
		fos = new FileOutputStream(location);
		workbook.write(fos);
		emp_photo.click();
		Thread.sleep(1500);
		logout.click();
		Thread.sleep(3000);
	}

//================================================InternalProduct Credit================================	
	public void InternalProductCredit() throws Exception {
		fis = new FileInputStream(location);
		// fis=new FileInputStream("");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Cash");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(9).getLastCellNum();
		for (int i = 9; i <= rowcount; i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < colcount; j++) {
				XSSFCell cell = (XSSFCell) row.getCell(j);
				AC_Product_Number.click();
				AC_Product_Number.sendKeys(Keys.F1);
				Thread.sleep(5000);
				Actions ac = new Actions(driver);
//				ac.keyDown(Keys.F1);
//				ac.build().perform();
//				ac.keyUp(Keys.F1);
//				ac.build().perform();
//				ac.sendKeys(InternalPriduct, doubleclick());
				ac.moveToElement(InternalPriduct).doubleClick().build().perform();
				Date.click();
				Thread.sleep(5000);
				Select activity = new Select(Activity);
				activity.selectByVisibleText("INTERNAL_PRODUCT_CREDIT");
				// activity.selectByIndex(2);
				Transaction_Nature.click();
				Thread.sleep(1500);
				// long amount=(long) cell.getNumericCellValue();
				double amount = (double) row.getCell(2).getNumericCellValue();
				Amount.sendKeys(String.valueOf(amount));
				// double instnum = (double) row.getCell(2).getNumericCellValue();
				InstrumentNumber.sendKeys(row.getCell(3).getStringCellValue()); // Instrument
				ADD.click();
				Thread.sleep(1500);
				Submit.click();
				Thread.sleep(1500);
				CloseErrorMessage.click();
				Thread.sleep(1500);
				Pending_Denominations.click();
				Thread.sleep(3000);
				Select txnnature = new Select(txn_nature);
				txnnature.selectByVisibleText("Credit");
				// txnnature.selectByIndex(0);
				Search_pending_denom.click();
				Thread.sleep(1500);
				Add_denom.click();
				Thread.sleep(3000);
				int new_quan = (int) row.getCell(4).getNumericCellValue();
				New_quan.sendKeys(String.valueOf(new_quan));
				int new_quan1 = (int) row.getCell(5).getNumericCellValue();
				New_quan1.sendKeys(String.valueOf(new_quan1));
				Thread.sleep(1500);
				Old_quan.click();
				Thread.sleep(3000);
				submit_denoms.click();
				Thread.sleep(1500);
				CloseErrorMessage.click();
				Thread.sleep(3000);
				Authorization.click();
				Thread.sleep(3000);
				String exp_ref_no = Expected.getText();
				Thread.sleep(1500);
				System.out.println("Expected Result: " + exp_ref_no);
				row.createCell(6).setCellValue(exp_ref_no);
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				row.createCell(9).setCellValue(dtf.format(now));
				fos = new FileOutputStream(location);
				workbook.write(fos);
				emp_photo.click();
				Thread.sleep(1500);
				logout.click();
				Thread.sleep(3000);
			}
		}
	}

	public void authInternalProductCredit() throws Exception {
		Authorization.click();
		Thread.sleep(3000);
		String actual_ref_no = Actual.getText();
		System.out.println("Actual Result: " + actual_ref_no);
		row.createCell(7).setCellValue(actual_ref_no);
		Thread.sleep(3000);
		Actual.click();
		Thread.sleep(3000);
		Cash_Auth.click();
		Thread.sleep(3000);
		testutil.handle_popop1();
		Thread.sleep(1500);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		if (row.getCell(6).getStringCellValue().equals(actual_ref_no)) {
			row.createCell(8).setCellValue("Pass");
		} else {
			row.createCell(8).setCellValue("Fail");
		}
		fos = new FileOutputStream(location);
		workbook.write(fos);
		emp_photo.click();
		Thread.sleep(1500);
		logout.click();
		Thread.sleep(3000);
	}

// ================================internal Product debit============================================
	public void InternalProductDebit() throws Exception {
		fis = new FileInputStream(location);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Cash");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(10).getLastCellNum();
		for (int i = 10; i <= rowcount; i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < colcount; j++) {
//				XSSFCell cell=(XSSFCell) row.getCell(j);
//				AC_Product_Number.sendKeys(row.getCell(0).getStringCellValue());
				AC_Product_Number.click();
				AC_Product_Number.sendKeys(Keys.F1);
				Thread.sleep(5000);
				Actions ac = new Actions(driver);
//				ac.keyDown(Keys.F1);
//				ac.build().perform();
//				ac.keyUp(Keys.F1);
//				ac.build().perform();
//				ac.sendKeys(InternalPriduct, doubleclick());
				ac.moveToElement(InternalPriduct).doubleClick().build().perform();
				Date.click();
				Thread.sleep(5000);
				Select activity = new Select(Activity);
				activity.selectByVisibleText("INTERNAL_PRODUCT_DEBIT");
				Transaction_Nature.click();
				Thread.sleep(3000);
				int Token = (int) row.getCell(1).getNumericCellValue();
				TokenNo.sendKeys(String.valueOf(Token));
				double amount = (double) row.getCell(2).getNumericCellValue();
				Amount.sendKeys(String.valueOf(amount));
				InstrumentNumber.sendKeys(row.getCell(3).getStringCellValue());
				Date.click();
				Thread.sleep(1500);
				ADD.click();
				Thread.sleep(1500);
				Submit.click();
				Thread.sleep(1500);
				CloseErrorMessage.click();
				Thread.sleep(1500);
				Authorization.click();
				Thread.sleep(3000);
				String exp_ref_no = Expected.getText();
				Thread.sleep(1500);
				System.out.println("Expected Result: " + exp_ref_no);
				row.createCell(6).setCellValue(exp_ref_no);
				fos = new FileOutputStream(location);
				workbook.write(fos);
				emp_photo.click();
				Thread.sleep(1500);
				logout.click();
				Thread.sleep(3000);
			}
		}
	}

	public void authInternalProductDebit() throws Exception {
		Authorization.click();
		Thread.sleep(3000);
		String actual_ref_no = Actual.getText();
		System.out.println("Actual Result: " + actual_ref_no);
		row.createCell(7).setCellValue(actual_ref_no);
		Thread.sleep(3000);
		Actual.click();
		Thread.sleep(3000);
		Cash_Auth.click();
		Thread.sleep(3000);
		testutil.handle_popop1();
		Thread.sleep(1500);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		if (row.getCell(6).getStringCellValue().equals(actual_ref_no)) {
			row.createCell(8).setCellValue("Pass");
		} else {
			row.createCell(8).setCellValue("Fail");
		}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		row.createCell(9).setCellValue(dtf.format(now));
		fos = new FileOutputStream(location);
		workbook.write(fos);
		emp_photo.click();
		Thread.sleep(1500);
		logout.click();
		Thread.sleep(3000);
	}

	public void InternalProductDebitPdendingDenoms() throws Exception {
		Pending_Denominations.click();
		Thread.sleep(3000);
		Search_pending_denom.click();
		Thread.sleep(1500);
		Add_denom.click();
		Thread.sleep(3000);
		int new_quan = (int) row.getCell(4).getNumericCellValue();
		New_quan.sendKeys(String.valueOf(new_quan));
		Thread.sleep(1500);
		Old_quan.click();
		Thread.sleep(3000);
		submit_denoms.click();
		Thread.sleep(1500);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		emp_photo.click();
		Thread.sleep(1500);
		logout.click();
	}

//============================================Internl AC activity ========================================
	public void InternalACCredit() throws Exception {
		fis = new FileInputStream(location);
		// fis=new FileInputStream("");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Cash");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(11).getLastCellNum();
		for (int i = 11; i <= rowcount; i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < colcount; j++) {
				XSSFCell cell = (XSSFCell) row.getCell(j);
				AC_Product_Number.click();
				AC_Product_Number.sendKeys(Keys.F2);
				Thread.sleep(5000);
				Actions ac = new Actions(driver);

//				ac.keyDown(Keys.F1);
//				ac.build().perform();
//				ac.keyUp(Keys.F1);
//				ac.build().perform();
//				ac.sendKeys(InternalPriduct, doubleclick());
				ac.moveToElement(InternalPriduct).doubleClick().build().perform();
				Date.click();
				Thread.sleep(5000);
				Select activity = new Select(Activity);
				activity.selectByVisibleText("INTERNAL_ACCOUNT_CREDIT");
				// activity.selectByIndex(2);
				Transaction_Nature.click();
				Thread.sleep(1500);
				// long amount=(long) cell.getNumericCellValue();
				double amount = (double) row.getCell(2).getNumericCellValue();
				Amount.sendKeys(String.valueOf(amount));
				// double instnum = (double) row.getCell(2).getNumericCellValue();
				InstrumentNumber.sendKeys(row.getCell(3).getStringCellValue()); // Instrument
				ADD.click();
				Thread.sleep(1500);
				Submit.click();
				Thread.sleep(1500);
				CloseErrorMessage.click();
				Thread.sleep(1500);
				Pending_Denominations.click();
				Thread.sleep(3000);
				Select txnnature = new Select(txn_nature);
				txnnature.selectByVisibleText("Credit");
				// txnnature.selectByIndex(0);
				Search_pending_denom.click();
				Thread.sleep(1500);
				Add_denom.click();
				Thread.sleep(3000);
				int new_quan = (int) row.getCell(4).getNumericCellValue();
				New_quan.sendKeys(String.valueOf(new_quan));
				int new_quan1 = (int) row.getCell(5).getNumericCellValue();
				New_quan1.sendKeys(String.valueOf(new_quan1));
				Thread.sleep(1500);
				Old_quan.click();
				Thread.sleep(3000);
				submit_denoms.click();
				Thread.sleep(1500);
				CloseErrorMessage.click();
				Thread.sleep(3000);
				Authorization.click();
				Thread.sleep(3000);
				String exp_ref_no = Expected.getText();
				Thread.sleep(1500);
				System.out.println("Expected Result: " + exp_ref_no);
				row.createCell(6).setCellValue(exp_ref_no);
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				row.createCell(9).setCellValue(dtf.format(now));
				fos = new FileOutputStream(location);
				workbook.write(fos);
				emp_photo.click();
				Thread.sleep(1500);
				logout.click();
				Thread.sleep(3000);
			}
		}
	}

	public void authInternalACCredit() throws Exception {
		Authorization.click();
		Thread.sleep(3000);
		String actual_ref_no = Actual.getText();
		System.out.println("Actual Result: " + actual_ref_no);
		row.createCell(7).setCellValue(actual_ref_no);
		Thread.sleep(3000);
		Actual.click();
		Thread.sleep(3000);
		Cash_Auth.click();
		Thread.sleep(3000);
		testutil.handle_popop1();
		Thread.sleep(1500);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		if (row.getCell(6).getStringCellValue().equals(actual_ref_no)) {
			row.createCell(8).setCellValue("Pass");
		} else {
			row.createCell(8).setCellValue("Fail");
		}
		fos = new FileOutputStream(location);
		workbook.write(fos);
		emp_photo.click();
		Thread.sleep(1500);
		logout.click();
		Thread.sleep(3000);
	}

//===============================================Internal AC debit  ===========================	
	public void InternalACDebit() throws Exception {
		fis = new FileInputStream(location);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Cash");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(12).getLastCellNum();
		for (int i = 12; i <= rowcount; i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < colcount; j++) {
//				XSSFCell cell=(XSSFCell) row.getCell(j);
//				AC_Product_Number.sendKeys(row.getCell(0).getStringCellValue());
				AC_Product_Number.click();
				AC_Product_Number.sendKeys(Keys.F2);
				Thread.sleep(5000);
				Actions ac = new Actions(driver);
//				ac.keyDown(Keys.F1);
//				ac.build().perform();
//				ac.keyUp(Keys.F1);
//				ac.build().perform();
//				ac.sendKeys(InternalPriduct, doubleclick());
				ac.moveToElement(InternalPriduct).doubleClick().build().perform();
				Date.click();
				Thread.sleep(5000);
				Select activity = new Select(Activity);
				activity.selectByVisibleText("INTERNAL_ACCOUNT_DEBIT");
				Transaction_Nature.click();
				Thread.sleep(3000);
				int Token = (int) row.getCell(1).getNumericCellValue();
				TokenNo.sendKeys(String.valueOf(Token));
				double amount = (double) row.getCell(2).getNumericCellValue();
				Amount.sendKeys(String.valueOf(amount));
				InstrumentNumber.sendKeys(row.getCell(3).getStringCellValue());
				Date.click();
				Thread.sleep(1500);
				ADD.click();
				Thread.sleep(1500);
				Submit.click();
				Thread.sleep(1500);
				CloseErrorMessage.click();
				Thread.sleep(1500);
				Authorization.click();
				Thread.sleep(3000);
				String exp_ref_no = Expected.getText();
				Thread.sleep(1500);
				System.out.println("Expected Result: " + exp_ref_no);
				row.createCell(6).setCellValue(exp_ref_no);
				fos = new FileOutputStream(location);
				workbook.write(fos);
				emp_photo.click();
				Thread.sleep(1500);
				logout.click();
				Thread.sleep(3000);
			}
		}
	}

	public void authInternalACDebit() throws Exception {
		Authorization.click();
		Thread.sleep(3000);
		String actual_ref_no = Actual.getText();
		System.out.println("Actual Result: " + actual_ref_no);
		row.createCell(7).setCellValue(actual_ref_no);
		Thread.sleep(3000);
		Actual.click();
		Thread.sleep(3000);
		Cash_Auth.click();
		Thread.sleep(3000);
		testutil.handle_popop1();
		Thread.sleep(1500);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		if (row.getCell(6).getStringCellValue().equals(actual_ref_no)) {
			row.createCell(8).setCellValue("Pass");
		} else {
			row.createCell(8).setCellValue("Fail");
		}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		row.createCell(9).setCellValue(dtf.format(now));
		fos = new FileOutputStream(location);
		workbook.write(fos);
		emp_photo.click();
		Thread.sleep(1500);
		logout.click();
		Thread.sleep(3000);
	}

	public void InternalACDebitPdendingDenoms() throws Exception {
		Pending_Denominations.click();
		Thread.sleep(3000);
		Search_pending_denom.click();
		Thread.sleep(1500);
		Add_denom.click();
		Thread.sleep(3000);
		int new_quan = (int) row.getCell(4).getNumericCellValue();
		New_quan.sendKeys(String.valueOf(new_quan));
		Thread.sleep(1500);
		Old_quan.click();
		Thread.sleep(3000);
		submit_denoms.click();
		Thread.sleep(1500);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		emp_photo.click();
		Thread.sleep(1500);
		logout.click();
	}

//=========================================test for for loop=========================

	public void addmultuiplecredit1() throws Exception {
		// cons.counter = 1;
		fis = new FileInputStream(location);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("MultipleTrancsa");
		int rowcount = sheet.getLastRowNum();
		for (int i = 1; i <= rowcount; i++) {
			System.out.println("Check The given output:" + i);
			int colcount = sheet.getRow(i).getLastCellNum();
			row = sheet.getRow(i);
			for (int j = 0; j < colcount; j++) {
				XSSFCell cell = (XSSFCell) row.getCell(j);
				AC_Product_Number.sendKeys(row.getCell(0).getStringCellValue());
				Date.click();
				Select activity = new Select(Activity);
				activity.selectByVisibleText("CASA_CREDIT");
				Transaction_Nature.click();
				Thread.sleep(1000);
				// double amount =(double) row.getCell(1).getNumericCellValue();
				Amount.sendKeys(row.getCell(1).getStringCellValue());
				InstrumentNumber.sendKeys(row.getCell(2).getStringCellValue());
				ADD.click();
				Thread.sleep(1000);
				Submit.click();
				Thread.sleep(1000);
				CloseErrorMessage.click();
				Thread.sleep(1000);
				// driver.findElement(By.xpath("//li[@id='id_post_transaction_cash']")).click();
				Pending_Denominations.click();
				Thread.sleep(1000);
				Select txnnature = new Select(txn_nature);
				txnnature.selectByVisibleText("Credit");
				// txnnature.selectByIndex(0);
				Search_pending_denom.click();
				Thread.sleep(1000);
				Add_denom.click();
				// Thread.sleep(1000);
				// int new_quan = (int) row.getCell(4).getNumericCellValue();
				// New_quan.sendKeys(String.valueOf(new_quan));
				// int new_quan1 = (int) row.getCell(4).getNumericCellValue();
				New_quan1.sendKeys(row.getCell(4).getStringCellValue());
				Thread.sleep(1000);
				Old_quan.click();
				Thread.sleep(1000);
				submit_denoms.click();
				Thread.sleep(600);
				CloseErrorMessage.click();
				Thread.sleep(1000);
				Authorization.click();
				Thread.sleep(1000);
				System.out.println(Expected.getText());
				String exp_ref_no = Expected.getText();
				Thread.sleep(1000);
				System.out.println("Expected Result: " + exp_ref_no + "value of i " + i);
				row.createCell(6).setCellValue(exp_ref_no);
				fos = new FileOutputStream(location);
				workbook.write(fos);
				PostTransaction.click();
				Thread.sleep(1000);
				break;
			}

		}
		testutil.Logout();
	}

	public void authaddmultuiplecredit1() throws Exception {
		fis = new FileInputStream(location);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("MultipleTrancsa");
		int rowcount = sheet.getLastRowNum();
		// for (counter =1;counter<=rowcount;counter++)
		for (int m = 1; m <= rowcount; m++) {
			System.out.println("Check The given output:" + m);
			int colcount = sheet.getRow(m).getLastCellNum();
			row = sheet.getRow(m);
			for (int n = 0; n < colcount; n++) {
				XSSFCell cell = (XSSFCell) row.getCell(n);
				Authorization.click();
				Thread.sleep(1000);
				enterRef_number.sendKeys(row.getCell(6).getStringCellValue());
				ref_num_Search.click();
				Thread.sleep(1000);
				Actual.click();
				String data = driver.findElement(By.xpath(
						"//table[@class='table table-striped table-bordered']/tbody/tr[1]/td/a[@id='reference_no0']"))
						.getText();
				row.createCell(7).setCellValue(data);
				Thread.sleep(1000);
				Cash_Auth.click();
				Thread.sleep(1000);
				testutil.handle_popop1();
				Thread.sleep(1000);
				CloseErrorMessage.click();
				Thread.sleep(1000);
				if (row.getCell(6).getStringCellValue().equals(data)) {
					row.createCell(8).setCellValue("Pass");
				} else {
					row.createCell(8).setCellValue("Fail");
				}
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				row.createCell(9).setCellValue(dtf.format(now));
				fos = new FileOutputStream(location);
				workbook.write(fos);
//				emp_photo.click();
//				Thread.sleep(1500);
//				logout.click();
//				Thread.sleep(3000);
				break;
			}
		}
		testutil.Logout();
	}

	public void casaCreditCancalAuthorization() throws Exception {

		fis = new FileInputStream(location);
		// fis=new FileInputStream("");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Cash");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(13).getLastCellNum();
		for (int i = 13; i <= rowcount; i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < colcount; j++) {
				XSSFCell cell = (XSSFCell) row.getCell(j);
				AC_Product_Number.sendKeys(row.getCell(0).getStringCellValue());
				Date.click();
				Thread.sleep(5000);
				Select activity = new Select(Activity);
				activity.selectByVisibleText("CASA_CREDIT");
				// activity.selectByIndex(2);
				Transaction_Nature.click();
				Thread.sleep(1500);
				// long amount=(long) cell.getNumericCellValue();
				double amount = (double) row.getCell(2).getNumericCellValue();
				Amount.sendKeys(String.valueOf(amount));
				// double instnum = (double) row.getCell(2).getNumericCellValue();
				InstrumentNumber.sendKeys(row.getCell(3).getStringCellValue()); // Instrument
				ADD.click();
				Thread.sleep(1500);
				Submit.click();
				Thread.sleep(1500);
				CloseErrorMessage.click();
				Thread.sleep(1500);
				Authorization.click();
				Thread.sleep(3000);
				String exp_ref_no = Expected.getText();
				Thread.sleep(1500);
				System.out.println("Expected Result: " + exp_ref_no);
				row.createCell(6).setCellValue(exp_ref_no);
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				row.createCell(9).setCellValue(dtf.format(now));
				fos = new FileOutputStream(location);
				workbook.write(fos);
				Thread.sleep(1500);
				Expected.click();
				Thread.sleep(1500);
				cancalTransaction.click();
				Thread.sleep(1500);
				testutil.handle_popop1();
				Thread.sleep(1500);
				CloseErrorMessage.click();
				emp_photo.click();
				Thread.sleep(1500);
				logout.click();
				Thread.sleep(3000);
			}
		}
	}

	public void casaCreditReject() throws Exception {

		fis = new FileInputStream(location);
		// fis=new FileInputStream("");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Cash");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(14).getLastCellNum();
		for (int i = 14; i <= rowcount; i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < colcount; j++) {
				XSSFCell cell = (XSSFCell) row.getCell(j);
				AC_Product_Number.sendKeys(row.getCell(0).getStringCellValue());
				Date.click();
				Thread.sleep(5000);
				Select activity = new Select(Activity);
				activity.selectByVisibleText("CASA_CREDIT");
				Transaction_Nature.click();
				Thread.sleep(1500);
				double amount = (double) row.getCell(2).getNumericCellValue();
				Amount.sendKeys(String.valueOf(amount));
				InstrumentNumber.sendKeys(row.getCell(3).getStringCellValue());
				ADD.click();
				Thread.sleep(1500);
				Submit.click();
				Thread.sleep(1500);
				CloseErrorMessage.click();
				Thread.sleep(1500);
				driver.findElement(By.xpath("//li[@id='id_post_transaction_cash']")).click();
				Pending_Denominations.click();
				Thread.sleep(3000);
				Select txnnature = new Select(txn_nature);
				txnnature.selectByVisibleText("Credit");
				Search_pending_denom.click();
				Thread.sleep(1500);
				Add_denom.click();
				Thread.sleep(3000);
				int new_quan = (int) row.getCell(4).getNumericCellValue();
				New_quan.sendKeys(String.valueOf(new_quan));
				int new_quan1 = (int) row.getCell(5).getNumericCellValue();
				New_quan1.sendKeys(String.valueOf(new_quan1));
				Thread.sleep(1500);
				Old_quan.click();
				Thread.sleep(3000);
				submit_denoms.click();
				Thread.sleep(1500);
				CloseErrorMessage.click();
				Thread.sleep(3000);
				Authorization.click();
				Thread.sleep(3000);
				String exp_ref_no = Expected.getText();
				Thread.sleep(1500);
				System.out.println("Expected Result: " + exp_ref_no);
				row.createCell(6).setCellValue(exp_ref_no);
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				row.createCell(9).setCellValue(dtf.format(now));
				fos = new FileOutputStream(location);
				workbook.write(fos);
				// driver.findElement(By.xpath("//li[@id='id_post_transaction_cash']")).click();
				emp_photo.click();
				Thread.sleep(1500);
				logout.click();
				Thread.sleep(3000);
			}
		}
	}

	public void authCasaCreditReject() throws Exception {
		Authorization.click();
		Thread.sleep(3000);
		String actual_ref_no = Actual.getText();
		System.out.println("Actual Result: " + actual_ref_no);
		row.createCell(7).setCellValue(actual_ref_no);
		Thread.sleep(3000);
		Actual.click();
		Thread.sleep(3000);
		rejectTransaction.click();
		Thread.sleep(3000);
		testutil.handle_popop1();
		Thread.sleep(1500);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		if (row.getCell(6).getStringCellValue().equals(actual_ref_no)) {
			row.createCell(8).setCellValue("Pass");
		} else {
			row.createCell(8).setCellValue("Fail");
		}
		fos = new FileOutputStream(location);
		workbook.write(fos);
		emp_photo.click();
		Thread.sleep(1500);
		logout.click();
		Thread.sleep(3000);
	}

	public void cashReversal() throws Exception {
		fis = new FileInputStream(location);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Cash");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(15).getLastCellNum();
		for (int i = 15; i <= rowcount; i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < colcount; j++) {
				Thread.sleep(1500);
				completed_cash.click();
				Thread.sleep(1000);
				Actual.click();
				Thread.sleep(1000);
				int tokenrev = (int) (Math.random() * (maxtoken - mintoken + 1) + mintoken);
				token_no_for_reversal.sendKeys(tokenrev + "");
				// token_no_for_reversal.sendKeys("1");
				Thread.sleep(2000);
				reversal_btn.click();
				Thread.sleep(1500);
				String tokenRepeate = errorMessageToken1.getText();
				tokenRepeate = tokenRepeate.replace("Error", "");
				tokenRepeate = tokenRepeate.replace("x", "");
				tokenRepeate = tokenRepeate.trim();
				System.out.println(tokenRepeate);
				Thread.sleep(1500);
				for (int a = 1; a <= 300; a++) {
					if (tokenRepeate.equals(reversalToken)) {
						CloseErrorMessage.click();
						token_no_for_reversal.clear();
						Thread.sleep(2000);
						int tokenrevv = (int) (Math.random() * (maxtoken - mintoken + 1) + mintoken);
						token_no_for_reversal.sendKeys(tokenrevv + "");
						// token_no_for_reversal.sendKeys("1");
						Thread.sleep(2000);
						reversal_btn.click();
					}
					break;
				}

				testutil.handle_popop1();
				Thread.sleep(1500);
				CloseErrorMessage.click();
				Thread.sleep(1500);
				pending_reversal_txns.click();
				Thread.sleep(3000);
				String actual_ref_numbber = reversal_ref_number.getText();
				row.createCell(6).setCellValue(actual_ref_numbber);
				fos = new FileOutputStream(location);
				workbook.write(fos);
				testutil.Logout();
			}
		}
	}

	public void authCashReversal() throws Exception {
		pending_reversal_txns.click();
		Thread.sleep(2000);
		String expected_ref_num = reversal_ref_number.getText();
		row.createCell(7).setCellValue(expected_ref_num);
		reversal_ref_number.click();
		Thread.sleep(1500);
		// String expected_ref_num = Actual_ref_num.getText();
		Thread.sleep(1500);
		Cash_Auth.click();
		testutil.handle_popop1();
		Thread.sleep(1500);
		CloseErrorMessage.click();
		System.out.println("fgfuyfuuhghgghghg");
		System.out.println(expected_ref_num);
		Thread.sleep(1500);
		row.createCell(7).setCellValue(expected_ref_num);
		if (row.getCell(6).getStringCellValue().equals(expected_ref_num)) {
			row.createCell(8).setCellValue("Pass");
		} else {
			row.createCell(8).setCellValue("Fail");
		}
		fos = new FileOutputStream(location);
		workbook.write(fos);
		Thread.sleep(2000);
		testutil.Logout();

	}

	public void CCaccountCredit() throws Exception {

		fis = new FileInputStream(location);
		// fis=new FileInputStream("");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Cash");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(16).getLastCellNum();
		for (int i = 16; i <= rowcount; i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < colcount; j++) {
				XSSFCell cell = (XSSFCell) row.getCell(j);
				AC_Product_Number.sendKeys(row.getCell(0).getStringCellValue());
				Date.click();
				Thread.sleep(5000);
				Select activity = new Select(Activity);
				activity.selectByVisibleText("CC_CREDIT");
				// activity.selectByIndex(2);
				Transaction_Nature.click();
				Thread.sleep(1500);
				// long amount=(long) cell.getNumericCellValue();
				double amount = (double) row.getCell(2).getNumericCellValue();
				Amount.sendKeys(String.valueOf(amount));
				// double instnum = (double) row.getCell(2).getNumericCellValue();
				InstrumentNumber.sendKeys(row.getCell(3).getStringCellValue()); // Instrument
				ADD.click();
				Thread.sleep(1500);
				Submit.click();
				Thread.sleep(1500);
				CloseErrorMessage.click();
				Thread.sleep(1500);
				driver.findElement(By.xpath("//li[@id='id_post_transaction_cash']")).click();
				Pending_Denominations.click();
				Thread.sleep(3000);
				Select txnnature = new Select(txn_nature);
				txnnature.selectByVisibleText("Credit");
				// txnnature.selectByIndex(0);
				Search_pending_denom.click();
				Thread.sleep(1500);
				Add_denom.click();
				Thread.sleep(3000);
				int new_quan = (int) row.getCell(4).getNumericCellValue();
				New_quan.sendKeys(String.valueOf(new_quan));
				int new_quan1 = (int) row.getCell(5).getNumericCellValue();
				New_quan1.sendKeys(String.valueOf(new_quan1));
				Thread.sleep(1500);
				Old_quan.click();
				Thread.sleep(3000);
				submit_denoms.click();
				Thread.sleep(1500);
				CloseErrorMessage.click();
				Thread.sleep(3000);
				Authorization.click();
				Thread.sleep(3000);
				String exp_ref_no = Expected.getText();
				Thread.sleep(1500);
				System.out.println("Expected Result: " + exp_ref_no);
				row.createCell(6).setCellValue(exp_ref_no);
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				row.createCell(9).setCellValue(dtf.format(now));
				fos = new FileOutputStream(location);
				workbook.write(fos);
				// driver.findElement(By.xpath("//li[@id='id_post_transaction_cash']")).click();
				emp_photo.click();
				Thread.sleep(1500);
				logout.click();
				Thread.sleep(3000);
			}
		}
	}

	public void authCCaccountCredit() throws Exception {
		Authorization.click();
		Thread.sleep(3000);
		String actual_ref_no = Actual.getText();
		System.out.println("Actual Result: " + actual_ref_no);
		row.createCell(7).setCellValue(actual_ref_no);
		Thread.sleep(3000);
		Actual.click();
		Thread.sleep(3000);
		Cash_Auth.click();
		Thread.sleep(3000);
		testutil.handle_popop1();
		Thread.sleep(1500);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		if (row.getCell(6).getStringCellValue().equals(actual_ref_no)) {
			row.createCell(8).setCellValue("Pass");
		} else {
			row.createCell(8).setCellValue("Fail");
		}
		fos = new FileOutputStream(location);
		workbook.write(fos);
		emp_photo.click();
		Thread.sleep(1500);
		logout.click();
		Thread.sleep(3000);
	}

	public void CCaccountDebit() throws Exception {
		fis = new FileInputStream(location);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Cash");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(17).getLastCellNum();
		for (int i = 17; i <= rowcount; i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < colcount; j++) {
				XSSFCell cell = (XSSFCell) row.getCell(j);
				AC_Product_Number.sendKeys(row.getCell(0).getStringCellValue());
				Date.click();
				Thread.sleep(5000);
				Select activity = new Select(Activity);
				activity.selectByVisibleText("CC_DEBIT");
				Transaction_Nature.click();
				Thread.sleep(3000);
				int Token = (int) row.getCell(1).getNumericCellValue();
				TokenNo.sendKeys(String.valueOf(Token));
				double amount = (double) row.getCell(2).getNumericCellValue();
				Amount.sendKeys(String.valueOf(amount));
				InstrumentNumber.sendKeys(row.getCell(3).getStringCellValue());
				Date.click();
				Thread.sleep(3000);
				CloseAccountDetails.click();
				Thread.sleep(1500);
				ADD.click();
				Thread.sleep(1500);
				Submit.click();
				Thread.sleep(1500);
				CloseErrorMessage.click();
				Thread.sleep(1500);
				Authorization.click();
				Thread.sleep(3000);
				String exp_ref_no = Expected.getText();
				Thread.sleep(1500);
				System.out.println("Expected Result: " + exp_ref_no);
				row.createCell(6).setCellValue(exp_ref_no);
				fos = new FileOutputStream(location);
				workbook.write(fos);
				emp_photo.click();
				Thread.sleep(1500);
				logout.click();
				Thread.sleep(3000);
			}
		}
	}

	public void authCCaccountDebit() throws Exception {
		Authorization.click();
		Thread.sleep(3000);
		String actual_ref_no = Actual.getText();
		System.out.println("Actual Result: " + actual_ref_no);
		row.createCell(7).setCellValue(actual_ref_no);
		Thread.sleep(3000);
		Actual.click();
		Thread.sleep(3000);
		Cash_Auth.click();
		Thread.sleep(3000);
		testutil.handle_popop1();
		Thread.sleep(1500);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		if (row.getCell(6).getStringCellValue().equals(actual_ref_no)) {
			row.createCell(8).setCellValue("Pass");
		} else {
			row.createCell(8).setCellValue("Fail");
		}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		row.createCell(9).setCellValue(dtf.format(now));
		fos = new FileOutputStream(location);
		workbook.write(fos);
		emp_photo.click();
		Thread.sleep(1500);
		logout.click();
		Thread.sleep(3000);
	}

	public void CCaccountDebitPendingDenoms() throws Exception {
		Pending_Denominations.click();
		Thread.sleep(3000);
		Search_pending_denom.click();
		Thread.sleep(1500);
		Add_denom.click();
		Thread.sleep(3000);
		int new_quan = (int) row.getCell(4).getNumericCellValue();
		New_quan.sendKeys(String.valueOf(new_quan));
		Thread.sleep(1500);
		// New_quan1.sendKeys(row.getCell(4).getStringCellValue());
		Old_quan.click();
		Thread.sleep(3000);
		submit_denoms.click();
		Thread.sleep(1500);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		emp_photo.click();
		Thread.sleep(1500);
		logout.click();
	}

	// ========================================================================
	public void CCaccountClose() throws Exception {
		fis = new FileInputStream(location);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Cash");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(3).getLastCellNum();
		for (int i = 18; i <= rowcount; i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < colcount; j++) {
				XSSFCell cell = (XSSFCell) row.getCell(j);
				AC_Product_Number.sendKeys(row.getCell(0).getStringCellValue());
				Thread.sleep(1000);
				Date.click();
				Thread.sleep(2000);
				OkButton.click();
				Select activity = new Select(Activity);
				activity.selectByVisibleText("CC_ACCOUNT_CLOSURE");
				Thread.sleep(1000);
				// activity.selectByIndex(1);
				Thread.sleep(1000);
				CloseAccountDetails.click();
				Thread.sleep(1000);
				Transaction_Nature.click();
				Thread.sleep(1000);
				int Token = (int) row.getCell(1).getNumericCellValue();
				TokenNo.sendKeys(String.valueOf(Token));
				Thread.sleep(1500);
				// CloseAccountDetails.click();
				Thread.sleep(1500);
				InstrumentNumber.sendKeys(row.getCell(3).getStringCellValue());
				Date.click();
				Thread.sleep(1500);
				ChequeList.click();
				Thread.sleep(1500);
				ADD.click();
				CCCloseAccount = TotalAmount.getText();
				System.out.println("closing amount is : " + TotalAmount.getText());
				Thread.sleep(1500);
				Submit.click();
				Thread.sleep(1500);
				CloseErrorMessage.click();
				Thread.sleep(1500);
				Authorization.click();
				Thread.sleep(3000);
				String exp_ref_no = Expected.getText();
				Thread.sleep(1500);
				System.out.println("Expected Result: " + exp_ref_no);
				row.createCell(6).setCellValue(exp_ref_no);
				fos = new FileOutputStream(location);
				workbook.write(fos);
				emp_photo.click();
				Thread.sleep(1500);
				logout.click();
				Thread.sleep(3000);
			}
		}
	}

	public void authCCaccountClose() throws Exception {
		Thread.sleep(3000);
		Authorization.click();
		Thread.sleep(3000);
		enterRef_number.sendKeys(row.getCell(6).getStringCellValue());
		Thread.sleep(2000);
		transactionDate.click();
		Thread.sleep(2000);
		Search1.click();
		String actual_ref_no = Actual.getText();
		System.out.println("Actual Result: " + actual_ref_no);
		row.createCell(7).setCellValue(actual_ref_no);
		Thread.sleep(3000);
		Actual.click();
		Thread.sleep(3000);
		Cash_Auth.click();
		Thread.sleep(1000);
		testutil.handle_popop1();
		Thread.sleep(1500);
		CloseErrorMessage.click();
		Thread.sleep(1000);
		if (row.getCell(6).getStringCellValue().equals(actual_ref_no)) {
			row.createCell(8).setCellValue("Pass");
		} else {
			row.createCell(8).setCellValue("Fail");
		}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		row.createCell(9).setCellValue(dtf.format(now));
		fos = new FileOutputStream(location);
		workbook.write(fos);
		emp_photo.click();
		Thread.sleep(1500);
		logout.click();
		Thread.sleep(1000);
	}

	public void CCaccountClosePendingDenoms() throws Exception {
		Pending_Denominations.click();
		Thread.sleep(3000);
		Search_pending_denom.click();
		Thread.sleep(1500);
		Add_denom.click();
		Thread.sleep(3000);
		OneRupNotes.sendKeys(CCCloseAccount);
		// OneRupNotes.sendKeys(OneRupeesNotes);
		Thread.sleep(3000);
		submit_denoms.click();
		Thread.sleep(1500);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		emp_photo.click();
		Thread.sleep(1500);
		logout.click();
	}

	public void cashTransit() throws Exception {
		fis = new FileInputStream(location);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Cash");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(3).getLastCellNum();
		for (int i = 19; i <= rowcount; i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < colcount; j++) {
				Thread.sleep(1000);
				post_transit.click();
				Thread.sleep(1000);
				Select selectActivit = new Select(selectActivity);
				selectActivit.selectByValue("1004");
				Thread.sleep(1000);
				post_transit_amount.sendKeys(row.getCell(2).getStringCellValue());
				Thread.sleep(1000);
				transit_Remark.sendKeys("Cash in Transit");
				Thread.sleep(1000);
				add_cashTransit.click();
				Thread.sleep(1000);
				transit_Submit.click();
				Thread.sleep(1000);
				CloseErrorMessage.click();
				Thread.sleep(1000);
				List<WebElement> listSize = driver
						.findElements(By.xpath("//table[@class='table table-striped table-bordered']/tbody/tr"));
				String path1 = "//table[@class='table table-striped table-bordered']/tbody/tr[";
				String path2 = "]/td[1]";
				for (int k = 1; k <= listSize.size(); k++) {
					System.out.println(driver.findElement(By.xpath(path1 + k + path2)).getText());
					list_of_ref_nu = (driver.findElement(By.xpath(path1 + k + path2)).getText());
				}
				Thread.sleep(1000);
				ref_nu_postinTransit = pendingTransit_Ref_nu.getText();
				Thread.sleep(1000);
				row.createCell(6).setCellValue(ref_nu_postinTransit);
				Thread.sleep(1000);
				pendingTransit_Ref_nu.click();
				Thread.sleep(1000);
				token_nu_postinTransit = post_transit_Token.getText();
				Thread.sleep(1000);
				row.createCell(1).setCellValue(token_nu_postinTransit);
				Thread.sleep(3000);
				CloseAccountDetails.click();
				fos = new FileOutputStream(location);
				workbook.write(fos);
				Thread.sleep(2000);
				testutil.Logout();
				Thread.sleep(1000);
				testutil.checkerLogin(); // checker login
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//span[@class='bsg-block__header'])[7]")).click();
				post_transit.click();
				Thread.sleep(1000);
				for (int a = 0; a <= listSize.size() - 1; a++) {
					transit_Pending.click();
					Thread.sleep(500);
					cash_transitSend.click();
					Thread.sleep(500);
					CloseErrorMessage.click();

				}
				testutil.Logout();
				Thread.sleep(1000);
				testutil.makerLogin();
				driver.findElement(By.xpath("(//span[@class='bsg-block__header'])[7]")).click();
				Thread.sleep(1000);
				post_transit.click();
				Thread.sleep(1000);
				Pending_Denominations.click();
				Thread.sleep(1000);
				pendig_Denoms_Token_No.sendKeys(row.getCell(1).getStringCellValue());
				Thread.sleep(1000);
				Search_pending_denom.click();
				Thread.sleep(1000);
				Add_denom.click();
				Thread.sleep(1000);
				OneRupNotes.sendKeys(row.getCell(2).getStringCellValue());
				Thread.sleep(1000);
				submit_denoms.click();
				Thread.sleep(1000);
				CloseErrorMessage.click();
				Thread.sleep(1000);
				testutil.Logout();
			}
		}
	}

	public void authCashTransit() throws Exception {

		post_transit.click();
		Thread.sleep(1000);
		Pending_Denominations.click();
		Thread.sleep(1500);
		Select txn_nature = new Select(select_txn_nature);
		txn_nature.selectByValue("C");
		Thread.sleep(1500);
		Thread.sleep(1500);
		Search_pending_denom.click();
		Thread.sleep(3000);
		Add_denom.click();
		Thread.sleep(1500);
		OneRupNotes.sendKeys(row.getCell(2).getStringCellValue());
		Thread.sleep(3000);
		submit_denoms.click();
		Thread.sleep(1500);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		testutil.Logout();
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("checkerotherBranch"),
				properties.getProperty("ckeckerotherBranch_password"));
		driver.findElement(By.xpath("(//span[@class='bsg-block__header'])[7]")).click();
//		post_transit.click();
//		List<WebElement> listSize = driver
//				.findElements(By.xpath("//table[@class='table table-striped table-bordered']/tbody/tr"));
		Thread.sleep(3000);
		Pending_Denominations.click();
		Thread.sleep(3000);
		transit_Pending.click();
		Thread.sleep(3000);
		receive_pending_Transit.click();
		Thread.sleep(3000);
		CloseErrorMessage.click();
		Thread.sleep(1000);
		transit_authorized.click();
		Thread.sleep(1000);
		transit_ref_num = expected_last_ref_nu.getText();
		// System.out.println("transit ref numb " +transit_ref_num);
		row.createCell(7).setCellValue(transit_ref_num);
		fos = new FileOutputStream(location);
		workbook.write(fos);
		if (row.getCell(6).getStringCellValue().equals(transit_ref_num)) {
			row.createCell(8).setCellValue("Pass");
		} else {
			row.createCell(8).setCellValue("Fail");
		}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		row.createCell(9).setCellValue(dtf.format(now));
		fos = new FileOutputStream(location);
		workbook.write(fos);
		Thread.sleep(1000);
		testutil.Logout();
	}

}
