package ex04;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class MyFrame extends JFrame 
{
	public MyFrame() {
		setTitle("üũ�ڽ� ����� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		ImageIcon cherryIcon = new ImageIcon("images/cherry.jpg"); 			
		ImageIcon selectedCherryIcon = new ImageIcon("images/selectedCherry.jpg");

		JCheckBox chkApple = new JCheckBox("���");
		JCheckBox chkPear = new JCheckBox("��", true);
		JCheckBox chkCherry = new JCheckBox("ü��", cherryIcon);
				
		//�̷� �޼ҵ带�� �˾ƾ� �� �����Ѵ�... ã�� ��?
		chkCherry.setBorderPainted(true);
		chkCherry.setSelectedIcon(selectedCherryIcon);

		c.add(chkApple);
		c.add(chkPear);
		c.add(chkCherry);

		setSize(300,200);
		setVisible(true);
	}


}
