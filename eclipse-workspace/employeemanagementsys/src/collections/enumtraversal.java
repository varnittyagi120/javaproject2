package collections;
import java.util.*;
import java.io.*;
public class enumtraversal 
{
	public static void main(String[] args) 
	{
	     Vector<String> v=new Vector<String>();	
         v.add("varnit");
         v.add("tyagi");
         v.add("nilesh");
         v.add("pandey");
         Enumeration e=v.elements();
         while(e.hasMoreElements())
         {
        	 System.out.println(e.nextElement());
         }
	}
}
