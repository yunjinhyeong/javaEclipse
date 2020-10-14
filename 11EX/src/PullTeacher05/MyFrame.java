package PullTeacher05;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame {
	private JCheckBox [] fruits = new JCheckBox [3];
	private String [] names = {"���", "��", "ü��"};
	private JLabel sumLabel;

	public MyFrame() {
		setTitle("üũ�ڽ��� ItemEvent ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("��� 100��, �� 500��, ü�� 20000��"));

//		MyItemListener listener = new MyItemListener();
		MyItemListener listener = new MyItemListener(this);
		
		for(int i=0; i<fruits.length; i++) {
			fruits[i] = new JCheckBox(names[i]); 
			fruits[i].setBorderPainted(true);
			c.add(fruits[i]);
			
			//üũ�ڽ� ������ ��ü����! �����ʸ� �ܴ�!
			fruits[i].addItemListener(listener);
		}
		sumLabel = new JLabel("���� 0 �� �Դϴ�.");
		c.add(sumLabel);
		setSize(250,200);
		setVisible(true);
	}

	//3.�޼ҵ� getter, setter �߰�
	public JCheckBox[] getFruits() {
		return fruits;
	}
	
	public JLabel getSumLabel()
	{
		return sumLabel; 
	}
	
	
}
