
public class SnakeApp {
	private SnakeApp() {
		
	}
	
	public static void main(String[] args) {
		SnakeModel model = new SnakeModel();
		SnakeController snakecontroller = new SnakeController();
		MenuController menucontroller = new MenuController();
		AppView view = new AppView(menucontroller);
		menucontroller.setModel(model);
		menucontroller.setView(view);
		view.setVisible(true);
	}
}
