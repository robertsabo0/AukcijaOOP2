package prikazStavke;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.sun.beans.editors.IntegerEditor;

import model.StavkaTim2;

import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		/*JLabel lblNewLabel_3 = new JLabel("Materijal:"+s.getMaterijal().getOpis());
		lblNewLabel_3.setBounds(35, 141, 206, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tip:"+s.getTip().getOpis());
		lblNewLabel_4.setBounds(35, 181, 206, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Velicina:"+s.getVelicina().getOpis());
		lblNewLabel_5.setBounds(35, 221, 233, 14);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Datum postavljanja:"+s.getDatumPostavljanja());
		lblNewLabel_6.setBounds(35, 261, 317, 14);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Postavljeno od strane:"+s.getPostavljenoOdStrane().getUsername());
		lblNewLabel_7.setBounds(35, 301, 317, 14);
		add(lblNewLabel_7);*/
		
		JLabel lblNewLabel_8 = new JLabel("Aktuelna cena:"+s.getAktuelnaCena());
		lblNewLabel_8.setBounds(35, 341, 233, 14);
		add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Postavi cenu:");
		lblNewLabel_9.setBounds(35, 381, 97, 14);
		add(lblNewLabel_9);
		
		textField = new JTextField();
		textField.setBounds(133, 378, 86, 20);
		add(textField);
		textField.setColumns(10);
		textField.setText("0");
		JButton btnNewButton = new JButton("Postavi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				int a=Integer.parseInt(textField.getText());
				if(s.getAktuelnaCena()>a)
					btnNewButton.setEnabled(true);
			}
		});
		
		
		
		btnNewButton.setBounds(216, 419, 114, 23);
		add(btnNewButton);
		
	}

}
