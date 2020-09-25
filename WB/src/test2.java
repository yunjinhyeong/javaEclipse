import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class test2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test2 frame = new test2();
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
	public test2() {
		setTitle("저녁 머 먹을래?");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 441, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "학식이 최고", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(25, 22, 278, 161);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uBC25");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(12, 37, 24, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uB77C\uBA74");
		lblNewLabel_1.setBounds(12, 77, 24, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uC218\uB7C9");
		lblNewLabel_2.setBounds(138, 37, 30, 15);
		panel.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(46, 37, 71, 18);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(48, 74, 71, 18);
		panel.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(180, 35, 71, 18);
		panel.add(comboBox_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("\uB538\uAE30 \uC694\uAC70\uD2B8");
		chckbxNewCheckBox.setBounds(46, 113, 115, 23);
		panel.add(chckbxNewCheckBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\uC601\uC218\uC99D", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(150, 193, 153, 82);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("부가세 미포함");
		rdbtnNewRadioButton_1.setBounds(16, 22, 121, 23);
		panel_1.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("부가세 포함");
		rdbtnNewRadioButton.setBounds(16, 47, 121, 23);
		panel_1.add(rdbtnNewRadioButton);
		
		textField = new JTextField();
		textField.setBounds(315, 22, 100, 161);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\uACC4\uC0B0\uD558\uAE30");
		btnNewButton.setBounds(315, 193, 100, 23);
		contentPane.add(btnNewButton);
	}
}
