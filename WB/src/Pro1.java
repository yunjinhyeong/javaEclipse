import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.SpringLayout;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JProgressBar;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Canvas;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Dimension;

public class Pro1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pro1 frame = new Pro1();
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
	public Pro1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Body Max index", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(12, 10, 270, 341);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\uC131 \uBCC4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(12, 156, 176, 64);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\uC5EC\uC790");
		rdbtnNewRadioButton.setBounds(29, 23, 62, 23);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\uB0A8\uC790");
		rdbtnNewRadioButton_1.setBounds(95, 23, 62, 23);
		panel_1.add(rdbtnNewRadioButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\uC2B5 \uAD00", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(12, 244, 234, 64);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("\uC74C\uC8FC");
		chckbxNewCheckBox.setBounds(17, 21, 55, 23);
		panel_2.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("\uD761\uC5F0");
		chckbxNewCheckBox_1.setBounds(88, 21, 49, 23);
		panel_2.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("\uC6B4\uB3D9");
		chckbxNewCheckBox_2.setBounds(161, 21, 49, 23);
		panel_2.add(chckbxNewCheckBox_2);
		
		JLabel lblNewLabel = new JLabel("\uC774  \uB984:");
		lblNewLabel.setBounds(24, 32, 42, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uD0A4   :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(24, 69, 42, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uCCB4  \uC911:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBounds(24, 104, 42, 15);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(77, 29, 116, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(78, 66, 116, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(78, 101, 116, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("(cm)");
		lblNewLabel_3.setBounds(205, 69, 42, 15);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("(kg)");
		lblNewLabel_4.setBounds(205, 104, 23, 15);
		panel.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("\uC2E0\uCCB4 \uC0C1\uD0DC \uCE21\uC815");
		btnNewButton.setBounds(384, 10, 124, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("BMI\uACB0\uACFC");
		lblNewLabel_5.setBounds(307, 36, 57, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\uC18C  \uACAC");
		lblNewLabel_6.setBounds(307, 228, 57, 15);
		contentPane.add(lblNewLabel_6);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(Color.BLACK));
		panel_3.setBounds(307, 61, 201, 157);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("New label2");
		lblNewLabel_9.setBackground(new Color(0, 153, 102));
		lblNewLabel_9.setOpaque(true);
		lblNewLabel_9.setBounds(32, 55, 145, 92);//32, 81, 145, 66
		panel_3.add(lblNewLabel_9);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBackground(new Color(240,240,240));
		textArea.setBounds(12, 10, 177, 76);
		panel_3.add(textArea);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(Color.BLACK));
		panel_4.setBounds(307, 253, 201, 98);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("New label3");
		lblNewLabel_8.setBounds(12, 10, 179, 78);
		panel_4.add(lblNewLabel_8);
		
		
	}
}
