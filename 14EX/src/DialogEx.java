import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class DialogEx extends JFrame {
	private MyDialog dialog;
	public DialogEx() {
		super("DialogEx 예제 프레임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btn = new JButton("show dialog");
		
		dialog = new MyDialog(this,"Test Dialog");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);				
			}
		});
		getContentPane().add(btn);
		setSize(250, 200);
		setVisible(true);
	}
}
