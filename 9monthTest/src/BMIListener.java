import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JTextField;

public class BMIListener implements ActionListener{
	private int sum; // ������ ��	
	BMImeasure bf;
	private String coment;
	private String state;
	private int stateI;
	private double stateD;
	private double textHD;
	private double textWD;
	private String name;
	
	
	public BMIListener(BMImeasure bf) 
	{
		this.bf = bf;
		sum = 0;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		
		if(bf.getSM().isSelected()) {
			this.coment="���� ";
		}else if(bf.getSW().isSelected())
			this.coment="�Ƹ��ٿ� ";
		else
			this.coment="���������ϼ���! ";
		

		textWD = Double.parseDouble(bf.getW().getText());
		textHD = Double.parseDouble(bf.getH().getText());
		name = bf.getN().getText();
		
		//��ü�������� = ü�� / (( Ű / 100) ^ 2) 
		stateD = Math.round(textWD/((textHD/100)*(textHD/100)));
		stateI = (int)(stateD);			
		
		switch(stateI) {
			case 30:
				state="����";
				break;
			case 29:
			case 28:
			case 27:
			case 26:
			case 25:
				state="�ߵ���";
				break;
			case 24:
			case 23:
				state="��ü��";
				break;
			case 22:
			case 21:
			case 20:
			case 19:
			case 18:
				state="����";
				break;
			default:
				state="��ü��";
				break;	
		}
		
		String result1 = coment + name + "���� \n";		
		result1 += "��ü ���� ������: \n";
		result1 += stateD + "("+ state +")" +" �Դϴ�";		
		bf.getResult().setText(result1);
		
		if(stateI>=23) {
			bf.getColor().setBackground(Color.RED);
		}else if(stateI>=18) {
			bf.getColor().setBackground(Color.GREEN);
		}else {
			bf.getColor().setBackground(Color.BLUE);
		}
		
			if(bf.getD().isSelected()==true) {
				bf.getSay().setText("�� �׸� ���ſ� !! \n");
			}
			if(bf.getS().isSelected()==true) {
				bf.getSay().setText(bf.getSay().getText()+"��� �������� !! \n");
			}
			if(bf.getE().isSelected()==false) {
				bf.getSay().setText(bf.getSay().getText()+"� �� �ϼ��� !!");
			}
	}
	
}

//		MyitemListener listener = new MyitemListener();		
//		bf.getD().addItemListener(listener);
//		bf.getS().addItemListener(listener);
//		bf.getE().addItemListener(listener);
		
		
	
//	class MyitemListener implements ItemListener {
//
//		@Override
//		public void itemStateChanged(ItemEvent e) {
//			if(e.getStateChange() == ItemEvent.SELECTED) {
//				if(e.getItem()==bf.getD())
//					bf.getSay().append("�� �� �׸����ſ�");
//				else if(e.getItem()==bf.getS())
//					bf.getSay().append("��� �� ��������");
//				else if(e.getItem()==bf.getE())
//					bf.getSay().setText("");	
//			}
//			else
//				if(e.getItem()==bf.getE())
//					bf.getSay().append("� �� �ϼ���");				
//				else if(e.getItem()==bf.getS())
//					bf.getSay().setText("");	
//				else if(e.getItem()==bf.getD())
//					bf.getSay().setText("");	
//		}
