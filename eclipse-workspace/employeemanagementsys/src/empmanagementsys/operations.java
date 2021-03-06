package empmanagementsys;
import java.util.*;
import java.util.Map.Entry;
import java.io.*;
public class operations 
{
 Map<String,employee> map = new HashMap<String,employee>();
	 
	 public void add(){
		 employee emplpoyee= new employee();
		 System.out.println("Enter First name ");
		 employee.setfname(getString());
		 
		 System.out.println("Enter Last name ");
		 employee.setlname(getString());
		 
		 System.out.println("Enter Contact Number ");
		 employee.setnumber(getNumber());

		 System.out.println("Enter Emailid");
		 employee.setemail(getEmail());
		 
		 String uniqueID = UUID.randomUUID().toString();
		 System.out.println("Data has been successfully inserted");
		 System.out.println("Your uuid is "+uniqueID);
		 map.put(uniqueID,employee);
	 }
	 
	  public void read() {
		 System.out.println("Enter uniqueId");
		 Scanner scanner = new Scanner(System.in);
		 String uid = scanner.nextLine();
         int flag = 0;
         System.out.println(String.format("%s", "---------------------------------------------------------------------------------------------------------------------------------"));
	     System.out.println(String.format("%1s %17s %20s %15s %2s %15s %5s %15s %5s %12s %12s","|","UniqueID", "|", "First Name", "|", "Last Name","|","Mobile Number","|","E-mail","|"));   
	     for (Map.Entry<String,employee> entry:map.entrySet()) { 
		        String key = entry.getKey();  
		        employee b = entry.getValue();
		        if(uid.equals(key)){ 
		        	flag=1;
		        	System.out.println(String.format("%s", "---------------------------------------------------------------------------------------------------------------------------------"));
		   	        System.out.println(String.format("%1s %15s %1s %12s %5s %12s %8s %12s %8s %15s %8s","|",uid, "|",b.fname, "|",b.lname,"|",b.number,"|",b.email,"|"));                		          
		        }
		 }  
		 System.out.println(String.format("%s", "---------------------------------------------------------------------------------------------------------------------------------"));
		 if(flag==0)	{
			System.out.println("Desired entry doesn't exsist");
		 }

	 }
	 
	 public void readall() {   
		 System.out.println(String.format("%s", "---------------------------------------------------------------------------------------------------------------------------------"));
	     System.out.println(String.format("%1s %17s %20s %15s %2s %15s %5s %15s %5s %12s %12s","|","UniqueID", "|", "First Name", "|", "Last Name","|","Mobile Number","|","E-mail","|")); 
	     for (Map.Entry<String,employee> entry:map.entrySet()) {    
		        String key = entry.getKey();  
		        employee b = entry.getValue();
		        System.out.println(String.format("%s", "---------------------------------------------------------------------------------------------------------------------------------"));
	   	        System.out.println(String.format("%1s %15s %1s %12s %5s %12s %8s %12s %8s %15s %8s","|",key, "|",b.fname, "|",b.lname,"|",b.number,"|",b.email,"|"));                	          
		 }
		 System.out.println(String.format("%s", "---------------------------------------------------------------------------------------------------------------------------------"));

	 }
	 
	 public void update() throws InterruptedException {
		 System.out.println("Enter uuid of employee for which u want to update ");
		 Scanner scanner = new Scanner(System.in);
		 String uid = scanner.nextLine();
		 int flag = 0;
		 for(Map.Entry<String,employee>entry:map.entrySet()) {
			 String key = entry.getKey();
			 employee employee = entry.getValue();
			 if(uid.equals(key))
			 {
				 flag = 1;
				 System.out.println("Old first name "+employee.fname);
			     System.out.println("Enter new first name if u want to update else press enter ");
			     String fname = getString1();
			     if(fname.isEmpty()){   
			         fname = employee.fname;
			     }
			     employee.setfname(fname);
			     System.out.println("Old last name "+employee.lname);
		         System.out.println("Enter new last name if u want to update else press enter");
		         String lname = getString1();
		         if(lname.isEmpty()) {
		         	lname = employee.lname;
		         }
		         employee.setlname(lname);
		         System.out.println("Old last mobile number "+employee.number);
		         System.out.println("Enter new mobile number if u want to update else press enter");
		         String number = getNumber1();
		         if(number.isEmpty()) {
		         	number = employee.number;
		         }
		         employee.setnumber(number);
		         System.out.println("Old email id "+employee.email);
		         System.out.println("Enter new email id if u want to update else press enter");
		         String email = getEmail1();
		         if(email.isEmpty()) {
		         	email=employee.email;
		         }
		         employee.setemail(email);
		         updateQuery(uid,employee);
		         //map.replace(uid,employee);
				 System.out.println("Desired entry has been successfully updated");
			 }
	
		 }
		 if(flag==0)
		 {
			 System.out.println("Desired Entry does not exsist");
		 }
	 }
	 
