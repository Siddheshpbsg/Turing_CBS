package com.cbs.pages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cbs.base.TestBase;
import com.cbs.util.TestUtil;

public class LoginPage extends TestBase
{
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static Row row;
	String location = "D:\\Siddhesh Training Document\\Automation_For_CBS\\Excel\\CBS_Automation.xlsx";
	String Message="Invalid employee code/password";
	IndividualcustomerPage individualcustomerPage;
	CorparateCustomerPage corparateCustomerPage;
	Homepage homepage;
	LoginPage loginpage;
	TestUtil util=new TestUtil();
	public static String data;
	
	//page factory or object repository
	@FindBy(id="id_username")
	WebElement username;
	
	@FindBy(id="id_search_employee")
	WebElement verifybutton;
	
	@FindBy(id="id_password")
	WebElement password;
	
	@FindBy(id="id_submit")
	WebElement submitbutton;
	
	@FindBy(xpath="//img[@id='id_emp_photo']")
	WebElement image;
	
	@FindBy(xpath="//a[@id='id_logout']")
	WebElement logout;
		
	//initializing the page objects
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public String loginPageTitle()
	{
		return driver.getTitle();
	}
	
	public Homepage makerLogin(String UserName,String Password) throws Exception
	{
		loginpage=new LoginPage();
		username.sendKeys(UserName);
		verifybutton.click();
		Thread.sleep(2000);
		password.sendKeys(Password);
		submitbutton.click();
		Thread.sleep(3000);
		data=driver.findElement(By.xpath("//div[@id='error_message_master']")).getText();
		//System.out.println("Before New Data: "+data);
		data = data.replace("Error"," ");
		data = data.replace("x"," ");
		data = data.trim();
		System.out.println("After New Data: "+data);
		if(data.equals(Message))
		{
			driver.findElement(By.xpath("//a[@id='id_closeErrorMessage']")).click();
			Thread.sleep(2000);
			driver.navigate().refresh();
			driver.manage().deleteAllCookies();
			Thread.sleep(2000);
			driver.get(properties.getProperty("url"));
			Thread.sleep(2000);
			homepage=loginpage.makerLogin(properties.getProperty("maker"),properties.getProperty("maker_password"));
			Thread.sleep(3000);
		}
		//util.getscreenshot();
		return new Homepage();
	}
		
	public Homepage checkerLogin(String UserName1,String Password1) throws Exception
	//public Homepage checkerLogin() throws Exception
	{
		loginpage=new LoginPage();
		username.sendKeys(UserName1);
		verifybutton.click();
		Thread.sleep(2000);
		password.sendKeys(Password1);
		submitbutton.click();
		Thread.sleep(3000);
		String data=driver.findElement(By.xpath("//div[@id='error_message_master']")).getText();
		data = data.replace("Error"," ");
		data = data.replace("x","");
		data = data.trim();
		if(data.equals(Message))
		{
			driver.findElement(By.xpath("//a[@id='id_closeErrorMessage']")).click();
			Thread.sleep(2000);
			driver.navigate().refresh();
			driver.manage().deleteAllCookies();
			Thread.sleep(2000);
			driver.get(properties.getProperty("url"));
			Thread.sleep(2000);
			homepage=loginpage.checkerLogin(properties.getProperty("checker"),properties.getProperty("checker_password"));
			Thread.sleep(3000);
		}
		//util.getscreenshot();
		return new Homepage();
	}
		
		
	public void userLogout() throws Exception
	{
		image.click();
		Thread.sleep(3000);
		logout.click();
		Thread.sleep(3000);
	}
	
	public Homepage makerLogin1(String UserName3,String Password3) throws Exception
	{
		loginpage=new LoginPage();
		username.sendKeys(UserName3);
		verifybutton.click();
		Thread.sleep(2000);
		password.sendKeys(Password3);
		submitbutton.click();
		Thread.sleep(3000);
		data=driver.findElement(By.xpath("//div[@id='error_message_master']")).getText();
		//System.out.println("Before New Data: "+data);
		data = data.replace("Error"," ");
		data = data.replace("x"," ");
		data = data.trim();
		System.out.println("After New Data: "+data);
		if(data.equals(Message))
		{
			driver.findElement(By.xpath("//a[@id='id_closeErrorMessage']")).click();
			Thread.sleep(2000);
			driver.navigate().refresh();
			driver.manage().deleteAllCookies();
			Thread.sleep(2000);
			driver.get(properties.getProperty("url"));
			Thread.sleep(2000);
			homepage=loginpage.makerLogin1(properties.getProperty("maker1"),properties.getProperty("maker_password1"));
			Thread.sleep(3000);
		}
		//util.getscreenshot();
		return new Homepage();
	}
	
	
	public Homepage checkerLogin1(String UserName4,String Password4) throws Exception
	//public Homepage checkerLogin() throws Exception
	{
		loginpage=new LoginPage();
		username.sendKeys(UserName4);
		verifybutton.click();
		Thread.sleep(2000);
		password.sendKeys(Password4);
		submitbutton.click();
		Thread.sleep(3000);
		String data=driver.findElement(By.xpath("//div[@id='error_message_master']")).getText();
		data = data.replace("Error"," ");
		data = data.replace("x","");
		data = data.trim();
		if(data.equals(Message))
		{
			driver.findElement(By.xpath("//a[@id='id_closeErrorMessage']")).click();
			Thread.sleep(2000);
			driver.navigate().refresh();
			driver.manage().deleteAllCookies();
			Thread.sleep(2000);
			driver.get(properties.getProperty("url"));
			Thread.sleep(2000);
			homepage=loginpage.checkerLogin1(properties.getProperty("checker1"),properties.getProperty("checker_password1"));
			Thread.sleep(3000);
		}
		//util.getscreenshot();
		return new Homepage();
	}
}


