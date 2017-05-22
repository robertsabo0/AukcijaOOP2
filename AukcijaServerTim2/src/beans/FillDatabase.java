package beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.jboss.security.auth.spi.Users.User;

import model.UserTim2;

@Singleton
@LocalBean
@Startup
public class FillDatabase {

	@PersistenceContext(name = "AukcijaServerTim2")
	private EntityManager em;

	private String[] boje ={"crna", "bela", "zuta", "crvena", "zelena", "crvena","braon", "ljubicasta"};
	private String[] velicina ={"XS", "S", "M", "L", "XL", "XXL", "37", "38", "39", "40", "41", "42", "43", "44", "45"};
	// TODO: continue here...
	//private String[] tipov ={"majica", "pantalone","kosulja","haljina", "sako","..." ... C};
	
	
	@PostConstruct
	public void postConstruct() {
		if(em.find(User.class, "admin") != null){
			System.out.println("Database is filled");
		} else {
			System.out.println("Let's fill the database");
		}
		System.out.println("Started post constr.");
		// sacuvaj informacije o polaganju
		UserTim2 i = new UserTim2();
		i.setUsername("admin");
		em.persist(i);
		/* TODO: implement...
		fillBoja();
		fillVrednost();
		fillTip();
		fillVelicina();
		*/
		TypedQuery<UserTim2> q = em.createQuery("SELECT s FROM UserTim2 s", UserTim2.class);
		List<UserTim2> l = q.getResultList();
		
		for(UserTim2 u : l){
			System.out.println(u.getUsername() +": "+u.getIme()+" "+u.getPrezime()+" ("+u.getEmail()+");");
		}
		System.out.println("Done!");
	}
}
