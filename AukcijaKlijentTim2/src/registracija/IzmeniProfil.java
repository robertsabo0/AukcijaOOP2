package registracija;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
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

import main.Aukcija;
import main.BeansGetter;
import model.UserTim2;

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
	private UserTim2 korisnik = BeansGetter.sessionStavka().vratiUlogovanog();
	private JPanel panelSlika;
	
	private byte[] slika;

	/**
	 * Create the panel.
	 */
	public IzmeniProfil() {
		setLayout(new BorderLayout(0, 0));
		
		JButton btnIzmeni = new JButton("Izmeni");
		btnIzmeni.setEnabled(false);
		JPanel panelNaslov = new JPanel();
		add(panelNaslov, BorderLayout.NORTH);

		JLabel lblIzmeniProfil = new JLabel("<html><h3>Izmeni profil");
		panelNaslov.add(lblIzmeniProfil);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);

		JLabel lblPassword = new JLabel("Password:");

		imeField = new JTextField();
		imeField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				btnIzmeni.setEnabled(true);
			}
		});
		imeField.setColumns(10);
		imeField.setText(korisnik.getIme());

		JLabel lblIme = new JLabel("Ime:");

		JLabel lblPrezime = new JLabel("Prezime:");

		prezimeField = new JTextField();
		prezimeField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				btnIzmeni.setEnabled(true);
			}
		});
		prezimeField.setColumns(10);
		prezimeField.setText(korisnik.getPrezime());

		JLabel lblEmail = new JLabel("E-mail:");

		eMailFiled = new JTextField();
		eMailFiled.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				btnIzmeni.setEnabled(true);
			}
		});
		eMailFiled.setColumns(10);
		eMailFiled.setText(korisnik.getPassword());

		JLabel lblOpis = new JLabel("Opis:");

		opisField = new JTextField();
		opisField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				btnIzmeni.setEnabled(true);
			}
		});
		opisField.setColumns(10);
		opisField.setText(korisnik.getOpis());

		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				btnIzmeni.setEnabled(true);
			}
		});
		passwordField.setText(korisnik.getPassword());

		JButton btnPretrazi = new JButton("Pretrazi");
		btnPretrazi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnIzmeni.setEnabled(true);
				JFileChooser fc = new JFileChooser();
				fc.setCurrentDirectory(new java.io.File("."));
				fc.setDialogTitle("Pretrazivac");
				fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				if (fc.showOpenDialog(btnPretrazi) == JFileChooser.APPROVE_OPTION) {
					System.out.println(fc.getSelectedFile().getAbsolutePath());
					Path p = Paths.get(fc.getSelectedFile().getPath());

					// slika =
					BufferedImage img;
					try {
						img = resize(ImageIO.read(new ByteArrayInputStream(Files.readAllBytes(p))), 75, 100);
						slika = imageToByteArray(img);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});

		JLabel lblIzaberiSliku = new JLabel("Izaberi sliku:");

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(68)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addComponent(lblIzaberiSliku)
								.addComponent(lblIme).addComponent(lblPrezime).addComponent(lblPassword)
								.addComponent(lblEmail).addComponent(lblOpis))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, gl_panel
								.createParallelGroup(Alignment.LEADING)
								.addComponent(prezimeField, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
								.addComponent(imeField, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 111,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(eMailFiled, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
								.addComponent(opisField, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnPretrazi, Alignment.TRAILING))
						.addGap(156)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(imeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIme))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(prezimeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPrezime))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(eMailFiled, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail))
				.addGap(9)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(opisField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOpis))
				.addPreferredGap(ComponentPlacement.UNRELATED).addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPretrazi).addComponent(lblIzaberiSliku))
				.addContainerGap(196, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		
		if (korisnik.getSlika() != null){
			postaviSliku(korisnik.getSlika());
		} else{
			
			try {
				BufferedImage img = ImageIO.read(new File("noImage.png"));
				img = resize(img, 75, 100);
				byte [] nova = imageToByteArray(img);
				postaviSliku(nova);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		
		final JPanel ovaj = this;
		
		btnIzmeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean izmeni = BeansGetter.sessionStavka().izmeniKorisnika(imeField.getText(), prezimeField.getText(),
						passwordField.getPassword(), eMailFiled.getText(), opisField.getText(), slika);
				if (izmeni){
					JOptionPane.showMessageDialog(null, "Uspesno ste izmeni profil");
					postaviSliku(slika);
					Aukcija.me.postaviStranicu(ovaj);
				}
				else
					JOptionPane.showMessageDialog(null, "Niste uspeli izmeniti profil");
			}
		});
		panel_1.add(btnIzmeni);

		JButton btnTest = new JButton("Test");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TestFrame tf = new TestFrame();
				tf.setVisible(true);
			}
		});
		panel_1.add(btnTest);

	}
	
	//smanjuje velicinu slike
	public static BufferedImage resize(BufferedImage img, int newW, int newH) {
		int w = img.getWidth();
		int h = img.getHeight();
		BufferedImage dimg = new BufferedImage(newW, newH, img.getType());
		Graphics2D g = dimg.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);
		g.dispose();
		return dimg;
	}
	
	//prebacuje sliku u niz
	static byte[] imageToByteArray(BufferedImage image) {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		try {
			ImageIO.write(image, "png", stream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return stream.toByteArray();
	}
	
	//postavlja sliku na panel
	public void postaviSliku(byte [] slika) {
		BufferedImage img;
		try {
			img = ImageIO.read(new ByteArrayInputStream(slika));
			
			ImageIcon i = new ImageIcon(img);
			JLabel lblNewLabel = new JLabel();
			lblNewLabel.setIcon(i);
			
			panelSlika = new JPanel();
			panelSlika.add(lblNewLabel, BorderLayout.NORTH);
			panelSlika.setPreferredSize(new Dimension(120, getHeight()));
			add(panelSlika, BorderLayout.WEST);
			
			panelSlika.repaint();
			panelSlika.revalidate();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
