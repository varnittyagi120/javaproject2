package Abstractconcept;

abstract class A 
{
      private String name;
      private String address;
      private int number;
      public A(String name,String address,int number)
      {
    	  this.name=name;
    	  this.address=address;
    	  this.number=number;
      }
      public void pay()
      {
    	  System.out.println("this is pay method");
      }
      public void mailcheck()
      {
    	  System.out.println("mail a check to "+this.name+" "+this.address);
      }
      public String getname()
      {
    	   return name;
    	   
      }
      public String getaddress()
      {
    	  return address;
      }
      public int getnumber()
      {
    	  return number;
      }
      public void setaddress()
      {
    	  address=this.address;
      }
	   
}
