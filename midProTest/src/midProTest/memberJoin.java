package midProTest;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class memberJoin extends JDialog {
	private JTextField tfName;
	private JTextField tfID;
	private JTextField tfPW;
	private JTextField tfAdress;
	public memberJoin(JFrame frame, String title) {			
		super(frame,title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();		
		c.setLayout(null);		
		
		JLabel lblName = new JLabel("�̸� :");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(12, 22, 57, 15);
		c.add(lblName);
			
		tfName = new JTextField();
		tfName.setBounds(81, 15, 143, 30);
		c.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblID = new JLabel("���̵� :");
		lblID.setHorizontalAlignment(SwingConstants.RIGHT);
		lblID.setBounds(12, 62, 57, 15);
		c.add(lblID);
			
		tfID = new JTextField();
		tfID.setBounds(81, 55, 143, 30);
		c.add(tfID);
		tfID.setColumns(10);
			
		JLabel lblPW= new JLabel("�н����� :");
		lblPW.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPW.setBounds(0, 102, 69, 15);
		c.add(lblPW);
			
		tfPW = new JTextField();
		tfPW.setBounds(81, 95, 143, 30);
		c.add(tfPW);
		tfPW.setColumns(10);
			
		JLabel lblAdress = new JLabel("�ּ� :");
		lblAdress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdress.setBounds(0, 142, 69, 15);
		c.add(lblAdress);
			
		tfAdress = new JTextField();
		tfAdress.setBounds(81, 135, 240, 30);
		c.add(tfAdress);
		tfAdress.setColumns(10);
		
		JLabel lblAdd = new JLabel("�߰����� :");
		lblAdd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdd.setBounds(0, 182, 69, 15);
		c.add(lblAdd);
			
		JButton btnSave = new JButton("����");
		btnSave.setBounds(81, 265, 69, 23);
		c.add(btnSave);
			
		JButton btnCancel = new JButton("���");
		btnCancel.setBounds(230, 265, 69, 23);
		c.add(btnCancel);
			
		JTextArea txtAdd = new JTextArea();
		txtAdd.setBounds(80, 178, 254, 77);
		c.add(txtAdd);
					
		ImageIcon img2 = new ImageIcon("imgs/gora2.jpeg");
		JLabel lblimg = new JLabel(img2);
		lblimg.setBounds(230, 15, 91, 110);
		c.add(lblimg);
		
		setBounds(100, 100, 450, 300);
		setVisible(true);
	}
	
	

}
