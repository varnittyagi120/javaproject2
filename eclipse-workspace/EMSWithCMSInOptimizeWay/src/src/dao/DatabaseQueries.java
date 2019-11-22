package src.dao;

import java.util.List;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import src.dto.Person;
import src.util.Utility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;

public class DatabaseQueries<T extends Person> extends Utility {

	Connection connection;

	public DatabaseQueries() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "newuser", "infoobjects");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public <T1,T2> void addData(Map<T1, T2> map, T object) {
		int mapSize = map.size();
		StringBuilder parameterQuestionMark = new StringBuilder(mapSize);
		parameterQuestionMark.append("?");
		for (int i = 0; i < mapSize - 1; i++) {
			parameterQuestionMark.append(",?");
		}
		String tableName = getTableName(object.getClass().getName());
		try {
			String sql = "INSERT INTO " + tableName + " VALUES(" + parameterQuestionMark + ")";
			PreparedStatement statement = connection.prepareStatement(sql);
			int i = 1;
			for (Map.Entry<T1, T2> entry : map.entrySet()) {
				if (entry.getValue().getClass().getSimpleName().equals("String")) {
					statement.setString(i, (String) entry.getValue());
				} else if (entry.getValue().getClass().getSimpleName().equals("Integer")) {
					statement.setInt(i, (Integer) entry.getValue());
				}
				i++;
			}
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Desired entry has been successfully inserted!");
			}
		} catch (Exception exception) {
			System.err.println("Got an Exception " + exception.getMessage());
		}

	}
	/*public void addData(Map<T,T> map, T object) {
		int mapSize = map.size();
		StringBuilder parameterQuestionMark = new StringBuilder(mapSize);
		parameterQuestionMark.append("?");
		for (int i = 0; i < mapSize - 1; i++) {
			parameterQuestionMark.append(",?");
		}
		String tableName = getTableName(object.getClass().getName());
		try {
			String sql = "INSERT INTO " + tableName + " VALUES(" + parameterQuestionMark + ")";
			PreparedStatement statement = connection.prepareStatement(sql);
			int i = 1;
			for (Map.Entry<T,T> entry : map.entrySet()) {
				if (entry.getValue().getClass().getSimpleName().equals("String")) {
					statement.setString(i, entry.getValue().toString());
				} else if (entry.getValue().getClass().getSimpleName().equals("Integer")) {
					statement.setString(i,entry.getValue().toString());
				}
				i++;
			}
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Desired entry has been successfully inserted!");
			}
		} catch (Exception exception) {
			System.err.println("Got an Exception " + exception.getMessage());
		}

	}*/

	public List<List<String>> readData(String uid, T object) {

		List<List<String>> listOfObject = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			String tableName = getTableName(object.getClass().getName());
			String sql = "Select * from " + tableName + " WHERE id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, uid);
			rs = preparedStatement.executeQuery();
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			while (rs.next()) {
				ArrayList<String> listOfColumns = new ArrayList<String>();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					listOfColumns.add(rs.getString(i));
				}
				listOfObject.add(listOfColumns);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return listOfObject;
	}
	/*public List<List<T>> readData(String uid, T object) {

		List<List<T>> listOfObject = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			String tableName = getTableName(object.getClass().getName());
			String sql = "Select * from " + tableName + " WHERE id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, uid);
			rs = preparedStatement.executeQuery();
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			while (rs.next()) {
				List<String> listOfColumns = new ArrayList<>();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					listOfColumns.add(rs.getString(i));
				}
				List<T> list = new ArrayList<>();
				for(String e:listOfColumns) {
					list.add((T)e);
				}
				listOfObject.add(list);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return listOfObject;
	}*/
  
	public List<List<String>> readAllData(T object) {
		List<List<String>> listOfObjects = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		try {
			String tableName = getTableName(object.getClass().getName());
			String sql = "Select * from " + tableName;
			preparedStatement = connection.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();

			if (rs.next() == false) {
				System.out.println("Result set is empty");
			} else {
				do {
					List<String> listOfColumns = new ArrayList<String>();
					for (int i = 1; i <= rsmd.getColumnCount(); i++) {
						listOfColumns.add(rs.getString(i));
					}
					listOfObjects.add(listOfColumns);
				} while (rs.next());
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return listOfObjects;
	}/*
	public List<List<T>> readAllData(T object) {
		List<List<T>> listOfObjects = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		try {
			String tableName = getTableName(object.getClass().getName());
			String sql = "Select * from " + tableName;
			preparedStatement = connection.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();

			if (rs.next() == false) {
				System.out.println("Result set is empty");
			} else {
				do {
					List<T> listOfColumns = new ArrayList<>();
					for (int i = 1; i <= rsmd.getColumnCount(); i++) {
						listOfColumns.add(rs.getString(i));
					}
					listOfObjects.add(listOfColumns);
				} while (rs.next());
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return listOfObjects;
	}
*/
	public void deleteData(String uid, T object) {
		try {

			String tableName = getTableName(object.getClass().getName());
			String sql = "DELETE FROM " + tableName + " WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, uid);

			int rowsDeleted = statement.executeUpdate();
			String message = (rowsDeleted > 0) ? "Desired entry has been successfully deleted"
					: "Desired entry not found";
			System.out.println(message);
		} catch (Exception exception) {
			System.out.println("Got an exception " + exception.getMessage());
		}
	}

	public List<List<String>> checkUidExsist(String uid, T object) {
		List<List<String>> listOfObject = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			String tableName = getTableName(object.getClass().getName());
			String sql = "Select * from " + tableName + " WHERE id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, uid);
			rs = preparedStatement.executeQuery();
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			while (rs.next()) {
				ArrayList<String> listOfColumns = new ArrayList<String>();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					listOfColumns.add(rs.getString(i));
				}
				listOfObject.add(listOfColumns);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return listOfObject;

	}

	public void updateData(String uid, Map<String, String> map, T object) {
		try {
			StringBuilder setParameter = new StringBuilder(map.size());
			int i = 0;
			for (Map.Entry<String, String> entry : map.entrySet()) {
				setParameter.append(entry.getKey());
				setParameter.append("=?");
				if (i != map.size() - 1) {
					setParameter.append(",");
				}
				i++;
			}
			String tableName = getTableName(object.getClass().getName());
			String sql = "UPDATE " + tableName + " SET " + setParameter + " WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			i = 1;
			for (Map.Entry<String, String> entry : map.entrySet()) {
				statement.setString(i, entry.getValue());
				i++;
			}
			statement.setString(i, uid);
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An existing user has updated successfully!");
			}
		} catch (Exception exception) {
			System.out.println("Got an Exception " + exception.getMessage());
		}

	}

	/*
	 * public void createTable() { try { Statement stmt =
	 * connection.createStatement(); String sql =
	 * "create table IF NOT EXISTS  employee100(id varchar(50),fname varchar(20),lname varchar(20),number varchar(20),email varchar(30))"
	 * ; stmt.executeUpdate(sql); } catch (Exception exception) {
	 * System.err.println("Got an exception " + exception.getMessage()); } }
	 */

	public void finalize() throws Throwable {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		
	}

}