package page32;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class RandomThread extends Thread {
	private Container contentPane;
	private boolean flag=false; // �������� ���� ����� ǥ���ϴ� �÷��� true�� ��������
	public RandomThread(Container contentPane) {
		this.contentPane = contentPane;
	}
	
	void finish() { // ������ ���� ����� flag�� ǥ��
		flag=true;
	}
	
	@Override
	public void run() {
		while(true) {
			int x = ((int)(Math.random()*contentPane.getWidth()));
			int y = ((int)(Math.random()*contentPane.getHeight()));
			JLabel label = new JLabel("Java"); // �� ���̺� ����
			label.setSize(80, 30);
			label.setLocation(x, y);
			contentPane.add(label);
			contentPane.repaint();
//			contentPane.invalidate();
			try {
				Thread.sleep(300); // 0.3�� ���� ���� �ܴ�.
				if(flag == true) {
					contentPane.removeAll();
					label = new JLabel("finish");
					label.setSize(80, 30);
					label.setLocation(100, 100);
					label.setForeground(Color.RED);
					contentPane.add(label);
					contentPane.repaint();
					return; // ������ ����
				}
			} catch(InterruptedException e) {return;}
		}		
	}	
}
