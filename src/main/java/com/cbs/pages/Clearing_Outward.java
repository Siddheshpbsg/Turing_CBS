package com.cbs.pages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cbs.base.TestBase;
import com.cbs.util.JDBC_San;
import com.cbs.util.TestUtil;

public class Clearing_Outward extends TestBase
{

	public Clearing_Outward()
	{
		PageFactory.initElements(driver,this);
	}

	TestUtil util=new TestUtil();
	JDBC_San jdbc = new JDBC_San();
	
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static Row row;
	String location = "C:\\Users\\SanketHase\\Desktop\\Work\\Automation\\CBS_Automation.xlsx";
	public static String referenceNum;
	String Account_No;
	String scrollNumber;

	@FindBy(xpath="//*[@name='txtAccountNumber']")
	WebElement Acc_No; 

	@FindBy(xpath="//*[@id='id_batchSelect']")
	WebElement batch; 

	@FindBy(xpath="//*[@id='id_activitySubTypeId']")
	WebElement activity;

	@FindBy(xpath="//*[@id='id_txtSlipTotal']")
	WebElement slipTotal;

	@FindBy(xpath="//*[@id='id_optSettlementAccount']")	
	WebElement settlementProduct;

	@FindBy(xpath="//*[@id='id_txtInstrumentMicrCode']")	
	WebElement MICR;

	@FindBy(xpath="//*[@id='id_txtSlipRefNo']")	
	WebElement slipReferenceNo;

	@FindBy(xpath="//*[@id='id_BatchDate']")	
	WebElement applicationDate;

	@FindBy(xpath="//*[@id='id_txtInstrumentDate']")	
	WebElement instrDate;

	@FindBy(xpath="//*[@id='id_txtInstrumentType']")
	WebElement instruType;

	@FindBy(xpath="//*[@id='id_txtInstrumentNumber']")	
	WebElement instruNo;

	@FindBy(xpath="//*[@id='id_txtAmount']")	
	WebElement chequeamonut;

	@FindBy(xpath="//*[@id='id_short_acct_no']")	
	WebElement shortAcc;

	@FindBy(xpath="//*[@id='btnAdd']")	
	WebElement addbutton;

	@FindBy(xpath="//*[@id='btnSubmit']")	
	WebElement submitbutton;

	@FindBy(xpath="//table[@class='table table-striped table-bordered' and @id='transfer-success-table']/tbody/tr[1]/td[1]")	
	WebElement scrollNo;

	@FindBy(xpath="//img[@id='id_emp_photo']")
	WebElement emp_photo;

	@FindBy(xpath="//a[@id='id_logout']")
	WebElement logout;

	@FindBy(xpath="//*[@id='id_closeModal']")
	WebElement closeTable;

	@FindBy(xpath="//*[text()='Pending']")
	WebElement PendigTab;

	@FindBy(xpath="//*[@id=\"id_ResDiv\"]/table/tbody/tr[1]/td[2]")
	WebElement PendigScrollNum;

	@FindBy(xpath="//*[@id='reference_no0']")
	WebElement refNo;

	@FindBy(xpath="//*[@id='id_authorize']")
	WebElement authButton;

	@FindBy(xpath="//*[@id='id_closeErrorMessage']")
	WebElement closePopup;

	@FindBy(xpath="//*[text()='(T+0) Posting']")
	WebElement Tplus0Posting;
	
	@FindBy(xpath="//*[@id='id_txn_ref_no']")
	WebElement refnoTplus0;
	
	@FindBy(xpath="//*[contains(@id,'chk')]")
	WebElement checkbox;
	
	@FindBy(xpath="//*[@id='id_btn_post_txns']")
	WebElement posttxn;
	
	@FindBy(xpath="//*[text()='confirm']")
	WebElement confirmbutton;
	
	@FindBy(xpath="//*[text()='Funds Release']")
	WebElement fundsRelease;
	
	@FindBy(xpath="//*[@id='id_region_code']")
	WebElement regionCode;
	
	@FindBy(xpath="//*[text()='Clearing Funded']")
	WebElement clearingFunded;
	
	@FindBy(xpath="//*[@id='btnLast']")
	WebElement lastpage;
	
