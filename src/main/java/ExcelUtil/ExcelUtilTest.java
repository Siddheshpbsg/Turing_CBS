package ExcelUtil;

import com.cbs.util.Xls_Reader;

public class ExcelUtilTest {

	public static void main(String[] args)
	{
		Xls_Reader reader = new Xls_Reader("C:\\Users\\sidheshp\\eclipse-workspace\\TuringCBS\\src\\main\\java\\com\\cbs\\util\\AppachePOI.xlsx");
		String sheetName="Login";
		String data=reader.getCellData(sheetName, 1, 1);
		System.out.println(data);

	}

}
