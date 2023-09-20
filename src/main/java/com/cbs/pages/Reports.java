package com.cbs.pages;

import java.awt.Robot;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class Login {
	public static WebDriver driver;
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static Row row;
	String location = "D:\\Siddhesh Training Document\\Automation_For_CBS\\Excel\\UAT Report List.xlsx";
	public static String statement;
	//String location = "";

	public void login() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Siddhesh Training Document\\Automation_For_CBS\\jar_files\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://unityreports.turingcbs.com:1198/TuringReportUnity/superadmin/login.aspx");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Robot rb = new Robot();
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
	}
}

class ChequeBookIssued extends Login {

	public void ChequeBookIssued() {
		try {
			//Properties properties = new Properties();
			//this.location = properties.getProperty("filelocation");
			driver.findElement(By.xpath("//input[@id='myInput']")).sendKeys("Cheque Book Issued");
			driver.findElement(By.xpath("//li[@class='ulChild']/a[contains(text(),' Cheque Book Issued')]")).click();
			Thread.sleep(3000);
			fis = new FileInputStream(location);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet("Reports to be verified");
			int rowcount = sheet.getLastRowNum();
			int colcount = sheet.getRow(1).getLastCellNum();
			row = sheet.getRow(1);
			XSSFCell cell = (XSSFCell) row.getCell(0);
			driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtFromDate']")).clear();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtFromDate']"))
					.sendKeys("01-Jan-2022");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_tbnGenerateReport']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_tbnGenerateReport']")).click();
			Thread.sleep(5000);
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			driver.close();
			driver.switchTo().window(tabs2.get(0));
			statement = driver.findElement(By.xpath("//div[@class='alert alert-success alert - dismissible']"))
					.getText();
			statement = statement.replace("Success ! File is Generated", "Success File is Generated");
			statement = statement.replace("×", "");
			statement = statement.trim();
			System.out.println(statement);
			row.createCell(3).setCellValue(statement);
			System.out.println("Done1");
			String Expected = row.getCell(2).getStringCellValue();
			System.out.println("Expected Result" + Expected);
			String Actual = row.getCell(3).getStringCellValue();
			System.out.println("Actual Result" + Actual);
			if (Actual.contains(Expected)) {
				row.createCell(4).setCellValue("Pass");
			} else {
				row.createCell(4).setCellValue("Fail");
			}
			fos = new FileOutputStream(location);
			workbook.write(fos);
			System.out.println("Done2");
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file,
					new File("D:\\Siddhesh Training Document\\Automation_For_CBS\\MIS Screenshot\\screen2.jpg"));
		} catch (Exception ex) {

		}
	}
}

/*
 * statement = driver.findElement(By.
 * xpath("//div[@class='alert alert-success alert - dismissible']")).getText();
 * statement = statement.replace("Success ! File is Generated",
 * "Success File is Generated"); statement = statement.replace("×", "");
 * statement = statement.trim(); System.out.println(statement);
 * row.createCell(3).setCellValue(statement); File file = ((TakesScreenshot)
 * driver).getScreenshotAs(OutputType.FILE); FileUtils.copyFile(file,new
 * File("D:\\Siddhesh Training Document\\Automation_For_CBS\\MIS Screenshot\\screen2.jpg"
 * )); if
 * (row.getCell(2).getStringCellValue().equals(row.getCell(3).getStringCellValue
 * ())) { row.createCell(4).setCellValue("Pass"); } else {
 * row.createCell(4).setCellValue("Fail"); } workbook.write(fos); }
 */

public class Reports extends ChequeBookIssued {
	public static void main(String[] args) throws Exception {
		Login log = new Login();
		log.login();
		ChequeBookIssued chequeBookIssued = new ChequeBookIssued();
		chequeBookIssued.ChequeBookIssued();
	}
}
