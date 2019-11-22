package util;

public class Utility {
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

}
