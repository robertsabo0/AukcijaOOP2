package prikazStavke;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.Aukcija;
import main.BeansGetter;
import model.KomentarTim2;
import model.StavkaTim2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelKomentari extends JPanel  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PanelKomentari(StavkaTim2 s) {
		setBorder(BorderFactory.createLineBorder(Color.black));
		List<KomentarTim2> kom=null;
		kom=BeansGetter.sessionStavka().getSve(s.getId());
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		for(KomentarTim2 k: kom){
			JPanel p=new JPanel();
			p.setBorder(BorderFactory.createLineBorder(Color.black));
			JLabel postavio=new JLabel(k.getPostaljvenoOdStrane().getUsername());
			JLabel datum= new JLabel(k.getPostaljeno().toString());
			JLabel opis=new JLabel(k.getSadrzaj());
			p.add(postavio);
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
				k.setPostaljvenoOdStrane(BeansGetter.sessionStavka().vratiUlogovanog());
				
				BeansGetter.sessionStavka().sacuvajKomentar(k);
				Aukcija.me.postaviStranicu(new GlavniPanel(s));
			}
		});
		btnNewButton.setEnabled(false);
		p1.add(btnNewButton);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				btnNewButton.setEnabled(true);
			}
		});
		if(s.isProdata())
			p1.setVisible(true);
			if(s.isProdata() || BeansGetter.sessionStavka().vratiUlogovanog()==null){
				p1.setVisible(false);
			}else{
				p1.setVisible(true);
			}
		
	}

}
