package registracija;

import javax.swing.JPanel;
import javax.naming.NamingException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import beans.PostojiUsernameException;
import main.BeansGetter;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IzmeniProfil extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2055820999086617818L;
	private JTextField userNameField;
	private JTextField imeField;
	private JTextField prezimeField;
	private JTextField eMailFiled;
	private JTextField opisField;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public IzmeniProfil() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelNaslov = new JPanel();
		add(panelNaslov, BorderLayout.NORTH);
		
		JLabel lblIzmeniProfil = new JLabel("<html><h3>Izmeni profil");
		panelNaslov.add(lblIzmeniProfil);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		
		JLabel lblUsername = new JLabel("Username:");
		
		userNameField = new JTextField();
		userNameField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		
		imeField = new JTextField();
		imeField.setColumns(10);
		
		JLabel lblIme = new JLabel("Ime:");
		
		JLabel lblPrezime = new JLabel("Prezime:");
		
		prezimeField = new JTextField();
		prezimeField.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		
		eMailFiled = new JTextField();
		eMailFiled.setColumns(10);
		
		JLabel lblOpis = new JLabel("Opis:");
		
		opisField = new JTextField();
		opisField.setColumns(10);
		
		JLabel lblmoraBitiJedinstveno = new JLabel("(*Mora biti jedinstveno)");
		
		passwordField = new JPasswordField();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblIme)
							.addComponent(lblPassword)
							.addComponent(lblPrezime)
							.addComponent(lblEmail)
							.addComponent(lblOpis)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(passwordField)
						.addComponent(opisField)
						.addComponent(eMailFiled)
						.addComponent(prezimeField)
						.addComponent(imeField)
						.addComponent(userNameField, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(lblmoraBitiJedinstveno)
					.addContainerGap(96, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(userNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername)
						.addComponent(lblmoraBitiJedinstveno))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(imeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIme))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(prezimeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPrezime))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(eMailFiled, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(opisField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOpis))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		
		JButton btnIzmeni = new JButton("Izmeni");
		btnIzmeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean izmeni= BeansGetter.sessionStavka().izmeniKorisnika(userNameField.getText(),imeField.getText(), prezimeField.getText(), passwordField.getPassword(),eMailFiled.getText() , opisField.getText());
					if (izmeni)
						JOptionPane.showMessageDialog(null, "Uspesno ste izmeni profil");
					else
						JOptionPane.showMessageDialog(null, "Niste uspeli izmeniti profil");
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (PostojiUsernameException e2){
					JOptionPane.showMessageDialog(null, "Posotoji korisnik s tim korisnickim imenom, probajte drugo!");
				}
			}
		});
		panel_1.add(btnIzmeni);

	}
}
