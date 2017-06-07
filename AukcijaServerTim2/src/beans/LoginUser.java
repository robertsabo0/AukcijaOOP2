package beans;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.CommonTim2;
import model.UserTim2;

@Stateful
public class LoginUser {

	@PersistenceContext(name = CommonTim2.persistanceName)
	private EntityManager em;

	private UserTim2 korisnik;
	public static boolean ulogovan = false;
	
	
	//pokusava da uloguje korisnika 
	public void loginUser(String userName, char[] password) throws LosaLozinkaException {
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
			} else {
				throw new LosaLozinkaException();
			}
		} else {
			throw new NullPointerException();
		}
	}
	
	
	//uklonice bean kada se izvrsi ova naredba
	@Remove
	public void logOut(){
		ulogovan=false;
	}
}
