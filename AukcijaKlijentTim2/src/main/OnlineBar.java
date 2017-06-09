package main;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.NamingException;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import Dashboard.Dashboard;
import registracija.IzmeniProfil;
import registracija.Login;

public class OnlineBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static JFrame frame;
	
	public OnlineBar(JFrame frame) {
		OnlineBar.frame = frame;

		JMenuBar menuBar = new JMenuBar();

		JMenu mnPocetna = new JMenu("Pocetna");
		menuBar.add(mnPocetna);
		mnPocetna.addActionListener(new PostavljanjeDashboarda());
		

		JMenu mnPretraga = new JMenu("Pretraga");
		menuBar.add(mnPretraga);
		
		JMenu mnPostaviStavku  = new JMenu ("Postavi stavku");
		menuBar.add(mnPostaviStavku);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue);

		JMenu mnKorisnik = new JMenu("Korisnik");
		menuBar.add(mnKorisnik);

		JPanel podesavanje = new IzmeniProfil();
		JMenuItem mntmPodesiProfil = new JMenuItem("Podesavanje profila");
		mntmPodesiProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				postaviStranicu(podesavanje);
			}
		});
		mnKorisnik.add(mntmPodesiProfil);
		
		JMenuItem mntmIzlogujSe = new JMenuItem("Izloguj se");
		mntmIzlogujSe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					BeansGetter.sessionStavka().logOut();
					new OfflineBar(frame);
					postaviStranicu(new Login(frame));
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		mnKorisnik.add(mntmIzlogujSe);
		
		frame.setJMenuBar(menuBar);
	}

	public static void postaviStranicu(JPanel stranica) {
		stranica.setPreferredSize(new Dimension(stranica.getWidth(),frame.getHeight()));
		JScrollPane sp = new JScrollPane(stranica,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		JScrollBar vertical = sp.getVerticalScrollBar();
		vertical.setValue(vertical.getMaximum());
		sp.setVerticalScrollBar(vertical);
		
		frame.getContentPane().removeAll();
		frame.setContentPane(sp);
		frame.repaint();
		frame.revalidate();

	}
	private class PostavljanjeDashboarda implements ActionListener{
			
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Dashboard d=new Dashboard();
				OnlineBar.postaviStranicu(d);
			} catch (NamingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}

}
