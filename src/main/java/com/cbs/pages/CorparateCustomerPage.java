package com.cbs.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.cbs.base.TestBase;
import com.cbs.util.JDBCConnection;
import com.cbs.util.TestUtil;

public class CorparateCustomerPage extends TestBase
{
	Robot robot;
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static Row row;
	String location = "D:\\SidheshP\\Siddhesh Training Document\\Automation_For_CBS\\Excel\\Sanket Excel\\CBS_Automation.xlsx";
	TestUtil util;
	public static String Corp_cust_id;
	public static String data;
	public static String Migrated_Corp_cust_id;

	//customer info
	@FindBy(xpath="//button[@id='btnNewCustomer']")
	WebElement NewCustomerbutton;

	@FindBy(xpath="//input[@id='id_fullName']")
	WebElement Full_Name;

	@FindBy(xpath="//input[@id='id_txtPan']")
	WebElement Pan_No;

	@FindBy(xpath="//select[@id='id__Subtype']")
	WebElement Customer_Category;

	@FindBy(xpath="//input[@id='id_txtMobileNumber']")
	WebElement Mobile_num;

	@FindBy(xpath="//input[@id='id_txtRegistrationNo']")
	WebElement Reg_num;

	@FindBy(xpath="//input[@id='id_incorporationDate']")
	WebElement Date_of_Incorporation;

	@FindBy(xpath="//input[@id='id_txtRegistration']")
	WebElement Date_of_Registration;

	@FindBy(xpath="//select[@id='id_txtBusinessType']")
	WebElement Business_Type;

	@FindBy(xpath="//select[@id='id_default_risk_rating']")
	WebElement Default_Risk_Rating;

	@FindBy(xpath="//select[@id='id_professionSelect']")
	WebElement Profession;

	@FindBy(xpath="//select[@id='id_annualIncomeCategorySelect']")
	WebElement Annual_Income_Category;

	@FindBy(xpath="//select[@id='id_basedOnProfessionSelect']")
	WebElement Based_on_Profession;

	@FindBy(xpath="//input[@id='id_txtCustomerAddress1']")
	WebElement Address_1;

	@FindBy(xpath="//input[@id='id_txtCustomerAddress2']")
	WebElement Address_2;

	@FindBy(xpath="//input[@id='id_txtCustomerAddress3']")
	WebElement Address_3;

	@FindBy(xpath="//select[@id='id_CustomerStateType']")
	WebElement Corp_State;

	@FindBy(xpath="//select[@id='id_CustomerCity']")
	WebElement Corp_City;

	@FindBy(xpath="//select[@id='id_CustomerCountryType']")
	WebElement Corp_Country;

	@FindBy(xpath="//input[@id='id_txtCustomerPincode']")
	WebElement Corp_Pin_Code;

	@FindBy(xpath="//input[@id='id_sameAsAbove']")
	WebElement Same_as_Above;

	@FindBy(xpath="//input[@id='id_txtCustomerPhoneOfficeNumber']")
	WebElement Phone_Office;

	@FindBy(xpath="//button[@id='id_SubmitCustomerInfo']")
	WebElement SubmitCustomerInfo;

	@FindBy(xpath="//div[@id='error_message_master']")
	WebElement Error_message_master;

	@FindBy(xpath="//a[@id='id_closeErrorMessage']")
	WebElement CloseErrorMessage;

	@FindBy(xpath="//span[contains(text(),'Company Details')]")
	WebElement Company_Details;

	@FindBy(xpath="//select[@id='id_TypeOfCompany']")
	WebElement Type_of_Company;

	@FindBy(xpath="//input[@id='id_txt_No_of_Partners']")
	WebElement No_of_Partners_Directors;

	@FindBy(xpath="//input[@id='id_txtPlaceOfIncorporation']")
	WebElement Place_of_Incorporation;

	@FindBy(xpath="//select[@id='id_CompanyAddressCountryType']")
	WebElement Country_of_Incorporation;

	@FindBy(xpath="//input[@id='id_txtParentCompany']")
	WebElement Parent_Company;

	@FindBy(xpath="//input[@id='id_txtApexHoldingCompany']")
	WebElement Apex_Holding_Company;

