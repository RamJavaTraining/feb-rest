package com.imcs.krishna.training.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/test")
public class TestController {
	
	
	@GET
	@Path("/hello")
	public Response sayHello(@QueryParam("name") String firstName) {
		String hello= "Hello Mr "+firstName;
		
		return Response.status(200).entity(hello).build() ;
	}
	@GET
	@Path("{name}")
	public Response pathParam(@PathParam("name") String firstName) {
		String hello= "Hello Mr "+firstName;
		
		return Response.status(200).entity(hello).build() ;
	}
	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUsers() {
		  List<User> users=  new ArrayList<>();
		  User user= new User();
		  user.setFirstName("Rama");
		  user.setLastName("Krishna");
		  
		  User user1= new User();
		  user1.setFirstName("Ronish");
		  user1.setLastName("Panjwani");
		  
		  
		  users.add(user);
		  users.add(user1);
		
		return Response.status(200).entity(users).build() ;
	}
	
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(User user) {
		
		
		
		System.out.println(user.getFirstName());
		System.out.println(user.getLastName());
		
		return Response.status(200).build();
		
	}
	

}
