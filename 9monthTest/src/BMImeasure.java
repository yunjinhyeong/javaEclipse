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
		setTitle("신체 질량 지수 측정(BMI) - 윤진형");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		
		// Body Max Index 판넬 시작
		
		JPanel panel = new JPanel(); // 전체 판넬
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Body Max index", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(20, 25, 270, 340);
		c.add(panel);
		panel.setLayout(null);
		
		JLabel labelN = new JLabel("이  름:"); //이름라벨
		labelN.setBounds(24, 32, 42, 15);
		panel.add(labelN);
		
		JLabel lblH = new JLabel(" 키  :");	//키라벨
		lblH.setHorizontalAlignment(SwingConstants.CENTER);
		lblH.setBounds(24, 69, 42, 15);
		panel.add(lblH);
		
		JLabel lblW = new JLabel("체  중:");	//체중라벨
		lblW.setBounds(24, 104, 42, 15);
		panel.add(lblW);
		
		textN = new JTextField();	//이름 텍스트필드
		textN.setBounds(77, 29, 116, 21);
		panel.add(textN);
		textN.setColumns(10);
		
		textH = new JTextField();	//키 텍스트필드
		textH.setBounds(78, 66, 116, 21);
		panel.add(textH);
		textH.setColumns(10);
		
		textW = new JTextField();	//체중 텍스트필드
		textW.setBounds(78, 101, 116, 21);
		panel.add(textW);
		textW.setColumns(10);
		
		JLabel lblCm = new JLabel("(cm)");	//cm 라벨
		lblCm.setBounds(205, 69, 42, 15);
		panel.add(lblCm);
		
		JLabel lblKg = new JLabel("(kg)");	//kg 라벨
		lblKg.setBounds(205, 104, 23, 15);
		panel.add(lblKg);
		
		// 성별판넬 시작
		
		JPanel panelS = new JPanel(); // 성별 판넬
		panelS.setBorder(new TitledBorder(null, "성   별", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelS.setBounds(10, 150, 180, 60);
		panel.add(panelS);
		panelS.setLayout(null);
		
		manRadio = new JRadioButton("남자");
		manRadio.setBounds(15, 23, 62, 23);
		panelS.add(manRadio);
		
		womanRadio = new JRadioButton("여자");
		womanRadio.setBounds(90, 23, 70, 23);
		panelS.add(womanRadio);
		
		g = new ButtonGroup();
		g.add(manRadio);
		g.add(womanRadio);
		
		//성별판넬 끝
		
		
		//습관판넬 시작
		
		JPanel panelH = new JPanel(); // 습관 판넬
		panelH.setBorder(new TitledBorder(null, "습   관", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelH.setBounds(10, 240, 230, 60);
		panel.add(panelH);
		panelH.setLayout(null);
		
		chkD = new JCheckBox("음주");
		chkD.setBounds(17, 21, 55, 25);
		panelH.add(chkD);
		
		chkS = new JCheckBox("흡연");
		chkS.setBounds(88, 21, 55, 25);
		panelH.add(chkS);
		
		chkE = new JCheckBox("운동");
		chkE.setBounds(160, 21, 55, 25);
		panelH.add(chkE);
		
		//습관판넬끝
		//Boday Max Index 판넬 끝
		
		//우측기능시작
		
		JButton btnResult = new JButton("신체 상태 측정"); //BMI결과값 보여주는 버튼
		btnResult.setBounds(384, 10, 124, 23);
		c.add(btnResult);
		btnResult.addActionListener(new BMIListener(this));
		
		JLabel lblBMIResult = new JLabel("BMI 결과"); //BMI 결과 라벨
		lblBMIResult.setBounds(307, 36, 57, 15);
		c.add(lblBMIResult);
		
		JLabel lblSay = new JLabel("소  견");	//소견 라벨
		lblSay.setBounds(307, 228, 57, 15);		
		c.add(lblSay);
		
		JPanel panelR = new JPanel();	//BMI 결과 색으로 보여주는 판넬
		panelR.setBorder(new LineBorder(Color.BLACK));
		panelR.setBounds(307, 61, 201, 157);
		c.add(panelR);
		panelR.setLayout(null);//판넬 null로 위치 재조정
		
		textResult = new JTextArea(); // 이름 키 체중 결과값
		textResult.setBounds(12, 10, 170, 70);
		textResult.setBackground(new Color(240, 240, 240));
		textResult.setWrapStyleWord(true);
		textResult.setLineWrap(true);
		panelR.add(textResult);
		
		lblColor = new JLabel(); // 색상
		lblColor.setBorder(new LineBorder(Color.BLACK));
		lblColor.setBounds(32, 81, 145, 66);		
		lblColor.setOpaque(true);
		panelR.add(lblColor);		
		
		textSay = new JTextArea();	//의사소견 보여줌
		textSay.setBorder(new LineBorder(Color.BLACK));
		textSay.setBackground(new Color(240, 240, 240));
		textSay.setWrapStyleWord(true);
		textSay.setLineWrap(true);
		textSay.setBounds(307, 253, 201, 98);
		c.add(textSay);
		
		//우측기능끝
		
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
