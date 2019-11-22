package genericsOne;

import java.util.List;
import java.util.Arrays;

public class TestTwo {
	/*public static double sumOfList(List<? extends Number> list) {
	    double s = 0.0;
	    for (Number n : list)
	        s += n.doubleValue();
	    return s;
	}*/
	public static void printList(List<?> list) {
	    for (Object elem: list)
	        System.out.print(elem + " ");
	    System.out.println();
	}
	public static void main(String[] args) {
		//	List<Integer> li = Arrays.asList(1, 2, 3);
			//System.out.println("sum = " + sumOfList(li));

			//List<Double> ld = Arrays.asList(1.2, 2.3, 3.5);
			//System.out.println("sum = " + sumOfList(ld));
		List<Integer> li = Arrays.asList(1, 2, 3);
		List<String>  ls = Arrays.asList("one", "two", "three");
		printList(li);
		printList(ls);
	}

}
