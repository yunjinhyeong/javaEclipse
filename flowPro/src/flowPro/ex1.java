package flowPro;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
public class ex1 extends JFrame{//�α���ȭ��
	Image img = null;
	public ex1()
	{
		JPanel p = new JPanel();
        p.setLayout(null); //null�� ���̾ƿ� ��
        JLabel label = new JLabel(new ImageIcon("imgs/gora.png"));
		add(label);
		Label t1= new Label("�ȳ��ϼ���. ����Ʈ�ص���Դϴ�.");
		add(t1);
		Label t2= new Label("�� ���α׷��� �� 7�� �̿��Դϴ�.");
		add(t2);
		Label t3= new Label("�ȉƶ� ȸ�����txt �� �����ߵ˴ϴ�.");
		add(t3);
		Label t4= new Label("ID�Է� �� �α��� ��ư�� Ŭ���ϼ���.");
		add(t4);
		Label lID= new Label("���̵�:");
		add(lID);
		Label lPW= new Label("��й�ȣ:");
		add(lPW);
		TextField tID = new TextField();
		add(tID);
		TextField tPW = new TextField(); //JPaword���� setEchoChar �ȉ�
		add(tPW);
		tPW.setEchoChar('*');//��ȣȭ
		JButton bIN = new JButton("�α���");
		add(bIN);
		JButton bJoin = new JButton("ȸ������");
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
		setTitle("�α��� ȭ�� ");
		setVisible(true);
		bJoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {//ȸ������â���� �̵�
				// TODO Auto-generated method stub
				ex2 f2= new ex2();
			}
		});;
		bIN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e2) {//�α��� �Ҷ� 
				// TODO Auto-generated method stub
				try{
					String s;
					String[] array;
					BufferedReader bos = new BufferedReader(new FileReader("ȸ�����.txt"));
					while((s=bos.readLine())!=null){
						array=s.split("/");
					if(tID.getText().equals(array[1])&&tPW.getText().equals(array[2])){
						JOptionPane.showMessageDialog(null, "�α����� �Ǿ����ϴ�!!");
						ex3 f3 = new ex3();
					}
					else {
						JOptionPane.showMessageDialog(null, "�α����� �����Ͽ����ϴ�.");
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

