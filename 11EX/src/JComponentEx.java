import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JComponentEx extends JFrame{
	public JComponentEx() {
		super("JComponet의 공통 메소드 예제");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JButton b1 = new JButton("Magenta/Yellow Btn");
		JButton b2 = new JButton("Disabled Btn");
		JButton b3 = new JButton("getX(),getY()");
		
		b1.setBackground(Color.YELLOW);
		b1.setForeground(Color.MAGENTA);//글자색 설정
		b1.setFont(new Font("",Font.ITALIC,20));//Arial 20 픽셀 폰트 설정
		b2.setEnabled(false);//버튼 비활성화
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();
				JComponentEx frame = (JComponentEx)b.getTopLevelAncestor();
				frame.setTitle(b.getX()+","+b.getY());//타이틀에 버튼좌표 출력			
			}			
		});
		
		c.add(b1); c.add(b2); c.add(b3);
		setSize(260,200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new JComponentEx();

	}

}
