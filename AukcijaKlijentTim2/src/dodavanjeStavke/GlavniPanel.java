package dodavanjeStavke;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.BeansGetter;
import model.BojaTim2;
import model.MaterijalTim2;
import model.TipTim2;
import model.VelicinaTim2;

public class GlavniPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Create the panel.
	 * @throws NamingException 
	 */
	public GlavniPanel() throws NamingException {
		setLayout(null);
		JLabel lblNewLabel = new JLabel("Naziv:");
		lblNewLabel.setBounds(110, 40, 46, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Opis:");
		lblNewLabel_1.setBounds(110, 80, 46, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Boja:");
		lblNewLabel_2.setBounds(110, 120, 46, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Materijal:");
		lblNewLabel_3.setBounds(110, 160, 73, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tip:");
		lblNewLabel_4.setBounds(110, 200, 46, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Velicnia:");
		lblNewLabel_5.setBounds(110, 240, 73, 14);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Minimalna cena:");
		lblNewLabel_6.setBounds(110, 280, 109, 14);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Slika:");
		lblNewLabel_7.setBounds(110, 320, 46, 14);
		add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.setBounds(217, 37, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(217, 77, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(217, 277, 86, 20);
		add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(217, 317, 86, 20);
		add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton = new JButton("postavi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(357, 362, 89, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel_8 = new JLabel("Prostor za dodavanje novog proizvoda na aukciju");
		lblNewLabel_8.setBounds(10, 11, 382, 14);
		add(lblNewLabel_8);
		
		JComboBox<String> comboBox = new JComboBox<>();
		java.util.List<BojaTim2> l = BeansGetter.stavkeGetters().getBoje();
		for(BojaTim2 li : l)
			comboBox.addItem(li.getOpis());
		//comboBox.setEditable(true);
		comboBox.setBounds(217, 117, 175, 20);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		java.util.List<MaterijalTim2> mat = BeansGetter.stavkeGetters().getMaterijali();
		for(MaterijalTim2 li : mat)
			comboBox_1.addItem(li.getOpis());
		//comboBox_1.setEditable(true);
		comboBox_1.setBounds(217, 157, 175, 20);
		add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		java.util.List<TipTim2> tip = BeansGetter.stavkeGetters().getTipovi();
		for(TipTim2 li : tip)
			comboBox_2.addItem(li.getOpis());
		comboBox_2.setBounds(217, 197, 175, 20);
		//comboBox_2.setEditable(true);
		add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		java.util.List<VelicinaTim2> vel = BeansGetter.stavkeGetters().getVelicine();
		for(VelicinaTim2 li : vel)
			comboBox_3.addItem(li.getOpis());
		//comboBox_3.setEditable(true);
		comboBox_3.setBounds(217, 237, 175, 20);
		add(comboBox_3);
		

	}
}
