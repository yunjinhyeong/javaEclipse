package CopyEx0109;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;

public class RBEx extends JFrame{
	private JRadioButton[] radio = new JRadioButton[3];
	private String[] text = {"사과", "배", "체리"};
	private ImageIcon[] image = {
			new ImageIcon("images/apple.jpg"),
			new ImageIcon("images/pear.jpg"),
			new ImageIcon("images/cherry.jpg"),
	};
	private JLabel imgL = new JLabel();
	
	public RBEx() {
		setTitle("sdfa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JPanel radioP = new JPanel();
		radioP.setBackground(Color.GRAY);
		ButtonGroup g = new ButtonGroup();
		
		for( int i=0 ; i<radio.length ; i++ ) {
			radio[i] = new JRadioButton(text[i]);
			g.add(radio[i]);
			radioP.add(radio[i]);
			radio[i].addItemListener(new MyListen(this));
		}
		
		radio[2].setSelected(true);
		c.add(radioP, BorderLayout.NORTH);
		c.add(imgL, BorderLayout.CENTER);
		imgL.setHorizontalAlignment(SwingConstants.CENTER);
		setSize(250, 200);
		setVisible(true);
	}
	
	public JRadioButton[] getRadio() {
		return radio;
	}
	
	public JLabel getImgL() {
		return imgL;
	}
	public ImageIcon[] getImg() {
		return image;
	}

}
