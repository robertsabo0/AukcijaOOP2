package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class StavkaTim2 implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	
	private String naziv;
	private String opis;
	private Date datumPostavljanja;
	
	@ManyToOne
	private UserTim2 postavljenoOdStrane;
	
	@ManyToOne
	private MaterijalTim2 materijal;
	
	@ManyToOne
	private BojaTim2 boja;
	
	@ManyToOne
	private VelicinaTim2 velicina;
	
	@ManyToOne
	private TipTim2 tip;
	
	@OneToMany(mappedBy="stavka")
	private List<PonudaTim2> nudio;
	
	
}
