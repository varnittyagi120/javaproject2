package management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class EmpDao {
	Connection connection=null;
	public EmpDao() {
		try {
	    	Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "newuser", "infoobjects");
			
			System.out.println("connection has established");
		} catch (Exception exception) {
			System.out.println("here1");
			exception.printStackTrace();
		}
	}
	
	public int addition(Employee employee) {
		int status = 0;
        try {
        	System.out.println("i am in addition");
        	System.out.println(employee.getCountry());
        	System.out.println(employee.getEmail());
        	System.out.println(employee.getFname());
        	System.out.println(employee.getLname());
        	System.out.println(employee.getPassword());
        	PreparedStatement ps=connection.prepareStatement(  
                    "insert into emplyeelist(fname,lname,password,email,country) values (?,?,?,?,?)");
        	 ps.setString(1,employee.getFname());  
             ps.setString(2,employee.getLname());  
             ps.setString(3,employee.getPassword());  
             ps.setString(4,employee.getEmail());
             ps.setString(5,employee.getCountry());
             status = ps.executeUpdate();
        }catch(Exception exception) {
        	exception.printStackTrace();
        	System.out.println("here2");
        }
		return status;
	}
	
	public void finalize() throws Throwable {
        try{
            if(connection!=null) {
                connection.close();
            }
        } catch(SQLException exception) {
            exception.printStackTrace();
        }
                 
    }

}
