package myrest;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("test")
public class HelloWWW {

	@GET
	public void test_method() {
		System.out.println("test method called");
	}
	
	@GET
	@Path("test2")
	public void test2() {
		System.out.println("test2 method called");
	}
	
	
	@GET
	@Path("sayHello")
	public Response sayHelloResponse() {
		return Response.status(200).entity("<h1>Hello</h1>").build();
	}
	
	@GET
	@Path("sayHello2/{uname}")
	public Response sayHelloResponse(@PathParam("uname") String name) {
		return Response.status(200).entity("<h1>Hello</h1>"+name).build();
	}

	@GET
	@Path("sayHello3/{uname}/{myname}")
	public Response sayHelloResponse(@PathParam("uname") String name,@PathParam("myname") String myname) {
		return Response.status(200).entity("<h1>Hello</h1>"+name+" : "+myname).build();
	}
	
	@GET
	@Path("sayHello4")
	public Response sayHelloResponse4(@QueryParam("uname") String name,@QueryParam("myname") String myname) {
		return Response.status(200).entity("<h1>Hello</h1>"+name+" : "+myname).build();
	}
	
	@GET
	@Path("sayHello5")
	public Response sayHelloResponse4(@Context UriInfo uriInfo) {
		String name = uriInfo.getQueryParameters().getFirst("uname");
		String mname = uriInfo.getQueryParameters().getFirst("myname"); 		
		return Response.status(200).entity("<h1>Hello</h1>"+name+" : "+mname).build();
	}
	
	@GET
	@Path("sayHello6")
	public Response sayHelloResponse6(@MatrixParam("jsessionid") String id) {
				
		return Response.status(200).entity("<h1>Session Id is....:"+id+"</h1>").build();
	}
	
	@POST
	@Path("sayHello7")
	public Response sayHelloResponse7(@FormParam("uname") String name,@FormParam("myname") String mname) {		
		return Response.status(200).entity("<h1>Welcome To REST</h1>"+name+":"+mname).build();
	}
	
}
