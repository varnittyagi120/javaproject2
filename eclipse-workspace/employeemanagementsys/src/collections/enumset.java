package collections;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;

public class enumset 
{
	 enum  days
	 {
		 SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY
	 }

	public static void main(String[] args) 
	{
       Set<days> set=EnumSet.of(days.WEDNESDAY,days.FRIDAY);
       Iterator<days> itr=set.iterator();
       while(itr.hasNext())
       {
    	   System.out.println(itr.next());
       }
       Set<days> set1=EnumSet.allOf(days.class);
       System.out.println(set1);
       Set<days> set2=EnumSet.noneOf(days.class);
       System.out.println(set2);
	}

}