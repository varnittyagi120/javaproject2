package collections;
import java.util.*;
import java.io.*;
public class main2
{

	public static void main(String[] args)
	{
	    ArrayList<student1> al=new ArrayList<student1>();
	    al.add(new student1("raghav"));
	    al.add(new student1("mahi"));
	    al.add(new student1("bhuvi"));
	    al.add(new student1("boom-boom"));
	    Collections.sort(al);
	    for(student1 obj:al)
	    {
	    	System.out.println(obj.name);
	    }

	}

}
