package empmanagementsys;
import java.util.*;
public class testo {
	 /*public static  boolean fname(String firstName) 
	 {
          return firstName.matches("[A-Z][a-z]*");
     }*/
	public static void main(String[] args) throws InterruptedException 
	{
		String str="male";
		/*String fname="varnit";
		String lname="tyagi";
		String no="96541331009";
		String str1="fdsgfdfghdfhgvarnittyagi@gmail.com";
		String fname1="varnit";
		String lname1="tyagi";
		String no1="96541331009";
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
		System.out.format("%-5s%-40s %-5s %-20s %-5s %-20s %-5s %-15s %-5s\n","|",str,"|",fname,"|",lname,"|",no,"|");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
		System.out.format("%-5s%-40s %-5s %-20s %-5s %-20s %-5s %-15s %-5s\n","|",str1,"|",fname1,"|",lname1,"|",no1,"|");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
         */
		if(str.matches("^M(ale)?$|^F(emale)?$"))
		{
			System.out.println("correct");
		}
		//tt.printTable(); 
		//  final String ANSI_RESET  = "\u001B[0m";
	    //System.out.println(ANSI_RESET);
		
		//System.out.println("here");
		//long start = System.currentTimeMillis();
        //Thread.sleep(1000);
        //System.out.println("we go");
		/*String name="Varnit";
		Scanner sc=new Scanner(System.in);
		name=sc.nextLine();
		Map<Integer,String> map=new HashMap<Integer,String>();
		map.put(1,"geeks");
		map.put(2,"for");
		map.put(3,"geeks");
		for(Map.Entry<Integer,String>entry:map.entrySet())
		{
			System.out.println("Key "+entry.getKey()+" Value "+entry.getValue());
		}
		map.replace(1,"Geeko");
		for(Map.Entry<Integer,String>entry:map.entrySet())
		{
			System.out.println("Key "+entry.getKey()+" Value "+entry.getValue());
		}
		//operations obj2=new operations();
		//obj2.add();*/
		/*int a=1000;
		int b=2000;
		int c=3000;
		int d=4000;*/
		//System.out.println(a+"                 "+b+"                      "+c+"                        "+d);
		/*int i=0;
		while(i<10)
		{
		 Scanner sc=new Scanner(System.in);
		 String str=sc.nextLine();
		 String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		 System.out.println(str.matches(EMAIL_REGEX));
		  i++;
		}*/
		/*int flag;
		 String str="Varnit";
		 String phoneNumber = "1999999998";
	      String regex = "(0/91)?[7-9][0-9]{9}";
	      System.out.println("The phone number is: " + phoneNumber);
	      System.out.println("Is the above phone number valid? " + phoneNumber.matches("(0/91)?[7-9][0-9]{9}"));
		 //System.out.println(str.matches("[A-Z][a-z]*"));
		 */
	    /*  System.out.println(fname("varnit"));
	      
		 do
		 { 
			 flag=0;
			 Scanner sc=new Scanner(System.in);
			 System.out.println("Enter your name");
			 str=sc.nextLine();
			 try
			 {
					 if(str.matches( "[A-Z][a-z]*")==false)
					 {
						System.out.println("Please enter only characters");
					    flag=1;
				        //long start = System.currentTimeMillis();
				       // Thread.sleep(2000);
					 }
			 }
			 catch(Exception e)
			 {
				 
			 }
		 }
		 while(flag==1);
		 System.out.println("name is "+str);*/
    }
}
//bf02e8ea-9c11-423b-9403-12b744003348

