package test2pro;
import java.util.*;

public class test5 {

	public static void main(String[] args) {
		System.out.print("���� 3�� �Է��Ͻÿ�>>");
		Scanner a = new  Scanner(System.in);
		
		int num1 = a.nextInt();
		int num2 = a.nextInt();
		int num3 = a.nextInt();
		
		if ((num1+num2<num3)||(num2+num3<num1)||(num1+num3<num2)) {
			System.out.println("�ﰢ���� �ȵ˴ϴ�.");
		} else {
			System.out.println("��");
		}
	}

}
