package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-05-22T18:55:46.176+0200")
@StaticMetamodel(UserTim2.class)
public class UserTim2_ {
	public static volatile SingularAttribute<UserTim2, String> username;
	public static volatile SingularAttribute<UserTim2, String> ime;
	public static volatile SingularAttribute<UserTim2, String> prezime;
	public static volatile SingularAttribute<UserTim2, String> email;
	public static volatile SingularAttribute<UserTim2, String> opis;
	public static volatile ListAttribute<UserTim2, PonudaTim2> nudio;
	public static volatile ListAttribute<UserTim2, StavkaTim2> postavio;
}
