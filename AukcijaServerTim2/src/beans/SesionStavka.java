package beans;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.CommonTim2;
import model.KomentarTim2;


@Stateful
@Remote(SesionStavkaI.class)
public class SesionStavka implements SesionStavkaI {
	@PersistenceContext(name = CommonTim2.persistanceName)
	private EntityManager em;
	
	@Override
	public List<KomentarTim2> getSve() {
		TypedQuery<KomentarTim2> q=em.createNamedQuery("KomentarTim2.getSve", KomentarTim2.class);
		return q.getResultList();
	}
	@Remove
	public void logOut(){
		
	}
}
