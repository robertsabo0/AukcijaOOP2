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
import model.UserTim2;

@Stateful
@Remote(SesionStavkaI.class)
public class SesionStavka implements SesionStavkaI {
	@PersistenceContext(name = CommonTim2.persistanceName)
	private EntityManager em;

	private UserTim2 korisnik= new UserTim2();
	public static boolean ulogovan = false;

	@Override
	public List<KomentarTim2> getSve(long id) {
		TypedQuery<KomentarTim2> q = em.createNamedQuery("KomentarTim2.getSve", KomentarTim2.class);
		q.setParameter("id", id);
		return q.getResultList();
	}

	// pokusava da uloguje korisnika
	@Override
	public UserTim2 loginUser(String userName, char[] password) throws LosaLozinkaException, NullPointerException {
		TypedQuery<UserTim2> q = em.createNamedQuery("UserTim2.findUser", UserTim2.class);
		q.setParameter("username", userName);
		UserTim2 k = q.getSingleResult();
		if (k != null) {
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
			System.out.println("Ne posotji user");
			return null;
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
