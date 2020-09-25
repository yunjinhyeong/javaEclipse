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

public class Ex7 extends JFrame{
	
	public Ex7() {
		setTitle("시계");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel clockLable = new JLabel(""); // clockLable 시계 레이블
		clockLable.setFont(new Font("Gothic", Font.ITALIC, 80));
		
		Container contenPane = getContentPane();
		contenPane.add(clockLable, BorderLayout.CENTER);
		
		JButton btnStart = new JButton("Start");
		JButton btnStop = new JButton("Stop");
		
		JPanel panel = new JPanel();
		panel.add(btnStart);
		panel.add(btnStop);
		btnStop.setEnabled(false);
		
		// 시계 구동
		btnStart.addActionListener(event ->{
			
			new Thread(() -> {
				while(true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("a hh:mm:ss");
					String str = sdf.format(date);
					clockLable.setText(str);
				} // while
			}).start();
			
			btnStart.setEnabled(false); // On 버튼 비활성화
			btnStop.setEnabled(true); // Off 버튼 활성화
		});		
		//시계 정지
		btnStop.addActionListener(e ->{
			
			
			btnStart.setEnabled(true); // On 버튼 활성화
			btnStop.setEnabled(false); // Off 버튼 비활성화
		});		
		
		contenPane.add(panel, BorderLayout.SOUTH); // 버튼 부착
		
		setLocationByPlatform(true);
		setSize(550, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex7();
		
		/*
		// run매소드 람다

		*/
	} // main
}
