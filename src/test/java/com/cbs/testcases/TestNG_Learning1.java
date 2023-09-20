package com.cbs.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

public class TestNG_Learning1 {

	public static void main(String[] args) throws Exception 
	{
		String Location="C:\\Siddhesh Training Document\\Automation_For_CBS\\Excel\\Cash_Automation.xlsx";
		FileInputStream fis=new FileInputStream(Location);
		XSSFWorkbook book=new XSSFWorkbook(fis);
		XSSFSheet sheet=book.getSheet("Sheet1");
		//XSSFSheet sheet=book.getSheetAt(1);
		Row row;
		int rowcount=sheet.getLastRowNum();
		int colcount=sheet.getRow(1).getLastCellNum();
		for(int i=1;i<=rowcount;i++)
		{
			row=sheet.getRow(i);
			for(int j=0;j<colcount;j++)
			{
				XSSFCell cell=(XSSFCell) row.getCell(j);
				switch(cell.getCellType())
				{
					case STRING:  System.out.println(cell.getStringCellValue());break;
					case NUMERIC: System.out.println(cell.getNumericCellValue());break;
					case BOOLEAN: System.out.println(cell.getBooleanCellValue());break;
					default:break;
				}
			}
			System.out.println( );
		}
		
		FileOutputStream fos=new FileOutputStream(Location);
		book.write(fos);

	}

}
