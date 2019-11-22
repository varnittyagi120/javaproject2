package empfinal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import empmanagementsys.employee;
public class operation1 
{
	//public Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/info","newuser","infoobjects");
	public int add()
	 {
		 employee1 e=new employee1();
		 System.out.println("Enter First name ");
		 e.setfname(getstring());
		 
		 System.out.println("Enter Last name ");
		 e.setlname(getstring());
		 
		 System.out.println("Enter Contact Number ");
		 e.setnumber(getnumber());

		 System.out.println("Enter Emailid");
		 e.setemail(getemail());
		 
		 String uniqueID = UUID.randomUUID().toString();
		 try
			{
					 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/info","newuser","infoobjects");
		        	 String sql = "INSERT INTO employee100 (id,fname,lname,number,email) VALUES(?,?,?,?,?)";
		        	 PreparedStatement statement = con.prepareStatement(sql);
		        	 statement.setString(1,uniqueID);
		        	 statement.setString(2,e.getfname());
		        	 statement.setString(3,e.getlname());
		        	 statement.setString(4,e.getnumber());
		        	 statement.setString(5,e.getemail());
		        	 int rowsInserted = statement.executeUpdate();
		        	 if (rowsInserted > 0) {
		        	     System.out.println("A new user was inserted successfully!");
		        	 }
			}
			catch(Exception ex)
			{
				System.err.println(ex.getMessage());
			}
		 return exitsign();
	 }
	public int read()
	{
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
		try
		{
			 
			String str=getuid();
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/info","newuser","infoobjects"); 
			String sql = "Select * from employee100 WHERE id=?";
			preparedStatement = con.prepareStatement(sql);
            // set values for PreparedStatement for respective ?
            preparedStatement.setString(1,str); // PLAYER_ID
 
            // Step 2.C: Executing SQL & retrieve data into ResultSet
            rs = preparedStatement.executeQuery();
 
            // processing returned data and printing into console
            if(rs.next()) 
            {
    		    System.out.println(String.format("%s", "---------------------------------------------------------------------------------------------------------------------------------"));
    	        System.out.println(String.format("%1s %17s %20s %15s %2s %15s %5s %15s %5s %12s %12s","|","UniqueID", "|", "First Name", "|", "Last Name","|","Mobile Number","|","E-mail","|"));
    		    System.out.println(String.format("%s", "---------------------------------------------------------------------------------------------------------------------------------"));
    	        System.out.println(String.format("%1s %15s %1s %12s %5s %12s %8s %12s %8s %15s %8s","|",rs.getString(1), "|",rs.getString(2), "|",rs.getString(3),"|",rs.getString(4),"|",rs.getString(5),"|"));                
    		    System.out.println(String.format("%s", "---------------------------------------------------------------------------------------------------------------------------------"));
            }
            else
            {
            	System.out.println("Desired entry not found please try again");
            }
		}
		catch(Exception e)
		{
			System.err.println("Got an exception");
			System.out.println(e.getMessage());
		}
		return exitsign();
	}
	public int readall()
	{
		try
		{
	    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/info","newuser","infoobjects");   
	        Statement stmt=con.createStatement();
	        ResultSet rs=stmt.executeQuery("select * from employee100");
		    System.out.println(String.format("%s", "---------------------------------------------------------------------------------------------------------------------------------"));
	        System.out.println(String.format("%1s %17s %20s %15s %2s %15s %5s %15s %5s %12s %12s","|","UniqueID", "|", "First Name", "|", "Last Name","|","Mobile Number","|","E-mail","|"));
		    while(rs.next())
		    {    
			    System.out.println(String.format("%s", "---------------------------------------------------------------------------------------------------------------------------------"));
		        System.out.println(String.format("%1s %15s %1s %12s %5s %12s %8s %12s %8s %15s %8s","|",rs.getString(1), "|",rs.getString(2), "|",rs.getString(3),"|",rs.getString(4),"|",rs.getString(5),"|"));   
		    }
		    System.out.println(String.format("%s", "---------------------------------------------------------------------------------------------------------------------------------"));
		}
		catch(Exception e)
		{
			System.out.println("Got an exception");
			System.out.println(e.getMessage());
		}
	        return exitsign();
	}
	public int update()
	{
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
		try
		{
			String uid=getuid();
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/info","newuser","infoobjects"); 
			String sql = "Select * from employee100 WHERE id=?";
			preparedStatement = con.prepareStatement(sql);
            // set values for PreparedStatement for respective ?
            preparedStatement.setString(1,uid); // PLAYER_ID
 
            // Step 2.C: Executing SQL & retrieve data into ResultSet
            rs = preparedStatement.executeQuery();
 
            // processing returned data and printing into console
            if(rs.next()) 
            {
            	int exitsign=1;
  			  do
  			  {
  				 
  				  System.out.println("##########################");
  				  System.out.println("||     1.FIRST NAME     ||");
  				  System.out.println("||     2.LAST NAME      ||");
  				  System.out.println("||     3.MOBILE NUMBER  ||");
  				  System.out.println("||     4.EMAIL          ||");
  				  System.out.println("##########################");
  				  System.out.println("Enter your choice");
  				  Scanner sc=new Scanner(System.in);
  				  int ch=sc.nextInt();
  				  switch(ch)
  				  {
       				  case 1:
       				        {
  			                     exitsign=updatefname(rs.getString(2),uid);  	 	         
  					             break;
       				        }
       				  case 2:
       				        {
  			                     exitsign=updatelname(rs.getString(3),uid);  	 	         
                                 break;
       				        }
       				  case 3:
       				        {
       				        	exitsign=updatenumber(rs.getString(4),uid);  	 	         
                                break;
       				        }
       				  case 4:
       				        {
       				        	exitsign=updateemail(rs.getString(5),uid);  	 	         
                                break;
       				        }
       				  default:
       				        {
       				        	System.out.println("Please Choose from above options");
  					        	long start = System.currentTimeMillis();
  					            Thread.sleep(2000);
       				        	exitsign=exitsign();
  					  		    break;
       				        }
       					     
  				  }
  				  
  			  }while(exitsign==0);
            }
            else
            {
            	System.out.println("Desired entry not found please try again");
            }
			
		}
		catch(Exception e)
		{
			 System.out.println("Got an exception");
			 System.out.println(e.getMessage());
		}
		return exitsign();
	}
	public int delete1()
	{
		try
		{
			 String uid=getuid();
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/info","newuser","infoobjects");
			 String sql = "DELETE FROM employee100 WHERE id=?";
			 PreparedStatement statement = con.prepareStatement(sql);
			 statement.setString(1,uid);
			  
			 int rowsDeleted = statement.executeUpdate();
			 if (rowsDeleted > 0) {
			     System.out.println("Desired entry has been successfully deleted");
			 }
			 else
			 {
				 System.out.println("Desired entry not found");
			 }
			 
		}
		catch(Exception e)
		{
			System.err.println("Got an exception");
			System.out.println(e.getMessage());
		}
		return exitsign();
	}
	public String getstring()
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
	 public String getuid()
	 {
		    System.out.println("Enter uuid");
			Scanner sc=new Scanner(System.in);
			String str=sc.nextLine();
			return str;
	 }
	 public int updatefname(String fname,String uid)
	 {
		 try
		 {
			 System.out.println("Your old first name "+fname);
			 System.out.println("Enter new first name ");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/info","newuser","infoobjects");
			 String sql = "UPDATE employee100 set fname=? WHERE id=?";
			 PreparedStatement statement = con.prepareStatement(sql);
			 statement.setString(1,getstring());
			 statement.setString(2,uid);
			 int rowsUpdated = statement.executeUpdate();
			 if (rowsUpdated > 0) {
			     System.out.println("first name has been successfully updated");
			 }
			 
		 }
		 catch(Exception e)
		 {
			 System.out.println("Got an exception");
			 System.out.println(e.getMessage());
		 }
		 return exitsign();
	 }
	 public int updatelname(String lname,String uid)
	 {
		 try
		 {
			 System.out.println("Your old last name "+lname);
			 System.out.println("Enter new last name ");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/info","newuser","infoobjects");
			 String sql = "UPDATE employee100 set lname=? WHERE id=?";
			 PreparedStatement statement = con.prepareStatement(sql);
			 statement.setString(1,getstring());
			 statement.setString(2,uid);
			 int rowsUpdated = statement.executeUpdate();
			 if (rowsUpdated > 0) {
			     System.out.println("last name has been successfully updated");
			 }
			 
		 }
		 catch(Exception e)
		 {
			 System.out.println("Got an exception");
			 System.out.println(e.getMessage());
		 }
		 return exitsign();
	 }
	 public int updatenumber(String number,String uid)
	 {
		 try
		 {
			 System.out.println("Your old Mobile Number "+number);
			 System.out.println("Enter new mobile number ");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/info","newuser","infoobjects");
			 String sql = "UPDATE employee100 set number=? WHERE id=?";
			 PreparedStatement statement = con.prepareStatement(sql);
			 statement.setString(1,getnumber());
			 statement.setString(2,uid);
			 int rowsUpdated = statement.executeUpdate();
			 if (rowsUpdated > 0) {
			     System.out.println("Mobile Number has been successfully updated");
			 }
			 
		 }
		 catch(Exception e)
		 {
			 System.out.println("Got an exception");
			 System.out.println(e.getMessage());
		 }
		 return exitsign();
	 }
	 public int updateemail(String email,String uid)
	 {
		 try
		 {
			 System.out.println("Your old email-id "+email);
			 System.out.println("Enter new email-id ");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/info","newuser","infoobjects");
			 String sql = "UPDATE employee100 set email=? WHERE id=?";
			 PreparedStatement statement = con.prepareStatement(sql);
			 statement.setString(1,getemail());
			 statement.setString(2,uid);
			 int rowsUpdated = statement.executeUpdate();
			 if (rowsUpdated > 0) {
			     System.out.println("Email-id has been successfully updated");
			 }
			 
		 }
		 catch(Exception e)
		 {
			 System.out.println("Got an exception");
			 System.out.println(e.getMessage());
		 }
		 return exitsign();
	 }
	 public int exitsign()
	 {
		 System.out.println("If u want to continue press 0  , else any other key for going one step back");
		 Scanner sc=new Scanner(System.in);
		 int sign=sc.nextInt();
		 return sign;
	 }
	 
}
