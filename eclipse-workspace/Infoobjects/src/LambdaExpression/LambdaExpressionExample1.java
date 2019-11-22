package LambdaExpression;

public class LambdaExpressionExample1
{
	public static void main(String[] args) {
          int t=10;
          Drawable d2=(a,b)->(a+b);
          System.out.println(d2.sum(1,2));
	}

}
