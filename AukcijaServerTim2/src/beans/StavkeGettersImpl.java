package beans;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.BojaTim2;
import model.CommonTim2;
import model.MaterijalTim2;
import model.StavkaTim2;
import model.TipTim2;
import model.VelicinaTim2;

@Stateless
@Remote(StavkeGetters.class)
public class StavkeGettersImpl implements StavkeGetters{

	@PersistenceContext(name = CommonTim2.persistanceName)
	private EntityManager em;
	
	@Override
	public List<StavkaTim2> getStavkaFiltered(List<BojaTim2> boje, List<MaterijalTim2> materijal,
			List<VelicinaTim2> velicine, List<TipTim2> tipovi, double cenaOd, double cenaDo, boolean prikaziIProdate) {
		
		if(boje==null) boje = new LinkedList<>();
		if(materijal==null) materijal = new LinkedList<>();
		if(velicine==null) velicine = new LinkedList<>();
		if(tipovi==null) tipovi = new LinkedList<>();
		if(cenaOd <= 0) cenaOd = 0;
		if(cenaDo <= 0) cenaDo = Double.MAX_VALUE;
		
		String query = "FROM StavkaTim2 s "
										+ "WHERE s.boje IN :boje"
										+ " AND s.materijal IN :materijal"
										+ " AND s.velicina IN :velicine"
										+ " AND s.tip IN :tipovi"
										+ " AND s.aktuelnaCena >= :cenaOd AND s.aktuelnaCena <= :cenaDo";
		
		if(!prikaziIProdate){
			query +=" AND s.prodato == false";
		}
		
		TypedQuery<StavkaTim2> s = em.createQuery(query, StavkaTim2.class);
		
		s.setParameter("boje", boje);
		s.setParameter("materijal", materijal);
		s.setParameter("velicine", velicine);
		s.setParameter("tipovi", tipovi);
		s.setParameter("cenaOd", cenaOd);
		s.setParameter("cenaDo", cenaDo);
		
		List<StavkaTim2> list = s.getResultList();
		
		return list;
	}

}
