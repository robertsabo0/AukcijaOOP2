package beans;

import java.util.List;

import model.KomentarTim2;
import model.StavkaTim2;
import model.UserTim2;

public interface SesionStavkaI {
	public List<KomentarTim2> getSve(long id);
	public UserTim2 loginUser(String userName, char[] password) throws LosaLozinkaException, LosUsernameException;
	public UserTim2 registrujKorisnika (String username, char[] password, String ime, String prezime, String eMail, String opis) throws NoUsernameException,PostojiUsernameException;
	public void logOut();
	
	public boolean getUlogovan();
	public boolean izmeniKorisnika(String ime, String prezime, char[] password, String eMail, String opis);
	
	public UserTim2 vratiUlogovanog();
	public void sacuvajStavku(StavkaTim2 s);
	public void sacuvajKomentar(KomentarTim2 k);
	public void izmeniStavku(StavkaTim2 s, UserTim2 u);
}
