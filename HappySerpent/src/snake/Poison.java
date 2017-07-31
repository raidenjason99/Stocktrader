package snake;


import javax.swing.ImageIcon;


public class Poison extends GameImages { //////////////////////////////////////////////////////////////// Food Class
	
	private ImageIcon poisonImage;
	private final static int POISON_AMOUNT = 20;

	public Poison() {
		super(POISON_AMOUNT); // 10 poison items
		
//		System.out.println("4. Poison"+this);
		
		poisonImage = new ImageIcon("poison.png");
		
	}

	public ImageIcon getImage() {
		return poisonImage;
	}
}
