package flowPro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.*;
import java.awt.*;
public class ex2 extends JFrame {//회원가입화면
	public ex2(){
		  	JPanel p = new JPanel();
		  	Label lN= new Label("이름");	
	        Label lID = new Label("아이디");
	        Label lPW= new Label("패스워드");
	        Label lAD = new Label("주소");
	        Label lCO = new Label("추가사항");
	        add(lN);
	        add(lID);
	        add(lPW);
	        add(lAD);
	        add(lCO);
	        TextField tN = new TextField();
	        TextField tID = new TextField();
	        TextField tPW = new TextField();
	        TextField tAD = new TextField();
	        TextField tCO = new TextField();
	        add(tN);
	        add(tID);
	        add(tPW);
	        add(tAD);
	        add(tCO);
	        tPW.setEchoChar('*');
	        JButton jS = new JButton("저장");
	        JButton jC = new JButton("취소");
	        add(jS);
	        add(jC);
	        lN.setBounds(40, 10, 40, 40);
	        lID.setBounds(40, 50, 40, 40);
	        lPW.setBounds(40,90,60,40);
	        lAD.setBounds(40, 130, 40, 40);
	        lCO.setBounds(40, 170, 60, 40);
	        tN.setBounds(120, 10, 200, 30);
	        tID.setBounds(120, 50, 200, 30);
	        tPW.setBounds(120, 90, 200, 30);
	        tAD.setBounds(120, 130, 280, 30);
	        tCO.setBounds(120, 180, 280, 120);
	        jS.setBounds(125, 330, 80, 30);
	        jC.setBounds(240, 330, 80, 30); 
	    add(p);
		setSize(500,500);
		setTitle("회원가입");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setVisible(true);
       jS.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent T) {//회원가입 데이터 저장
			try{
				BufferedWriter bos = new BufferedWriter(new FileWriter("회원명단.txt",true));
				bos.write(tN.getText()+"/");
				bos.write(tID.getText()+"/");
				bos.write(tPW.getText()+"/");
				bos.write(tAD.getText()+"/");
				bos.write(tCO.getText()+"\r\n");
				bos.close();
				JOptionPane.showMessageDialog(null, "회원가입을 축하합니다!!");
				dispose();
			}catch (Exception ex){
				JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다.");
			}
		}
	});
	}    
}

