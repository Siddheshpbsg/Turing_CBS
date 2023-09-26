package com.cbs.util;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.poifs.property.Child;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.cbs.base.TestBase;
import com.cbs.pages.Homepage;
import com.cbs.pages.IndividualcustomerPage;
import com.cbs.pages.LoanCreationPage;
import com.cbs.pages.LoginPage;

public class TestUtil extends TestBase
{
	Actions action=new Actions(driver);
	public static long PAGE_LOAD_TIME=20;
	public static long IMPLICIT_WAIT=20;
	LoginPage loginpage;
	Homepage homepage;
	//public String CustID;
	public void addsignature() throws Exception
	{
		WebElement Signature_Card_File= driver.findElement(By.xpath("//input[@id='id_signature_card']"));
		/*action.moveToElement(Signature_Card_File).click().build().perform();
		Thread.sleep(3000);
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_C);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_SEMICOLON);
		robot.keyRelease(KeyEvent.VK_SEMICOLON);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_BACK_SLASH);
		robot.keyRelease(KeyEvent.VK_BACK_SLASH);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_S);
		robot.keyPress(KeyEvent.VK_I);
		robot.keyRelease(KeyEvent.VK_I);
		robot.keyPress(KeyEvent.VK_G);
		robot.keyRelease(KeyEvent.VK_G);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);*/
		Thread.sleep(3000);
		Signature_Card_File.sendKeys("D:\\Siddhesh automation\\eclipse-workspace\\eclipse-workspace\\TuringCBS1\\picture\\MicrosoftTeams-SIGN.jpg");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='id_signature_upload_add']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='id_signature_upload_submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='id_closeErrorMessage']")).click();
		Thread.sleep(2000);
	}
	
	public void addphoto() throws Exception
	{ 
		WebElement Photo_Card_File= driver.findElement(By.xpath("//input[@id='id_photo_card']"));
		/*action.moveToElement(Photo_Card_File).click().build().perform();
		Thread.sleep(3000);
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_C);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_SEMICOLON);
		robot.keyRelease(KeyEvent.VK_SEMICOLON);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_BACK_SLASH);
		robot.keyRelease(KeyEvent.VK_BACK_SLASH);
		robot.keyPress(KeyEvent.VK_I);
		robot.keyRelease(KeyEvent.VK_I);
		robot.keyPress(KeyEvent.VK_M);
		robot.keyRelease(KeyEvent.VK_M);
		robot.keyPress(KeyEvent.VK_G);
		robot.keyRelease(KeyEvent.VK_G);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);*/ 
		Thread.sleep(3000);
		Photo_Card_File.sendKeys("D:\\Siddhesh automation\\eclipse-workspace\\eclipse-workspace\\TuringCBS1\\picture\\harish 1p.jpg");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='id_photo_upload_add']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='id_photo_upload_submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='id_closeErrorMessage']")).click();
		Thread.sleep(2000);
	}
	public void handlePopUp() {
		driver.switchTo().alert().accept();
		
	}	
	public void selectBranchUtil() {
		String Branch = driver.findElement(By.xpath("//label[@id='id_select_branch_message']")).getText();
	}
	public void Logout() throws Exception {
		Thread.sleep(2000);
		WebElement emp_photo = driver.findElement(By.xpath("//img[@id='id_emp_photo']")) ;
		Thread.sleep(2000);
		emp_photo.click();		
		WebElement logout = driver.findElement(By.xpath("//a[@id='id_logout']"));
		Thread.sleep(2000);
		logout.click();
	}
	public void handle_popop() throws Exception
	{
		String MainWindow=driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();      
		Iterator<String> i=s.iterator();          //	public void AddressAlertHandle() {
//		driver.switchTo().alert().dismiss();
//	}

		while(i.hasNext())          
		{   
			String ChildWindow=i.next();  
			if(!MainWindow.equalsIgnoreCase(ChildWindow))          
			{          
                // Switching to Child window
				driver.switchTo().window(ChildWindow);                                                                                                                                       
				driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
				driver.close();
			}
			driver.switchTo().window(MainWindow);
			driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
		}
		Thread.sleep(3000);
	}
	
	public void handle_popop1() throws Exception
	{
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
		Thread.sleep(3000);
	}
		
		    /*if(!MainWindow.equalsIgnoreCase(ChildWindow))			
		    {    		
		            // Switching to Child window
		            driver.switchTo().window(ChildWindow);	                                                                                                                         			
		            driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
		            driver.close();
		    }
		    driver.switchTo().window(MainWindow);
		    driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
		    Thread.sleep(3000);
		}*/
		
	public void createJDBCConnection() throws Exception
	
	{
		
		//ssJDBCConnection.getconnection();
		JDBCConnection.getMigratedIndividualCustomer();
	}
	
	public void getscreenshot() throws Exception
	{
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File("D:\\Siddhesh Training Document\\Automation_For_CBS\\MIS Screenshot" +System.currentTimeMillis()+ "screen1.jpg"));
	}
	
	public void makerLogin() throws Exception{
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("maker"), properties.getProperty("maker_password"));
		
	}
	public void checkerLogin() throws Exception{
		loginpage = new LoginPage();
		homepage = loginpage.makerLogin(properties.getProperty("checker"), properties.getProperty("checker_password"));
		
	}
	
