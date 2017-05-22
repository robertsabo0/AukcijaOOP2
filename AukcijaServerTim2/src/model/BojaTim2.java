package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BojaTim2 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	private String opis;
	
	public int getId() {
		return id;
	}

	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = CommonTim2.toCapitalizes(opis);
	}
	
	
}
