package CopyEx0109;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class MIL implements ItemListener{
	private int sum;
	private CBIEEx mf;
	public MIL(CBIEEx mf) {
		this.mf=mf;
		sum=0;
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange()==ItemEvent.SELECTED) {
			if(e.getItem()==mf.getFruits()[0]) 
				sum+=100;
			else if(e.getItem()==mf.getFruits()[1])
				sum+=500;
			else
				sum+=200000000;				
		} else {
			if(e.getItem()==mf.getFruits()[0]) 
				sum-=100;
			else if(e.getItem()==mf.getFruits()[1])
				sum-=500;
			else
				sum-=200000000;
		}
		mf.getSumL().setText(sum+"¿‘¥œ¥Ÿ.");
	}
	
}