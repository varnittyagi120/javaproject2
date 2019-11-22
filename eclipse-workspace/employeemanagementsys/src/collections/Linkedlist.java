package collections;
import java.util.*;
import java.io.*;
public class Linkedlist {

	public static void main(String[] args)
	{
		LinkedList<String> ll=new LinkedList();
        ll.add("Arpit");
        ll.add("Sharma");
        ll.add("Ankit");
        ll.add("jaat");
        ll.addFirst("First");
        ll.addLast("Last");
        System.out.println("Peek "+ll.peek());
        System.out.println("Peek First "+ll.peekFirst());
        System.out.println("Peek Last "+ll.peekLast());
        System.out.println("element "+ll.element());
        System.out.println("get "+ll.get(1));
        System.out.println("getFirst "+ll.getFirst());
        System.out.println("getLast "+ll.getLast());
        System.out.println("hashcode "+ll.hashCode());
        System.out.println("indexof "+ll.indexOf("Ankit"));
        System.out.println("lastindexof "+ll.lastIndexOf("jaat"));
        System.out.println("poll "+ll.poll());
        System.out.println("pollFirst "+ll.pollFirst());
        System.out.println("peek "+ll.peek());
        System.out.println("Size "+ll.size());
        System.out.println("setmethod "+ll.set(1,"juju"));
        System.out.println("tostring "+ll.toString());
        System.out.println("clone "+ll.clone());
        System.out.println("contains "+ll.contains("juju"));
        System.out.println("isempty "+ll.isEmpty());
        System.out.println("toarray "+ll.toArray());
        String str=new String();
        //System.out.println("getFirst "+ll.wait());
        Iterator itr=ll.iterator();
        while(itr.hasNext())
        {
        	System.out.println(itr.next());
        }
	}

}
