
package web.rest;

import java.util.concurrent.ExecutorService;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/simpleget")
public class SimpleGet {

 
    
    @Resource(mappedName="concurrent/__defaultManagedExecutorService") 
       private ExecutorService executorService;
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public void doGet(@Suspended
    final AsyncResponse async) {
        doRunnable dor=new doRunnable();
        dor.setAsyncReponse(async);
        executorService.execute(dor);
        
    }
    
    private Response actualget(){
       return Response.ok("This is simple get ").build(); 
    }
            
}
