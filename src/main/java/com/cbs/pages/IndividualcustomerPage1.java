package com.cbs.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
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
import com.cbs.util.JDBCConnection;
import com.cbs.util.TestUtil;

public class IndividualcustomerPage1 extends TestBase 
{
	Actions action=new Actions(driver);
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static Row row;
	String location = "D:\\Siddhesh Training Document\\Automation_For_CBS\\Excel\\CBS_Automation.xlsx";
	TestUtil util;
	public static String Indv_cust_id;
	public static String Minor_Indv_cust_id;
	public static String Migrated_Indv_cust_id;
	public static String Staff_Indv_cust_id;
	public static String Senior_Citizen_cust_id;
	@FindBy(xpath="//button[@id='btnNewCustomer']")
	WebElement NewCustomerbutton;
	
	//Basic Details
	@FindBy(xpath="//div[@class='bsg-breadcrumb__icon']")
	WebElement Menu;
	
	@FindBy(xpath="//a[contains(text(),'Basic Details')]")
	WebElement Basic_Details;
	
	@FindBy(xpath="//input[@name='txtPan']")
	WebElement Pan_No;
	
	@FindBy(xpath="//input[@id='id_txtAadhaarNo']")
	WebElement Aadhar_No;
	
	@FindBy(xpath="//input[@id='id_txt_confirm_MobileNumber']")
	WebElement Confirm_mobile_no;
	
	@FindBy(xpath="//select[@id='id_branch']")
	WebElement Home_Branch;
	
	@FindBy(xpath="//select[@id='id_subType']")
	WebElement Customer_Category;
	
	@FindBy(xpath="//select[@id='id_txtSalutation']")
	WebElement Salutation;
	
	@FindBy(xpath="//input[@id='id_txtFirstName']")
	WebElement First_name;
	
	@FindBy(xpath="//input[@id='id_txtMiddleName']")
	WebElement Middle_name;
	
	@FindBy(xpath="//input[@id='id_txtLastName']")
	WebElement Last_name;
	
	@FindBy(xpath="//select[@id='id_txtFatherSalutation']")
	WebElement Father_Salutation;
	
	@FindBy(xpath="//input[@id='id_txtFatherFirstName']")
	WebElement Father_First_name;
	
	@FindBy(xpath="//input[@id='id_txtFatherMiddleName']")
	WebElement Father_Middle_name;
	
	@FindBy(xpath="//input[@id='id_txtFatherLastName']")
	WebElement Father_Last_name;
	
	@FindBy(xpath="//select[@id='id_txtMotherSalutation']")
	WebElement Mother_Salutation;
	
	@FindBy(xpath="//input[@id='id_txtMotherFirstName']")
	WebElement Mother_First_name;
	
	@FindBy(xpath="//input[@id='id_txtMotherMiddleName']")
	WebElement Mother_Middle_name;
	
	@FindBy(xpath="//input[@id='id_txtMotherLastName']")
	WebElement Mother_Last_name;
	
	@FindBy(xpath="//input[@id='id_txtdob']")
	WebElement DOB;
	
	@FindBy(xpath="//select[@id='id_gender']")
	WebElement Gender;
	
	@FindBy(xpath="//input[@id='id_isStaff']")
	WebElement Staff;
	
	@FindBy(xpath="//input[@id='id_txtMobileNumber']")
	WebElement Mobile_number;
	
	@FindBy(xpath="//select[@id='id_nriFlag']")
	WebElement NRI;
	
	@FindBy(xpath="//select[@id='id_fatcaMandatory']")
	WebElement Fatca;
	
	@FindBy(xpath="//select[@id='id_default_risk_rating']")
	WebElement Default_Risk_Rating;
	
	@FindBy(xpath="//select[@id='id_customer_profile']")
	WebElement Customer_Profile;
	
	@FindBy(xpath="//select[@id='id_education']")
	WebElement Education;
	
	@FindBy(xpath="//select[@id='id_religion']")
	WebElement Religion;
	
	@FindBy(xpath="//select[@id='id_occupation']")
	WebElement Occupation;
	
	@FindBy(xpath="//text[@id='id_threshold']")
	WebElement Threshold;
	
	@FindBy(xpath="//select[@id='id_maritalStatusSelect']")
	WebElement Marital_Status;
	
	@FindBy(xpath="//select[@id='id_annualIncomeCategorySelect']")
	WebElement Annual_Income_Category;
	
	@FindBy(xpath="//input[@id='id_txtCustomerAddress1']")
	WebElement Address_1;
	
	@FindBy(xpath="//input[@id='id_txtCustomerAddress2']")
	WebElement Address_2;
	
	@FindBy(xpath="//input[@id='id_txtCustomerAddress3']")
	WebElement Address_3;
	
	@FindBy(xpath="//select[@id='id_CustomerStateType']")
	WebElement State;
	
	@FindBy(xpath="//select[@id='id_CustomerCity']")
	WebElement City;
	
	@FindBy(xpath="//select[@id='id_CustomerCountryType']")
	WebElement Country;
	
	@FindBy(xpath="//input[@id='id_txtCustomerPincode']")
	WebElement Pin_Code;
	
	@FindBy(xpath="//input[@id='id_sameAsAbove']")
	WebElement Same_as_Above;
	
	@FindBy(xpath="//button[@id='btnSubmitCustomerInfo']")
	WebElement btnSubmit;
	
	@FindBy(xpath="//div[@id='error_message_master']")
	WebElement Error_message_master;
	
	@FindBy(xpath="//a[@id='id_closeErrorMessage']")
	WebElement CloseErrorMessage;
	
	//Employment Details
	@FindBy(xpath="//span[contains(text(),'Employment Details')]")
	WebElement Employment_Details;
	
	@FindBy(xpath="//input[@id='id_txtFromDate']")
	WebElement FromDate;
	
	@FindBy(xpath="//input[@id='id_txtEmployerCompanyname']")
	WebElement EmployerCompanyname;
	
	@FindBy(xpath="//input[@id='id_txtEmployerAddress1']")
	WebElement EmployerAddress1;
	
	@FindBy(xpath="//input[@id='id_txtEmployerAddress2']")
	WebElement EmployerAddress2;
	
	@FindBy(xpath="//input[@id='id_txtEmployerAddress3']")
	WebElement EmployerAddress3;
	
	@FindBy(xpath="//button[@id='id_SubmitEmployerContactdetail']")
	WebElement btnSubmitEmployerContactdetail;
	
	@FindBy(xpath="//span[contains(text(),'Individual Parent/Spouse Details')]")
	WebElement Indiv_PartSpou_Details;
	
	@FindBy(xpath="//input[@id='id_SpouseParentFirstName']")
	WebElement SpouseParentFirstName;
	
	@FindBy(xpath="//input[@id='id_SpouseParentMiddleName']")
	WebElement SpouseParentMiddleName;
	
	@FindBy(xpath="//input[@id='id_SpouseParentLastName']")
	WebElement SpouseParentLastName;
	
	@FindBy(xpath="//button[@id='id_AddSpouseParentdetail']")
	WebElement btnAddSpouseParent;
	
	@FindBy(xpath="//button[@id='id_SubmitSpouseParentdetail']")
	WebElement SubmitSpouseParent;
	
