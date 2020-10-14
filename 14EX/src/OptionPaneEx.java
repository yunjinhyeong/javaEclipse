import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class OptionPaneEx extends JFrame{
	public OptionPaneEx() {
		setTitle("�ɼ� �� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		setSize(500, 200);
		c.add(new MyPanel(), BorderLayout.SOUTH);
		setVisible(true);
	}
	
	class MyPanel extends Panel {
		private JButton inputBtn = new JButton("input Name");
		private JTextField tf = new JTextField(10);
		private JButton confirmBtn = new JButton("Confirm");
		private JButton messageBtn  = new JButton("Message");
		
		public MyPanel() {
			setBackground(Color.LIGHT_GRAY);
			add(inputBtn);
			add(confirmBtn);
			add(messageBtn);
			add(tf);
			
			inputBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String name =
							JOptionPane.showInputDialog("�̸��� �Է��ϼ���");//�̸��Է��ض�� ��ư�� �޾� �Է¹����� name�� ����
					if(name != null)
						tf.setText(name);//name�� ��������ʴٸ� tf�� ����
				}
			});
			
			confirmBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(null, "����� ���Դϱ�?", "ConfirmȮ��",
							JOptionPane.YES_NO_OPTION);
					if(result == JOptionPane.CLOSED_OPTION)
						tf.setText("Just Closed without Selection");
					else if(result == JOptionPane.YES_OPTION)
						tf.setText("Yes");
					else
						tf.setText("No");					
				}
			});
			
			messageBtn.addActionListener(new ActionListener() {				
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "�����ϼ���", "Message",
							JOptionPane.ERROR_MESSAGE);					
				}
			});
		}
	}
	
		
}
