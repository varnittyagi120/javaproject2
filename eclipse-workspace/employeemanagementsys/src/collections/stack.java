package collections;
import java.util.*;
import java.io.*;
public class stack {

	public static void main(String[] args) 
	{
	    Stack<String> st=new Stack<String>();
        st.push("Raghav");
        st.push("Singhal");
        st.push("abhi");
        st.push("bhuvi");
        System.out.println(st.pop());
        Iterator itr=st.iterator();
        while(itr.hasNext())
        {
        	System.out.println(itr.next());
        }
	}

}
