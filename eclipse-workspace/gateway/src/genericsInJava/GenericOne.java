package genericsInJava;

import java.util.ArrayList;
import java.util.List;

public class GenericOne<T> {
    public  List<List<T>> add(){
    	List<List<T>> listOfObjects = new ArrayList<>();
    	try {
    		List<String> listOfStrings = new ArrayList<>();
    		listOfStrings.add("one");
    		listOfStrings.add("two");
    		listOfStrings.add("three");
    		listOfObjects.add((List<T>) listOfStrings);
    	}catch(Exception exception) {
    		exception.printStackTrace();
    	}
    	return listOfObjects;
    }
}
