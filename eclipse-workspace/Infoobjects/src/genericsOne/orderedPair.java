package genericsOne;

public class orderedPair <K,V> implements Pair<K,V>{
  
       private K k;
       private V v;
       public orderedPair(K k,V v) {
    	   this.k=k;
    	   this.v=v;
       }
       public K getKey() {
    	   return k;
       }
       public V getValue() {
    	   return v;
       }
       public static void main(String[] args) {
    	   orderedPair<String, Integer> object = new orderedPair<String, Integer>("Varnit", 1);
    	   System.out.println("Name : "+object.getKey());
    	   System.out.println("Id : "+object.getValue());
    	   orderedPair<String, String> object1 = new orderedPair<String, String>("Hello","World");
    	   System.out.println("String1 : "+object1.getKey());
    	   System.out.println("String2 : "+object1.getValue());
       }
}
