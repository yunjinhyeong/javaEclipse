package ex05;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

public 	class MyItemListener implements ItemListener 
{
	private int sum; // ������ ��	
	MyFrame mf;
	
	public MyItemListener(MyFrame mf) 
	{
		this.mf = mf;
		sum = 0;
	}


	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
//			if(e.getItem() == fruits[0])
			if(e.getItem() == mf.getFruits()[0])
				sum += 100;
			else if(e.getItem() == mf.getFruits()[1])
				sum += 500;
			else
				sum += 20000;
		}
		else {
			if(e.getItem() == mf.getFruits()[0])
				sum -= 100;
			else if(e.getItem() == mf.getFruits()[1])
				sum -= 500;
			else
				sum -= 20000;
		}
//		sumLabel.setText("���� "+ sum + "�� �Դϴ�.");
		mf.getSumLabel().setText("���� "+ sum + "�� �Դϴ�.");
	}
}
