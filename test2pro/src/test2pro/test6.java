package test2pro;
import java.util.*;

public class test6 {

	public static void main(String[] args) {
		System.out.print("1~99 »çÀÌÀÇ Á¤¼ö¸¦ ÀÔ·ÂÇÏ½Ã¿À>>");
		Scanner a = new  Scanner(System.in);
		int num = a.nextInt();
		
		if(num>=1 && num<=99) {
			int num01=num/10;
			int num10=num%10;
			
			int count=0;
			
			if(num01 != 0 && num01 % 3 == 0 )
				count++;
			
			if(num10 != 0 &&  num10 % 3 == 0 )
				count++;
			
			if(count==2) {
				System.out.println("¹Ú¼öÂ¦Â¦");
			} else if(count==1) {
				System.out.println("¹Ú¼öÂ¦");
			} else {
				System.out.println("¹Ú¼ö");
			}
			
		}
		
		
	}

}
