package LambdaExpression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaExpressionExample {

	public static void main(String[] args) {
        List<Product> list=new ArrayList<Product>();
        list.add(new Product(2,"Delhi",23.4f));
        list.add(new Product(1,"Us",12.5f));
        list.add(new Product(3,"America",28.9f));
        Collections.sort(list,(p1,p2)->{
        	return p1.name.compareTo(p2.name);
        });
        for(Product obj:list) {
        	System.out.println(obj.id+" "+obj.name+" "+obj.price);
        }
	}

}
