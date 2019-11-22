package singletonPattern;

public class Singleton {

	public static void main(String[] args) {
         Abc abc = Abc.getObject();
         Abc obj = Abc.getObject();
         System.out.println(abc);
         System.out.println(obj);
	}

}