	@FindBy(xpath="//input[@id='id_txtContactPerson']")
	WebElement Contact_Person;

	@FindBy(xpath="//select[@id='id_ContactPersonDesignationType']")
	WebElement Contact_Person_Designation;

	@FindBy(xpath="//button[@id='id_SubmitCompanydetail']")
	WebElement submitCompanydetail;

	@FindBy(xpath="//span[contains(text(),'Business Details')]")
	WebElement Business_Details;

	@FindBy(xpath="//select[@id='id_BusinessNature']")
	WebElement Business_Nature;

	@FindBy(xpath="//input[@id='id_txt_commencement_date']")
	WebElement Commencement_Date;

	@FindBy(xpath="//input[@id='id_txtLicenseNo']")
	WebElement License_No;

	@FindBy(xpath="//input[@id='id_txtLicenseExpiryDate']")
	WebElement License_Expiry_Date;

	@FindBy(xpath="//input[@id='id_txt_credit_rating']")
	WebElement Internal_Credit_Rating;

	@FindBy(xpath="//select[@id='id_industryCode']")
	WebElement Industry_Code;

	@FindBy(xpath="//select[@id='id_IndustryType']")
	WebElement Industry_Type;

	@FindBy(xpath="//button[@id='id_SubmitBusinessdetail']")
	WebElement SubmitBusinessdetail;

	@FindBy(xpath="//span[contains(text(),'Business Bank Details')]")
	WebElement Business_Bank_Details;

	@FindBy(xpath="//input[@id='id_txtBankName']")
	WebElement Bank_Name;

	@FindBy(xpath="//input[@id='id_txtBranchName']")
	WebElement Branch_Name;

	@FindBy(xpath="//input[@id='id_txtAccountNumber']")
	WebElement Account_Number;

	@FindBy(xpath="//button[@id='id_AddBusinessdetail']")
	WebElement AddBusinessdetail;

	@FindBy(xpath="//button[@id='id_SubmitBusinessdetail']")
	WebElement SubmitBusinessbankdetail;

	@FindBy(xpath="//span[contains(text(),'Financial Details')]")
	WebElement Financial_Details;

	@FindBy(xpath="//input[@id='id_txt_company_net_worth']")
	WebElement Company_Net_Worth;

	@FindBy(xpath="//input[@id='id_txt_last_financial_update']")
	WebElement Last_Financial_Update;

	@FindBy(xpath="//input[@id='id_txtAuthorizedCapital']")
	WebElement Authorized_Capital;

	@FindBy(xpath="//input[@id='id_txtPaidUpCapital']")
	WebElement Paid_Up_Capital;

	@FindBy(xpath="//input[@id='id_txt_Net_Last_Year']")
	WebElement Net_Profit_Loss_last;

	@FindBy(xpath="//input[@id='id_txt_Net_Year_Before']")
	WebElement Net_Profit_Loss_before;

	@FindBy(xpath="//input[@id='id_txt_annual_turnover']")
	WebElement Annual_Turnover;

	@FindBy(xpath="//input[@id='id_txtAuditAgency']")
	WebElement Audit_Agency;

	@FindBy(xpath="//input[@id='id_txtAuditorName1']")
	WebElement Auditor_Name_1;

	@FindBy(xpath="//input[@id='id_txtAuditorName2']")
	WebElement Auditor_Name_2;

	@FindBy(xpath="//button[@id='id_SubmitFinancialdetail']")
	WebElement SubmitFinancialdetail;

	@FindBy(xpath="//span[contains(text(),'Shareholder Details')]")
	WebElement Shareholder_Details;

	@FindBy(xpath="//input[@id='id_txt_Shareholder_Name']")
	WebElement Name;

	@FindBy(xpath="//input[@id='id_txt_Shareholding_percent']")
	WebElement Shareholding;

	@FindBy(xpath="//input[@id='id_txt_Shareholder_Tin']")
	WebElement Tax_identification_No;

	@FindBy(xpath="//select[@id='id_Shareholder_relation']")
	WebElement Relationship;

	@FindBy(xpath="//input[@id='id_txt_Shareholder_Address1']")
	WebElement Sharehold_Address_1;

	@FindBy(xpath="//input[@id='id_txt_Shareholder_Address2']")
	WebElement Sharehold_Address_2;

