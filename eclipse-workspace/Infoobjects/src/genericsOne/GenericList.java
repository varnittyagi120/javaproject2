package genericsOne;

import java.util.ArrayList;
import java.util.List;

public class GenericList {
    public static <T> void printlist(List<T> list) {
    	for(T e:list) {
    		System.out.println(e);
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        List<Integer> list=new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        printlist(list);
        List<String> list1=new ArrayList<String>();
        list1.add("adf");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        printlist(list1);
	}

}
