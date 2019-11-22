package mongodb;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
 
public class update {

	public static void main(String[] args)
	{
		MongoClient client = new MongoClient("localhost", 27017);
		MongoDatabase database = client.getDatabase("info");
		MongoCollection<Document> collection = database
				.getCollection("employee");
		  org.bson.types.ObjectId objectId = new ObjectId("5d9b45260bdd3d491091adeb");
		/*Bson filter = new Document("_id",objectId);
		Bson newValue = new Document("fname","utkarsh");
		Bson newValu = new Document("lname","datta");
		Bson newVal = new Document("number","9654133019");
		Bson newVa = new Document("email","varni@gmail.com");
		Bson updateOperationDocument = new Document("$set", newValue);
		Bson updateOperationDocument1 = new Document("$set", newValu);
		Bson updateOperationDocument2 = new Document("$set", newVal);
		Bson updateOperationDocument3 = new Document("$set", newVa);
		collection.updateOne(filter, updateOperationDocument);
		//collection.updateOne(filter, updateOperationDocument1);
		//collection.updateOne(filter, updateOperationDocument2);
		//collection.updateOne(filter, updateOperationDocument3);
		System.out.println("Data has been successfully updated");
		client.close();
		*/
		  Bson filter = new Document("_id",objectId);
		  Bson newValue = new Document("fname", "karan").append("lname", "sharma").append("number","8865842454").append("email","karan@gmail.com");      
		  Bson updateOperationDocument = new Document("$set", newValue);
		  collection.updateMany(filter, updateOperationDocument);
		   System.out.println("data has been successfully updated");
	}

}