	@FindBy(xpath="//input[@id='id_txt_Shareholder_Address3']")
	WebElement Sharehold_Address_3;

	@FindBy(xpath="//button[@id='id_AddBusinessdetail']")
	WebElement AddShareholderdetail;

	@FindBy(xpath="//button[@id='id_submitShareHolder']")
	WebElement submitShareHolder;

	@FindBy(xpath="//span[contains(text(),'Signature')]")
	WebElement Signature;

	@FindBy(xpath="//span[contains(text(),'Photo')]")
	WebElement Photo;

	@FindBy(xpath="//span[contains(text(),'Beneficial Owner')]")
	WebElement Beneficial_Owner;

	@FindBy(xpath="//*[@id='dropdownMenu1']")
	WebElement emp_photo;

	@FindBy(xpath="//button[@id='id_photo_upload_add']")
	WebElement add_photo;

	@FindBy(xpath="//*[@id='id_logout']")
	WebElement logout;

	@FindBy(xpath="//*[@id='id_SkipDetails']")
	WebElement skip;


	@FindBy(xpath="//button[@id='btnAuthorize']")
	WebElement btnAuthorize;

	@FindBy(xpath="//button[@id='btnVerify']")
	WebElement btnVerify;

	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[10]/button[@type='button']")
	WebElement Buss_bank_View;

	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[11]/button[@id='btnVerify_0']")
	WebElement Buss_bank_Verify;

	//	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[4]/button[contains(text(),'View')]")
	//	WebElement Shareholder_View;

	@FindBy(xpath="//*[@class='btn btn-new btn-primary text-uppercase']")
	WebElement Shareholder_View;

	//	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[5]/button[contains(text(),'Verify')]")
	//	WebElement Shareholder_Verify;

	@FindBy(xpath="//*[@onclick='verify()']")
	WebElement Shareholder_Verify;


	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[3]/button[contains(text(),'View')]")
	WebElement Sign_View;

	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[4]/button[contains(text(),'Verify')]")
	WebElement Sign_Verify;

	//	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[3]/button[contains(text(),'View')]")
	//	WebElement Photo_View;

	@FindBy(xpath="//*[@class='btn btn-new btn-primary text-uppercase']")
	WebElement Photo_View;

	//	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[4]/button[contains(text(),'Verify')]")
	//	WebElement Photo_Verify;

	@FindBy(xpath="//*[@onclick='verify()']")
	WebElement Photo_Verify;

	@FindBy(xpath="//button[@id='btnEdit']")
	WebElement Edit;

	@FindBy(xpath="//input[@id='id_txtCustomerNumber']")
	WebElement customer_id;

	@FindBy(xpath="//button[@id='btnSearchRequest']")
	WebElement Search;

	@FindBy(xpath="//input[@id='id_txtCustomerPhoneResidentNumber']")
	WebElement Phone_Residence;

	@FindBy(xpath="//input[@id='id_txtCustomerEmailid']")
	WebElement Email_id;

	@FindBy(xpath="//button[@id='id_SubmitCustomerInfo']")
	WebElement Update;

	@FindBy(xpath="//button[@id='btnView']")
	WebElement custView;

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

	@FindBy(xpath="//span[contains(text(),'Customer Maintenance')]")
	WebElement Customer_Maintenance;

	@FindBy(xpath="//button[@id='btnSendForVerify']")
	WebElement SendForVerify;

	@FindBy(xpath="//button[@id='btnAuthorize']")
	WebElement Authorize;
	//
	//	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[14]/button[contains(text(),'View')]")
	//	WebElement KYC_View;

	@FindBy(xpath="//*[@class='btn btn-new btn-primary text-uppercase']")
	WebElement KYC_View;

	//	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[15]/button[contains(text(),'Verify')]")
	//	WebElement KYC_Verify;

	@FindBy(xpath="//*[@onclick='verify()']")
	WebElement KYC_Verify;

