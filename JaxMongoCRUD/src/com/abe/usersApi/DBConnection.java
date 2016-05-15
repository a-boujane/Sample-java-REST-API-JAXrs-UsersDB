package com.abe.usersApi;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

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

	public static String addUser(DBUser user) {
		if (!init)
			connect();
		if (ds.find(DBUser.class, "email =", user.getEmail()).countAll() > 0) {
			return "Another User with the same email address exists already! pleas try a different e-mail address";
		}
		ds.save(user);
		return "Added " + user.getFname();
	}

	public static DBUser getUser(String emailAddress) {
		if (!init)
			connect();
		DBUser u = ds.find(DBUser.class, "email =", emailAddress).get();
		return u;
	}

	public static DBUser modifyUser(String oldEmailAddress, DBUser user) {
		if (!init)
			connect();

		Query<DBUser> q = ds.find(DBUser.class, "email =", oldEmailAddress);
		if (q.countAll() > 0) {
			UpdateOperations<DBUser> up = ds.createUpdateOperations(DBUser.class)
					.set(DBUser.MONGOD_EMAIL, user.getEmail()).set(DBUser.MONGOD_FNAME, user.getFname())
					.set(DBUser.MONGOD_LNAME, user.getLname()).set(DBUser.MONGOD_UNAME, user.getUname())
					.set(DBUser.MONGOD_PIC, user.getPic());
			return ds.findAndModify(q, up);
		} else
			return null;

	}

	public static String deleteUser(String emailAddress) {
		if (!init)
			connect();
		ds.delete(ds.find(DBUser.class, "email =", emailAddress));
		return "User associatd with " + emailAddress + " has been deleted from the Database";
	}

}
