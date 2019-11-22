package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DatabaseQueries {
	Connection connection = null;

	public DatabaseQueries() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "newuser", "infoobjects");
			System.out.println("connection established");
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	public void readAllEmployees() {
		System.out.println("i am here");
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			String sql = "Select * from emplyeelist";
			preparedStatement = connection.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	
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