//return new Homepage();
		//util.getscreenshot();
		/*fis = new FileInputStream(location);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("User_Login");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(1).getLastCellNum();
		for (int i=1;i<=rowcount;i++)
		{
			row = sheet.getRow(i);
			for(int j=0;j<colcount;j++)
			{
				XSSFCell cell=(XSSFCell) row.getCell(j);
				//Long username=(long) row.getCell(0).getNumericCellValue();
				username.sendKeys(row.getCell(0).getStringCellValue());
				verifybutton.click();
				Thread.sleep(2000);
				password.sendKeys(row.getCell(1).getStringCellValue());
				submitbutton.click();
				Thread.sleep(5000);
				data=driver.findElement(By.xpath("//div[@id='error_message_master']")).getText();
				//System.out.println("Before New Data: "+data);
				data = data.replace("Error"," ");
				data = data.replace("x"," ");
				data = data.trim();
				System.out.println("After New Data: "+data);
				if(data.equals(Message))
				{
					driver.findElement(By.xpath("//a[@id='id_closeErrorMessage']")).click();
					Thread.sleep(2000);
					driver.navigate().refresh();
					driver.manage().deleteAllCookies();
					Thread.sleep(2000);
					driver.get(properties.getProperty("url"));
					Thread.sleep(2000);
					homepage=loginpage.makerLogin();
					Thread.sleep(5000);
				}
			}
		}
		return new Homepage();
		//util.getscreenshot();*/


/*LoginPage loginpage=new LoginPage();
fis = new FileInputStream(location);
workbook = new XSSFWorkbook(fis);
sheet = workbook.getSheet("User_Login");
int rowcount = sheet.getLastRowNum();
int colcount = sheet.getRow(1).getLastCellNum();
for (int i=2;i<=rowcount;i++)
{
	row = sheet.getRow(i);
	for(int j=0;j<colcount;j++)
	{
		XSSFCell cell=(XSSFCell) row.getCell(j);
		//Long username=(long) row.getCell(0).getNumericCellValue();
		username.sendKeys(row.getCell(0).getStringCellValue());
		verifybutton.click();
		Thread.sleep(2000);
		password.sendKeys(row.getCell(1).getStringCellValue());
		submitbutton.click();
		Thread.sleep(5000);
		data=driver.findElement(By.xpath("//div[@id='error_message_master']")).getText();
		//System.out.println("Before New Data: "+data);
		data = data.replace("Error"," ");
		data = data.replace("x"," ");
		data = data.trim();
		System.out.println("After New Data: "+data);
		if(data.equals(Message))
		{
			driver.findElement(By.xpath("//a[@id='id_closeErrorMessage']")).click();
			Thread.sleep(2000);
			driver.navigate().refresh();
			driver.manage().deleteAllCookies();
			Thread.sleep(2000);
			driver.get(properties.getProperty("url"));
			Thread.sleep(2000);
			homepage=loginpage.checkerLogin();
			Thread.sleep(5000);
		}
	}
}
return new Homepage();
}*/


/*public void newmakerLogin() throws Exception
{
	String cust_cred=getCredentialFromUser().get("BranchMaker");
	username.sendKeys(cust_cred.split(":")[0]);
	verifybutton.click();
	Thread.sleep(2000);
	password.sendKeys(cust_cred.split(":")[1]);
}*/


/*public static HashMap<String,String> getCredentialFromUser()
{
	HashMap<String, String> hashMap=new HashMap<String, String>();
	hashMap.put("BranchMaker", "sp-m:Test@1234");
	hashMap.put("Branchchecker", "sp-c:Test@1234");
	hashMap.put("HOMaker", "Homaker:");
	hashMap.put("HoChecker", "Hochecker:");
	return hashMap;
}*/