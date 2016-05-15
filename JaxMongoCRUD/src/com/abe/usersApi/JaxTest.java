package com.abe.usersApi;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;


@Path("/users")
public class JaxTest {

	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<DBUser> itWorks(){
		return DBConnection.getList();
	}
	
	@GET
	@Path("/cooki")
	@Produces(MediaType.TEXT_PLAIN)
	public Response echoRequest(){
		
		return Response.ok().cookie(new NewCookie("cookieName","cookievalue")).build();
	}
	
}
