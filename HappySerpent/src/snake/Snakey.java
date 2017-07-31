package snake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

public class Snakey extends GameImages { ////////////////////////////////////////////////////////////// Snakey

	// inderited ArrayList<Locus> componentList

	private ImageIcon upHead;
	private ImageIcon downHead;
	private ImageIcon rightHead;
	private ImageIcon leftHead;
	private ImageIcon bodyImage;
	
	Map<String, ImageIcon> snakeBodyParts;
	private String chooseHead;

	public Snakey() {// initial location of the snake
		super(new ArrayList<Locus>(Arrays.asList(new Locus(2, 0), new Locus(1, 0), new Locus(0, 0))));
		
//		System.out.println("2. Snakey"+this);
		
		upHead = new ImageIcon("upHead.png");
		downHead = new ImageIcon("downHead.png");
		rightHead = new ImageIcon("rightHead.png");
		leftHead = new ImageIcon("leftHead.png");
		bodyImage = new ImageIcon("body.png");
		
		snakeBodyParts = new HashMap<>();
		snakeBodyParts.put("upHead", upHead);
		snakeBodyParts.put("downHead", downHead);
		snakeBodyParts.put("leftHead", leftHead);
		snakeBodyParts.put("rightHead", rightHead);
		snakeBodyParts.put("bodyImage", bodyImage);
		
		chooseHead = "rightHead";
	
	}
	
	public void reset() {
		setComponentList(new ArrayList<Locus>(Arrays.asList(new Locus(2, 0), new Locus(1, 0), new Locus(0, 0))));
		chooseHead = "rightHead";
	}
	
	
	public Map<String, ImageIcon> getSnakeBodyParts() {
		return snakeBodyParts;
	}
	
	public void setChooseHead(String chooseHead) {
		this.chooseHead = chooseHead;
	}
	
	public String getChooseHead() {
		return chooseHead;
	}
	

	@Override
	public ImageIcon getImage() {
		return null;
	}
}
