package beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.BojaTim2;
import model.CommonTim2;
import model.KomentarTim2;
import model.MaterijalTim2;
import model.PonudaTim2;
import model.StavkaTim2;
import model.TipTim2;
import model.UserTim2;
import model.VelicinaTim2;

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
	public VelicinaTim2 sacuvajVelicni(VelicinaTim2 v) {
		// TODO Auto-generated method stub
		if (v != null) {
			em.persist(v);
			return v;
		}
		return null;
	}

	@Override
	public BojaTim2 sacuvajBoju(BojaTim2 b) {
		// TODO Auto-generated method stub
		if (b != null) {
			em.persist(b);
			return b;
		}
		return null;
	}

	@Override
	public TipTim2 sacuvajTip(TipTim2 t) {
		// TODO Auto-generated method stub
		if (t != null) {
			em.persist(t);
			return t;
		}
		return null;
	}

	@Override
	public MaterijalTim2 sacuvajMaterija(MaterijalTim2 m) {
		// TODO Auto-generated method stub
		if (m != null) {
			em.persist(m);
			return m;
		}
		return null;
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
		if (korisnik != null)
			return null; // korisnik je vec ulogovan
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
				korisnik = k;
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
		korisnik = null;
	}

	@Override
	public boolean getUlogovan() {
		// TODO Auto-generated method stub
		return ulogovan;
	}

	// izmenjuje korisnika
	@Override
	public boolean izmeniKorisnika(String ime, String prezime, char[] password, String eMail, String opis, byte[] slika) {
		if (korisnik == null)
			return false;

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
		
		if(slika.length!=0){
			korisnik.setSlika(slika);
		}

		em.merge(korisnik);
		em.flush();
		return true;
	}

	// registracija korisnika
	@Override
	public UserTim2 registrujKorisnika(String username, char[] password, String ime, String prezime, String eMail,
			String opis) throws NoUsernameException, PostojiUsernameException {
		if (korisnik != null)
			return null; // postoji registrovan korisnik trenutno na sistemu
		
		if (username.isEmpty()) {
			throw new NoUsernameException();
		} else {
			if (em.contains(em.find(UserTim2.class, username))) {
				throw new PostojiUsernameException();
			} else {
				korisnik = new UserTim2();
				korisnik.setUsername(username);
			}
		}
		korisnik.setEmail(eMail);
		korisnik.setIme(ime);
		korisnik.setPrezime(prezime);
		korisnik.setOpis(opis);
		String str = "";
		for (char c : password)
			str += c;
		korisnik.setPassword(str);

		em.persist(korisnik);
		em.flush();

		return korisnik;

	}

}
