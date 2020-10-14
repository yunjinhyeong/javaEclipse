package copy10ex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FTextEx extends JFrame {
	private JLabel la = new JLabel("dsfs");
	private final int UNIT = 10;
	public FTextEx() {
		setTitle("sdfa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		c.addKeyListener(new MyKey());
		
		la.setLocation(100,100);
		la.setSize(100,20);
		
		c.add(la);
		
		setSize(300,200);
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
	}
	
	class MyKey extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			int itme = e.getKeyCode();
			
			switch(itme) {
			case KeyEvent.VK_RIGHT:
				la.setLocation(la.getX()+UNIT,la.getY());
				break;
			case KeyEvent.VK_LEFT:
				la.setLocation(la.getX()-UNIT,la.getY());
				break;
			case KeyEvent.VK_UP:
				la.setLocation(la.getX(),la.getY()-UNIT);
				break;
			case KeyEvent.VK_DOWN:
				la.setLocation(la.getX(),la.getY()+UNIT);
				break;
			
			}
		}
		
	}
	public static void main(String[] args) {
		new FTextEx();
	}

}
