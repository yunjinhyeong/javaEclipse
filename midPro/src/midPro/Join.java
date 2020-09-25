package midPro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Join extends JDialog {
	private JTextField tf = new JTextField(10);
	private JButton okBtn = new JButton("OK");
	
	public Join(JFrame frame, String title) {
		super(frame, title);
		setLayout(new FlowLayout());
		add(tf);
		add(okBtn);
		setSize(200,100);
		
		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
}
