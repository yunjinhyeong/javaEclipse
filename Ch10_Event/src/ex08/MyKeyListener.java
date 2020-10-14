package ex08;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;

//외부(독립) 클래스 (방법1)
class MyKeyListener extends KeyAdapter 
{
	private final int FLYING_UNIT = 10;
	JLabel la;
	
	public MyKeyListener(JLabel la) 
	{
		this.la = la;
	}

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();

		switch (keyCode) {
		case 38:
			la.setLocation(la.getX(), la.getY() - FLYING_UNIT);
			break;
		case KeyEvent.VK_DOWN:
			la.setLocation(la.getX(), la.getY() + FLYING_UNIT);
			break;
		case KeyEvent.VK_LEFT:
			la.setLocation(la.getX() - FLYING_UNIT, la.getY());
			break;
		case KeyEvent.VK_RIGHT:
			la.setLocation(la.getX() + FLYING_UNIT, la.getY());
			break;
		}
	}
}
