import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController implements ActionListener {
	private SnakeModel model;
	private AppView view;

	public MenuController() {
		
	}

	public void setModel(SnakeModel model) {
		this.model = model;
	}

	public void setView(AppView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String action = event.getActionCommand();

		if (action.equals(AppView.NEW_GAME)) {

		}

		else if (action.equals(AppView.ADVANCED_GAME)) {

		}

		else if (action.equals(AppView.MULTIPLAY)) {

		}

	}
}
