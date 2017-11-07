package web.DBentities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import web.DBentities.Appuser;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-05T19:46:03")
@StaticMetamodel(Friendship.class)
public class Friendship_ { 

    public static volatile SingularAttribute<Friendship, Integer> friendshipID;
    public static volatile SingularAttribute<Friendship, Appuser> userIDSource;
    public static volatile SingularAttribute<Friendship, Appuser> userIDTarget;

}