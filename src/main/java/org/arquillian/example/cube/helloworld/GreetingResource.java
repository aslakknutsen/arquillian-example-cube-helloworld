package org.arquillian.example.cube.helloworld;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/greet")
public class GreetingResource {

	@Inject
	private GreetingService service;
	
	@GET @Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject greet(@PathParam("name") String name) {
		System.out.println("WWEEEEEEE");
		return Json.createObjectBuilder()
				  .add("name", name)
				  .add("greeting", service.greet(name))
			   .build();
	}
}
