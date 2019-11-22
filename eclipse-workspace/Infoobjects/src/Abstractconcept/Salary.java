package Abstractconcept;

public class Salary extends A
{
    double salary;
	public Salary(String name, String address, int number,double salary) 
	{
		super(name, address, number);
		setSalary(salary);
		
	}
	public void setSalary(double salary1)
	{
		salary=salary1;
	}
	public double getsalary()
	{
		return salary;
	}
	public void mailcheck()
	{
		System.out.println("this is the salary class");
		System.out.println("mail check to "+this.getname()+" "+this.getaddress());
		
	}
	public double computepay()
	{
		System.out.println("compute pay");
		return salary/2;
	}

}
