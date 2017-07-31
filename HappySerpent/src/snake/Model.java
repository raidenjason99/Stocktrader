package snake;

public class Model {

	public <T> boolean doesOverlap(Snakey snake, T eaten) {
		// cast eaten to Edible
		GameImages eat = (GameImages) eaten;
		for (Locus locus : eat.getComponentList()) {
			if (snake.getComponentList().get(0).equals(locus)) {
//				System.out.println("Food eaten at " + locus);
				if (eat instanceof Food) {
//					System.out.println("Instance of Food!");
					eat.removeLocus(locus);
				}
				return true;
			}
		}

		return false;
	}
	
	
	
	public boolean doesOverlap(Snakey snake){
		for (int i = 1; i < snake.getComponentList().size(); i++) {
			if (snake.getComponentList().get(0).equals(snake.getComponentList().get(i))) {					
				return true;
			}
		}
		return false;
	}

		
	public void snakeMoveGrow(Snakey snake, Locus newHead, boolean foodEaten) {
		snake.addLocusAtIndex(0, newHead);
		if (!foodEaten) {
			snake.removeLastLocus();
		}
	}
	
	public boolean snakeDidCrash(Locus head){			
		return (head.getX()<0 || head.getX()>29 || head.getY()<0 || head.getY()>22)? true : false;
	}
	

	public boolean allFoodEaten(Food food) {			
		return food.getComponentList().size() == 0;
	}


}
