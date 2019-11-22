package dao;

public  class Databasequeries<T extends Person> {
//	 public static Databasequeries databaseQueries= new Databasequeries();
//     
//     private Databasequeries() {
//   	  System.out.println("constructor");
//     }
//     
//     public static Databasequeries getObject() {
//   	  return databaseQueries;
//     }
	
	 public static Databasequeries<?> databaseQueries= new Databasequeries<>();
     private Databasequeries() {
	  System.out.println("constructor");
  }
  
  public static Databasequeries<?> getObject() {
	  return databaseQueries;
  }
	

	   
}
