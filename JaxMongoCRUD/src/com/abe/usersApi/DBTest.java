package com.abe.usersApi;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public class DBTest {

	public static void main(String[] args) {

		boolean init = false;
		Datastore ds;

		MongoClient mongoClient = new MongoClient("10.0.0.25", 27017);

		Morphia morphia = new Morphia();
		ds = morphia.createDatastore(mongoClient, "chatapp");
		init = true;
		
		DBUser user = new DBUser("fname","lname","uname","Some.one@like.you");

		
		System.out.println(ds.find(DBUser.class,"email =",user.getEmail()).countAll());

		

	}

}
