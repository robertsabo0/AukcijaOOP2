package main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import registracija.Login;
import javax.swing.JMenuItem;

public class Aukcija extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aukcija frame = new Aukcija();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Aukcija() {
		setTitle("Aukcija");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 466);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnPocetna = new JMenu("Pocetna");
		menuBar.add(mnPocetna);

		JMenu mnPretraga = new JMenu("Pretraga");
		menuBar.add(mnPretraga);

		Component horizontalGlue = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue);
		
		JMenu mnKorisnik = new JMenu("Korisnik");
		menuBar.add(mnKorisnik);
		
		JPanel logovanje = new Login();
		JMenuItem mntmUlogujSe = new JMenuItem("Uloguj se");
		mntmUlogujSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				postaviStranicu(logovanje);
			}
		});
		mnKorisnik.add(mntmUlogujSe);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		repaint();
	}

	public void postaviStranicu(JPanel stranica) {
		getContentPane().removeAll();
		getContentPane().add(stranica);
		getContentPane().repaint();
		getContentPane().revalidate();
		
	}
}