	@FindBy(xpath="//a[contains(text(),'Individual Credit Details')]")
	WebElement Individual_Credit_Details;
	
	@FindBy(xpath="//span[contains(text(),'Individual Credit Details')]")
	WebElement Individual_Credit_Details1;
	
	@FindBy(xpath="//input[@id='id_txtCreditRatingDate']")
	WebElement Credit_Rating_Date;
	
	@FindBy(xpath="//input[@id='id_txtCreditScore']")
	WebElement Credit_Score;
	
	@FindBy(xpath="//input[@id='id_txtReferenceNumber']")
	WebElement Reference_Number;
	
	@FindBy(xpath="//input[@id='id_creditBankName']")
	WebElement Credit_Bank_Name;
	
	@FindBy(xpath="//button[@id='id_SubmitCreditCardDetail']")
	WebElement SubmitCreditCardDetail;
	
	@FindBy(xpath="//span[contains(text(),'Signature')]")
	WebElement Signature;
	
	@FindBy(xpath="//a[contains(text(),'Signature')]")
	WebElement Signature1;
	
	/*@FindBy(xpath="//input[@id='id_signature_card']")
	WebElement Signature_Card_File;
	
	@FindBy(xpath="//button[@id='id_signature_upload_add']")
	WebElement Signature_upload_add;
	
	@FindBy(xpath="//button[@id='id_signature_upload_submit']")
	WebElement Signature_upload_submit;*/
	
	@FindBy(xpath="//span[contains(text(),'Photo')]")
	WebElement Photo;
	
	//@FindBy(xpath="//*[@id=\"id_customer_photo\"]/a[contains(text(),'Photo')]")
	//WebElement Photo1;
	
	@FindBy(xpath="//a[contains(text(),'Insta Account')]")
	WebElement Insta_Account;
	
	@FindBy(xpath="//select[@id='id_producttype']")
	WebElement Product_Code;
	
	@FindBy(xpath="//img[@id='id_emp_photo']")
	WebElement emp_photo;
	
	@FindBy(xpath="//a[@id='id_logout']")
	WebElement logout;
	
	@FindBy(xpath="//button[@id='btnAuthorize']")
	WebElement btnAuthorize;
	
	@FindBy(xpath="//button[@id='btnVerify']")
	WebElement btnVerify;
	
	@FindBy(xpath="//button[@id='btnVerify']")
	WebElement btnVerify1;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[23]/button/img['View']")
	WebElement View;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[24]/button[@id='btnVerify_0']")
	WebElement Verify;
	
	@FindBy(xpath="//button[@id='btnVerify']")
	WebElement btnVerify2;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[3]/button[contains(text(),'View')]")
	WebElement View1;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[4]/button[contains(text(),'Verify')]")
	WebElement btnVerify3;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[3]/button/img['View']")
	WebElement View2;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[4]/button[@id='btnVerify_0']")
	WebElement btnVerify4;
	
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
	
	@FindBy(xpath="//button[@id='btnSubmitCustomerInfo']")
	WebElement Update;
	
	@FindBy(xpath="//button[@id='btnView']")
	WebElement custView;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[3]/button[@type='button']")
	WebElement sigView;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[3]/button[@type='button']")
	WebElement photoView;
	
	@FindBy(xpath="//button[@id='id_SubmitInstaAccDetails']")
	WebElement Insta_submit;
	
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
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[14]/button[@type='button']")
	WebElement KYC_View;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[15]/button[@id='btnVerify_0']")
	WebElement KYC_Verify;
	
