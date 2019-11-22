package varnit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertIntoDB {
	 Connection connection = null;
	 public InsertIntoDB() throws ClassNotFoundException {
		    try {
		    	Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "newuser", "infoobjects");
				System.out.println("connection has established");
			} catch (SQLException e) {
				System.out.println("here1");
				e.printStackTrace();
			}
	 }
	 public void insert() {
		 int status=0;
		 try {
			 PreparedStatement ps=connection.prepareStatement(  
	                 "insert into emplyeelist(fname,lname,password,email,country) values (?,?,?,?,?)");
	     	 ps.setString(1, "raghav");  
	          ps.setString(2,"singhal");  
	          ps.setString(3,"raghav@13");  
	          ps.setString(4,"raghav@gmail.com");
	          ps.setString(5,"India");
              status = ps.executeUpdate();
              if(status>0) {
            	  System.out.println("data successfully entered");
              }else {
            	  System.out.println("problem occurred");
              }
		 }catch(Exception exception) {
			 exception.printStackTrace();
		 }
	 }
	 
}
