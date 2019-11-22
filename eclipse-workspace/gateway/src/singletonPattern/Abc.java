package singletonPattern;

public class Abc {
         static Abc obj = new Abc();
         private Abc() {
        	 System.out.println("constructor");
         }
         public static Abc getObject() {
        	 return obj;
         }
}
