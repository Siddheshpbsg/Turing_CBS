package com.cbs.pages;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.cbs.base.TestBase;
import com.cbs.util.TestUtil;

public class ChequebookPage extends TestBase
{
	public static String Chequebook_Req_Reference_No;

	public ChequebookPage()
	{
		PageFactory.initElements(driver,this);
	}

	TestUtil util=new TestUtil();
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static Row row;
	String location = "D:\\SidheshP\\Siddhesh Training Document\\Automation_For_CBS\\Excel\\Sanket Excel\\CBS_Automation.xlsx";
	public static String SA_reference_No;
	public static String CA_reference_No;
	public static String CC_reference_No;
	public  static String cheque;

	@FindBy(xpath="//input[@id='txtAccNo']")
	WebElement Acc_No_Chequebook_Req; 

	@FindBy(xpath="//*[@class='bsg-form__body p-a-4']")
	WebElement page; 

	@FindBy(xpath="//*[@id='optSignatureTitle']")
	WebElement Signature_Title; 

	@FindBy(xpath="//*[@id='btnSubmitForm']")
	WebElement Submit_Chequebook_Req; 

	@FindBy(xpath="//*[@id='error_message_master']")
	WebElement Error_Message_Master; 

	@FindBy(xpath="//*[@id='id_closeErrorMessage']")
	WebElement Close_Error_Message; 

	@FindBy(xpath="//img[@id='id_emp_photo']")
	WebElement emp_photo;

	@FindBy(xpath="//a[@id='id_logout']")
	WebElement logout;

	@FindBy(xpath="//*[text()='Authorize Request']")
	WebElement auth_tab;

	@FindBy(xpath="//*[@id='btnSearchRequest']")
	WebElement search_button;

	@FindBy(xpath="//*[@id='txtReqRefNo']")
	WebElement ref_no_text;

	@FindBy(xpath="//*[@onclick='authorize(this)']")
	WebElement authorize_button;

	@FindBy(xpath="//*[text()='Generate File']")
	WebElement generate_file;

	@FindBy(xpath="//*[@id='txtReqRefNo']")
	WebElement req_ref_no;

	@FindBy(xpath="//*[@id='optFileGenMode']")
	WebElement file_generation_type;

	@FindBy(xpath="//*[text()='Generate']")
	WebElement generate_button;

	@FindBy(xpath="//*[text()='Chequebook Maintenance']")
	WebElement chequebook_Maintenance;

	@FindBy(xpath="//*[@id='btnSearch']")
	WebElement search_button_maintenanace;

	@FindBy(xpath="//*[@onclick='viewChequeDetails(this);']")
	WebElement accNo_maintenanace;

	@FindBy(xpath="//*[@id='btnDeliverChqBk']")
	WebElement markdeliver_button;

	@FindBy(xpath="//*[text()='Cancel Cheque']")
	WebElement cancel_cheque;

	@FindBy(xpath="//*[@id='idAccountNumber']")
	WebElement acc_no_cancel_cheque;

	@FindBy(xpath="//*[@id='id_search']")
	WebElement search_acc;

	@FindBy(xpath="/html/body/section/section/div[2]/div[3]/div[2]/div/div/div/div/div/div[6]/table/tbody/tr[1]/td[5]/button")
	WebElement cancel_button;

	@FindBy(xpath="//button[contains(text(),'confirm')]")
	WebElement confirm_button;

	@FindBy(xpath="//*[text()='Cancel Cheque Authorization']")
	WebElement cancel_cheque_auth;

	@FindBy(xpath="//*[@id=\"divChequeBookRequestList\"]/table/tbody[1]/tr[1]/td[7]/button")
	WebElement authorize_button_cancel_cheque;

