package web.rest;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.Response;

public class doRunnable implements Runnable {

    private AsyncResponse asyncContext;
    
    public void setAsyncReponse(AsyncResponse asyncCont){
        this.asyncContext=asyncCont;
    }
    @Override
    public void run() {
        Response res=Response.ok("This is simple get async").build();
        asyncContext.resume(res);
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
