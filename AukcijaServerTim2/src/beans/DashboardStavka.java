package beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.CommonTim2;
import model.StavkaTim2;


@Stateless
@Remote(DashboardStavkaI.class)
public class DashboardStavka implements DashboardStavkaI{
	
	@PersistenceContext(name = CommonTim2.persistanceName)
	private EntityManager em;

	@Override
	public List<StavkaTim2> getSve() {
		TypedQuery<StavkaTim2> q=em.createNamedQuery("StavkaTim2.getSve", StavkaTim2.class);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Long> getId() {
		Query q=em.createNamedQuery("StavkaTim2.getId", StavkaTim2.class);
		List<Long> listaId= q.getResultList();
		return listaId;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getNazivi() {
		Query q=em.createNamedQuery("StavkaTim2.getNazivi", StavkaTim2.class);
		List<String> nazivi=q.getResultList();
		return nazivi;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Date> getDatum() {
		Query q=em.createNamedQuery("StavkaTim2.getDatum", StavkaTim2.class);
		List<Date> datumi=q.getResultList();
		return datumi;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Double> getCena() {
		Query q=em.createNamedQuery("StavkaTim2.getCena", StavkaTim2.class);
		List<Double> cene=q.getResultList();
		return cene;
	}
	public static void main(String[] args) {
		DashboardStavka s=new DashboardStavka();
		List<StavkaTim2> lista=s.getSve();
		System.out.println(lista);
	}

}
