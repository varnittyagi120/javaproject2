package empmanagementsys;
import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class operato 
{
	Map<String,employee> map=new HashMap<String,employee>();
	operato operato = new operato();
	 public int add()
	 {
		 employee e=new employee();
		 System.out.println("Enter First name ");
		 e.setfname(getstring());
		 
		 System.out.println("Enter Last name ");
		 e.setlname(getstring());
		 
		 System.out.println("Enter Contact Number ");
		 e.setnumber(getnumber());

		 System.out.println("Enter Emailid");
		 e.setemail(getemail());
		 
		 String uniqueID = UUID.randomUUID().toString();
		 System.out.println("Data has been successfully inserted");
		 System.out.println("Your uuid is "+uniqueID);
		 map.put(uniqueID,e);
		 
		 return exitsign();
	 }
	 public int read()
	 {
		 System.out.println("Enter uniqueId");
		 Scanner sc=new Scanner(System.in);
		 String uid = sc.nextLine();
         int flag=0;
         System.out.println(String.format("%s", "---------------------------------------------------------------------------------------------------------------------------------"));
	     System.out.println(String.format("%1s %17s %20s %15s %2s %15s %5s %15s %5s %12s %12s","|","UniqueID", "|", "First Name", "|", "Last Name","|","Mobile Number","|","E-mail","|"));   
	     for (Map.Entry<String,employee> entry:map.entrySet()) { 
		        String key=entry.getKey();  
		        employee b=entry.getValue();
		        if(uid.equals(key))
		        { 
		        	flag=1;
		        	System.out.println(String.format("%s", "---------------------------------------------------------------------------------------------------------------------------------"));
		   	        System.out.println(String.format("%1s %15s %1s %12s %5s %12s %8s %12s %8s %15s %8s","|",uid, "|",b.fname, "|",b.lname,"|",b.number,"|",b.email,"|"));                		          
		        }
		 }  
		 System.out.println(String.format("%s", "---------------------------------------------------------------------------------------------------------------------------------"));
		if(flag==0)	{
			System.out.println("Desired entry doesn't exsist");
		}
		return exitsign();
	 }
	 
	 public int readall() {   
		 System.out.println(String.format("%s", "---------------------------------------------------------------------------------------------------------------------------------"));
	     System.out.println(String.format("%1s %17s %20s %15s %2s %15s %5s %15s %5s %12s %12s","|","UniqueID", "|", "First Name", "|", "Last Name","|","Mobile Number","|","E-mail","|")); 
	     for (Map.Entry<String,employee> entry:map.entrySet())
		 {    
		        String key=entry.getKey();  
		        employee b=entry.getValue();
		        System.out.println(String.format("%s", "---------------------------------------------------------------------------------------------------------------------------------"));
	   	        System.out.println(String.format("%1s %15s %1s %12s %5s %12s %8s %12s %8s %15s %8s","|",key, "|",b.fname, "|",b.lname,"|",b.number,"|",b.email,"|"));                	          
		 }
		 System.out.println(String.format("%s", "---------------------------------------------------------------------------------------------------------------------------------"));

		 return exitsign();
	 }
	 public int update() throws InterruptedException
	 {
		 System.out.println("Enter uuid of employee for which u want to update ");
		 Scanner sc=new Scanner(System.in);
		 String uid=sc.nextLine();
		 int flag=0;
		 for(Map.Entry<String,employee>entry:map.entrySet())
		 {
			 String key=entry.getKey();
			 employee b=entry.getValue();
			 if(uid.equals(key))
			 {
				 flag=1;
				 updatefname(b,uid);
				 updatelname(b,uid);
				 updatenumber(b,uid);
				 updateemail(b,uid);
				 System.out.println("Desired entry has been successfully updated");
			 }
	
		 }
		 if(flag==0)
		 {
			 System.out.println("Desired Entry does not exsist");
		 }
		 return exitsign();
	 }

	 public int delete1()
	 {
		    
		    int flag=0;
		    do 
		    {
		    	System.out.println("Enter uniqueId for deletion");
		    	Scanner sc=new Scanner(System.in);
				String uid=sc.nextLine();
				flag=0;
				for (Map.Entry<String,employee> entry:map.entrySet())
				 { 
				        String key=entry.getKey();  
				        employee b=entry.getValue();
				        if(uid.equals(key))
				        { 
				        	flag=1;
				        	map.remove(uid);
				        	System.out.println("Desired entry has been successfully deleted");
				        }
				 }  
				if(flag==0)
				{
					System.out.println("Desired entry doesn't exsist");
					break;
				}
		        
		    }while(flag==0);
			
			return exitsign();
	 }
	 public void updatefname(employee b,String uid)
	 {
		 System.out.println("Old first name "+b.fname);
        System.out.println("Enter new first name if u want to update else press enter ");
        String fname=getstring1();
        if(fname.isEmpty())
        {   
        	b.setfname(b.fname);
        }
        else
        {
            b.setfname(fname);
        }
        map.replace(uid,b);
	 }
	  public void updatelname(employee b,String uid)
	 {
		 System.out.println("Old last name "+b.lname);
         System.out.println("Enter new last name if u want to update else press enter");
         String lname=getstring1();
         if(lname.isEmpty())
         {
         	b.setlname(b.lname);
         }
         else
         {
             b.setlname(lname);
         }
        map.replace(uid,b);
	 }
	 public void updatenumber(employee b,String uid)
	 {
		 System.out.println("Old last mobile number "+b.number);
        System.out.println("Enter new mobile number if u want to update else press enter");
        String number=getnumber1();
        if(number.isEmpty())
        {
        	b.setnumber(b.number);
        }
        else
        {
            b.setnumber(number);
        }
        map.replace(uid,b);
	 }
	 public void updateemail(employee b,String uid)
	 {
		 System.out.println("Old email id "+b.email);
        System.out.println("Enter new email id if u want to update else press enter");
        String email=getemail1();
        if(email.isEmpty())
        {
        	b.setemail(b.email);
        }
        else
        {
            b.setemail(email);
        }
        map.replace(uid,b);
	 }
	 public String getstring()
	 {
		 int flag,f;
		 String str;
		 do
		 {
			 flag=1;
			 f=1;
			 Scanner sc=new Scanner(System.in);
			 str=sc.nextLine();
			 if(str.isEmpty())
			 {
				 f=0;
			 }
			 try
			 {
				 int no=Integer.parseInt(str);
			 }
			 catch(Exception e)
			 {
				 flag=0;
			 }
			 if(flag==1)
			 {
				 System.out.println("Please enter correct name");
			 }
			 if(f==0)
			 {
				 System.out.println("required");
			 }
			
		 }
		 while(flag==1||f==0);
		 return str;
	 }
	 public String getstring1()
	 {
		 int flag;
		 String str;
		 do
		 {
			 flag=1;
			 Scanner sc=new Scanner(System.in);
			 str=sc.nextLine();
			 try
			 {
				 int no=Integer.parseInt(str);
			 }
			 catch(Exception e)
			 {
				 flag=0;
			 }
			 if(flag==1)
			 {
				 System.out.println("Please enter correct name");
			 }
			
		 }
		 while(flag==1);
		 return str;
	 }
	 public String getnumber()
	 {
		 String number;
		 int flag=0;
		 do
		 {
			 flag=0;
			 Scanner sc=new Scanner(System.in);
			 number=sc.nextLine();
		     if(number.matches("(0/91)?[6-9][0-9]{9}")==false)
		     {
		    	 System.out.println("Please enter correct contact number");
		    	 flag=1;
		     }
			 
		 }while(flag==1);
		 
		 return number;
	 }
	 public String getnumber1()
	 {
		 String number;
		 int flag=0;
		 Scanner sc=new Scanner(System.in);
		 number=sc.nextLine();
		 if(number.isEmpty())
		 {
			 return number;
		 }
		 else
		 {
				 do
				 {
					 flag=0;
				     if(number.matches("(0/91)?[6-9][0-9]{9}")==false)
				     {
				    	 System.out.println("Please enter correct contact number");
				    	 flag=1;
				     }
					 
				 }while(flag==1);
				 return number;
		 }
	 }
	 public String getemail()
	 {
		 int flag;
		 String email;
		 do
		 {
			 flag=0;
			 Scanner sc=new Scanner(System.in);
			 email=sc.nextLine();
		     if(email.matches( "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")==false)
		     {
		    	 System.out.println("Please enter correct email address");
		    	 flag=1;
		     }
			 
		 }while(flag==1);
		 
		 return email;
		 
	 }
	 public String getemail1()
	 {
		 int flag;
		 String email;
		 Scanner sc=new Scanner(System.in);
		 email=sc.nextLine();
		 if(email.isEmpty())
		 {
			 return email;
		 }
		 else {
			 do
			 {
				 flag=0;
			     if(email.matches( "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")==false)
			     {
			    	 System.out.println("Please enter correct email address");
			    	 flag=1;
			     }
				 
			 } while(flag==1);
			 
			 return email;
		 }
	 }
	 public int exitsign()
	 {
		 System.out.println("If u want to continue press 0  , else any other key for going one step back");
		 Scanner sc=new Scanner(System.in);
		 int sign=sc.nextInt();
		 return sign;
	 }
    

}
