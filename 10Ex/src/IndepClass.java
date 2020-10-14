

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class IndepClass extends JFrame {
	public IndepClass() {
		setTitle("m.m");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JButton jb = new JButton("Action");
		jb.addActionListener(new myp());
		c.add(jb);
		
		setSize(350, 150);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new IndepClass();
	}
}
class myp implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		if(b.getText().equals("Action"))
			b.setText("¾×¼Ç");
		else
			b.setText("Action");
		
	}

}
