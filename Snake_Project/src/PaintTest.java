import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PaintTest extends JPanel {

	private static final long serialVersionUID = 1L;
	boolean blueSqr = false;

	PaintTest() {
		this.setPreferredSize(new Dimension(100, 25));
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				blueSqr = !blueSqr;
				repaint();
			}
		};
		Timer timer = new Timer(1000, al);
		timer.start();
	}

	public void paint(Graphics g) {
		Color c = (blueSqr ? Color.BLUE : Color.RED);
		g.setColor(c);
		g.fillRect(10, 10, 10, 10);
	}

	public static void createWindow(JFrame theWindow) {
		theWindow.pack();
		theWindow.setLocationByPlatform(true);
		theWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theWindow.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame theWindow = new JFrame("Window");
				theWindow.getContentPane().add(new PaintTest());
				createWindow(theWindow);
			}
		});
	}
}