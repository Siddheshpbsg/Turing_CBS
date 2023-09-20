package com.cbs.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
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

import com.cbs.base.TestBase;
import com.cbs.pages.Homepage;
import com.cbs.pages.IndividualcustomerPage;
import com.cbs.pages.LoginPage;

public class TestUtil extends TestBase
{
	String Message="Invalid employee code/password";
	Actions action=new Actions(driver);
	//public static long PAGE_LOAD_TIME=15;
	//public static long IMPLICIT_WAIT=15;
	//LoginPage loginpage;
	//Homepage homepage;
	//public String CustID;
	
	public void generatRandomPAN()
	{
		
	}
	
	public void generatRandomAadhaar()
	{
		
	}
	
	public void inwardUpload() throws Exception
	{
		WebElement InwardFile=driver.findElement(By.xpath("//input[@name='returnFileUpload']"));
		action.moveToElement(InwardFile).click().build().perform();
		Thread.sleep(2000);
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_C);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_SEMICOLON);
		robot.keyRelease(KeyEvent.VK_SEMICOLON);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_BACK_SLASH);
		robot.keyRelease(KeyEvent.VK_BACK_SLASH);
		robot.keyPress(KeyEvent.VK_M);
		robot.keyRelease(KeyEvent.VK_M);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_S);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_T);
		robot.keyPress(KeyEvent.VK_E);
		robot.keyRelease(KeyEvent.VK_E);
		robot.keyPress(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_R);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='btnUpload']")).click();
		Thread.sleep(2000);
	}
	
	public String generatRandomDate()
	{
		System.out.println("inside :");
		Long max =0L;
	    Long min =100000000000L;
		SimpleDateFormat spf = new SimpleDateFormat("dd-MMM-yyyy");
	    Random r = new Random();
	    Long randomLong=(r.nextLong() % (max - min)) + min;
	    Date date =new Date(randomLong);
	    System.out.println("Date generated from long: "+spf.format(date));
	    
		String date1=spf.format(date).toString();
		return date1;
	}
	
	
	public void addsignature() throws Exception
	{
		WebElement Signature_Card_File= driver.findElement(By.xpath("//input[@id='id_signature_card']"));
		action.moveToElement(Signature_Card_File).click().build().perform();
		Thread.sleep(2000);
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
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
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
		action.moveToElement(Photo_Card_File).click().build().perform();
		Thread.sleep(2000);
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
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='id_photo_upload_add']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='id_photo_upload_submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='id_closeErrorMessage']")).click();
		Thread.sleep(2000);
	}
	public void handle_popop() throws Exception
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
		Thread.sleep(2000);
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
		FileUtils.copyFile(file,new File("D:\\eclipse-workspace\\TuringCBS1\\Screenshot" +System.currentTimeMillis()+ "screen1.jpg"));
	}
	
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







