import javax.swing.*;
import java.awt.*;

public class borderLayoutTest extends JFrame {
	public borderLayoutTest() {
		setTitle("�����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		GridLayout G = new GridLayout();
		G.setVgap(5);
		G.setHgap(5);
		
		c.setLayout(G);
		
		c.add(new JButton("������"));
		c.add(new JButton("����"));
		c.add(new JButton("��"));
		c.add(new JButton("����"));
		c.add(new JButton("����"));
		
		setSize(400, 300);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new borderLayoutTest();

	}

}
