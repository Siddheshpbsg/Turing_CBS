package CBSReports;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Random;

public class GFG
{
	public static LocalDateTime date;
	public static void main(String args[])
	{ 
		Long max =0L;
	    Long min =100000000000L;
	    Calendar cal = Calendar.getInstance();
	    Date date =new Date(min);
	    cal.setTime(date);
	    int month = cal.get(Calendar.MONTH);
	    //Use the date format that best suites you
	    SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");
	    Random r = new Random();
	    Long randomLong=(r.nextLong() % (max - min)) + min;
		int day = date.getDay();
		int year = date.getYear();
		System.out.println(day+"-"+month+"-"+year);  
	}
}
