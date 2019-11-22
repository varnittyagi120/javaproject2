package mongodb;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import com.mongodb.ErrorCategory;
import com.mongodb.MongoClient; 
import com.mongodb.MongoCredential;
import com.mongodb.MongoWriteException;  
public class ConnectToDb
{

	public static void main(String[] args) 
	{
       try
       {
		 MongoClient mongo = new MongoClient( "localhost" , 27017 );
	      System.out.println("Connected to the database successfully");  
	      MongoDatabase database = mongo.getDatabase("info"); 
	      MongoCollection collection = database.getCollection("employee");
         Document mickeyMouse = new Document();
          mickeyMouse.append("characterName", "Mickey Mouse")
          .append("creator", new Document("firstName", "Walt").append("lastName", "Disney"))
          .append("pet", "Goofy");
          collection.insertOne(mickeyMouse);
          System.out.println("Successfully inserted documents. \n");
          
	      //FindIterable<Document> iterDoc = collection.find();
	      //MongoCursor<Document> dbc = iterDoc.iterator();

	     /* MongoCollection<org.bson.Document> collection = database.getCollection("movie");
          System.out.println(collection.find());
	      System.out.println("Credentials ::"+ credential);	*/
	     
	      

	}
	catch (MongoWriteException mwe) 
	{
        if (mwe.getError().getCategory().equals(ErrorCategory.DUPLICATE_KEY)) 
        {
            System.out.println("Document with that id already exists");
        }
	}
 }
}
