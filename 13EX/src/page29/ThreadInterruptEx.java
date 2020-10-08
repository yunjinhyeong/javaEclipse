package page29;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThreadInterruptEx extends JFrame {
	private Thread th;
	public ThreadInterruptEx() {
		setTitle("hreadInterruptEx ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		
		TimerRunnable runnable = new TimerRunnable(timerLabel);
		th = new Thread(runnable); // ������ ����
		c.add(timerLabel);
		
		// ��ư�� �����ϰ� Action ������ ���
		JButton btn = new JButton("kill Timer");
		btn.addActionListener((e) -> {			
				th.interrupt(); // Ÿ�̸� ������ ���� ����
				JButton btn1 = (JButton)e.getSource();
				btn1.setEnabled(false); // ��ư ��Ȱ��ȭ
		});
		c.add(btn);
		setSize(300, 170);
		setVisible(true);
		
		th.start(); // ������ ����
	}
	
	public static void main(String[] args) {
		new ThreadInterruptEx();

	}

}
