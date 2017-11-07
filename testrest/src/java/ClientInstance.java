
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

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
