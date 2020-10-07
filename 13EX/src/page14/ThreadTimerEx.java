package page14;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class ThreadTimerEx extends JFrame{
	public ThreadTimerEx() {
		setTitle("Thread를 상속받은 타이머 스레드 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
	}
	public static void main(String[] args) {
		
	}

}
