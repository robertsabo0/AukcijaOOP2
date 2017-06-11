package prikazStavke;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.BeansGetter;
import model.PonudaTim2;
import model.StavkaTim2;

public class PanelOpis extends JPanel {
	/**
	 * 
	 */
	private static StavkaTim2 s;
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public PanelOpis(StavkaTim2 s) {
		this.s=s;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Naziv: "+s.getNaziv());
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Opis: "+s.getOpis());
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 3;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Boja: "+s.getBoja());
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 5;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Materijal: "+s.getMaterijal());
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 7;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tip: "+s.getTip());
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 9;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Velicina: "+s.getVelicina());
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 2;
		gbc_lblNewLabel_5.gridy = 11;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Datum postavljanja: "+s.getDatumPostavljanja());
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 2;
		gbc_lblNewLabel_6.gridy = 13;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		if(s.getPostavljenoOdStrane()!=null){
		JLabel lblNewLabel_7 = new JLabel("Postavljeno od strane: "+s.getPostavljenoOdStrane().getUsername());
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 2;
		gbc_lblNewLabel_7.gridy = 15;
		add(lblNewLabel_7, gbc_lblNewLabel_7);
		}
		
		JLabel lblNewLabel_8 = new JLabel("Aktuelna cena: "+s.getAktuelnaCena());
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 2;
		gbc_lblNewLabel_8.gridy = 17;
		add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Postavi cenu:");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 2;
		gbc_lblNewLabel_9.gridy = 19;
		add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		JButton btnNewButton = new JButton("Postavi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double a = Double.parseDouble(textField_1.getText());
				s.setAktuelnaCena(a);
				BeansGetter.sessionStavka().izmeniStavku(s, BeansGetter.sessionStavka().vratiUlogovanog());
				lblNewLabel_8.setText("Aktuelna cena: "+s.getAktuelnaCena());
			}
		});
		
		JButton btnPrihvati = new JButton("Prihvati");
		GridBagConstraints gbc_btnPrihvati = new GridBagConstraints();
		gbc_btnPrihvati.insets = new Insets(0, 0, 0, 5);
		gbc_btnPrihvati.gridx = 2;
		gbc_btnPrihvati.gridy = 21;
		add(btnPrihvati, gbc_btnPrihvati);
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 21;
		add(btnNewButton, gbc_btnNewButton);
		btnNewButton.setEnabled(false);
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int a=0;
				try{
				a=Integer.parseInt(textField_1.getText());
				}catch(Exception ex){
					ex.getMessage();
					textField_1.setText("");
				}
				if(s.getAktuelnaCena()>=a){
					btnNewButton.setEnabled(false);
				}else{
					btnNewButton.setEnabled(true);
				}
			}
		});
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 19;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
			if(s.getPostavljenoOdStrane().getUsername().equals(BeansGetter.sessionStavka().vratiUlogovanog().getUsername()) || s.isProdata() || BeansGetter.sessionStavka().vratiUlogovanog()==null){
				textField_1.setVisible(false);
				lblNewLabel_9.setVisible(false);
				btnNewButton.setVisible(false);
				btnPrihvati.addActionListener(
						e -> {s.setProdata(true);
						BeansGetter.sessionStavka().prodataStavka(s);
						lblNewLabel_8.setText("Proizvod je prodat za: "+s.getAktuelnaCena());
						btnPrihvati.setVisible(false);
				});
			}else{
				textField_1.setVisible(true);
				btnNewButton.setVisible(true);
				lblNewLabel_9.setVisible(true);
				btnPrihvati.setVisible(false);
			}
		
		if(s.isProdata()){
			lblNewLabel_8.setText("Proizvod je prodat za: "+s.getAktuelnaCena());
			btnPrihvati.setVisible(false);
		}
		if(s.getPostavljenoOdStrane().getUsername().equals(BeansGetter.sessionStavka().vratiUlogovanog().getUsername())){
			//PonudaTim2 ponuda=BeansGetter.sessionStavka().getKupac(s);
			//lblNewLabel_8.setText("Proizvod je prodat: "+ponuda.user.getIme()+" "+ponuda.getUser().getPrezime()+"(Username: "+ponuda.getUser().getUsername()+") za: "+s.getAktuelnaCena());
		}
	}
	
}
