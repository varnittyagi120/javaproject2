package dto;

public class Employee {
	public String fname;
	public String lname;
	public String number;
	public String email;
	public String uid;
    public void setFname(String fname){
   	  this.fname=fname;
    }
    
    public String getFname(){
   	  return fname;
    }
    
    public void setLname(String lname){
   	  this.lname=lname;
    }
    
    public String getLname(){
   	  return lname;
    }
    
    public void setNumber(String number){
   	  this.number=number;
    }
    
    public String getNumber(){
   	  return number;
    }
    
    public void setEmail(String email){
   	  this.email=email;
    }
    
    public String getEmail(){
   	  return email;
    }
	
    public void setUid(String uid){
     	  this.uid=uid;
    }
      
    public String getUid(){
     	  return uid;
    }
}
