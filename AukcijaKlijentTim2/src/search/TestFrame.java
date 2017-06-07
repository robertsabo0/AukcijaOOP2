package search;

import javax.swing.JFrame;

public class TestFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		JFrame f=new TestFrame();
		
		f.setTitle("Aukcija");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(600, 600);
		f.setContentPane(SearchPanel.showMe());
		f.setVisible(true);
	}
	
}
