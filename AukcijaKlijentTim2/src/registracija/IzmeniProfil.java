package registracija;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.NamingException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import main.BeansGetter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IzmeniProfil extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2055820999086617818L;
	private JTextField imeField;
	private JTextField prezimeField;
	private JTextField eMailFiled;
	private JTextField opisField;
	private JPasswordField passwordField;
	
	private byte[] slika;

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
		
		passwordField = new JPasswordField();
		
		JButton btnPretrazi = new JButton("Pretrazi");
		btnPretrazi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setCurrentDirectory(new java.io.File("."));
				fc.setDialogTitle("Pretrazivac");
				fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				if (fc.showOpenDialog(btnPretrazi)== JFileChooser.APPROVE_OPTION){
					System.out.println(fc.getSelectedFile().getAbsolutePath());
					slika = fc.getSelectedFile().getAbsolutePath().getBytes();
				}
			}
		});
		
		
		JLabel lblIzaberiSliku = new JLabel("Izaberi sliku:");
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(68)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblIzaberiSliku)
						.addComponent(lblIme)
						.addComponent(lblPrezime)
						.addComponent(lblPassword)
						.addComponent(lblEmail)
						.addComponent(lblOpis))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(prezimeField, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addComponent(imeField, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addComponent(eMailFiled, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addComponent(opisField, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnPretrazi, Alignment.TRAILING))
					.addGap(156))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(imeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIme))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(prezimeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPrezime))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(eMailFiled, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail))
					.addGap(9)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(opisField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOpis))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPretrazi)
						.addComponent(lblIzaberiSliku))
					.addContainerGap(196, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panelSlika = new JPanel();
		add(panelSlika, BorderLayout.WEST);
		ImageIcon image = new ImageIcon("noImage.png");
		panelSlika.setLayout(new BorderLayout(0, 0));
		JLabel lblImage = new JLabel();
		lblImage.setIcon(image);
		panelSlika.add(lblImage, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		
		
		JButton btnIzmeni = new JButton("Izmeni");
		btnIzmeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					boolean izmeni= BeansGetter.sessionStavka().izmeniKorisnika(imeField.getText(), prezimeField.getText(), passwordField.getPassword(),eMailFiled.getText() , opisField.getText(), slika);
					if (izmeni)
						JOptionPane.showMessageDialog(null, "Uspesno ste izmeni profil");
					else
						JOptionPane.showMessageDialog(null, "Niste uspeli izmeniti profil");
			}
		});
		panel_1.add(btnIzmeni);

	}
}
