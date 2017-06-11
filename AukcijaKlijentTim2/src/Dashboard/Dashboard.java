package Dashboard;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Aukcija;
import main.BeansGetter;
import main.CustomFlowLayout;
import model.StavkaTim2;

public class Dashboard extends JPanel{
	
	public static void main(String[] args) {
		Aukcija.main(args);
	}
	 
	private static final long serialVersionUID = -5771702808421735030L;
	
	StavkaTim2 s;
	 JButton dugme;
	 
	 
	 public Dashboard(){
		 this.setLayout(new BorderLayout());

		 
		 List<StavkaTim2> licitirane=BeansGetter.stavkeGetters().licitiraneStavke(BeansGetter.sessionStavka().vratiUlogovanog().getUsername());
		 List<StavkaTim2> postavljene=BeansGetter.stavkeGetters().postavljeneStavke(BeansGetter.sessionStavka().vratiUlogovanog().getUsername());

		 JLabel licitiraneL=new JLabel("Vase licitirane i vase stavke: ");
		 
		 JPanel p = new JPanel();
		 p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
		 p.add(Box.createHorizontalGlue());
		 p.add(licitiraneL);
		 p.add(Box.createHorizontalGlue());
		 p.setAlignmentY(JPanel.CENTER_ALIGNMENT);
		 add(p, BorderLayout.NORTH);
		 
		 JPanel flow1=new JPanel();
		 flow1.setLayout(new CustomFlowLayout());
		 
		 for(int i=0;i<licitirane.size();i++){
			 JPanel stavka=new SmallStavkaPanel(licitirane.get(i));
			 flow1.add(stavka);
		 }
		 
		 		 
		 for(int i=0;i<postavljene.size();i++){
			 JPanel stavka=new SmallStavkaPanel(postavljene.get(i));
			 flow1.add(stavka);
		 }
		 add(flow1);
	 }

}
