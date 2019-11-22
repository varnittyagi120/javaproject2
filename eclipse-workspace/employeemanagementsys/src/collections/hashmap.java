package collections;
import java.util.*;
import java.io.*;
public class hashmap {

	public static void main(String[] args) 
	{
		HashMap<Integer,String> map=new HashMap<Integer,String>();
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");
        for(Map.Entry<Integer,String>entry:map.entrySet())
        {
        	System.out.println(entry.getKey()+"   "+entry.getValue());
        }
        Set set=map.entrySet();
        Iterator itr=set.iterator();
        while(itr.hasNext())
        {
        	Map.Entry entry=(Map.Entry)itr.next();
        	System.out.println(entry.getKey()+" "+entry.getValue());
        }
        for(Map.Entry m:map.entrySet())
        {
        	System.out.println(m.getKey()+" "+m.getValue());
        }
        System.out.println("$$$$$$$$$$$ Here $$$$$$$$$");
        map.entrySet()
        .stream().sorted(Map.Entry.comparingByKey())
        .forEach(System.out::println);
        map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
        .forEach(System.out::println);
        map.replaceAll((k,v)->"Ajay");
        for(Map.Entry m:map.entrySet())
        {
        	System.out.println(m.getKey()+" "+m.getValue());
        }
        
	}

}
