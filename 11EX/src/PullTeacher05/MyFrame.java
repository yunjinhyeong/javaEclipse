package PullTeacher05;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame {
	private JCheckBox [] fruits = new JCheckBox [3];
	private String [] names = {"사과", "배", "체리"};
	private JLabel sumLabel;

	public MyFrame() {
		setTitle("체크박스와 ItemEvent 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("사과 100원, 배 500원, 체리 20000원"));

//		MyItemListener listener = new MyItemListener();
		MyItemListener listener = new MyItemListener(this);
		
		for(int i=0; i<fruits.length; i++) {
			fruits[i] = new JCheckBox(names[i]); 
			fruits[i].setBorderPainted(true);
			c.add(fruits[i]);
			
			//체크박스 각각의 객체마다! 리스너를 단다!
			fruits[i].addItemListener(listener);
		}
		sumLabel = new JLabel("현재 0 원 입니다.");
		c.add(sumLabel);
		setSize(250,200);
		setVisible(true);
	}

	//3.메소드 getter, setter 추가
	public JCheckBox[] getFruits() {
		return fruits;
	}
	
	public JLabel getSumLabel()
	{
		return sumLabel; 
	}
	
	
}
