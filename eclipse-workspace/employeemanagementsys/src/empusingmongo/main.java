package empusingmongo;
import java.util.*;

import empfinal.operation2;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class main 
{

	public static void main(String[] args) 
	{
		try
		{
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/info","newuser","infoobjects"); 
		        Statement stmt=conn.createStatement();
		        String sql="create table IF NOT EXISTS  employee100(id varchar(50),fname varchar(20),lname varchar(20),number varchar(20),email varchar(30))";
		        stmt.executeUpdate(sql);
		}
		catch(Exception e)
		{
             System.err.println("Got an exception");
             System.err.println(e.getMessage());
		}
		int sign=1;
		int flag;
	    operation3 obj=new operation3();
		do
		{
			System.out.println("##########################################");
			System.out.println("||        Enter 1 for Add an entry      ||");
			System.out.println("||        Enter 2 for Read an entry     ||");
			System.out.println("||        Enter 3 view all entries      ||");
			System.out.println("||        Enter 4 for Update an entry   ||");
			System.out.println("||        Enter 5 for Delete an entry   ||");
			System.out.println("##########################################");
			int choice;
	            System.out.println("Enter Your Choice");
		  	try
		  	{   
		  		flag=0;
		  		Scanner sc=new Scanner(System.in);
		  	    choice=sc.nextInt();
		  	    switch(choice)
			  	{
			  	    case 1:
			  	    	 sign=obj.add();
			  		     break;
			  	    case 2:
			  	         sign=obj.read();
			  	    	 break;
			  	    case 3:
			  	    	 sign=obj.readall();
			  	    	 break;
			  	    case 4:
			  	    //	sign=obj.update();
			  	    	break;
			  	    case 5:
			  	    	sign=obj.delete1();
			  	        break;
			        default:
			        	System.out.println("Please Choose from above five options");
			        	flag=1;
			        	long start = System.currentTimeMillis();
			            Thread.sleep(2000);
			  		    break;
			  	}
		  	}
		  	catch(Exception e)
		  	{
		  		System.out.println("Error : Enter only integer ");
		  		flag=1;
		  	}	   
			
		}while(flag==1||sign==0);
        System.out.println("Your program has been successfully terminated..........");


	}

}
