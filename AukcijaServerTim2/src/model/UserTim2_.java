package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-06-05T21:57:48.805+0200")
@StaticMetamodel(UserTim2.class)
public class UserTim2_ {
	public static volatile SingularAttribute<UserTim2, String> username;
	public static volatile SingularAttribute<UserTim2, String> ime;
	public static volatile SingularAttribute<UserTim2, String> prezime;
	public static volatile SingularAttribute<UserTim2, String> email;
	public static volatile SingularAttribute<UserTim2, String> opis;
	public static volatile CollectionAttribute<UserTim2, Object> postavio;
	public static volatile CollectionAttribute<UserTim2, Object> nudio;
}
