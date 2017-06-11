package search;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Dashboard.SmallStavkaPanel;
import main.Aukcija;
import main.CustomFlowLayout;
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
		this(p, new ArrayList<StavkaTim2>());
	}
	
	SearchPanel(JFrame p, List<StavkaTim2> stavke){
		parent = p;
		setLayout(new BorderLayout());
		
		JPanel filter = new FiltersPanel(this);
		add(filter, BorderLayout.NORTH);
		
		 bot=new JPanel();
		 //FlowLayout f=new FlowLayout();
		 bot.setLayout(new CustomFlowLayout());
		 for(StavkaTim2 s : stavke){
			 JPanel stavkaPanel=new SmallStavkaPanel(s);
			 bot.add(stavkaPanel);
		 }
		 
		 add(bot);
	}
	
	public void addStavkes(List<StavkaTim2> stavke){
		 Aukcija.postaviStranicu(new SearchPanel(parent, stavke));
	}
}
