package main;

import java.awt.EventQueue;

import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import registracija.Login;

public class Aukcija extends JFrame {

	/**f
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Aukcija me;

	/**
	 * Launch the application.
	 * @throws NamingException 
	 */
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aukcija frame = new Aukcija();
					me = frame;
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Aukcija() {
		setTitle("Aukcija");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 466);

		new OfflineBar(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(new Login(this));

		
		
	}
	public static int getContenctWidth(){
		return me.getContentPane().getWidth();
	}
	public static void postaviStranicu(JPanel stranica) {
		JScrollPane sp = new JScrollPane(stranica, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		me.getContentPane().removeAll();
		me.setContentPane(sp);
		me.repaint();
		me.revalidate();
	}
}
