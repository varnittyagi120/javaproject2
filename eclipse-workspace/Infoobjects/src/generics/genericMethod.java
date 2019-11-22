package generics;

public class genericMethod {
    public <T> void printData(T element) {
    	System.out.println(element.getClass().getName()+" = "+element);
    }
	public static void main(String[] args) {
		genericMethod obj=new genericMethod();
		obj.printData(10);
		genericMethod obj1=new genericMethod();
	  	obj1.printData("Geeksforgeeks");
	  	genericMethod obj2=new genericMethod();
		obj2.printData(10.00);

	}

}
