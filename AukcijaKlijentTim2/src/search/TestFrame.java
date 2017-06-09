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
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setSize(200, 200);
		f.setContentPane(SearchPanel.showMe(f));
		f.pack();
		f.setVisible(true);
	}
	
}
