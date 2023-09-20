package CBSReports;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	public static WebDriver driver;
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static Row row;
	Robot rb;
	// String location = "D:\\Siddhesh Training
	// Document\\Automation_For_CBS\\Excel\\UAT Report List.xlsx";

	public void login() {
		try {
			System.setProperty("webdriver.chrome.driver","D:\\Siddhesh Training Document\\Automation_For_CBS\\jar_files\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://unityreports.turingcbs.com:1198/TuringReportUnity/superadmin/login.aspx");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			rb = new Robot();
			for (int i = 0; i < 3; i++) {
				rb.keyPress(KeyEvent.VK_CONTROL);
				rb.keyPress(KeyEvent.VK_SUBTRACT);
				rb.keyRelease(KeyEvent.VK_CONTROL);
				rb.keyRelease(KeyEvent.VK_SUBTRACT);
			}
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='txtUserName']")).sendKeys("Bsg-Amit");
			driver.findElement(By.xpath("//input[@id='txtpassword']")).sendKeys("amit");
			driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
			Thread.sleep(5000);
		} catch (Exception ex) {
			System.out.println(ex.getStackTrace());
		}
	}

	public static void main(String[] args)
	{
		try {
			Properties prop = new Properties();
			File iniFile=new File("D:\\eclipse-workspace\\TuringCBS\\src\\main\\java\\com\\cbs\\config\\config.properties");
			InputStream inputStream = new FileInputStream(iniFile);
			prop.load(inputStream);
			Login log = new Login();
			log.login();
			System.out.println("Login Sucessfully...");
			ChequeBookIssued chequeBookIssued = new ChequeBookIssued(prop);
			chequeBookIssued.ChequeBookIssued();
			System.out.println("chequeBookIssued Report Generated...");
			TransactionDetails transactionDetails=new TransactionDetails(prop);
			transactionDetails.TransactionDetails();
			System.out.println("TransactionDetails Report Generated...");
			PrioritySectorLending prioritySectorLending=new PrioritySectorLending(prop);
			prioritySectorLending.PrioritySectorLending();
			System.out.println("Priority Sector Lending Report Generated...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
