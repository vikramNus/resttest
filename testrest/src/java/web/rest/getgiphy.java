/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.rest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/simplegiphyget")
public class getgiphy {
    
    @Resource(mappedName="concurrent/__defaultManagedExecutorService") 
       private ExecutorService executorService;
    
     @Resource(lookup = "concurrent/myThreadPool")
   private ManagedScheduledExecutorService service;

//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public void doGet(@Suspended
//    final AsyncResponse async) {
//        doRunnable dor=new doRunnable();
//        dor.setAsyncReponse(async);
//        executorService.execute(dor);
//        
//    }
    
   
	@GET
	@Path("/search")
	public void search(@QueryParam("q")String q,
			@Suspended AsyncResponse asyncResp) {

		GiphyTask task = new GiphyTask(q, asyncResp);

		service.schedule(task, 5, TimeUnit.SECONDS);
		System.out.println(">>> exiting resouce");

	}
   
}
