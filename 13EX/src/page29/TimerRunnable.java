package page29;

import javax.swing.JLabel;

public class TimerRunnable implements Runnable {
	private JLabel timerLabel;

	public TimerRunnable(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}

	@Override
	public void run() {
		int n = 0;
		while(true) {
			timerLabel.setText(Integer.toString(n));
			n++;
			try {
				Thread.sleep(100); // 1�� ���� ���� �ܴ�.
			} catch(InterruptedException e) {
				return; // ���ܰ� �߻��ϸ� ������ ����
			}
		}		
	}	
}
