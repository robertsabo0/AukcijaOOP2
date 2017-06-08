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

public class PodaciPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public PodaciPanel() throws NamingException {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Naziv:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 1;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Opis:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 3;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 4;
		gbc_textField_1.gridy = 3;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Boja:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 5;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JComboBox<BojaTim2>comboBox = new JComboBox<>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 4;
		gbc_comboBox.gridy = 5;
		java.util.List<BojaTim2> l = BeansGetter.stavkeGetters().getBoje();
		for(BojaTim2 li : l)
			comboBox.addItem(li);
		add(comboBox, gbc_comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Materijal:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 7;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JComboBox<MaterijalTim2> comboBox_1 = new JComboBox<>();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 4;
		gbc_comboBox_1.gridy = 7;
		java.util.List<MaterijalTim2> mat = BeansGetter.stavkeGetters().getMaterijali();
		for(MaterijalTim2 li : mat)
			comboBox_1.addItem(li);
		add(comboBox_1, gbc_comboBox_1);
		
		
		JLabel lblNewLabel_4 = new JLabel("Tip:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 9;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JComboBox<TipTim2> comboBox_2 = new JComboBox<>();
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 4;
		gbc_comboBox_2.gridy = 9;
		java.util.List<TipTim2> tip = BeansGetter.stavkeGetters().getTipovi();
		for(TipTim2 li : tip)
			comboBox_2.addItem(li);
		add(comboBox_2, gbc_comboBox_2);
		
		JLabel lblNewLabel_5 = new JLabel("Velicnia:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 2;
		gbc_lblNewLabel_5.gridy = 11;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JComboBox<VelicinaTim2> comboBox_3 = new JComboBox<>();
		GridBagConstraints gbc_comboBox_3 = new GridBagConstraints();
		gbc_comboBox_3.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_3.gridx = 4;
		gbc_comboBox_3.gridy = 11;
		java.util.List<VelicinaTim2> vel = BeansGetter.stavkeGetters().getVelicine();
		for(VelicinaTim2 li : vel)
			comboBox_3.addItem(li);
		add(comboBox_3, gbc_comboBox_3);
		
		JLabel lblNewLabel_6 = new JLabel("Minimalna cena:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 2;
		gbc_lblNewLabel_6.gridy = 13;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
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
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
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
				s.setOpis(textField_1.getText());
				s.setDatumPostavljanja(new Date());
				s.setAktuelnaCena(Integer.parseInt(textField_2.getText()));
				s.setBoja(comboBox.getPrototypeDisplayValue());
				s.setMaterijal(comboBox_1.getPrototypeDisplayValue());
				s.setTip(comboBox_2.getPrototypeDisplayValue());
				s.setVelicina(comboBox_3.getPrototypeDisplayValue());
				try {
					BeansGetter.sessionStavka().sacuvajStavku(s);
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 17;
		add(btnNewButton, gbc_btnNewButton);
		
	}

}
