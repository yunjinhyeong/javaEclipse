package ex08;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame 
{
//	private final int FLYING_UNIT = 10;
	
//	private JLabel la = new JLabel("HELLO"); 
	private JLabel la;
	
	//2.생성자
	public MyFrame() 
	{
		la = new JLabel("HELLO");
		
		setTitle("상,하,좌,우 키를 이용하여 텍스트 움직이기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		//배치관리자(Layout Manager를 absolute 레이아웃 ==> null
		c.setLayout(null);
		c.addKeyListener(new MyKeyListener(la));

		la.setLocation(50,50);
		la.setSize(100,20);
		c.add(la);
		setSize(300,300);
		setVisible(true);
		c.setFocusable(true);
		c.requestFocus();

		//방법3. 익명 클래스, 익명 객체
		c.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Component com = (Component)e.getSource();
				com.setFocusable(true);
				com.requestFocus();
			}
		});
	}
	
//	//4.내부 클래스 (방법2)
//	class MyKeyListener extends KeyAdapter 
//	{
//		public void keyPressed(KeyEvent e) 
//		{
//			int keyCode = e.getKeyCode();
//
//			switch(keyCode) {
//				case 38: 
//					la.setLocation(la.getX(), la.getY()-FLYING_UNIT);
//					break;
//				case KeyEvent.VK_DOWN: 
//					la.setLocation(la.getX(), la.getY()+FLYING_UNIT); 
//					break;
//				case KeyEvent.VK_LEFT: 
//					la.setLocation(la.getX()-FLYING_UNIT, la.getY()); 
//					break;
//				case KeyEvent.VK_RIGHT: 
//					la.setLocation(la.getX()+FLYING_UNIT, la.getY()); 
//					break;
//			}
//		}
//	}
}

