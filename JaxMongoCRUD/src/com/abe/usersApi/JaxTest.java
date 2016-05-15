package com.abe.usersApi;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * @author abe
 *This Class Follows the REST architecture/naming convention 
 *to interact with a DB of users
 */
@Path("/users")
public class JaxTest {

//	This method returns all users in the DB
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<DBUser> getUsers(){
		return DBConnection.getList();
	}
//	This method allows to add a new user to the DB
	@POST
	@Consumes({"application/json","application/xml"})
	@Produces(MediaType.TEXT_PLAIN)
	public String addUser(DBUser user){
		return DBConnection.addUser(user);
	}
	
	@GET
	@Path("{emailAddress}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public DBUser getUser(@PathParam("emailAddress") String emailAddress){
		return DBConnection.getUser(emailAddress);
	}
	
}
