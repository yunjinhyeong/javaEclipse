package flowPro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.*;
import java.awt.*;
public class ex2 extends JFrame {//ȸ������ȭ��
	public ex2(){
		  	JPanel p = new JPanel();
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
	        add(tN);
	        add(tID);
	        add(tPW);
	        add(tAD);
	        add(tCO);
	        tPW.setEchoChar('*');
	        JButton jS = new JButton("����");
	        JButton jC = new JButton("���");
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
		setTitle("ȸ������");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setVisible(true);
       jS.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent T) {//ȸ������ ������ ����
			try{
				BufferedWriter bos = new BufferedWriter(new FileWriter("ȸ�����.txt",true));
				bos.write(tN.getText()+"/");
				bos.write(tID.getText()+"/");
				bos.write(tPW.getText()+"/");
				bos.write(tAD.getText()+"/");
				bos.write(tCO.getText()+"\r\n");
				bos.close();
				JOptionPane.showMessageDialog(null, "ȸ�������� �����մϴ�!!");
				dispose();
			}catch (Exception ex){
				JOptionPane.showMessageDialog(null, "ȸ�����Կ� �����Ͽ����ϴ�.");
			}
		}
	});
	}    
}

