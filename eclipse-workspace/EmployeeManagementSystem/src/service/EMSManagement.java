package service;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import dto.Employee;
import util.Utility;
import java.io.*;
import dao.DatabaseQueries;

public class EMSManagement {

	Scanner scanner = new Scanner(System.in);
	String stringFormatOne = "%-5s%-36s %-5s %-12s %-5s %-12s %-5s %-10s %-5s %-28s %-5s\n";
	String StringFormatTwo = "%-5s%-33s %-5s %-12s %-5s %-12s %-5s %-13s %-5s %-28s %-5s\n";
    Utility utility=new Utility();
	public void add(DatabaseQueries databaseQueries) {
		Employee employee = new Employee();
		System.out.println("Enter First name (required) \nFor example : Varnit");
		int flag;
		String str;
		employee.setFname(inputName());

		System.out.println("Enter Last name (required) \nFor example : Tyagi");
		employee.setLname(inputName());

		System.out.println("Enter Mobile Number (required) \nFor India : only 10 digits integer with correct format");
		do {
			flag = 1;
			str = scanner.nextLine();
			flag=checkRequiredField(str);
			if(flag==1){
				flag = utility.validateMobileNumber(str);
				if (flag == 0) {
					System.out.println("Please enter correct mobile number");
				}
			}
		} while (flag == 0);
		employee.setNumber(str);

		System.out.println("Enter Emailid (required) \nFor example : example@gmail.com");
		do {
			flag = 1;
			str = scanner.nextLine();
			flag=checkRequiredField(str);
			if(flag==1){
				flag = utility.validateEmail(str);
				if (flag == 0) {
					System.out.println("Please enter correct email address");
				}
			}
		} while (flag == 0);
		employee.setEmail(str);
        
		String uniqueID = UUID.randomUUID().toString();
		employee.setUid(uniqueID);
		databaseQueries.addData(employee,"employee100");
	}

	public void read(DatabaseQueries databaseQueries) {
		try {
			String uid = getUid();
			List<Employee> list = databaseQueries.readEmployee(uid);
			if (!list.isEmpty()) {
				System.out.println(String.format("%s",
						"----------------------------------------------------------------------------------------------------------------------------------------"));

				System.out.format(stringFormatOne, "|", "UniqueID", "|", "First Name", "|", "Last Name", "|",
						"Mobile Number", "|", "E-mail", "|");

				System.out.println(String.format("%s",
						"----------------------------------------------------------------------------------------------------------------------------------------"));

				System.out.format(StringFormatTwo, "|", list.get(0).getUid(), "|", list.get(0).getFname(), "|",
						list.get(0).getLname(), "|", list.get(0).getNumber(), "|", list.get(0).getEmail(), "|");
				System.out.println(String.format("%s",
						"----------------------------------------------------------------------------------------------------------------------------------------"));

			} else {
				System.out.println("Desired entry not found please try again");
			}
		} catch (Exception exception) {
			System.out.println("Got an Exception " + exception.getMessage());
		}
	}

	public void readall(DatabaseQueries databaseQueries) {
		try {
			List<Employee> list = databaseQueries.readAllEmployees();
			if (!list.isEmpty()) {
				System.out.println(String.format("%s",
						"----------------------------------------------------------------------------------------------------------------------------------------"));
				System.out.format(stringFormatOne, "|", "UniqueID", "|", "First Name", "|", "Last Name", "|",
						"Mobile Number", "|", "E-mail", "|");
				for (int i = 0; i < list.size(); i++) {
					System.out.println(String.format("%s",
							"----------------------------------------------------------------------------------------------------------------------------------------"));

					System.out.format(StringFormatTwo, "|", list.get(i).getUid(), "|", list.get(i).getFname(), "|",
							list.get(i).getLname(), "|", list.get(i).getNumber(), "|", list.get(i).getEmail(), "|");
				}
				System.out.println(String.format("%s",
						"----------------------------------------------------------------------------------------------------------------------------------------"));

			} else {
				System.out.println("Database is empty no entry found");
			}
		} catch (Exception exception) {
			System.out.println("Got an exception " + exception.getMessage());
		}
	}

	public void update(DatabaseQueries databaseQueries) {
		String uid = getUid();
		try {
			List<Employee> list = databaseQueries.checkUidExsist(uid);
			if (!list.isEmpty()) {
				System.out.println("Your old first name " + list.get(0).getFname() + "\n"
						+ "Enter fname if u want to update else press enter");
				String fname;
				int flag;
				do {
					flag = 1;
					fname = scanner.nextLine();
					if (fname.isEmpty()) {
						fname = list.get(0).getFname();
					} else {
						flag = utility.validateName(fname);
						if (flag == 0) {
							System.out.println("Please enter only characters");
						}
					}
				} while (flag == 0);
				list.get(0).setFname(fname);

				System.out.println("Your old last name " + list.get(0).getLname() + "\n"
						+ "Enter last name if u want to update else press enter");
				String lname;
				do {
					flag = 1;
					lname = scanner.nextLine();
					if (lname.isEmpty()) {
						lname = list.get(0).getLname();
					} else {
						flag = utility.validateName(lname);
						if (flag == 0) {
							System.out.println("Please enter only characters");
						}
					}
				} while (flag == 0);
				list.get(0).setLname(lname);

				System.out.println("Your old Mobile Number " + list.get(0).getNumber() + "\n"
						+ "Enter mobile number if u want to update else press enter");
				String mobileNumber;
				do {
					flag = 1;
					mobileNumber = scanner.nextLine();
					if (mobileNumber.isEmpty()) {
						mobileNumber = list.get(0).getNumber();
					} else {
						flag = utility.validateMobileNumber(mobileNumber);
						if (flag == 0) {
							System.out.println("Please enter correct mobile number");
						}
					}
				} while (flag == 0);
				list.get(0).setNumber(mobileNumber);

				System.out.println("Your old email-id " + list.get(0).getEmail() + "\n"
						+ "Enter email-id if u want to update else press enter");
				String email;
				do {
					flag = 1;
					email = scanner.nextLine();
					if (email.isEmpty()) {
						email = list.get(0).getEmail();
					} else {
						flag = utility.validateEmail(email);
						if (flag == 0) {
							System.out.println("Please enter correct email address");
						}
					}
				} while (flag == 0);
				list.get(0).setEmail(email);

				databaseQueries.updateData(uid, list.get(0));
			} else {
				System.out.println("Desired entry not found please try again");
			}
		} catch (Exception exception) {
			System.out.println("Got an Exception " + exception.getMessage());
		}

	}

	public void delete(DatabaseQueries databaseQueries) {
		String uid = getUid();
		databaseQueries.deleteData(uid);
	}
    
	public String inputName()
	{
		int flag;
		String str;
		do {
			flag = 1;
			str = scanner.nextLine();
			flag=checkRequiredField(str);
			if(flag==1) {
				flag = utility.validateName(str);
				if (flag == 0) {
					System.out.println("Please enter only characters");
				}
			}
		} while (flag == 0);
		return str;
	}
	public int checkRequiredField(String str) {
		int flag=1;
		if (str.isEmpty()) {
			flag = 0;
			System.out.println("required");
		}
		return flag;
	}


	public String getUid() {
		System.out.println("Enter uuid");
		String str = scanner.nextLine();
		return str;
	}

}
