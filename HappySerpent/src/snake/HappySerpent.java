package snake;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class HappySerpent extends JFrame {

	private ViewPanel viewPanel;
	private ListenKeys keyListner;
	private Model model;
	private ControlPanel2 controlPanel2;
	
	private static final String START_COMMAND = "START";
	private static final String PAUSE_COMMAND = "PAUSE";
	private static final String RESTART_COMMAND = "RESTART";
	
	/////////////////////////////////////////////////// Constructor
	public HappySerpent() {
		super("Happy Serpent");
		setLayout(new BorderLayout());
		
		keyListner = new ListenKeys();
		ButtonAction buttonAction = new ButtonAction();
		viewPanel = new ViewPanel(keyListner);
		keyListner.setViewPanel(viewPanel);
		model = new Model();		
		controlPanel2 = new ControlPanel2(viewPanel, model);
		
		setUI(buttonAction,keyListner);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setMinimumSize(new Dimension(800, 700));
		setLocation(10, 10);
		setVisible(true);
		setFocusable(false);
		
		
		
		this.pack();
		controlPanel2.start();
		keyListner.start();
	}
	////////////////////////////////////////////////// Methods
	
	
	
	public  void reset(){

		viewPanel.reset();
		controlPanel2.reset();

	}
	
	
	private void setUI(ActionListener listener, KeyListener keyListener){
		this.add(BorderLayout.CENTER, viewPanel);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(Color.YELLOW);
		bottomPanel.setLayout(new FlowLayout());
		
		JButton start = new JButton("Start");
		start.setActionCommand(START_COMMAND);
		start.addActionListener(listener);
		start.addKeyListener(keyListener);
		bottomPanel.add(start);
		
		JButton pause = new JButton("Pause");
		pause.setActionCommand(PAUSE_COMMAND);
		pause.addActionListener(listener);
		pause.addKeyListener(keyListener);

		bottomPanel.add(pause);
		
		JButton restart = new JButton("Play Again");
		restart.setActionCommand(RESTART_COMMAND);
		restart.addActionListener(listener);
		restart.addKeyListener(keyListener);

		bottomPanel.add(restart);
		
		this.add(BorderLayout.SOUTH, bottomPanel);
	}
	
	private class ButtonAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			String command = event.getActionCommand();

			if (command.equals(HappySerpent.START_COMMAND) && !ControlPanel2.getStart()) {
				ControlPanel2.startIt();
			} else if (command.equals(HappySerpent.PAUSE_COMMAND) && ControlPanel2.getStart()) {
				ControlPanel2.pauseIt();
			} else if (command.equals(HappySerpent.RESTART_COMMAND)){
				reset();
			}
		}

	}

	/////////////////////////////////////////////////
	public static void main(String[] args) {
		new HappySerpent();
//		JFrame stupid = new JFrame("Aghh");
		
	}
}
