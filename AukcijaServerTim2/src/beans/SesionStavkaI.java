package beans;

import java.util.List;

import model.KomentarTim2;
import model.StavkaTim2;
import model.UserTim2;

public interface SesionStavkaI {
	public List<KomentarTim2> getSve(long id);
	public UserTim2 loginUser(String userName, char[] password) throws LosaLozinkaException;
	public void logOut();
	public UserTim2 vratiUlogovanog();
	public boolean getUlogovan();
	public void sacuvajKomentar(KomentarTim2 k);
	public void sacuvajStavku(StavkaTim2 s);
}
