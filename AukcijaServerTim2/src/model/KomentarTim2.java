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
}
