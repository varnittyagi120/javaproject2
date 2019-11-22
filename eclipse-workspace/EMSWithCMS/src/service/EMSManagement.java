package service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
import dao.DatabaseQueries;
import dto.Employee;
import util.Utility;

public class EMSManagement implements CRUDContainer {

	Scanner scanner = new Scanner(System.in);
	String stringFormatOne = "%-5s%-36s %-5s %-12s %-5s %-12s %-5s %-10s %-5s %-28s %-5s %-15s %-5s %-10s %-5s\n";
	String StringFormatTwo = "%-5s%-33s %-5s %-12s %-5s %-12s %-5s %-13s %-5s %-28s %-5s %-15s %-5s %-10s %-5s\n";
	Utility utility = new Utility();
	Employee employee = new Employee();

	public void add(DatabaseQueries databaseQueries) {

		System.out.println("Enter First name (required) \nFor example : Varnit");
		int flag;
		String str;
		employee.setFname(utility.inputName());

		System.out.println("Enter Last name (required) \nFor example : Tyagi");
		employee.setLname(utility.inputName());

		System.out.println("Enter Mobile Number (required) \nFor India : only 10 digits integer with correct format");
		do {
			flag = 1;
			str = scanner.nextLine();
			flag = utility.checkRequiredField(str);
			if (flag == 1) {
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
			flag = utility.checkRequiredField(str);
			if (flag == 1) {
				flag = utility.validateEmail(str);
				if (flag == 0) {
					System.out.println("Please enter correct email address");
				}
			}
		} while (flag == 0);
		employee.setEmail(str);

		System.out.println("Enter date of joining (required)");
		employee.setDateOfJoining(inputDateOfJoining());

		String salaryInString = null;
		double salaryInDouble = 0.00;
		System.out.println("Enter salary (optional) \nBetween 10000>= to <=100000");
		do {
			try {
				flag = 1;
				salaryInString = scanner.nextLine();
				if (salaryInString.isEmpty()) {
					salaryInString = "null";
					break;
				} else {
					salaryInDouble = Double.parseDouble(salaryInString);
				}
				if (flag == 1) {
					flag = validateSalary(salaryInDouble);
					if (flag == 0) {
						System.out.println("Please enter salary between 10000>= to <=100000");
					}
				}
			} catch (Exception exception) {
				System.out.println("please enter salary only numeric type");
				flag = 0;
			}
		} while (flag == 0);
		employee.setSalary(salaryInString);

		String uniqueID = UUID.randomUUID().toString();
		employee.setUid(uniqueID);

		databaseQueries.addData(employee.getDataOfEmployee(employee), "employee100");
	}

	public void read(DatabaseQueries databaseQueries) {
		try {
			String uid = utility.getUid();
			List<ArrayList<String>> list = databaseQueries.read(uid, "employee100");
			if (!list.isEmpty()) {
				printColumnNamesOfTable();
				printDataOfTable(0, list);
				System.out.println(String.format("%s",
						"--------------------------------------------------------------------------------------------------------------"
								+ "-----------------------------------------------------------------"));

			} else {
				System.out.println("Desired entry not found please try again");
			}
		} catch (Exception exception) {
			System.out.println("Got an Exception " + exception.getMessage());
		}
	}

	public void readall(DatabaseQueries databaseQueries) {
		try {
			List<ArrayList<String>> list = databaseQueries.readAll("employee100");
			if (!list.isEmpty()) {
				printColumnNamesOfTable();
				for (int i = 0; i < list.size(); i++) {
					printDataOfTable(i, list);
				}
				System.out.println(String.format("%s",
						"--------------------------------------------------------------------------------------------------------------"
								+ "-----------------------------------------------------------------"));

			} else {
				System.out.println("Database is empty no entry found");
			}
		} catch (Exception exception) {
			System.out.println("Got an exception " + exception.getMessage());
		}
	}

	public void update(DatabaseQueries databaseQueries) {

		try {
			String uid = utility.getUid();
			List<ArrayList<String>> list = databaseQueries.checkUidExsist(uid, "employee100");
			if (!list.isEmpty()) {
				employee.setUid(list.get(0).get(0));

				System.out.println("Your old first name " + list.get(0).get(1) + "\n"
						+ "Enter fname if u want to update else press enter");
				String fname;
				int flag;
				do {
					flag = 1;
					fname = scanner.nextLine();
					if (fname.isEmpty()) {
						fname = list.get(0).get(1);
					} else {
						flag = utility.validateName(fname);
						if (flag == 0) {
							System.out.println("Please enter only characters");
						}
					}
				} while (flag == 0);
				employee.setFname(fname);

				System.out.println("Your old last name " + list.get(0).get(2) + "\n"
						+ "Enter last name if u want to update else press enter");
				String lname;
				do {
					flag = 1;
					lname = scanner.nextLine();
					if (lname.isEmpty()) {
						lname = list.get(0).get(2);
					} else {
						flag = utility.validateName(lname);
						if (flag == 0) {
							System.out.println("Please enter only characters");
						}
					}
				} while (flag == 0);
				employee.setLname(lname);

				System.out.println("Your old Mobile Number " + list.get(0).get(3) + "\n"
						+ "Enter mobile number if u want to update else press enter");
				String mobileNumber;
				do {
					flag = 1;
					mobileNumber = scanner.nextLine();
					if (mobileNumber.isEmpty()) {
						mobileNumber = list.get(0).get(3);
					} else {
						flag = utility.validateMobileNumber(mobileNumber);
						if (flag == 0) {
							System.out.println("Please enter correct mobile number");
						}
					}
				} while (flag == 0);
				employee.setNumber(mobileNumber);

				System.out.println("Your old email-id " + list.get(0).get(4) + "\n"
						+ "Enter email-id if u want to update else press enter");
				String email;
				do {
					flag = 1;
					email = scanner.nextLine();
					if (email.isEmpty()) {
						email = list.get(0).get(4);
					} else {
						flag = utility.validateEmail(email);
						if (flag == 0) {
							System.out.println("Please enter correct email address");
						}
					}
				} while (flag == 0);
				employee.setEmail(email);

				System.out.println(list.get(0).get(5));
				String[] date = list.get(0).get(5).split("-");
				System.out.println("Your old date of joining is " + list.get(0).get(5));
				System.out.println(
						"Your old year " + date[2] + "\n" + "Enter new year if u want to update else press enter");
				String inputYear;
				int yearInInteger = 0;
				do {
					flag = 1;
					System.out.println("Enter year between 2000>= and <=" + Calendar.getInstance().get(Calendar.YEAR));
					inputYear = scanner.nextLine();
					if (inputYear.isEmpty()) {
						yearInInteger = Integer.valueOf(date[2]);
						break;
					} else {
						try {
							yearInInteger = Integer.parseInt(inputYear);
						} catch (Exception exception) {
							System.out.println("please enter only integers");
							flag = 0;
						}
						if (flag == 1) {
							flag = utility.validateYear(yearInInteger);
						}
					}
				} while (flag == 0);

				System.out.println(
						"Your old month " + date[1] + "\n" + "Enter new month if u want to update else press enter");
				String inputmonth;
				int monthInInteger = 0;
				do {
					flag = 1;
					if (yearInInteger == Calendar.getInstance().get(Calendar.YEAR)) {
						System.out
						.println("Enter month between 1>= and <=" + Calendar.getInstance().get(Calendar.MONTH));
					} else {
						System.out.println("Enter month between 1>= and <=12");
					}
					inputmonth = scanner.nextLine();
					if (inputmonth.isEmpty()) {
						monthInInteger = Integer.valueOf(date[1]);
						break;
					} else {
						try {
							monthInInteger = Integer.parseInt(inputmonth);
						} catch (Exception exception) {
							System.out.println("please enter only integers");
							flag = 0;
						}
						if (flag == 1) {
							flag = utility.validateMonth(yearInInteger, monthInInteger);
						}
					}
				} while (flag == 0);

				System.out.println(
						"Your old date " + date[0] + "\n" + "Enter new month if u want to update else press enter");
				String inputdate;
				int dateInInteger = 0;
				do {
					flag = 1;
					if (yearInInteger == Calendar.getInstance().get(Calendar.YEAR)
							&& monthInInteger == Calendar.getInstance().get(Calendar.MONTH)) {
						System.out.println("Enter date according to the month between 1>= and <="
								+ Calendar.getInstance().get(Calendar.DATE));
					} else {
						System.out.println("Enter date according to the month between 1>= and <=31");
					}
					inputdate = scanner.nextLine();
					if (inputmonth.isEmpty()) {
						dateInInteger = Integer.valueOf(date[0]);
						break;
					} else {
						try {
							dateInInteger = Integer.parseInt(inputdate);
						} catch (Exception exception) {
							System.out.println("please enter only integers");
							flag = 0;
						}
						if (flag == 1) {
							flag = utility.validateDate(yearInInteger, utility.validateLeapYear(yearInInteger),
									monthInInteger, dateInInteger);
						}
					}
				} while (flag == 0);
				String dateOfJoining = String.valueOf(dateInInteger) + "-" + String.valueOf(monthInInteger) + "-"
						+ String.valueOf(yearInInteger);
				System.out.println("updated date " + dateOfJoining);
				employee.setDateOfJoining(dateOfJoining);

				System.out.println("Your old Salary " + list.get(0).get(6) + "\n"
						+ "Enter new salary if u want to update else press enter");
				String salaryInString;
				double salaryInDouble = 0;
				do {
					flag = 1;
					System.out.println("Enter salary  between 10000>= to <=100000");
					salaryInString = scanner.nextLine();
					if (salaryInString.isEmpty()) {
						salaryInString = list.get(0).get(6);
						break;
					} else {
						try {
							salaryInDouble = Double.parseDouble(salaryInString);
						} catch (Exception exception) {
							System.out.println("Please enter salary in numeric format");
							flag = 0;
						}
						if (flag == 1) {
							flag = validateSalary(salaryInDouble);
							if (flag == 1) {
								salaryInString = String.valueOf(salaryInDouble);
							} else {
								System.out.println("Please enter salary between 10000>= to <=100000");
							}
						}
					}
				} while (flag == 0);
				employee.setSalary(salaryInString);
				databaseQueries.updateData(uid, employee.getDataOfEmployee(employee), "employee100");
			} else {
				System.out.println("Desired entry not found please try again");
			}
		} catch (Exception exception) {
			System.out.println("Got an Exception " + exception.getMessage());
		}

	}

	public void delete(DatabaseQueries databaseQueries) {
		String uid = utility.getUid();
		databaseQueries.deleteData(uid, "employee100");
	}

	public String inputDateOfJoining() {
		int year = 0, month = 0, date = 0;

		String inputYear;
		int flag;
		do {
			flag = 1;
			try {
				System.out.println("Enter year between 2000>= and <=" + Calendar.getInstance().get(Calendar.YEAR));
				inputYear = scanner.nextLine();
				flag = utility.checkRequiredField(inputYear);
				if (flag == 1) {
					year = Integer.parseInt(inputYear);
				}
			} catch (Exception e) {
				System.out.println("Please enter only integers");
				flag = 0;
			}
			if (flag == 1) {
				flag = utility.validateYear(year);
			}

		} while (flag == 0);

		String inputMonth;
		do {
			flag = 1;
			try {
				if (year == Calendar.getInstance().get(Calendar.YEAR)) {
					System.out.println("Enter month between 1>= and <=" + Calendar.getInstance().get(Calendar.MONTH));
				} else {
					System.out.println("Enter month between 1>= and <=12");
				}
				inputMonth = scanner.nextLine();
				flag = utility.checkRequiredField(inputMonth);
				if (flag == 1) {
					month = Integer.parseInt(inputMonth);
				}
			} catch (Exception e) {
				System.out.println("Please enter only integers");
				flag = 0;
			}
			if (flag == 1) {
				flag = utility.validateMonth(year, month);
			}

		} while (flag == 0);

		String inputDate;
		do {
			flag = 1;
			try {
				if (year == Calendar.getInstance().get(Calendar.YEAR)
						&& month == Calendar.getInstance().get(Calendar.MONTH)) {
					System.out.println("Enter date according to the month between 1>= and <="
							+ Calendar.getInstance().get(Calendar.DATE));
				} else {
					System.out.println("Enter date according to the month between 1>= and <=31");
				}
				inputDate = scanner.nextLine();
				flag = utility.checkRequiredField(inputDate);
				if (flag == 1) {
					date = Integer.parseInt(inputDate);
				}
			} catch (Exception e) {
				System.out.println("Please enter only integers");
				flag = 0;
			}
			if (flag == 1) {
				flag = utility.validateDate(year, utility.validateLeapYear(year), month, date);
			}

		} while (flag == 0);
		String dateOfJoining = String.valueOf(date) + "-" + String.valueOf(month) + "-" + String.valueOf(year);
		return dateOfJoining;
	}

	public int validateSalary(Double salary) {
		int flag = 0;
		if (salary >= 10000 && salary <= 100000) {
			flag = 1;
		}
		return flag;
	}

	public void printColumnNamesOfTable() {
		System.out.println(String.format("%s",
				"--------------------------------------------------------------------------------------------------------------"
						+ "-----------------------------------------------------------------"));
		System.out.format(stringFormatOne, "|", "UniqueID", "|", "First Name", "|", "Last Name", "|", "Mobile Number",
				"|", "E-mail", "|", "DateOfJoining", "|", "Salary", "|");
	}

	public void printDataOfTable(int i, List<ArrayList<String>> list) {
		System.out.println(String.format("%s",
				"--------------------------------------------------------------------------------------------------------------"
						+ "-----------------------------------------------------------------"));

		System.out.format(StringFormatTwo, "|", list.get(i).get(0), "|", list.get(i).get(1), "|", list.get(i).get(2),
				"|", list.get(i).get(3), "|", list.get(i).get(4), "|", list.get(i).get(5), "|", list.get(i).get(6),
				"|");

	}
}
