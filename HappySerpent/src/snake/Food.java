package snake;



import javax.swing.ImageIcon;

public class Food extends GameImages { //////////////////////////////////////////////////////////////// Food
					//////////////////////////////////////////////////////////////// Class

	// inderited ArrayList<Locus> componentList
	private ImageIcon foodImage;
	private final static int FOOD_AMOUNT = 2;

	public Food() {
		super(FOOD_AMOUNT); // 10 food items
		
		foodImage = new ImageIcon("food.png");
		
	}

	

	@Override
	public ImageIcon getImage() {
		return foodImage;
	}

}
