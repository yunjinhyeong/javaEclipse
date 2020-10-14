package ex01;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MyFrame extends JFrame 
{
	public MyFrame() 
	{
		setTitle("Action 이벤트 리스너 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
				
		JButton btn = new JButton("Action");
		
		JButton btn2 = new JButton("Action");
		JButton btn3 = new JButton("Action");
		
//		btn.addActionListener(new MyActionListener()); // Action 리스너 달기
		
		MyActionListener lis1 = new MyActionListener();
		btn.addActionListener(lis1);
		
//		btn2.addActionListener(lis1);
//		btn3.addActionListener(lis1);
		
		
		c.add(btn);
//		c.add(btn2);
//		c.add(btn3);

		setSize(350, 150);
		setVisible(true);	
	}
}

