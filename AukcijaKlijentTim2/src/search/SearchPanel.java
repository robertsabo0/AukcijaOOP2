package search;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Dashboard.SmallStavkaPanel;
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
		JPanel filter = new FiltersPanel(this);
		add(filter, BorderLayout.NORTH);
		bot = new JPanel();
		add(bot, BorderLayout.CENTER);
	}
	
	public void addStavkes(List<StavkaTim2> stavke){
		if(bot!=null)parent.remove(bot);
		 bot=new JPanel();
		 bot.setLayout(new FlowLayout());
		 add(bot);

		 for(StavkaTim2 s : stavke){
			 JPanel stavkaPanel=new SmallStavkaPanel(s);
			 bot.add(stavkaPanel);
		 }
		 parent.repaint();
		 parent.revalidate();
	}
}
