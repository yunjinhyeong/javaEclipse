package ex10;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//���1. �ܺ�(����) Ŭ����
class MyMouseListener extends MouseAdapter 
{
	public void mouseClicked(MouseEvent e) 
	{
		//���� Ŭ���� �����ϴ� �ڵ�
		if (e.getClickCount() == 2) {
			int r = (int) (Math.random() * 256);
			int g = (int) (Math.random() * 256);
			int b = (int) (Math.random() * 256);
//			Component c = (Component) e.getSource();
			Container c = (Container) e.getSource();
			c.setBackground(new Color(r, b, g));
		}
	}
}
