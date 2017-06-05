package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-06-05T21:57:48.338+0200")
@StaticMetamodel(StavkaTim2.class)
public class StavkaTim2_ {
	public static volatile SingularAttribute<StavkaTim2, Long> id;
	public static volatile SingularAttribute<StavkaTim2, String> naziv;
	public static volatile SingularAttribute<StavkaTim2, String> opis;
	public static volatile SingularAttribute<StavkaTim2, Boolean> prodata;
	public static volatile SingularAttribute<StavkaTim2, Double> aktuelnaCena;
	public static volatile SingularAttribute<StavkaTim2, UserTim2> postavljenoOdStrane;
	public static volatile SingularAttribute<StavkaTim2, MaterijalTim2> materijal;
	public static volatile SingularAttribute<StavkaTim2, BojaTim2> boja;
	public static volatile SingularAttribute<StavkaTim2, VelicinaTim2> velicina;
	public static volatile SingularAttribute<StavkaTim2, TipTim2> tip;
	public static volatile CollectionAttribute<StavkaTim2, Object> nudio;
}
