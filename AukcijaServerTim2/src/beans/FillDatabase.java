package beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import model.BojaTim2;
import model.CommonTim2;
import model.KomentarTim2;
import model.MaterijalTim2;
import model.PonudaTim2;
import model.StavkaTim2;
import model.TipTim2;
import model.UserTim2;
import model.VelicinaTim2;

@Singleton
@LocalBean
@Startup
public class FillDatabase {

	@PersistenceContext(name = CommonTim2.persistanceName)
	private EntityManager em;

	private String[] boje ={"crna", "bela", "zuta", "crvena", "zelena", "crvena","braon", "ljubicasta"};
	private String[] velicina ={"XS", "S", "M", "L", "XL", "XXL", "37", "38", "39", "40", "41", "42", "43", "44", "45"};
	private String[] tipov ={"majica", "pantalone","kosulja","haljina", "sako","sorc", "suknja",
							"patike", "cipele", "papuce", "sandale", "cizme", "zimska obuca", "stikle"};
	private String[] matrijal ={"koza", "skaj", "pamuk"};
	
	
	@PostConstruct
	public void postConstruct()  {
		try {
			this.dodajKomentar();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//popuniBazu();
		//popuniPonude();
		if(em.find(UserTim2.class, "admin") == null){

			System.out.println("Database is not filled yet!");
			
			UserTim2 i = new UserTim2();
			i.setUsername("admin");
			em.persist(i);
			
			fillBoja();
			fillMaterijal();
			fillTip();
			fillVelicina();
			
		}
		System.out.println("Database is filled!");
	}

	public void popuniBazu() throws ParseException{
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		Date date = fmt.parse("2013-05-06");
		for(int i=0;i<10;i++){
			StavkaTim2 s=new StavkaTim2();
			s.setAktuelnaCena(100);
			s.setNaziv("asdasd");
			s.setDatumPostavljanja(date);
			s.setPostavljenoOdStrane(em.find(UserTim2.class, "admin"));
			em.persist(s);
			System.out.println("Stavka ubacena");
		}
	}

	public void popuniPonude(){
		for(int i=0;i<10;i++){
			PonudaTim2 p=new PonudaTim2();
			p.setUser(em.find(UserTim2.class, "admin"));
			p.setVrednost(25);
			em.persist(p);
		}
	}
	public void dodajKomentar() throws ParseException{
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		Date datee = fmt.parse("2013-05-06");
		for(int i=0;i<10;i++){
			KomentarTim2 k=new KomentarTim2();
			k.setPostaljeno(datee);
			k.setSadrzaj("assfdghjgfdsdfgh");
			em.persist(k);
		}
	}
	private void fillVelicina() {
		for(String s : velicina){
			VelicinaTim2 b = new VelicinaTim2();
			b.setOpis(s);
			em.persist(b);
		}
	}


	private void fillTip() {
		for(String s : tipov){
			TipTim2 b = new TipTim2();
			b.setOpis(s);
			em.persist(b);
		}
	}


	private void fillMaterijal() {
		for(String s : matrijal){
			MaterijalTim2 b = new MaterijalTim2();
			b.setOpis(s);
			em.persist(b);
		}
	}


	private void fillBoja() {
		for(String s : boje){
			BojaTim2 boja = new BojaTim2();
			boja.setOpis(s);
			em.persist(boja);
		}
	}
}
