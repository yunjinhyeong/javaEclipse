package flowPro;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class ex3 extends JFrame{//로그인 성공시
	public ex3(){
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
    tPW.setEchoChar('*');
    TextField tAD = new TextField();
    TextField tCO = new TextField();
    add(tN);
    add(tID);
    add(tPW);
    add(tAD);
    add(tCO);
    tN.setEditable(false);
    tID.setEditable(false);
    tPW.setEditable(false);
    tAD.setEditable(false);
    tCO.setEditable(false);
    JButton j1 = new JButton("확인");
    JButton j2 = new JButton("수정");
    add(j1);
    add(j2);
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
    j1.setBounds(125, 330, 80, 30);
    j2.setBounds(240, 330, 80, 30);
    try { //로그인하고 회원정보 데이터 입력
 	   String s; 
 	   String[] array; 
 	   BufferedReader br = new BufferedReader(new FileReader("회원명단.txt")); 
 	   while ((s = br.readLine()) != null) { 
 	      array = s.split("/"); 
 	     tN.setText(array[0]);
 	     tID.setText(array[1]);
 	     tPW.setText(array[2]);
 	     tAD.setText(array[3]);
 	     tCO.setText(array[4]);
 	   } 
 	   br.close(); 
 	   } catch (IOException e2) { 
 	   e2.printStackTrace(); 
 	} 
add(p); //p를 JFrame에 붙임
setSize(500,500);
setTitle("로그인 성공");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
j1.addActionListener(new ActionListener() {//고라파덕그림나오는거
	@Override
	public void actionPerformed(ActionEvent e3) {
			ex5 drawing = new ex5 ();
	}
	
});
j2.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e4) {//수정버튼눌럿을 때
		// TODO Auto-generated method stub
		ex4 f4 = new ex4();
	}
});
	}
}