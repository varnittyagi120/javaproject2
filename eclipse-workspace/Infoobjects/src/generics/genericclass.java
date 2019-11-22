package generics;

public class genericclass<T> {
       T obj;
       genericclass(T obj)
       {
    	   this.obj=obj;
       }
       public T getObjects()
       {
    	   return obj;
       }
}
