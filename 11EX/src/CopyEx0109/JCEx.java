package CopyEx0109;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JCEx extends JFrame {
	public JCEx() {
		setTitle("..");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton b1 = new JButton("GP");
		JButton b2 = new JButton("unB");
		JButton b3 = new JButton("R");
		
		b1.setBackground(Color.PINK);
		b1.setForeground(Color.GREEN);
		b1.setFont(new Font("",Font.ITALIC, 20));
		b2.setEnabled(false);
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();
				JCEx fr =(JCEx)b.getTopLevelAncestor();
				fr.setTitle(b.getX()+","+b.getY()); //타이틀에 버튼좌표
			}
		});
		c.add(b1);c.add(b2);c.add(b3);
		setSize(300,250);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JCEx();
	}

}
