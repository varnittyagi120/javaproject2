package empmanagementsys;
import java.io.*;
import java.util.*;
public class practice {

	public static void main(String[] args)
	{
	    try
	    {
	    	int t=100/0;
	    }
	    catch(ArithmeticException e)
	    {
	    	System.out.println("Exception "+e);
	    }
	    System.out.println("Rest of the code.....");
	    try
	    {
	    	String str=null;
	    	int length=str.length();
	    }
	    catch(NullPointerException e)
	    {
	    	System.out.println("Exception "+e);
	    }
	    System.out.println("rest of the code ............");
        String str1="abc";
        try
        {
        	int a=Integer.parseInt(str1);
        }
        catch(NumberFormatException e)
        {
        	System.out.println("Exception "+e);
        }
        System.out.println("rest of the code ............");
        int a[]=new int[5];
        try
        {
        	System.out.println(a[10]);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
        	System.out.println("Exception "+e);
        }
        System.out.println("rest of the code ............");

	}

	

}
