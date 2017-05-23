package model;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
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
	
	private boolean prodata;
	private double aktuelnaCena;
	
	public boolean isProdata() {
		return prodata;
	}

	public void setProdata(boolean prodata) {
		this.prodata = prodata;
	}

	public double getAktuelnaCena() {
		return aktuelnaCena;
	}

	public void setAktuelnaCena(double aktuelnaCena) {
		this.aktuelnaCena = aktuelnaCena;
	}

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
	
	public StavkaTim2(){
		nudio = new LinkedList<PonudaTim2>() ;
	}

	public long getId() {
		return id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Date getDatumPostavljanja() {
		return datumPostavljanja;
	}

	public void setDatumPostavljanja(Date datumPostavljanja) {
		this.datumPostavljanja = datumPostavljanja;
	}

	public UserTim2 getPostavljenoOdStrane() {
		return postavljenoOdStrane;
	}

	public void setPostavljenoOdStrane(UserTim2 postavljenoOdStrane) {
		this.postavljenoOdStrane = postavljenoOdStrane;
	}

	public MaterijalTim2 getMaterijal() {
		return materijal;
	}

	public void setMaterijal(MaterijalTim2 materijal) {
		this.materijal = materijal;
	}

	public BojaTim2 getBoja() {
		return boja;
	}

	public void setBoja(BojaTim2 boja) {
		this.boja = boja;
	}

	public VelicinaTim2 getVelicina() {
		return velicina;
	}

	public void setVelicina(VelicinaTim2 velicina) {
		this.velicina = velicina;
	}

	public TipTim2 getTip() {
		return tip;
	}

	public void setTip(TipTim2 tip) {
		this.tip = tip;
	}

	public List<PonudaTim2> getNudio() {
		return nudio;
	}

	public void setNudio(List<PonudaTim2> nudio) {
		this.nudio = nudio;
	}
	
}
