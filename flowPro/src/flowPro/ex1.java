package flowPro;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
public class ex1 extends JFrame{//로그인화면
	Image img = null;
	public ex1()
	{
		JPanel p = new JPanel();
        p.setLayout(null); //null의 레이아웃 셋
        JLabel label = new JLabel(new ImageIcon("imgs/gora.png"));
		add(label);
		Label t1= new Label("안녕하세요. 프런트앤드반입니다.");
		add(t1);
		Label t2= new Label("본 프로그램은 만 7세 이용입니다.");
		add(t2);
		Label t3= new Label("안됄땐 회원명단txt 를 지워야됩니다.");
		add(t3);
		Label t4= new Label("ID입력 후 로그인 버튼을 클릭하세요.");
		add(t4);
		Label lID= new Label("아이디:");
		add(lID);
		Label lPW= new Label("비밀번호:");
		add(lPW);
		TextField tID = new TextField();
		add(tID);
		TextField tPW = new TextField(); //JPaword쓰면 setEchoChar 안됌
		add(tPW);
		tPW.setEchoChar('*');//암호화
		JButton bIN = new JButton("로그인");
		add(bIN);
		JButton bJoin = new JButton("회원가입");
		add(bJoin);
		
		label.setBounds(0, 5, 350, 255);
		t1.setBounds(350, 35, 280, 40);
		t2.setBounds(350,65, 280, 40);
		t3.setBounds(350, 95,280, 40);
		t4.setBounds(350,125,280, 40);
		lID.setBounds(40, 265, 40, 40);
		lPW.setBounds(40, 305, 60, 40);
		tID.setBounds(150, 265, 200, 30);
		tPW.setBounds(150, 305, 200, 30);
		bIN.setBounds(380, 265, 80, 30);
		bJoin.setBounds(380, 305, 90, 30);
		add(p);
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("로그인 화면 ");
		setVisible(true);
		bJoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {//회원가입창으로 이동
				// TODO Auto-generated method stub
				ex2 f2= new ex2();
			}
		});;
		bIN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e2) {//로그인 할때 
				// TODO Auto-generated method stub
				try{
					String s;
					String[] array;
					BufferedReader bos = new BufferedReader(new FileReader("회원명단.txt"));
					while((s=bos.readLine())!=null){
						array=s.split("/");
					if(tID.getText().equals(array[1])&&tPW.getText().equals(array[2])){
						JOptionPane.showMessageDialog(null, "로그인이 되었습니다!!");
						ex3 f3 = new ex3();
					}
					else {
						JOptionPane.showMessageDialog(null, "로그인이 실패하였습니다.");
					}
					}
					bos.close();
					dispose();
				}catch (IOException E10){
					E10.printStackTrace();
				}
			}
		});
	}
}

