package collections;
import java.util.*;
import java.io.*;
public class main3 {

	public static void main(String[] args) 
	{
          ArrayList<sortlistbyage> list=new ArrayList<sortlistbyage>();
          list.add(new sortlistbyage(100,"anmol",23));
          list.add(new sortlistbyage(103,"raghav",20));
          list.add(new sortlistbyage(101,"sumit",21));
          Collections.sort(list,Collections.reverseOrder());
          for(sortlistbyage st:list)
          {
        	  System.out.println(st.rollno+" "+st.name+" "+st.age);
          }
	}

}
