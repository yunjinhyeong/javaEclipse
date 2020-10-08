package page32;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ThreadFinishFlagEx extends JFrame{
	private RandomThread th; // ������ ���۷���
	
	public ThreadFinishFlagEx() {
		setTitle("ThreadFinishFlagEx ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		
		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				th.finish(); // RandomThread ������ ���� ��
			}
		});
		setSize(300, 200);
		setVisible(true);
		
		th = new RandomThread(c); // ������ ����
		th.start(); // ������ ���۽�Ŵ
	}

	public static void main(String[] args) {
		new ThreadFinishFlagEx();

	}

}