	public IndividualcustomerPage1()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createIndividualCustomer() throws Exception
	{
		NewCustomerbutton.click();
		Thread.sleep(5000);
		fis = new FileInputStream(location);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Indv Cust");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(1).getLastCellNum();
		for (int i=1;i<=rowcount;i++)
		{
			row = sheet.getRow(i);
			for(int j=0;j<colcount;j++)
			{
				XSSFCell cell=(XSSFCell) row.getCell(j);
			/*WebDriverWait block = new WebDriverWait(driver,10);
              block.until(ExpectedConditions.visibilityOfElementLocated(By.className("ute-pay-now-modalContent")));
              driver.switchTo().frame("sema");
              WebElement pan;
              pan = modal.findElement(By.id("pan")); */
				Pan_No.sendKeys(row.getCell(0).getStringCellValue());
				Aadhar_No.sendKeys(row.getCell(1).getStringCellValue());
				//Home_Branch.click();
				//Confirm_mobile_no.sendKeys(mobileNum);
				Thread.sleep(2000);
				Select customer_Category=new Select(Customer_Category);
				customer_Category.selectByIndex(1);
				Select Salutation=new Select(driver.findElement(By.xpath("//select[@id='id_txtSalutation']")));
				Salutation.selectByIndex(5);
				First_name.sendKeys(row.getCell(2).getStringCellValue());
				Middle_name.sendKeys(row.getCell(3).getStringCellValue());
				Last_name.sendKeys(row.getCell(4).getStringCellValue());
				Select Father_Salutation=new Select(driver.findElement(By.xpath("//select[@id='id_txtFatherSalutation']")));
				Father_Salutation.selectByIndex(2);
				Father_First_name.sendKeys(row.getCell(5).getStringCellValue());
				Father_Middle_name.sendKeys(row.getCell(6).getStringCellValue());
				Father_Last_name.sendKeys(row.getCell(7).getStringCellValue());
				Select Mother_Salutation=new Select(driver.findElement(By.xpath("//select[@id='id_txtMotherSalutation']")));
				Mother_Salutation.selectByIndex(1);
				Mother_First_name.sendKeys(row.getCell(8).getStringCellValue());
				Mother_Middle_name.sendKeys(row.getCell(9).getStringCellValue());
				Mother_Last_name.sendKeys(row.getCell(10).getStringCellValue());
				//int dob = (int) row.getCell(11).getNumericCellValue();
				//DOB.sendKeys(String.valueOf(dob));
				DOB.sendKeys("05-Dec-1983");
				//Select NRI=new Select(driver.findElement(By.xpath("//select[@id='id_nriFlag']")));
				//NRI.selectByIndex(1);
				Select Gender=new Select(driver.findElement(By.xpath("//select[@id='id_gender']")));
				Gender.selectByIndex(1);
				//Gender.selectByVisibleText("Male");
				Random rand = new Random();
			    int num1, num2, num3;
			    num1 = rand.nextInt (900) + 100;
			    num2 = rand.nextInt (643) + 100;
			    num3 = rand.nextInt (9000) + 1000;
			    String mob1=num1+""+num2+""+num3;
			    Mobile_number.sendKeys(mob1);
				//long mob = (long) row.getCell(12).getNumericCellValue();
				//Mobile_number.sendKeys(String.valueOf(mob));
			    
				Select Default_Risk_Rating=new Select(driver.findElement(By.xpath("//select[@id='id_default_risk_rating']")));
				Default_Risk_Rating.selectByIndex(1);
				//Default_Risk_Rating.selectByVisibleText("H");
				Select Customer_Profile=new Select(driver.findElement(By.xpath("//select[@id='id_customer_profile']")));
				Customer_Profile.selectByIndex(1);
				//Customer_Profile.selectByVisibleText("SERVICE");
				Select Education=new Select(driver.findElement(By.xpath("//select[@id='id_education']")));
				Education.selectByIndex(1);
				//Education.selectByVisibleText("Graduation");
				Select Religion=new Select(driver.findElement(By.xpath("//select[@id='id_religion']")));
				Religion.selectByIndex(1);
				Thread.sleep(2000);
				Robot robot = new Robot();
		        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
				//Religion.selectByVisibleText("Hindu");
				Thread.sleep(3000);
				Select Occupation=new Select(driver.findElement(By.xpath("//select[@id='id_occupation']")));
				Occupation.selectByIndex(1);
				driver.findElement(By.xpath("//input[@id='id_threshold']")).sendKeys("0");
				//Occupation.selectByVisibleText("SERVICE");
				Select Marital_Status=new Select(driver.findElement(By.xpath("//select[@id='id_maritalStatusSelect']")));
				Marital_Status.selectByIndex(1);
				//Select Fatca=new Select(driver.findElement(By.xpath("//select[@id='id_fatcaMandatory']")));
				//Fatca.selectByIndex(1);
				//Marital_Status.selectByVisibleText("Single");
				Select Annual_Income_Category=new Select(driver.findElement(By.xpath("//select[@id='id_annualIncomeCategorySelect']")));
				Annual_Income_Category.selectByIndex(3);
				//Annual_Income_Category.selectByVisibleText("500000 - 1000000");
				Address_1.sendKeys(row.getCell(13).getStringCellValue());
				Address_2.sendKeys(row.getCell(14).getStringCellValue());
				Address_3.sendKeys(row.getCell(15).getStringCellValue());
				Select City=new Select(driver.findElement(By.xpath("//select[@id='id_CustomerCity']")));
				City.selectByIndex(3);
				//City.selectByVisibleText("MUMBAI");
				Select State=new Select(driver.findElement(By.xpath("//select[@id='id_CustomerStateType']")));
				//State.selectByVisibleText("MAHARASHTRA");
				State.selectByIndex(5);
				long pin_code = (long) row.getCell(16).getNumericCellValue();
				Pin_Code.sendKeys(String.valueOf(pin_code));
				Select Country=new Select(driver.findElement(By.xpath("//select[@id='id_CustomerCountryType']")));
				Country.selectByIndex(1);
				//Country.selectByVisibleText("INDIA");
				Thread.sleep(2000);
				Same_as_Above.click();
				Thread.sleep(2000);
				btnSubmit.click();
				Thread.sleep(3000);
				Indv_cust_id=Error_message_master.getText();
				//System.out.println(Indv_cust_id);
				Indv_cust_id = Indv_cust_id.replace("Success", "");
				Indv_cust_id = Indv_cust_id.replace("Customer ID", "");
				Indv_cust_id = Indv_cust_id.replace("x", "");
				Indv_cust_id = Indv_cust_id.trim();
				System.out.println(Indv_cust_id);
				String Expected=Indv_cust_id;
				row.createCell(31).setCellValue(Indv_cust_id);
				CloseErrorMessage.click();
				Thread.sleep(5000);
				Select Type=new Select(driver.findElement(By.xpath("//select[@id='id_employmentType']")));
				Type.selectByIndex(1);
				Select Tenure=new Select(driver.findElement(By.xpath("//select[@id='id_txtOccupationTenure']")));
				Tenure.selectByIndex(1);
				Select Emp_Occupation=new Select(driver.findElement(By.xpath("//select[@id='id_txtOccupationType']")));
				Emp_Occupation.selectByIndex(1);
				Select Designation=new Select(driver.findElement(By.xpath("//select[@id='id_txtDesignationType']")));
				Designation.selectByIndex(10);
				int fromDate = (int) row.getCell(19).getNumericCellValue();
				FromDate.sendKeys(String.valueOf(fromDate));
				EmployerCompanyname.sendKeys(row.getCell(20).getStringCellValue());
				EmployerAddress1.sendKeys(row.getCell(21).getStringCellValue());
				EmployerAddress2.sendKeys(row.getCell(22).getStringCellValue());
				EmployerAddress3.sendKeys(row.getCell(23).getStringCellValue());
				btnSubmitEmployerContactdetail.click();
				Thread.sleep(2000);
				CloseErrorMessage.click();
				Thread.sleep(3000);
				SpouseParentFirstName.sendKeys(row.getCell(24).getStringCellValue());
				SpouseParentMiddleName.sendKeys(row.getCell(25).getStringCellValue());
				SpouseParentLastName.sendKeys(row.getCell(26).getStringCellValue());
				btnAddSpouseParent.click();
				Thread.sleep(2000);
				SubmitSpouseParent.click();
				Thread.sleep(2000);
				CloseErrorMessage.click();
				Thread.sleep(3000);
				Individual_Credit_Details.click();
				Thread.sleep(3000);
				Select Credit_Agency=new Select(driver.findElement(By.xpath("//select[@id='id_creditRatingAgency']")));
				//Credit_Agency.selectByVisibleText("CIBIL");
				Credit_Agency.selectByIndex(1);
				int creditratingDate=(int) row.getCell(27).getNumericCellValue();
				Credit_Rating_Date.sendKeys(String.valueOf(creditratingDate));
				int creditScore=(int) row.getCell(28).getNumericCellValue();
				Credit_Score.sendKeys(String.valueOf(creditScore));
				int referenceNumber=(int) row.getCell(29).getNumericCellValue();
				Reference_Number.sendKeys(String.valueOf(referenceNumber));
				Select Credit_Rating=new Select(driver.findElement(By.xpath("//select[@id='id_creditRating']")));
				//Credit_Rating.selectByVisibleText("rating 1");
				Credit_Rating.selectByIndex(1);
				Credit_Bank_Name.sendKeys(row.getCell(30).getStringCellValue());
				SubmitCreditCardDetail.click();
				fos=new FileOutputStream(location);
				workbook.write(fos);
				Thread.sleep(2000);
				CloseErrorMessage.click();
				Thread.sleep(3000);
				
				Signature.click();
				Thread.sleep(3000);
				util=new TestUtil();
				util.addsignature();
				Thread.sleep(3000);
				Photo.click();
				Thread.sleep(3000);
				util.addphoto();

				Insta_Account.click();
				Thread.sleep(2000);
				Select product_code=new Select(Product_Code);
				product_code.selectByIndex(1);
				Insta_submit.click();
				Thread.sleep(2000);
				CloseErrorMessage.click();
				Thread.sleep(3000);
				/*action.moveToElement(Menu).click().build().perform();
				driver.findElement(By.xpath("//ul[@id='corporate_back_menu']/li/a[contains(text(),'New')]")).click();
				Thread.sleep(5000);
				Basic_Details.click();
				Thread.sleep(3000);*/
				emp_photo.click();
				Thread.sleep(2000);
				logout.click();
			}
		}
	}
	
