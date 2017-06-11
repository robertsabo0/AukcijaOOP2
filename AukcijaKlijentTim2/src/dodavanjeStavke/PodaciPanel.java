package dodavanjeStavke;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.BeansGetter;
import model.BojaTim2;
import model.MaterijalTim2;
import model.StavkaTim2;
import model.TipTim2;
import model.VelicinaTim2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;

public class PodaciPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Create the panel.
	 */
	public PodaciPanel() throws NamingException {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 101, 90, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, -7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Naziv:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 1;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Opis:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 3;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setColumns(20);
		textArea.setLineWrap(true);
		textArea.setRows(3);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 4;
		gbc_textArea.gridy = 3;
		add(textArea, gbc_textArea);
		
		JLabel lblNewLabel_2 = new JLabel("Boja:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 5;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JComboBox<BojaTim2>comboBox = new JComboBox<>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 4;
		gbc_comboBox.gridy = 5;
		java.util.List<BojaTim2> l = BeansGetter.stavkeGetters().getBoje();
		for(BojaTim2 li : l)
			comboBox.addItem(li);
		comboBox.setSelectedItem(null);
		add(comboBox, gbc_comboBox);
		
		textField_4 = new JTextField();
		
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 4;
		gbc_textField_4.gridy = 6;
		add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Nova boja");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BojaTim2 b=new BojaTim2();
				String opis=textField_4.getText();
				b.setOpis(opis);
				BojaTim2 boja=null;
				boja=BeansGetter.sessionStavka().sacuvajBoju(b);
				
				comboBox.addItem(boja);
				comboBox.setSelectedItem(boja);
			}
		});
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				btnNewButton_1.setEnabled(true);
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 5;
		gbc_btnNewButton_1.gridy = 6;
		add(btnNewButton_1, gbc_btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Materijal:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 7;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JComboBox<MaterijalTim2> comboBox_1 = new JComboBox<>();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 4;
		gbc_comboBox_1.gridy = 7;
		java.util.List<MaterijalTim2> mat = BeansGetter.stavkeGetters().getMaterijali();
		for(MaterijalTim2 li : mat)
			comboBox_1.addItem(li);
		comboBox_1.setSelectedItem(null);
		add(comboBox_1, gbc_comboBox_1);
		
		textField_5 = new JTextField();
		
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 4;
		gbc_textField_5.gridy = 8;
		add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Novi materijal");
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaterijalTim2 m=new MaterijalTim2();
				String opis=textField_5.getText();
				m.setOpis(opis);
				MaterijalTim2 mat=null;
				mat=BeansGetter.sessionStavka().sacuvajMaterija(m);
				
				comboBox_1.addItem(mat);
				comboBox_1.setSelectedItem(mat);
			}
		});
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				btnNewButton_2.setEnabled(true);
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 5;
		gbc_btnNewButton_2.gridy = 8;
		add(btnNewButton_2, gbc_btnNewButton_2);
		
		
		JLabel lblNewLabel_4 = new JLabel("Tip:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 9;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JComboBox<TipTim2> comboBox_2 = new JComboBox<>();
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 4;
		gbc_comboBox_2.gridy = 9;
		java.util.List<TipTim2> tip = BeansGetter.stavkeGetters().getTipovi();
		for(TipTim2 li : tip)
			comboBox_2.addItem(li);
		comboBox_2.setSelectedItem(null);
		add(comboBox_2, gbc_comboBox_2);
		
		JButton btnNewButton_3 = new JButton("Novi tip");
		btnNewButton_3.setEnabled(false);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TipTim2 t=new TipTim2();
				String opis=textField_6.getText();
				t.setOpis(opis);
				TipTim2 tip=null;
				tip=BeansGetter.sessionStavka().sacuvajTip(t);
				
				comboBox_2.addItem(tip);
				comboBox_2.setSelectedItem(tip);
			}
		});
		
		textField_6 = new JTextField();
		textField_6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				btnNewButton_3.setEnabled(true);
			}
		});
		
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 4;
		gbc_textField_6.gridy = 10;
		add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_3.gridx = 5;
		gbc_btnNewButton_3.gridy = 10;
		add(btnNewButton_3, gbc_btnNewButton_3);
		
		JLabel lblNewLabel_5 = new JLabel("Velicnia:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 2;
		gbc_lblNewLabel_5.gridy = 11;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JComboBox<VelicinaTim2> comboBox_3 = new JComboBox<>();
		GridBagConstraints gbc_comboBox_3 = new GridBagConstraints();
		gbc_comboBox_3.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_3.gridx = 4;
		gbc_comboBox_3.gridy = 11;
		java.util.List<VelicinaTim2> vel = BeansGetter.stavkeGetters().getVelicine();
		for(VelicinaTim2 li : vel)
			comboBox_3.addItem(li);
		comboBox_3.setSelectedItem(null);
		add(comboBox_3, gbc_comboBox_3);
		
		textField_7 = new JTextField();
	
		
		
		
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.insets = new Insets(0, 0, 5, 5);
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 4;
		gbc_textField_7.gridy = 12;
		add(textField_7, gbc_textField_7);
		textField_7.setColumns(10);
		
		JButton btnNovaVelicina = new JButton("Nova velicina");
		textField_7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				btnNovaVelicina.setEnabled(true);
			}
		});
		btnNovaVelicina.setEnabled(false);
		btnNovaVelicina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VelicinaTim2 v=new VelicinaTim2();
				String opis=textField_7.getText();
				v.setOpis(opis);
				VelicinaTim2 vel=null;
				
				vel=BeansGetter.sessionStavka().sacuvajVelicni(v);
				
				comboBox_3.addItem(vel);
				comboBox_3.setSelectedItem(vel);
			}
		});
		
		GridBagConstraints gbc_btnNovaVelicina = new GridBagConstraints();
		gbc_btnNovaVelicina.anchor = GridBagConstraints.WEST;
		gbc_btnNovaVelicina.insets = new Insets(0, 0, 5, 0);
		gbc_btnNovaVelicina.gridx = 5;
		gbc_btnNovaVelicina.gridy = 12;
		add(btnNovaVelicina, gbc_btnNovaVelicina);
		
		JLabel lblNewLabel_6 = new JLabel("Minimalna cena:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 2;
		gbc_lblNewLabel_6.gridy = 13;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 4;
		gbc_textField_2.gridy = 13;
		add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Slika:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 2;
		gbc_lblNewLabel_7.gridy = 15;
		add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 4;
		gbc_textField_3.gridy = 15;
		add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("postavi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StavkaTim2 s=new StavkaTim2();
				s.setNaziv(textField.getText());
				s.setOpis(textArea.getText());
				s.setDatumPostavljanja(new Date());
				s.setAktuelnaCena(Integer.parseInt(textField_2.getText()));
				s.setBoja(comboBox.getItemAt(comboBox.getSelectedIndex()));
				s.setMaterijal(comboBox_1.getItemAt(comboBox_1.getSelectedIndex()));
				s.setTip(comboBox_2.getItemAt(comboBox_2.getSelectedIndex()));
				s.setVelicina(comboBox_3.getItemAt(comboBox_3.getSelectedIndex()));
				s.setPostavljenoOdStrane(BeansGetter.sessionStavka().vratiUlogovanog());
				BeansGetter.sessionStavka().sacuvajStavku(s);
				
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 17;
		add(btnNewButton, gbc_btnNewButton);
		
	}

}
