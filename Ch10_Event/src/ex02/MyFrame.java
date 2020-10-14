package ex02;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import ex01.MyActionListener;

public class MyFrame extends JFrame 
{
	//1.������� - ����!
	//2.������
	public MyFrame() 
	{
		setTitle("Action �̺�Ʈ ������ ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
				
		JButton btn = new JButton("Action");
		
		JButton btn2 = new JButton("Action");
		JButton btn3 = new JButton("Action");

		//���1. ��ü(��ü����) �ȸ���� �ٷ� ���
		btn.addActionListener(new MyActionListener()); // Action ������ �ޱ�
		
		//���2. ��ü(��ü����) ���� �� ���
//		MyActionListener lis1 = new MyActionListener();
//		btn.addActionListener(lis1);
		
//		btn2.addActionListener(lis1);
//		btn3.addActionListener(lis1);
		
		
		c.add(btn);
//		c.add(btn2);
//		c.add(btn3);

		setSize(350, 150);
		setVisible(true);	
	}
	
	//3.�޼ҵ� - ����
	
	//4.���� Ŭ���� -> MyFrame Ŭ������ "���"�� �ȴ�! MyActionListener Ŭ������!
	public class MyActionListener implements ActionListener {

		// �������̽��� ��� �޾ұ� ������, �ݵ�� �ʼ������� �߻� �޼ҵ�(abstract method)��
		// �������̵�(������) ����߸� �Ѵ�!
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			JButton b = (JButton) e.getSource();
			if (b.getText().equals("Action"))
				b.setText("�׼�");
			else
				b.setText("Action");

		}
	}
}
