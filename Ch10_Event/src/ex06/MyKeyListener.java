package ex06;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;

//4.내부 클래스 : 방법2
class MyKeyListener extends KeyAdapter 
{
	//1.멤버변수 - 배열!

	//문제! 객체 배열을 생성자로 받아서 처리하는게 안됨!
//	private JLabel [] keyMessage; 
//	
//	public MyKeyListener(JLabel[] keyMessage) 
//	{
//		this.keyMessage = keyMessage;
//	}
	
	//1.멤버변수 - 이번엔 객체 -> MyFrame
	
	private MyFrame mf;

	public MyKeyListener(MyFrame mf) 
	{
		this.mf = mf;
	}

	public void keyPressed(KeyEvent e) 
	{
		int keyCode = e.getKeyCode();
		char keyChar = e.getKeyChar();

//		mf.keyMessage[0].setText(Integer.toString(keyCode));
//		mf.keyMessage[1].setText(Character.toString(keyChar));
//		mf.keyMessage[2].setText(e.getKeyText(keyCode));
		
		mf.getKeyMessage()[0].setText(Integer.toString(keyCode));
		mf.getKeyMessage()[1].setText(Character.toString(keyChar));
		mf.getKeyMessage()[2].setText(e.getKeyText(keyCode));
	}	
}
