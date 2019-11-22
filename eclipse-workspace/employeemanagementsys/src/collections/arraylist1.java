package collections;
import java.util.*;
import java.io.*;
public class arraylist1 {

	public static void main(String[] args)
	{
	    student obj1=new student(100,"varnit",21);
	    student obj2=new student(101,"tyagi",22);
	    student obj3=new student(102,"raghav",23);
        ArrayList<student> list=new ArrayList<student>();
        list.add(obj1);
        list.add(obj2);
        list.add(obj3);
        Iterator itr=list.iterator();
        while(itr.hasNext())
        {
        	student st=(student)itr.next();
        	System.out.println(st.rollno+" "+st.name+" "+st.age);
        }
	}

}
