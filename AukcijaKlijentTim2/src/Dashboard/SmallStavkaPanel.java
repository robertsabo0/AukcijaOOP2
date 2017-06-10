package Dashboard;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.OnlineBar;
import model.StavkaTim2;
import prikazStavke.GlavniPanel;

public class SmallStavkaPanel extends JPanel {
	JButton dugme;
	public SmallStavkaPanel(StavkaTim2 s) {
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
		 BufferedImage slika=null;;
		try {
			slika = ImageIO.read(new File("Desktop/upit.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 JLabel slikaL=new JLabel(new ImageIcon(slika));
		 JLabel	datum=new JLabel("Datum postavljanja: "+s.getDatumPostavljanja());
		 dugme=new JButton("Prikazi");
		 dugme.addActionListener(new ProsledjivanjeStavke(s));
		 this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		 this.add(slikaL);
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
