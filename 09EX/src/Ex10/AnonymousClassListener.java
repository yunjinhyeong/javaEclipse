package Ex10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnonymousClassListener extends JFrame {
	public AnonymousClassListener() {
		setTitle("�ٽ�~");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JButton jb = new JButton("Action");
		c.add(jb);
	
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();
				if(b.getText().equals("Action"))
					b.setText("�׼�");
				else
					b.setText("Action");
			
				setTitle(b.getText());
				
			}
		});
		
		
		setSize(350, 150);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new AnonymousClassListener();
	}

}
