package CBSReports;

class Test  //parent class
{
	public void m1(int a)
	{
		System.out.println(a);
	}
	
	/*public void m1(int x,int y)
	{
		System.out.println(x);
		System.out.println(y);
	}
	
	public void m1(int w,int r,int p)
	{
		System.out.println(w);
		System.out.println(r);
		System.out.println(p);
	}*/
	
}
public class JavaProgram extends Test   //child class
{
	public void m1(int a)
	{
		System.out.println(a);
	}
	public static void main(String[] args)
	{
		Test test=new Test();
		JavaProgram jv=new JavaProgram();
		test.m1(10);
		jv.m1(20);
	}

}
