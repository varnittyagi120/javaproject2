package collections;
import java.util.*;
import java.io.*;
public class main {

	public static void main(String[] args)
	{
		Book b1=new Book(200,"Bob","c++",1);
		Book b2=new Book(300,"shiv","u can win",2);
		Book b3=new Book(200,"raghav","let us c",3);
		ArrayList<Book> al=new ArrayList<Book>();
		al.add(b1);
		al.add(b2);
		al.add(b3);
		for(Book obj:al)
		{
			System.out.println(obj.price+" "+obj.quantity+" "+obj.bookname+" "+obj.author);
		}
	}

}
