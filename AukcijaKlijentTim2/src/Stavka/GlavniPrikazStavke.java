package Stavka;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

public class GlavniPrikazStavke extends JSplitPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public GlavniPrikazStavke(){
		//JScrollPane sp=new JScrollPane(this);
		//add(sp);
		setLayout(new BorderLayout());
		Slika s=new Slika();
		Podaci p=new Podaci();
		Komenatari k=new Komenatari();
		add(p, BorderLayout.EAST);
		add(s, BorderLayout.WEST);
		add(k, BorderLayout.SOUTH);
		setVisible(true);
	}
}
