package util;

import java.util.Calendar;
import java.util.Scanner;

public class Utility {
	Scanner scanner=new Scanner(System.in);
	String regxForNumber = "(0/91)?[6-9][0-9]{9}";
	String regxForEmail = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	public int validateName(String str) {
		int flag = 0;
		try {
			int no = Integer.parseInt(str);
		} catch (Exception e) {
			flag = 1;
		}
		return flag;
	 }

	public int validateMobileNumber(String number) {
		int flag = 1;
		if (!number.matches(regxForNumber)) {
			flag = 0;
		}
		return flag;
	}

	public int validateEmail(String number) {
		int flag = 1;
		if (!number.matches(regxForEmail)) {
			flag = 0;
		}
		return flag;
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
				flag = validateName(str);
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
	public int validateYear(int year) {
		int flag = 0;
		if (year >= 2000 && year <= Calendar.getInstance().get(Calendar.YEAR)) {
			flag = 1;
		} else {
			System.out.println("please enter year between 2000>= and <=" + Calendar.getInstance().get(Calendar.YEAR));
			flag = 0;
		}
		return flag;
	}

	public int validateMonth(int year,int month) {
		int flag=1;
		if (year == Calendar.getInstance().get(Calendar.YEAR)) {
			if (month >= 1 && month <= Calendar.getInstance().get(Calendar.MONTH)) {
				flag=1;
			} else {
				System.out.println("Date of joining month can not greater than current month");
				flag = 0;
			}
		} else {
			if (month >= 1 && month <= 12) {
				flag=1;
			} else {
				System.out.println("please enter month between 1>= and <=12 ");
				flag = 0;
			}
		}
		return flag;

	}

	public boolean validateLeapYear(int year) {
		boolean flag = false;
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					flag = true;
				} else {
					flag = false;
				}
			} else {
				flag = true;
			}
		} else {
			flag = false;
		}
		return flag;
	}

	public int validateDate(int year, boolean leap, int month,int date) {
		int flag;
		if (year == Calendar.getInstance().get(Calendar.YEAR)
				&& month == Calendar.getInstance().get(Calendar.MONTH)) {
			if (date >= 1 && date <= Calendar.getInstance().get(Calendar.DATE)) {
				flag=1;
			} else {
				flag = 0;
				System.out.println("Date of joining can not be outside the given range");
			}
		} else {
			if (month == 2) {
				if (leap) {
					if (date >= 1 && date <= 29) {
						flag=1;
					} else {
						flag = 0;
					}
				} else {
					if (date >= 1 && date <= 28) {
						flag=1;
					} else {
						flag = 0;
					}
				}
			} else if (month == 4 || month == 6 || month == 9 || month == 11) {
				if (date >= 1 && date <= 30) {
					flag=1;
				} else {
					flag = 0;
				}
			} else {
				if (date >= 1 && date <= 31) {
				    flag=1;
				} else {
					flag = 0;
				}
			}
			if (flag == 0) {
				System.out.println("Please enter correct date");
			}
		}
		return flag;
	}


}
