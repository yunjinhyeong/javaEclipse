import java.awt.*;

import javax.swing.*;

public class BorderLayoutEx extends JFrame {
	public BorderLayoutEx() {
		setTitle("smaple borderlayout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout(30, 20));
		c.add(new JButton("ADDD"), BorderLayout.CENTER);
		c.add(new JButton("BDDF"), BorderLayout.SOUTH);
		c.add(new JButton("CDCD"), BorderLayout.EAST);
		c.add(new JButton("FFFF"), BorderLayout.WEST);
		c.add(new JButton("QQQQ"), BorderLayout.NORTH);
		c.add(new JButton("QQQdsfdsQ"), BorderLayout.NORTH);
		
		setSize(400, 400);
		setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		new BorderLayoutEx();

	}

}
