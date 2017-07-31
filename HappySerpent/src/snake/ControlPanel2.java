package snake;


import java.util.Random;


public class ControlPanel2 extends Thread {

	private ViewPanel viewPanel;
	private Model model;
		
	private int moveX; // used in the action listener to know where the head is initially located and to increase the head by one step forward.
	private int moveY;
	private final int GAME_FRAME_RATE = 400;
	private static int PAUSE_TIME = 2000;
	
	private boolean foodOverlap;
	private boolean poisonOverlap;
	private boolean canibalSnake;
	private boolean canMove;
	private int segmentsToGrow;
	private static boolean start;
	private static boolean killThread;

	public ControlPanel2(ViewPanel view, Model model) {
		viewPanel = view;
		this.model = model;
		
		moveX = viewPanel.getGameSnake().getComponentList().get(0).getX(); // 	the head of the snake and its location
		moveY = viewPanel.getGameSnake().getComponentList().get(0).getY();
		
		System.out.println("control vals "+ moveX + "  "+moveY);
		
		foodOverlap = false;
		poisonOverlap = false;
		canibalSnake = false;
		canMove = true;
		segmentsToGrow = 0;
		start = false;
		killThread = false;
	}
	
	public static void startIt(){
		ControlPanel2.start = true;
		ControlPanel2.PAUSE_TIME = 2000;
//		System.out.println("Start = "+ ControlPanel2.start);
		
	}
	
	public static void pauseIt(){
		ControlPanel2.start = false;
	}
	
	public static boolean getStart(){
		return ControlPanel2.start;
	}
	
	public void reset(){
		this.moveX = new Snakey().getComponentList().get(0).getX();
		this.moveY = new Snakey().getComponentList().get(0).getY();
		System.out.println("shit storm "+ moveX + "  "+moveY );
	}
	
	@Override
	public void run() {
		System.out.println("stupid shit "+ killThread);
		while (true) {
			if(ControlPanel2.killThread) break;
			System.out.println("I keep running "+killThread);
			while (canMove && !poisonOverlap && !canibalSnake && viewPanel.getOnlyForward() && start) {
				switch (viewPanel.getGameSnake().getChooseHead()) {
				case "rightHead":
					// System.out.println("rightHead");
					moveX += 1;
					break;
				case "leftHead":
					// System.out.println("leftHead");
					moveX -= 1;
					break;
				case "upHead":
					// System.out.println("upHead");
					moveY -= 1;
					break;
				case "downHead":
					// System.out.println("downHead");
					moveY += 1;
					break;

				default:
					System.out.println("none of above");
					break;
				}

				Locus newSnakeHead = new Locus(moveX, moveY);
				boolean growth = foodOverlap || (segmentsToGrow > 0);
				model.snakeMoveGrow(viewPanel.getGameSnake(), newSnakeHead, growth);
				if (segmentsToGrow > 0)
					segmentsToGrow--;
				// -->>
				
				viewPanel.update();

				foodOverlap = model.doesOverlap(viewPanel.getGameSnake(), viewPanel.getGameFood());
				poisonOverlap = model.doesOverlap(viewPanel.getGameSnake(), viewPanel.getGamePoison());
				canibalSnake = model.doesOverlap(viewPanel.getGameSnake());

				if (foodOverlap) {
					segmentsToGrow += new Random().nextInt(3) + 1;
				}
//				System.out.println("seg "+segmentsToGrow);
				
				if(segmentsToGrow<=0 && model.allFoodEaten(viewPanel.getGameFood())){
//					System.out.println("///// inner segments to grow "+ segmentsToGrow+" "+model.allFoodEaten(viewPanel.getGameFood()));
					ControlPanel2.pauseIt();
				}
				
				boolean snakeCrashed = model.snakeDidCrash(newSnakeHead);
				if (snakeCrashed) {
					ControlPanel2.pauseIt();
				}

				try {
					ControlPanel2.sleep(GAME_FRAME_RATE);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				// System.out.printf("%s,%s,%s,%s",
				// foodOverlap,poisonOverlap,canibalSnake,allFoodEaten);
				// System.out.println("Segments to Grow " + segmentsToGrow);
			}
			try {
				Thread.sleep(PAUSE_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}// outer while loop end bracket
		System.out.println("Finall, Im out!");
	}
}
