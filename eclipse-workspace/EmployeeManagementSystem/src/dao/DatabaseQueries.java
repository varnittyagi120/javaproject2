package dao;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.*;
import dto.Employee;

public class DatabaseQueries{

	Connection connection;

	public DatabaseQueries() {
		try {
			System.out.println("Connection open");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "newuser", "infoobjects");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addData(Employee employee,String tableName){
	    createTable();	
		try {
			String parametermark="?,?,?,?,?,?,?";
			String sql = "INSERT INTO "+ tableName +" VALUES("+ parametermark +")";
		//	String sql = "INSERT INTO "+ tableName +" VALUES(?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, employee.getUid());
			statement.setString(2, employee.getFname());
			statement.setString(3, employee.getLname());
			statement.setString(4, employee.getNumber());
			statement.setString(5, employee.getEmail());
			statement.setString(6, "12-04-1996");
			statement.setDouble(7, 1000.50);
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Desired entry has been successfully inserted!");
			}
		} catch (Exception exception) {
			System.err.println("Got an Exception "+exception.getMessage());
		}
		/*finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
	}
	
	public  List<Employee> readEmployee(String uid) {
		  List<Employee> list = new ArrayList<Employee>();
		  PreparedStatement preparedStatement = null;
		  ResultSet rs = null;
		  try {
			String sql = "Select * from employee100 WHERE id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, uid);
			rs = preparedStatement.executeQuery();
			while(rs.next()){
					Employee employee = new Employee();
					employee.setFname(rs.getString(2));
					employee.setLname(rs.getString(3));
					employee.setNumber(rs.getString(4));
					employee.setEmail(rs.getString(5));
					employee.setUid(rs.getString(1));
					list.add(employee);
			} 
		  } catch (Exception exception) {
			  exception.printStackTrace();
		  }
		  return list;
	}
	
	public List<Employee> readAllEmployees() {
		  List<Employee> list = new ArrayList<Employee>();
		  PreparedStatement preparedStatement = null;
		  ResultSet rs = null;
		  try {
			String sql = "Select * from employee100";
			preparedStatement = connection.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			if(rs.next()==false){
				System.out.println("Result set is empty");
			} else {
					do{
						Employee employee = new Employee();
						employee.setFname(rs.getString(2));
						employee.setLname(rs.getString(3));
						employee.setNumber(rs.getString(4));
						employee.setEmail(rs.getString(5));
						employee.setUid(rs.getString(1));
						list.add(employee);
					} while(rs.next());
			}
		  } catch (Exception exception) {
			  exception.printStackTrace();
		  }  
		  return list;
	}
	public void deleteData(String uid) {
		try{
			String sql = "DELETE FROM employee100 WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, uid);

			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Desired entry has been successfully deleted");
			} else {
				System.out.println("Desired entry not found");
			}

		} catch (Exception exception) {
			System.out.println("Got an exception "+exception.getMessage());
		}
	}
	
	public List<Employee> checkUidExsist(String uid){
		
	  List<Employee> list = new ArrayList<Employee>();
	  PreparedStatement preparedStatement = null;
	  ResultSet rs = null;
	  try {
		String sql = "Select * from employee100 WHERE id=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, uid);
		rs = preparedStatement.executeQuery();
		while(rs.next())
		{
			Employee employee=new Employee();
			employee.setFname(rs.getString(2));
			employee.setLname(rs.getString(3));
			employee.setNumber(rs.getString(4));
			employee.setEmail(rs.getString(5));
			list.add(employee);
		}
	  } catch (Exception exception) {
		  exception.printStackTrace();
	  }
	  return list;
	}
	
	public void updateData(String uid,Employee employee) {
		try
		{
			String sql = "UPDATE employee100 SET fname=?,lname=?,number=?,email=? WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, employee.getFname());
			statement.setString(2, employee.getLname());
			statement.setString(3, employee.getNumber());
			statement.setString(4, employee.getEmail());
			statement.setString(5, uid);
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An existing user has updated successfully!");
			}
		} catch (Exception exception) {
			System.out.println("Got an Exception "+exception.getMessage());
		}
	}
	
	public void createTable() {
	    	try {
					Statement stmt = connection.createStatement();
			        String sql = "create table IF NOT EXISTS  employee100(id varchar(50),fname varchar(20),lname varchar(20),number varchar(20),email varchar(30))";
			        stmt.executeUpdate(sql);
			} catch (Exception exception) {
	             System.err.println("Got an exception "+exception.getMessage());
			}
	 }
	public void finalize() throws Throwable {
        try{
            if(connection!=null) {
            	System.out.println("connection close");
                connection.close();
            }
        } catch(SQLException exception) {
            exception.printStackTrace();
        }
                 
    } 

}
