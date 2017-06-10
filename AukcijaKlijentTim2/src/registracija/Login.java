package registracija;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Dashboard.Dashboard;
import beans.LosUsernameException;
import beans.LosaLozinkaException;
import beans.NoUsernameException;
import beans.PostojiUsernameException;
import main.BeansGetter;
import main.OnlineBar;
import model.UserTim2;
import search.SearchPanel;

public class Login extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1281817289232296908L;
	private JTextField userNameField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField imeField2;
	private JTextField prezimeField2;
	private JTextField eMailField2;
	private JTextField userNameFiled2;
	private JTextField opisField2;
	
	private JFrame frame;

	/**
	 * Create the panel.
	 */
	public Login(JFrame frame) {
		this.frame=frame;
		setLayout(new BorderLayout(0, 0));

		JSplitPane splitPane = new JSplitPane();
		add(splitPane);

		JPanel regPanel = new JPanel();
		splitPane.setRightComponent(regPanel);
		regPanel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		regPanel.add(panel_1, BorderLayout.CENTER);

		JLabel lblUsername_1 = new JLabel("Username:");

		JLabel lblPassword_1 = new JLabel("Password:");

		passwordField_1 = new JPasswordField();

		JLabel lblIme = new JLabel("Ime:");

		imeField2 = new JTextField();
		imeField2.setColumns(10);

		JLabel lblPrezime = new JLabel("Prezime:");

		prezimeField2 = new JTextField();
		prezimeField2.setColumns(10);

		JLabel lblEmail = new JLabel("E-mail:");

		eMailField2 = new JTextField();
		eMailField2.setColumns(10);

		userNameFiled2 = new JTextField();
		userNameFiled2.setColumns(10);

		JLabel lblOpis = new JLabel("Opis:");

		opisField2 = new JTextField();
		opisField2.setColumns(10);

		JButton btnRegistrujSe = new JButton("Registruj se");
		btnRegistrujSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UserTim2 user = BeansGetter.sessionStavka().registrujKorisnika(userNameFiled2.getText(),
							passwordField_1.getPassword(), imeField2.getText(), prezimeField2.getText(),
							eMailField2.getText(), opisField2.getText());
					if (user != null) {
						System.out.println("Registovao se");
						new OnlineBar(frame);
						postaviStranicu(new Dashboard());
					}
				} catch (NoUsernameException e1) {
					JOptionPane.showMessageDialog(null, "Obavezno je uneti korisnicko ime!");
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (PostojiUsernameException e1) {
					JOptionPane.showMessageDialog(null, "Korisnicko ime je zauzeo, probajte ponovo!");
				}
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(37)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addComponent(lblUsername_1)
								.addComponent(lblPassword_1).addComponent(lblIme).addComponent(lblPrezime)
								.addComponent(lblEmail).addComponent(lblOpis))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false).addComponent(btnRegistrujSe)
								.addComponent(passwordField_1).addComponent(imeField2).addComponent(prezimeField2)
								.addComponent(opisField2)
								.addComponent(eMailField2, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
								.addComponent(userNameFiled2))
						.addContainerGap(27, Short.MAX_VALUE)));
		gl_panel_1
				.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
						.createSequentialGroup().addGap(24).addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(userNameFiled2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUsername_1))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addComponent(lblPassword_1)
								.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, 18,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
								.createSequentialGroup()
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(imeField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblIme))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(prezimeField2, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPrezime))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(eMailField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblEmail)))
								.addGroup(gl_panel_1.createSequentialGroup().addGap(82)
										.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
												.addComponent(opisField2, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblOpis))))
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnRegistrujSe)
						.addContainerGap(58, Short.MAX_VALUE)));
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
				try {
					UserTim2 user = BeansGetter.sessionStavka().loginUser(userNameField.getText(),
							passwordField.getPassword());
					if (user != null) {
						System.out.println("Ulogovao se");
						new OnlineBar(frame);
						postaviStranicu(new Dashboard());
					}

				} catch (LosaLozinkaException e1) {
					JOptionPane.showMessageDialog(null, "Pogresna sifra za korisnika");
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (LosUsernameException ex2) {
					JOptionPane.showMessageDialog(null, "Korisnik s unetim korisnicnik imenom ne postoji");
				}
			}
		});

		passwordField = new JPasswordField();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap(14, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
										.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblPassword).addComponent(lblUsername))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
												.addComponent(passwordField).addComponent(userNameField)))
								.addComponent(btnUlogujSe))
						.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(19)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblUsername).addComponent(
						userNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnUlogujSe)
				.addContainerGap(151, Short.MAX_VALUE)));
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

		JPanel panel_4 = new JPanel();
		add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));

		Component horizontalGlue_4 = Box.createHorizontalGlue();
		panel_4.add(horizontalGlue_4);

		JLabel lblUpozorenjeNeulogovanPosetilac = new JLabel(
				"Upozorenje: Neulogovan posetilac moze samo da pretrazuje sadrzaj ");
		panel_4.add(lblUpozorenjeNeulogovanPosetilac);

		JButton btnPresoci = new JButton("Presoci");
		btnPresoci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				postaviStranicu(SearchPanel.showMe(frame));
			}
		});
		panel_4.add(btnPresoci);
	}

	public void postaviStranicu(JPanel stranica) {
		stranica.setPreferredSize(new Dimension(stranica.getWidth(), frame.getHeight()));
		JScrollPane sp = new JScrollPane(stranica, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		JScrollBar vertical = sp.getVerticalScrollBar();
		vertical.setValue(vertical.getMaximum());
		sp.setVerticalScrollBar(vertical);
		
		frame.getContentPane().removeAll();
		frame.setContentPane(sp);
		frame.repaint();
		frame.revalidate();
	}
}
