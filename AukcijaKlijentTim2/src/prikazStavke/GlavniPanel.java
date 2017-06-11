package prikazStavke;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister.Pack;

import model.StavkaTim2;

import java.awt.BorderLayout;
import java.awt.Color;


import javax.swing.BorderFactory;



public class GlavniPanel extends JPanel {
	private StavkaTim2 s;
	/**
	 * Create the panel.
	 */
	public GlavniPanel(StavkaTim2 s) {
		this.s=s;
		setLayout(new BorderLayout());
		PanelSlika slike=new PanelSlika(s);
		PanelKomentari komentari=new PanelKomentari(s);
		PanelOpis opis=new PanelOpis(s);
		add(slike, BorderLayout.WEST);
		add(opis, BorderLayout.CENTER);
		add(komentari, BorderLayout.SOUTH);
		
	}
}
