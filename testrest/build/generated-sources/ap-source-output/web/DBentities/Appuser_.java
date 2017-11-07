package web.DBentities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import web.DBentities.Friendship;
import web.DBentities.Posting;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-05T19:46:03")
@StaticMetamodel(Appuser.class)
public class Appuser_ { 

    public static volatile SingularAttribute<Appuser, Integer> userID;
    public static volatile CollectionAttribute<Appuser, Friendship> friendshipCollection;
    public static volatile CollectionAttribute<Appuser, Posting> postingCollection;
    public static volatile SingularAttribute<Appuser, String> username;
    public static volatile CollectionAttribute<Appuser, Friendship> friendshipCollection1;

}