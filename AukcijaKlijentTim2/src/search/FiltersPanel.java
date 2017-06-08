package search;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;

import main.BeansGetter;
import model.BojaTim2;
import model.MaterijalTim2;
import model.TipTim2;
import model.VelicinaTim2;

class FiltersPanel extends JPanel {
	
	BojaTim2[] boje;
	VelicinaTim2[] velicine;
	TipTim2[] tipovi;
	MaterijalTim2[] materijali;
	
	JCheckBox[] bojeBoxes;
	JCheckBox[] velicineBoxes;
	JCheckBox[] tipoviBoxes;
	JCheckBox[] materijaliBoxes;
	JCheckBox showSold;
	
	JButton showButton;
	
	JSpinner cenaOd;
	JSpinner cenaDo;
	
	public static void main(String[] args) {
		TestFrame.main(args);
	}
	
	FiltersPanel(){
		List<BojaTim2> bojeList = BeansGetter.stavkeGetters().getBoje();
		List<VelicinaTim2> velicineList= BeansGetter.stavkeGetters().getVelicine();
		List<TipTim2> tipoviList = BeansGetter.stavkeGetters().getTipovi();
		List<MaterijalTim2> materijaliList = BeansGetter.stavkeGetters().getMaterijali();
		
		boje = bojeList.toArray( new BojaTim2[bojeList.size()]);
		velicine = velicineList.toArray( new VelicinaTim2[velicineList.size()]);
		tipovi = tipoviList.toArray( new TipTim2[tipoviList.size()]);
		materijali = materijaliList.toArray( new MaterijalTim2[materijaliList.size()]);
		
		bojeBoxes = new JCheckBox[boje.length];
		velicineBoxes = new JCheckBox[velicine.length];
		tipoviBoxes = new JCheckBox[tipovi.length];
		materijaliBoxes = new JCheckBox[materijali.length];

		initializeBoxes();
		GridLayout gridLayout = new GridLayout(1, 5);
		gridLayout.setHgap(25);
		gridLayout.setVgap(25);
		setLayout(gridLayout);		

		JPanel bojePanel = new JPanel();
		BoxLayout boxLayou = new BoxLayout(bojePanel, BoxLayout.Y_AXIS);
		bojePanel.setLayout(boxLayou); 
		bojePanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		//bojePanel.add(Box.createVerticalStrut(25));
		for(JCheckBox  b : bojeBoxes){
			bojePanel.add(b);
			//bojePanel.add(Box.createVerticalStrut(25));
		}
		bojePanel.add(Box.createVerticalGlue());
		bojePanel.setAlignmentY(JPanel.TOP_ALIGNMENT);
		add(bojePanel);
		
		JPanel velicinePanel = new JPanel();
		boxLayou = new BoxLayout(velicinePanel, BoxLayout.Y_AXIS);
		velicinePanel.setLayout(boxLayou); 
		velicinePanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		//velicinePanel.add(Box.createVerticalStrut(25));
		for(JCheckBox  b : velicineBoxes){
			velicinePanel.add(b);
			//velicinePanel.add(Box.createVerticalStrut(25));
		}
		velicinePanel.setAlignmentY(JPanel.TOP_ALIGNMENT);
		add(velicinePanel);
		
		
		JPanel tipoviPanel = new JPanel();
		boxLayou = new BoxLayout(tipoviPanel, BoxLayout.Y_AXIS);
		tipoviPanel.setLayout(boxLayou); 
		tipoviPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		//tipoviPanel.add(Box.createVerticalStrut(25));
		for(JCheckBox  b : tipoviBoxes){
			tipoviPanel.add(b);
			//tipoviPanel.add(Box.createVerticalStrut(25));
		}
		tipoviPanel.setAlignmentY(JPanel.TOP_ALIGNMENT);
		add(tipoviPanel);
		
		JPanel materijaliPanel = new JPanel();
		boxLayou = new BoxLayout(materijaliPanel, BoxLayout.Y_AXIS);
		materijaliPanel.setLayout(boxLayou); 
		materijaliPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		//materijaliPanel.add(Box.createVerticalStrut(25));
		for(JCheckBox  b : materijaliBoxes){
			materijaliPanel.add(b);
			//materijaliPanel.add(Box.createVerticalStrut(25));
		}
		materijaliPanel.setAlignmentY(JPanel.TOP_ALIGNMENT);
		
		add(materijaliPanel);
		
		
		JPanel ostaloPanel = new JPanel();
		ostaloPanel.setAlignmentY(JPanel.TOP_ALIGNMENT);
		boxLayou = new BoxLayout(ostaloPanel, BoxLayout.Y_AXIS);
		ostaloPanel.setLayout(boxLayou); 
		ostaloPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		ostaloPanel.add(Box.createVerticalGlue());
		
		Box boxOd = new Box(BoxLayout.X_AXIS);
		boxOd.add(new JLabel("Minimalna cena: "));
		boxOd.add(cenaOd);
		ostaloPanel.add(boxOd);
		
		Box boxDo = new Box(BoxLayout.X_AXIS);
		boxDo.add(new JLabel("Maksimalna cena: "));
		boxDo.add(cenaDo);
		ostaloPanel.add(boxDo);
		
		ostaloPanel.add(showSold);
		ostaloPanel.add(showButton);
		
		add(ostaloPanel);
		
	}

