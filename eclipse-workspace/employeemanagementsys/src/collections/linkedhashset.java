package collections;
import java.io.*;
import java.util.*;
public class linkedhashset {

	public static void main(String[] args) 
	{
	   LinkedHashSet<String> llh=new LinkedHashSet<String>();
	   llh.add("varnit");
	   llh.add("Varnit");
	   llh.add("tyagi");
	   llh.add("nilesh");
	   System.out.println(llh.size());
	   Iterator<String> itr=llh.iterator();
	   while(itr.hasNext())
	   {
		   System.out.println(itr.next());
	   }

	}

}
