package copy10ex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KCEx extends JFrame {
	private JLabel la = new JLabel(" ");
	Container c;
	public KCEx() {
		setTitle("sdf");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();
		c.addKeyListener(new MMous());
		c.add(la);
		
		setSize(300,200);
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
	}
	
	class MMous extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			la.setText(e.getKeyText(e.getKeyCode()));
			
			if(e.getKeyChar() == '%')
				c.setBackground(Color.black);
			else if(e.getKeyCode() == KeyEvent.VK_F1)
				c.setBackground(Color.RED);
		}
		
	}
	
	public static void main(String[] args) {
		new KCEx();

	}

}
