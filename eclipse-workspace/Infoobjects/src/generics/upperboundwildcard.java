package generics;
import java.util.*;
public class upperboundwildcard {
    public static Double add(List<?extends Number>num)
    {
    	Double sum=0.0;
    	for(Number n:num)
    	{
    		sum=sum+n.doubleValue();
    	}
    	return sum;
    }
	public static void main(String[] args) 
	{
		List<Integer> list1=new ArrayList<Integer>();
		list1.add(20);
		list1.add(30);
		System.out.println(add(list1));
		List<Double> list2=new ArrayList<Double>();
        list2.add(30.0);
        list2.add(40.0);
        System.out.println(add(list2));
	}

}
