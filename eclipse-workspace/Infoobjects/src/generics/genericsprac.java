package generics;
import java.util.*;
public class genericsprac {

	public static void main(String[] args) 
	{
	   List list=new ArrayList();
	   list.add("11");
	   list.add(11);
	   System.out.println(list);
	    Iterator itr=list.iterator();
	    while(itr.hasNext())
	    {
	    	System.out.println(itr.next());
	    }
	}

}
