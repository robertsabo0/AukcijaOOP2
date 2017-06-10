package main;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

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
		
		//JMenu mnPretraga = new JMenu("Pretraga");
		//menuBar.add(mnPretraga);

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
		stranica.setPreferredSize(new Dimension(stranica.getWidth(), frame.getHeight()));
		JScrollPane sp = new JScrollPane(stranica,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		JScrollBar vertical = sp.getVerticalScrollBar();
		vertical.setValue(vertical.getMaximum());
		sp.setVerticalScrollBar(vertical);
		
		frame.getContentPane().removeAll();
		frame.setContentPane(sp);
		frame.repaint();
		frame.revalidate();
		
	}
}
