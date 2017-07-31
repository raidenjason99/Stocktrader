package shitstorm;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyEar extends KeyAdapter{
	
	View see;
	public KeyEar() {
	}
	
	public void setSee(View see) {
		this.see = see;
	}
	
	

	@Override
	public void keyPressed(KeyEvent arg0) {
		see.change= false;
		see.repaint();
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
