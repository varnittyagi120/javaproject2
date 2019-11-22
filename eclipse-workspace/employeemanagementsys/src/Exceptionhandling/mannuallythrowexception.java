package Exceptionhandling;

public class mannuallythrowexception
{
    static void validate(int age)
    {
    	try
    	{
		    	if(age<18)
		    	{
		    		throw new ArithmeticException("Not valid");
		    	}
		    	else
		    	{
		    		System.out.println("valid age");
		    	}
    	}
    	catch(ArithmeticException e)
    	{
    		System.out.println(e);
    	}
    }
	public static void main(String[] args) 
	{
		validate(14);
        System.out.println("Normal flow");
	}

}
