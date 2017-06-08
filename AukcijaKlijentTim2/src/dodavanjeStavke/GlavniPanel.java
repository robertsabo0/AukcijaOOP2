package dodavanjeStavke;

import java.awt.BorderLayout;
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
	public GlavniPanel() throws NamingException{
		setLayout(new BorderLayout());
		PodaciPanel p=new PodaciPanel();
		add(p, BorderLayout.CENTER);
		

	}
}
