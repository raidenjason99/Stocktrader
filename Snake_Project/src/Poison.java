import java.util.Random;

public class Poison extends Food {
	
	public Poison() {
		while((Food.x == Poison.x) || (Food.y == Poison.y)) {
		random = new Random();
		xPosition = random.nextInt(34);
		yPosition = random.nextInt(23);
		}
		
		Poison.x = xZone[xPosition];
		Poison.y = yZone[yPosition];
	}

	public Poison(Poison other) {
		other.x = xZone[xPosition];
		other.y = yZone[yPosition];
	}
	public static int getX() {
		return Poison.x;
	}

	public static int getY() {
		return Poison.y;
	}
}