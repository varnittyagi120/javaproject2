package generics;
import java.util.*;
public class lowerboundwildcard 
{
    public static void show(List<?super Integer>list)
    {
    	for(Object o:list)
    	{
    		System.out.println(o);
    	}
    }
	public static void main(String[] args)
	{
        List<Integer> list1=new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        show(list1);
        List<Number> list2=Arrays.asList(1.0,2.0,3.0);
        show(list2);
	}
}
