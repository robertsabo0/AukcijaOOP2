package prikazStavke;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.naming.NamingException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import main.BeansGetter;
import model.KomentarTim2;
import model.StavkaTim2;

public class PanelKomentari extends JPanel  {
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
				KomentarTim2 k=new KomentarTim2();
				k.setSadrzaj(textField.getText());
				k.setStavka(s);
				k.setPostaljeno(new Date());
				try {
					k.setPostaljvenoOdStrane(BeansGetter.sessionStavka().vratiUlogovanog());
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					BeansGetter.sessionStavka().sacuvajKomentar(k);
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		p1.add(btnNewButton);
	}

}
