package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-05-22T19:46:09.219+0200")
@StaticMetamodel(StavkaTim2.class)
public class StavkaTim2_ {
	public static volatile SingularAttribute<StavkaTim2, Long> id;
	public static volatile SingularAttribute<StavkaTim2, String> naziv;
	public static volatile SingularAttribute<StavkaTim2, String> opis;
	public static volatile SingularAttribute<StavkaTim2, Date> datumPostavljanja;
	public static volatile SingularAttribute<StavkaTim2, UserTim2> postavljenoOdStrane;
	public static volatile SingularAttribute<StavkaTim2, MaterijalTim2> materijal;
	public static volatile SingularAttribute<StavkaTim2, BojaTim2> boja;
	public static volatile SingularAttribute<StavkaTim2, VelicinaTim2> velicina;
	public static volatile SingularAttribute<StavkaTim2, TipTim2> tip;
	public static volatile ListAttribute<StavkaTim2, PonudaTim2> nudio;
}
