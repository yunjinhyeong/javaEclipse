package ex07;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class MyFrame extends JFrame 
{
	private JRadioButton [] radio = new JRadioButton [3];
	private String [] text = {"사과", "배", "체리"};
//	private ImageIcon [] image = {
//							new ImageIcon("images/apple.jpg"),
//							new ImageIcon("images/pear.jpg"),
//							new ImageIcon("images/cherry.jpg")};
	private JLabel imageLabel = new JLabel();

	public MyFrame() {
		setTitle("라디오버튼 Item Event 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		//화면을 나누기 위해서, JPanel(패널)을 사용
		JPanel radioPanel = new JPanel(); 
		radioPanel.setBackground(Color.GRAY);
		ButtonGroup g = new ButtonGroup(); 

		for(int i=0; i<radio.length; i++) {
			radio[i] = new JRadioButton(text[i]);
			g.add(radio[i]);
			radioPanel.add(radio[i]);
//			radio[i].addItemListener(new MyItemListener());
			radio[i].addItemListener(new MyItemListener(this));
		}
		radio[2].setSelected(true); 
		c.add(radioPanel, BorderLayout.NORTH); 
		c.add(imageLabel, BorderLayout.CENTER);
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER); 
		setSize(250,200);
		setVisible(true);
	}

	//3.메소드 getter, setter 추가
	public JRadioButton[] getRadio() {
		return radio;
	}

	public JLabel getImageLabel() {
		return imageLabel;
	}
}
