package ex04;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class MyFrame extends JFrame 
{
	public MyFrame() {
		setTitle("체크박스 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		ImageIcon cherryIcon = new ImageIcon("images/cherry.jpg"); 			
		ImageIcon selectedCherryIcon = new ImageIcon("images/selectedCherry.jpg");

		JCheckBox chkApple = new JCheckBox("사과");
		JCheckBox chkPear = new JCheckBox("배", true);
		JCheckBox chkCherry = new JCheckBox("체리", cherryIcon);
				
		//이런 메소드를을 알아야 잘 구현한다... 찾는 법?
		chkCherry.setBorderPainted(true);
		chkCherry.setSelectedIcon(selectedCherryIcon);

		c.add(chkApple);
		c.add(chkPear);
		c.add(chkCherry);

		setSize(300,200);
		setVisible(true);
	}


}
