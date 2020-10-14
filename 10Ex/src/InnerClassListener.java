

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InnerClassListener extends JFrame {
	public InnerClassListener() {
		setTitle("다시 가즈아");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton jb = new JButton("Action");
		jb.addActionListener(new call());
		c.add(jb);
		
		setSize(350, 250);
		setVisible(true);
	}
	
	private class call implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("Action"))
				b.setText("액션");
			else
				b.setText("Action");
			setTitle(b.getText());
//			InnerClassListener.this.setTitle(b.getText());
		}
		
	}
	public static void main(String[] args) {
		new InnerClassListener();
	}
}

