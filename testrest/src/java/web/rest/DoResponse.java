package web.rest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@RequestScoped
@Path("/doResponse")
public class DoResponse {
    
    @PathParam("username") String username;
    
    @Context private UriInfo ui;
    
      @GET
      @Path("/{username}/{id}")
      @Produces(MediaType.APPLICATION_JSON)
      public Response getuser(@PathParam("{id}") String id) {
          
             System.out.println("get user:"  + username );
             System.out.println("get id:"  + username );
             return (Response.status(Response.Status.OK).build());
      }
      
      @GET
      @Path("/{username}")
      @Produces(MediaType.APPLICATION_JSON)
      public Response getData() {
             
	   System.out.println("get data:"  + username );
           List<EntityUser> userlist= new ArrayList<EntityUser> (); 
                     
           EntityUser user1=new EntityUser();
           user1.setUserID(10);
           user1.setUsername("abc");
           userlist.add(user1);
           
           EntityUser user2=new EntityUser();
           user2.setUserID(11);
           user2.setUsername("pqr");
           userlist.add(user2);
           
           GenericEntity< List< EntityUser > > entity;
           entity  = new GenericEntity< List< EntityUser > >( userlist ) { };
           
           ListofUsers ul=new ListofUsers();
           //JsonObject jsonbuilder=Json.createObjectBuilder(); 
           //JsonObjectBuilder jobuilder = Json.createObjectBuilder();
           //NO NEED TO BUILD JSON AS THE RESPONSE DOES THE WORK
            ul.setListid("1234");
            ul.setUserlist(userlist);
                        
           Response.ResponseBuilder builder;
           builder=Response.ok(ul); // OR can do   builder=Response.ok(entity); 
           CacheControl mycache=new CacheControl();
           mycache.setNoCache(true);
           builder.cacheControl(mycache)
               .tag(ul.getListid())
               .expires(new Date(System.currentTimeMillis()+60000));
             
           return (builder.build());           
	
    }     
}
