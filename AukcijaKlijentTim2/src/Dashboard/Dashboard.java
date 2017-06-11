package Dashboard;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.naming.NamingException;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import beans.StavkeGetters;
import main.Aukcija;
import main.BeansGetter;
import main.CustomFlowLayout;
import model.StavkaTim2;

public class Dashboard extends JPanel{
	
	public static void main(String[] args) {
		Aukcija.main(args);
	}
	 
	 /**
	 * 
	 */
	private static final long serialVersionUID = -5771702808421735030L;
	
	StavkaTim2 s;
	 JButton dugme;
	 StavkeGetters dashStavka;
	 
	 
	 public Dashboard(){
		 this.setLayout(new GridLayout(4, 1));

		 
		 List<StavkaTim2> licitirane=BeansGetter.stavkeGetters().licitiraneStavke(BeansGetter.sessionStavka().vratiUlogovanog().getUsername());
		 List<StavkaTim2> postavljene=BeansGetter.stavkeGetters().postavljeneStavke(BeansGetter.sessionStavka().vratiUlogovanog().getUsername());

		 JPanel flow1=new JPanel();
		 flow1.setLayout(new CustomFlowLayout());
		 
		 JLabel licitiraneL=new JLabel("Licitirane stavke: ");
		 
		 JPanel p = new JPanel();
		 p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
		 p.add(Box.createHorizontalGlue());
		 p.add(licitiraneL);
		 p.add(Box.createHorizontalGlue());
		 p.setAlignmentY(JPanel.CENTER_ALIGNMENT);
		 add(p);//, BorderLayout.NORTH);
		 
		 for(int i=0;i<licitirane.size();i++){
			 JPanel stavka=new SmallStavkaPanel(licitirane.get(i));
			 flow1.add(stavka);
		 }
		 add(flow1);
		 JLabel postavljeneL=new JLabel("Postavljene stavke: ");
		 
		 JPanel p1 = new JPanel();
		 p1.setLayout(new BoxLayout(p1, BoxLayout.X_AXIS));
		 p1.add(Box.createHorizontalGlue());
		 p1.add(postavljeneL);
		 p1.add(Box.createHorizontalGlue());
		 p1.setAlignmentY(JPanel.CENTER_ALIGNMENT);
		 add(p1);
		 
		 JPanel flow2=new JPanel();
		 flow2.setLayout(new CustomFlowLayout());
		 
		 for(int i=0;i<postavljene.size();i++){
			 JPanel stavka=new SmallStavkaPanel(postavljene.get(i));
			 flow2.add(stavka);
		 }
		 add(flow2);
		 
		// skrol.add(this);
	 }

}
