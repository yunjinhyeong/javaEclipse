package ex04;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
//		la.setLocation(x, y); // �̰� ����� ���ư��� �Ϸ���???
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

}
