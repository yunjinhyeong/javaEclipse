

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseAdapterEx extends JFrame{
	private JLabel jl = new JLabel("머여이건");
	
	public MouseAdapterEx() {
		setTitle("ㅡ.ㅡ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.addMouseListener(new mus());
		c.setLayout(null);
		
		jl.setSize(70, 20);
		jl.setLocation(30, 30);
		c.add(jl);
		
		setSize(250, 250);
		setVisible(true);
		
		
	}
	
	class mus extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			int x=e.getX();
			int y=e.getY();
			jl.setLocation(x, y);
		}
	}
	
	public static void main(String[] args) {
		new MouseAdapterEx();
	}

}
