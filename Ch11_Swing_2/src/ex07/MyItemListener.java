package ex07;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;

public class MyItemListener implements ItemListener 
{
	MyFrame mf;
	
	private ImageIcon [] image = {
			new ImageIcon("images/apple.jpg"),
			new ImageIcon("images/pear.jpg"),
			new ImageIcon("images/cherry.jpg")};

	public MyItemListener(MyFrame mf) 
	{
		this.mf = mf;
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.DESELECTED)
			return;
//		if (radio[0].isSelected())
//			imageLabel.setIcon(image[0]);
//		else if (radio[1].isSelected())
//			imageLabel.setIcon(image[1]);
//		else
//			imageLabel.setIcon(image[2]);
		
		if (mf.getRadio()[0].isSelected())
			mf.getImageLabel().setIcon(image[0]);
		else if (mf.getRadio()[1].isSelected())
			mf.getImageLabel().setIcon(image[1]);
		else
			mf.getImageLabel().setIcon(image[2]);
	}
}

