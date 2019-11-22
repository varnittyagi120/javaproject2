package collections;
import java.util.*;
import java.io.*;
public class test1 {

	public static void main(String[] args) 
	{
		HashMap<Integer,Book1> map=new HashMap<Integer,Book1>();
        Book1 b1=new Book1(300,"shiv","u can",1);
        Book1 b2=new Book1(400,"khera","win",2);
        Book1 b3=new Book1(500,"yashvant","c++",1);
        map.put(1,b1);
        map.put(2,b2);
        map.put(3,b3);
        for(Map.Entry<Integer,Book1>entry:map.entrySet())
        {
        	
        	System.out.println(entry.getKey()+" "+entry.getValue().price+" "+entry.getValue().author+" "+entry.getValue().bookname+" "+entry.getValue().quantity);
        }
	}

}
