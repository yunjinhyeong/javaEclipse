package ex06;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame 
{
	//1.멤버변수
	private JLabel [] keyMessage; 
	
	//3.메소드 - set() 필요없음!, get()
	public JLabel[] getKeyMessage() {
		return keyMessage;
	}

	//2.생성자
	public MyFrame() {
		setTitle("keyListener 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		c.addKeyListener(new MyKeyListener(this));

		keyMessage = new JLabel [3]; 
		keyMessage[0] = new JLabel(" getKeyCode() ");
		keyMessage[1] = new JLabel(" getKeyChar() ");
		keyMessage[2] = new JLabel(" getKeyText() ");

		for(int i=0; i<keyMessage.length; i++) {
			c.add(keyMessage[i]);
			keyMessage[i].setOpaque(true);
			keyMessage[i].setBackground(Color.YELLOW);
		}
		setSize(300,150);
		setVisible(true);

		c.setFocusable(true);
		c.requestFocus();
	}

//	//4.내부 클래스 : 방법2
//	class MyKeyListener extends KeyAdapter 
//	{
//		public void keyPressed(KeyEvent e) 
//		{
//			int keyCode = e.getKeyCode();
//			char keyChar = e.getKeyChar();
//
//			keyMessage[0].setText(Integer.toString(keyCode));
//			keyMessage[1].setText(Character.toString(keyChar));
//			keyMessage[2].setText(e.getKeyText(keyCode));
//		}	
//	}
} 

