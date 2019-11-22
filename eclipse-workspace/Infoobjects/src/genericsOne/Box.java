package genericsOne;

public class Box<T> {
    T t;
    public void setValue(T t) {
    	this.t=t;
    }
    public T getValue() {
    	return t;
    }
}
