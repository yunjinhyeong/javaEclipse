package ex02;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MyFrame extends JFrame 
{
	public MyFrame() 
	{
		setTitle("���̺� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		//1.JLabel ������ �Ű������� -> String
		JLabel textLabel = new JLabel("����մϴ�.");

//		ImageIcon beauty = new ImageIcon("images/beauty.jpg"); 
//		//2.JLabel ������ �Ű������� -> ��ü ImageIcon
//		JLabel imageLabel = new JLabel(beauty);
		
		//2.JLabel ������ �Ű������� -> ��ü ImageIcon
		JLabel imageLabel = new JLabel(new ImageIcon("images/beauty.jpg"));

		//���� ���� ��ȣ
		//�θ�(�Ѵܰ� ��) -> ../ 
		//�ڽ� -> ./ or / -> �̰Ŵ� ��������
		ImageIcon normalIcon = new ImageIcon("images/normalIcon.gif"); 
		JLabel label = new JLabel("��ȭ!",normalIcon, SwingConstants.CENTER);

		c.add(textLabel);
		c.add(imageLabel);
		c.add(label);

		setSize(400,600);
		setVisible(true);
	}


}
