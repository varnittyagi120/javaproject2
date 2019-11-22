package basic;

public class statickeyword extends test 
{
	

	public static void main(String[] args) 
	{
		 test obj=new test();
		 statickeyword obj1=new statickeyword();
		 System.out.println(obj.Str);
		 System.out.println(test.Str);
		 System.out.println(obj.str1);
		 System.out.println(obj1.str1);
		 System.out.println(obj1.str1);
		 System.out.println("i am here");
		 System.out.println(args.length);
		 for(int i=0;i<args.length;i++)
		 {
			 System.out.println(args[i]);
		 }
	}

}
