package beans;

import java.util.ArrayList;
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
import model.PonudaTim2;
import model.StavkaTim2;
import model.TipTim2;
import model.UserTim2;
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
		
		String query = "SELECT s FROM StavkaTim2 s "//27
										+ "WHERE s.boja IN (:boje)"//56
										+ " AND s.materijal IN (:materijal)"
										+ " AND s.velicina IN (:velicine)"
										+ " AND s.tip IN (:tipovi)"
										+ " AND s.aktuelnaCena >= :cenaOd AND s.aktuelnaCena <= :cenaDo";
		
		if(!prikaziIProdate){
			query +=" AND s.prodata = false";
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

	@Override
	public List<StavkaTim2> getSve() {
		TypedQuery<StavkaTim2> q=em.createNamedQuery("StavkaTim2.getSve", StavkaTim2.class);
		return q.getResultList();
	}

	@Override
	public List<BojaTim2> getBoje() {
		TypedQuery<BojaTim2> q = em.createNamedQuery("BojaTim2.getAll", BojaTim2.class);
		List<BojaTim2> l = q.getResultList();
		return l;
	}

	@Override
	public List<MaterijalTim2> getMaterijali() {
		TypedQuery<MaterijalTim2> q = em.createNamedQuery("MaterijalTim2.getAll", MaterijalTim2.class);
		List<MaterijalTim2> l = q.getResultList();
		return l;
	}

	@Override
	public List<VelicinaTim2> getVelicine() {
		TypedQuery<VelicinaTim2> q = em.createNamedQuery("VelicinaTim2.getAll", VelicinaTim2.class);
		List<VelicinaTim2> l = q.getResultList();
		return l;
	}

	@Override
	public List<TipTim2> getTipovi() {
		TypedQuery<TipTim2> q = em.createNamedQuery("TipTim2.getAll", TipTim2.class);
		List<TipTim2> l = q.getResultList();
		return l;
	}

	@Override
	public List<StavkaTim2> postavljeneStavke(String username) {
		System.out.println("aaaaaaaaaaaaaaaa");
		TypedQuery<StavkaTim2> q=em.createNamedQuery("StavkaTim2.getPostavljeneStavkeUsera", StavkaTim2.class);
		q.setParameter("user", em.find(UserTim2.class, username));
		return q.getResultList();
		
	}

	@Override
	public List<StavkaTim2> licitiraneStavke(String username) {
		TypedQuery<StavkaTim2> q=em.createNamedQuery("StavkaTim2.getLicitiraneStavke", StavkaTim2.class);
		q.setParameter("user", em.find(UserTim2.class, username));
		return q.getResultList();
		
	}

}
