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

public class TransferPage extends TestBase
{
	TestUtil testutil = new TestUtil();
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static Row row;
	String location = "D:\\SidheshP\\Siddhesh Training Document\\Automation_For_CBS\\Excel\\CBS_Automation.xlsx";
	
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

	@FindBy(xpath = "//input[@id='id_txtInstrumentNumber']")
	WebElement InstrumentNumber;

	@FindBy(xpath="//input[@id='id_txtAmount']")
	WebElement TransferAmount;
	
	@FindBy(xpath="//button[@id='btnAddTransfer']")
	WebElement AddTransfer;
	
	@FindBy(xpath="//button[@id='btnSubmitTransfer']")
	WebElement Submit;
	
	@FindBy(xpath="//a[@id='id_closeModal']")
	WebElement close;
	
	@FindBy(xpath = "//img[@id='id_emp_photo']")
	WebElement emp_photo;

	@FindBy(xpath = "//a[@id='id_logout']")
	WebElement logout;
	
	@FindBy(xpath = "//li[@id='id_authorization_transfer']/a[contains(text(),'Authorization')]")
	WebElement Authorization;
	
	@FindBy(xpath="//button[@id='id_authorizeBtn']")
	WebElement Auth_button;
	
	public TransferPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public void multipleTransfer() throws Exception
	{
		fis = new FileInputStream(location);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("MultipleTransfer");
		int rowcount = sheet.getLastRowNum();
		for (int i = 1; i <= rowcount; i++) 
		{
			row = sheet.getRow(i);
			int colcount = sheet.getRow(i).getLastCellNum();
			for (int j = 0; j < colcount; j++)
			{
				XSSFCell cell = (XSSFCell) row.getCell(j);
				AC_Product_Number.sendKeys(row.getCell(0).getStringCellValue());
				Date.click();
				Thread.sleep(1000);
				Select activity = new Select(Activity);
				activity.selectByVisibleText("CASA_CREDIT");
				Transaction_Nature.click();
				Thread.sleep(1000);
				//double amount = (double) row.getCell(1).getNumericCellValue();
				TransferAmount.sendKeys(row.getCell(1).getStringCellValue());
				InstrumentNumber.sendKeys(row.getCell(2).getStringCellValue()); 
				AddTransfer.click();
				Thread.sleep(2000);
				AC_Product_Number.sendKeys(row.getCell(3).getStringCellValue());
				Date.click();
				Thread.sleep(1000);
				Select activity1 = new Select(Activity);
				activity1.selectByVisibleText("CASA_DEBIT");
				Transaction_Nature.click();
				Thread.sleep(2000);
				//double amount1 = (double) row.getCell(4).getNumericCellValue();
				TransferAmount.sendKeys(row.getCell(1).getStringCellValue());
				InstrumentNumber.sendKeys(row.getCell(2).getStringCellValue());
				Thread.sleep(2000);
				AddTransfer.click();
				Thread.sleep(2000);
				close.click();
				AddTransfer.click();
				Thread.sleep(2000);
				Submit.click();
				Thread.sleep(2000);
				driver.switchTo().alert().accept();
				Thread.sleep(2000);
				close.click();
				break;
			}
			driver.findElement(By.xpath("//li/a[contains(text(),'Post Transaction')]")).click();
			Thread.sleep(2000);
		}
		emp_photo.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}
	
	public void authMultipleTransfer() throws Exception
	{
		Authorization.click();
		Thread.sleep(2000);
		WebElement table=driver.findElement(By.xpath("//table[@class='table table-striped table-bordered']"));
		List<WebElement> row=table.findElements(By.tagName("tr"));
		for(int i=1;i<=row.size();i++)
		{
			List<WebElement> column=table.findElements(By.tagName("td"));
			 for(int j=0;j<=column.size();j++)
	    	 {
				 driver.findElement(By.xpath("//table[@class='table table-striped table-bordered']/tbody/tr[1]/td/a[starts-with(@id,'reference_no')]")).click();
				 Thread.sleep(2000);
	    		 Auth_button.click();
	    		 Thread.sleep(2000);
	    		 driver.switchTo().alert().accept();
				 Thread.sleep(2000);
				 close.click();
	    	 }
			 break;
		}
		
		
		
	    //List<WebElement> row=table.findElements(By.tagName("tr"));
	   /* List<WebElement> row=(List<WebElement>) table.findElement(By.xpath(""));
	    for(int i=1;i<=row.size();i++)
	    {
	    	 System.out.println("Rowcount:" + i);
	         List<WebElement> column=row.get(i).findElements(By.tagName("td"));
	    	 System.out.println(row.get(i).getText());
	    	 for(int j=0;j<=column.size();j++)
	    	 {
	    		 System.out.println("column:" + j);
	    		 column.get(j).click(); 
	    		 Thread.sleep(2000);
	    		 Auth_button.click();
	    		 Thread.sleep(2000);
	    		 driver.switchTo().alert().accept();
				 Thread.sleep(2000);
				 close.click();
				 break;
	    	 }
	    }   */
	}
}
