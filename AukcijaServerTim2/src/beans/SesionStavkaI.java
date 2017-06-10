package beans;

import java.util.List;

import model.BojaTim2;
import model.KomentarTim2;
import model.MaterijalTim2;
import model.StavkaTim2;
import model.TipTim2;
import model.UserTim2;
import model.VelicinaTim2;

public interface SesionStavkaI {
	public List<KomentarTim2> getSve(long id);
	public UserTim2 loginUser(String userName, char[] password) throws LosaLozinkaException, LosUsernameException;
	public UserTim2 registrujKorisnika (String username, char[] password, String ime, String prezime, String eMail, String opis) throws NoUsernameException,PostojiUsernameException;
	public void logOut();
	
	public boolean getUlogovan();
	public boolean izmeniKorisnika(String ime, String prezime, char[] password, String eMail, String opis, byte[] slika);
	
	public UserTim2 vratiUlogovanog();
	public void sacuvajStavku(StavkaTim2 s);
	public void sacuvajKomentar(KomentarTim2 k);
	public void izmeniStavku(StavkaTim2 s, UserTim2 u);
	public BojaTim2 sacuvajBoju(BojaTim2 b);
	public TipTim2 sacuvajTip(TipTim2 t);
	public MaterijalTim2 sacuvajMaterija(MaterijalTim2 m);
	public VelicinaTim2 sacuvajVelicni(VelicinaTim2 v);
	public void prodataStavka(StavkaTim2 s);
}
