package user;
import java.util.Scanner;
import dao.DatabaseQueries;
import service.EMSManagement;
public class Start<T> {
	
	public static Scanner scanner=new Scanner(System.in);
	public static DatabaseQueries databaseQueries = new DatabaseQueries();
	public static int exitSign() {
    	System.out.println("If u want to continue press 0  , else any other key for going one step back");
		int sign=scanner.nextInt();
		
		return sign;
    }
	public static void main(String[] args) {
		  EMSManagement emsManagement=new EMSManagement();
    	  System.out.println("||##############################||");
    	  System.out.println("||        Enter 1 for EMS       ||");
    	  System.out.println("||        Enter 2 for EMS       ||");
    	  System.out.println("||        Enter 3 for Exit      ||");
    	  System.out.println("||##############################||");
    	  System.out.println("Enter your choice");
    	  int choice=scanner.nextInt();
    	  switch(choice){
    	     case 1:
    	    	   choiceCasesOfCruds(emsManagement);
    	    	   break;
    	     case 2:
    	    	   break;
    	     case 3:
    	    	   break;
    	     default:
                   System.out.println("Wrong choice");    	    	 
    	    	 
    	  }
          System.out.println("Your program has been successfully terminated..........");
          databaseQueries=null;
          System.gc();
	}
	public static <T> void choiceCasesOfCruds(T object)
	{
		int sign;
  		do {
			    System.out.println("############################################");
				System.out.println("||        Enter 1 for Add an entry        ||");
				System.out.println("||        Enter 2 for Read an entry       ||");
				System.out.println("||        Enter 3 view all entries        ||");
				System.out.println("||        Enter 4 for Update an entry     ||");
				System.out.println("||        Enter 5 for Delete an entry     ||");
				System.out.println("||        Enter 6 for exit                ||");
				System.out.println("############################################");
			  	int choice;
			  	sign=1;
		  	    //choice=scanner.nextInt();
	  		    System.out.println("Enter Your Choice");
			    try {   
					  	    choice=scanner.nextInt();
					  	    switch(choice)
						  	{
						  	    case 1:
						  	    	   ((EMSManagement) object).add(databaseQueries);
						  	    	   sign=exitSign();
						  		       break;
						  	  /*  case 2:
						  	    	   ((EMSManagement) object).read(databaseQueries);
						  	    	   sign=exitSign();
						  	    	   break;
						  	    case 3:
						  	    	   ((EMSManagement) object).readall(databaseQueries);
						  	    	   sign=exitSign();
						  	    	   break;
						  	    case 4:
						  	    	   ((EMSManagement) object).update(databaseQueries);
						  	    	   sign=exitSign();
						  	    	   break;
						  	    case 5:
						  	    	   ((EMSManagement) object).delete(databaseQueries);
						  	    	   sign=exitSign();
						  	           break;*/
						  	    case 6:
						  	    	   sign=1;
						  	    	   break;
						        default:
						        	   System.out.println("Please Choose from above five options");
						        	   sign=0;
						               Thread.sleep(2000);
						  		       
						  	}
			   } catch(Exception exception) {
					      System.out.println("Error : Enter only integer ");
					  	  sign=0;	       
			     }
					  	
	      } while(sign==0);
	}

}
