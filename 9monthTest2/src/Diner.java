import java.awt.Container;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

public class Diner extends JFrame{
	private ButtonGroup g;
	private JTextArea cal;
	private JComboBox<String> comboRice;
	private JComboBox comboRamen;
	private JComboBox comboCount;
	private JCheckBox chkD;
	private JRadioButton untax;
	private JRadioButton tax;
	private JComboBox[] ListR;
	private JComboBox[] Listr;
	private JComboBox[] ListC;
	
	public Diner() {
		setTitle("저녁 뭐 먹을래?");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "학식이 최고!", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(25, 22, 278, 161);
		c.add(panel_1);
		panel_1.setLayout(null);		
		
		JLabel lblrice = new JLabel("밥");
		lblrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblrice.setBounds(12, 37, 30, 15);
		panel_1.add(lblrice);
		
		JLabel lblramen = new JLabel("라면");
		lblramen.setBounds(12, 77, 30, 15);
		panel_1.add(lblramen);
		
		JLabel lblcount = new JLabel("수량");
		lblcount.setBounds(138, 37, 30, 15);
		panel_1.add(lblcount);
		
//		comboRice = new JComboBox();		
//		panel_1.add(comboRice);
		
		String ListR[] = {"고치돈","제육볶음","치킨마요"};		
		comboRice = new JComboBox<String>(ListR);
		comboRice.setBounds(46, 37, 71, 18);
		panel_1.add(comboRice);
				
//		comboRamen = new JComboBox();
		
//		panel_1.add(comboRamen);
		
		String Listr[] = {"라면"};
		comboRamen = new JComboBox(Listr);
		comboRamen.setBounds(48, 74, 71, 18);
		panel_1.add(comboRamen);
		
//		comboCount = new JComboBox();
		
//		panel_1.add(comboCount);
		
		String ListC[] = {"1","2","3","4","5"};
		comboCount = new JComboBox(ListC);
		comboCount.setBounds(180, 35, 71, 18);
		panel_1.add(comboCount);
		
		chkD = new JCheckBox("딸기 요거트");
		chkD.setBounds(46, 113, 115, 23);
		panel_1.add(chkD);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "영수증", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(150, 193, 153, 82);
		c.add(panel_2);
		panel_2.setLayout(null);
		
		untax = new JRadioButton("부가세 미포함");
		untax.setBounds(16, 22, 121, 23);
		panel_2.add(untax);
		
		tax = new JRadioButton("부가세 포함");
		tax.setBounds(16, 47, 121, 23);
		panel_2.add(tax);
		
		g = new ButtonGroup();
		g.add(untax);
		g.add(tax);
		
		cal = new JTextArea();
		cal.setBounds(315, 22, 100, 161);
		c.add(cal);
		cal.setColumns(10);
		cal.setEditable(false);		
		
		JButton btnC = new JButton("계산하기");
		btnC.setBounds(315, 193, 100, 23);
		c.add(btnC);
		btnC.addActionListener(new calculation(this));
		
		
		setBounds(100, 100, 441, 319);
		setVisible(true);
	}
	
	public JComboBox getRice() {
		return comboRice;
	}
	public JComboBox getRamen() {
		return comboRamen;
	}
	public JComboBox getCount() {
		return comboCount;
	}
	public JCheckBox getD() {
		return chkD;
	}
	public JRadioButton getUntax() {
		return untax;
	}
	public JRadioButton getTax() {
		return tax;
	}
	public JTextArea getShow() {
		return cal;
	}
	
		
}
