package ex06;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class MyFrame extends JFrame 
{
	public MyFrame() 
	{
		setTitle("������ư ����� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		ImageIcon cherryIcon = new ImageIcon("images/cherry.jpg" );
		ImageIcon selectedCherryIcon = 
									new ImageIcon("images/selectedCherry.jpg"); 
		
		ButtonGroup g = new ButtonGroup();
		JRadioButton apple = new JRadioButton("���");
		JRadioButton pear = new JRadioButton("��", true);
		JRadioButton cherry = new JRadioButton("ü��", cherryIcon);
		cherry.setBorderPainted(true);
		cherry.setSelectedIcon(selectedCherryIcon);

		g.add(apple);
		g.add(pear);
		g.add(cherry);

		c.add(apple);
		c.add(pear);
		c.add(cherry);
		setSize(250,150);
		setVisible(true);
	}


}
