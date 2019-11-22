package dao;
import java.util.List;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.*;

public class DatabaseQueries<T>{

	Connection connection;

	public DatabaseQueries() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "newuser", "infoobjects");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addData(Map<String,String> map,String tableName){
	    int mapSize=map.size();
	    String parameterQuestionMark="?";
	    for(int i=0;i<mapSize-1;i++)
	    {
	    	parameterQuestionMark+=",?";
	    }
		try {
			String sql = "INSERT INTO "+ tableName +" VALUES("+ parameterQuestionMark +")";
			PreparedStatement statement = connection.prepareStatement(sql);
			int i=1;
			for(Map.Entry<String, String>entry:map.entrySet()){
			   statement.setString(i,entry.getValue());
			   i++;
			}
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
	
	public <T>  List<T> read(String uid,String tableName) {
		  List<T> listOfObject = new ArrayList<T>();
		  PreparedStatement preparedStatement = null;
		  ResultSet rs = null;
		  try {
			String sql = "Select * from "+ tableName +" WHERE id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, uid);
			rs = preparedStatement.executeQuery();
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			while(rs.next()){
				ArrayList<String> listOfColumns=new ArrayList<String>();
				for(int i=1;i<=rsmd.getColumnCount();i++){
					listOfColumns.add(rs.getString(i));
				}
			    listOfObject.add((T)listOfColumns);
			} 
		  } catch (Exception exception) {
			  exception.printStackTrace();
		  }
		  return listOfObject;
	}
	
	public List<T> readAll(String tableName) {
		  List<T> listOfObjects = new ArrayList<T>();
		  PreparedStatement preparedStatement = null;
		  ResultSet rs = null;
		  try {
			String sql = "Select * from "+ tableName;
			preparedStatement = connection.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			if(rs.next()==false){
				System.out.println("Result set is empty");
			} else {
					do{
						ArrayList<String> listOfColumns=new ArrayList<String>();
						for(int i=1;i<=rsmd.getColumnCount();i++){
							listOfColumns.add(rs.getString(i));
						}
						listOfObjects.add((T) listOfColumns);
					} while(rs.next());
			}
		  } catch (Exception exception) {
			  exception.printStackTrace();
		  }  
		  return listOfObjects;
	}
	public void deleteData(String uid,String tableName) {
		try{
			String sql = "DELETE FROM "+ tableName +" WHERE id=?";
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
	
	public List<T> checkUidExsist(String uid,String tableName){
	  List<T> listOfObject = new ArrayList<T>();
	  PreparedStatement preparedStatement = null;
	  ResultSet rs = null;
	  try {
		String sql = "Select * from "+ tableName +" WHERE id=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, uid);
		rs = preparedStatement.executeQuery();
		ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
		while(rs.next())
		{
			ArrayList<String> listOfColumns=new ArrayList<String>();
			for(int i=1;i<=rsmd.getColumnCount();i++){
				listOfColumns.add(rs.getString(i));
			}
		    listOfObject.add((T)listOfColumns);
		}
	  } catch (Exception exception) {
		  exception.printStackTrace();
	  }
	  return listOfObject;
	}
	
	public void updateData(String uid,Map<String, String> map,String tableName) {
		try {   
			String setParameter = "";
			int i=0;
			for(Map.Entry<String, String>entry:map.entrySet()){
				setParameter+=entry.getKey()+"=?";
				if(i!=map.size()-1) {
					setParameter+=",";
				}
				i++;
				}
			String sql = "UPDATE "+ tableName +" SET "+ setParameter +" WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			i=1;
			for(Map.Entry<String, String>entry:map.entrySet()){
			   statement.setString(i,entry.getValue());
			   i++;
			}
			statement.setString(i, uid);
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
                connection.close();
            }
        } catch(SQLException exception) {
            exception.printStackTrace();
        }
                 
    } 


}
