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
	
	public static String addUser(DBUser user){
		if (!init)
			connect();
		if(ds.find(DBUser.class,"email =",user.getEmail()).countAll()>0){
			return "Another User with the same email address exists already! pleas try a different e-mail address";
		}
		ds.save(user);
			return "Added " +user.getFname();
	}

	public static DBUser getUser(String emailAddress) {
		if (!init)
			connect();
		DBUser u = ds.find(DBUser.class,"email =",emailAddress).get();
		return u;
	}

}
