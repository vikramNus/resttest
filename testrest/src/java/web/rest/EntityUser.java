/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.rest;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;

/**
 *
 * @author Vikram
 */
public class EntityUser implements Serializable{
    
    private static final long serialVersionUID = 1L;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
     
    @Id @Column(name="UserID") @GeneratedValue(strategy=IDENTITY)
    private int userID;
    
    @Column(name="Username")
    private String username;
    
}
