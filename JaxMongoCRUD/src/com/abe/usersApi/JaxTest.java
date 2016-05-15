package com.abe.usersApi;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/users")
public class JaxTest {

	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<DBUser> getUsers(){
		return DBConnection.getList();
	}
	
	@POST
	@Consumes({"application/json","application/xml"})
	@Produces(MediaType.TEXT_PLAIN)
	public String addUser(DBUser user){
		DBConnection.addUser(user);
		return "Merci!";
	}
	
	
}
