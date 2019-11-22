package empusingmongo;
import java.util.*;
import java.util.logging.Level;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.diagnostics.logging.Logger;

import empfinal.employee1;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class operation3 
{
	public int add()
	 {
		java.util.logging.Logger.getLogger("org.mongodb.driver").setLevel(Level.SEVERE);
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
		      MongoCollection collection =getconnection();
	          Document mickeyMouse = new Document();
	          mickeyMouse.append("fname",e.getfname())
	          .append("lname",e.getlname()).append("number",e.getnumber())
	          .append("email",e.getemail());
	          collection.insertOne(mickeyMouse);
	          System.out.println("Successfully inserted documents. \n");
			}
			catch(Exception ex)
			{
				System.err.println(ex.getMessage());
			}
		 return exitsign();
	 }
	public int read()
	{
		
		try
		{
		      MongoCollection<Document> collection=getconnection();
		      System.out.println("Enter uuid");
			  Scanner sc=new Scanner(System.in);
			  String str=sc.nextLine();
			  org.bson.types.ObjectId objectId =getid(str);
			  List<Document> documents = (List<Document>) collection.find().into(new ArrayList<Document>());
		      int flag=0;
	   		   // System.out.println(String.format("%s", "---------------------------------------------------------------------------------------------------------------------------------"));
	   	        //System.out.println(String.format("%1s %17s %20s %15s %2s %15s %5s %15s %5s %12s %12s","|","_id", "|", "First Name", "|", "Last Name","|","Mobile Number","|","E-mail","|"));

                     for(Document document : documents)
		               {
		            	 if(objectId.equals(document.getObjectId("_id")))
		            	 {
		       	   		  //    System.out.println(String.format("%s", "---------------------------------------------------------------------------------------------------------------------------------"));
		       	   	       //   System.out.println(String.format("%1s %15s %1s %12s %5s %12s %8s %12s %8s %15s %8s","|",document.getObjectId("_id"), "|",document.getString("fname"), "|",document.getString("lname"),"|",document.getString("number"),"|",document.getString("email"),"|"));                
		            		 System.out.println(String.format("%s", "---------------------------------------------------------------------------------------------------------------------------"));
		         	        System.out.println(String.format("%1s %15s %10s %15s %2s %15s %5s %15s %5s %12s %18s","|","UniqueID", "|", "First Name", "|", "Last Name","|","Mobile Number","|","E-mail","|"));
		         		    System.out.println(String.format("%s", "---------------------------------------------------------------------------------------------------------------------------"));
		         	        System.out.println(String.format("%1s %15s %1s %12s %5s %12s %8s %12s %8s %15s %5s","|",document.getObjectId("_id"), "|",document.getString("fname"), "|",document.getString("lname"),"|",document.getString("number"),"|",document.getString("email"),"|"));                
		         		    System.out.println(String.format("%s", "---------------------------------------------------------------------------------------------------------------------------")); 
		            		 flag=1;
		            	  }
		                }
     	   		    //System.out.println(String.format("%s", "---------------------------------------------------------------------------------------------------------------------------------"));

		            if(flag==0)
		            {
		            	System.out.println("Id not found");
		            }
		      
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		return exitsign();
	}
	public int readall()
	{
		
		try
		{
		      MongoCollection<Document> collection = getconnection();
		      List<Document> documents = (List<Document>) collection.find().into(new ArrayList<Document>());
		      int flag=0;
		      System.out.println(String.format("%s", "---------------------------------------------------------------------------------------------------------------------------"));
   	        System.out.println(String.format("%1s %15s %10s %15s %2s %15s %5s %15s %5s %12s %18s","|","UniqueID", "|", "First Name", "|", "Last Name","|","Mobile Number","|","E-mail",""));
                     for(Document document : documents)
		               {                
		            		
		         	        System.out.println(String.format("%s", "---------------------------------------------------------------------------------------------------------------------------"));
		         	        System.out.println(String.format("%1s %15s %1s %12s %5s %12s %8s %12s %8s %12s %18s","|",document.getObjectId("_id"), "|",document.getString("fname"), "|",document.getString("lname"),"|",document.getString("number"),"|",document.getString("email"),""));                		            	  
		                }

	         	        System.out.println(String.format("%s", "---------------------------------------------------------------------------------------------------------------------------"));
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		return exitsign();
	}
	public int update()
	{
        try
        {
        	MongoCollection<Document> collection=getconnection();
        	System.out.println("Enter uuid");
  		  Scanner sc=new Scanner(System.in);
  		  String str=sc.nextLine();
			  org.bson.types.ObjectId objectId =getid(str);
		      List<Document> documents = (List<Document>) collection.find().into(new ArrayList<Document>());
		      int flag=0;
                     for(Document document : documents)
		               {
		            	 if(objectId.equals(document.getObjectId("_id")))
		            	 {
		         		    //System.out.println(String.format("%1s %15s %1s %12s %5s %12s %8s %12s %8s %15s %5s","|",document.getObjectId("_id"), "|",document.getString("fname"), "|",document.getString("lname"),"|",document.getString("number"),"|",document.getString("email"),"|"));                
		         		    //System.out.println(String.format("%s", "---------------------------------------------------------------------------------------------------------------------------")); 
		            		 System.out.println("Your old first name "+document.getString("fname"));
		            	 	 System.out.println("Enter fname if u want to update else press enter");
		            	 	 String fname=getstring();
		                     if(getstring().isEmpty())
		                     {
		                     	fname=document.getString("fname");
		                     }
		 
		                     System.out.println("Your old last name "+document.getString("lname"));
		            	 		System.out.println("Enter last name if u want to update else press enter");
		            	 		String lname=getstring();
		                     if(lname.isEmpty())
		                     {
		                     	lname=document.getString("lname");
		                     }
		                     System.out.println("Your old Mobile Number "+document.getString("number"));
		            	 		System.out.println("Enter mobile number if u want to update else press enter");
		            	 		String number=getnumber();
		                     if(number.isEmpty())
		                     {
		                     	number=document.getString("number");
		                     }
		                     System.out.println("Your old email-id "+document.getString("email"));
		            	 		System.out.println("Enter email-id if u want to update else press enter");
		            	 		String email=getemail();
		                     if(email.isEmpty())
		                     {
		                     	email=document.getString("email");
		                     }
				            	updatequery(objectId,fname,lname,number,email);

		         		    flag=1;
		            	  }
		                }
		            if(flag==0)
		            {
		            	System.out.println("Id not found");
		            }
        	
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        }
		
		return exitsign();
	}
	public int delete1()
	{
		try
		{
			  MongoCollection<Document> collection=getconnection();
			  List<Document> documents = (List<Document>) collection.find().into(
		      new ArrayList<Document>());
			  System.out.println("Enter uuid");
			  Scanner sc=new Scanner(System.in);
			  String str=sc.nextLine();
			  org.bson.types.ObjectId objectId =getid(str);
		      int flag=0;         
              for(Document document : documents)
		      {
            	  
		          if(objectId.equals(document.getObjectId("_id")))
		            {
		        	  System.out.println("I am here");
		                 flag=1;
		            }
		       }
		            if(flag==0)
		            {
		            	System.out.println("Id not found");
		            }
		            else
		            {
		            	collection.deleteOne(new Document("_id",objectId));
		            	System.out.println("Data has successfully deleted");
		            }
		     /* MongoCollection<org.bson.Document> collection = database.getCollection("movie");
	          System.out.println(collection.find());
		      System.out.println("Credentials ::"+ credential);	*/
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		return exitsign();
	}
	public void updatequery(ObjectId objectid,String fname,String lname,String number,String email)
	{
		MongoCollection<Document> collection=getconnection();
		org.bson.types.ObjectId objfname=getid(fname);
		org.bson.types.ObjectId objlname=getid(lname);
		org.bson.types.ObjectId objnumber=getid(number);
		org.bson.types.ObjectId objemail=getid(email);
		Bson filter = new Document("_id",objectid);
		Bson newValue = new Document("fname",fname).append("lname",lname).append("number",number).append("email",email);      
		Bson updateOperationDocument = new Document("$set", newValue);
		collection.updateMany(filter, updateOperationDocument);
		System.out.println("data has been successfully updated");	
	}
	public MongoCollection<Document> getconnection()
	{
		 java.util.logging.Logger.getLogger("org.mongodb.driver").setLevel(Level.SEVERE);
		  MongoClient mongo = new MongoClient( "localhost" , 27017 );
	      System.out.println("Connected to the database successfully");  
	      MongoDatabase database = mongo.getDatabase("info"); 
	      MongoCollection<Document> collection = database.getCollection("employee");
		return collection;
	}
	public ObjectId getid(String str)
	{
		  org.bson.types.ObjectId objectId = new ObjectId(str);
		  System.out.println("id is : "+objectId.getClass().getName());
		  return objectId;
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
	public int exitsign()
	 {
		 System.out.println("If u want to continue press 0  , else any other key for going one step back");
		 Scanner sc=new Scanner(System.in);
		 int sign=sc.nextInt();
		 return sign;
	 }
}
