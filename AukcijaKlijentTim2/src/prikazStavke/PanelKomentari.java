package prikazStavke;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.naming.NamingException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.BeansGetter;
import model.KomentarTim2;
import model.StavkaTim2;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelKomentari extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PanelKomentari(StavkaTim2 s) {
		setBorder(BorderFactory.createLineBorder(Color.black));
		List<KomentarTim2> kom=null;
		try {
			kom=BeansGetter.sessionStavka().getSve(s.getId());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		for(KomentarTim2 k: kom){
			JPanel p=new JPanel();
			p.setBorder(BorderFactory.createLineBorder(Color.black));
			//JLabel postavio=new JLabel(k.getPostaljvenoOdStrane().getUsername());
			JLabel datum= new JLabel(k.getPostaljeno().toString());
			JLabel opis=new JLabel(k.getSadrzaj());
			//p.add(postavio);
			p.add(datum);
			p.add(opis);
			this.add(p);
		}
		JPanel p1=new JPanel();
		p1.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(p1);
		
		textField = new JTextField();
		p1.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Dodaj komentar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		p1.add(btnNewButton);
	}

}
