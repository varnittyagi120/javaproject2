package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {
	public boolean validateStrings(String string, String regx) {
		Pattern pattern = Pattern.compile(new String(regx));
		Matcher matcher = pattern.matcher(string);
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}
	public static String getTableName(String className) {
		if (className.equals("Employee")) {
			return "employeeData";
		} else if (className.equals("Client")) {
			return "clientData";
		}

		return null;
	}
}
