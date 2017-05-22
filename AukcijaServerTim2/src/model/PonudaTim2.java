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
}
