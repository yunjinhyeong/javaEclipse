package CopyEx0109;

import java.awt.Color;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyChangeListener implements ChangeListener {
	private SliderChangeEx mf;
	
	public MyChangeListener(SliderChangeEx mf) {
		this.mf=mf;
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		int r = mf.getsl()[0].getValue();
		int g = mf.getsl()[1].getValue();
		int b = mf.getsl()[2].getValue();
		mf.getCL().setBackground(new Color(r,g,b));

	}

}
