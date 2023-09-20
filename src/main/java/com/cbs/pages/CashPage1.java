package com.cbs.pages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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

public class CashPage1 extends TestBase
{

TestUtil testutil = new TestUtil();
public static FileInputStream fis;
public static FileOutputStream fos;
public static XSSFWorkbook workbook;
public static XSSFSheet sheet;
public static Row row;
String location = "C:\\Users\\AkashBorade\\Desktop\\Excel Autom\\CBS_Automation.xlsx";
// String location = "C:\\Siddhesh Training
// Document\\Automation_For_CBS\\Excel\\CBS_Automation.xlsx";
public static String OneRupeesNotes;
public static String TDpayoutAmt;
public static String TDReqAmount;
public static String availableBalance;
public static String requestAmount;

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

@FindBy(xpath = "//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[1]/a[@id='reference_no0']")
WebElement Expected;

@FindBy(xpath = "//a[@id='reference_no1']")
WebElement Expected1;

@FindBy(xpath = "//a[@id='reference_no2']")
WebElement Expected2;

@FindBy(xpath = "//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[1]/a[@id='reference_no0']")
WebElement Actual;

@FindBy(xpath = "//img[@id='id_emp_photo']")
WebElement emp_photo;

@FindBy(xpath = "//a[@id='id_logout']")
WebElement logout;

@FindBy(xpath = "//button[@id='id_authorizeBtn']")
WebElement Cash_Auth;

@FindBy(xpath = "//a[@id='id_closeModal']")
WebElement ChequeList;

public CashPage1() {
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
			Thread.sleep(2000);
			// long amount=(long) cell.getNumericCellValue();
			double amount = (double) row.getCell(2).getNumericCellValue();
			Amount.sendKeys(String.valueOf(amount));
			// double instnum = (double) row.getCell(2).getNumericCellValue();
			InstrumentNumber.sendKeys(row.getCell(3).getStringCellValue()); // Instrument
			ADD.click();
			Thread.sleep(2000);
			Submit.click();
			Thread.sleep(2000);
			CloseErrorMessage.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//li[@id='id_post_transaction_cash']")).click();
			Pending_Denominations.click();
			Thread.sleep(3000);
			Select txnnature = new Select(txn_nature);
			txnnature.selectByVisibleText("Credit");
			// txnnature.selectByIndex(0);
			Search_pending_denom.click();
			Thread.sleep(2000);
			Add_denom.click();
			Thread.sleep(3000);
			int new_quan = (int) row.getCell(4).getNumericCellValue();
			New_quan.sendKeys(String.valueOf(new_quan));
			int new_quan1 = (int) row.getCell(5).getNumericCellValue();
			New_quan1.sendKeys(String.valueOf(new_quan1));
			Thread.sleep(2000);
			Old_quan.click();
			Thread.sleep(3000);
			submit_denoms.click();
			Thread.sleep(2000);
			CloseErrorMessage.click();
			Thread.sleep(3000);
			Authorization.click();
			Thread.sleep(3000);
			String exp_ref_no = Expected.getText();
			Thread.sleep(2000);
			System.out.println("Expected Result: " + exp_ref_no);
			row.createCell(6).setCellValue(exp_ref_no);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			row.createCell(9).setCellValue(dtf.format(now));
			fos = new FileOutputStream(location);
			workbook.write(fos);
			// driver.findElement(By.xpath("//li[@id='id_post_transaction_cash']")).click();
			emp_photo.click();
			Thread.sleep(2000);
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
	Thread.sleep(2000);
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
	Thread.sleep(2000);
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
			int Token = (int) row.getCell(1).getNumericCellValue();
			TokenNo.sendKeys(String.valueOf(Token));
			double amount = (double) row.getCell(2).getNumericCellValue();
			Amount.sendKeys(String.valueOf(amount));
			InstrumentNumber.sendKeys(row.getCell(3).getStringCellValue());
			Date.click();
			Thread.sleep(3000);
			CloseAccountDetails.click();
			Thread.sleep(2000);
			ADD.click();
			Thread.sleep(2000);
			Submit.click();
			Thread.sleep(2000);
			CloseErrorMessage.click();
			Thread.sleep(2000);
			Authorization.click();
			Thread.sleep(3000);
			String exp_ref_no = Expected.getText();
			Thread.sleep(2000);
			System.out.println("Expected Result: " + exp_ref_no);
			row.createCell(6).setCellValue(exp_ref_no);
			fos = new FileOutputStream(location);
			workbook.write(fos);
			emp_photo.click();
			Thread.sleep(2000);
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
	Thread.sleep(2000);
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
	Thread.sleep(2000);
	logout.click();
	Thread.sleep(3000);
}

public void casaDebitPendingDenoms() throws Exception {
	Pending_Denominations.click();
	Thread.sleep(3000);
	Search_pending_denom.click();
	Thread.sleep(2000);
	Add_denom.click();
	Thread.sleep(3000);
	int new_quan = (int) row.getCell(4).getNumericCellValue();
	New_quan.sendKeys(String.valueOf(new_quan));
	Thread.sleep(2000);
	// New_quan1.sendKeys(row.getCell(4).getStringCellValue());
	Old_quan.click();
	Thread.sleep(3000);
	submit_denoms.click();
	Thread.sleep(2000);
	CloseErrorMessage.click();
	Thread.sleep(3000);
	emp_photo.click();
	Thread.sleep(2000);
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
			//CloseAccountDetails.click();
			Thread.sleep(1500);
			InstrumentNumber.sendKeys(row.getCell(3).getStringCellValue());
			Date.click();
			Thread.sleep(2000);
			ChequeList.click();
			Thread.sleep(2000);
			OneRupeesNotes = TotalPayoutAmount.getText();
			OneRupeesNotes = OneRupeesNotes.substring(0, OneRupeesNotes.indexOf('.'));
			System.out.println("Account closing acount:" + OneRupeesNotes);
			Thread.sleep(2500);
			//CloseAccountDetails.click();
			Thread.sleep(1500);
			ADD.click();
			Thread.sleep(2000);
			Submit.click();
			Thread.sleep(2000);
			CloseErrorMessage.click();
			Thread.sleep(2000);
			Authorization.click();
			Thread.sleep(3000);
			String exp_ref_no = Expected.getText();
			Thread.sleep(2000);
			System.out.println("Expected Result: " + exp_ref_no);
			row.createCell(6).setCellValue(exp_ref_no);
			fos = new FileOutputStream(location);
			workbook.write(fos);
			emp_photo.click();
			Thread.sleep(2000);
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
	Thread.sleep(2000);
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
	Thread.sleep(2000);
	logout.click();
	Thread.sleep(3000);
}

public void casaClosePendingDenoms() throws Exception {
	Pending_Denominations.click();
	Thread.sleep(3000);
	// Select txnnature = new Select(txn_nature);
	// txnnature.selectByIndex(0);
	Search_pending_denom.click();
	Thread.sleep(2000);
	Add_denom.click();
	Thread.sleep(3000);
	OneRupNotes.sendKeys(OneRupeesNotes);
	Thread.sleep(3000);
	submit_denoms.click();
	Thread.sleep(2000);
	CloseErrorMessage.click();
	Thread.sleep(3000);
	emp_photo.click();
	Thread.sleep(2000);
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
	// Thread.sleep(2000);
	// New_quan1.sendKeys(row.getCell(4).getStringCellValue());
//	Old_quan.click();
	// Thread.sleep(3000);
	/*
	 * submit_denoms.click(); Thread.sleep(2000); CloseErrorMessage.click();
	 * Thread.sleep(3000); emp_photo.click(); Thread.sleep(2000); logout.click();
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
			Thread.sleep(2000);
			// ChequeList.click();
			Thread.sleep(2000);
			ADD.click();
			Thread.sleep(2000);
			Submit.click();
			Thread.sleep(2000);
			CloseErrorMessage.click();
			Thread.sleep(2000);
			Authorization.click();
			Thread.sleep(3000);
			String exp_ref_no = Expected.getText();
			Thread.sleep(2000);
			System.out.println("Expected Result: " + exp_ref_no);
			row.createCell(6).setCellValue(exp_ref_no);
			fos = new FileOutputStream(location);
			workbook.write(fos);
			emp_photo.click();
			Thread.sleep(2000);
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
	Thread.sleep(2000);
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
	Thread.sleep(2000);
	logout.click();
	Thread.sleep(3000);
}

public void TDAccountPayoutPendingDenoms() throws Exception {
	Pending_Denominations.click();
	Thread.sleep(3000);
	Search_pending_denom.click();
	Thread.sleep(2000);
	Add_denom.click();
	Thread.sleep(3000);
	OneRupNotes.sendKeys(TDpayoutAmt);
	Thread.sleep(3000);
	submit_denoms.click();
	Thread.sleep(2000);
	CloseErrorMessage.click();
	Thread.sleep(3000);
	emp_photo.click();
	Thread.sleep(2000);
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
			Thread.sleep(2000);
			ADD.click();
			Thread.sleep(2000);
			TDReqAmount = TDRequestAmt.getText();
			Submit.click();
			Thread.sleep(2000);
			CloseErrorMessage.click();
			Thread.sleep(2000);
			Pending_Denominations.click();
			Thread.sleep(3000);
			Select txnnature = new Select(txn_nature);
			txnnature.selectByVisibleText("Credit");
			Search_pending_denom.click();
			Thread.sleep(2000);
			Add_denom.click();
			OneRupNotes.sendKeys(TDReqAmount);
			submit_denoms.click();
			Thread.sleep(2000);
			CloseErrorMessage.click();
			Thread.sleep(2000);
			Authorization.click();
			Thread.sleep(3000);
			String exp_ref_no = Expected.getText();
			Thread.sleep(2000);
			System.out.println("Expected Result: " + exp_ref_no);
			row.createCell(6).setCellValue(exp_ref_no);
			fos = new FileOutputStream(location);
			workbook.write(fos);
			emp_photo.click();
			Thread.sleep(2000);
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
	Thread.sleep(2000);
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
	Thread.sleep(2000);
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
//			double amount = (double) row.getCell(2).getNumericCellValue();
			availableBalance = AvailableBalance.getText();
			Amount.sendKeys(availableBalance);
			availableBalance = availableBalance.substring(0, availableBalance.indexOf('.'));
			InstrumentNumber.sendKeys(row.getCell(3).getStringCellValue());
			Date.click();
			Thread.sleep(2000);
			ADD.click();
			Thread.sleep(2000);
			Submit.click();
			Thread.sleep(2000);
			CloseErrorMessage.click();
			Thread.sleep(2000);
			Authorization.click();
			Thread.sleep(3000);
			String exp_ref_no = Expected.getText();
			Thread.sleep(2000);
			System.out.println("Expected Result: " + exp_ref_no);
			row.createCell(6).setCellValue(exp_ref_no);
			fos = new FileOutputStream(location);
			workbook.write(fos);
			emp_photo.click();
			Thread.sleep(2000);
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
	Thread.sleep(2000);
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
	Thread.sleep(2000);
	logout.click();
	Thread.sleep(3000);
}

public void LaonACDisbursmentPendingDenoms() throws Exception {
	Pending_Denominations.click();
	Thread.sleep(3000);
	Search_pending_denom.click();
	Thread.sleep(2000);
	Add_denom.click();
	Thread.sleep(3000);
	OneRupNotes.sendKeys(availableBalance);
	Thread.sleep(3000);
	submit_denoms.click();
	Thread.sleep(2000);
	CloseErrorMessage.click();
	Thread.sleep(3000);
	emp_photo.click();
	Thread.sleep(2000);
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
			Thread.sleep(2000);
			// long amount=(long) cell.getNumericCellValue();
			double amount = (double) row.getCell(2).getNumericCellValue();
			Amount.sendKeys(String.valueOf(amount));
			// double instnum = (double) row.getCell(2).getNumericCellValue();
			InstrumentNumber.sendKeys(row.getCell(3).getStringCellValue()); // Instrument
			ADD.click();
			Thread.sleep(2000);
			Submit.click();
			Thread.sleep(2000);
			CloseErrorMessage.click();
			Thread.sleep(2000);
			Pending_Denominations.click();
			Thread.sleep(3000);
			Select txnnature = new Select(txn_nature);
			txnnature.selectByVisibleText("Credit");
			Search_pending_denom.click();
			Thread.sleep(2000);
			Add_denom.click();
			Thread.sleep(3000);
			int new_quan1 = (int) row.getCell(5).getNumericCellValue();
			New_quan1.sendKeys(String.valueOf(new_quan1));
			Thread.sleep(2000);
			Thread.sleep(3000);
			submit_denoms.click();
			Thread.sleep(2000);
			CloseErrorMessage.click();
			Thread.sleep(3000);
			Authorization.click();
			Thread.sleep(3000);
			String exp_ref_no = Expected.getText();
			Thread.sleep(2000);
			System.out.println("Expected Result: " + exp_ref_no);
			row.createCell(6).setCellValue(exp_ref_no);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			row.createCell(9).setCellValue(dtf.format(now));
			fos = new FileOutputStream(location);
			workbook.write(fos);
			emp_photo.click();
			Thread.sleep(2000);
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
	Thread.sleep(2000);
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
	Thread.sleep(2000);
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
			Thread.sleep(2000);
			CloseAccountDetails.click();
			Thread.sleep(2000);
			Transaction_Nature.click();
			Thread.sleep(2000);
			InstrumentNumber.sendKeys(row.getCell(3).getStringCellValue()); // Instrument
			ADD.click();
			Thread.sleep(2000);
			requestAmount = RequestAmount.getText();
			Submit.click();
			Thread.sleep(2000);
			CloseErrorMessage.click();
			Thread.sleep(2000);
			Pending_Denominations.click();
			Thread.sleep(3000);
			Select txnnature = new Select(txn_nature);
			txnnature.selectByVisibleText("Credit");
			// txnnature.selectByIndex(0);
			Search_pending_denom.click();
			Thread.sleep(2000);
			Add_denom.click();
			Thread.sleep(3000);
			OneRupNotes.sendKeys(requestAmount);
			Thread.sleep(3000);
			submit_denoms.click();
			Thread.sleep(2000);
			CloseErrorMessage.click();
			Thread.sleep(3000);
			Authorization.click();
			Thread.sleep(3000);
			String exp_ref_no = Expected.getText();
			Thread.sleep(2000);
			System.out.println("Expected Result: " + exp_ref_no);
			row.createCell(6).setCellValue(exp_ref_no);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			row.createCell(9).setCellValue(dtf.format(now));
			fos = new FileOutputStream(location);
			workbook.write(fos);
			emp_photo.click();
			Thread.sleep(2000);
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
	Thread.sleep(2000);
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
	Thread.sleep(2000);
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
//			ac.keyDown(Keys.F1);
//			ac.build().perform();
//			ac.keyUp(Keys.F1);
//			ac.build().perform();
//			ac.sendKeys(InternalPriduct, doubleclick());
			ac.moveToElement(InternalPriduct).doubleClick().build().perform();
			Date.click();
			Thread.sleep(5000);
			Select activity = new Select(Activity);
			activity.selectByVisibleText("INTERNAL_PRODUCT_CREDIT");
			// activity.selectByIndex(2);
			Transaction_Nature.click();
			Thread.sleep(2000);
			// long amount=(long) cell.getNumericCellValue();
			double amount = (double) row.getCell(2).getNumericCellValue();
			Amount.sendKeys(String.valueOf(amount));
			// double instnum = (double) row.getCell(2).getNumericCellValue();
			InstrumentNumber.sendKeys(row.getCell(3).getStringCellValue()); // Instrument
			ADD.click();
			Thread.sleep(2000);
			Submit.click();
			Thread.sleep(2000);
			CloseErrorMessage.click();
			Thread.sleep(2000);
			Pending_Denominations.click();
			Thread.sleep(3000);
			Select txnnature = new Select(txn_nature);
			txnnature.selectByVisibleText("Credit");
			// txnnature.selectByIndex(0);
			Search_pending_denom.click();
			Thread.sleep(2000);
			Add_denom.click();
			Thread.sleep(3000);
			int new_quan = (int) row.getCell(4).getNumericCellValue();
			New_quan.sendKeys(String.valueOf(new_quan));
			int new_quan1 = (int) row.getCell(5).getNumericCellValue();
			New_quan1.sendKeys(String.valueOf(new_quan1));
			Thread.sleep(2000);
			Old_quan.click();
			Thread.sleep(3000);
			submit_denoms.click();
			Thread.sleep(2000);
			CloseErrorMessage.click();
			Thread.sleep(3000);
			Authorization.click();
			Thread.sleep(3000);
			String exp_ref_no = Expected.getText();
			Thread.sleep(2000);
			System.out.println("Expected Result: " + exp_ref_no);
			row.createCell(6).setCellValue(exp_ref_no);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			row.createCell(9).setCellValue(dtf.format(now));
			fos = new FileOutputStream(location);
			workbook.write(fos);
			emp_photo.click();
			Thread.sleep(2000);
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
	Thread.sleep(2000);
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
	Thread.sleep(2000);
	logout.click();
	Thread.sleep(3000);
}

//================================internal Product debit============================================
public void InternalProductDebit() throws Exception {
	fis = new FileInputStream(location);
	workbook = new XSSFWorkbook(fis);
	sheet = workbook.getSheet("Cash");
	int rowcount = sheet.getLastRowNum();
	int colcount = sheet.getRow(10).getLastCellNum();
	for (int i = 10; i <= rowcount; i++) {
		row = sheet.getRow(i);
		for (int j = 0; j < colcount; j++) {
//			XSSFCell cell=(XSSFCell) row.getCell(j);
//			AC_Product_Number.sendKeys(row.getCell(0).getStringCellValue());
			AC_Product_Number.click();
			AC_Product_Number.sendKeys(Keys.F1);
			Thread.sleep(5000);
			Actions ac = new Actions(driver);
//			ac.keyDown(Keys.F1);
//			ac.build().perform();
//			ac.keyUp(Keys.F1);
//			ac.build().perform();
//			ac.sendKeys(InternalPriduct, doubleclick());
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
			Thread.sleep(2000);
			ADD.click();
			Thread.sleep(2000);
			Submit.click();
			Thread.sleep(2000);
			CloseErrorMessage.click();
			Thread.sleep(2000);
			Authorization.click();
			Thread.sleep(3000);
			String exp_ref_no = Expected.getText();
			Thread.sleep(2000);
			System.out.println("Expected Result: " + exp_ref_no);
			row.createCell(6).setCellValue(exp_ref_no);
			fos = new FileOutputStream(location);
			workbook.write(fos);
			emp_photo.click();
			Thread.sleep(2000);
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
	Thread.sleep(2000);
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
	Thread.sleep(2000);
	logout.click();
	Thread.sleep(3000);
}

public void InternalProductDebitPdendingDenoms() throws Exception {
	Pending_Denominations.click();
	Thread.sleep(3000);
	Search_pending_denom.click();
	Thread.sleep(2000);
	Add_denom.click();
	Thread.sleep(3000);
	int new_quan = (int) row.getCell(4).getNumericCellValue();
	New_quan.sendKeys(String.valueOf(new_quan));
	Thread.sleep(2000);
	Old_quan.click();
	Thread.sleep(3000);
	submit_denoms.click();
	Thread.sleep(2000);
	CloseErrorMessage.click();
	Thread.sleep(3000);
	emp_photo.click();
	Thread.sleep(2000);
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

//			ac.keyDown(Keys.F1);
//			ac.build().perform();
//			ac.keyUp(Keys.F1);
//			ac.build().perform();
//			ac.sendKeys(InternalPriduct, doubleclick());
			ac.moveToElement(InternalPriduct).doubleClick().build().perform();
			Date.click();
			Thread.sleep(5000);
			Select activity = new Select(Activity);
			activity.selectByVisibleText("INTERNAL_ACCOUNT_CREDIT");
			// activity.selectByIndex(2);
			Transaction_Nature.click();
			Thread.sleep(2000);
			// long amount=(long) cell.getNumericCellValue();
			double amount = (double) row.getCell(2).getNumericCellValue();
			Amount.sendKeys(String.valueOf(amount));
			// double instnum = (double) row.getCell(2).getNumericCellValue();
			InstrumentNumber.sendKeys(row.getCell(3).getStringCellValue()); // Instrument
			ADD.click();
			Thread.sleep(2000);
			Submit.click();
			Thread.sleep(2000);
			CloseErrorMessage.click();
			Thread.sleep(2000);
			Pending_Denominations.click();
			Thread.sleep(3000);
			Select txnnature = new Select(txn_nature);
			txnnature.selectByVisibleText("Credit");
			// txnnature.selectByIndex(0);
			Search_pending_denom.click();
			Thread.sleep(2000);
			Add_denom.click();
			Thread.sleep(3000);
			int new_quan = (int) row.getCell(4).getNumericCellValue();
			New_quan.sendKeys(String.valueOf(new_quan));
			int new_quan1 = (int) row.getCell(5).getNumericCellValue();
			New_quan1.sendKeys(String.valueOf(new_quan1));
			Thread.sleep(2000);
			Old_quan.click();
			Thread.sleep(3000);
			submit_denoms.click();
			Thread.sleep(2000);
			CloseErrorMessage.click();
			Thread.sleep(3000);
			Authorization.click();
			Thread.sleep(3000);
			String exp_ref_no = Expected.getText();
			Thread.sleep(2000);
			System.out.println("Expected Result: " + exp_ref_no);
			row.createCell(6).setCellValue(exp_ref_no);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			row.createCell(9).setCellValue(dtf.format(now));
			fos = new FileOutputStream(location);
			workbook.write(fos);
			emp_photo.click();
			Thread.sleep(2000);
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
	Thread.sleep(2000);
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
	Thread.sleep(2000);
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
//			XSSFCell cell=(XSSFCell) row.getCell(j);
//			AC_Product_Number.sendKeys(row.getCell(0).getStringCellValue());
			AC_Product_Number.click();
			AC_Product_Number.sendKeys(Keys.F2);
			Thread.sleep(5000);
			Actions ac = new Actions(driver);
//			ac.keyDown(Keys.F1);
//			ac.build().perform();
//			ac.keyUp(Keys.F1);
//			ac.build().perform();
//			ac.sendKeys(InternalPriduct, doubleclick());
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
			Thread.sleep(2000);
			ADD.click();
			Thread.sleep(2000);
			Submit.click();
			Thread.sleep(2000);
			CloseErrorMessage.click();
			Thread.sleep(2000);
			Authorization.click();
			Thread.sleep(3000);
			String exp_ref_no = Expected.getText();
			Thread.sleep(2000);
			System.out.println("Expected Result: " + exp_ref_no);
			row.createCell(6).setCellValue(exp_ref_no);
			fos = new FileOutputStream(location);
			workbook.write(fos);
			emp_photo.click();
			Thread.sleep(2000);
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
	Thread.sleep(2000);
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
	Thread.sleep(2000);
	logout.click();
	Thread.sleep(3000);
}

public void InternalACDebitPdendingDenoms() throws Exception {
	Pending_Denominations.click();
	Thread.sleep(3000);
	Search_pending_denom.click();
	Thread.sleep(2000);
	Add_denom.click();
	Thread.sleep(3000);
	int new_quan = (int) row.getCell(4).getNumericCellValue();
	New_quan.sendKeys(String.valueOf(new_quan));
	Thread.sleep(2000);
	Old_quan.click();
	Thread.sleep(3000);
	submit_denoms.click();
	Thread.sleep(2000);
	CloseErrorMessage.click();
	Thread.sleep(3000);
	emp_photo.click();
	Thread.sleep(2000);
	logout.click();
}

//=========================================test for for loop=========================
public void MultipleACCredit() throws Exception {
	fis = new FileInputStream(location);

	workbook = new XSSFWorkbook(fis);
	sheet = workbook.getSheet("Cash");
	int rowcount = sheet.getLastRowNum();
	for (int i = 16; i <= 18; i++) {
		int colcount = sheet.getRow(i).getLastCellNum();
		row = sheet.getRow(i);
		Thread.sleep(2000);
		AC_Product_Number.sendKeys(row.getCell(0).getStringCellValue());
		Date.click();
		Thread.sleep(3000);
		Select activity = new Select(Activity);
		activity.selectByVisibleText("CASA_CREDIT");
		Transaction_Nature.click();
		Thread.sleep(2000);
		double amount = (double) row.getCell(2).getNumericCellValue();
		Amount.sendKeys(String.valueOf(amount));
		InstrumentNumber.sendKeys(row.getCell(3).getStringCellValue());
		ADD.click();
		Thread.sleep(2000);
		// System.out.println(i + " loop value");
	}

	Submit.click();
	Thread.sleep(2000);
	CloseErrorMessage.click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//li[@id='id_post_transaction_cash']")).click();
	Thread.sleep(2000);
	Pending_Denominations.click();
	Thread.sleep(3000);
	Select txnnature = new Select(txn_nature);
	txnnature.selectByVisibleText("Credit");
	Search_pending_denom.click();
	Thread.sleep(2000);
	Add_denom.click();
	Thread.sleep(3000);
	int new_quan = (int) row.getCell(4).getNumericCellValue();
	New_quan.sendKeys(String.valueOf(new_quan));
	int new_quan1 = (int) row.getCell(5).getNumericCellValue();
	New_quan1.sendKeys(String.valueOf(new_quan1));
	Thread.sleep(2000);
	Old_quan.click();
	Thread.sleep(3000);
	submit_denoms.click();
	Thread.sleep(2000);
	CloseErrorMessage.click();
	Thread.sleep(3000);
	Authorization.click();
	Thread.sleep(3000);

	WebElement table = driver.findElement(By.xpath("//table[@class='table table-striped table-bordered']"));
	List<WebElement> row1 = table.findElements(By.tagName("tr"));
	for (int i = 1; i < row1.size(); i++) {
		String path1 = "//table[@class='table table-striped table-bordered']/tbody/tr[";
		String path2 = "]/td[1]";
		for (int j = 1; j <= 11; j++) {
			System.out.println(driver.findElement(By.xpath(path1 + j + path2)).getText());
		}
	}
	/*
	 * String exp_ref_no = Expected.getText(); String exp_ref_no1 =
	 * Expected1.getText(); String exp_ref_no2 = Expected2.getText();
	 * Thread.sleep(2000); System.out.println("Expected Result: "+exp_ref_no);
	 * row.createCell(6).setCellValue(exp_ref_no); DateTimeFormatter dtf =
	 * DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); LocalDateTime now =
	 * LocalDateTime.now(); row.createCell(9).setCellValue(dtf.format(now)); fos=new
	 * FileOutputStream(location); workbook.write(fos);
	 */
	emp_photo.click();
	Thread.sleep(2000);
	logout.click();
	Thread.sleep(3000);
}

public void authMultipleACCredit() throws Exception {
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
	Thread.sleep(2000);
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
	Thread.sleep(2000);
	logout.click();
	Thread.sleep(3000);
}

}


