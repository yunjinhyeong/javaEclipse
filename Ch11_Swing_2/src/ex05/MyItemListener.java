package ex05;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

public 	class MyItemListener implements ItemListener 
{
	private int sum; // 가격의 합	
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
//		sumLabel.setText("현재 "+ sum + "원 입니다.");
		mf.getSumLabel().setText("현재 "+ sum + "원 입니다.");
	}
}
