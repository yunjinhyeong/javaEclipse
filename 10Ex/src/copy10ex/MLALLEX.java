package copy10ex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MLALLEX extends JFrame{
	private JLabel la = new JLabel("dsdf");
	
	public MLALLEX() {
		setTitle("too long");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		Mama ma = new Mama();
		c.addMouseListener(ma);
		c.addMouseMotionListener(ma);
		
		c.add(la);
		
		setSize(300,200);
		setVisible(true);
	}
	
	class Mama implements MouseListener,MouseMotionListener{

		@Override
		public void mouseDragged(MouseEvent e) {
			la.setText(e.getX()+","+e.getY());
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			la.setText(e.getX()+","+e.getY());
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			Component c = (Component)e.getSource();
			c.setBackground(Color.darkGray);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			Component c = (Component)e.getSource();
			c.setBackground(Color.CYAN);
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			la.setText(e.getX()+","+e.getY());
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			la.setText(e.getX()+","+e.getY());
			
		}
		
	}
	public static void main(String[] args) {
		new MLALLEX();

	}

}
