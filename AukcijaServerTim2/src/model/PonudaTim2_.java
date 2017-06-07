package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-06-07T10:02:04.722+0200")
@StaticMetamodel(PonudaTim2.class)
public class PonudaTim2_ {
	public static volatile SingularAttribute<PonudaTim2, Long> id;
	public static volatile SingularAttribute<PonudaTim2, Double> vrednost;
	public static volatile SingularAttribute<PonudaTim2, UserTim2> user;
	public static volatile SingularAttribute<PonudaTim2, StavkaTim2> stavka;
	public static volatile SingularAttribute<PonudaTim2, Date> timestamp;
}
