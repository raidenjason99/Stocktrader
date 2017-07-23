import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class AppView extends JFrame {
	private GUI gui = new GUI();

	public static final String NEW_GAME = "New Game";
	public static final String MULTIPLAY = "Connect to Others";
	public static final String ADVANCED_GAME = "Advanced Game";

	public AppView(ActionListener listener) {
		super("Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setBounds(10, 10, 905, 725);
		this.setBackground(Color.DARK_GRAY);
		this.setResizable(false);

		this.makeMenu(listener);

		this.add(this.gui);	// shows Game UI

	}

	private void makeMenu(ActionListener listener) {
		JMenuBar menuBar = new JMenuBar();

		JMenu newGameItem = new JMenu(NEW_GAME);
		newGameItem.setActionCommand(AppView.NEW_GAME);
		newGameItem.addActionListener(listener);
		menuBar.add(newGameItem);

		JMenu multiplayItem = new JMenu(MULTIPLAY);
		multiplayItem.setActionCommand(AppView.MULTIPLAY);
		multiplayItem.addActionListener(listener);
		menuBar.add(multiplayItem);

		JMenu advancedGameItem = new JMenu(ADVANCED_GAME);
		advancedGameItem.setActionCommand(AppView.ADVANCED_GAME);
		advancedGameItem.addActionListener(listener);
		menuBar.add(advancedGameItem);

		this.setJMenuBar(menuBar);
	}
}
