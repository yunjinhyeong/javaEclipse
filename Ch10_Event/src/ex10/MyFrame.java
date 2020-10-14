package ex10;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class MyFrame extends JFrame 
{
	public MyFrame() {
		setTitle("Click and DoubleClick ¿¹Á¦");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.addMouseListener(new MyMouseListener());
		setSize(300, 200);
		setVisible(true);
	}
}
