package prikazStavke;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

import model.StavkaTim2;

import java.awt.BorderLayout;
import java.awt.Dimension;


public class GlavniPanel extends JPanel {
	private StavkaTim2 s;
	/**
	 * Create the panel.
	 */
	public GlavniPanel(StavkaTim2 s) {
		this.s=s;
		JSplitPane sp=new JSplitPane();
		sp.setLayout(new BorderLayout());
		setLayout(new BorderLayout());
		PanelSlika slike=new PanelSlika();
		PanelKomentari komentari=new PanelKomentari();
		PanelOpis opis=new PanelOpis(s);
		sp.add(opis, BorderLayout.CENTER);
		sp.add(slike, BorderLayout.WEST);
		sp.add(komentari, BorderLayout.SOUTH);
		add(sp);
		sp.setVisible(true);
	}
}