	private void initializeBoxes() {
		showSold = new JCheckBox("Prikazi prodate", false);
		
		for(int i = 0 ; i < bojeBoxes.length; i++){
			bojeBoxes[i]= new JCheckBox(boje[i].getOpis(), true);
		}
		for(int i = 0 ; i < velicineBoxes.length; i++){
			velicineBoxes[i]= new JCheckBox(velicine[i].getOpis(), true);
		}
		for(int i = 0 ; i < tipoviBoxes.length; i++){
			tipoviBoxes[i]= new JCheckBox(tipovi[i].getOpis(), true);
		}
		for(int i = 0 ; i < materijaliBoxes.length; i++){
			materijaliBoxes[i]= new JCheckBox(materijali[i].getOpis(), true);
		}
		
		cenaOd = new JSpinner(new SpinnerNumberModel(0, 0, 10_000_000, 1000));
		cenaOd.setPreferredSize(new Dimension(4, 10));
		cenaDo = new JSpinner(new SpinnerNumberModel(10_000_000, 0, 10_000_000, 1000));
		cenaDo.setBounds(new Rectangle(25, 10));
		
		showButton = new JButton("Prikazi");
		showButton.addActionListener(e -> showFiltered());
		
		showFiltered();
	}
	
	public void showFiltered(){
		boolean showProdate = showSold.isSelected();
		
		List<BojaTim2> bojeFilter = new ArrayList<>(boje.length);
		
		for(int i = 0 ; i < bojeBoxes.length; i++){
			if(bojeBoxes[i].isSelected()){
				bojeFilter.add(boje[i]);
			}
		}
		
		List<VelicinaTim2> velicineFilter = new ArrayList<>(velicine.length);
		
		for(int i = 0 ; i < velicineBoxes.length; i++){
			if(velicineBoxes[i].isSelected())
				velicineFilter.add(velicine[i]);
		}
		
		List<TipTim2> tipoviFilter = new ArrayList<>(tipovi.length);
		
		for(int i = 0 ; i < tipoviBoxes.length; i++){
			if(tipoviBoxes[i].isSelected())
				tipoviFilter.add(tipovi[i]);
		}
		
		List<MaterijalTim2> materijaliFilter = new ArrayList<>(materijali.length);
		
		for(int i = 0 ; i < materijaliBoxes.length; i++){
			if(materijaliBoxes[i].isSelected())
				materijaliFilter.add(materijali[i]);
		}
		
		StringBuilder sb = new StringBuilder("Prikazi prodate: "+showProdate);
		sb.append("\n Boje: ");
		bojeFilter.forEach( t -> sb.append(t.getOpis()+" "));
		sb.append("\n Velicine: ");
		velicineFilter.forEach( t -> sb.append(t.getOpis()+" "));
		sb.append("\n Tipovi: ");
		tipoviFilter.forEach( t -> sb.append(t.getOpis()+" "));
		sb.append("\n Materijali: ");
		materijaliFilter.forEach( t -> sb.append(t.getOpis()+" "));
		sb.append("\n Cena od: "+cenaOd.getValue());
		sb.append("\n Ceba do: "+cenaDo.getValue());
		
		JOptionPane.showConfirmDialog(null, sb.toString());
		
		//BeansGetter.stavkeGetters().getStavkaFiltered(bojeFilter, materijaliFilter, velicineFilter, tipoviFilter, (double)cenaOd.getValue(),(double)cenaDo.getValue(), showProdate);
	}
}
