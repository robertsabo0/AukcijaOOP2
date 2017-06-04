package Stavka;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class Podaci extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Podaci(){
		setLayout(new GridLayout(11, 1, 0, 0));
		JLabel naziv=new JLabel("Naziv: ");
		add(naziv);
		JLabel opis=new JLabel("Opis: ");
		add(opis);
		JLabel boja=new JLabel("Boja: ");
		add(boja);
		JLabel materijal=new JLabel("Materijal: ");
		add(materijal);
		JLabel tip=new JLabel("Tip: ");
		add(tip);
		JLabel velicina= new JLabel("Velicina: ");
		add(velicina);
		JLabel datumPostavljanja=new JLabel("Datum postavljanja je: ");
		add(datumPostavljanja);
		JLabel korisnik=new JLabel("Postavljenje od strane: ");
		add(korisnik);
		JLabel aktuelnaCena=new JLabel("Aktuenla cena: ");
		add(aktuelnaCena);
		JLabel postavka=new JLabel("Postavi cenu: ");
		add(postavka);
		JButton postavi=new JButton("Postavi");
		add(postavi);
		
		
	}
}
