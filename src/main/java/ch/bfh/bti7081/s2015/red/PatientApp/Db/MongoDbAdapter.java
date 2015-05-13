package ch.bfh.bti7081.s2015.red.PatientApp.Db;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import org.bson.types.ObjectId;
import org.reflections.Reflections;

import com.google.gson.Gson;
import com.google.gwt.core.server.ServerGwtBridge.Properties;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.util.JSON;


/**
 * An adapter for the document base database mongoDb
 * 
 * @author James Mayr
 *
 */
public class MongoDbAdapter {
	private MongoClient mongoDbClient;
	private DB db;
	private DBCollection collection;
	
	public MongoDbAdapter()
	{
		InputStream input = null;
		java.util.Properties prop = new java.util.Properties();
		try {
			input = new FileInputStream("src/main/resources/ch/bfh/bti7081/s2015/red/PatientApp/db.properties");
			
			prop.load(input);
		
			MongoCredential credential = MongoCredential.createCredential(prop.getProperty("user"), 
					prop.getProperty("db"), prop.getProperty("pass").toCharArray());

			mongoDbClient = new MongoClient(new ServerAddress(prop.getProperty("server")),Arrays.asList(credential));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		db = mongoDbClient.getDB("patientapp");
		collection = db.getCollection("patient-data");
	}
	
	/**
	 * update  a given collection and stores the updates in the database 
	 * @param entries
	 */
	public void updateCollection(ArrayList<Persistable> entries)
	{
		/*
		 * update all Persistable objects
		 */
		for(Persistable entry : entries)
		{
			updateEntry(entry);
		}
	}
	
	/**
	 * update  a given entry and stores the update into database 
	 * @param entry
	 */
	public void updateEntry(Persistable entry)
	{
		/*
		 * convert from json string to a mongo db specific format 
		 */
		String json = entry.serialize();
		BasicDBObject updateQuery = new BasicDBObject();
		updateQuery.append("_id", new ObjectId(entry.getId()));
		
		Object object = JSON.parse(json);
		BasicDBObject document = (BasicDBObject) object;
		
		collection.update(updateQuery, document);
	}
	
	/**
	 * get the actual Data from an entry from the database
	 * @param persistable
	 * @return
	 */
	public Persistable getEntryFromDatabase(Persistable persistable)
	{
	
		BasicDBObject query = new BasicDBObject();
	    query.put("_id", new ObjectId(persistable.getId()));
	    DBObject dbObj = collection.findOne(query);
	    
		Gson gson = new Gson();
		Persistable createdClass  =  generateClassFromDbObject(dbObj,persistable);
		createdClass.setId(dbObj.get("_id").toString());
		
		return (Persistable)createdClass;
	}
	/**
	 * get a collection of the given datatype
	 * inclusive it's subtypes
	 * @param persistable
	 */
	public ArrayList<Persistable> getSpecificCollection(Persistable persistable,boolean withSubclasses)
	{
		String condition ="";
		BasicDBObject query = new BasicDBObject();
		if(withSubclasses)
		{
			BasicDBList or = new BasicDBList();
			
			Reflections reflections = new Reflections("ch.bfh.bti7081.s2015.red.PatientApp.Model");
			Set<?> subTypes = reflections.getSubTypesOf(persistable.getClass());
			for(Object subtype : subTypes )
			{
				or.add(new BasicDBObject("type",subtype.getClass().toString()));
			}
			or.add(new BasicDBObject("type",persistable.getClass().toString()));
			query.put("$or", or);
			return getQueryResult(query,persistable);
		}
		else
		{
			return getSpecificCollection(persistable);
		}
		

	}
	/**
	 * get a collection of the given datatype
	 * @param persistable
	 */
	public ArrayList<Persistable> getSpecificCollection(Persistable persistable)
	{
		BasicDBObject query = new BasicDBObject();
		query.put("type", persistable.getClass().toString());
		return getQueryResult(query,persistable);

	}
	/**
	 * insert a new collection into database
	 * @param entries
	 */
	public void insertIntoDatabase(ArrayList<Persistable>entries)
	{
		for(Persistable entry: entries)
		{
			insertIntoDatabase(entry);
		}
	}
	/**
	 * insert a single persistable entry into database
	 * @param entry
	 */
	public void insertIntoDatabase(Persistable entry)
	{
		/*
		 * convert from json string to a mongo db specific format 
		 */
		String json = entry.serialize();
		
		Object object = JSON.parse(json);
		BasicDBObject document = (BasicDBObject) object;
		
		collection.insert(document);
	}
	/**
	 * generate a object from a json string
	 * @param record
	 * @param persistable
	 * @return
	 */
	private Persistable generateClassFromDbObject(DBObject record,Persistable persistable)
	{
		Gson gson = new Gson();
		Persistable createdClass  =  gson.fromJson(record.toString(),persistable.getClass());
		return createdClass;
	}
	/**
	 * just converts a queryResult in a ArrayList of Persistables
	 * @param query
	 * @param persistable
	 * @return
	 */
	private ArrayList<Persistable> getQueryResult(BasicDBObject query,Persistable persistable)
	{
		DBCursor cursor = collection.find(query);
	    
	    ArrayList<Persistable> persistables = new ArrayList<Persistable>();
		
	    try 
	    {
	    	   while(cursor.hasNext()) 
	    	   {
	    		   DBObject record = cursor.next();
	    		   Gson gson = new Gson();
	    		   Persistable createdClass  =  generateClassFromDbObject(record,persistable);
	    		   createdClass.setId(record.get("_id").toString());
	    		   persistables.add(createdClass);
	    	   }
	    } 
	    finally 
	    {
	    	   cursor.close();
	    	   return persistables;
	    }
	}
}