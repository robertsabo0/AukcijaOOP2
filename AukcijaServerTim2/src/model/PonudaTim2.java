package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PonudaTim2 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	
	private double vrednost;
	
	@ManyToOne
	private UserTim2 user;
	
	@ManyToOne
	private StavkaTim2 stavka;
	
	private Date timestamp;

	public double getVrednost() {
		return vrednost;
	}

	public void setVrednost(double vrednost) {
		this.vrednost = vrednost;
	}

	public UserTim2 getUser() {
		return user;
	}

	public void setUser(UserTim2 user) {
		this.user = user;
	}

	public StavkaTim2 getStavka() {
		return stavka;
	}

	public void setStavka(StavkaTim2 stavka) {
		this.stavka = stavka;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public long getId() {
		return id;
	}
	
	
}
