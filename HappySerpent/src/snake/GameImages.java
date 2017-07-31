package snake;


import java.util.ArrayList;

import javax.swing.ImageIcon;



public abstract class GameImages{// unnecessary to make it abstract

	private ArrayList<Locus> componentList;
	private int number;
	
	/////////////////////////////////////////// Constructor
	public GameImages(int num) {
		componentList = new ArrayList<>();
		number = num;
	}
	
	public GameImages(ArrayList<Locus> list) {
		componentList = list;
	}
	
	/////////////////////////////////////////// Methods
	
	public void setComponentList(ArrayList<Locus> componentList) {
		this.componentList = componentList;
	}
	
	public ArrayList<Locus> getComponentList() {
		return componentList;
	}
	
	public void addLocusAtIndex(int index, Locus locus) {// used for snake
		this.componentList.add(index,locus);
	}
	
	public void addLocus(Locus locus){ // used for food and poison
		this.componentList.add(locus);
	}
	
	public void removeLastLocus() {			// used for food and poison
		this.componentList.remove(this.componentList.size() - 1);
	}
	
	public void removeLocus(Locus locus) {
		this.componentList.remove(locus);
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public abstract ImageIcon getImage();
	

}
