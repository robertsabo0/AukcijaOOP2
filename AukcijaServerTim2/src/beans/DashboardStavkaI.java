package beans;

import java.util.Date;
import java.util.List;

import model.StavkaTim2;

public interface DashboardStavkaI {

	// Vraca listu stavke
	public List<StavkaTim2> getSve();
	
	// Vraca listu id-ova
	public List<Long> getId();
	
	// Vraca listu naziva
	public List<String> getNazivi();
	
	// Vraca listu datumPostavljanja
	public List<Date> getDatum();
	
	// Vraca listu cena
	public List<Double> getCena();
}
