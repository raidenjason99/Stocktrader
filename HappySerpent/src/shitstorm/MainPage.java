package shitstorm;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainPage extends JFrame {

	public MainPage() {
		super("Happy Serpent");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);
		setMinimumSize(new Dimension(800, 700));
		setLocation(10, 10);
		setVisible(true);
		
		KeyEar listen = new KeyEar();
		View view = new View(listen);
		listen.setSee(view);
		add(BorderLayout.CENTER, view);
		
		this.pack();
	}

	public static void main(String[] args) {
		new MainPage();
	}
}
