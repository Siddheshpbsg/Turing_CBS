package CBSReports;


import java.awt.Robot;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CBSLogin
{
	public static WebDriver driver;
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","D:\\Siddhesh Training Document\\Automation_For_CBS\\New Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://itcbuat.turingcbs.com:1143/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Robot rb = new Robot();
		for (int i=0;i<3;i++)
		{
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_SUBTRACT);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_SUBTRACT);
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='id_username']")).sendKeys("ss-m");
		driver.findElement(By.xpath("//button[@id='id_search_employee']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='id_password']")).sendKeys("Test@123");
		driver.findElement(By.xpath("//button[@id='id_submit']")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//img[@id='id_emp_photo']")).click();
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[@id='id_logout']")).click();
		//Thread.sleep(3000);
		//Actions action = new Actions(driver); 
		rb.keyPress(KeyEvent.VK_ALT);
		rb.keyPress(KeyEvent.VK_T);
		rb.keyRelease(KeyEvent.VK_T);
		rb.keyRelease(KeyEvent.VK_ALT);
		//driver.get("https://narodauat.turingcbs.com:7243/");
		ArrayList<String> w = new ArrayList<String>(driver.getWindowHandles());
		Thread.sleep(10000);
		//System.out.println(w);
		driver.switchTo().window(w.get(0));
	   //switch to open tab
	    //driver.switchTo().window(w.get(1));
	    //System.out.println("New tab title: " + driver.getTitle());
	    //switch to first tab
	    //driver.switchTo().window(w.get(0));
		driver.findElement(By.xpath("//span[contains(text(),'Customer Creation (Individual)')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'New Customer')]")).click();
		Thread.sleep(3000);
		//JavascriptExecutor jse = (JavascriptExecutor) driver;
		//jse.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		driver.findElement(By.xpath("//select[@id='id_branch']")).click();
		Thread.sleep(2000);
		//Siddhesh
		Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	}

}
