package collections;
//student with comparable
//main2
import java.util.*;
//import java.io.*;
public class student1 implements Comparable<student1>
{
       public String name;
       student1(String name)
       {
    	   this.name=name;
       }
	public int compareTo(student1 person) 
	{
		return name.compareTo(person.name);
	}
}
