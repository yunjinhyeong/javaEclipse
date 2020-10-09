package page44;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

public class MyLabel extends JLabel {
	int barSize = 0; // ���� ũ��
	int maxBarSize;
	
	MyLabel(int maxBarSize) {
		this.maxBarSize = maxBarSize;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.magenta);
		int width = (int)(((double)(this.getWidth()))
				/maxBarSize*barSize);
		if(width==0) return;
		g.fillRect(0, 0, width, this.getHeight());
	}
	
	synchronized void fill() {
		if(barSize == maxBarSize) {
			try {
				wait(); // �����带 ����
			} catch(InterruptedException e) {return;}
		}
		barSize++;
		repaint(); // �� �ٽ� �׸���
		notify(); // �����带 �����
	}
	synchronized void consume() {
		if(barSize==0) {
			try {
				wait(); // �����带 ����
			} catch (InterruptedException e) {return;}
		}
		barSize--;
		repaint(); // �� �ٽ� �׸���
		notify(); // �����带 �����
	}
}

class ConsumerThread extends Thread {
	MyLabel bar;
	
	ConsumerThread(MyLabel bar) {
		this.bar = bar;
	}
	public void run() {
		while(true) {
			try {
				sleep(200);
				bar.consume();
			} catch(InterruptedException e) {
				return;
			}
		}
	}
}
