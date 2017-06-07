package beans;

import java.util.List;

import model.BojaTim2;
import model.MaterijalTim2;
import model.StavkaTim2;
import model.TipTim2;
import model.VelicinaTim2;

public interface StavkeGetters {
	List<StavkaTim2> getStavkaFiltered( List<BojaTim2> boje, 
										List<MaterijalTim2> materijal, 
										List<VelicinaTim2> velicine, 
										List<TipTim2> tipovi, 
										double cenaOd, 
										double cenaDo,
										boolean prikaziIProdate);
	public List<StavkaTim2> getSve();
}
