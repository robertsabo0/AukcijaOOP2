package search;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Dashboard.SmallStavkaPanel;
import main.Aukcija;
import model.StavkaTim2;

public class SearchPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8938800055710281067L;

	public static void main(String[] args) {
		TestFrame.main(args);
	}
	
	public static JPanel showMe(JFrame p){
		return new SearchPanel(p); 
	}
	JFrame parent;
	JPanel bot;
	
	SearchPanel(JFrame p){
		parent = p;
		setLayout(new BorderLayout());
		bot = new JPanel();
		add(bot, BorderLayout.CENTER);
		
		JPanel filter = new FiltersPanel(this);
		add(filter, BorderLayout.NORTH);
	}
	
	public void addStavkes(List<StavkaTim2> stavke){
		 remove(bot);
		 bot=new JPanel();
		 bot.setLayout(new FlowLayout());
		 bot.setPreferredSize(parent.getSize());
		 bot.add((Component)Box.createHorizontalGlue());
		 for(StavkaTim2 s : stavke){
			 JPanel stavkaPanel=new SmallStavkaPanel(s);
			 bot.add(stavkaPanel);
		 }

		 add(bot);
		 
		 if(parent instanceof Aukcija)
			 ((Aukcija)parent).postaviStranicu(this);
		 else{
			 
			 parent.repaint();
			 parent.revalidate();
		 }
	}
}
