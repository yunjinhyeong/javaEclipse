package ex01;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame 
{
	public MyFrame() 
	{
		super("JComponent�� ���� �޼ҵ� ����");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JButton b1 = new JButton("Magenta/Yellow Button");
		JButton b2 = new JButton(" Disabled Button ");
		JButton b3 = new JButton("getX(), getY()");
		
		b1.setBackground(Color.YELLOW); // ���� ����
		b1.setForeground(Color.MAGENTA); // ���ڻ� ����
		
		Font f1 = new Font("Arial", Font.ITALIC, 20);
		b1.setFont(f1); // Arial, 20�ȼ� ��Ʈ ����
		
//		b1.setFont(new Font("Arial", Font.ITALIC, 20)); // Arial, 20�ȼ� ��Ʈ ����
		b2.setEnabled(false); // ��ư ��Ȱ��ȭ
		
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				
//				MyFrame frame = (MyFrame) b.getTopLevelAncestor();	
				MyFrame frame = (MyFrame) MyFrame.this;
				
				frame.setTitle(b.getX() + "," + b.getY()); // Ÿ��Ʋ�� ��ư ��ǥ ���
			}
		});
		
		c.add(b1);
		c.add(b2);
		c.add(b3); // ����Ʈ�ҿ� ��ư ����
		setSize(260, 200);
		setVisible(true);
	}

}
