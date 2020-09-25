import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import java.awt.Color;

public class TestFrame extends JFrame {

	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private JTextField tf1;//�̸�
	private JTextField tf2;//Ű
	private JTextField tf3;//ü��
	
	JTextArea ta1;//���� ���
	JTextArea ta2;//�Ʒ��� ���
//	
	JLabel lblColor;//���� ���

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFrame frame = new TestFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 413, 362);
		getContentPane().setLayout(null);
		
		lblColor = new JLabel("");
		lblColor.setForeground(new Color(218, 112, 214));
		lblColor.setBackground(Color.BLACK);
		lblColor.setBounds(301, 158, 71, 55);
		lblColor.setOpaque(true);
		getContentPane().add(lblColor);
		getContentPane().setComponentZOrder(lblColor, 0);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Body Max Index", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(25, 22, 208, 277);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\uC131  \uBCC4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(12, 128, 144, 47);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JRadioButton rdo1 = new JRadioButton("\uC5EC\uC790");
		buttonGroup.add(rdo1);
		rdo1.setSelected(true);
		rdo1.setBounds(7, 18, 66, 23);
		panel_1.add(rdo1);
		
		JRadioButton rdo2 = new JRadioButton("\uB0A8\uC790");
		buttonGroup.add(rdo2);
		rdo2.setBounds(77, 18, 57, 23);
		panel_1.add(rdo2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\uC2B5 \uAD00", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(12, 203, 184, 52);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JCheckBox chk1 = new JCheckBox("\uC74C\uC8FC");
		chk1.setBounds(8, 19, 58, 23);
		panel_2.add(chk1);
		
		JCheckBox chk2 = new JCheckBox("\uB2F4\uBC30");
		chk2.setBounds(65, 19, 58, 23);
		panel_2.add(chk2);
		
		JCheckBox chk3 = new JCheckBox("\uC6B4\uB3D9");
		chk3.setBounds(119, 19, 57, 23);
		panel_2.add(chk3);
		
		JLabel lblNewLabel = new JLabel("\uC774   \uB984 :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(12, 37, 57, 15);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("\uD0A4    :");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(12, 62, 57, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\uCCB4   \uC911 :");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(12, 87, 57, 15);
		panel.add(label_1);
		
		tf1 = new JTextField();
		tf1.setText("\uD64D\uAE38\uB3D9");
		tf1.setBounds(75, 34, 71, 21);
		panel.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setText("172");
		tf2.setColumns(10);
		tf2.setBounds(75, 59, 71, 21);
		panel.add(tf2);
		
		tf3 = new JTextField();
		tf3.setText("75");
		tf3.setColumns(10);
		tf3.setBounds(75, 84, 71, 21);
		panel.add(tf3);
		
		JLabel lblcm = new JLabel("(cm)");
		lblcm.setBounds(155, 37, 28, 15);
		panel.add(lblcm);
		
		JLabel lblkg = new JLabel("(kg)");
		lblkg.setBounds(155, 62, 28, 15);
		panel.add(lblkg);
		
//		setComponentZOrder(lblColor, -1);
		
		JButton btn1 = new JButton("\uC2E0\uCCB4 \uC0C1\uD0DC \uCE21\uC815");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String name="";// �̸� (�տ� ���� or �Ƹ��ٿ�) 
				
				double bmi1=0;//bmi ��ġ - ��: 27.4
				String bmi_type="";//bmiŸ�� - ��: �ߵ���, ����.. 
				
				double height=0;//bmi��ġ�� ����ϱ����� "Ű"�� ���� �ӽú���
				double weight=0;//bmi��ġ�� ����ϱ����� "ü��"�� ���� �ӽú���
				
				Color color1;
				
				height = Double.parseDouble(tf2.getText());// String �� Double�� ��ȯ, �������� ���ؼ�
				weight = Double.parseDouble(tf3.getText());// String �� Double�� ��ȯ, �������� ���ؼ�
				
				bmi1 = weight/((height/100)*(height/100));//bmi ��ġ ���
				bmi1 = (int)(bmi1*100)/100.0;
				
				if(rdo1.isSelected())
					name = "�Ƹ��ٿ�" + tf1.getText();
				else if(rdo2.isSelected()) 
					name = "����" + tf1.getText();
				
				if(bmi1 >= 30)
				{
					bmi_type = "����";
					color1 = Color.RED;
				}
				else if(bmi1 >= 25)
				{
					bmi_type = "�ߵ���";
					color1 = Color.RED;
				}
				else if(bmi1 >= 23)
				{
					bmi_type = "��ü��";
					color1 = Color.RED;
				}
				else if(bmi1 >= 18.5)
				{
					bmi_type = "����";
					color1 = Color.GREEN;
				}
				else
				{
					bmi_type = "��ü��";
					color1 = Color.BLUE;
				}	
					
				//1.���� ���
				lblColor.setOpaque(true);
				lblColor.setBackground(color1);
				
				//2.���� ��� ���1 ���
				String result1 = name + "���� \n";
				
				result1 += " ��ü ���� ������: \n";
				result1 += bmi1 + "("+ bmi_type +")" +" �Դϴ�";
				
				ta1.setText(result1);

				
				//3.���� �ϴ� ���2 ���
				String result2="";
				
				if(chk1.isSelected())
					result2 += "�� �׸� ���ſ�!\n";
				
				if(chk2.isSelected())
					result2 += "��� ��������!\n";
				
				if(!chk3.isSelected())
					result2 += "��ϼ���";
				
				ta2.setText(result2);
				
				lblColor.invalidate();
				
				
			}
		});
		
		btn1.setBounds(259, 18, 113, 23);
		getContentPane().add(btn1);
		
		JLabel lblBmi = new JLabel("BMI \uACB0\uACFC");
		lblBmi.setBounds(245, 47, 62, 15);
		getContentPane().add(lblBmi);
		
		JLabel label_2 = new JLabel("\uC18C \uACAC");
		label_2.setBounds(245, 209, 62, 15);
		getContentPane().add(label_2);
		
		ta2 = new JTextArea();
		ta2.setBounds(245, 234, 126, 65);
		getContentPane().add(ta2);
		
		ta1 = new JTextArea();
		ta1.setBackground(Color.WHITE);
		ta1.setBounds(245, 67, 126, 132);
		getContentPane().add(ta1);
		
	}
}
