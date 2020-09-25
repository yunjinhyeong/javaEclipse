package java0924;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex10 extends JFrame{
	
	private Thread thread;
	
	public Ex10() {
		setTitle("�ð�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel clockLable = new JLabel(""); // clockLable �ð� ���̺�
		clockLable.setFont(new Font("Gothic", Font.ITALIC, 80));
		
		Container contenPane = getContentPane();
		contenPane.add(clockLable, BorderLayout.CENTER);
		
		JButton btnStart = new JButton("Start");
		JButton btnStop = new JButton("Stop");
		btnStop.setEnabled(false);
		
		
		
		// �ð� ����
		btnStart.addActionListener(event ->{
			
			
			thread = new Thread(() -> {
				while(true) {
					if(Thread.interrupted()) {
						break;
						// return;
					}
					Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("a hh:mm:ss.SSS"); // SSS �� �и��ʱ��� ��
					String str = sdf.format(date);
					clockLable.setText(str);
				} // while
				// ���๮���� �ۿ� ����
			});
			
			
			thread.start();
			
			btnStart.setEnabled(false); // On ��ư ��Ȱ��ȭ
			btnStop.setEnabled(true); // Off ��ư Ȱ��ȭ
		});		
		//�ð� ����
		btnStop.addActionListener(e ->{
			// interrupt() ȣ�������� �ش� �������� �۾��ڵ忡 InterruptedException ���ܸ� �߻���Ŵ
			// ���⼭�� sleep() �޼ҵ忡�� �߻���Ŵ
			thread.interrupt(); // thread�� �����ؼ� ������
			
			btnStart.setEnabled(true); // On ��ư Ȱ��ȭ
			btnStop.setEnabled(false); // Off ��ư ��Ȱ��ȭ
		});
		JPanel panel = new JPanel();
		panel.add(btnStart);
		panel.add(btnStop);
		
		contenPane.add(panel, BorderLayout.SOUTH); // ��ư ����
		
		setLocationByPlatform(true);
		setSize(700, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex10();
		
		/*
		// run�żҵ� ����

		*/
	} // main
}