	@SuppressWarnings("deprecation")
	public void SA_Chequebook() throws IOException, InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		fis = new FileInputStream(location);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Chequebook");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(1).getLastCellNum();
		for (int i=1;i<=rowcount;i++)
		{
			row = sheet.getRow(i);
			for(int j=0;j<=colcount;j++)
			{
				Thread.sleep(1000);
				cheque=String.valueOf(row.getCell(0).getStringCellValue());
				Thread.sleep(1000);
				Acc_No_Chequebook_Req.sendKeys(cheque);
				Thread.sleep(1000);
				Acc_No_Chequebook_Req.sendKeys(Keys.TAB);
				Thread.sleep(1000);
				Select dropdown = new Select(Signature_Title);
				Thread.sleep(1000);
				dropdown.selectByIndex(1);
				Submit_Chequebook_Req.click();
				Thread.sleep(1000);
				SA_reference_No=Error_Message_Master.getText();
				Thread.sleep(1000);
				SA_reference_No=SA_reference_No.replace("Reference no for cheque book request : ","");
				SA_reference_No=SA_reference_No.replace("x", "");
				SA_reference_No=SA_reference_No.replace("Success", "");
				SA_reference_No=SA_reference_No.trim();
				Thread.sleep(1000);
				System.out.println("SA Chequebook Refference Number :"+SA_reference_No);
				Thread.sleep(1000);
				Close_Error_Message.click();
				Thread.sleep(1000);
				emp_photo.click();
				Thread.sleep(1000);
				logout.click();
			}
		}
	}

	public void auth_SA_Chequebook() throws InterruptedException
	{
		auth_tab.click();
		Thread.sleep(1000);
		ref_no_text.sendKeys(SA_reference_No);
		Thread.sleep(1000);
		search_button.click();
		Thread.sleep(1000);
		authorize_button.click();
		Thread.sleep(1000);
		Close_Error_Message.click();
		Thread.sleep(1000);
		emp_photo.click();
		logout.click();
	}

	@SuppressWarnings("deprecation")
	public void CA_Chequebook() throws IOException, InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		fis = new FileInputStream(location);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Chequebook");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(1).getLastCellNum();
		for (int i=1;i<=rowcount;i++)
		
		{
			row = sheet.getRow(i);
			for(int j=0;j<=colcount;j++)
			{
				Thread.sleep(1000);
				String AccNO=String.valueOf(row.getCell(1).getStringCellValue());
				Thread.sleep(1000);
				Acc_No_Chequebook_Req.sendKeys(AccNO);
				Thread.sleep(1000);
				Acc_No_Chequebook_Req.sendKeys(Keys.TAB);
				Thread.sleep(1000);
				Select dropdown = new Select(Signature_Title);
				Thread.sleep(1000);
				dropdown.selectByIndex(1);
				Submit_Chequebook_Req.click();
				Thread.sleep(1000);
				CA_reference_No=Error_Message_Master.getText();
				Thread.sleep(1000);
				CA_reference_No=CA_reference_No.replace("Reference no for cheque book request : ","");
				CA_reference_No=CA_reference_No.replace("x", "");
				CA_reference_No=CA_reference_No.replace("Success", "");
				CA_reference_No=CA_reference_No.trim();
				Thread.sleep(1000);
				System.out.println("CA Chequebook Refference Number :"+CA_reference_No);
				Thread.sleep(1000);
				Close_Error_Message.click();
				Thread.sleep(1000);
				emp_photo.click();
				Thread.sleep(1000);
				logout.click();
			}
		}
	}

	@SuppressWarnings("deprecation")
	public void auth_CA_Chequebook() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		auth_tab.click();
		Thread.sleep(1000);
		ref_no_text.sendKeys(CA_reference_No);
		Thread.sleep(1000);
		search_button.click();
		Thread.sleep(1000);
		authorize_button.click();
		Thread.sleep(1000);
		Close_Error_Message.click();
		Thread.sleep(1000);
		emp_photo.click();
		logout.click();
	}

	@SuppressWarnings("deprecation")
	public void CC_Chequebook() throws IOException, InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		fis = new FileInputStream(location);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Chequebook");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(1).getLastCellNum();
		for (int i=1;i<=rowcount;i++)
		{
			row = sheet.getRow(i);
			for(int j=0;j<=colcount;j++)
			{
				Thread.sleep(1000);
				String AccNO=String.valueOf(row.getCell(2).getStringCellValue());
				Thread.sleep(1000);
				Acc_No_Chequebook_Req.sendKeys(AccNO);
				Thread.sleep(1000);
				Acc_No_Chequebook_Req.sendKeys(Keys.TAB);
				Thread.sleep(1000);
				Close_Error_Message.click();
				Thread.sleep(1000);
				Select dropdown = new Select(Signature_Title);
				Thread.sleep(1000);
				dropdown.selectByIndex(1);
				Submit_Chequebook_Req.click();
				Thread.sleep(1000);
				CC_reference_No=Error_Message_Master.getText();
				Thread.sleep(1000);
				CC_reference_No=CC_reference_No.replace("Reference no for cheque book request : ","");
				CC_reference_No=CC_reference_No.replace("x", "");
				CC_reference_No=CC_reference_No.replace("Success", "");
				CC_reference_No=CC_reference_No.trim();
				Thread.sleep(1000);
				System.out.println("CC Chequebook Refference Number :"+CC_reference_No);
				Thread.sleep(1000);
				Close_Error_Message.click();
				Thread.sleep(1000);
				emp_photo.click();
				Thread.sleep(1000);
				logout.click();
			}
		}
	}

	@SuppressWarnings("deprecation")
	public void auth_CC_Chequebook() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		auth_tab.click();
		Thread.sleep(1000);
		ref_no_text.sendKeys(CC_reference_No);
		Thread.sleep(1000);
		search_button.click();
		Thread.sleep(1000);
		authorize_button.click();
		Thread.sleep(1000);
		Close_Error_Message.click();
		Thread.sleep(1000);
		emp_photo.click();
		logout.click();
	}

	public void generate_File() throws InterruptedException
	{
		generate_file.click();
		Thread.sleep(1000);
		req_ref_no.sendKeys(SA_reference_No);
		Thread.sleep(1000);
		req_ref_no.sendKeys(Keys.TAB);
		Thread.sleep(1000);
		search_button.click();
		Thread.sleep(1000);
		Select dropdown = new Select(file_generation_type);
		dropdown.selectByIndex(1);
		Thread.sleep(1000);
		generate_button.click();
		Thread.sleep(1000);
		Close_Error_Message.click();
		Thread.sleep(1000);
	}

	public void chequebook_Maintenance() throws InterruptedException
	{
		chequebook_Maintenance.click();
		Thread.sleep(1000);
		req_ref_no.sendKeys(SA_reference_No);
		Thread.sleep(1000);
		req_ref_no.sendKeys(Keys.TAB);
		Thread.sleep(1000);
		search_button_maintenanace.click();
		Thread.sleep(1000);
		accNo_maintenanace.click();
		Thread.sleep(1000);
		markdeliver_button.click();
		Thread.sleep(1000);
		Close_Error_Message.click();
		Thread.sleep(2000);
	}

	public void cancel_Cheque() throws InterruptedException, IOException
	{
		cancel_cheque.click();
		Thread.sleep(1000);
		acc_no_cancel_cheque.sendKeys(cheque);
		search_acc.click();
		Thread.sleep(1000);
		cancel_button.click();
		Thread.sleep(2000);
		confirm_button.click();
		Thread.sleep(1000);
		Close_Error_Message.click();
		Thread.sleep(1000);
		emp_photo.click();
		logout.click();
	}

	public void auth_cancel_Cheque() throws InterruptedException, IOException
	{
		cancel_cheque_auth.click();
		Thread.sleep(1000);
		authorize_button_cancel_cheque.click();
		Thread.sleep(1000);
		Close_Error_Message.click();
		Thread.sleep(1000);
		emp_photo.click();
		logout.click();
	}

}
