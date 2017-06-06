package registracija;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class IzmeniProfil extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2055820999086617818L;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
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
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblIme = new JLabel("Ime:");
		
		JLabel lblPrezime = new JLabel("Prezime:");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel lblOpis = new JLabel("Opis:");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
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
						.addComponent(textField_5)
						.addComponent(textField_4)
						.addComponent(textField_3)
						.addComponent(textField_2)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(lblmoraBitiJedinstveno)
					.addContainerGap(96, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername)
						.addComponent(lblmoraBitiJedinstveno))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIme))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPrezime))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOpis))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		
		JButton btnIzmeni = new JButton("Izmeni");
		panel_1.add(btnIzmeni);

	}
}
