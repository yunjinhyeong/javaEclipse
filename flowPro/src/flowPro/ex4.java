package flowPro;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class ex4 extends JFrame{//����Ŭ����
	public ex4(){
	JPanel p = new JPanel();
    p.setLayout(null);
    Label lN= new Label("�̸�");
    Label lID = new Label("���̵�");
    Label lPW= new Label("�н�����");
    Label lAD = new Label("�ּ�");
    Label lCO = new Label("�߰�����");
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
    tPW.setEchoChar('*');
    add(tN);
    add(tID);
    add(tPW);
    add(tAD);
    add(tCO);
    tN.setEditable(false);
    tID.setEditable(false);
    tPW.setEditable(false);
    JButton j1 = new JButton("����");
    JButton j2 = new JButton("���");
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
add(p); //p�� JFrame�� ����
setSize(500,500);
setTitle("����");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
try { //������ ȸ������ �ҷ�����
	   String s; 
	   String[] array; 
	   BufferedReader br = new BufferedReader(new FileReader("ȸ�����.txt")); 
	   while ((s = br.readLine()) != null) { 
	      array = s.split("/"); 
	     tN.setText(array[0]);
	     tID.setText(array[1]);
	     tPW.setText(array[2]);
	     tAD.setText("");
	     tCO.setText("");
	   } 
	   br.close(); 
	   } catch (IOException e2) { 
	   e2.printStackTrace(); 
	}
j1.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e77) {//�����Ѱ��� �ٽ� ����
		// TODO Auto-generated method stub
		try{
			BufferedWriter bo = new BufferedWriter(new FileWriter("ȸ�����.txt"));
			bo.write(tN.getText()+"/");
			bo.write(tID.getText()+"/");
			bo.write(tPW.getText()+"/");
			bo.write(tAD.getText()+"/");
			bo.write(tCO.getText()+"\r\n");
			bo.close();
			 JOptionPane.showMessageDialog(null, "�����Ͽ����ϴ�."); 
        } catch (Exception ex) { 
        JOptionPane.showMessageDialog(null, "���忡 �����Ͽ����ϴ�."); 
     } 
		}
});
j2.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		setVisible(false);
	}
});
	}
}
