package flowPro;
import java.awt.*;
import javax.swing.*;
public class ex5 extends JFrame {//����Ĵ�
	public ex5(){
		JPanel p = new JPanel();
		p.setLayout(null);
		JLabel imgL = new JLabel(new ImageIcon("imgs/gora2.jpeg"));
		add(imgL);		
		imgL.setBounds(0,0,550,500);
		add(p);
		setSize(550, 500);
		setTitle("Ȯ��");
		setVisible(true);
	}
	
}
