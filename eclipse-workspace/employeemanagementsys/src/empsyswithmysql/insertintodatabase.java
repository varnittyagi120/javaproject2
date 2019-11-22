package empsyswithmysql;
import java.sql.*;
import java.util.*;
import java.io.*;
public class insertintodatabase
{

	public static void insertion()
	{
		//Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/info","newuser","infoobjects"); 
       // Statement stmt=conn.createStatement();
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/info","newuser","infoobjects");   
		    Statement stmt=con.createStatement();      	 
		    String sql1="insert into studentoo values(1,'varnit','tyagi',100)";
		    stmt.executeUpdate(sql1);
		    System.out.println("Data has been inserted into the table");
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
	public static void read()
	{
		//Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/info","newuser","infoobjects"); 
       // Statement stmt=conn.createStatement();
		try
		{
			System.out.println("I am inside");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/info","newuser","infoobjects");   
		    Statement stmt=con.createStatement();
		    ResultSet rs=stmt.executeQuery("select * from studentoo where id=1");
		    if(rs.next())
		    {
		        System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
		    }
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
	public static int exitsign()
	{
		System.out.println("If u want to continue press 0 else any other key for going one step back");
		Scanner sc=new Scanner(System.in);
		int exitsign=sc.nextInt();
        return exitsign;		
		
	}
	public static void main(String[] args)
	{
	   int sign=1;
	   do
	   {
		try
		{
		    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/info","newuser","infoobjects"); 
            Statement stmt=conn.createStatement();
            String sql="create table IF NOT EXISTS  studentoo(id int(30),fname varchar(20),lname varchar(20),rollno int(10))";
            stmt.executeUpdate(sql);
            System.out.println("table has been successfully created");
            System.out.println("Choose one for insert");
            System.out.println("choose two for read");
            Scanner sc=new Scanner(System.in);
            int ch=sc.nextInt();
            switch(ch)
            {
            case 1:
                  insertion();
                  sign=exitsign();
                  break;
            case 2:
            	  read();
            	  sign=exitsign();
            	  break;
            default:
            	  System.out.println("Enter correct option");
            }
		}
		catch(Exception e)
		{
			System.err.println("Got an exception");
			System.err.println(e.getMessage());
		}
	   }while(sign==0);
	}
	

}
