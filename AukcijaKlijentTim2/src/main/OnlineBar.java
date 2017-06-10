package main;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.enterprise.inject.spi.Bean;
import javax.naming.NamingException;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import Dashboard.Dashboard;
import dodavanjeStavke.GlavniPanel;
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
		
		JButton mnPostaviStavku  = new JButton ("Postavi stavku");
		mnPostaviStavku.addActionListener(new PostavljenjeUnosaStavke());
		menuBar.add(mnPostaviStavku);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue);
		
		String ulogovankao = "Ulogovan korisnik: ";
		ulogovankao += BeansGetter.sessionStavka().vratiUlogovanog().getUsername();
		
		
		JLabel label = new JLabel(ulogovankao);
		menuBar.add(label);
		
		menuBar.add(Box.createHorizontalStrut(10));
		
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
				BeansGetter.sessionStavka().logOut();
				new OfflineBar(frame);
				postaviStranicu(new Login(frame));
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
			} catch (NamingException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
	private class PostavljenjeUnosaStavke implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				GlavniPanel g=new GlavniPanel();
				OnlineBar.postaviStranicu(g);
			} catch (NamingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}

}
