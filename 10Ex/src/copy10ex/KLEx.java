package copy10ex;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class KLEx extends JFrame {
	private JLabel KM[];
	
	public KLEx() {
		setTitle("sdf");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.addKeyListener(new KeyMy());
		
		KM = new JLabel[3];
		KM[0] = new JLabel("code");
		KM[1] = new JLabel("char");
		KM[2] = new JLabel("text");
		
		for( int i=0 ; i<KM.length ; i++ ) {
			c.add(KM[i]);
			KM[i].setOpaque(true);
			KM[i].setBackground(Color.CYAN);
		}
		
		setSize(300, 150);
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
	}
	
	class KeyMy extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			int Gcode = e.getKeyCode();
			char Gchar = e.getKeyChar();
			
			KM[0].setText(Integer.toString(Gcode));
			KM[1].setText(Character.toString(Gchar));
			KM[2].setText(e.getKeyText(Gcode));
		}
		
	}
	public static void main(String[] args) {
		new KLEx();

	}

}
