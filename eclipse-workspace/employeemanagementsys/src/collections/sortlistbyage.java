package collections;
import java.util.*;
//main3
public class sortlistbyage implements Comparable<sortlistbyage> 
{
     public int rollno;
     public String name;
     public int age;
     sortlistbyage(int rollno,String name,int age)
     {
    	 this.rollno=rollno;
    	 this.name=name;
    	 this.age=age;
     }
	public int compareTo(sortlistbyage st)
	{
		if(age==st.age)
		{
			return 0;
		}
		else if(age<st.age)
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
}
