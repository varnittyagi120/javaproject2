package mongodb;
import com.mongodb.client.FindIterable;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mysql.cj.xdevapi.JsonParser;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.ErrorCategory;
import com.mongodb.Mongo;
import com.mongodb.MongoClient; 
import com.mongodb.MongoCredential;
import com.mongodb.MongoWriteException;  
import java.io.*;
import java.util.*;
public class read
{

	public static void main(String[] args) 
	{
		try
		{
		//	java.util.logging.Logger.getLogger("org.mongodb.driver").setLevel(Level.SEVERE);

			 MongoClient mongo = new MongoClient( "localhost" , 27017 );
		      System.out.println("Connected to the database successfully");  
		      MongoDatabase database = mongo.getDatabase("info"); 
		      //MongoCollection collection = database.getCollection("movie");
	         /* Document mickeyMouse = new Document();
	          mickeyMouse.append("_id", 1)
	          .append("characterName", "Mickey Mouse")
	          .append("creator", new Document("firstName", "Walt").append("lastName", "Disney"))
	          .append("pet", "Goofy");
	          collection.insertOne(mickeyMouse);
	          System.out.println("Successfully inserted documents. \n");
	          */
		      //FindIterable<Document> iterDoc = collection.find();
		      //MongoCursor<Document> dbc = iterDoc.iterator();
		      //DBCursor cursor = (DBCursor) collection.find();
		      //while(cursor.hasNext())
		      //{
		       //   System.out.println(cursor.next());
		      //}
				      MongoCollection<Document> collection = database
						.getCollection("movie");
				       System.out.println("Total documents : "+collection.countDocuments());
				       System.out.println("Total documents : "+collection.count());
				     //  System.out.println("Total documents : "+collection.aggregate(arg0));
				       /* System.out.println("Enter uuid");
			              Scanner sc=new Scanner(System.in);
			              String str=sc.nextLine();
			              org.bson.types.ObjectId objectId = new ObjectId(str);
			              System.out.println("id is : "+objectId.getClass().getName());*/
			           List<Document> documents = (List<Document>) collection.find().into(
					   new ArrayList<Document>());
		               int flag=0;
         
                       for(Document document : documents)
		               {
		            	  // if(objectId.equals(document.getObjectId("_id")))
		            	  // {
		            	    //   System.out.print("id is :  "+document.getObjectId("_id").getClass().getName());
		            	       //System.out.println("String is : "+str);
		                       System.out.println(document);
		                       flag=1;
		            	   //}
		               }
		            if(flag==0)
		            {
		            	System.out.println("Id not found");
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

	private static Object ObjectId(ObjectId objectId) {
		// TODO Auto-generated method stub
		return null;
	}

}
