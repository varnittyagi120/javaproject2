package genericsOne;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Test {

	public static <T1,T2> void print(Map<T1,T2> map) {
		//T1 string="?";
	}
	public static void main(String[] args) {
		Map<String,String> map=new LinkedHashMap<String,String>();
		map.put("a", "abc");
		map.put("b", "xyz");
		print(map);
	}

}
