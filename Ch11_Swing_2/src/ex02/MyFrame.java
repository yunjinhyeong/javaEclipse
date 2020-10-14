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
		setTitle("레이블 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		//1.JLabel 생성자 매개변수로 -> String
		JLabel textLabel = new JLabel("사랑합니다.");

//		ImageIcon beauty = new ImageIcon("images/beauty.jpg"); 
//		//2.JLabel 생성자 매개변수로 -> 객체 ImageIcon
//		JLabel imageLabel = new JLabel(beauty);
		
		//2.JLabel 생성자 매개변수로 -> 객체 ImageIcon
		JLabel imageLabel = new JLabel(new ImageIcon("images/beauty.jpg"));

		//폴더 접근 기호
		//부모(한단계 앞) -> ../ 
		//자신 -> ./ or / -> 이거는 생략가능
		ImageIcon normalIcon = new ImageIcon("images/normalIcon.gif"); 
		JLabel label = new JLabel("전화!",normalIcon, SwingConstants.CENTER);

		c.add(textLabel);
		c.add(imageLabel);
		c.add(label);

		setSize(400,600);
		setVisible(true);
	}


}
