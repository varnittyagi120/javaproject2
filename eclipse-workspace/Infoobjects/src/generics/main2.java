package generics;
//multiple parameters with generics
public class main2 {
	public static void main(String[] args)
	{
	multipleParametersWithGeneric<Integer,String> obj1=new multipleParametersWithGeneric<Integer,String>(100,"geeks");
    obj1.printObjects();
	}
}
