package registracija;

import javax.swing.JFrame;

public class Test {

	public static void main(String[] args) {
		JFrame f=new JFrame();
		Login p=new Login(f);
		f.add(p);
		f.setSize(600, 600);
		f.setVisible(true);
	}

}