	 public void delete() {
		  int flag = 0;
		  System.out.println("Enter uniqueId for deletion");
		  Scanner scanner = new Scanner(System.in);
	      String uid = scanner.nextLine();
		  for (Map.Entry<String,employee> entry:map.entrySet()) { 
				        String key = entry.getKey();  
				        employee b = entry.getValue();
				        if(uid.equals(key)){ 
				        	flag = 1;
				        	map.remove(uid);
				        	System.out.println("Desired entry has been successfully deleted");
				        }
		  }  
		  if(flag==0)
		  {
			 System.out.println("Desired entry doesn't exsist");
				
		  }
	 }
	 
	 public void updateQuery(String uid,employee employee)
	 {
		 map.replace(uid,employee);
	 }
	 public String getString(){
		 int flag,f;
		 String str;
		 do {
			 flag = 1;
			 f = 1;
			 Scanner scanner = new Scanner(System.in);
			 str = scanner.nextLine();
			 if(str.isEmpty()){
				 f = 0;
			 }
			 try{
				 int no = Integer.parseInt(str);
			 } catch(Exception e) {
				  flag = 0;
			   }
			 if(flag==1) {
				 System.out.println("Please enter correct name");
			 }
			 if(f==0) {
				 System.out.println("required");
			 }
			
		 } while(flag==1||f==0);
		 
		 return str;
	 }
	 public String getString1() {
		 int flag;
		 String str;
		 do {
			 flag = 1;
			 Scanner scanner = new Scanner(System.in);
			 str = scanner.nextLine();
			 try {
				 int no = Integer.parseInt(str);
			 } catch(Exception e) {
				 flag=0;
			   }
			 if(flag==1){
				 System.out.println("Please enter correct name");
			 }
			
		 } while(flag==1);
		 
		 return str;
	 }
	 public String getNumber() {
		 String number;
		 int flag = 0;
		 do
		 {
			 flag = 0;
			 Scanner scanner = new Scanner(System.in);
			 number = scanner.nextLine();
		     if(number.matches("(0/91)?[6-9][0-9]{9}")==false) {
		    	 System.out.println("Please enter correct contact number");
		    	 flag = 1;
		     }
			 
		 } while(flag==1);
		 
		 return number;
	 }
	 
	 public String getNumber1() {
		 String number;
		 int flag = 0;
		 Scanner scanner = new Scanner(System.in);
		 number = scanner.nextLine();
		 if(number.isEmpty()){
			 
			 return number;
		 } else {
				  do {
					   flag=0;
				       if(number.matches("(0/91)?[6-9][0-9]{9}")==false) {
				    	   System.out.println("Please enter correct contact number");
				    	   flag=1;
				        }
					 
				     } while(flag==1);
				    return number;
		 }
	 }
	 public String getEmail() {
		 int flag;
		 String email;
		 do {
			 flag = 0;
			 Scanner scanner = new Scanner(System.in);
			 email = scanner.nextLine();
		     if(email.matches( "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")==false) {
		    	 System.out.println("Please enter correct email address");
		    	 flag = 1;
		     }
			 
		 } while(flag==1);
		 
		 return email;
	 }
	 public String getEmail1() {
		 int flag;
		 String email;
		 Scanner scanner = new Scanner(System.in);
		 email = scanner.nextLine();
		 if(email.isEmpty()) {
			 return email;
		 } else {
			 do {
				 flag=0;
			     if(email.matches( "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")==false) {
			    	 System.out.println("Please enter correct email address");
			    	 flag=1;
			     }
				 
			  } while(flag==1);
			 
			 return email;
		 }
	 }
	 
}