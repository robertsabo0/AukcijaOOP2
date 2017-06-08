package beans;

import java.util.List;

import model.KomentarTim2;
import model.UserTim2;

public interface SesionStavkaI {
	public List<KomentarTim2> getSve(long id);
	public UserTim2 loginUser(String userName, char[] password) throws LosaLozinkaException;
	public void logOut();
	
	public boolean getUlogovan();
}
