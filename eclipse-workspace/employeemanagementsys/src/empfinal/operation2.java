package empfinal;

import java.util.Scanner;
import java.util.UUID;
import java.sql.*;

public class operation2 {
	Connection con;

	public operation2() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "newuser", "infoobjects");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int add() {
		employee1 e = new employee1();
		System.out.println("Enter First name ");
		e.setfname(getstring());

		System.out.println("Enter Last name ");
		e.setlname(getstring());

		System.out.println("Enter Contact Number ");
		e.setnumber(getnumber());

		System.out.println("Enter Emailid");
		e.setemail(getemail());

		String uniqueID = UUID.randomUUID().toString();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "newuser", "infoobjects");
			String sql = "INSERT INTO employee100 (id,fname,lname,number,email) VALUES(?,?,?,?,?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, uniqueID);
			statement.setString(2, e.getfname());
			statement.setString(3, e.getlname());
			statement.setString(4, e.getnumber());
			statement.setString(5, e.getemail());
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new user was inserted successfully!");
			}
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		return exitsign();
	}

	public int read() {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {

			String str = getuid();
			String sql = "Select * from employee100 WHERE id=?";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, str);
			rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				System.out.println(String.format("%s",
						"---------------------------------------------------------------------------------------------------------------------------------"));
				System.out.println(String.format("%1s %17s %20s %15s %2s %15s %5s %15s %5s %12s %12s", "|", "UniqueID",
						"|", "First Name", "|", "Last Name", "|", "Mobile Number", "|", "E-mail", "|"));
				System.out.println(String.format("%s",
						"---------------------------------------------------------------------------------------------------------------------------------"));
				System.out.println(String.format("%1s %15s %1s %12s %5s %12s %8s %12s %8s %15s %8s", "|",
						rs.getString(1), "|", rs.getString(2), "|", rs.getString(3), "|", rs.getString(4), "|",
						rs.getString(5), "|"));
				System.out.println(String.format("%s",
						"---------------------------------------------------------------------------------------------------------------------------------"));
			} else {
				System.out.println("Desired entry not found please try again");
			}
		} catch (Exception e) {
			System.err.println("Got an exception");
			System.out.println(e.getMessage());
		}
		return exitsign();
	}

	public int readall() {
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employee100");
			System.out.println(String.format("%s",
					"---------------------------------------------------------------------------------------------------------------------------------"));
			System.out.println(String.format("%1s %17s %20s %15s %2s %15s %5s %15s %5s %12s %12s", "|", "UniqueID", "|",
					"First Name", "|", "Last Name", "|", "Mobile Number", "|", "E-mail", "|"));
			while (rs.next()) {
				System.out.println(String.format("%s",
						"---------------------------------------------------------------------------------------------------------------------------------"));
				System.out.println(String.format("%1s %15s %1s %12s %5s %12s %8s %12s %8s %15s %8s", "|",
						rs.getString(1), "|", rs.getString(2), "|", rs.getString(3), "|", rs.getString(4), "|",
						rs.getString(5), "|"));
			}
			System.out.println(String.format("%s",
					"---------------------------------------------------------------------------------------------------------------------------------"));
		} catch (Exception e) {
			System.out.println();
			System.out.println("Got an exception"+e.getMessage());
		}
		return exitsign();
	}

	public int update() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			String uid = getuid();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "newuser", "infoobjects");
			String sql = "Select * from employee100 WHERE id=?";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, uid);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				System.out.println("Your old first name " + rs.getString(2));
				System.out.println("Enter fname if u want to update else press enter");
				String fname = getstring();
				if (fname.isEmpty()) {
					fname = rs.getString(2);
				}
				System.out.println("Your old last name " + rs.getString(3));
				System.out.println("Enter last name if u want to update else press enter");
				String lname = getstring();
				if (lname.isEmpty()) {
					lname = rs.getString(3);
				}
				System.out.println("Your old Mobile Number " + rs.getString(4));
				System.out.println("Enter mobile number if u want to update else press enter");
				String number = getnumber();
				if (number.isEmpty()) {
					number = rs.getString(4);
				}
				System.out.println("Your old email-id " + rs.getString(5));
				System.out.println("Enter email-id if u want to update else press enter");
				String email = getemail();
				if (email.isEmpty()) {
					email = rs.getString(5);
				}
				updatequery(uid, fname, lname, number, email);

			} else {
				System.out.println("Desired entry not found please try again");
			}

		} catch (Exception e) {
			System.out.println("Got an exception");
			System.out.println(e.getMessage());
		}
		return exitsign();
	}

	public int delete1() {
		try {
			String uid = getuid();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "newuser", "infoobjects");
			String sql = "DELETE FROM employee100 WHERE id=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, uid);

			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Desired entry has been successfully deleted");
			} else {
				System.out.println("Desired entry not found");
			}

		} catch (Exception e) {
			System.err.println("Got an exception");
			System.out.println(e.getMessage());
		}
		return exitsign();
	}

	public String getstring() {
		int flag;
		String str;
		do {
			flag = 1;
			Scanner sc = new Scanner(System.in);
			str = sc.nextLine();
			try {
				int no = Integer.parseInt(str);
			} catch (Exception e) {
				flag = 0;
			}
			if (flag == 1) {
				System.out.println("Please enter correct name");
			}

		} while (flag == 1);
		return str;
	}

	public String getnumber() {
		String number;
		int flag = 0;
		do {
			flag = 0;
			Scanner sc = new Scanner(System.in);
			number = sc.nextLine();
			if (number.matches("(0/91)?[6-9][0-9]{9}") == false) {
				System.out.println("Please enter correct contact number");
				flag = 1;
			}

		} while (flag == 1);

		return number;
	}

	public String getemail() {
		int flag;
		String email;
		do {
			flag = 0;
			Scanner sc = new Scanner(System.in);
			email = sc.nextLine();
			if (email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$") == false) {
				System.out.println("Please enter correct email address");
				flag = 1;
			}

		} while (flag == 1);

		return email;

	}

	public String getuid() {
		System.out.println("Enter uuid");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		return str;
	}

	public void updatequery(String uid, String fname, String lname, String number, String email) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "newuser", "infoobjects");
			String sql = "UPDATE employee100 SET fname=?,lname=?,number=?,email=? WHERE id=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, fname);
			statement.setString(2, lname);
			statement.setString(3, number);
			statement.setString(4, email);
			statement.setString(5, uid);
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An existing user has updated successfully!");
			}
		} catch (Exception e) {
			System.out.println("Got an Exception");
			System.out.println(e.getMessage());
		}

	}

	public int exitsign() {
		System.out.println("If u want to continue press 0  , else any other key for going one step back");
		Scanner sc = new Scanner(System.in);
		int sign = sc.nextInt();
		return sign;
	}

}