package CBSReports;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class PrioritySectorLending
{
	public String location;
	public String statement;
	Properties properties;
	
	public PrioritySectorLending(Properties properties )
	{
		this.properties = properties;
		this.location = properties.getProperty("filelocation");
	}
	
	public void PrioritySectorLending()
	{
		try
		{
			Login.driver.findElement(By.xpath("//input[@id='myInput']")).sendKeys("Priority Sector Lending");
			Login.driver.findElement(By.linkText("12) Priority Sector Lending")).click();
			Thread.sleep(3000);
			Login.fis = new FileInputStream(location);
			Login.workbook = new XSSFWorkbook(Login.fis);
			Login.sheet = Login.workbook.getSheet("Reports to be verified");
			int rowcount = Login.sheet.getLastRowNum();
			int colcount = Login.sheet.getRow(5).getLastCellNum();
			Login.row = Login.sheet.getRow(5);
			XSSFCell cell = (XSSFCell) Login.row.getCell(0);
			Login.driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtReportDate']")).clear();
			Thread.sleep(3000);
			Login.driver.findElement(By.xpath("//span[contains(text(),'×')]")).click();
			Thread.sleep(3000);
			Login.driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtReportDate']")).sendKeys("01-Jan-2022");
			Thread.sleep(3000);
			Login.driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_tbnGenerateReport']")).click();
			Thread.sleep(5000);
			Login.driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_tbnGenerateReport']")).click();
			Thread.sleep(5000);
			statement = Login.driver.findElement(By.xpath("//div[@class='alert alert-success alert - dismissible']")).getText();
			statement = statement.replace("Success ! File is Generated", "Success File is Generated");
			statement = statement.replace("×", "");
			statement = statement.trim();
			System.out.println(statement);
			
			/*ArrayList<String> tabs2 = new ArrayList<String>(Login.driver.getWindowHandles());
			Login.driver.switchTo().window(tabs2.get(1));
			Login.driver.close();
			Login.driver.switchTo().window(tabs2.get(0));*/
			Login.row.createCell(3).setCellValue(statement);
			System.out.println("Done1");
			String Expected = Login.row.getCell(2).getStringCellValue();
			System.out.println("Expected Result" + Expected);
			String Actual = Login.row.getCell(3).getStringCellValue();
			System.out.println("Actual Result" + Actual);
			if (Actual.contains(Expected)) {
				Login.row.createCell(4).setCellValue("Pass");
			} else {
				Login.row.createCell(4).setCellValue("Fail");
			}
			Login.fos = new FileOutputStream(location);
			Login.workbook.write(Login.fos);
			System.out.println("Done2");
			File file = ((TakesScreenshot) Login.driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("D:\\Siddhesh Training Document\\Automation_For_CBS\\MIS Screenshot\\screen3.jpg"));
			
		}
		catch (Exception e) {
			
		}
	}
}
