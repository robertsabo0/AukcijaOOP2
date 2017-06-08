package search;

import java.awt.Checkbox;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

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
	
	Checkbox[] bojeBoxes;
	Checkbox[] velicineBoxes;
	Checkbox[] tipoviBoxes;
	Checkbox[] materijaliBoxes;
	Checkbox showSold;
	
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
		
		bojeBoxes = new Checkbox[boje.length];
		velicineBoxes = new Checkbox[velicine.length];
		tipoviBoxes = new Checkbox[tipovi.length];
		materijaliBoxes = new Checkbox[materijali.length];

		initializeBoxes();
		GridLayout gridLayout = new GridLayout(1, 5);
		gridLayout.setHgap(25);
		gridLayout.setVgap(25);
		setLayout(gridLayout);		

		JPanel bojePanel = new JPanel();
		BoxLayout boxLayou = new BoxLayout(null, BoxLayout.Y_AXIS);
		bojePanel.setLayout(boxLayou); 
		bojePanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		//bojePanel.add(Box.createVerticalStrut(25));
		for(Checkbox  b : bojeBoxes){
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
		for(Checkbox  b : velicineBoxes){
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
		for(Checkbox  b : tipoviBoxes){
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
		for(Checkbox  b : materijaliBoxes){
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
		ostaloPanel.add(showSold);
		//ostaloPanel.add(Box.createVerticalStrut(25));
		
		add(ostaloPanel);
		
	}

	private void initializeBoxes() {
		showSold = new Checkbox("Prikazi prodate");
		
		for(int i = 0 ; i < bojeBoxes.length; i++){
			bojeBoxes[i]= new Checkbox(boje[i].getOpis());
		}
		for(int i = 0 ; i < velicineBoxes.length; i++){
			velicineBoxes[i]= new Checkbox(velicine[i].getOpis());
		}
		for(int i = 0 ; i < tipoviBoxes.length; i++){
			tipoviBoxes[i]= new Checkbox(tipovi[i].getOpis());
		}
		for(int i = 0 ; i < materijaliBoxes.length; i++){
			materijaliBoxes[i]= new Checkbox(materijali[i].getOpis());
		}
	}
}
