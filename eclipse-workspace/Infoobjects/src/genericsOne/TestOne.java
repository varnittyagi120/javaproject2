package genericsOne;

import java.util.ArrayList;

public class TestOne {

	public static <T extends Comparable<T>> int countGreaterNumber(T[] array,T i) {
		int count=0;
		for(T e:array) {
			if(e.compareTo(i)>0){
				++count;
			}
		}
		return count;
	}
	public static void main(String[] args) {
        int arr[]=new int[5];
		arr[0]=1;
		arr[0]=2;
		arr[0]=5;
		arr[0]=6;
		arr[0]=7;
		TestOne testOne=new TestOne();
		//testOne.countGreaterNumber(arr,4);
	}

}