	public void postTransaction() throws IOException, InterruptedException
	{

		fis = new FileInputStream(location);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("ClearingOutward");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(1).getLastCellNum();
		for (int i=1;i<=rowcount;i++)
		{
			row = sheet.getRow(i);
			for(int j=0;j<=colcount;)
			{
				Account_No=String.valueOf(row.getCell(1).getStringCellValue());
				Thread.sleep(1000);
				Acc_No.sendKeys(Account_No);

				Thread.sleep(1000);
				Select batchdropdown = new Select (batch);
				batchdropdown.selectByIndex(1);

				Thread.sleep(1000);
				Select activitydropdown = new Select (activity);
				activitydropdown.selectByIndex(1);

				Thread.sleep(1000);
				String slipAmount = row.getCell(2).getStringCellValue();
				slipTotal.sendKeys(slipAmount);

				Thread.sleep(1000);
				String slipRefNo =row.getCell(3).getStringCellValue();
				slipReferenceNo.sendKeys(slipRefNo);

				Thread.sleep(1000);
				Select settlementProductdropdown = new Select (settlementProduct);
				settlementProductdropdown.selectByIndex(1);

				Thread.sleep(1000);
				String micr =row.getCell(4).getStringCellValue();
				MICR.sendKeys(micr);

				Thread.sleep(1000);
				String appDate= applicationDate.getText();
				String[] arrOfStr = appDate.split(":");
				appDate = arrOfStr[1];
				appDate=appDate.trim();
				System.out.println(appDate);
				Thread.sleep(1000);

				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				String script = "arguments[0].value = arguments[1];";
				jsExecutor.executeScript(script, instrDate, appDate);
				instrDate.sendKeys(Keys.TAB);

				Thread.sleep(1000);
				String instrType =row.getCell(5).getStringCellValue();
				instruType.sendKeys(instrType);

				Thread.sleep(1000);
				String instrNo =row.getCell(6).getStringCellValue();
				instruNo.sendKeys(instrNo);

				Thread.sleep(1000);
				chequeamonut.sendKeys(slipAmount);

				Thread.sleep(1000);
				String shortAccNo =row.getCell(7).getStringCellValue();
				shortAcc.sendKeys(shortAccNo);

				Thread.sleep(1000);
				addbutton.click();

				Thread.sleep(2000);
				submitbutton.click();

				Thread.sleep(2000);
				scrollNumber = scrollNo.getText();
				System.out.println("Scroll Number : "+scrollNumber);
				Thread.sleep(3000);
				closeTable.click();

				Thread.sleep(1000);
				emp_photo.click();
				Thread.sleep(1000);
				logout.click();
				Thread.sleep(1000);	

			}
		}

	}
	
	public void authTransaction() throws IOException, InterruptedException
	{
		PendigTab.click();
		Thread.sleep(1000);	
		Thread.sleep(1000);	
		referenceNum=refNo.getText();
		Thread.sleep(1000);	
		System.out.println("RefereneNum: "+referenceNum);
		Thread.sleep(1000);	
//		if(pendingScrollNum.equals(scrollNumber))
//		{
//			refNo.click();
//		}
		refNo.click();
		Thread.sleep(1000);
		authButton.click();
		Thread.sleep(1000);	
		closePopup.click();

	}
	
	public void postDateUpdateDB() 
	{
		String updateQuery1 = "UPDATE BSGACCOUNTING..transaction_status SET post_date = txn_date WHERE is_active = 1 AND txn_ref_no = ?";
		JDBC_San. getConnection();
		JDBC_San.updateTransactionStatus(updateQuery1,referenceNum);
	}
	
	public void postingTplus0 () throws InterruptedException
	{
		Tplus0Posting.click();
		Thread.sleep(3000);	
		String RefnoTplus0= refnoTplus0.getText();
		Thread.sleep(1000);	
		if(RefnoTplus0.equals(referenceNum))
		{
			checkbox.click();
		}
		Thread.sleep(1000);	
		posttxn.click();
		Thread.sleep(1000);
		confirmbutton.click();
		Thread.sleep(1000);
		closePopup.click();
	}
	
	public void fundDateUpdateDB() 
	{
		String updateQuery2 = "UPDATE BSGACCOUNTING..transaction_status set fund_date=txn_date where is_active=1 and txn_ref_no = ?";
		JDBC_San. getConnection();
		JDBC_San.updateTransactionStatus(updateQuery2,referenceNum);
	}
	
	public void fundsRelease() throws InterruptedException
	{
		fundsRelease.click();
		Thread.sleep(1000);
		Select regionCodeDropDown = new Select(regionCode);
		Thread.sleep(1000);
		regionCodeDropDown.selectByIndex(1);
		Thread.sleep(1000);
		Select settlementProductDropDown = new Select(settlementProduct);
		Thread.sleep(1000);
		settlementProductDropDown.selectByIndex(1);
		Thread.sleep(1000);
		submitbutton.click();
		Thread.sleep(1000);
		confirmbutton.click();
		Thread.sleep(2000);
		closePopup.click();
		Thread.sleep(1000);
		emp_photo.click();
		Thread.sleep(1000);
		logout.click();
		Thread.sleep(1000);	
	}
	
	public void clearingFunded() throws InterruptedException
	{
		Thread.sleep(2000);
		clearingFunded.click();
		Thread.sleep(2000);
		lastpage.click();
		Thread.sleep(19000);
		emp_photo.click();
		Thread.sleep(1000);
		logout.click();
		Thread.sleep(1000);	
	}
	
}


