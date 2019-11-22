package generics;
//genricclass
public class main1 {

	public static void main(String[] args) {
		genericclass<Integer> obj=new genericclass<Integer>(12); 
		System.out.println(obj.getObjects());
		genericclass<String> obj1=new genericclass<String>("geeksforgeeks"); 
		System.out.println(obj1.getObjects());
	}

}
