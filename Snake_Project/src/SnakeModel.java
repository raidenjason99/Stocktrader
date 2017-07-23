import java.awt.geom.Point2D;
import java.util.ArrayList;

import org.omg.CORBA.PUBLIC_MEMBER;

public class SnakeModel {
	private static int currentScore = 0;
	private static int highScore = 0;
	
	private static int snakeLength = 3;
	private static int moves = 0;

	private static int[] snakeX = new int[782];
	private static int[] snakeY = new int[782];
	
	// public class Tuple<Integer, Integer> {
	// public final int x;
	// public final int y;
	//
	// public Tuple(Integer x, Integer y) {
	// this.x = x;
	// this.y = y;
	// }
	//
	// }
	
	public SnakeModel() {
//		if (moves == 0) {
//			snakexlength[2] = 50;
//			snakexlength[1] = 75;
//			snakexlength[0] = 100;
//
//			snakeylength[2] = 100;
//			snakeylength[1] = 100;
//			snakeylength[0] = 100;
//
//		}
	}
	
	public static int getLength() {
		return SnakeModel.snakeLength;
	}
	
	public static int getMoves() {
		return SnakeModel.moves;
	}
	public static int getCurrentScore() {
		return SnakeModel.currentScore;
	}

	public static int getHighScore() {
		return SnakeModel.highScore;
	}
}
