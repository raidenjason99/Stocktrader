import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.sun.xml.internal.messaging.saaj.packaging.mime.Header;

public class Gameplay extends JPanel implements KeyListener, ActionListener {

	
	private static final long serialVersionUID = 1L;
	
	private int[] snakexlength = new int[750]; // the snake is as long as length x width
	private int[] snakeylength = new int[750]; // 

	private boolean up = false; // initially the snake is at rest, so all are false
	private boolean down = false;
	private boolean left = false;
	private boolean right = false;

	private ImageIcon upmouth; // self explanatory
	private ImageIcon downmouth;
	private ImageIcon leftmouth;
	private ImageIcon rightmouth;
	private ImageIcon titleimage;
	private ImageIcon snakeimage; // the menu bar

	private int lengthofsnake = 3; // initial length of the snake when the game starts. 

	private int moves = 0;

	private Timer timer;
	private int delay = 1000; // this is the frame rate for the game

	//all positions on the game field
	private int[] enemyxpos = { 25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, // 34 horizontal indices
			475, 500, 525, 550, 575, 600, 625, 650, 675, 700, 725, 750, 775, 800, 825, 850 };
	private int[] enemyypos = { 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 500, // 23 vertical indices
			525, 550, 575, 600, 625 };

	private ImageIcon enemyimage; // the food image

	private Random random = new Random(); // randomly position the food
	private int xpos = random.nextInt(34); // there are 34 positions horizontally, it generates nums from 0 to 34
	private int ypos = random.nextInt(23); // there are 23 positions vertically, it generates nums from 0 to 23

	private int score = 0; // the number of food pills eaten by the snake

	public Gameplay() {           // constructor
		addKeyListener(this);     // keyListners for the directions
		setFocusable(true);       // it focuses on the window of the game
		setFocusTraversalKeysEnabled(false); // dont know what this does, but it disables tab and shift
		timer = new Timer(delay, this);
		timer.start(); 
	}

