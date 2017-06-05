package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-06-05T21:57:47.959+0200")
@StaticMetamodel(KomentarTim2.class)
public class KomentarTim2_ {
	public static volatile SingularAttribute<KomentarTim2, Integer> id;
	public static volatile SingularAttribute<KomentarTim2, String> sadrzaj;
	public static volatile SingularAttribute<KomentarTim2, UserTim2> postaljvenoOdStrane;
	public static volatile SingularAttribute<KomentarTim2, StavkaTim2> stavka;
}
