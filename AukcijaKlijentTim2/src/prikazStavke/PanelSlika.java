package prikazStavke;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PanelSlika extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelSlika() {
		ImageIcon i=new ImageIcon("images.jpg");
		JLabel labela=new JLabel();
		labela.setIcon(i);
		add(labela);
	}

}
