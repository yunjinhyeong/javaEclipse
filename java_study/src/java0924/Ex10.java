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
		setTitle("시계");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel clockLable = new JLabel(""); // clockLable 시계 레이블
		clockLable.setFont(new Font("Gothic", Font.ITALIC, 80));
		
		Container contenPane = getContentPane();
		contenPane.add(clockLable, BorderLayout.CENTER);
		
		JButton btnStart = new JButton("Start");
		JButton btnStop = new JButton("Stop");
		btnStop.setEnabled(false);
		
		
		
		// 시계 구동
		btnStart.addActionListener(event ->{
			
			
			thread = new Thread(() -> {
				while(true) {
					if(Thread.interrupted()) {
						break;
						// return;
					}
					Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("a hh:mm:ss.SSS"); // SSS 는 밀리초까지 셈
					String str = sdf.format(date);
					clockLable.setText(str);
				} // while
				// 실행문들이 밖에 없음
			});
			
			
			thread.start();
			
			btnStart.setEnabled(false); // On 버튼 비활성화
			btnStop.setEnabled(true); // Off 버튼 활성화
		});		
		//시계 정지
		btnStop.addActionListener(e ->{
			// interrupt() 호출했을때 해당 스레드의 작업코드에 InterruptedException 예외를 발생시킴
			// 여기서는 sleep() 메소드에서 발생시킴
			thread.interrupt(); // thread에 접근해서 방해함
			
			btnStart.setEnabled(true); // On 버튼 활성화
			btnStop.setEnabled(false); // Off 버튼 비활성화
		});
		JPanel panel = new JPanel();
		panel.add(btnStart);
		panel.add(btnStop);
		
		contenPane.add(panel, BorderLayout.SOUTH); // 버튼 부착
		
		setLocationByPlatform(true);
		setSize(700, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex10();
		
		/*
		// run매소드 람다

		*/
	} // main
}
