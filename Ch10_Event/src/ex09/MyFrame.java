package ex09;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame {
	
	private JLabel la = new JLabel("No Mouse Event");

	public MyFrame() {
		setTitle("MouseListener와 MouseMotionListener 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

//		MyMouseListener listener = new MyMouseListener();
//		c.addMouseListener(listener);
//		c.addMouseMotionListener(listener);
		
		c.addMouseListener(new MyMouseListener(la));
		c.addMouseMotionListener(new MyMouseListener(la));

		c.add(la);

		setSize(300, 200);
		setVisible(true);
	}
	
//	//4.내부 클래스 - 방법2 , 다중 상속을 하기 때문에 인터페이스를 사용했다.
//	class MyMouseListener implements MouseListener, MouseMotionListener 
//	{
//		//mouse 리스너 1번.
//		public void mousePressed(MouseEvent e) {
//			la.setText("mousePressed (" + e.getX() + ", " + e.getY() + ")");
//		}
//
////		mouse 리스너 2번.
//		public void mouseReleased(MouseEvent e) {
//			la.setText("MouseReleased(" + e.getX() + ", " + e.getY() + ")");
//		}
////		mouse 리스너 3번.
//		public void mouseClicked(MouseEvent e) {
//		}
//
////		mouse 리스너 4번.
//		public void mouseEntered(MouseEvent e) {
//			Component c = (Component) e.getSource();
//			c.setBackground(Color.CYAN);
//		}
//
////		mouse 리스너 5번.
//		public void mouseExited(MouseEvent e) {
//			Component c = (Component) e.getSource();
//			c.setBackground(Color.YELLOW);
//		}
//
//		//motion리스너 1번.
//		public void mouseDragged(MouseEvent e) {
//			la.setText("MouseDragged (" + e.getX() + "," + e.getY() + ")");
//		}
//		//motion리스너 2번.
//		public void mouseMoved(MouseEvent e) {
//			la.setText("MouseMoved (" + e.getX() + "," + e.getY() + ")");
//		}
//	}
}
