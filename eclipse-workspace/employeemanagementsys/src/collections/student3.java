package collections;
import java.util.*;
import java.io.*;
//main5
public class student3 
{
	public int rollno;
	public String name;
	public int age;
	
	student3(int rollno,String name,int age)
	{
		this.age=age;
		this.name=name;
		this.rollno=rollno;
	}
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
