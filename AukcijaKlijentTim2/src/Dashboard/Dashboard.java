package Dashboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.el.MethodExpression;
import javax.faces.application.NavigationCase;
import javax.faces.flow.Flow;
import javax.faces.flow.FlowCallNode;
import javax.faces.flow.FlowNode;
import javax.faces.flow.MethodCallNode;
import javax.faces.flow.Parameter;
import javax.faces.flow.ReturnNode;
import javax.faces.flow.SwitchNode;
import javax.faces.flow.ViewNode;
import javax.faces.lifecycle.ClientWindow;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import beans.StavkeGetters;
import main.Aukcija;
import main.BeansGetter;
import model.StavkaTim2;
import model.UserTim2;
import prikazStavke.GlavniPanel;

public class Dashboard extends JPanel{
	
	 
	 StavkaTim2 s;
	 JButton dugme;
	 StavkeGetters dashStavka;
	 
	private StavkeGetters getDashboardStavka() throws NamingException
	{
		if (dashStavka == null)
		{
			InitialContext ctx = new InitialContext();
			String name = "ejb:/AukcijaServerTim2//StavkeGettersImpl!" + StavkeGetters.class.getName();
			dashStavka = (StavkeGetters) ctx.lookup(name);
		}
		return dashStavka;
	}
	 
	 public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Dashboard s = new Dashboard();
						JFrame f=new JFrame();
						f.add(s);
						System.out.println("Dodaj panel u frejm");
						f.dispose();
						f.setSize(600, 600);
						f.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	 
	 
	 
	 
	 public Dashboard() throws NamingException{
<<<<<<< HEAD
		 this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		 
		 List<StavkaTim2> licitirane=BeansGetter.stavkeGetters().licitiraneStavke("admin");
		 List<StavkaTim2> postavljene=BeansGetter.stavkeGetters().postavljeneStavke("admin");

		 List<StavkaTim2> stavke= BeansGetter.stavkeGetters().getSve();

		 
		 
		 JLabel licitiraneL=new JLabel("Licitirane stavke: ");
		 licitiraneL.setHorizontalAlignment(SwingConstants.CENTER);
		 add(licitiraneL);
		 JPanel flow1=new JPanel();
		 flow1.setLayout(new FlowLayout());
		 add(flow1);
=======
		 this.setLayout(new FlowLayout());
		 
		 List<StavkaTim2> licitirane=getDashboardStavka().licitiraneStavke("admin");
		 List<StavkaTim2> postavljene=getDashboardStavka().postavljeneStavke("admin");
		 List<StavkaTim2> stavke= BeansGetter.stavkeGetters().getSve();
		 
		 JScrollPane skrol=new JScrollPane();
		 JLabel l1=new JLabel("Licitirane stavke: ");
		 add(l1);
>>>>>>> b135350337015a92b6a014f7d8d51144ecd638fb
		 for(int i=0;i<licitirane.size();i++){
			 JPanel stavka=new JPanel();
			 stavka.setLayout(new BoxLayout(stavka, BoxLayout.Y_AXIS));
			 s=licitirane.get(i);
			 JLabel naziv=new JLabel("Naziv: "+s.getNaziv());
			 JLabel cena;
			 if(s.isProdata()){
				 cena=new JLabel("Prodato za: "+s.getAktuelnaCena());
				 cena.setForeground(Color.RED);
				
			 }
			 else{
				 cena=new JLabel("Aktuelna cena: "+s.getAktuelnaCena());
				 cena.setForeground(Color.GREEN);
				// cena.settex
				
			 }
			 
			 JLabel	datum=new JLabel("Datum postavljanja: "+s.getDatumPostavljanja());
			 dugme=new JButton("Prikazi");
			 dugme.addActionListener(new ProsledjivanjeStavke(s));
			 stavka.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
			 stavka.add(naziv);
			 stavka.add(cena);
			 stavka.add(datum);
			 stavka.add(dugme);
			 flow1.add(stavka);
		 }
		 
		 JLabel postavljeneL=new JLabel("Postavljene stavke: ");
		 postavljeneL.setHorizontalAlignment(SwingConstants.CENTER);
		 add(postavljeneL);
		 JPanel flow2=new JPanel();
		 flow1.setLayout(new FlowLayout());
		 add(flow2);
		 for(int i=0;i<postavljene.size();i++){
			 JPanel stavka=new JPanel();
			 stavka.setLayout(new BoxLayout(stavka, BoxLayout.Y_AXIS));
			 s=postavljene.get(i);
			 JLabel naziv=new JLabel("Naziv: "+s.getNaziv());
			 JLabel cena;
			 if(s.isProdata()){
				 cena=new JLabel("Prodato za: "+s.getAktuelnaCena());
				 cena.setForeground(Color.RED);
				
				
			 }
			 else{
				 cena=new JLabel("Aktuelna cena: "+s.getAktuelnaCena());
				 cena.setForeground(Color.GREEN);
				 
			 }
			 
			 JLabel	datum=new JLabel("Datum postavljanja: "+s.getDatumPostavljanja());
			 dugme=new JButton("Prikazi");
			 dugme.addActionListener(new ProsledjivanjeStavke(s));
			 stavka.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
			 stavka.add(naziv);
			 stavka.add(cena);
			 stavka.add(datum);
			 stavka.add(dugme);
			 flow2.add(stavka);
		 }
		 
		// skrol.add(this);
	 }
	 private class ProsledjivanjeStavke implements ActionListener{
		 StavkaTim2 s;
		 public ProsledjivanjeStavke(StavkaTim2 s){
			 this.s=s;
		 }
		@Override
		public void actionPerformed(ActionEvent e) {
			GlavniPanel g=new GlavniPanel(s);
			
		}
		 
	 }
}
