package web.DBentities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import web.DBentities.Appuser;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-05T19:46:03")
@StaticMetamodel(Posting.class)
public class Posting_ { 

    public static volatile SingularAttribute<Posting, Date> posttime;
    public static volatile SingularAttribute<Posting, String> comments;
    public static volatile SingularAttribute<Posting, String> imageURL;
    public static volatile SingularAttribute<Posting, Integer> postID;
    public static volatile SingularAttribute<Posting, Appuser> userID;

}