package collections;
import java.util.*;
import java.io.*;
//studentenum
public class main1
{
    public enum keys
    {
    	one,two,three
    };
	public static void main(String[] args)
	{
		 EnumMap<keys,studentenum> em=new EnumMap<keys,studentenum>(keys.class);
		 studentenum obj1=new studentenum(100,"shivam",20);
		 studentenum obj2=new studentenum(101,"Kumar",21);
		 studentenum obj3=new studentenum(102,"Raghav",22);
		 em.put(keys.one, obj1);
		 em.put(keys.two, obj2);
		 em.put(keys.three, obj3);
		 for(Map.Entry m:em.entrySet())
		 {
			 System.out.println("Keys "+m.getKey()+" values "+m.getValue());
			 studentenum b=(studentenum)m.getValue();
			 System.out.println(b.rollno+" "+b.name+" "+b.age);
		 }
	}

}
