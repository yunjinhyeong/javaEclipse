import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JTextField;

public class BMIListener implements ActionListener{
	private int sum; // 가격의 합	
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
			this.coment="멋진 ";
		}else if(bf.getSW().isSelected())
			this.coment="아름다운 ";
		else
			this.coment="성별선택하세요! ";
		

		textWD = Double.parseDouble(bf.getW().getText());
		textHD = Double.parseDouble(bf.getH().getText());
		name = bf.getN().getText();
		
		//신체질량지수 = 체중 / (( 키 / 100) ^ 2) 
		stateD = Math.round(textWD/((textHD/100)*(textHD/100)));
		stateI = (int)(stateD);			
		
		switch(stateI) {
			case 30:
				state="고도비만";
				break;
			case 29:
			case 28:
			case 27:
			case 26:
			case 25:
				state="중도비만";
				break;
			case 24:
			case 23:
				state="과체중";
				break;
			case 22:
			case 21:
			case 20:
			case 19:
			case 18:
				state="정상";
				break;
			default:
				state="저체중";
				break;	
		}
		
		String result1 = coment + name + "님의 \n";		
		result1 += "신체 질량 지수는: \n";
		result1 += stateD + "("+ state +")" +" 입니다";		
		bf.getResult().setText(result1);
		
		if(stateI>=23) {
			bf.getColor().setBackground(Color.RED);
		}else if(stateI>=18) {
			bf.getColor().setBackground(Color.GREEN);
		}else {
			bf.getColor().setBackground(Color.BLUE);
		}
		
			if(bf.getD().isSelected()==true) {
				bf.getSay().setText("술 그만 마셔요 !! \n");
			}
			if(bf.getS().isSelected()==true) {
				bf.getSay().setText(bf.getSay().getText()+"담배 끊으세요 !! \n");
			}
			if(bf.getE().isSelected()==false) {
				bf.getSay().setText(bf.getSay().getText()+"운동 좀 하세요 !!");
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
//					bf.getSay().append("술 좀 그만마셔요");
//				else if(e.getItem()==bf.getS())
//					bf.getSay().append("담배 좀 끊으세요");
//				else if(e.getItem()==bf.getE())
//					bf.getSay().setText("");	
//			}
//			else
//				if(e.getItem()==bf.getE())
//					bf.getSay().append("운동 좀 하세요");				
//				else if(e.getItem()==bf.getS())
//					bf.getSay().setText("");	
//				else if(e.getItem()==bf.getD())
//					bf.getSay().setText("");	
//		}
