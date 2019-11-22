package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dto.Person;
import util.Utility;

public class DatabaseQueries<T extends Person> extends Utility {
	Connection connection;
//	public static DatabaseQueries databaseQueries = new DatabaseQueries<>();
//	private DatabaseQueries() {
//		try {
//			System.out.println("connection established");
//			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "newuser", "infoobjects");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static DatabaseQueries getObject() {
//		return databaseQueries;
//	}
	private static  DatabaseQueries<?> databaseQueries = null;
	private DatabaseQueries() {
		try {
			System.out.println("connection established");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "newuser", "infoobjects");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static DatabaseQueries<?> getObject() {
		if(databaseQueries==null) {
			databaseQueries = new DatabaseQueries<>();
		}
		return databaseQueries;
	}

	public <T1, T2> boolean addData(Map<T1, T2> map, T object) {
		int mapSize = map.size();
		StringBuilder parameterQuestionMark = new StringBuilder(mapSize);
		parameterQuestionMark.append("?");
		for (int i = 0; i < mapSize - 1; i++) {
			parameterQuestionMark.append(",?");
		}
		String tableName = getTableName(object.getClass().getSimpleName());
		try {
			String sql = "INSERT INTO " + tableName + " VALUES(" + parameterQuestionMark + ")";
			PreparedStatement statement = connection.prepareStatement(sql);
			int i = 1;
			for (Map.Entry<T1, T2> entry : map.entrySet()) {
				statement.setString(i, (String) entry.getValue());
				i++;
			}
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				return true;
			}
		} catch (Exception exception) {
			System.err.println("Got an Exception " + exception.getMessage());
		}
		return false;
	}

	public List<String> readEmployee(String uid, T object) {
		PreparedStatement preparedStatement = null;
		List<String> list = new ArrayList<>();
		ResultSet rs = null;
		try {
			String tableName = getTableName(object.getClass().getSimpleName());
			String sql = "Select * from " + tableName + " where id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, uid);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {

				list.add(rs.getString(1));
				list.add(rs.getString(2));
				list.add(rs.getString(3));
				list.add(rs.getString(4));
				list.add(rs.getString(5));
				list.add(rs.getString(6));
				list.add(rs.getString(7));

			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return list;
	}

	public List<List<String>> readAllEmployees(T object) {
		List<List<String>> listOfObjects = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		try {
			String tableName = getTableName(object.getClass().getSimpleName());
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
	}

	public int updateData(String uid, Map<String, String> map, T object) {
		int rowsUpdated = 0;
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
			String tableName = getTableName(object.getClass().getSimpleName());
			String sql = "UPDATE " + tableName + " SET " + setParameter + " WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			i = 1;
			for (Map.Entry<String, String> entry : map.entrySet()) {
				statement.setString(i, entry.getValue());
				i++;
			}
			statement.setString(i, uid);
			rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				return rowsUpdated;
			}
		} catch (Exception exception) {
			System.out.println("Got an Exception " + exception.getMessage());
		}
		return rowsUpdated;
	}

	public int delete(String uid, T object) {
		int rowsDeleted = 0;
		try {
			String tableName = getTableName(object.getClass().getSimpleName());
			String sql = "DELETE FROM " + tableName + " WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, uid);

			rowsDeleted = statement.executeUpdate();
		} catch (Exception exception) {
			System.out.println("Got an exception " + exception.getMessage());
		}
		return rowsDeleted;
	}

}
