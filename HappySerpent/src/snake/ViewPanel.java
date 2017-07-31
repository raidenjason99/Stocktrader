package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;


@SuppressWarnings("serial")
public class ViewPanel extends JPanel { ///////////////////////////////////
	
	private Snakey snake;
	private Food food;
	private Poison poison;
	
	private final String SNAKE_BODY = "bodyImage";
	private boolean oneKey;
	private boolean onlyForward;
	private int score;
	private int highScore;
//	
	
	public ViewPanel(KeyListener controlsListener) {
		super();
		this.setOpaque(true);
		
		setBackground(Color.black);
		setFocusable(true);
		
	
		this.snake = new Snakey();
		this.food = new Food();
		this.poison = new Poison();
		makeEdibleList(this.food, this.poison, this.snake);
		
		addKeyListener(controlsListener);
		
		oneKey = true;
		onlyForward = true;
		score = 3;
	}

//	public void listenRightKey(KeyListener adapter) {
//		this.addKeyListener(adapter);
//	}
	
	public void update(){
		repaint();
		oneKey = true;
	}
	
	public void reset(){
//		System.out.println("in view "+this);
		this.snake.reset();
		System.out.println(snake);
		this.food = new Food();
		this.poison = new Poison();
		makeEdibleList(food, poison, snake);
		oneKey = true;
		onlyForward = true;
		score = 3;
		
		update();
	}

	
	@Override
	public void paintComponent(Graphics x) { // paints all the components of the game in the JPanel
		
		super.paintComponent(x);
		x.setColor(Color.white);
		x.clearRect(20, 10, 750, 575);
		x.fillRect(20, 10, 750, 575); // this makes the snake playing area 30 x 23

		

		paintFoodPoison(x, food);
		paintFoodPoison(x, poison);
		paintSnake(x, snake);
		paintScore(x);
		
	}

	
	// This method takes a Food or Poison and paints them in the UI
	private void paintFoodPoison(Graphics p, GameImages images) {
		for (Locus locus : images.getComponentList()) {			
			images.getImage().paintIcon(this, p, (locus.getX() * 25) + 20, (locus.getY() * 25) + 10);
		}
	}
	
	private void paintSnake(Graphics p, Snakey python) {
		boolean head = true;
		System.out.println(python);
		for (Locus locus : python.getComponentList()) {
			if (head){
			python.getSnakeBodyParts().get(python.getChooseHead()).paintIcon(this, p, (locus.getX() * 25) + 20,
					(locus.getY() * 25) + 10);
			head=false;
			}else{
				python.getSnakeBodyParts().get(SNAKE_BODY).paintIcon(this, p, (locus.getX() * 25) + 20,
						(locus.getY() * 25) + 10);
			}
		}
	}
	
	private void paintScore(Graphics p) {
		score = snake.getComponentList().size();
		p.drawString("Score: "+ score, 600, 600);
		p.drawString("High Score: "+ highScore, 600, 615);
		
		
	}
	
	// set the food and poison points
	public void makeEdibleList(GameImages food, GameImages poison, GameImages snake) {
//		System.out.println("5. Food & Poison List");
		@SuppressWarnings("unchecked")
		ArrayList<Locus> tempList = (ArrayList<Locus>) snake.getComponentList().clone();
		System.out.println(snake.getComponentList());
		Random random = new Random();
		GameImages[] items = { food, poison };
		for (GameImages e : items) {
			boolean exitLoop = true;
			while (exitLoop) {
				Locus locus = new Locus(random.nextInt(30), random.nextInt(23));
				if (!tempList.contains(locus)) {
					tempList.add(locus);
					e.addLocus(locus);
				}

				exitLoop = (e.getComponentList().size() == e.getNumber()) ? false : true;
			}
//			 System.out.println(e.getComponentList());
		}
	}
	
	//The methods below are accessors for Food, Snake and Poison,
	public Food getGameFood() {
		return this.food;
	}
	
	public Poison getGamePoison() {
		return this.poison;
	}
	
	public Snakey getGameSnake() {
		return this.snake;
	}
	
	public boolean getOneKey(){
		return this.oneKey;
	}
	
	public void setOneKey(boolean oneKey) {
		this.oneKey = oneKey;
	}
	
	public boolean getOnlyForward(){
		return this.onlyForward;
	}
	
	public void setOnlyForward(boolean forward) {
		this.onlyForward = forward;
	}
	
	
//	private class GameControler extends Thread implements KeyListener{ /////////////////////////////////////////////// KeyListner Class
//		
//	}
	
	
}
