package singletonPatternOne;

import singletonPattern.Abc;

public class Bcd {

	public static void main(String[] args) {
          Abc abc = Abc.getObject();
          System.out.println(abc);
	}

}
