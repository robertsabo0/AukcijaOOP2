package prikazStavke;

import javax.swing.JFrame;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister.Pack;

import model.StavkaTim2;

public class Test {
	public static void main(String[]args){
		StavkaTim2 s=new StavkaTim2();
		JFrame f=new JFrame();
		GlavniPanel g=new GlavniPanel(s);
		f.add(g);
		f.setSize(400, 400);
		f.setVisible(true);
	}
}
