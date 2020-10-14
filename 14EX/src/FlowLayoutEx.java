import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;

public class FlowLayoutEx extends JFrame{
	public FlowLayoutEx() {
		setTitle("FlowLayout Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));
		c.add(new JButton("add"));
		c.add(new JButton("add"));
		c.add(new JButton("add"));
		c.add(new JButton("add"));
		c.add(new JButton("add"));
		c.add(new JButton("add"));
		
		setSize(500, 500);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new FlowLayoutEx();

	}

}
