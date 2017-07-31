package shitstorm;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class View extends JPanel {

	boolean change = true;

	public View(KeyEar listen) {
		setBackground(Color.black);
		setFocusable(true);

		addKeyListener(listen);
	}

	public void draw(Graphics x) {
		Color color = (change) ? Color.green : Color.BLUE;
		x.setColor(color);
		x.fillRect(4, 9, 100, 100);
	}

	@Override
	public void paint(Graphics g) {

		super.paint(g);
		draw(g);
	}
}
