package ex05;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CBasic extends JFrame {
	private JLabel la = new JLabel("Hello"); 

	public CBasic() {
		setTitle("Mouse �̺�Ʈ ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.addMouseListener(new MyMouseAdapter()); 

		c.setLayout(null);
		la.setSize(50, 20);
		la.setLocation(30, 30);
		c.add(la);

		setSize(250, 250);
		setVisible(true);
	}	
	class MyMouseAdapter extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			la.setLocation(x, y);
		}
		
		//�Ʒ� abstract �޼ҵ���� ���� �����ϴ�! 
		//��Ȯ�ϰԴ� MuouseAdapter���� �޼ҵ�� abstract �޼ҵ尡 �ƴϴ�!
//		public void mouseClicked(MouseEvent arg0) {}
//		public void mouseEntered(MouseEvent arg0) {}
//		public void mouseExited(MouseEvent arg0) {}
//		public void mouseReleased(MouseEvent arg0) {}
	}

	public static void main(String [] args) {
		new CBasic();
	}
} 
