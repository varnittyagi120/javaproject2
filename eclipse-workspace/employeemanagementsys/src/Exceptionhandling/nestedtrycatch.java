package Exceptionhandling;

public class nestedtrycatch {

	public static void main(String[] args) 
	{
		try
		{
			try
			{
				int b=100/0;
			}
			catch(ArithmeticException e)
			{
				System.out.println(e);
			}
			try
			{
				int a[]=new int[5];
				a[6]=5;
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				System.out.println(e);
			}
			System.out.println("here");
		}catch(Exception e)
		{
			System.out.println("Handeled");
		}
        System.out.println("Outside try and catch");
	}

}
