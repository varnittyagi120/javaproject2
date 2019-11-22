package mongodb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class delete 
{

	public static void main(String[] args) 
	{
		try
		{
			 MongoClient mongo = new MongoClient( "localhost" , 27017 );
		      System.out.println("Connected to the database successfully");  
		      MongoDatabase database = mongo.getDatabase("info"); 
		      MongoCollection<Document> collection = database.getCollection("employee");
			  System.out.println("Enter uuid");
			  Scanner sc=new Scanner(System.in);
			  String str=sc.nextLine();
			  org.bson.types.ObjectId objectId = new ObjectId(str);
			  System.out.println("id is : "+objectId.getClass().getName());
			  List<Document> documents = (List<Document>) collection.find().into(
		      new ArrayList<Document>());
		      int flag=0;         
              for(Document document : documents)
		      {
		          if(objectId.equals(document.getObjectId("_id")))
		            {
		                 flag=1;
		            }
		       }
		            if(flag==0)
		            {
		            	System.out.println("Id not found");
		            }
		            else
		            {
		            	collection.deleteOne(new Document("_id", objectId));
		            	System.out.println("Data has successfully deleted");
		            }
		     /* MongoCollection<org.bson.Document> collection = database.getCollection("movie");
	          System.out.println(collection.find());
		      System.out.println("Credentials ::"+ credential);	*/
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}

	}

}
