import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyCodeEx extends JFrame {
	private JLabel la = new JLabel();
	Container c;
	
	public KeyCodeEx() {
		setTitle("gogo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();
		
		c.addKeyListener(new MyKeyListener());
		
		
		la.setLocation(50,50);
		la.setSize(100,20);
		c.add(la);
		setSize(300, 150);
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
	}
	
	class MyKeyListener extends KeyAdapter {
		
		@Override
		public void keyPressed(KeyEvent e) {
			la.setText(e.getKeyText(e.getKeyCode()));
			
			if(e.getKeyChar() == '%')
				c.setBackground(Color.YELLOW);
			else if(e.getKeyCode() == KeyEvent.VK_F1)
				c.setBackground(Color.GREEN);
		}
		
	}
	public static void main(String[] args) {
		new KeyCodeEx();

	}

}
