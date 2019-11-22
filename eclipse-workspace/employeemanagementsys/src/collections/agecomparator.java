package collections;
import java.util.*;
import java.io.*;
public class agecomparator implements Comparator
{
	public int compare(Object o1, Object o2)
	{
	    student2 s1=(student2)o1;
	    student2 s2=(student2)o2;
		return s1.name.compareTo(s2.name);
	}

}
