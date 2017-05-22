package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class KomentarTim2 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;
	
	private String sadrzaj;
	
	private Date postaljeno;
	
	@ManyToOne
	private UserTim2 postaljvenoOdStrane;
	
	@ManyToOne
	private StavkaTim2 stavka;

	public int getId() {
		return id;
	}

	public String getSadrzaj() {
		return sadrzaj;
	}

	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	}

	public Date getPostaljeno() {
		return postaljeno;
	}

	public void setPostaljeno(Date postaljeno) {
		this.postaljeno = postaljeno;
	}

	public UserTim2 getPostaljvenoOdStrane() {
		return postaljvenoOdStrane;
	}

	public void setPostaljvenoOdStrane(UserTim2 postaljvenoOdStrane) {
		this.postaljvenoOdStrane = postaljvenoOdStrane;
	}

	public StavkaTim2 getStavka() {
		return stavka;
	}

	public void setStavka(StavkaTim2 stavka) {
		this.stavka = stavka;
	}
	
}
