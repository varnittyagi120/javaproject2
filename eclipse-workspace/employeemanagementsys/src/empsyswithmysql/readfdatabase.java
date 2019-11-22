package empsyswithmysql;
import java.sql.*;
import java.util.*;
import java.io.*;
public class readfdatabase
{

	public static void main(String[] args) 
	{
         try
         {
        	 String fname="raghav";
        	 int salary=20000;
        	 String uuid="f76a74ae-83b6-389c-82ca-8ac0b9febd33";
        	 
 		   /* System.out.println(String.format("%s", "-------------------------------------------------------------------------------------------------------------------------------"));
 	        System.out.println(String.format("%1s %20s %10s %20s %10s %20s %10s %20s %10s","|","First Name", "|", "Last Name", "|", "Mobile Number","|","E-mail","|"));
 		    while(rs.next())
 		    {    
 		        System.out.println(String.format("%s", "-------------------------------------------------------------------------------------------------------------------------------"));
 		        System.out.println(String.format("%1s %20s %10s %20s %10s %20s %10s %20s %10s","|",rs.getString(1), "|",rs.getString(2), "|",rs.getString(3),"|",rs.getString(4),"|"));   
 		    }
 	        System.out.println(String.format("%s", "-------------------------------------------------------------------------------------------------------------------------------"));
            */
         }
         catch(Exception e)
         {
        	 System.err.println("Got an Exception");
        	 System.err.println(e.getMessage());
         }
	}

}
