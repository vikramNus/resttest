/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.DBentities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Vikram
 */
@Entity
@Table(name = "friendship")
@NamedQueries({
    @NamedQuery(name = "Friendship.findAll", query = "SELECT f FROM Friendship f"),
    @NamedQuery(name = "Friendship.findByFriendshipID", query = "SELECT f FROM Friendship f WHERE f.friendshipID = :friendshipID")})
public class Friendship implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FriendshipID")
    private Integer friendshipID;
    @JoinColumn(name = "UserIDSource", referencedColumnName = "UserID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Appuser userIDSource;
    @JoinColumn(name = "UserIDTarget", referencedColumnName = "UserID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Appuser userIDTarget;

    public Friendship() {
    }

    public Friendship(Integer friendshipID) {
        this.friendshipID = friendshipID;
    }

    public Integer getFriendshipID() {
        return friendshipID;
    }

    public void setFriendshipID(Integer friendshipID) {
        this.friendshipID = friendshipID;
    }

    public Appuser getUserIDSource() {
        return userIDSource;
    }

    public void setUserIDSource(Appuser userIDSource) {
        this.userIDSource = userIDSource;
    }

    public Appuser getUserIDTarget() {
        return userIDTarget;
    }

    public void setUserIDTarget(Appuser userIDTarget) {
        this.userIDTarget = userIDTarget;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (friendshipID != null ? friendshipID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Friendship)) {
            return false;
        }
        Friendship other = (Friendship) object;
        if ((this.friendshipID == null && other.friendshipID != null) || (this.friendshipID != null && !this.friendshipID.equals(other.friendshipID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "web.DBentities.Friendship[ friendshipID=" + friendshipID + " ]";
    }
    
}
