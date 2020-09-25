import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;

public class Test extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
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
	public Test() {
		setTitle("고라파덕 공식 팬클럽 사이트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);	
		
		JLabel lblNewLabel = new JLabel("고라파덕 팬클럽");
		lblNewLabel.setBounds(16, 13, 100, 21);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(125, 172, 191, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("로그인");
		btnNewButton.setBounds(328, 171, 94, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("회원가입");
		btnNewButton_1.setBounds(328, 215, 92, 34);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("아이디(ID) :");
		lblNewLabel_1.setBounds(33, 176, 70, 24);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("패스워드(PW) :");
		lblNewLabel_2.setBounds(19, 223, 93, 19);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(125, 216, 193, 35);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		ImageIcon gora = new ImageIcon("imgs/gora.png");
		JLabel lblImg = new JLabel(gora);
		lblImg.setBounds(128, 13, 294, 142);
		contentPane.add(lblImg);
	}
}
