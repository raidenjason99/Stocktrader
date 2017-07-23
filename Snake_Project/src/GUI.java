import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GUI extends JPanel {
	private ImageIcon titleImage;

	private ImageIcon snakeHead;
	private ImageIcon snakeBody;

	private ImageIcon foodImage;
	private ImageIcon poisonImage;

	public GUI() {
		this.setFocusable(true);
	}

	public void paint(Graphics g) {

		titleBorder(g); // draw title image border
		titleImage(g); // draw title image
		gameBorder(g); // draw border for gameplay
		gameBackground(g); // draw background for gameplay
		drawScores(g); // draw scores
		drawSnake(g); // draw snake
		drawFood(g); // draw food
		// drawPoison(g); //draw poison

	}

	private void titleBorder(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawRect(24, 10, 851, 55);
	}

	private void titleImage(Graphics g) {
		titleImage = new ImageIcon("Title.jpg");
		titleImage.paintIcon(this, g, 25, 11);
	}

	public void gameBorder(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawRect(24, 74, 851, 577);
	}

	private void gameBackground(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(25, 75, 850, 575);
	}

	private void drawScores(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.PLAIN, 14));
		g.drawString("Current Score: " + SnakeModel.getCurrentScore(), 730, 55);
		g.setFont(new Font("arial", Font.BOLD, 15));
		g.drawString("HIGH SCORE: " + SnakeModel.getHighScore(), 730, 35);
	}

	private void drawSnake(Graphics g) {

	}

	private void drawFood(Graphics g) {
		Food food = new Food();
		foodImage = new ImageIcon("Food.png");
		foodImage.paintIcon(this, g, Food.getX(), Food.getY());
	}

	private void drawPoison(Graphics g) {
		Poison poison = new Poison();
		poisonImage = new ImageIcon("Poison.png");
		poisonImage.paintIcon(this, g, Poison.getX(), Poison.getY());
	}
}
