package Bible;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import RESTbible.worker.Genesis;

@ApplicationPath("/normal")
public class BibleService extends Application {

	public Set<Class<?>> getClasses() {
		return new HashSet<Class<?>>(Arrays.asList(BibleService.class));
	}

	@POST
	@Path("/Genesis")
	@Produces("text/html")
	public Response search(@FormParam("searchword") String search) {
		String returnHTML = "<p>Your results for the word " + search + " are: ";
		returnHTML += Genesis.searchGenesis(search) + " Instances";
		returnHTML += "<p><a href='/RESTful_Bible/genesis.html'>Back To Genesis</a>";
		return Response.ok(returnHTML).build();
	}

	@GET
	@Path("/hello/name")
	@Produces("text/plain")
	public String displayName() {
		return "Charles";
	}

	@POST
	@Path("/hello/nameA")
	@Produces("text/plain")
	public String displayNameA() {
		return "Edwards";
	}

	@GET
	@Path("/hello/address")
	@Produces("text/plain")
	public String displayAddress() {
		return "2806 Haven Rd.";
	}

}