	/*public void createindvcustomer(String pan, String aadhar,String firstname,String middlename,String lastname,
			String fatherfirstname,String fathermiddlename,String fatherlastname,String motherfirstname,
			String mothermiddlename,String motherlastname,String dob,String mobileNum,String address1,String address2,
			String address3,String pin,String fromDate,String companyName,String empAddress1,String empAddress2,
			String empAddress3, String spouseParentFirstName,String spouseParentMiddleName,String spouseParentLastName,
			String creditRatingDate,String creditScore,String referenceNumber,String creditBankName)
			throws Exception
	{
		NewCustomerbutton.click();
		Thread.sleep(3000);
		Pan_No.sendKeys(pan);
		Aadhar_No.sendKeys(aadhar);
		Home_Branch.click();
		//Confirm_mobile_no.sendKeys(mobileNum);
		Thread.sleep(2000);
		Select customer_Category=new Select(Customer_Category);
		customer_Category.selectByIndex(1);
		//customer_Category.selectByVisibleText("STAFF MEMBER");
		Select Salutation=new Select(driver.findElement(By.xpath("//select[@id='id_txtSalutation']")));
		Salutation.selectByIndex(5);
		//Salutation.selectByVisibleText("Mr.");
		First_name.sendKeys(firstname);
		Middle_name.sendKeys(middlename);
		Last_name.sendKeys(lastname);
		Select Father_Salutation=new Select(driver.findElement(By.xpath("//select[@id='id_txtFatherSalutation']")));
		Father_Salutation.selectByIndex(2);
		//Father_Salutation.selectByVisibleText("Shri");
		Father_First_name.sendKeys(fatherfirstname);
		Father_Middle_name.sendKeys(fathermiddlename);
		Father_Last_name.sendKeys(fatherlastname);
		Select Mother_Salutation=new Select(driver.findElement(By.xpath("//select[@id='id_txtMotherSalutation']")));
		Mother_Salutation.selectByIndex(1);
		//Mother_Salutation.selectByVisibleText("Shri");
		Mother_First_name.sendKeys(motherfirstname);
		Mother_Middle_name.sendKeys(mothermiddlename);
		Mother_Last_name.sendKeys(motherlastname);
		DOB.sendKeys(dob);
		Select Gender=new Select(driver.findElement(By.xpath("//select[@id='id_gender']")));
		Gender.selectByIndex(1);
		//Gender.selectByVisibleText("Male");
		Mobile_number.sendKeys(mobileNum);
		Select Default_Risk_Rating=new Select(driver.findElement(By.xpath("//select[@id='id_default_risk_rating']")));
		Default_Risk_Rating.selectByIndex(1);
		//Default_Risk_Rating.selectByVisibleText("H");
		Select Customer_Profile=new Select(driver.findElement(By.xpath("//select[@id='id_customer_profile']")));
		Customer_Profile.selectByIndex(1);
		//Customer_Profile.selectByVisibleText("SERVICE");
		Select Education=new Select(driver.findElement(By.xpath("//select[@id='id_education']")));
		Education.selectByIndex(1);
		//Education.selectByVisibleText("Graduation");
		Select Religion=new Select(driver.findElement(By.xpath("//select[@id='id_religion']")));
		Religion.selectByIndex(1);
		//Religion.selectByVisibleText("Hindu");
		Select Occupation=new Select(driver.findElement(By.xpath("//select[@id='id_occupation']")));
		Occupation.selectByIndex(1);
		//Occupation.selectByVisibleText("SERVICE");
		Select Marital_Status=new Select(driver.findElement(By.xpath("//select[@id='id_maritalStatusSelect']")));
		Marital_Status.selectByIndex(1);
		//Marital_Status.selectByVisibleText("Single");
		Select Annual_Income_Category=new Select(driver.findElement(By.xpath("//select[@id='id_annualIncomeCategorySelect']")));
		Annual_Income_Category.selectByIndex(3);
		//Annual_Income_Category.selectByVisibleText("500000 - 1000000");
		Address_1.sendKeys(address1);
		Address_2.sendKeys(address2);
		Address_3.sendKeys(address3);
		Select City=new Select(driver.findElement(By.xpath("//select[@id='id_CustomerCity']")));
		City.selectByIndex(164);
		//City.selectByVisibleText("MUMBAI");
		Select State=new Select(driver.findElement(By.xpath("//select[@id='id_CustomerStateType']")));
		//State.selectByVisibleText("MAHARASHTRA");
		State.selectByIndex(19);
		Pin_Code.sendKeys(pin);
		Select Country=new Select(driver.findElement(By.xpath("//select[@id='id_CustomerCountryType']")));
		Country.selectByIndex(1);
		//Country.selectByVisibleText("INDIA");
		Thread.sleep(2000);
		Same_as_Above.click();
		Thread.sleep(2000);
		btnSubmit.click();
		Thread.sleep(3000);
		Indv_cust_id=Error_message_master.getText();
		Indv_cust_id = Indv_cust_id.replace("Customer ID", "");
		Indv_cust_id = Indv_cust_id.replace("x", "");
		Indv_cust_id = Indv_cust_id.trim();
		System.out.println(Indv_cust_id);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		//Employment_Details.click();
		//Thread.sleep(5000);
		Select Type=new Select(driver.findElement(By.xpath("//select[@id='id_employmentType']")));
		Type.selectByIndex(1);
		//Type.selectByVisibleText("Current");
		Select Tenure=new Select(driver.findElement(By.xpath("//select[@id='id_txtOccupationTenure']")));
		Tenure.selectByIndex(1);
		//Tenure.selectByVisibleText("less than 1 Year");
		Select Emp_Occupation=new Select(driver.findElement(By.xpath("//select[@id='id_txtOccupationType']")));
		Emp_Occupation.selectByIndex(1);
		//Emp_Occupation.selectByValue("3");
		Select Designation=new Select(driver.findElement(By.xpath("//select[@id='id_txtDesignationType']")));
		Designation.selectByIndex(10);
		//Designation.selectByVisibleText("Chairman");
		FromDate.sendKeys(fromDate);
		EmployerCompanyname.sendKeys(companyName);
		EmployerAddress1.sendKeys(empAddress1);
		EmployerAddress2.sendKeys(empAddress2);
		EmployerAddress3.sendKeys(empAddress3);
		btnSubmitEmployerContactdetail.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		SpouseParentFirstName.sendKeys(spouseParentFirstName);
		SpouseParentMiddleName.sendKeys(spouseParentMiddleName);
		SpouseParentLastName.sendKeys(spouseParentLastName);
		btnAddSpouseParent.click();
		Thread.sleep(2000);
		SubmitSpouseParent.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		Individual_Credit_Details.click();
		Thread.sleep(3000);
		Select Credit_Agency=new Select(driver.findElement(By.xpath("//select[@id='id_creditRatingAgency']")));
		//Credit_Agency.selectByVisibleText("CIBIL");
		Credit_Agency.selectByIndex(1);
		Credit_Rating_Date.sendKeys(creditRatingDate);
		Credit_Score.sendKeys(creditScore);
		Reference_Number.sendKeys(referenceNumber);
		Select Credit_Rating=new Select(driver.findElement(By.xpath("//select[@id='id_creditRating']")));
		//Credit_Rating.selectByVisibleText("rating 1");
		Credit_Rating.selectByIndex(1);
		Credit_Bank_Name.sendKeys(creditBankName);
		SubmitCreditCardDetail.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		Signature.click();
		Thread.sleep(3000);
		util=new TestUtil();
		util.addsignature();
		Thread.sleep(3000);
		Photo.click();
		Thread.sleep(3000);
		util.addphoto();
		Insta_Account.click();
		Thread.sleep(2000);
		Select product_code=new Select(Product_Code);
		product_code.selectByIndex(1);
		Insta_submit.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}*/
	
