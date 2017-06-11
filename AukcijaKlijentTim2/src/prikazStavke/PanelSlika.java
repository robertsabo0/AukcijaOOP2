package prikazStavke;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.StavkaTim2;

public class PanelSlika extends JPanel {
	private StavkaTim2 s;
	/**
	 * Create the panel.
	 */
	public PanelSlika(StavkaTim2 s) {
		this.s=s;
		BufferedImage img=null;
		try {
			if(s.getSlika()!=null)
			img=ImageIO.read(new ByteArrayInputStream(s.getSlika()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(img!=null){
			ImageIcon i=new ImageIcon(img);
			JLabel labela=new JLabel();
			labela.setIcon(i);
			add(labela);
		}
	}

}
