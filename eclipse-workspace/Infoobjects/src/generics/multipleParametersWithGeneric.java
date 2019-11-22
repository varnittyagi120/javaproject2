package generics;

public class multipleParametersWithGeneric<T,U> {
	 T obj1;
	 U obj2;
	 multipleParametersWithGeneric(T obj1,U obj2)
     {
  	   this.obj1=obj1;
  	   this.obj2=obj2;
     }
     public void printObjects()
     {
  	      System.out.println(obj1);
  	      System.out.println(obj2);
     }
}
