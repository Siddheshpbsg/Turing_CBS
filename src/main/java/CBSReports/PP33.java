package CBSReports;

import java.security.SecureRandom;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

import org.apache.commons.math3.random.RandomDataGenerator;
public class PP33
{
  public static void main (String[] args)
  {
	  //Create Random mobile number
    Random rand = new Random();
    int num1, num2, num3;
    num1 = rand.nextInt (900) + 100;
    num2 = rand.nextInt (643) + 100;
    num3 = rand.nextInt (9000) + 1000;
    System.out.println(num1+""+num2+""+num3);
    
    //Create Random Date of birth number
    Long max =0L;
    Long min =100000000000L;
    //Use the date format that best suites you
    
    SimpleDateFormat spf = new SimpleDateFormat("dd-MMM-yyyy");
    Random r = new Random();
    Long randomLong=(r.nextLong() % (max - min)) + min;
    Date date =new Date(randomLong);
    System.out.println("Generated Long:"+ randomLong);
    System.out.println("Date generated from long: "+spf.format(date));

    
    
    //Create Random PAN number
   /* public int createRandomPin()
    {
        int k = random.nextInt(Integer.SIZE);
        k = (k + 1) * 9999;
        if (9999 > k || k > 99999)
        {
            //then regenerate 
        }
        else
        {
            return k;
        }
    }
    SecureRandom random = new SecureRandom();
    int num = random.nextInt(100000);
    String formatted = String.format("%05d", num); 
    System.out.println(formatted);*/
    
    
    
  }
}