	public void authorizedCustomer() throws Exception
	{
		btnAuthorize.click();
		Thread.sleep(5000);
		WebElement customer_id=driver.findElement(By.xpath("//select[@id='id_optCustomerNumber']"));
		List<WebElement> dropdown=customer_id.findElements(By.tagName("option"));
		for(int i=0;i<dropdown.size();i++)
		{
			//System.out.println(dropdown.get(i).getText());
			if(dropdown.get(i).getText().equals(Indv_cust_id))
			{
				dropdown.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		btnVerify.click();
		Thread.sleep(3000);
		CloseErrorMessage.click();
		Thread.sleep(5000);
		Employment_Details.click();
		Thread.sleep(3000);
		btnVerify1.click();
		Thread.sleep(5000);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		Indiv_PartSpou_Details.click();
		Thread.sleep(3000);
		View.click();
		Thread.sleep(2000);
		Verify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(5000);
		Individual_Credit_Details1.click();
		Thread.sleep(3000);
		btnVerify2.click();
		Thread.sleep(3000);
		CloseErrorMessage.click();
		Thread.sleep(4000);
		Signature.click();
		Thread.sleep(3000);
		View1.click();
		Thread.sleep(2000);
		btnVerify3.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Photo.click();
		Thread.sleep(3000);
		View2.click();
		Thread.sleep(2000);
		btnVerify4.click();
		Thread.sleep(3000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Insta_Account.click();
		Thread.sleep(2000);
		btnVerify2.click();
		Thread.sleep(2000);
		//String Actual="";
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
	}
	
	public void editIndvCustomer(String phone_num,String email) throws Exception
	{
		Edit.click();
		Thread.sleep(5000);
		customer_id.sendKeys(Indv_cust_id);
		Search.click();
		Thread.sleep(3000);
		Phone_Residence.sendKeys(phone_num);
		Email_id.sendKeys(email);
		Update.click();
		Thread.sleep(3000);
		CloseErrorMessage.click();
		Thread.sleep(3000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}
	
	public void editAuthIndv() throws Exception
	{
		btnAuthorize.click();
		Thread.sleep(3000);
		WebElement customer_id=driver.findElement(By.xpath("//select[@id='id_optCustomerNumber']"));
		List<WebElement> dropdown=customer_id.findElements(By.tagName("option"));
		for(int i=0;i<dropdown.size();i++)
		{
			//System.out.println(dropdown.get(i).getText());
			if(dropdown.get(i).getText().equals(Indv_cust_id))
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
	public void viewIndvCustomer() throws Exception
	{
		custView.click();
		Thread.sleep(3000);
		customer_id.sendKeys(Indv_cust_id);
		Search.click();
		Thread.sleep(3000);
		/*Employment_Details.click();
		Thread.sleep(2000);
		Indiv_PartSpou_Details.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[23]/button[@type='button']")).click();
		Thread.sleep(2000);
		Individual_Credit_Details1.click();
		Thread.sleep(2000);
		Signature.click();
		Thread.sleep(2000);
		sigView.click();
		Thread.sleep(2000);
		Photo.click();
		Thread.sleep(2000);
		photoView.click();
		Thread.sleep(2000);
		Insta_Account.click();
		Thread.sleep(2000);*/
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(2000);
	}
	
	public void customer_kyc_Details() throws Exception
	{
		Customer_Maintenance.click();
		Thread.sleep(3000);
		btnNewCustomer.click();
		Thread.sleep(3000);
		fis = new FileInputStream(location);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("IndvCustKYC");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(1).getLastCellNum();
		for (int i=1;i<=rowcount;i++)
		{
			row = sheet.getRow(i);
			for(int j=0;j<colcount;j++)
			{
				XSSFCell cell=(XSSFCell) row.getCell(j);
				//Long cust_id=(long) row.getCell(0).getNumericCellValue();
				CustomerNumber.sendKeys(Indv_cust_id);
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
				//int doe = (int) row.getCell(1).getNumericCellValue();
				//Document_Expiry_Date.sendKeys(String.valueOf(doe));
				Document_Expiry_Date.sendKeys("15-Dec-2025");
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
		
		/*this.cust_id=Error_message_master.getText();
		//System.out.println(cust_id);
		this.cust_id = this.cust_id.replace("Successfully added Document details 1 for", "");
		this.cust_id = this.cust_id.replace("x", "");
		this.cust_id = this.cust_id.trim();
		System.out.println(this.cust_id);*/
		
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
			if(dropdown.get(i).getText().equals(Indv_cust_id))
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
	}
	
	public void editMigratedCustomer(String phone_residence,String email) throws Exception
	{
		Edit.click();
		Thread.sleep(5000);
		Migrated_Indv_cust_id =JDBCConnection.getMigratedIndividualCustomer();
		System.out.println("migrated_Indv_cust_id"+ Migrated_Indv_cust_id);
		customer_id.sendKeys(Migrated_Indv_cust_id);
		Search.click();
		Thread.sleep(2000);
		for(int i=1;i<=10;i++)
		{
			Phone_Residence.sendKeys(Keys.BACK_SPACE);
		}
		Phone_Residence.sendKeys(phone_residence);
		Thread.sleep(1000);
		for(int i=1;i<=30;i++)
		{
			Email_id.sendKeys(Keys.BACK_SPACE);
		}
		Email_id.sendKeys(email);
		Update.click();
		Thread.sleep(3000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}
	
	public void editAuthMigratedCustomer() throws Exception
	{
		btnAuthorize.click();
		Thread.sleep(5000);
		WebElement customer_id=driver.findElement(By.xpath("//select[@id='id_optCustomerNumber']"));
		List<WebElement> dropdown=customer_id.findElements(By.tagName("option"));
		for(int i=0;i<dropdown.size();i++)
		{
			//System.out.println(dropdown.get(i).getText());
			if(dropdown.get(i).getText().equals(Migrated_Indv_cust_id))
			{
				dropdown.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		btnVerify.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}
	
	public void viewMigratedCustomer() throws Exception
	{
		custView.click();
		Thread.sleep(5000);
		customer_id.sendKeys(Migrated_Indv_cust_id);
		Search.click();
		Thread.sleep(5000);
		Employment_Details.click();
		Thread.sleep(3000);
		/*Indiv_PartSpou_Details.click();
		Thread.sleep(3000);
		Individual_Credit_Details1.click();
		Thread.sleep(3000);
		Signature.click();
		Thread.sleep(3000);
		sigView.click();
		Thread.sleep(2000);
		Photo.click();
		Thread.sleep(3000);
		photoView.click();*/
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		//Thread.sleep(5000);
	}
	
	public void createMinorIndvCust() throws Exception
	{
			NewCustomerbutton.click();
			Thread.sleep(5000);
			fis = new FileInputStream(location);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet("Indv Cust");
			int rowcount = sheet.getLastRowNum();
			int colcount = sheet.getRow(1).getLastCellNum();
			for (int i=2;i<=rowcount;i++)
			{
				row = sheet.getRow(i);
				for(int j=0;j<colcount;j++)
				{
					XSSFCell cell=(XSSFCell) row.getCell(j);
					Pan_No.sendKeys(row.getCell(0).getStringCellValue());
					Aadhar_No.sendKeys(row.getCell(1).getStringCellValue());
					//Home_Branch.click();
					//Confirm_mobile_no.sendKeys(mobileNum);
					Thread.sleep(2000);
					Select customer_Category=new Select(Customer_Category);
					customer_Category.selectByIndex(1);
					Select Salutation=new Select(driver.findElement(By.xpath("//select[@id='id_txtSalutation']")));
					Salutation.selectByIndex(5);
					First_name.sendKeys(row.getCell(2).getStringCellValue());
					Middle_name.sendKeys(row.getCell(3).getStringCellValue());
					Last_name.sendKeys(row.getCell(4).getStringCellValue());
					Select Father_Salutation=new Select(driver.findElement(By.xpath("//select[@id='id_txtFatherSalutation']")));
					Father_Salutation.selectByIndex(2);
					Father_First_name.sendKeys(row.getCell(5).getStringCellValue());
					Father_Middle_name.sendKeys(row.getCell(6).getStringCellValue());
					Father_Last_name.sendKeys(row.getCell(7).getStringCellValue());
					Select Mother_Salutation=new Select(driver.findElement(By.xpath("//select[@id='id_txtMotherSalutation']")));
					Mother_Salutation.selectByIndex(1);
					Mother_First_name.sendKeys(row.getCell(8).getStringCellValue());
					Mother_Middle_name.sendKeys(row.getCell(9).getStringCellValue());
					Mother_Last_name.sendKeys(row.getCell(10).getStringCellValue());
					int dob = (int) row.getCell(11).getNumericCellValue();
					DOB.sendKeys(String.valueOf(dob));
					//Select NRI=new Select(driver.findElement(By.xpath("//select[@id='id_nriFlag']")));
					//NRI.selectByIndex(1);
					Select Gender=new Select(driver.findElement(By.xpath("//select[@id='id_gender']")));
					Gender.selectByIndex(1);
					//Gender.selectByVisibleText("Male");
					long mob = (long) row.getCell(12).getNumericCellValue();
					Mobile_number.sendKeys(String.valueOf(mob));
					Select Default_Risk_Rating=new Select(driver.findElement(By.xpath("//select[@id='id_default_risk_rating']")));
					Default_Risk_Rating.selectByIndex(1);
					//Default_Risk_Rating.selectByVisibleText("H");
					Select Customer_Profile=new Select(driver.findElement(By.xpath("//select[@id='id_customer_profile']")));
					Customer_Profile.selectByIndex(1);
					//Customer_Profile.selectByVisibleText("SERVICE");
					Select Education=new Select(driver.findElement(By.xpath("//select[@id='id_education']")));
					Education.selectByIndex(1);
					//Education.selectByVisibleText("Graduation");
					Select Religion=new Select(driver.findElement(By.xpath("//select[@id='id_religion']")));
					Religion.selectByIndex(1);
					//Thread.sleep(2000);
					Robot robot = new Robot();
			        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
					Thread.sleep(1000);
					Select Occupation=new Select(driver.findElement(By.xpath("//select[@id='id_occupation']")));
					Occupation.selectByIndex(1);
					driver.findElement(By.xpath("//input[@id='id_threshold']")).sendKeys("0");
					//Occupation.selectByVisibleText("SERVICE");
					Select Marital_Status=new Select(driver.findElement(By.xpath("//select[@id='id_maritalStatusSelect']")));
					Marital_Status.selectByIndex(1);
					//Select Fatca=new Select(driver.findElement(By.xpath("//select[@id='id_fatcaMandatory']")));
					//Fatca.selectByIndex(1);
					//Marital_Status.selectByVisibleText("Single");
					Select Annual_Income_Category=new Select(driver.findElement(By.xpath("//select[@id='id_annualIncomeCategorySelect']")));
					Annual_Income_Category.selectByIndex(3);
					//Annual_Income_Category.selectByVisibleText("500000 - 1000000");
					Address_1.sendKeys(row.getCell(13).getStringCellValue());
					Address_2.sendKeys(row.getCell(14).getStringCellValue());
					Address_3.sendKeys(row.getCell(15).getStringCellValue());
					Select City=new Select(driver.findElement(By.xpath("//select[@id='id_CustomerCity']")));
					City.selectByIndex(3);
					//City.selectByVisibleText("MUMBAI");
					Select State=new Select(driver.findElement(By.xpath("//select[@id='id_CustomerStateType']")));
					//State.selectByVisibleText("MAHARASHTRA");
					State.selectByIndex(5);
					long pin_code = (long) row.getCell(16).getNumericCellValue();
					Pin_Code.sendKeys(String.valueOf(pin_code));
					Select Country=new Select(driver.findElement(By.xpath("//select[@id='id_CustomerCountryType']")));
					Country.selectByIndex(1);
					//Country.selectByVisibleText("INDIA");
					Thread.sleep(2000);
					Same_as_Above.click();
					Thread.sleep(2000);
					btnSubmit.click();
					Thread.sleep(3000);
					Minor_Indv_cust_id=Error_message_master.getText();
					//System.out.println(Indv_cust_id);
					Minor_Indv_cust_id = Minor_Indv_cust_id.replace("Success", "");
					Minor_Indv_cust_id = Minor_Indv_cust_id.replace("Customer ID", "");
					Minor_Indv_cust_id = Minor_Indv_cust_id.replace("x", "");
					Minor_Indv_cust_id = Minor_Indv_cust_id.trim();
					System.out.println(Minor_Indv_cust_id);
					//String Expected=Indv_cust_id;
					//row.createCell(31).setCellValue(Minor_Indv_cust_id);
					CloseErrorMessage.click();
					Thread.sleep(3000);
					Signature1.click();
					Thread.sleep(1000);
					util=new TestUtil();
					util.addsignature();
					Thread.sleep(3000);
					Photo.click();
					Thread.sleep(2000);
					util.addphoto();
					emp_photo.click();
					Thread.sleep(2000);
					logout.click();
					Thread.sleep(3000);
				}
			}
		}
	
	public void authorizedminorCustomer() throws Exception
	{
		btnAuthorize.click();
		Thread.sleep(3000);
		WebElement customer_id=driver.findElement(By.xpath("//select[@id='id_optCustomerNumber']"));
		List<WebElement> dropdown=customer_id.findElements(By.tagName("option"));
		for(int i=0;i<dropdown.size();i++)
		{
			//System.out.println(dropdown.get(i).getText());
			if(dropdown.get(i).getText().equals(Minor_Indv_cust_id))
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
		Signature.click();
		Thread.sleep(1000);
		View1.click();
		Thread.sleep(2000);
		btnVerify3.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Photo.click();
		Thread.sleep(2000);
		View2.click();
		Thread.sleep(2000);
		btnVerify4.click();
		Thread.sleep(3000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}
	
	public void createStaffIndvCust() throws Exception
	{
			NewCustomerbutton.click();
			Thread.sleep(3000);
			fis = new FileInputStream(location);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet("Indv Cust");
			int rowcount = sheet.getLastRowNum();
			int colcount = sheet.getRow(1).getLastCellNum();
			for (int i=3;i<=rowcount;i++)
			{
				row = sheet.getRow(i);
				for(int j=0;j<colcount;j++)
				{
					XSSFCell cell=(XSSFCell) row.getCell(j);
					Pan_No.sendKeys(row.getCell(0).getStringCellValue());
					Aadhar_No.sendKeys(row.getCell(1).getStringCellValue());
					//Home_Branch.click();
					//Confirm_mobile_no.sendKeys(mobileNum);
					Thread.sleep(2000);
					Select customer_Category=new Select(Customer_Category);
					customer_Category.selectByIndex(1);
					Select Salutation=new Select(driver.findElement(By.xpath("//select[@id='id_txtSalutation']")));
					Salutation.selectByIndex(5);
					First_name.sendKeys(row.getCell(2).getStringCellValue());
					Middle_name.sendKeys(row.getCell(3).getStringCellValue());
					Last_name.sendKeys(row.getCell(4).getStringCellValue());
					Select Father_Salutation=new Select(driver.findElement(By.xpath("//select[@id='id_txtFatherSalutation']")));
					Father_Salutation.selectByIndex(2);
					Father_First_name.sendKeys(row.getCell(5).getStringCellValue());
					Father_Middle_name.sendKeys(row.getCell(6).getStringCellValue());
					Father_Last_name.sendKeys(row.getCell(7).getStringCellValue());
					Select Mother_Salutation=new Select(driver.findElement(By.xpath("//select[@id='id_txtMotherSalutation']")));
					Mother_Salutation.selectByIndex(1);
					Mother_First_name.sendKeys(row.getCell(8).getStringCellValue());
					Mother_Middle_name.sendKeys(row.getCell(9).getStringCellValue());
					Mother_Last_name.sendKeys(row.getCell(10).getStringCellValue());
					int dob = (int) row.getCell(11).getNumericCellValue();
					DOB.sendKeys(String.valueOf(dob));
					Thread.sleep(1000);
					//Select NRI=new Select(driver.findElement(By.xpath("//select[@id='id_nriFlag']")));
					//NRI.selectByIndex(1);
					Select Gender=new Select(driver.findElement(By.xpath("//select[@id='id_gender']")));
					Gender.selectByIndex(1);
					Thread.sleep(2000);
					Staff.click();
					Thread.sleep(2000);
					long mob = (long) row.getCell(12).getNumericCellValue();
					Mobile_number.sendKeys(String.valueOf(mob));
					Select Default_Risk_Rating=new Select(driver.findElement(By.xpath("//select[@id='id_default_risk_rating']")));
					Default_Risk_Rating.selectByIndex(1);
					//Default_Risk_Rating.selectByVisibleText("H");
					Select Customer_Profile=new Select(driver.findElement(By.xpath("//select[@id='id_customer_profile']")));
					Customer_Profile.selectByIndex(1);
					//Customer_Profile.selectByVisibleText("SERVICE");
					Select Education=new Select(driver.findElement(By.xpath("//select[@id='id_education']")));
					Education.selectByIndex(1);
					//Education.selectByVisibleText("Graduation");
					Select Religion=new Select(driver.findElement(By.xpath("//select[@id='id_religion']")));
					Religion.selectByIndex(1);
					//Thread.sleep(2000);
					Robot robot = new Robot();
			        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
					Thread.sleep(1000);
					Select Occupation=new Select(driver.findElement(By.xpath("//select[@id='id_occupation']")));
					Occupation.selectByIndex(1);
					driver.findElement(By.xpath("//input[@id='id_threshold']")).sendKeys("0");
					//Occupation.selectByVisibleText("SERVICE");
					Select Marital_Status=new Select(driver.findElement(By.xpath("//select[@id='id_maritalStatusSelect']")));
					Marital_Status.selectByIndex(1);
					//Select Fatca=new Select(driver.findElement(By.xpath("//select[@id='id_fatcaMandatory']")));
					//Fatca.selectByIndex(1);
					//Marital_Status.selectByVisibleText("Single");
					Select Annual_Income_Category=new Select(driver.findElement(By.xpath("//select[@id='id_annualIncomeCategorySelect']")));
					Annual_Income_Category.selectByIndex(3);
					//Annual_Income_Category.selectByVisibleText("500000 - 1000000");
					Address_1.sendKeys(row.getCell(13).getStringCellValue());
					Address_2.sendKeys(row.getCell(14).getStringCellValue());
					Address_3.sendKeys(row.getCell(15).getStringCellValue());
					Select City=new Select(driver.findElement(By.xpath("//select[@id='id_CustomerCity']")));
					City.selectByIndex(3);
					//City.selectByVisibleText("MUMBAI");
					Select State=new Select(driver.findElement(By.xpath("//select[@id='id_CustomerStateType']")));
					//State.selectByVisibleText("MAHARASHTRA");
					State.selectByIndex(5);
					long pin_code = (long) row.getCell(16).getNumericCellValue();
					Pin_Code.sendKeys(String.valueOf(pin_code));
					Select Country=new Select(driver.findElement(By.xpath("//select[@id='id_CustomerCountryType']")));
					Country.selectByIndex(1);
					//Country.selectByVisibleText("INDIA");
					Thread.sleep(2000);
					Same_as_Above.click();
					Thread.sleep(2000);
					btnSubmit.click();
					Thread.sleep(3000);
					Staff_Indv_cust_id=Error_message_master.getText();
					//System.out.println(Indv_cust_id);
					Staff_Indv_cust_id = Staff_Indv_cust_id.replace("Success", "");
					Staff_Indv_cust_id = Staff_Indv_cust_id.replace("Customer ID", "");
					Staff_Indv_cust_id = Staff_Indv_cust_id.replace("x", "");
					Staff_Indv_cust_id = Staff_Indv_cust_id.trim();
					System.out.println(Staff_Indv_cust_id);
					//String Expected=Indv_cust_id;
					//row.createCell(31).setCellValue(Minor_Indv_cust_id);
					CloseErrorMessage.click();
					Thread.sleep(3000);
					Signature1.click();
					Thread.sleep(1000);
					util=new TestUtil();
					util.addsignature();
					Thread.sleep(3000);
					Photo.click();
					Thread.sleep(2000);
					util.addphoto();
					emp_photo.click();
					Thread.sleep(2000);
					logout.click();
					Thread.sleep(3000);
				}
			}
		}
	
	public void authorizedStaffCustomer() throws Exception
	{
		btnAuthorize.click();
		Thread.sleep(3000);
		WebElement customer_id=driver.findElement(By.xpath("//select[@id='id_optCustomerNumber']"));
		List<WebElement> dropdown=customer_id.findElements(By.tagName("option"));
		for(int i=0;i<dropdown.size();i++)
		{
			//System.out.println(dropdown.get(i).getText());
			if(dropdown.get(i).getText().equals(Staff_Indv_cust_id))
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
		Signature.click();
		Thread.sleep(1000);
		View1.click();
		Thread.sleep(2000);
		btnVerify3.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Photo.click();
		Thread.sleep(2000);
		View2.click();
		Thread.sleep(2000);
		btnVerify4.click();
		Thread.sleep(3000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}
	
	public void createSrcitizenCust() throws Exception
	{
			NewCustomerbutton.click();
			Thread.sleep(3000);
			fis = new FileInputStream(location);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet("Indv Cust");
			int rowcount = sheet.getLastRowNum();
			int colcount = sheet.getRow(1).getLastCellNum();
			for (int i=4;i<=rowcount;i++)
			{
				row = sheet.getRow(i);
				for(int j=0;j<colcount;j++)
				{
					XSSFCell cell=(XSSFCell) row.getCell(j);
					Pan_No.sendKeys(row.getCell(0).getStringCellValue());
					Aadhar_No.sendKeys(row.getCell(1).getStringCellValue());
					//Home_Branch.click();
					//Confirm_mobile_no.sendKeys(mobileNum);
					Thread.sleep(2000);
					Select customer_Category=new Select(Customer_Category);
					customer_Category.selectByIndex(1);
					Select Salutation=new Select(driver.findElement(By.xpath("//select[@id='id_txtSalutation']")));
					Salutation.selectByIndex(5);
					First_name.sendKeys(row.getCell(2).getStringCellValue());
					Middle_name.sendKeys(row.getCell(3).getStringCellValue());
					Last_name.sendKeys(row.getCell(4).getStringCellValue());
					Select Father_Salutation=new Select(driver.findElement(By.xpath("//select[@id='id_txtFatherSalutation']")));
					Father_Salutation.selectByIndex(2);
					Father_First_name.sendKeys(row.getCell(5).getStringCellValue());
					Father_Middle_name.sendKeys(row.getCell(6).getStringCellValue());
					Father_Last_name.sendKeys(row.getCell(7).getStringCellValue());
					Select Mother_Salutation=new Select(driver.findElement(By.xpath("//select[@id='id_txtMotherSalutation']")));
					Mother_Salutation.selectByIndex(1);
					Mother_First_name.sendKeys(row.getCell(8).getStringCellValue());
					Mother_Middle_name.sendKeys(row.getCell(9).getStringCellValue());
					Mother_Last_name.sendKeys(row.getCell(10).getStringCellValue());
					int dob = (int) row.getCell(11).getNumericCellValue();
					DOB.sendKeys(String.valueOf(dob));
					//Select NRI=new Select(driver.findElement(By.xpath("//select[@id='id_nriFlag']")));
					//NRI.selectByIndex(1);
					Select Gender=new Select(driver.findElement(By.xpath("//select[@id='id_gender']")));
					Gender.selectByIndex(1);
					Thread.sleep(2000);
					Staff.click();
					Thread.sleep(2000);
					long mob = (long) row.getCell(12).getNumericCellValue();
					Mobile_number.sendKeys(String.valueOf(mob));
					Select Default_Risk_Rating=new Select(driver.findElement(By.xpath("//select[@id='id_default_risk_rating']")));
					Default_Risk_Rating.selectByIndex(1);
					//Default_Risk_Rating.selectByVisibleText("H");
					Select Customer_Profile=new Select(driver.findElement(By.xpath("//select[@id='id_customer_profile']")));
					Customer_Profile.selectByIndex(1);
					//Customer_Profile.selectByVisibleText("SERVICE");
					Select Education=new Select(driver.findElement(By.xpath("//select[@id='id_education']")));
					Education.selectByIndex(1);
					//Education.selectByVisibleText("Graduation");
					Select Religion=new Select(driver.findElement(By.xpath("//select[@id='id_religion']")));
					Religion.selectByIndex(1);
					//Thread.sleep(2000);
					Robot robot = new Robot();
			        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
					Thread.sleep(1000);
					Select Occupation=new Select(driver.findElement(By.xpath("//select[@id='id_occupation']")));
					Occupation.selectByIndex(1);
					driver.findElement(By.xpath("//input[@id='id_threshold']")).sendKeys("0");
					//Occupation.selectByVisibleText("SERVICE");
					Select Marital_Status=new Select(driver.findElement(By.xpath("//select[@id='id_maritalStatusSelect']")));
					Marital_Status.selectByIndex(1);
					//Select Fatca=new Select(driver.findElement(By.xpath("//select[@id='id_fatcaMandatory']")));
					//Fatca.selectByIndex(1);
					//Marital_Status.selectByVisibleText("Single");
					Select Annual_Income_Category=new Select(driver.findElement(By.xpath("//select[@id='id_annualIncomeCategorySelect']")));
					Annual_Income_Category.selectByIndex(3);
					//Annual_Income_Category.selectByVisibleText("500000 - 1000000");
					Address_1.sendKeys(row.getCell(13).getStringCellValue());
					Address_2.sendKeys(row.getCell(14).getStringCellValue());
					Address_3.sendKeys(row.getCell(15).getStringCellValue());
					Select City=new Select(driver.findElement(By.xpath("//select[@id='id_CustomerCity']")));
					City.selectByIndex(3);
					//City.selectByVisibleText("MUMBAI");
					Select State=new Select(driver.findElement(By.xpath("//select[@id='id_CustomerStateType']")));
					//State.selectByVisibleText("MAHARASHTRA");
					State.selectByIndex(5);
					long pin_code = (long) row.getCell(16).getNumericCellValue();
					Pin_Code.sendKeys(String.valueOf(pin_code));
					Select Country=new Select(driver.findElement(By.xpath("//select[@id='id_CustomerCountryType']")));
					Country.selectByIndex(1);
					//Country.selectByVisibleText("INDIA");
					Thread.sleep(2000);
					Same_as_Above.click();
					Thread.sleep(2000);
					btnSubmit.click();
					Thread.sleep(3000);
					Senior_Citizen_cust_id=Error_message_master.getText();
					//System.out.println(Indv_cust_id);
					Senior_Citizen_cust_id = Senior_Citizen_cust_id.replace("Success", "");
					Senior_Citizen_cust_id = Senior_Citizen_cust_id.replace("Customer ID", "");
					Senior_Citizen_cust_id = Senior_Citizen_cust_id.replace("x", "");
					Senior_Citizen_cust_id = Senior_Citizen_cust_id.trim();
					System.out.println(Senior_Citizen_cust_id);
					//String Expected=Indv_cust_id;
					//row.createCell(31).setCellValue(Minor_Indv_cust_id);
					CloseErrorMessage.click();
					Thread.sleep(3000);
					Signature1.click();
					Thread.sleep(1000);
					util=new TestUtil();
					util.addsignature();
					Thread.sleep(3000);
					Photo.click();
					Thread.sleep(2000);
					util.addphoto();
					emp_photo.click();
					Thread.sleep(2000);
					logout.click();
					Thread.sleep(3000);
				}
			}
		}
	
	public void authorizedSrcitizenCust() throws Exception
	{
		btnAuthorize.click();
		Thread.sleep(3000);
		WebElement customer_id=driver.findElement(By.xpath("//select[@id='id_optCustomerNumber']"));
		List<WebElement> dropdown=customer_id.findElements(By.tagName("option"));
		for(int i=0;i<dropdown.size();i++)
		{
			//System.out.println(dropdown.get(i).getText());
			if(dropdown.get(i).getText().equals(Senior_Citizen_cust_id))
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
		Signature.click();
		Thread.sleep(1000);
		View1.click();
		Thread.sleep(2000);
		btnVerify3.click();
		Thread.sleep(2000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		Photo.click();
		Thread.sleep(2000);
		View2.click();
		Thread.sleep(2000);
		btnVerify4.click();
		Thread.sleep(3000);
		CloseErrorMessage.click();
		Thread.sleep(2000);
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}
}
	
