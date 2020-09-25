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

public class Ex8 extends JFrame{
	
	private boolean isStart = false; // boolean �⺻�� false // �ð� ��ư on off ����
	
	public Ex8() {
		setTitle("�ð�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel clockLable = new JLabel(""); // clockLable �ð� ���̺�
		clockLable.setFont(new Font("Gothic", Font.ITALIC, 80));
		
		Container contenPane = getContentPane();
		contenPane.add(clockLable, BorderLayout.CENTER);
		
		JButton btnStart = new JButton("Start");
		JButton btnStop = new JButton("Stop");
		
		JPanel panel = new JPanel();
		panel.add(btnStart);
		panel.add(btnStop);
		btnStop.setEnabled(false);
		
		// �ð� ����
		btnStart.addActionListener(event ->{
			
			isStart = true;
			
			new Thread(() -> {
				while(isStart) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("a hh:mm:ss.SSS"); // SSS �� �и��ʱ��� ��
					String str = sdf.format(date);
					clockLable.setText(str);
				} // while
			}).start();
			
			btnStart.setEnabled(false); // On ��ư ��Ȱ��ȭ
			btnStop.setEnabled(true); // Off ��ư Ȱ��ȭ
		});		
		//�ð� ����
		btnStop.addActionListener(e ->{
			isStart = false;
			
			btnStart.setEnabled(true); // On ��ư Ȱ��ȭ
			btnStop.setEnabled(false); // Off ��ư ��Ȱ��ȭ
		});		
		
		contenPane.add(panel, BorderLayout.SOUTH); // ��ư ����
		
		setLocationByPlatform(true);
		setSize(700, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex8();
		
		/*
		// run�żҵ� ����

		*/
	} // main
}
