package service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
import javax.swing.text.html.HTMLDocument.Iterator;
import dto.Client;
import dao.DatabaseQueries;
import util.Utility;

public class CMSManagement implements CRUDContainer {
	
	Scanner scanner = new Scanner(System.in);
	String stringFormatOne = "%-5s%-36s %-5s %-12s %-5s %-12s %-5s %-10s %-5s %-28s %-5s %-15s %-5s %-10s %-5s\n";
	String StringFormatTwo = "%-5s%-33s %-5s %-12s %-5s %-12s %-5s %-13s %-5s %-28s %-5s %-15s %-5s %-10s %-5s\n";
	Utility utility = new Utility();
	Client client = new Client();

	public void add(DatabaseQueries databaseQueries) {
		
		System.out.println("Enter First name (required) \nFor example : Varnit");
		int flag;
		String str;
		client.setFname(utility.inputName());

		System.out.println("Enter Last name (required) \nFor example : Tyagi");
		client.setLname(utility.inputName());

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
		client.setNumber(str);

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
		client.setEmail(str);

		System.out.println("Enter billmount (required) \nFor example :100.00 ");
		String billAmountInString = null;
		do {
			try {
				flag = 1;
				billAmountInString = scanner.nextLine();
				flag = utility.checkRequiredField(billAmountInString);
				if (flag == 1) {
					double billAmountInDouble = Double.parseDouble(billAmountInString);
				}
			} catch (Exception exception) {
				System.out.println("Please enter billAmount in numeric format");
				flag = 0;
			}
		} while (flag == 0);
		client.setBillAmount(billAmountInString);
		System.out.println("Enter tenure of customer (optional) \nFor example :10 ");
		String tenureInString = null;
		do {
			try {
				flag = 1;
				tenureInString = scanner.nextLine();
				if (tenureInString.isEmpty()) {
					tenureInString = "null";
					break;
				} else {
					int tenureInInteger = Integer.parseInt(tenureInString);
				}
			} catch (Exception exception) {
				System.out.println("Please enter tenure in Integers format");
				flag = 0;
			}
		} while (flag == 0);
		client.setTenure(tenureInString);

		String uniqueID = UUID.randomUUID().toString();
		client.setUid(uniqueID);
		databaseQueries.addData(client.getDataOfClient(client), "client100");
	}

	public void read(DatabaseQueries databaseQueries) {
		
		try {
			String uid = utility.getUid();
			List<ArrayList<String>> list = databaseQueries.read(uid, "client100");
			if (!list.isEmpty()) {
				printColumnNamesOfTable();
				printDataOfTable(0,list);
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
			List<ArrayList<String>> list = databaseQueries.readAll("client100");
			if (!list.isEmpty()) {
			   printColumnNamesOfTable();
	           for (int i = 0; i < list.size(); i++) {
				         printDataOfTable(i,list);					
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
			List<ArrayList<String>> list = databaseQueries.checkUidExsist(uid, "client100");
			
			if (!list.isEmpty()) {
				client.setUid(list.get(0).get(0));
				
				System.out.println("Your old first name " + list.get(0).get(1) + "\n"
						+ "Enter new fname if u want to update else press enter");
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
				client.setFname(fname);

				System.out.println("Your old last name " + list.get(0).get(2) + "\n"
						+ "Enter new last name if u want to update else press enter");
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
				client.setLname(lname);

				System.out.println("Your old Mobile Number " + list.get(0).get(3) + "\n"
						+ "Enter new mobile number if u want to update else press enter");
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
				client.setNumber(mobileNumber);

				System.out.println("Your old email-id " + list.get(0).get(4) + "\n"
						+ "Enter new email-id if u want to update else press enter");
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
				client.setEmail(email);

				System.out.println("Your old billAmount " + list.get(0).get(5) + "\n"
						+ "Enter new billAmount if u want to update else press enter");
				String billAmount;
				do {
					flag = 1;
					billAmount = scanner.nextLine();
					if (billAmount.isEmpty()) {
						billAmount = list.get(0).get(5);
					} else {
						try {
							double billAmountInDouble = Double.parseDouble(billAmount);
						} catch (Exception exception) {
							flag = 0;
							if (flag == 0) {
								System.out.println("Please enter billAmount in numeric format");
							}
						}
					}
				} while (flag == 0);
				client.setBillAmount(billAmount);

				System.out.println("Your old tenure " + list.get(0).get(6) + "\n"
						+ "Enter new tenure if u want to update else press enter");
				String tenure;
				do {
					flag = 1;
					tenure = scanner.nextLine();
					if (tenure.isEmpty()) {
						tenure = list.get(0).get(6);
					} else {
						try {
							double tenureInInteger = Integer.parseInt(tenure);
						} catch (Exception exception) {
							flag = 0;
							if (flag == 0) {
								System.out.println("Please enter tenure in Integer format");
							}
						}
					}
				} while (flag == 0);
				client.setTenure(tenure);

				databaseQueries.updateData(uid, client.getDataOfClient(client), "client100");
			} else {
				System.out.println("Desired entry not found please try again");
			}
		} catch (Exception exception) {
			System.out.println("Got an Exception " + exception.getMessage());
		}

	}

	public void delete(DatabaseQueries databaseQueries) {
		String uid = utility.getUid();
		databaseQueries.deleteData(uid, "client100");
	}
	public void printColumnNamesOfTable() {
		System.out.println(String.format("%s",
				"--------------------------------------------------------------------------------------------------------------"
						+ "-----------------------------------------------------------------"));
		System.out.format(stringFormatOne, "|", "UniqueID", "|", "First Name", "|", "Last Name", "|",
				"Mobile Number", "|", "E-mail", "|", "BillingAmount", "|", "Tenure", "|");

	}
	
	public void printDataOfTable(int i,List< ArrayList<String> > list) {
		System.out.println(String.format("%s",
				"--------------------------------------------------------------------------------------------------------------"
						+ "-----------------------------------------------------------------"));

		System.out.format(StringFormatTwo, "|", list.get(i).get(0), "|", list.get(i).get(1), "|",
				list.get(i).get(2), "|", list.get(i).get(3), "|", list.get(i).get(4), "|",
				list.get(i).get(5), "|", list.get(i).get(6), "|");

	}

}
