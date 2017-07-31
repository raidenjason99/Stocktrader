package snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class ListenKeys extends Thread implements KeyListener {//////////////////////////////////////// Key Listener

	ViewPanel viewPanel;
	String tempSnakeHead;
	private static boolean killThread = false;
	
	private final String UP_HEAD = "upHead";
	private final String DOWN_HEAD = "downHead";
	private final String LEFT_HEAD = "leftHead";
	private final String RIGHT_HEAD = "rightHead";
	

	public ListenKeys() {
//		System.out.println("KeyListner Called");
		tempSnakeHead = "rightHead";
	}
	
	public void setViewPanel(ViewPanel viewPanel) {
		this.viewPanel = viewPanel;
	}
	
	
	@Override
	public void run() {
		while(true){
//			System.out.println("I run ");
			viewPanel.getGameSnake().setChooseHead(tempSnakeHead);
		}
	}

		
	@Override
	public void keyPressed(KeyEvent e) {
		
//		start = false;
		if (viewPanel.getOneKey()) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				System.out.println("right");
				// viewPanel.getGameSnake().setChooseHead(RIGHT_HEAD);
				if (!(tempSnakeHead == LEFT_HEAD)){
					tempSnakeHead = RIGHT_HEAD;
				}else{
					viewPanel.setOnlyForward(false);
				}
			}

			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				System.out.println("left");
				// viewPanel.getGameSnake().setChooseHead(LEFT_HEAD);
				if (!(tempSnakeHead == RIGHT_HEAD)){
					tempSnakeHead = LEFT_HEAD;
				}else{
					viewPanel.setOnlyForward(false);
				}

			}

			if (e.getKeyCode() == KeyEvent.VK_UP) {
				System.out.println("up");
				// viewPanel.getGameSnake().setChooseHead(UP_HEAD);
				if (!(tempSnakeHead == DOWN_HEAD)){
					tempSnakeHead = UP_HEAD;
				}else{
					viewPanel.setOnlyForward(false);
				}
			}

			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				System.out.println("down");
				// viewPanel.getGameSnake().setChooseHead(DOWN_HEAD);
				if (!(tempSnakeHead == UP_HEAD)){
					tempSnakeHead = DOWN_HEAD;
				}else{
					viewPanel.setOnlyForward(false);
				}
			}
			
			viewPanel.setOneKey(false);
		}
			
			
//			
//		}
//
//		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
//			System.out.println("Pause");
//			timer.stop();
//		}
//		
//		if(e.getKeyCode()== KeyEvent.VK_HOME){
//			reset();
////			FoodGrowFault.instance.getInstance();
//			System.out.println("resetting");
//		}
//		if(e.getKeyCode()==KeyEvent.VK_PAGE_UP){
//			timer.start();
//		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent event) {
		if (event.getID() == 400) {// SPACE_BAR = 400
			if (ControlPanel2.getStart()) {
				ControlPanel2.pauseIt();
			} else {
				ControlPanel2.startIt();
			}
		}

	}

}
