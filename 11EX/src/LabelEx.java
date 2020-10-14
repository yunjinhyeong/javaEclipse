import javax.swing.*;
import java.awt.*;

public class LabelEx extends JFrame{
	public LabelEx() {
		setTitle("sdfa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel TL = new JLabel("LOVE");
		
		ImageIcon beauty = new ImageIcon("images/beauty.jpg");
		JLabel imageLabel = new JLabel(beauty);
		
		ImageIcon normalIcon = new ImageIcon("images/normalicon.gif");
		JLabel label = new JLabel("보고싶으면 콜",
				normalIcon,SwingConstants.CENTER);
		
		c.add(TL);
		c.add(imageLabel);
		c.add(label);
		
		setSize(400,600);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new LabelEx();

	}

}
