package LambdaExpression;

public class LambdaExpressionExample2 {

	public static void main(String[] args) {
         Message obj=(message)->{
        	 String str1="parav";
        	 String str2=message+"parav";
        	 return str2;
         };
         System.out.println(obj.message("hello"));
	}

}
