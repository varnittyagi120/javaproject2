package collections;
import java.util.*;
import java.io.*;
public class main5
{

	public static void main(String[] args) 
	{
		ArrayList<student3> list=new ArrayList<student3>();
		list.add(new student3(200,"varnit",10));
		list.add(new student3(205,"ankit",15));
		list.add(new student3(300,null,12));
		/*System.out.println("sort by age");
		Comparator<student3> comp1=Comparator.comparing(student3::getName);
		Collections.sort(list,comp1);
		for(student3 st:list)
		{
			System.out.println(st.name+" "+st.age+" "+st.rollno);
		}
        System.out.println("sort by name");
        Comparator<student3> comp2=Comparator.comparing(student3::getAge);
        Collections.sort(list,comp2);
        for(student3 st:list)
        {
        	System.out.println(st.name+" "+st.age+" "+st.rollno);
        }*/
        //a list that contains null also null first or null last method
		System.out.println("After sorting using nullfirstmethod");
        Comparator<student3> comp3=Comparator.comparing(student3::getName,Comparator.nullsFirst(String::compareTo));
        Collections.sort(list,comp3);
        for(student3 st:list)
        {
        	System.out.println(st.name+" "+st.age+" "+st.rollno);
        }
        System.out.println("After sorting using nullLastmethod");
        Comparator<student3> comp4=Comparator.comparing(student3::getName,Comparator.nullsLast(String::compareTo));
        Collections.sort(list,comp4);
        for(student3 st:list)
        {
        	System.out.println(st.name+" "+st.age+" "+st.rollno);
        }
	}

}
