import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClickAndDoubleClickEx extends JFrame{
	public ClickAndDoubleClickEx() {
		setTitle("dd");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.addMouseListener(new Mymouse());
		setSize(300, 200);
		setVisible(true);
		
	}
	
	class Mymouse extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount()==2) {
				int r = (int)(Math.random()*256);
				int g = (int)(Math.random()*256);
				int b = (int)(Math.random()*256);
				Component c = (Component)e.getSource();
				c.setBackground(new Color(r,g,b));
			}			
		}
	}
	public static void main(String[] args) {
		new ClickAndDoubleClickEx();
	}
}
