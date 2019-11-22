package collections;
import java.util.*;
import java.io.*;
public class enummap 
{
    public enum days
    {
    	SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY
    };
	public static void main(String[] args)
	{
		EnumMap<days,String> em=new EnumMap<days,String>(days.class);
        em.put(days.MONDAY,"1");
        em.put(days.TUESDAY,"1");
        em.put(days.WEDNESDAY,"1");
        em.put(days.THURSDAY,"1");
        for(Map.Entry m:em.entrySet())
        {
        	System.out.println("Key is "+m.getKey()+" Corresponding Value is "+m.getValue());
        }
	}

}
