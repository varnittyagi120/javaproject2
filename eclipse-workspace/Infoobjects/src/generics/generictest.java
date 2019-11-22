package generics;
import java.util.*;
public class generictest
{
    public static void drawshapes(List<?extends shape>lists)
    {
    	for(shape s:lists)
    	{
    		s.draw();
    	}
    }
	public static void main(String[] args)
	{
       List<rectangle> list1=new ArrayList<rectangle>();
       list1.add(new rectangle());
       List<circle> list2=new ArrayList<circle>();
       list2.add(new circle());
       list2.add(new circle());
       drawshapes(list1);
       drawshapes(list2);
	}

}
