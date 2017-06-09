package main;

import java.awt.Component;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import registracija.Login;

public class OfflineBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	
	public OfflineBar(JFrame frame) {
		this.frame=frame;
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu mnPretraga = new JMenu("Pretraga");
		menuBar.add(mnPretraga);

		Component horizontalGlue = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue);

		JMenu mnKorisnik = new JMenu("Korisnik");
		menuBar.add(mnKorisnik);

		JPanel logovanje = new Login(frame);
		JMenuItem mntmUlogujSe = new JMenuItem("Uloguj se");
		mntmUlogujSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				postaviStranicu(logovanje);
			}
		});
		mnKorisnik.add(mntmUlogujSe);
		frame.setJMenuBar(menuBar);
	}
	
	public void postaviStranicu(JPanel stranica) {
		ScrollPane sp = new ScrollPane();
		sp.add(stranica);
		frame.getContentPane().removeAll();
		frame.getContentPane().add(sp);
		frame.getContentPane().repaint();
		frame.getContentPane().revalidate();
		
	}
}
