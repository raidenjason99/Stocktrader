package snake;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel implements ActionListener {/////////////////////////////////////////////// Controller
	ViewPanel viewPanel;
	Model model;
//	int segmentsToGrow;
	
	public int moveX; // used in the action listener to know where the head is initially located and to increase the head by one step forward.
	public int moveY;

	public ControlPanel(ViewPanel panel, Model mod) {
		viewPanel = panel;
		model = mod;		
//		segmentsToGrow = 0;
		System.out.println("control panel called too");
		moveX = viewPanel.getGameSnake().getComponentList().get(0).getX(); // 	the head of the snake and its location
		moveY = viewPanel.getGameSnake().getComponentList().get(0).getY();
		System.out.printf("(%d,%d)",moveX,moveY);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		oneKey = true;
		
//		boolean foodOverlap = model.doesOverlap(viewPanel.getGameSnake(), viewPanel.getGameFood());
//		boolean poisonOverlap = model.doesOverlap(viewPanel.getGameSnake(), viewPanel.getGamePoison());
//		boolean canibalSnake = model.doesOverlap(viewPanel.getGameSnake());
//		boolean allFoodEaten = model.allFoodEaten(viewPanel.getGameFood());
		
//		if(foodOverlap){
//			segmentsToGrow += new Random().nextInt(3)+1;
//			System.out.println("first "+ segmentsToGrow);
//		}
		
		System.out.println(viewPanel.getGameSnake().getChooseHead());
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////
		switch (viewPanel.getGameSnake().getChooseHead()) {
		case "rightHead":
			System.out.println("rightHead");
			moveX += 1;
			break;
		case "leftHead":
			System.out.println("leftHead");
			moveX -= 1;
			break;
		case "upHead":
			System.out.println("upHead");
			moveY-=1;
			break;
		case "downHead":
			System.out.println("downHead");
			moveY+=1;
			break;

		default:
			System.out.println("none of above");
			break;
		}
		
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		Locus newSnakeHead = new Locus(moveX, moveY);
//		boolean snakeCrashed = model.snakeDidCrash(newSnakeHead);
		
//		if (poisonOverlap) {
//			System.out.println("Avoid Poison! Game Over");
//			timer.stop(); // a new thread will be launched that summarizes
//							// the scores.
//			timer.removeActionListener(this);
//		}
//		
//		if (foodOverlap || segmentsToGrow>0) {
//			model.snakeGrow(viewPanel.snake, new Locus(viewPanel.moveX, viewPanel.moveY));
//			System.out.println("Food Eaten");
//			segmentsToGrow--;
//			
//		}
//		
//		if (canibalSnake) {
//			System.out.println("Canibalized self! ");
//			timer.stop();
//			timer.removeActionListener(this);
//		}
		System.out.println(newSnakeHead);
		System.out.println(viewPanel.getGameSnake());
//		model.snakeMove(viewPanel.getGameSnake(), newSnakeHead);
		viewPanel.repaint();
//		
//		if (!snakeCrashed) {
//			viewPanel.repaint();
//		} else {
//			System.out.println("You Crashed, Game Over!");
//			timer.stop();
//			timer.removeActionListener(this);
//		}
//		
//		if(allFoodEaten && segmentsToGrow <= 0){
//			System.out.println(allFoodEaten + "|||" + (segmentsToGrow<=0));
//			timer.stop();
////			timer.removeActionListener(this);
//			System.out.println("You gobbled up everything");
//		}
	}

}
