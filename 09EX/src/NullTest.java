import javax.swing.*;
import javax.tools.DocumentationTool.Location;

import java.awt.*;

public class NullTest extends JFrame{
	public NullTest() {
		setTitle("¸ÖºÁ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(null);
		
		JLabel l = new JLabel("hello geFul");
		l.setLocation(200, 100);
		l.setSize(50,50);
		c.add(l);
		
		for( int i=1 ; i<=9 ; i++ ) {
			JButton b = new JButton(" ");
			b.setLocation(200,20*i);
			b.setSize(30,30);
			c.add(b);			
		}
		for( int i=1 ; i<=18 ; i++ ) {
			JButton b = new JButton(" ");
			b.setLocation(20*i,180);
			b.setSize(30,30);
			c.add(b);			
		}
		
		for( int i=1 ; i<=9 ; i++ ) {
			JButton b = new JButton(" ");
			b.setLocation(600,60*i);
			b.setSize(80,80);
			c.add(b);			
		}
		for( int i=1 ; i<=18 ; i++ ) {
			JButton b = new JButton(" ");
			b.setLocation(60*i,540);
			b.setSize(80,80);
			c.add(b);			
		}
		
		
		
		setSize(2000,2000);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new NullTest();
	}

}
