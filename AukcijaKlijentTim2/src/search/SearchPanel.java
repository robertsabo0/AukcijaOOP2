package search;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SearchPanel extends JPanel {
	public static JPanel showMe(){
		return new SearchPanel();
	}
	
	SearchPanel(){
		add(new JLabel("Hello, World!"));
	}
}
