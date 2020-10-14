package CopyEx0109;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CBEx extends JFrame {
	public CBEx() {
		super("슈퍼");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		ImageIcon cherry = new ImageIcon("images/cherry.jpg");
		ImageIcon selectCherry = new ImageIcon("images/selectedCherry.jpg");
		
		JCheckBox meat = new JCheckBox("고기");
		JCheckBox vegetable = new JCheckBox("야채",true);
		JCheckBox JJogari = new JCheckBox("..", cherry);
		JJogari.setBorderPainted(true);
		JJogari.setSelectedIcon(selectCherry);
		JJogari.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JCheckBox jb = (JCheckBox)e.getSource();
				CBEx TitleName = (CBEx)jb.getTopLevelAncestor();
				TitleName.setTitle(jb.getX()+","+jb.getY());
			}
		});
		
		c.add(meat);
		c.add(vegetable);
		c.add(JJogari);
		
		setSize(250, 150);
		setVisible(true);
	}
	public static void main(String[] args) {
		new CBEx();
	}

}
