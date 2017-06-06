package Dashboard;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import beans.DashboardStavka;
import main.Aukcija;
import model.StavkaTim2;

public class Dashboard extends JPanel{
	
	 DashboardStavka s=new DashboardStavka();
	 List<StavkaTim2> stavke=s.getSve();
	 List<String> nazivi=s.getNazivi();
	 List<Double> cene=s.getCena();
	 List<Date> datumi=s.getDatum();
	 List<Long> ids=s.getId();
	 
	 
	 
	 public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Dashboard s = new Dashboard();
						s.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	 
	 
	 
	 
	 public Dashboard(){
		 JPanel stavka=new JPanel();
		 stavka.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		 JScrollPane skrol=new JScrollPane();
		 this.add(skrol);
		 this.setSize(500, 500);
		 stavka.setLayout(new BoxLayout(stavka, BoxLayout.X_AXIS));
		 for(int i=0;i<stavke.size();i++){
			 JLabel naziv=new JLabel("Naziv: "+nazivi.get(i));
			 JLabel cena=new JLabel("Cena: "+cene.get(i));
			 JLabel	datum=new JLabel("Datum postavljanja: "+datumi.get(i));
			 JButton dugme=new JButton("Prikazi");
			 
			 stavka.add(naziv);
			 stavka.add(cena);
			 stavka.add(datum);
			 stavka.add(dugme);
			 skrol.add(stavka);
		 }
	 }
}
