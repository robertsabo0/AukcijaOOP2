package beans;

import java.util.List;

import model.KomentarTim2;
import model.StavkaTim2;
import model.UserTim2;

public interface SesionStavkaI {
	public List<KomentarTim2> getSve(long id);
	public UserTim2 loginUser(String userName, char[] password) throws LosaLozinkaException, LosUsernameException;
	public void logOut();
	
	public boolean getUlogovan();
	public boolean izmeniKorisnika(String username, String ime, String prezime, char[] password, String eMail, String opis) throws PostojiUsernameException;
	
	public UserTim2 vratiUlogovanog();
	public void sacuvajStavku(StavkaTim2 s);
	public void sacuvajKomentar(KomentarTim2 k);
	public void izmeniStavku(StavkaTim2 s, UserTim2 u);
}
