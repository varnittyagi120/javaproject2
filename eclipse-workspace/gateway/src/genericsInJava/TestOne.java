package genericsInJava;

import java.util.Map;

public class TestOne <T extends Person>{
      public void print(T stringo,T intoo,T obj,Map<T,T> map) {
    	  System.out.println(stringo+" "+intoo);
    	  for(Map.Entry<T, T>entry:map.entrySet()) {
    		  System.out.println(entry.getValue());
    	  }
      }
}
