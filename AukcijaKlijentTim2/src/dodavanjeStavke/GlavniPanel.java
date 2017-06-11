package dodavanjeStavke;

import java.awt.BorderLayout;

import javax.naming.NamingException;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GlavniPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7382394229602793645L;

	/**
	 * Create the panel.
	 * @throws NamingException 
	 */
	public GlavniPanel() throws NamingException{
		setLayout(new BorderLayout());
		PodaciPanel p=new PodaciPanel();
		JLabel naslov=new JLabel("Unos novog artikla na aukciju: ");
		add(naslov, BorderLayout.NORTH);
		add(p, BorderLayout.CENTER);
		

	}
}