//	public void GOLDLoanSecurity() {
//		driver.findElement(By.xpath("//input[@id='id_witnesscustid']")).sendKeys("51104");
//		driver.findElement(By.xpath("//input[@id='id_storagerefno']")).sendKeys("1256");
//		Select Valuer_Name=new Select(driver.findElement(By.xpath("//select[@id='id_valuer_name']")));
//		Valuer_Name.selectByIndex(2);
//		driver.findElement(By.xpath("//textarea[@id='id_golddesc']")).sendKeys("24 carat pure gold");
//		driver.findElement(By.xpath("//input[@id='id_item_weight']")).sendKeys("50");
//		driver.findElement(By.xpath("//input[@id='id_stone_weight']")).sendKeys("1");
//		Select Gold_purity = new Select(driver.findElement(By.xpath("//select[@id='id_gold_purity']")));
//		Gold_purity.selectByIndex(1);
//	}
	
}
	




	/*public void maker_Login() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","D:\\Siddhesh Training Document\\Report\\Siddhesh Document\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://narodauat.turingcbs.com:7243/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Robot rb=new Robot();
		for(int i=0;i<4;i++)
		{
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_SUBTRACT);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_SUBTRACT);
		}
		Thread.sleep(3000);
	}
	
	public void checker_Login() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","D:\\Siddhesh Training Document\\Report\\Siddhesh Document\\chromedriver.exe");
		ChromeOptions o= new ChromeOptions();
		o.addArguments("--incognito");
		//DesiredCapabilities c = DesiredCapabilities.htmlUnit();
		DesiredCapabilities c = DesiredCapabilities.htmlUnit();
		c.setCapability(ChromeOptions.CAPABILITY, o);
		WebDriver driver = new ChromeDriver(o);
		driver.get("https://narodauat.turingcbs.com:7243/");
		driver.manage().window().maximize();
		Robot rb=new Robot();
		for(int i=0;i<4;i++)
		{
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_SUBTRACT);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_SUBTRACT);
		}
		Thread.sleep(3000);
	}*/
	

	
	/*public void getcustomerid()
	{
		WebElement customer_id=driver.findElement(By.xpath("//select[@id='id_optCustomerNumber']"));
		List<WebElement> dropdown=customer_id.findElements(By.tagName("option"));
		CustID = IndividualcustomerPage.Indv_cust_id;
		System.out.println("Print new cust_id: "+CustID);
		for(int i=0;i<dropdown.size();i++)
		{
			System.out.println(dropdown.get(i).getText());
			if(dropdown.get(i).getText().equals(CustID))
			{
				dropdown.get(i).click();
				break;
			}
		}
	}*/


