package beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.User;

@Singleton
@LocalBean
@Startup
public class Test {

	@PersistenceContext(name = "AukcijaServerTim2")
	private EntityManager em;

	@PostConstruct
	public void postConstruct() {

		System.out.println("Started post constr.");
		// sacuvaj informacije o polaganju
		User i = new User();
		i.setEmail("hello");
		i.setUsername("hello33");
		i.setIme("hello");
		i.setPrezime("hello");
		em.persist(i);
		
		i = new User();
		i.setEmail("hello!");
		i.setUsername("hello1");
		i.setIme("hello1");
		i.setPrezime("hello1");
		em.persist(i);


		i = new User();
		i.setEmail("hello2");
		i.setUsername("hello2");
		i.setIme("hello2");
		i.setPrezime("hello2");
		em.persist(i);
		
		TypedQuery<User> q = em.createQuery("SELECT s FROM User s", User.class);
		List<User> l = q.getResultList();
		
		for(User u : l){
			System.out.println(u.getUsername() +": "+u.getIme()+" "+u.getPrezime()+" ("+u.getEmail()+");");
		}
		System.out.println("Done!");
	}
}
