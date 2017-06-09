package beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.CommonTim2;
import model.KomentarTim2;
import model.PonudaTim2;
import model.StavkaTim2;
import model.UserTim2;

@Stateful
@Remote(SesionStavkaI.class)
public class SesionStavka implements SesionStavkaI {
	@PersistenceContext(name = CommonTim2.persistanceName)
	private EntityManager em;

	private UserTim2 korisnik = new UserTim2();
	public static boolean ulogovan = false;

	@Override
	public List<KomentarTim2> getSve(long id) {
		TypedQuery<KomentarTim2> q = em.createNamedQuery("KomentarTim2.getSve", KomentarTim2.class);
		q.setParameter("id", id);
		return q.getResultList();
	}

	@Override
	public void izmeniStavku(StavkaTim2 s, UserTim2 u) {
		// TODO Auto-generated method stub
		if (s != null) {
			em.merge(s);
			em.flush();
		}
		PonudaTim2 p = new PonudaTim2();
		p.setStavka(s);
		p.setTimestamp(new Date());
		p.setUser(u);
		p.setVrednost(s.getAktuelnaCena());
		em.persist(p);
	}

	@Override
	public void sacuvajKomentar(KomentarTim2 k) {
		if (k != null) {
			em.persist(k);
		}
	}

	@Override
	public void sacuvajStavku(StavkaTim2 s) {
		if (s != null) {
			em.persist(s);
		}

	}

	@Override
	public UserTim2 vratiUlogovanog() {
		return korisnik;
	}

	// pokusava da uloguje korisnika
	@Override
	public UserTim2 loginUser(String userName, char[] password) throws LosaLozinkaException, LosUsernameException {
		TypedQuery<UserTim2> q = em.createNamedQuery("UserTim2.findUser", UserTim2.class);
		q.setParameter("username", userName);
		UserTim2 k = new UserTim2();
		try {
			k = q.getSingleResult();
		} catch (Exception e) {
			throw new LosUsernameException();
		}
		if (k != null) {
			String str = "";
			for (char c : password) {
				str += c;
			}
			if (k.getPassword().equals(str)) {
				korisnik.setUsername(k.getUsername());
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
			return null;
		}
	}

	@Remove
	@Override
	public void logOut() {
		ulogovan = false;
	}

	@Override
	public boolean getUlogovan() {
		// TODO Auto-generated method stub
		return ulogovan;
	}

	// izmenjuje korisnika
	@Override
	public boolean izmeniKorisnika(String username, String ime, String prezime, char[] password, String eMail,
			String opis) throws PostojiUsernameException {
		try {
			korisnik = em.find(UserTim2.class, korisnik.getUsername());

			if (!username.isEmpty()) {
				if (em.contains(em.find(UserTim2.class, username))) {
					throw new PostojiUsernameException();
				} else{
					korisnik.setUsername(username);
				}
			}
			if (!ime.isEmpty())
				korisnik.setIme(ime);

			if (!prezime.isEmpty())
				korisnik.setPrezime(prezime);

			if (!eMail.isEmpty())
				korisnik.setEmail(eMail);

			if (!opis.isEmpty())
				korisnik.setOpis(opis);

			String pas = "";
			for (char c : password)
				pas += c;
			if (!pas.isEmpty()) {
				korisnik.setPassword(pas);
			}

			em.merge(korisnik);

		} catch (PostojiUsernameException e) {
			throw new PostojiUsernameException();
			
		} catch (Exception e){
			return false;
		}
		return true;
	}

}
