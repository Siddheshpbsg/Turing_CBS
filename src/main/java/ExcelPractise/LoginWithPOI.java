package ExcelPractise;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class LoginWithPOI
{
	public static WebDriver driver;
	public static void main(String[] args) throws Exception
	{
		ChromeOptions handlingSSL = new ChromeOptions(); 
		handlingSSL.setAcceptInsecureCerts(true);	
		System.setProperty("webdriver.chrome.driver","C:\\Siddhesh Training Document\\Automation_For_CBS\\selenium jar\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver(handlingSSL);
		driver.get("https://nesfbuat.turingcbs.com:7943/");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Robot rb=new Robot();
		for(int i=0;i<3;i++)
		{
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_SUBTRACT);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_SUBTRACT);
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='id_username']")).sendKeys("sr-m");
		driver.findElement( By.xpath("//button[@id='id_search_employee']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='id_password']")).sendKeys("Test@1234");
		driver.findElement(By.xpath("//button[@id='id_submit']")).click();
		Thread.sleep(5000);
		Actions action=new Actions(driver);
		WebElement cash=driver.findElement(By.xpath("//span[contains(text(),'Cash')]"));
		action.moveToElement(cash).click().build().perform();
		Thread.sleep(5000);
		
		FileInputStream fis=new FileInputStream("C:\\Siddhesh Training Document\\Automation_For_CBS\\Excel\\Cash_Automation.xlsx");
		XSSFWorkbook book=new XSSFWorkbook(fis);
		XSSFSheet sheet=book.getSheet("Sheet1");
		Row row;
		int count=sheet.getLastRowNum();
		for(int i=1;i<=count;i++)
		{
			row=sheet.getRow(i);
			driver.findElement(By.xpath("//input[@id='id_txtAccountNumber']")).sendKeys(row.getCell(0).getStringCellValue());
		}
		FileOutputStream fos=new FileOutputStream("‪C:\\Siddhesh Training Document\\Automation_For_CBS\\Excel\\Cash_Automation.xlsx");
		book.write(fos);
	}
}
		
		
/*FileInputStream fis=new FileInputStream("C:\\Siddhesh Training Document\\Automation_For_CBS\\NewTours.xlsx");
XSSFWorkbook workbook=new XSSFWorkbook(fis);
XSSFSheet sheet=workbook.getSheet("Sheet1");
Row row;
{
	row=sheet.createRow(5);
	row.createCell(6).setCellValue("Siddhesh");
}
FileOutputStream outputStream = new FileOutputStream("C:\\Siddhesh Training Document\\Automation_For_CBS\\NewTours.xlsx");
workbook.write(outputStream);		
		
		
		
		
		
		
		/*ChromeOptions handlingSSL = new ChromeOptions(); 
		handlingSSL.setAcceptInsecureCerts(true);	
		System.setProperty("webdriver.chrome.driver","C:\\Siddhesh Training Document\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver(handlingSSL);
		driver.get("https://10.10.30.110:8243/");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Robot rb=new Robot();
		for(int i=0;i<3;i++)
		{
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_SUBTRACT);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_SUBTRACT);
		}
		Thread.sleep(3000);*/
		
		

			/*FileInputStream fis=new FileInputStream("‪C:\\Users\\sidheshp\\Desktop\\Ucbslogin.xlsx");
			//FileInputStream fis=new FileInputStream("‪C:\\Users\\sidheshp\\Desktop\\Ucbslogin.xlsx");
			XSSFWorkbook book=new XSSFWorkbook(fis);
			XSSFSheet sheet=book.getSheet("Sheet1");
			Row row;
			int cell=sheet.getLastRowNum();
			//System.out.println("Row count: "+ rowcount);
			for(int i=1;i<cell;i++)
			{
				row=sheet.getRow(i);
				driver.findElement(By.xpath("//input[@id='id_username']")).sendKeys(row.getCell(0).getStringCellValue());
				//row.getCell(0).getStringCellValue();
				driver.findElement(By.xpath("//button[@id='id_search_employee']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@id='id_password']")).sendKeys(row.getCell(1).getStringCellValue());
				driver.findElement(By.xpath("//button[@id='id_submit']")).click();
			}
			//FileOutputStream fos=new FileOutputStream("‪C:\\Users\\sidheshp\\Desktop\\Ucbslogin.xlsx");
			FileOutputStream fos=new FileOutputStream("‪C:\\Users\\sidheshp\\Desktop\\Ucbslogin.xlsx");
			book.write(fos);*/
