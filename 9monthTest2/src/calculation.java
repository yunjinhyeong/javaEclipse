import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class calculation implements ActionListener{
	private Diner mf;
	private int result;
	private double Dresult;
	private String F;
	
	public calculation(Diner mf) {
		this.mf=mf;
		this.result=0;
		this.Dresult=0;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		result=0;
		if(mf.getRice().getSelectedItem().toString()=="°íÄ¡µ·") {
			result += 3500;
		}else if(mf.getRice().getSelectedItem().toString()=="Á¦À°ººÀ½") {
			result += 4000;
		}else if(mf.getRice().getSelectedItem().toString()=="Ä¡Å²¸¶¿ä") {
			result +=3000;
		}
		if(mf.getRamen().getSelectedItem().toString()=="¶ó¸é")
			result+=2000;
		if(mf.getD().isSelected())
			result+=1500;
		
		if(mf.getCount().getSelectedItem().toString()=="1") {
			result=result*1;
		}else if(mf.getCount().getSelectedItem().toString()=="2") {
			result=result*2;
		}else if(mf.getCount().getSelectedItem().toString()=="3") {
			result=result*3;
		}else if(mf.getCount().getSelectedItem().toString()=="4") {
			result=result*4;
		}else if(mf.getCount().getSelectedItem().toString()=="5") {
			result=result*5;
		}
		
		Dresult=Double.valueOf(result);
		if(mf.getTax().isSelected())
			Dresult=Math.round(result*1.1);

		F=String.valueOf(Dresult);		
		mf.getShow().setText(F);
	}

}
