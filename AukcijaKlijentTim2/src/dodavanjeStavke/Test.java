package dodavanjeStavke;

import javax.naming.NamingException;
import javax.swing.JFrame;

public class Test {
	public static void main(String[]args) throws NamingException {
		JFrame f=new JFrame();
		GlavniPanel p=new GlavniPanel();
		f.add(p);
		f.setSize(600, 600);
		f.setVisible(true);
	}
}
