package Dashboard;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.el.MethodExpression;
import javax.faces.application.NavigationCase;
import javax.faces.flow.Flow;
import javax.faces.flow.FlowCallNode;
import javax.faces.flow.FlowNode;
import javax.faces.flow.MethodCallNode;
import javax.faces.flow.Parameter;
import javax.faces.flow.ReturnNode;
import javax.faces.flow.SwitchNode;
import javax.faces.flow.ViewNode;
import javax.faces.lifecycle.ClientWindow;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import beans.StavkeGetters;
import main.Aukcija;
import model.StavkaTim2;

public class Dashboard extends JPanel{
	
	 
	 StavkaTim2 s;
	 JButton dugme;
	 StavkeGetters dashStavka;
	 
	private StavkeGetters getDashboardStavka() throws NamingException
	{
		if (dashStavka == null)
		{
			InitialContext ctx = new InitialContext();
			String name = "ejb:/AukcijaServerTim2//StavkeGettersImpl!" + StavkeGetters.class.getName();
			dashStavka = (StavkeGetters) ctx.lookup(name);
		}
		return dashStavka;
	}
	 
	 public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Dashboard s = new Dashboard();
						JFrame f=new JFrame();
						f.add(s);
						System.out.println("Dodaj panel u frejm");
						f.dispose();
						f.setSize(600, 600);
						f.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	 
	 
	 
	 
	 public Dashboard() throws NamingException{
		 this.setLayout(new FlowLayout());
		 List<StavkaTim2> stavke=getDashboardStavka().getSve();
		 JScrollPane skrol=new JScrollPane();
		 for(int i=0;i<stavke.size();i++){
			 JPanel stavka=new JPanel();
			 stavka.setLayout(new BoxLayout(stavka, BoxLayout.Y_AXIS));
			 s=stavke.get(i);
			 JLabel naziv=new JLabel("Naziv: "+s.getNaziv());
			 JLabel cena=new JLabel("Cena: "+s.getAktuelnaCena());
			 JLabel	datum=new JLabel("Datum postavljanja: "+s.getDatumPostavljanja());
			 dugme=new JButton("Prikazi");
			 dugme.addActionListener(new ProsledjivanjeStavke());
			 stavka.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
			 stavka.add(naziv);
			 stavka.add(cena);
			 stavka.add(datum);
			 stavka.add(dugme);
			 add(stavka);
		 }
		// skrol.add(this);
	 }
	 private class ProsledjivanjeStavke implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//GlavniPanel g=new GlavniPanel(s);
			
		}
		 
	 }
}
