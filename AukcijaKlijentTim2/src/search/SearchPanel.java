package search;

import java.awt.BorderLayout;

import javax.naming.NamingException;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Dashboard.Dashboard;

public class SearchPanel extends JPanel {
	public static JPanel showMe(){
		return new SearchPanel();
	}
	
	SearchPanel(){
		setLayout(new BorderLayout());
		add(new FiltersPanel(), BorderLayout.NORTH);
		try {
			add(new Dashboard(), BorderLayout.CENTER);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
