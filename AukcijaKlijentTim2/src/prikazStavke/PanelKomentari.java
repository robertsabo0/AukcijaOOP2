package prikazStavke;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.List;

import javax.naming.NamingException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.BeansGetter;
import model.KomentarTim2;

public class PanelKomentari extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelKomentari() {
		setBorder(BorderFactory.createLineBorder(Color.black));
		List<KomentarTim2> kom=null;
		/*try {
			kom=BeansGetter.sessionStavka().getSve();
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
		}*/
	}

}
