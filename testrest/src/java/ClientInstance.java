
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/*
@ApplicationScoped 
Commented @ApplicationScoed and used @RequestScoped coz @ApplicationScoped gives below error 
 Unsatisfied dependencies for type ClientInstance with qualifiers @Default
  at injection point [BackedAnnotatedField] @Inject private testrestmethods.client
  at testrestmethods.client(testrestmethods.java:0)
*/
@RequestScoped
public class ClientInstance {
    
    private Client client;
    
    @PostConstruct
    private void init(){
        client=ClientBuilder.newClient();
    }
    
    @PreDestroy
    private void destroy(){
       client.close(); 
    }
    
     public  WebTarget target(String Url){
         return client.target(Url);
    }
            
}
