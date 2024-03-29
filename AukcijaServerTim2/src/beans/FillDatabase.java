package beans;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.BojaTim2;
import model.CommonTim2;
import model.KomentarTim2;
import model.MaterijalTim2;
import model.MaterijalTim2_;
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

	private String[] bojeStr ={"crna", "bela", "zuta", "crvena", "zelena", "crvena","braon", "ljubicasta"};
	private String[] velicinaStr ={"M", "L", "XL","38", "39", "41", "42", "43"};
	private String[] tipoviStr ={"majica", "pantalone","kosulja","haljina", "sako",
							"patike", "cipele", "papuce"};
	private String[] materijaliStr ={"koza", "skaj", "pamuk", "teksas", "likra", "lan", "keper"};
	private UserTim2[] useri;
	private String[] naziviStr={ "pantalone", "majica", "kosulja", "kaput", "patike", "papuce", "cipele", "farmerice"};
	
	private String[] komentariStr={"ok", "uzasno je", "lose je", "dobro je", "dobar kvalitet"};
	
	private Double[] ponudeD={(double) 100, (double) 500, (double)750, 
				(double)1000, (double)2000, (double)2456, (double)3334,
				(double) 3335, (double) 3500, (double)3750, (double)3900,
				(double)4000, (double)5000, (double)6456, (double)7334};
	
			
	private BojaTim2[] boje;
	private VelicinaTim2[] velicine;
	private TipTim2[] tipovi;
	private MaterijalTim2[] materijali;
	private StavkaTim2[] stavke;
	private KomentarTim2[] komentari;
	private PonudaTim2[] ponude;
	
	/* clear DB!
delete from ponudatim2 ;
delete from komentartim2 ;
delete from usertim2 ;
delete from stavkatim2 ;
delete from materijaltim2 ;
delete from bojatim2 ;
delete from tiptim2 ;
delete from velicinatim2 ;
	 */
	
	@PostConstruct

	public void postConstruct() throws ParseException  {
		
		
		if(em.find(UserTim2.class, "admin") == null){

			System.out.println("Database is not filled yet!");
			
			UserTim2 i = new UserTim2();
			i.setUsername("admin");
			i.setPassword("admin");
			em.persist(i);
			
			fillBoja();
			fillMaterijal();
			fillTip();
			fillVelicina();
			dodajKorisnike();
			popuniBazu();
			popuniBazu();
			dodajPonudu();
			dodajPonudu();

			dodajKomentar();
			
			
		}
		System.out.println("Database is filled!");
	}
	
	public void dodajKorisnike(){
		useri=new UserTim2[3];
		
		UserTim2 user=new UserTim2();
		user.setUsername("Stefan");
		user.setPassword("password");
		user.setIme("Stefan");
		user.setPrezime("Simeunovic");
		user.setEmail("simeunovics47@gmail.com");
		em.persist(user);
		useri[0]=user;
		
		UserTim2 user1=new UserTim2();
		user1.setUsername("Robii");
		user1.setPassword("password");
		user1.setIme("Robert");
		user1.setPrezime("Sabo");
		user1.setEmail("robert.sabo@gmail.com");
		em.persist(user1);
		useri[1]=user1;
		
		UserTim2 user2=new UserTim2();
		user2.setUsername("Pane");
		user2.setPassword("pane");
		user2.setIme("Pane");
		user2.setPrezime("Odalovic");
		user2.setEmail("pane.odalovic@gmail.com");
		em.persist(user2);
		useri[2]=user2;
	}
	public void popuniBazu() throws ParseException{
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		Date date = fmt.parse("2013-05-06");
		stavke = new StavkaTim2[10];
		for(int i=0;i<10;i++){
			StavkaTim2 s=new StavkaTim2();
			double r = Math.random();
			s.setAktuelnaCena(Math.round(r*10000));
			s.setMaterijal(materijali[(int)(r*materijali.length)]);
			s.setBoja(boje[(int) (r*boje.length)]);
			s.setVelicina(velicine[(int)(r*velicine.length)]);
			s.setTip(tipovi[(int)(r*tipovi.length)]);
			s.setDatumPostavljanja(date);
			s.setPostavljenoOdStrane(useri[(int)(r*useri.length)]);
			s.setNaziv(s.getTip()+" "+s.getBoja()+" "+s.getVelicina());
			em.persist(s);
			
			stavke[i] = s;
			System.out.println("Stavka ubacena");
		}
	}

	
	public void dodajPonudu(){
		ponude=new PonudaTim2[ponudeD.length];
		int c=0;
		double r=Math.random();

		for(Double d: ponudeD){	
			r=Math.random();
			PonudaTim2 p=new PonudaTim2();
			StavkaTim2 stavka = stavke[(int)(r*stavke.length)];
			stavka.setAktuelnaCena(stavka.getAktuelnaCena()+d);
			UserTim2 user=stavka.getPostavljenoOdStrane();
			
			UserTim2 user1=useri[(int)(r*useri.length)];
			
			while(user==user1){
				r=Math.random();
				user1=useri[(int)(r*useri.length)];
			}
			p.setVrednost(Math.round(stavka.getAktuelnaCena()));
			p.setTimestamp(new Date());
			p.setUser(user1);
			p.setStavka(stavka);
			
			em.persist(p);
			ponude[c++]=p;
		}
	}
	
	public void dodajKomentar(){
		komentari=new KomentarTim2[komentariStr.length];
		int c=0;
		double r=(int) Math.random();
		for(String s: komentariStr){
			KomentarTim2 k=new KomentarTim2();
			k.setSadrzaj(s);
			k.setPostaljeno(new Date());
			k.setPostaljvenoOdStrane(useri[(int)(r*useri.length)]);
			k.setStavka(stavke[(int)(r*stavke.length)]);
			em.persist(k);
			komentari[c++]=k;
		}
	}
	
	private void fillVelicina() {
		velicine=new VelicinaTim2[velicinaStr.length];
		int c=0;
		for(String s : velicinaStr){
			VelicinaTim2 v = new VelicinaTim2();
			v.setOpis(s);
			em.persist(v);
			velicine[c++]=v;
		}
	}


	private void fillTip() {
		tipovi=new TipTim2[tipoviStr.length];
		int c=0;
		for(String s : tipoviStr){
			TipTim2 t = new TipTim2();
			t.setOpis(s);
			em.persist(t);
			tipovi[c++]=t;
		}
	}


	private void fillMaterijal() {
		materijali = new MaterijalTim2[materijaliStr.length];
		int c = 0;
		for(String s : materijaliStr){
			MaterijalTim2 m = new MaterijalTim2();
			m.setOpis(s);
			em.persist(m);
			materijali[c++] = m;
		}
	}


	private void fillBoja() {
		boje=new BojaTim2[bojeStr.length];
		int c=0;
		for(String s : bojeStr){
			BojaTim2 boja = new BojaTim2();
			boja.setOpis(s);
			em.persist(boja);
			boje[c++]=boja;
		}
	}
}
