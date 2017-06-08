package Dashboard;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Aukcija;
import main.OnlineBar;
import model.StavkaTim2;
import prikazStavke.GlavniPanel;

public class SmallStavkaPanel extends JPanel {
	JButton dugme;
	public SmallStavkaPanel(StavkaTim2 s){
		 setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
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
		 this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		 this.add(naziv);
		 this.add(cena);
		 this.add(datum);
		 this.add(dugme);
	}
	private class ProsledjivanjeStavke implements ActionListener{
		 StavkaTim2 s;
		 public ProsledjivanjeStavke(StavkaTim2 s){
			 this.s=s;
		 }
		@Override
		public void actionPerformed(ActionEvent e) {
			GlavniPanel g=new GlavniPanel(s);
			OnlineBar.postaviStranicu(g);
			
		}
		 
	 }
}
