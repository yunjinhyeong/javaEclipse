package ex06;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;

//4.���� Ŭ���� : ���2
class MyKeyListener extends KeyAdapter 
{
	//1.������� - �迭!

	//����! ��ü �迭�� �����ڷ� �޾Ƽ� ó���ϴ°� �ȵ�!
//	private JLabel [] keyMessage; 
//	
//	public MyKeyListener(JLabel[] keyMessage) 
//	{
//		this.keyMessage = keyMessage;
//	}
	
	//1.������� - �̹��� ��ü -> MyFrame
	
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
