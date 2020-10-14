package CopyEx0109;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MyListen implements ItemListener {
	private RBEx mf;
	
	public MyListen(RBEx mf) {
		this.mf=mf;
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange()==ItemEvent.DESELECTED)
			return;
		if(mf.getRadio()[0].isSelected())
			mf.getImgL().setIcon(mf.getImg()[0]);
		if(mf.getRadio()[1].isSelected())
			mf.getImgL().setIcon(mf.getImg()[1]);
		if(mf.getRadio()[2].isSelected())
			mf.getImgL().setIcon(mf.getImg()[2]);

	}

}
