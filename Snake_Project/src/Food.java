import java.util.Random;

public class Food {
	public static int x, y;

	public Random random = new Random();
	public int xPosition = random.nextInt(34);
	public int yPosition = random.nextInt(23);

	public int[] xZone = { 25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475,
			500, 525, 550, 575, 600, 625, 650, 675, 700, 725, 750, 775, 800, 825, 850 };
	public int[] yZone = { 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 500, 525,
			550, 575, 600, 625 };

	public Food() {
		Food.x = xZone[xPosition];
		Food.y = yZone[yPosition];
	}
	
	public Food(Food other) {
		other.x = xZone[xPosition];
		other.y = yZone[yPosition];
	}

	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public static int getX() {
		return Food.x;
	}

	public static int getY() {
		return Food.y;
	}

}
