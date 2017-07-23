import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import org.omg.CORBA.PRIVATE_MEMBER;

public class SnakeController extends JPanel implements ActionListener, KeyListener {
	private SnakeModel model;
	private AppView view;
	
	private Timer timer;
	private int delay;

	public SnakeController() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(this.delay, this);
		timer.start();
	}
	
	

	public void setModel(SnakeModel model) {
		this.model = model;
	}

	public void setView(AppView view) {
		this.view = view;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
