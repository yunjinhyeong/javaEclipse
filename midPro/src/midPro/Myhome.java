package midPro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Myhome extends JFrame{
	private Join jon;
	public Myhome() {
		super("회원가입 로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btn = new JButton("show");
		
		jon = new Join(this, "Test Dialog");
		btn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				jon.setVisible(true);				
			}
		});
		getContentPane().add(btn);
		setSize(250,200);
		setVisible(true);
	}
		
}
