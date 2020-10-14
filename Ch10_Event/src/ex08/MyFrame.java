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
	
	//2.������
	public MyFrame() 
	{
		la = new JLabel("HELLO");
		
		setTitle("��,��,��,�� Ű�� �̿��Ͽ� �ؽ�Ʈ �����̱�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		//��ġ������(Layout Manager�� absolute ���̾ƿ� ==> null
		c.setLayout(null);
		c.addKeyListener(new MyKeyListener(la));

		la.setLocation(50,50);
		la.setSize(100,20);
		c.add(la);
		setSize(300,300);
		setVisible(true);
		c.setFocusable(true);
		c.requestFocus();

		//���3. �͸� Ŭ����, �͸� ��ü
		c.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Component com = (Component)e.getSource();
				com.setFocusable(true);
				com.requestFocus();
			}
		});
	}
	
//	//4.���� Ŭ���� (���2)
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

