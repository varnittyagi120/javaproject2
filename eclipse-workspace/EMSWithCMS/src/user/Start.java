package user;
import java.util.Scanner;
import dao.DatabaseQueries;
import service.CMSManagement;
import service.CRUDContainer;
import service.EMSManagement;
public class Start<T> {
	public static Scanner scanner=new Scanner(System.in);
	public T object;
	public static int exitSign() {
	    	System.out.println("If u want to continue press 0  , else any other key for going one step back");
			int sign=scanner.nextInt();
		return sign;
    }
	public static void main(String[] args) {
		  DatabaseQueries databaseQueries = new DatabaseQueries();
		  EMSManagement emsManagement=new EMSManagement();
		  CMSManagement cmsManagement=new CMSManagement();
		  int sign;
	    	     do {
	    	    	  System.out.println("||##############################||");
			    	  System.out.println("||        Enter 1 for EMS       ||");
			    	  System.out.println("||        Enter 2 for CMS       ||");
			    	  System.out.println("||        Enter 3 for Exit      ||");
			    	  System.out.println("||##############################||");
			    	  System.out.println("Enter your choice ");
			    	 sign=1; 
	    	    	 try {  
					    	  int choiceInInteger = scanner.nextInt();
					    	  switch(choiceInInteger){
					    	     case 1:
					    	    	   choiceCasesOfCruds(emsManagement,databaseQueries);
					    	    	   sign=exitSign();
					    	    	   break;
					    	     case 2:
					  	    	       choiceCasesOfCruds(cmsManagement,databaseQueries);
					  	    	       sign=exitSign();
					    	    	   break;
					    	     case 3:
					    	    	   sign=1;
					    	    	   break;
					    	     default:
					                   System.out.println("Please choose from given options");
					                   sign=0; 
					    	 }
			    	  }catch(Exception exception) {
				    	  System.out.println("Please enter only integers");
				    	  scanner.next();
				    	  sign=0;
				      }
	    	  }while(sign==0);
          System.out.println("Your program has been successfully terminated..........");
          databaseQueries=null;
          System.gc();
	}
	public static <T> void choiceCasesOfCruds(T object,DatabaseQueries databaseQueries)
	{
		int sign;
  		do {
  			    String managementSystemName;
  			    if(object.getClass().getName().equals("service.EMSManagement")) {
  			    	managementSystemName="Welcome you are in EMS";
  			    }else {
  			    	managementSystemName="Welcome you are in CMS";
  			    }
  			    System.out.println("############################################");
  			    System.out.println("||        "+managementSystemName+"          ||");
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
	  		    System.out.println("Enter Your Choice");
			    try {   
			    	        int choiceInInteger = scanner.nextInt();
			    	        switch(choiceInInteger){
						  	    case 1:
						  	    	   ((CRUDContainer) object).add(databaseQueries);
						  	    	   sign=exitSign();
						  		       break;
						  	   case 2:
						  	    	   ((CRUDContainer) object).read(databaseQueries);
						  	    	   sign=exitSign();
						  	    	   break;
						  	    case 3:
						  	    	   ((CRUDContainer) object).readall(databaseQueries);
						  	    	   sign=exitSign();
						  	    	   break;
						  	    case 4:
						  	    	   ((CRUDContainer) object).update(databaseQueries);
						  	    	   sign=exitSign();
						  	    	   break;
						  	    case 5:
						  	    	   ((CRUDContainer) object).delete(databaseQueries);
						  	    	   sign=exitSign();
						  	           break;
						  	    case 6:
						  	    	   sign=1;
						  	    	   break;
						        default:
						        	   System.out.println("Please Choose from above five options");
						        	   sign=0;
						               Thread.sleep(2000);
						  		       
						  	}
			   } catch(Exception exception) {
					      System.out.println("Please enter only integers");
					      scanner.next();
					  	  sign=0;	       
			     }
					  	
	      } while(sign==0);
	}
    
}