	public void paint(Graphics g) { 
		if (moves == 0) {
			snakexlength[2] = 50; // the initial position of the first snake
			snakexlength[1] = 75;
			snakexlength[0] = 100;

			snakeylength[2] = 100;
			snakeylength[1] = 100;
			snakeylength[0] = 100;
		}

		// draw title image border
		g.setColor(Color.WHITE);
		g.drawRect(24, 10, 851, 55); // start from (24,10) and draw a rectangle with length,width of (851,55)

		// draw title image
		titleimage = new ImageIcon("snaketitle.jpg"); // imports the pic
		titleimage.paintIcon(this, g, 25, 11); // it paints the snake title image just one pixle lower than the above rectangle

		// draw border for gameplay
		g.setColor(Color.WHITE);
		g.drawRect(24, 74, 851, 577);

		// draw background for gameplay
		g.setColor(Color.BLACK);
		g.fillRect(25, 75, 850, 575); // draws the game play rectangle fills it in black

		// draw scores
		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.PLAIN, 14));
		g.drawString("Score: " + score, 780, 30);     // it inserts a text at pixle locations (780, 30) 

		// draw length
		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.PLAIN, 14));
		g.drawString("Length: " + lengthofsnake, 780, 50);  // it inserts a text at pixle locations (780, 50) 

		rightmouth = new ImageIcon("rightmouth.png");
		rightmouth.paintIcon(this, g, snakexlength[0], snakeylength[0]);  // it paints an image at the specified coordinate, the snake starts rightward HEAD

		for (int a = 0; a < lengthofsnake; a++) { // this for loop builds the snake head and the body given the initial length 
			if (a == 0 && right) {
				rightmouth = new ImageIcon("rightmouth.png");
				rightmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}

			if (a == 0 && left) {
				leftmouth = new ImageIcon("leftmouth.png");
				leftmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}

			if (a == 0 && up) {
				upmouth = new ImageIcon("upmouth.png");
				upmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}

			if (a == 0 && down) {
				downmouth = new ImageIcon("downmouth.png");
				downmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}

			if (a != 0) {
				snakeimage = new ImageIcon("snakeimage.png");
				snakeimage.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
		}

	//	 generates enemy food
		enemyimage = new ImageIcon("enemy.png");
		enemyimage.paintIcon(this, g, enemyxpos[xpos], enemyypos[ypos]);
		if ((enemyxpos[xpos] == snakexlength[0]) && (enemyypos[ypos] == snakeylength[0])) { // head and food overlap
			score++;
			lengthofsnake++;
			xpos = random.nextInt(34);
			ypos = random.nextInt(23);
		}

		for (int b = 1; b < lengthofsnake; b++){ // it starts from one because the snake head is on the 0 index
			if ((snakexlength[b] == snakexlength[0]) && (snakeylength[b] == snakeylength[0])){ 
				right = false; // iterate through all segments of the snake and if any segment is equal to the head, GAME OVER
				left = false;
				up = false;
				down = false;
				
				g.setColor(Color.white);
				g.setFont(new Font("arial", Font.BOLD, 50)); // snake eats its self
				g.drawString("GAME OVER", 300, 300);

				g.setFont(new Font("arial", Font.BOLD, 20));
				g.drawString("Press SPACE to Restart", 350, 340);
//				g.dispose();
			}
		}
		
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		timer.start();

		if (right) {
			for (int r = lengthofsnake - 1; r >= 0; r--) {
				snakeylength[r + 1] = snakeylength[r];
			}
			for (int r = lengthofsnake; r >= 0; r--) {
				if (r == 0) {
					snakexlength[r] = snakexlength[r] + 25;
				}

				else {
					snakexlength[r] = snakexlength[r - 1];
				}

				if (snakexlength[r] > 850) {
					snakexlength[r] = 25;
				}
			}

			repaint();
		}

		if (left) {
			for (int r = lengthofsnake - 1; r >= 0; r--) {
				snakeylength[r + 1] = snakeylength[r];
			}
			for (int r = lengthofsnake; r >= 0; r--) {
				if (r == 0) {
					snakexlength[r] = snakexlength[r] - 25;
				}

				else {
					snakexlength[r] = snakexlength[r - 1];
				}

				if (snakexlength[r] < 25) {
					snakexlength[r] = 850;
				}
			}

			repaint();
		}

		if (up) {
			for (int r = lengthofsnake - 1; r >= 0; r--) {
				snakexlength[r + 1] = snakexlength[r];
			}
			for (int r = lengthofsnake; r >= 0; r--) {
				if (r == 0) {
					snakeylength[r] = snakeylength[r] - 25;
				}

				else {
					snakeylength[r] = snakeylength[r - 1];
				}

				if (snakeylength[r] < 75) {
					snakeylength[r] = 625;
				}
			}

			repaint();
		}

		if (down) {
			for (int r = lengthofsnake - 1; r >= 0; r--) {
				snakexlength[r + 1] = snakexlength[r];
			}
			for (int r = lengthofsnake; r >= 0; r--) {
				if (r == 0) {
					snakeylength[r] = snakeylength[r] + 25;
				}

				else {
					snakeylength[r] = snakeylength[r - 1];
				}

				if (snakeylength[r] > 625) {
					snakeylength[r] = 75;
				}
			}

			repaint();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			moves = 0;
			score = 0;
			lengthofsnake = 3;
			repaint();
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			moves++;
			right = true;

			if (!left) {
				right = true;
			}

			else {
				right = false;
				left = true;
			}

			up = false;
			down = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			moves++;
			left = true;

			if (!right) {
				left = true;
			}

			else {
				left = false;
				right = true;
			}

			up = false;
			down = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			moves++;
			up = true;

			if (!down) {
				up = true;
			}

			else {
				up = false;
				down = true;
			}

			left = false;
			right = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			moves++;
			down = true;

			if (!up) {
				down = true;
			}

			else {
				down = false;
				up = true;
			}

			left = false;
			right = false;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
	//////////////////////////////////////////////////////
	public static void main(String[] args) {
		JFrame obj = new JFrame();
		Gameplay gameplay = new Gameplay();
		
		obj.setBounds(10, 10, 905, 700);
//		obj.setBackground(Color.DARK_GRAY);
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(gameplay);
	}
}
