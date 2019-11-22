package Abstractconcept;

import java.util.Calendar;
import java.util.Scanner;

public class ValidateDate {
   public static Scanner scanner=new Scanner(System.in);
   public static void main(String args[])
   {
	     int year,month,date;
	     year=validateYear();
	     month=validateMonth();
	     date=validateDate(year,validateLeapYear(year),month);
	     System.out.println(year+"-"+month+"-"+date);
   }
   public static int validateYear()
   {
	   
	   String yy;
	   int year=0;
	   int flag;
	   do{
		   flag=1;
		   try{
			   System.out.println("Enter year between 2000>= and <="+Calendar.getInstance().get(Calendar.YEAR));
		      yy=scanner.nextLine();
		      year=Integer.parseInt(yy);
		   }catch(Exception e) {
			   System.out.println("Please enter only integers");
			   flag=0;
		   }
		   if(flag==1){
			   if(year>=2000 && year<=Calendar.getInstance().get(Calendar.YEAR)) {
				   return year;  
			   }else {
				   System.out.println("please enter year between 2000>= and <="+Calendar.getInstance().get(Calendar.YEAR));
				   flag=0;
			   }
		   }
		   
	   } while(flag==0);
	   return year;
   }
   public static int validateMonth()
   {
	   
	   String mm;
	   int month=0;
	   int flag;
	   do{
		   flag=1;
		   try{
		      mm=scanner.nextLine();
		      month=Integer.parseInt(mm);
		   }catch(Exception e) {
			   System.out.println("Please enter only integers");
			   flag=0;
		   }
		   if(flag==1){
			   if(month>=1 && month<=12) {
				   return month;  
			   }else {
				   System.out.println("please enter month between 1>= and <=12 ");
				   flag=0;
			   }
		   }
		   
	   } while(flag==0);
	   return month;
   }
   public static boolean validateLeapYear(int year)
   {
	   boolean flag=false;
	   if(year % 4 == 0) {
		   if(year % 100 == 0) {
			   if(year % 400 == 0) {
				   flag=true;
			   }else {
				   flag=false;
			   }
		   } else {
			   flag=true;
		   }
	   } else {
		   flag=false;
	   }
	   return flag;
   }
   public static int validateDate(int year,boolean leap,int month)
   {
	   String dd;
	   int date=0;
	   int flag;
	   do{
		   flag=1;
		   try{
		     dd=scanner.nextLine();
		     date=Integer.parseInt(dd);
		   }catch(Exception e) {
			   System.out.println("Please enter only integers");
			   flag=0;
		   }
		   if(flag==1){
			   if(month==2) {
				   if(leap) {
					   if(date>=1 && date<=29) {
						   return date;
					   }else {
						 flag=0;   
					   }
				   }else {
					   if(date>=1 && date<=28) {
						   return date;
					   }else {
						 flag=0;   
					   }
				   }
			   } else if(month == 4 || month == 6 || month == 9 || month == 11) {
				    if(date >= 1 && date <=30){
				    	return date;
				    }else {
				    	flag=0;
				    }
			   }else {
				   if(date >= 1 && date <=31){
				    	return date;
				    }else {
				    	flag=0;
				    }
			   }
			   if(flag==0)
			   {
				   System.out.println("Please enter correct date");   
			   }
		   }
		   
		   
	   } while(flag==0);
	   return date;
   }
   
}
