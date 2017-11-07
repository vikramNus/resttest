/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.DBentities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Vikram
 */
@Entity
@Table(name = "posting")
@NamedQueries({
    @NamedQuery(name = "Posting.findAll", query = "SELECT p FROM Posting p"),
    @NamedQuery(name = "Posting.findByPostID", query = "SELECT p FROM Posting p WHERE p.postID = :postID"),
    @NamedQuery(name = "Posting.findByComments", query = "SELECT p FROM Posting p WHERE p.comments = :comments"),
    @NamedQuery(name = "Posting.findByPosttime", query = "SELECT p FROM Posting p WHERE p.posttime = :posttime"),
    @NamedQuery(name = "Posting.findByImageURL", query = "SELECT p FROM Posting p WHERE p.imageURL = :imageURL")})
public class Posting implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "postID")
    private Integer postID;
    @Basic(optional = false)
    @Column(name = "Comments")
    private String comments;
    @Basic(optional = false)
    @Column(name = "posttime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date posttime;
    @Column(name = "imageURL")
    private String imageURL;
    @JoinColumn(name = "userID", referencedColumnName = "UserID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Appuser userID;

    public Posting() {
    }

    public Posting(Integer postID) {
        this.postID = postID;
    }

    public Posting(Integer postID, String comments, Date posttime) {
        this.postID = postID;
        this.comments = comments;
        this.posttime = posttime;
    }

    public Integer getPostID() {
        return postID;
    }

    public void setPostID(Integer postID) {
        this.postID = postID;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getPosttime() {
        return posttime;
    }

    public void setPosttime(Date posttime) {
        this.posttime = posttime;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Appuser getUserID() {
        return userID;
    }

    public void setUserID(Appuser userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (postID != null ? postID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Posting)) {
            return false;
        }
        Posting other = (Posting) object;
        if ((this.postID == null && other.postID != null) || (this.postID != null && !this.postID.equals(other.postID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "web.DBentities.Posting[ postID=" + postID + " ]";
    }
    
}
