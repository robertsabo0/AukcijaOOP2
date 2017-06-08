package prikazStavke;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
		
		//sp.setLayout(new BorderLayout());
		setLayout(new BorderLayout());
		PanelSlika slike=new PanelSlika();
		PanelKomentari komentari=new PanelKomentari(s);
		PanelOpis opis=new PanelOpis(s);
		add(opis, BorderLayout.CENTER);
		add(slike, BorderLayout.WEST);
		add(komentari, BorderLayout.SOUTH);
		//JScrollPane sp=new JScrollPane(this);
		//sp.add(this);
		//sp.setVisible(true);
	}
}
