package collections;
import java.util.*;
import java.io.*;
public class agecomparator1 implements Comparator<student2>
{

	public int compare(student2 o1, student2 o2)
	{
		if(o1.age==o2.age)
		{
		   return 0;	
		}
		else if(o1.age>o2.age)
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
	      
}
