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
import model.StavkaTim2;
import model.UserTim2;

@Stateful
@Remote(SesionStavkaI.class)
public class SesionStavka implements SesionStavkaI {
	@PersistenceContext(name = CommonTim2.persistanceName)
	private EntityManager em;

	private UserTim2 korisnik;
	public static boolean ulogovan = false;

	@Override
	public List<KomentarTim2> getSve(long id) {
		TypedQuery<KomentarTim2> q = em.createNamedQuery("KomentarTim2.getSve", KomentarTim2.class);
		q.setParameter("id", id);
		return q.getResultList();
	}
	
	
	@Override
	public void sacuvajKomentar(KomentarTim2 k) {
		if(k!=null){
			em.persist(k);
		}
	}

	

	@Override
	public void sacuvajStavku(StavkaTim2 s) {
		if(s!=null){
			em.persist(s);
		}
		
	}


	@Override
	public UserTim2 vratiUlogovanog() {
		return korisnik;
	}

	// pokusava da uloguje korisnika
	@Override
	public UserTim2 loginUser(String userName, char[] password) throws LosaLozinkaException {
		UserTim2 k = em.find(UserTim2.class, userName);
		if (korisnik != null) {
			String str = "";
			for (char c : password) {
				str += c;
			}
			if (k.getPassword().equals(str)) {
				korisnik.setEmail(k.getEmail());
				korisnik.setIme(k.getIme());
				korisnik.setPrezime(k.getPrezime());
				korisnik.setOpis(k.getOpis());
				korisnik.setPassword(k.getPassword());

				ulogovan = true;
				
				return korisnik;
			} else {
				throw new LosaLozinkaException();
			}
		} else {
			throw new NullPointerException();
		}
	}

	@Override
	@Remove
	public void logOut() {
		ulogovan = false;
	}

	@Override
	public boolean getUlogovan() {
		// TODO Auto-generated method stub
		return ulogovan;
	}
}
