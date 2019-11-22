package collections;
import java.util.*;
import java.io.*;
public class main4
{

	public static void main(String[] args) 
	{
		ArrayList<student2> list=new ArrayList<student2>();
	    list.add(new student2(100,"raghav",25));
	    list.add(new student2(101,"shubham",20));
	    list.add(new student2(102,"bhuvi",21));
	    System.out.println("Sort by name");
	    Collections.sort(list,new namecomparator());
	    Iterator itr=list.iterator();
	    while(itr.hasNext())
	    {
	    	student2 obj=(student2)itr.next();
	    	System.out.println(obj.name+" "+obj.age+" "+obj.rollno);
	    	
	    }
	    System.out.println("Sort by age");
        Collections.sort(list,new agecomparator1());
        Iterator itr1=list.iterator();
        while(itr1.hasNext())
        {
        	student2 obj1=(student2)itr1.next();
        	System.out.println(obj1.name+" "+obj1.age+" "+obj1.rollno);
        }
	}

}
