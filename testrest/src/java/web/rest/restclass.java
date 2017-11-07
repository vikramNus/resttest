package web.rest;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
//@Path("/ffolder/{custid:\\d+}")
@Path("/ffolder/{custid}/{ErroOk}")//all methods should match the url else its not valid
public class restclass {
    
   @PersistenceContext EntityManager Em;   
   
   
   @POST
   @Consumes(MediaType.TEXT_PLAIN)
    public Response addFriend(String bodyre) {
        //http://localhost:8080/testrest/api/ffolder/1/qaa 
        // /1/qaa is required 
        //input:Post:asas
        //example of taking body as complete string
   
    System.out.println("input:Post:" +bodyre);
        return (Response.status(Response.Status.OK).build());
    }
    
   
    @GET
    //public Response get(@PathParam("custid") int id){
    public Response get(@PathParam("custid") int id,@PathParam("ErroOk") String errok){
        //http://localhost:8080/testrest/api/ffolder/1/qaa
        //This is test  response for ID :1;qaa
        //example of taking /1/qaa as params
                
        //get details for customer with id 
        System.out.println("input:get" +id+errok);
        if (id==0){
            if (errok.equals("ok"))
            {return (Response.status(Response.Status.UNAUTHORIZED).build());}
            else
            {return (Response.ok("Customer Not Found").build());}
        }
        return (Response.ok("This is test  response for ID :" + id + ";" + errok).build());
}
}