package registracija;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.NamingException;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import beans.LosaLozinkaException;
import main.BeansGetter;
import main.OnlineBar;
import model.UserTim2;

public class Login extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1281817289232296908L;
	private JTextField userNameField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_1;
	private JTextField textField_5;

	/**
	 * Create the panel.
	 */
	public Login(JFrame frame) {
		setLayout(new BorderLayout(0, 0));

		JSplitPane splitPane = new JSplitPane();
		add(splitPane, BorderLayout.CENTER);

		JPanel regPanel = new JPanel();
		splitPane.setRightComponent(regPanel);
		regPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		regPanel.add(panel_1, BorderLayout.CENTER);
		
		JLabel lblUsername_1 = new JLabel("Username:");
		
		JLabel lblPassword_1 = new JLabel("Password:");
		
		passwordField_1 = new JPasswordField();
		
		JLabel lblIme = new JLabel("Ime:");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblOpis = new JLabel("Opis:");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JButton btnRegistrujSe = new JButton("Registruj se");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblUsername_1)
						.addComponent(lblPassword_1)
						.addComponent(lblIme)
						.addComponent(lblPrezime)
						.addComponent(lblEmail)
						.addComponent(lblOpis))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnRegistrujSe)
						.addComponent(passwordField_1)
						.addComponent(textField_2)
						.addComponent(textField_3)
						.addComponent(textField_5)
						.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
						.addComponent(textField_1))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblPassword_1)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblIme))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPrezime))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmail)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(82)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblOpis))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRegistrujSe)
					.addContainerGap(58, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_3 = new JPanel();
		regPanel.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		panel_3.add(horizontalGlue_2);
		
		JLabel lblRegistrujSe = new JLabel("Registruj se");
		panel_3.add(lblRegistrujSe);
		
		Component horizontalGlue_3 = Box.createHorizontalGlue();
		panel_3.add(horizontalGlue_3);

		JPanel loginPanel = new JPanel();
		splitPane.setLeftComponent(loginPanel);
		loginPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		loginPanel.add(panel, BorderLayout.CENTER);
		
		JLabel lblUsername = new JLabel("Username:");
		
		userNameField = new JTextField();
		userNameField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		
		JButton btnUlogujSe = new JButton("Uloguj se");
		btnUlogujSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					UserTim2 user= BeansGetter.sessionStavka().loginUser(userNameField.getText(),passwordField.getPassword());
						
						/*if (BeansGetter.sessionStavka().getUlogovan()){
								frame.getJMenuBar().removeAll();
								OnlineBar bar = new OnlineBar(frame);
								frame.setJMenuBar(bar);
						}*/
			
				}catch(NullPointerException ex){
					JOptionPane.showMessageDialog(null, "Korisnik s unetim korisnicnik imenom ne postoji");
				}catch (LosaLozinkaException e1) {
					JOptionPane.showMessageDialog(null, "Pogresna sifra za korisnika");
				}catch (NamingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
				}
			}
		});
		
		passwordField = new JPasswordField();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(14, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPassword)
								.addComponent(lblUsername))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passwordField)
								.addComponent(userNameField)))
						.addComponent(btnUlogujSe))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(userNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnUlogujSe)
					.addContainerGap(151, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_2 = new JPanel();
		loginPanel.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		Component horizontalGlue = Box.createHorizontalGlue();
		panel_2.add(horizontalGlue);
		
		JLabel lblUlogujSe = new JLabel("Uloguj se");
		panel_2.add(lblUlogujSe);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		panel_2.add(horizontalGlue_1);
	}
}
