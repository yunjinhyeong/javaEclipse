package ex01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

//ActionListener 인터페이스를 상속받아서(구현), MyActionListener 클래스를 만든다!
public class MyActionListener implements ActionListener {

	//인터페이스를 상속 받았기 때문에, 반드시 필수적으로 추상 메소드(abstract method)를
	//오버라이딩(재정의) 해줘야만 한다!
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		JButton b = (JButton) e.getSource();
		if (b.getText().equals("Action"))
			b.setText("액션");
		else
			b.setText("Action");

	}
}
