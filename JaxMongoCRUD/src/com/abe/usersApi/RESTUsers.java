package com.abe.usersApi;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Abe Boujane This Class Follows the REST architecture/naming
 *         convention to interact with a DB of users
 */
@Path("/users")
public class RESTUsers {

	// This method returns all users in the DB
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<DBUser> getUsers() {
		return DBConnection.getList();
	}

	// This is to return a single user by email address
	@GET
	@Path("{emailAddress}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public DBUser getUser(@PathParam("emailAddress") String emailAddress) {
		return DBConnection.getUser(emailAddress);
	}

	// This method allows to add a new user to the DB
	@POST
	@Consumes({ "application/json", "application/xml" })
	@Produces(MediaType.TEXT_PLAIN)
	public String addUser(DBUser user) {
		return DBConnection.addUser(user);
	}

	@DELETE
	@Path("{emailAddress}")
	@Produces({ MediaType.TEXT_PLAIN })
	public String deleteUser(@PathParam("emailAddress") String emailAddress) {
		return DBConnection.deleteUser(emailAddress);
	}

	@PUT
	@Path("{emailAddress}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public DBUser modifyUser(@PathParam("emailAddress") String oldEmailAddress, DBUser user) {
		return DBConnection.modifyUser(oldEmailAddress, user);
	}
}
