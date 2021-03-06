package ex03;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import ex02.MyFrame.MyActionListener;

public class MyFrame extends JFrame 
{
	// 1.멤버변수 - 없음!
	// 2.생성자
	public MyFrame() 
	{
		setTitle("Action 이벤트 리스너 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JButton btn = new JButton("Action");

		JButton btn2 = new JButton("Action");
		JButton btn3 = new JButton("Action");

		// 방법1. 객체(객체변수) 안만들고 바로 사용
//		btn.addActionListener(new MyActionListener()); // Action 리스너 달기

		// 방법2. 객체(객체변수) 만든 후 사용
//			MyActionListener lis1 = new MyActionListener();
//			btn.addActionListener(lis1);

//			btn2.addActionListener(lis1);
//			btn3.addActionListener(lis1);
		
		//방법3. 아예 클래스 자체를 만들지 않고, 고로 객체(객체변수) 못 만든다! 
		//이름없는 클래스, 익명 클래스, 익명 객체
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				JButton b = (JButton) e.getSource();
				if (b.getText().equals("Action"))
					b.setText("액션");
				else
					b.setText("Action");
			}
		} );

		c.add(btn);
//			c.add(btn2);
//			c.add(btn3);

		setSize(350, 150);
		setVisible(true);
		
		//인터페이스는 객체를 생성 못 시킨다!
		//ActionListener a1 = new ActionListener();
		//그런데, 예외적으로 "만들면서",동시에 "사용하면" 객체 생성이 가능하다!
		
	}

	// 3.메소드 - 없음

	// 4.내부 클래스 -> MyFrame 클래스의 "멤버"가 된다! MyActionListener 클래스가!
//	public class MyActionListener implements ActionListener 
//	{
//
//		// 인터페이스를 상속 받았기 때문에, 반드시 필수적으로 추상 메소드(abstract method)를
//		// 오버라이딩(재정의) 해줘야만 한다!
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			JButton b = (JButton) e.getSource();
//			if (b.getText().equals("Action"))
//				b.setText("액션");
//			else
//				b.setText("Action");
//
//		}
//	}
}