	public static String generateRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 0; i < length; i++) {
			sb.append(letters.charAt(new Random().nextInt(letters.length())));
		}
		return sb.toString();
	}

	public static String generateRandomDigits(int length) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(new Random().nextInt(10));
		}
		return sb.toString();
	}

	public CorparateCustomerPage()
	{
		PageFactory.initElements(driver,this);
	}

	/*public void createCorpCustomer(String full_name,String pan,String mob_num, String reg_num,String date_of_inco,
			String date_of_reg,String address1,String address2,String address3,String pin,String patner,String place,
			String parent_comp,String apex_hold_comp,String contact_person,String commencement_date,String license_no,
			String license_expiry_date,String inter_credit_rat,String bank_name,String branch_name,String acc_no,
			String company_Net_Worth,String last_Financial_Update,String authorized_Capital,String paid_Up_Capital,
			String net_Profit_Loss_last,String net_Profit_Loss_before,String annual_Turnover,String audit_Agency,
			String auditor_Name_1,String auditor_Name_2,String name,String shareholder,String tax_no,
			String shareholder_addr1,String shareholder_addr2,String shareholder_addr3) */

	@SuppressWarnings("deprecation")
	public void createCorpCustomer() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver,null);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		NewCustomerbutton.click();
		Thread.sleep(3000);
		fis = new FileInputStream(location);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Corp Cust");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(1).getLastCellNum();
		for (int i = 1; i <= rowcount; i++)
		{
			row = sheet.getRow(i);
			for(int j=0;j<colcount;j++)
			{
				XSSFCell cell=(XSSFCell) row.getCell(j);
				String randomPAN =generateRandomString(5) + generateRandomDigits(4) + generateRandomString(1);
				Pan_No.sendKeys(randomPAN);
				//Pan_No.sendKeys(row.getCell(0).getStringCellValue());
				Full_Name.sendKeys(row.getCell(1).getStringCellValue());
				Select customer_category =new Select(Customer_Category);
				customer_category.selectByIndex(4);
				long mob = (long) row.getCell(2).getNumericCellValue();
				Mobile_num.sendKeys(String.valueOf(mob));
				int reg_num=(int) row.getCell(3).getNumericCellValue();
				Reg_num.sendKeys(String.valueOf(reg_num));
				int date_of_incorporation = (int) row.getCell(4).getNumericCellValue();
				Date_of_Incorporation.sendKeys(String.valueOf(date_of_incorporation));
				int date_of_registration = (int) row.getCell(5).getNumericCellValue();
				Date_of_Registration.sendKeys(String.valueOf(date_of_registration));
				Select default_Risk_Rating =new Select(Default_Risk_Rating);
				default_Risk_Rating.selectByIndex(1);
				Select bussiness_type =new Select(Business_Type);
				bussiness_type.selectByIndex(1);

				Thread.sleep(2000);

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0, 500)");
				//				Select profession =new Select(Profession);
				//				profession.selectByIndex(1);
				//				Select annual_Income_Category =new Select(Annual_Income_Category);
				//				annual_Income_Category.selectByIndex(2);
				//				Select based_on_Profession =new Select(Based_on_Profession);
				//				based_on_Profession.selectByIndex(6);

				Address_1.sendKeys(row.getCell(6).getStringCellValue());
				Address_2.sendKeys(row.getCell(7).getStringCellValue());
				Address_3.sendKeys(row.getCell(8).getStringCellValue());
				Select City=new Select(driver.findElement(By.xpath("//select[@id='id_CustomerCity']")));
				City.selectByIndex(3);
				Select State=new Select(driver.findElement(By.xpath("//select[@id='id_CustomerStateType']")));
				State.selectByIndex(3);
				long pin_code = (long) row.getCell(9).getNumericCellValue();
				Corp_Pin_Code.sendKeys(String.valueOf(pin_code));
				Select Country=new Select(driver.findElement(By.xpath("//select[@id='id_CustomerCountryType']")));
				Country.selectByIndex(1);
				//Thread.sleep(2000);
				Same_as_Above.click();
				//Thread.sleep(2000);
				long phone_office = (long) row.getCell(10).getNumericCellValue();
				Phone_Office.sendKeys(String.valueOf(phone_office));
				//Thread.sleep(3000);
				SubmitCustomerInfo.click();
				Thread.sleep(2000);
				//wait.until(ExpectedConditions.visibilityOf(Error_message_master));
				Corp_cust_id=Error_message_master.getText();
				Corp_cust_id = Corp_cust_id.replace("Success", "");
				Corp_cust_id = Corp_cust_id.replace("Corporate Customer ID", "");
				Corp_cust_id = Corp_cust_id.replace("x", "");
				Corp_cust_id = Corp_cust_id.trim();
				System.out.println("Corporate Customer ID:" +Corp_cust_id);
				row.createCell(40).setCellValue(Corp_cust_id);
				Thread.sleep(3000);
				CloseErrorMessage.click();
				Thread.sleep(2000);
				//wait.until(ExpectedConditions.elementToBeClickable(Company_Details));
				//js.executeScript("arguments[0].click();",Company_Details);
				Company_Details.click();
				Thread.sleep(3000);
				Select type_of_Company=new Select(Type_of_Company);
				type_of_Company.selectByIndex(2);
				int no_of_Partners_Directors = (int) row.getCell(12).getNumericCellValue();
				No_of_Partners_Directors.sendKeys(String.valueOf(no_of_Partners_Directors));
				Place_of_Incorporation.sendKeys(row.getCell(13).getStringCellValue());
				Select country_of_Incorporation=new Select(Country_of_Incorporation);
				country_of_Incorporation.selectByIndex(1);
				Parent_Company.sendKeys(row.getCell(14).getStringCellValue());
				Apex_Holding_Company.sendKeys(row.getCell(15).getStringCellValue());
				Contact_Person.sendKeys(row.getCell(16).getStringCellValue());
				Select contact_Person_Designation=new Select(Contact_Person_Designation);
				contact_Person_Designation.selectByIndex(2);
				submitCompanydetail.click();
				Thread.sleep(3000);
				CloseErrorMessage.click();
				Thread.sleep(2000);
				//wait.until(ExpectedConditions.elementToBeClickable(Business_Details));
				//js.executeScript("arguments[0].click();",Business_Details);

				Business_Details.click();
				Thread.sleep(3000);
				Select business_Nature=new Select(Business_Nature);
				business_Nature.selectByIndex(1);
				int commencement_Date = (int) row.getCell(17).getNumericCellValue();
				Commencement_Date.sendKeys(String.valueOf(commencement_Date));
				int license_No = (int) row.getCell(18).getNumericCellValue();
				License_No.sendKeys(String.valueOf(license_No));
				int license_Expiry_Date = (int) row.getCell(19).getNumericCellValue();
				License_Expiry_Date.sendKeys(String.valueOf(license_Expiry_Date));
				int internal_Credit_Rating = (int) row.getCell(20).getNumericCellValue();
				Internal_Credit_Rating.sendKeys(String.valueOf(internal_Credit_Rating));
				Select industry_Code=new Select(Industry_Code);
				industry_Code.selectByIndex(1);
				Select industry_Type=new Select(Industry_Type);
				industry_Type.selectByIndex(1);
				SubmitBusinessdetail.click();
				Thread.sleep(3000);
				CloseErrorMessage.click();
				//Thread.sleep(3000);
				Thread.sleep(2000);

				//				wait.until(ExpectedConditions.elementToBeClickable(Business_Bank_Details));	
				//				js.executeScript("arguments[0].click();",Business_Bank_Details);

				Business_Bank_Details.click();
				Thread.sleep(3000);
				Bank_Name.sendKeys(row.getCell(21).getStringCellValue());
				Branch_Name.sendKeys(row.getCell(22).getStringCellValue());
				Account_Number.sendKeys(row.getCell(23).getStringCellValue());
				AddBusinessdetail.click();
				//Thread.sleep(1000);
				SubmitBusinessbankdetail.click();
				Thread.sleep(2000);
				CloseErrorMessage.click();
				Thread.sleep(3000);

				//				
				//				wait.until(ExpectedConditions.elementToBeClickable(Financial_Details));
				//				js.executeScript("arguments[0].click();", Financial_Details);
				Financial_Details.click();
				Thread.sleep(3000);
				long company_Net_Worth = (long) row.getCell(24).getNumericCellValue();
				Company_Net_Worth.sendKeys(String.valueOf(company_Net_Worth));
				int last_Financial_Update = (int) row.getCell(25).getNumericCellValue();
				Last_Financial_Update.sendKeys(String.valueOf(last_Financial_Update));
				long authorized_Capital = (long) row.getCell(26).getNumericCellValue();
				Authorized_Capital.sendKeys(String.valueOf(authorized_Capital));
				long paid_Up_Capital = (long) row.getCell(27).getNumericCellValue();
				Paid_Up_Capital.sendKeys(String.valueOf(paid_Up_Capital));
				long net_Profit_Loss_last = (long) row.getCell(28).getNumericCellValue();
				Net_Profit_Loss_last.sendKeys(String.valueOf(net_Profit_Loss_last));
				long net_Profit_Loss_before = (long) row.getCell(29).getNumericCellValue();
				Net_Profit_Loss_before.sendKeys(String.valueOf(net_Profit_Loss_before));
				long annual_Turnover = (long) row.getCell(30).getNumericCellValue();
				Annual_Turnover.sendKeys(String.valueOf(annual_Turnover));
				Audit_Agency.sendKeys(row.getCell(31).getStringCellValue());
				Auditor_Name_1.sendKeys(row.getCell(32).getStringCellValue());
				Auditor_Name_2.sendKeys(row.getCell(33).getStringCellValue());
				SubmitFinancialdetail.click();
				Thread.sleep(2000);
				CloseErrorMessage.click();
				Thread.sleep(2000);
				//				wait.until(ExpectedConditions.elementToBeClickable(Shareholder_Details));
				//				js.executeScript("arguments[0].click();",Shareholder_Details);
				//Thread.sleep(2000);
				Shareholder_Details.click();
				Thread.sleep(2000);
				Name.sendKeys(row.getCell(34).getStringCellValue());
				int shareholder = (int) row.getCell(35).getNumericCellValue();
				Shareholding.sendKeys(String.valueOf(shareholder));
				int tax_no = (int) row.getCell(36).getNumericCellValue();
				Tax_identification_No.sendKeys(String.valueOf(tax_no));
				Select relationship=new Select(Relationship);
				relationship.selectByVisibleText("Friend");
				Sharehold_Address_1.sendKeys(row.getCell(37).getStringCellValue());
				Sharehold_Address_2.sendKeys(row.getCell(38).getStringCellValue());
				Sharehold_Address_3.sendKeys(row.getCell(39).getStringCellValue());
				AddShareholderdetail.click();
				Thread.sleep(2000);
				submitShareHolder.click();
				Thread.sleep(2000);
				CloseErrorMessage.click();
				Thread.sleep(2000);

				//				wait.until(ExpectedConditions.elementToBeClickable(Signature));
				//				js.executeScript("arguments[0].click();",Signature);
				Signature.click();
				Thread.sleep(3000);
				util=new TestUtil();
				util.addsignature();
				Thread.sleep(2000);
				

				//				wait.until(ExpectedConditions.elementToBeClickable(Photo));
				js.executeScript("arguments[0].click();",Photo);
				util.addphoto();
				
				fos=new FileOutputStream(location);
				workbook.write(fos);

				//				wait.until(ExpectedConditions.elementToBeClickable(skip));
				//				js.executeScript("arguments[0].click();",skip);
				//				emp_photo.click();
				//				Thread.sleep(2000);
				//				logout.click();
				//				Thread.sleep(3000);
				//Photo.click();
				//Thread.sleep(3000);

				//				Thread.sleep(4000);
				//				wait.until(ExpectedConditions.elementToBeClickable(Beneficial_Owner));
				//				js.executeScript("arguments[0].click();",Beneficial_Owner);

				//wait.until(ExpectedConditions.elementToBeClickable(emp_photo));

				js.executeScript("arguments[0].click();",emp_photo);
				//	wait.until(ExpectedConditions.elementToBeClickable(logout));
				js.executeScript("arguments[0].click();",logout);
			}
		}

	}

	public void authCorpCustomer() throws Exception
	{
		btnAuthorize.click();
		Thread.sleep(3000);
		WebElement customer_id=driver.findElement(By.xpath("//select[@id='id_optCustomerNumber']"));
		List<WebElement> dropdown=customer_id.findElements(By.tagName("option"));
		for(int i=0;i<dropdown.size();i++)
		{
			//System.out.println(dropdown.get(i).getText());
			if(dropdown.get(i).getText().equals(Corp_cust_id))
			{
				dropdown.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		btnVerify.click();
		Thread.sleep(2000);
		data=Error_message_master.getText();
		data = data.replace("Success", "");
		data = data.replace("x", "");
		data = data.replace("fully verified for", "");
		data = data.trim();
		row.createCell(41).setCellValue(data);
		fos=new FileOutputStream(location);
		workbook.write(fos);
		Thread.sleep(3000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Company_Details.click();
		Thread.sleep(3000);
		btnVerify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Business_Details.click();
		Thread.sleep(3000);
		btnVerify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Business_Bank_Details.click();
		Thread.sleep(3000);
		Buss_bank_View.click();
		Thread.sleep(2000);
		Buss_bank_Verify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Financial_Details.click();
		Thread.sleep(3000);
		btnVerify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Shareholder_Details.click();
		Thread.sleep(3000);
		Shareholder_View.click();
		Thread.sleep(3000);
		Shareholder_Verify.click();
		Thread.sleep(3000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Signature.click();
		Thread.sleep(3000);
		Sign_View.click();
		Thread.sleep(2000);
		Sign_Verify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Photo.click();
		Thread.sleep(3000);
		Photo_View.click();
		Thread.sleep(2000);
		Photo_Verify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(1000);
		logout.click();
		Thread.sleep(3000);
	}
	public void editCorpCustomer() throws Exception
	{
		Edit.click();
		Thread.sleep(3000);
		customer_id.sendKeys(Corp_cust_id);
		Search.click();
		Thread.sleep(3000);
		fis = new FileInputStream(location);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Corp Cust");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(1).getLastCellNum();
		for (int i = 1; i <= rowcount; i++)
		{
			row = sheet.getRow(i);
			for(int j=0;j<colcount;j++)
			{
				XSSFCell cell=(XSSFCell) row.getCell(j);
				/*long phone_num = (long) row.getCell().getNumericCellValue();
				Phone_Residence.sendKeys(String.valueOf(phone_num));*/
				Email_id.sendKeys(row.getCell(11).getStringCellValue());
				Update.click();
				Thread.sleep(3000);
				CloseErrorMessage.click();
				Thread.sleep(2000);
				emp_photo.click();
				Thread.sleep(2000);
				logout.click();
				Thread.sleep(3000);
			}
		}
	}
	public void editAuthcorp() throws Exception
	{
		btnAuthorize.click();
		Thread.sleep(3000);
		WebElement customer_id=driver.findElement(By.xpath("//select[@id='id_optCustomerNumber']"));
		List<WebElement> dropdown=customer_id.findElements(By.tagName("option"));
		for(int i=0;i<dropdown.size();i++)
		{
			//System.out.println(dropdown.get(i).getText());
			if(dropdown.get(i).getText().equals(Corp_cust_id))
			{
				dropdown.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		btnVerify.click();
		Thread.sleep(3000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}
	public void viewCorpCustomer() throws Exception
	{
		custView.click();
		Thread.sleep(3000);
		customer_id.sendKeys(Corp_cust_id);
		Search.click();
		Thread.sleep(3000);
		Company_Details.click();
		Thread.sleep(3000);
		Business_Details.click();
		Thread.sleep(3000);
		Business_Bank_Details.click();
		Thread.sleep(3000);
		Buss_bank_View.click();
		Thread.sleep(3000);
		Financial_Details.click();
		Thread.sleep(3000);
		Shareholder_Details.click();
		Thread.sleep(3000);
		Shareholder_View.click();
		Thread.sleep(3000);
		Signature.click();
		Thread.sleep(3000);
		Sign_View.click();
		Thread.sleep(3000);
		Photo.click();
		Thread.sleep(3000);
		Photo_View.click();
		Thread.sleep(3000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}

	public void corp_cust_KYC(String doc_no,String exp_date,String remark) throws Exception
	{
		Customer_Maintenance.click();
		Thread.sleep(3000);
		btnNewCustomer.click();
		Thread.sleep(3000);
		CustomerNumber.sendKeys(Corp_cust_id);
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

	public void editMigratedCorpCustomer(String phone_num, String email ) throws Exception
	{
		Edit.click();
		Thread.sleep(2000);
		Migrated_Corp_cust_id=JDBCConnection.getMigratedCorpCustomer();
		System.out.println("Migrated_Corp_cust_id: " +Migrated_Corp_cust_id);
		customer_id.sendKeys(Migrated_Corp_cust_id);
		Search.click();
		Thread.sleep(2000);
		for(int i=1;i<=10;i++)
		{
			Phone_Residence.sendKeys(Keys.BACK_SPACE);
		}
		Phone_Residence.sendKeys(phone_num);
		Thread.sleep(1000);
		for(int i=1;i<=25;i++)
		{
			Email_id.sendKeys(Keys.BACK_SPACE);
		}
		Email_id.sendKeys(email);
		Update.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(2000);
	}

	public void authMigratedCorpCustomer() throws Exception
	{
		btnAuthorize.click();
		Thread.sleep(3000);
		WebElement customer_id=driver.findElement(By.xpath("//select[@id='id_optCustomerNumber']"));
		List<WebElement> dropdown=customer_id.findElements(By.tagName("option"));
		for(int i=0;i<dropdown.size();i++)
		{
			//System.out.println(dropdown.get(i).getText());
			if(dropdown.get(i).getText().equals(Migrated_Corp_cust_id))
			{
				dropdown.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		btnVerify.click();
		Thread.sleep(3000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}

	public void viewMigratedCorpCustomer() throws Exception
	{
		custView.click();
		Thread.sleep(3000);
		customer_id.sendKeys(Migrated_Corp_cust_id);
		Search.click();
		Thread.sleep(3000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}

	public void customer_kyc_Details() throws Exception
	{
		Customer_Maintenance.click();
		Thread.sleep(3000);
		btnNewCustomer.click();
		Thread.sleep(3000);
		fis = new FileInputStream(location);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("CorpCustKyc");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(1).getLastCellNum();
		for (int i=1;i<=rowcount;i++)
		{
			row = sheet.getRow(i);
			for(int j=0;j<colcount;j++)
			{
				XSSFCell cell=(XSSFCell) row.getCell(j);
				//Long cust_id=(long) row.getCell(0).getNumericCellValue();
				CustomerNumber.sendKeys(Corp_cust_id);
				//CustomerNumber.sendKeys(Indv_cust_id);
				SearchRequest.click();
				Thread.sleep(2000);
				KYC_tab.click();
				Thread.sleep(3000);
				Select document_Type=new Select(Document_Type);
				document_Type.selectByIndex(1);
				//document_Type.selectByVisibleText("Loan Agreement");
				Long Docket_no=(long) row.getCell(0).getNumericCellValue();
				Docket_No.sendKeys(String.valueOf(Docket_no));
				//Docket_No.sendKeys(doc_no);
				Document_Expiry_Date.clear();
				double doe = (double) row.getCell(1).getNumericCellValue();
				Document_Expiry_Date.sendKeys(String.valueOf(doe));
				//Document_Expiry_Date.sendKeys(exp_date);
				KYC_Type.click();
				Remarks.sendKeys(row.getCell(2).getStringCellValue());
				AddKYCDocumentDetails.click();
				Thread.sleep(2000);
				String MainWindow=driver.getWindowHandle();
				Set<String> s=driver.getWindowHandles();		
				Iterator<String> iterator=s.iterator();			
				while(iterator.hasNext())			
				{		
					String ChildWindow=iterator.next();			
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
				CloseErrorMessage.click();
				Thread.sleep(2000);
				SendForVerify.click();
				Thread.sleep(2000);
				CloseErrorMessage.click();
				Thread.sleep(2000);
				emp_photo.click();
				Thread.sleep(2000);
				logout.click();
			}
		}
	}

	public void authCustomerMaitenance() throws Exception
	{
		Customer_Maintenance.click();
		Thread.sleep(3000);
		Authorize.click();
		Thread.sleep(3000);
		WebElement customer_id=driver.findElement(By.xpath("//select[@id='id_optCustomerNumber']"));
		List<WebElement> dropdown=customer_id.findElements(By.tagName("option"));
		for(int i=0;i<dropdown.size();i++)
		{
			//System.out.println(cust_id);
			if(dropdown.get(i).getText().equals(Corp_cust_id))
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
