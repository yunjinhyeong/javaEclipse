package test2pro;
import java.util.*;

public class test2 {

	public static void main(String[] args) {
		System.out.println("2�ڸ��� ���� �Է�(10~99)>>");
		Scanner a = new Scanner(System.in);
		int result = a.nextInt();
		switch(result % 11) {
			case 0:
				System.out.println("Yes! 10�� �ڸ��� 1�� �ڸ��� �����ϴ�.");
				break;
			default:
				System.out.println("No! 10�� �ڸ��� 1�� �ڸ��� ���� �ʽ��ϴ�.");
				break;
		}
	}

}
