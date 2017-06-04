package Stavka;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Test {
	public static void main(String[]args){
		JFrame frame=new JFrame("test");
		frame.setLayout(new BorderLayout());
		GlavniPrikazStavke g=new GlavniPrikazStavke();
		frame.add(g, BorderLayout.CENTER);
		frame.setSize(400, 500);
		frame.setVisible(true);
	}
}
