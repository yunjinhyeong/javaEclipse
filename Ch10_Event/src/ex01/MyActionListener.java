package ex01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

//ActionListener �������̽��� ��ӹ޾Ƽ�(����), MyActionListener Ŭ������ �����!
public class MyActionListener implements ActionListener {

	//�������̽��� ��� �޾ұ� ������, �ݵ�� �ʼ������� �߻� �޼ҵ�(abstract method)��
	//�������̵�(������) ����߸� �Ѵ�!
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		JButton b = (JButton) e.getSource();
		if (b.getText().equals("Action"))
			b.setText("�׼�");
		else
			b.setText("Action");

	}
}
