package prikazStavke;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.StavkaTim2;

import java.awt.Dimension;

import javax.swing.JButton;

public class PanelOpis extends JPanel {
	/**
	 * 
	 */
	private static StavkaTim2 s;
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PanelOpis(StavkaTim2 s) {
		this.s=s;
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Naziv:"+s.getNaziv());
		lblNewLabel.setBounds(35, 21, 131, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Opis:"+s.getOpis());
		lblNewLabel_1.setBounds(35, 61, 184, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Boja:"+s.getBoja());
		lblNewLabel_2.setBounds(35, 101, 143, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Materijal:"+s.getMaterijal().getOpis());
		lblNewLabel_3.setBounds(35, 141, 97, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tip:"+s.getTip().getOpis());
		lblNewLabel_4.setBounds(35, 181, 52, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Velicina:"+s.getVelicina().getOpis());
		lblNewLabel_5.setBounds(35, 221, 114, 14);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Datum postavljanja:"+s.getDatumPostavljanja());
		lblNewLabel_6.setBounds(35, 261, 151, 14);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Postavljeno od strane:"+s.getPostavljenoOdStrane().getUsername());
		lblNewLabel_7.setBounds(35, 301, 151, 14);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Aktuelna cena:"+s.getAktuelnaCena());
		lblNewLabel_8.setBounds(35, 341, 97, 14);
		add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Postavi cenu:");
		lblNewLabel_9.setBounds(35, 381, 97, 14);
		add(lblNewLabel_9);
		
		textField = new JTextField();
		textField.setBounds(133, 378, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Postavi");
		btnNewButton.setBounds(216, 419, 114, 23);
		add(btnNewButton);

	}

}
