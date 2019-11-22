package basic;

public class superkeywordmain extends superkeyword
{
	public float salary=2000;
	superkeywordmain()
	{
		System.out.println("in child class constructor");
	}
    public  void print()
    {
    	System.out.println("salary "+super.salary);
    }
    public void message()
    {
    	System.out.println("I am in child class");
    }
    public void display()
    {
    	super.message();
    	message();
    }
	public static void main(String[] args)
	{
		superkeywordmain obj=new superkeywordmain();
		//obj.print();
        //obj.display();
	}

}