/*Thread.sleep(5000);
String MainWindow=driver.getWindowHandle(); 

System.out.println("handle_popop MainWindow:" + MainWindow);

Set<String> s=driver.getWindowHandles();

//Iterator<String> i=s.iterator();
//while(i.hasNext())	
for(String child:s)
{		

	System.out.println("handle_popop:" + s.size());
	
	System.out.println("handle_popop child:" + child);
    String ChildWindow=child;//i.next();			
    if(!MainWindow.equalsIgnoreCase(ChildWindow))			
    {    		
            // Switching to Child window
            driver.switchTo().window(ChildWindow);	                                                                                                                         			
            driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
            driver.close();
    }
    driver.switchTo().window(MainWindow);
    driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
}
Thread.sleep(3000);*/








	
	/*public void makerReLogin() throws Exception
	{
		String data=driver.findElement(By.xpath("//div[@id='error_message_master']")).getText();
		data = data.replace("x","");
		data = data.trim();
		//System.out.println("Siddhesh Data: "+data);
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
			Thread.sleep(5000);
		}	
			
	}*/
	
	/*public void checkerReLogin() throws Exception
	{
		String data=driver.findElement(By.xpath("//div[@id='error_message_master']")).getText();
		data = data.replace("x","");
		data = data.trim();
		//System.out.println("Siddhesh Data: "+data);
		if(data.equals(Message))
		{
			driver.findElement(By.xpath("//a[@id='id_closeErrorMessage']")).click();
			Thread.sleep(2000);
			driver.navigate().refresh();
			driver.manage().deleteAllCookies();
			Thread.sleep(2000);
			driver.get(properties.getProperty("url"));
			Thread.sleep(2000);
			Thread.sleep(3000);
		}
	}*/
	
	/*public void closeCurrentTab() throws Exception
	{
		ArrayList<String> switchTabs= new ArrayList<String> (driver.getWindowHandles());
		System.out.println("First Tab: "+driver.switchTo().window(switchTabs.get(0)));  
		System.out.println("First Tab: "+driver.switchTo().window(switchTabs.get(1)));
	}*/
	
	/*public void maker_Login() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","D:\\Siddhesh Training Document\\Report\\Siddhesh Document\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://narodauat.turingcbs.com:7243/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Robot rb=new Robot();
		for(int i=0;i<4;i++)
		{
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_SUBTRACT);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_SUBTRACT);
		}
		Thread.sleep(3000);
	}
	
	public void checker_Login() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","D:\\Siddhesh Training Document\\Report\\Siddhesh Document\\chromedriver.exe");
		ChromeOptions o= new ChromeOptions();
		o.addArguments("--incognito");
		//DesiredCapabilities c = DesiredCapabilities.htmlUnit();
		DesiredCapabilities c = DesiredCapabilities.htmlUnit();
		c.setCapability(ChromeOptions.CAPABILITY, o);
		WebDriver driver = new ChromeDriver(o);
		driver.get("https://narodauat.turingcbs.com:7243/");
		driver.manage().window().maximize();
		Robot rb=new Robot();
		for(int i=0;i<4;i++)
		{
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_SUBTRACT);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_SUBTRACT);
		}
		Thread.sleep(3000);
	}*/
	

	
	/*public void getcustomerid()
	{
		WebElement customer_id=driver.findElement(By.xpath("//select[@id='id_optCustomerNumber']"));
		List<WebElement> dropdown=customer_id.findElements(By.tagName("option"));
		CustID = IndividualcustomerPage.Indv_cust_id;
		System.out.println("Print new cust_id: "+CustID);
		for(int i=0;i<dropdown.size();i++)
		{
			System.out.println(dropdown.get(i).getText());
			if(dropdown.get(i).getText().equals(CustID))
			{
				dropdown.get(i).click();
				break;
			}
		}
	}*/


/*Thread.sleep(5000);
String MainWindow=driver.getWindowHandle(); 

System.out.println("handle_popop MainWindow:" + MainWindow);

Set<String> s=driver.getWindowHandles();

//Iterator<String> i=s.iterator();
//while(i.hasNext())	
for(String child:s)
{		

	System.out.println("handle_popop:" + s.size());
	
	System.out.println("handle_popop child:" + child);
    String ChildWindow=child;//i.next();			
    if(!MainWindow.equalsIgnoreCase(ChildWindow))			
    {    		
            // Switching to Child window
            driver.switchTo().window(ChildWindow);	                                                                                                                         			
            driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
            driver.close();
    }
    driver.switchTo().window(MainWindow);
    driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
}
Thread.sleep(3000);*/







