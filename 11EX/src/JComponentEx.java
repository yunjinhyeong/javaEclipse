import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JComponentEx extends JFrame{
	public JComponentEx() {
		super("JComponet�� ���� �޼ҵ� ����");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JButton b1 = new JButton("Magenta/Yellow Btn");
		JButton b2 = new JButton("Disabled Btn");
		JButton b3 = new JButton("getX(),getY()");
		
		b1.setBackground(Color.YELLOW);
		b1.setForeground(Color.MAGENTA);//���ڻ� ����
		b1.setFont(new Font("",Font.ITALIC,20));//Arial 20 �ȼ� ��Ʈ ����
		b2.setEnabled(false);//��ư ��Ȱ��ȭ
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();
				JComponentEx frame = (JComponentEx)b.getTopLevelAncestor();
				frame.setTitle(b.getX()+","+b.getY());//Ÿ��Ʋ�� ��ư��ǥ ���			
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
