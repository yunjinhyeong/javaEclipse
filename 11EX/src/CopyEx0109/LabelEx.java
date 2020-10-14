package CopyEx0109;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LabelEx extends JFrame{
	public LabelEx() {
		super("asdf");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel TL = new JLabel("soo much");
		
		ImageIcon normal = new ImageIcon("images/normalIcon.gif");
		ImageIcon rolloverIcon = new ImageIcon("images/rolloverIcon.gif");
		ImageIcon pressedIcon = new ImageIcon("images/pressedIcon.gif");
		
		ImageIcon beauty = new ImageIcon("images/beauty.jpg");
		JLabel il = new JLabel(beauty);		
		JButton button = new JButton("보고싶으면 콜", normal);
		button.setPressedIcon(pressedIcon);
		button.setRolloverIcon(rolloverIcon);
		
		c.add(TL);
		c.add(il);
		c.add(button);
		
		setSize(400,800);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new LabelEx();
	}

}
