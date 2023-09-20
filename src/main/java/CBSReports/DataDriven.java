package CBSReports;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven 
{
	public static void main(String[] args) throws Exception 
	{
		FileInputStream fis=new FileInputStream("D:\\Siddhesh Training Document\\Automation_For_CBS\\Excel\\CBS_Automation.xlsx");
		XSSFWorkbook book=new XSSFWorkbook(fis);
		XSSFSheet sheet=book.getSheet("Sheet1");
		Row row;
		int rowcount=sheet.getLastRowNum();
		for(int i=0;i<rowcount;i++)
		{
			row=sheet.getRow(i);
			int colcount=row.getLastCellNum();
			for(int j=0;j<colcount;j++)
			{
				System.out.print(row.getCell(j).getStringCellValue());
			}
			System.out.println("  ");
		}
		FileOutputStream fos=new FileOutputStream("D:\\Siddhesh Training Document\\Automation_For_CBS\\Excel\\CBS_Automation.xlsx");
		book.write(fos);
	}
	
}


/*for(int i=0;i<10;i++)
{
	row=sheet.createRow(i);
	row.createCell(0).setCellValue("Ajay Shukla");
}
//int size=sheet.getLastRowNum();
//for(int i=1;i<size;i++)*/





