package CopyEx0109;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CBIEEx extends JFrame{
	private JCheckBox[] fruits = new JCheckBox[3];
	private String[] names = {"사과","배","체리"};
	private JLabel sumL;
		
	public CBIEEx() {
		setTitle("체크박스예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JLabel("사과 100원, 배 500원, 체리 2억원"));
		
		MIL answer = new MIL(this);
		for( int i=0 ; i<fruits.length ; i++ ) {
			fruits[i] = new JCheckBox(names[i]);
			fruits[i].setBorderPainted(true);
			c.add(fruits[i]);
			fruits[i].addItemListener(answer);
		}
		
		sumL = new JLabel("0");
		c.add(sumL);
		setSize(250,200);
		setVisible(true);
	}
	
	public JCheckBox[] getFruits() {
		return fruits;
	}
	public JLabel getSumL() {
		return sumL;
	}

}
