package test2pro;
import java.util.*;

public class test11 {
	
	public static void main(String[] args) {
		System.out.print("���� �Է��ϼ���(1~12)>>");
		Scanner a = new  Scanner(System.in);
		int num = a.nextInt();
		
		if((num<13) && (num>0)) {
			switch(num) {
			case 3:
			case 4:
			case 5:
				System.out.println("��");
				break;
			case 6:
			case 7:
			case 8:
				System.out.println("����");
				break;
			case 9:
			case 10:
			case 11:
				System.out.println("����");
				break;
			case 1:
			case 2:
			case 12:
				System.out.println("�ܿ�");
				break;
			}
		} else {
			System.out.println("�߸��Է�");
		}
	}

}
