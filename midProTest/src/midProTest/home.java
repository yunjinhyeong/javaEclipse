package midProTest;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class home extends JFrame {
	private memberJoin mj;
	private JPanel c;
	private JTextField txtID;
	private JTextField txtPW;
	public home() {
		super("고라파덕 공식 팬클럽 사이트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mj=new memberJoin(this, "회원가입");
		
		c = new JPanel();
		setContentPane(c);
		c.setLayout(null);
		
		
		JLabel lbl = new JLabel("고라파덕 팬클럽");
		lbl.setBounds(16, 13, 100, 21);
		c.add(lbl);
		
		JLabel lblID = new JLabel("아이디(ID) :");
		lblID.setBounds(33, 176, 70, 24);
		lblID.setHorizontalAlignment(SwingConstants.RIGHT);
		c.add(lblID);
		
		txtID = new JTextField();
		txtID.setBounds(125, 172, 191, 34);
		c.add(txtID);
		txtID.setColumns(10);		
		
		JLabel lblPW = new JLabel("패스워드(PW) :");
		lblPW.setBounds(19, 223, 93, 19);
		c.add(lblPW);
		
		txtPW = new JTextField();
		txtPW.setBounds(125, 216, 193, 35);
		c.add(txtPW);
		txtPW.setColumns(10);
		
		ImageIcon gora = new ImageIcon("imgs/gora.png");
		JLabel lblImg = new JLabel(gora);
		lblImg.setBounds(128, 13, 294, 142);
		c.add(lblImg);
		
		JButton btnLink = new JButton("로그인");
		btnLink.setBounds(328, 171, 94, 34);
		c.add(btnLink);
		
		JButton btnJoin = new JButton("회원가입");
		btnJoin.setBounds(328, 215, 92, 34);		
		btnJoin.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				mj.setVisible(true);
				
			}
		});		
		c.add(btnJoin);
		
		setBounds(100, 100, 450, 300);
		setVisible(true);
		
	}
		
}
