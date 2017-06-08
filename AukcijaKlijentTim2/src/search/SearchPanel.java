package search;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class SearchPanel extends JPanel {
	public static JPanel showMe(){
		return new SearchPanel();
	}
	
	SearchPanel(){
		setLayout(new BorderLayout());
		JPanel filter = new FiltersPanel();
		add(filter, BorderLayout.NORTH);
	}
}
