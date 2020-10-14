package ex05;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CBasic extends JFrame {
	private JLabel la = new JLabel("Hello"); 

	public CBasic() {
		setTitle("Mouse 이벤트 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.addMouseListener(new MyMouseAdapter()); 

		c.setLayout(null);
		la.setSize(50, 20);
		la.setLocation(30, 30);
		c.add(la);

		setSize(250, 250);
		setVisible(true);
	}	
	class MyMouseAdapter extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			la.setLocation(x, y);
		}
		
		//아래 abstract 메소드들이 생략 가능하다! 
		//정확하게는 MuouseAdapter안의 메소드는 abstract 메소드가 아니다!
//		public void mouseClicked(MouseEvent arg0) {}
//		public void mouseEntered(MouseEvent arg0) {}
//		public void mouseExited(MouseEvent arg0) {}
//		public void mouseReleased(MouseEvent arg0) {}
	}

	public static void main(String [] args) {
		new CBasic();
	}
} 
