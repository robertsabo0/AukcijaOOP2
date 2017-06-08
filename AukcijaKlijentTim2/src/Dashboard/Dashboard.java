package Dashboard;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.util.List;

import javax.naming.NamingException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import beans.StavkeGetters;
import main.BeansGetter;
import model.StavkaTim2;

public class Dashboard extends JPanel{
	
	 
	 StavkaTim2 s;
	 JButton dugme;
	 StavkeGetters dashStavka;
	 
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

		 for(int i=0;i<licitirane.size();i++){
			 JPanel stavka=new SmallStavkaPanel(licitirane.get(i));
			 flow1.add(stavka);
		 }
		 
		 JLabel postavljeneL=new JLabel("Postavljene stavke: ");
		 postavljeneL.setHorizontalAlignment(SwingConstants.CENTER);
		 add(postavljeneL);
		 JPanel flow2=new JPanel();
		 flow2.setLayout(new FlowLayout());
		 add(flow2);
		 for(int i=0;i<postavljene.size();i++){
			 JPanel stavka=new SmallStavkaPanel(postavljene.get(i));
			 flow2.add(stavka);
		 }
		 
		// skrol.add(this);
	 }

}
