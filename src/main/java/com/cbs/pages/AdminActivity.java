package com.cbs.pages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cbs.base.TestBase;
import com.cbs.util.TestUtil;

public class AdminActivity extends TestBase
{
	TestUtil testutil=new TestUtil();
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static Row row;
	String location ="D:\\SidheshP\\Siddhesh Training Document\\Automation_For_CBS\\Excel\\CBS_Automation.xlsx";
	
	@FindBy(xpath="//a[contains(text(),'User Management')]")
	WebElement UserManagement;
	
	@FindBy(xpath="//button[@id='btnNew']")
	WebElement Newbutton;
	
	@FindBy(xpath="//a[contains(text(),'User Creation')]")
	WebElement Usercreation;
	
	@FindBy(xpath="//input[@id='id_txtName']")
	WebElement Name;
	
	@FindBy(xpath="//input[@id='id_txtMobile']")
	WebElement Mobile;
	
	@FindBy(xpath="//input[@id='id_txtEmployeeCode']")
	WebElement EmployeeCode;
	
	@FindBy(xpath="//select[@id='id_designation']")
	WebElement Designation;
	
	@FindBy(xpath="//input[@id='id_txtDob']")
	WebElement DOB;
	
	@FindBy(xpath="//select[@id='id_Branch']")
	WebElement BranchId;
	
	@FindBy(xpath="//select[@id='id_department']")
	WebElement Department;
	
	@FindBy(xpath="//input[@id='id_txtTODAmt']")
	WebElement TODAmt;
	
	@FindBy(xpath="//input[@id='id_txtAgainstClgAmt']")
	WebElement AgainstClgAmt;
	
	@FindBy(xpath="//input[@id='id_txnCCODExcessAmt']")
	WebElement CC_OD_ExcessAmt;
	
	@FindBy(xpath="//button[@id='btnSubmitForm']")
	WebElement Submit;
	
	@FindBy(xpath="//button[@id='btnAuthorize']")
	WebElement Authorizebutton;
	
	@FindBy(xpath="//img[@id='id_emp_photo']")
	WebElement emp_photo;
	
	@FindBy(xpath="//a[@id='id_logout']")
	WebElement logout;
	
	public AdminActivity()
	{
		PageFactory.initElements(driver,this);
	}
	
	public void userCreation() throws Exception
	{
		UserManagement.click();
		Thread.sleep(1000);
		Newbutton.click();
		Thread.sleep(2000);
		Usercreation.click();
		Thread.sleep(3000);
		fis = new FileInputStream(location);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("UserCreation");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(1).getLastCellNum();
		for (int i=1;i<=rowcount;i++)
		{
			row = sheet.getRow(i);
			for(int j=0;j<=colcount;j++)
			{
				XSSFCell cell=(XSSFCell) row.getCell(j);
				Name.sendKeys(row.getCell(0).getStringCellValue());
				long mob = (long) row.getCell(1).getNumericCellValue();
				Mobile.sendKeys(String.valueOf(mob));
				EmployeeCode.sendKeys(row.getCell(2).getStringCellValue());
				//driver.findElement(By.xpath("//span[@id='id_search']")).click();
				Select designation=new Select(Designation);
				designation.selectByVisibleText("CLERK CUM CASHIER");
				DOB.sendKeys("29-Jun-1993");
				Select Branch=new Select(BranchId);
				Branch.selectByVisibleText("HEAD OFFICE");
				Select department=new Select(Department);
				department.selectByVisibleText("department 1");
				int todamt = (int) row.getCell(3).getNumericCellValue();
				TODAmt.sendKeys(String.valueOf(todamt));
				int againstamt = (int) row.getCell(4).getNumericCellValue();
				AgainstClgAmt.sendKeys(String.valueOf(againstamt));
				int CCODExcessAmt = (int) row.getCell(5).getNumericCellValue();
				CC_OD_ExcessAmt.sendKeys(String.valueOf(CCODExcessAmt));
				Submit.click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[@id='id_closeErrorMessage']")).click();
				Thread.sleep(2000);
				break;
			}
		}
		emp_photo.click();
		Thread.sleep(1000);
		logout.click();
	}
	
	public void userAuthorization() throws Exception
	{
		UserManagement.click();
		Thread.sleep(1000);
		Authorizebutton.click();
		Thread.sleep(2000);
		Usercreation.click();
		Thread.sleep(3000);
		WebElement table=driver.findElement(By.xpath("table table-striped table-bordered"));
	    List<WebElement> row= table.findElements(By.tagName("tr"));
	    for(int i=1;i<=row.size();i++)
	    {
	    	List<WebElement> column=table.findElements(By.tagName("td"));
			for(int j=0;j<=column.size();j++)
			{
				driver.findElement(By.xpath("//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[24]/button[1]")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[25]/button[1]")).click();
			}
	    }
	}
}
