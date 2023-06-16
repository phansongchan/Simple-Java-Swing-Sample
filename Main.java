/*
	Phan Song Chan;
	Last update: June 16th, 2023.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ControlWindow extends JPanel implements ActionListener, KeyListener {
	public static final int M_WIDTH  = 400;
	public static final int M_HEIGHT = 400;
	public static final int M_DELAY  = 1000 / 60;
	
	private Timer m_timer = new Timer(M_DELAY, this);
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("[DELAY OF TIMER] -> " + M_DELAY);		// For testing purpose
		repaint();
	}
	
	@Override 
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
			System.out.println("[KEY PRESSED] -> SPACE");		// For testing purpose
	}
	
	@Override 
	public void keyReleased(KeyEvent e) {}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	
	public ControlWindow() {
		this.setPreferredSize(new Dimension(M_WIDTH, M_HEIGHT));
		this.setFocusable(true);
		this.setDoubleBuffered(true);
		this.setBackground(Color.BLACK);
		this.addKeyListener(this);
		m_timer.start();		// Start the timer here
	}
}

public class Main extends JFrame {
	public Main() {
		super("title");
		this.add(new ControlWindow());
		this.pack();
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Main();
	}
}