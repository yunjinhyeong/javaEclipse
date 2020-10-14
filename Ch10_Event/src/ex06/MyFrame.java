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
	//1.�������
	private JLabel [] keyMessage; 
	
	//3.�޼ҵ� - set() �ʿ����!, get()
	public JLabel[] getKeyMessage() {
		return keyMessage;
	}

	//2.������
	public MyFrame() {
		setTitle("keyListener ����");
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

//	//4.���� Ŭ���� : ���2
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

