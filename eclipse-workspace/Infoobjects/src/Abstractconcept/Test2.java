package Abstractconcept;
import java.util.Scanner;

public class Test2 {
	public static String regxForNumber = "(0/91)?[6-9][0-9]{9}";
	public static String regxForEmail = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	public static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println(inputOperationsOfDifferentFields("Enter email","Please enter correct email",2));  
		System.out.println(inputOperationsOfDifferentFields("Enter number","Please enter correct number",1));  
	}
	public static String inputOperationsOfDifferentFields(String instructionOne,String messageOne,int ch) {
		 String str;
		 boolean flag;
		  do {
			  flag=true;
			  System.out.println(instructionOne);
			  str=scanner.nextLine();
			  flag=checkRequiredField(str);
			  if(flag) {
				
					  switch(ch) {
					       case 1:
								  if(!validateMobileNumber(str)) {
									  System.out.println(messageOne);
									  flag=false;
								  }
								  break;
					        case 2:
								  if(!validateEmail(str)) {
									  System.out.println(messageOne);
									  flag=false;
								  }
								  break;
						     default:
						    	  System.out.println("wrong choice");
					  }


			  }
		  }while(!flag);
		return str;
	}
	public static boolean checkRequiredField(String str) {
		if (str.isEmpty()) {
			System.out.println("required");
			return false;
		}
		return true;
	}
	public static boolean validateMobileNumber(String number) {
		if (!number.matches(regxForNumber)) {
			return false;
		}
		return true;
	}
	public static boolean validateEmail(String number) {
		if (!number.matches(regxForEmail)) {
			return false;
		}
		return true;
	}

}
