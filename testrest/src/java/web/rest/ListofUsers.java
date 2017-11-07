package web.rest;

import java.io.Serializable;
import java.util.List;

public class ListofUsers implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private String listid;

    public String getListid() {
        return listid;
    }

    public void setListid(String listid) {
        this.listid = listid;
    }
    
    private List<EntityUser> userlist;

    public List<EntityUser> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<EntityUser> userlist) {
        this.userlist = userlist;
    }
    
    
}
