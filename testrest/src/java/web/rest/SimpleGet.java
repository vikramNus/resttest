
package web.rest;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/simpleget")
public class SimpleGet {
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response get(){
        
        return Response.ok("This is simple get ").build();
           
    }
}
