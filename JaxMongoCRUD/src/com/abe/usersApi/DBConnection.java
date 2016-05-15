package com.abe.usersApi;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public class DBConnection {

	private static boolean init = false;
	private static Datastore ds;

	private static void connect() {
		MongoClient mongoClient = new MongoClient("10.0.0.25", 27017);

		Morphia morphia = new Morphia();
		ds = morphia.createDatastore(mongoClient, "chatapp");
		init = true;

	}

	public static List<DBUser> getList() {
		if (!init)
			connect();
		List<DBUser> l = ds.find(DBUser.class).asList();
		return l;
	}
	
	public static void addUser(DBUser user){
		if (!init)
			connect();
		ds.save(user);
	}

}
