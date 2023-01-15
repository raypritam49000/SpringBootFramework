package com.jersey.rest.webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("myresources")
public class JersyRestAPIDemo {
    
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String home() {
		return "Hello Pritam Ray";
	}
}
