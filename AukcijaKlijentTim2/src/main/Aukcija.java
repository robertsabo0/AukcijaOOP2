package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import registracija.Login;

public class Aukcija extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 * @throws NamingException 
	 */
	public static void main(String[] args) throws NamingException {
		//if(true)return;
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

		new OfflineBar(this);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//contentPane.setLayout(new BorderLayout(0, 0));
		
		postaviStranicu(new Login(this));
		
	}

	public void postaviStranicu(JPanel stranica) {
		getContentPane().removeAll();
		getContentPane().add(stranica);
		getContentPane().repaint();
		getContentPane().revalidate();
		
	}
}
