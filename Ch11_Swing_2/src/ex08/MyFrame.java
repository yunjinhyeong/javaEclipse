package ex08;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MyFrame extends JFrame 
{
	public MyFrame() 
	{
		setTitle("�ؽ�Ʈ�ʵ� ����� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		c.add(new JLabel("�̸� "));
		c.add(new JTextField(20));
		c.add(new JLabel("�а� "));
		c.add(new JTextField("��ǻ�Ͱ��а� ", 20));
		c.add(new JLabel("�ּ� "));
		c.add(new JTextField("����� ...", 20));

		setSize(300, 150);
		setVisible(true);
	}

}
