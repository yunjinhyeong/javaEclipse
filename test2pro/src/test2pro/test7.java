package test2pro;
import java.util.*;

public class test7 {

	public static void main(String[] args) {
		System.out.print("�� (x,y)�� ��ǥ�� �Է��Ͻÿ�>>");
		Scanner a = new  Scanner(System.in);
		int num1 = a.nextInt();
		int num2 = a.nextInt();
		
		if((100<=num1)&&(200>=num1)&&(100<=num2)&&(200>=num2)) {
			System.out.println("("+num1+", "+num2+")�� �簢�� �ȿ� �ֽ��ϴ�.");
		} else {
			System.out.println("("+num1+", "+num2+")�� �簢�� �ȿ� �����ϴ�.");
		}
	}

}
