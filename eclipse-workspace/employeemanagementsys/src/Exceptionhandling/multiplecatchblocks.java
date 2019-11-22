package Exceptionhandling;

public class multiplecatchblocks {

	public static void main(String[] args) 
	{
		int a[]=new int[5];
		try
		{
			a[100]=100/10;
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Exception "+e);
		}
		//catch(ArithmeticException e)
	//	{
		//	System.out.println("Exception "+e);
		//}
		System.out.println("Rest of the code..........");
		 try{  
			    int a1[]=new int[5];  
			    a1[5]=30/0;  
			   }  
			   catch(ArithmeticException e){System.out.println("task1 is completed");}  
			   catch(ArrayIndexOutOfBoundsException e){System.out.println("task 2 completed");} 
		       catch(Exception e){System.out.println("common task completed");}  
			   System.out.println("rest of the code...");  
			   


	}

}
