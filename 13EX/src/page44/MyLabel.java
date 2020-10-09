package page44;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

public class MyLabel extends JLabel {
	int barSize = 0; // 바의 크기
	int maxBarSize;
	
	MyLabel(int maxBarSize) {
		this.maxBarSize = maxBarSize;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.MAGENTA); // 색 소문자로해봐
		int width = (int)(((double)(this.getWidth()))
				/maxBarSize*barSize);
		if(width==0) return;
		g.fillRect(0, 0, width, this.getHeight());
	}
	
	synchronized void fill() {
		if(barSize == maxBarSize) {
			try {
				wait();
			} catch(InterruptedException e) {return;}
		}
		barSize++;
		repaint(); // 바 다시 그리기
		notify();
	}
	synchronized void consume() {
		if(barSize==0) {
			try {
				wait();
			} catch (InterruptedException e) {return;}
		}
		barSize--;
		repaint(); // 바 다시 그리기
		notify();
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
