import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;

public class BMImeasure extends JFrame{
	private JTextField textN;
	private JTextField textH;
	private JTextField textW;
	private JRadioButton manRadio;
	private JRadioButton womanRadio;
	private ButtonGroup g;
	private JTextArea textResult;
	private JLabel lblColor;
	private JCheckBox chkD;
	private JCheckBox chkS;
	private JCheckBox chkE;
	private JTextArea textSay;
	
	
	public BMImeasure() {
		setTitle("��ü ���� ���� ����(BMI) - ������");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		
		// Body Max Index �ǳ� ����
		
		JPanel panel = new JPanel(); // ��ü �ǳ�
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Body Max index", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(20, 25, 270, 340);
		c.add(panel);
		panel.setLayout(null);
		
		JLabel labelN = new JLabel("��  ��:"); //�̸���
		labelN.setBounds(24, 32, 42, 15);
		panel.add(labelN);
		
		JLabel lblH = new JLabel(" Ű  :");	//Ű��
		lblH.setHorizontalAlignment(SwingConstants.CENTER);
		lblH.setBounds(24, 69, 42, 15);
		panel.add(lblH);
		
		JLabel lblW = new JLabel("ü  ��:");	//ü�߶�
		lblW.setBounds(24, 104, 42, 15);
		panel.add(lblW);
		
		textN = new JTextField();	//�̸� �ؽ�Ʈ�ʵ�
		textN.setBounds(77, 29, 116, 21);
		panel.add(textN);
		textN.setColumns(10);
		
		textH = new JTextField();	//Ű �ؽ�Ʈ�ʵ�
		textH.setBounds(78, 66, 116, 21);
		panel.add(textH);
		textH.setColumns(10);
		
		textW = new JTextField();	//ü�� �ؽ�Ʈ�ʵ�
		textW.setBounds(78, 101, 116, 21);
		panel.add(textW);
		textW.setColumns(10);
		
		JLabel lblCm = new JLabel("(cm)");	//cm ��
		lblCm.setBounds(205, 69, 42, 15);
		panel.add(lblCm);
		
		JLabel lblKg = new JLabel("(kg)");	//kg ��
		lblKg.setBounds(205, 104, 23, 15);
		panel.add(lblKg);
		
		// �����ǳ� ����
		
		JPanel panelS = new JPanel(); // ���� �ǳ�
		panelS.setBorder(new TitledBorder(null, "��   ��", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelS.setBounds(10, 150, 180, 60);
		panel.add(panelS);
		panelS.setLayout(null);
		
		manRadio = new JRadioButton("����");
		manRadio.setBounds(15, 23, 62, 23);
		panelS.add(manRadio);
		
		womanRadio = new JRadioButton("����");
		womanRadio.setBounds(90, 23, 70, 23);
		panelS.add(womanRadio);
		
		g = new ButtonGroup();
		g.add(manRadio);
		g.add(womanRadio);
		
		//�����ǳ� ��
		
		
		//�����ǳ� ����
		
		JPanel panelH = new JPanel(); // ���� �ǳ�
		panelH.setBorder(new TitledBorder(null, "��   ��", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelH.setBounds(10, 240, 230, 60);
		panel.add(panelH);
		panelH.setLayout(null);
		
		chkD = new JCheckBox("����");
		chkD.setBounds(17, 21, 55, 25);
		panelH.add(chkD);
		
		chkS = new JCheckBox("��");
		chkS.setBounds(88, 21, 55, 25);
		panelH.add(chkS);
		
		chkE = new JCheckBox("�");
		chkE.setBounds(160, 21, 55, 25);
		panelH.add(chkE);
		
		//�����ǳڳ�
		//Boday Max Index �ǳ� ��
		
		//������ɽ���
		
		JButton btnResult = new JButton("��ü ���� ����"); //BMI����� �����ִ� ��ư
		btnResult.setBounds(384, 10, 124, 23);
		c.add(btnResult);
		btnResult.addActionListener(new BMIListener(this));
		
		JLabel lblBMIResult = new JLabel("BMI ���"); //BMI ��� ��
		lblBMIResult.setBounds(307, 36, 57, 15);
		c.add(lblBMIResult);
		
		JLabel lblSay = new JLabel("��  ��");	//�Ұ� ��
		lblSay.setBounds(307, 228, 57, 15);		
		c.add(lblSay);
		
		JPanel panelR = new JPanel();	//BMI ��� ������ �����ִ� �ǳ�
		panelR.setBorder(new LineBorder(Color.BLACK));
		panelR.setBounds(307, 61, 201, 157);
		c.add(panelR);
		panelR.setLayout(null);//�ǳ� null�� ��ġ ������
		
		textResult = new JTextArea(); // �̸� Ű ü�� �����
		textResult.setBounds(12, 10, 170, 70);
		textResult.setBackground(new Color(240, 240, 240));
		textResult.setWrapStyleWord(true);
		textResult.setLineWrap(true);
		panelR.add(textResult);
		
		lblColor = new JLabel(); // ����
		lblColor.setBorder(new LineBorder(Color.BLACK));
		lblColor.setBounds(32, 81, 145, 66);		
		lblColor.setOpaque(true);
		panelR.add(lblColor);		
		
		textSay = new JTextArea();	//�ǻ�Ұ� ������
		textSay.setBorder(new LineBorder(Color.BLACK));
		textSay.setBackground(new Color(240, 240, 240));
		textSay.setWrapStyleWord(true);
		textSay.setLineWrap(true);
		textSay.setBounds(307, 253, 201, 98);
		c.add(textSay);
		
		//������ɳ�
		
		setSize(600,450);
		setVisible(true);
		
	}
	
	public JTextField getN() {
		return textN;
	}
	public JTextField getH() {
		return textH;
	}
	public JTextField getW() {
		return textW;
	}
	public JRadioButton getSW() {
		return womanRadio;
	}
	public JRadioButton getSM() {
		return manRadio;
	}
	public JTextArea getResult() {
		return textResult;
	}
	public JLabel getColor() {
		return lblColor;
	}
	public JCheckBox getD() {
		return chkD;
	}
	public JCheckBox getS() {
		return chkS;
	}
	public JCheckBox getE() {
		return chkE;
	}
	public JTextArea getSay() {
		return textSay;
	}
	

	

}
