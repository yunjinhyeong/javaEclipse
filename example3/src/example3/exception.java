package example3;
import java.util.*;

public class exception {

	public static void main(String[] args) {
		Scanner rd = new Scanner(System.in);
		int divisor = 0;
		int dividend = 0;
		
		System.out.println("�������� �Է��Ͻÿ�.");
		dividend = rd.nextInt();
		System.out.println("�������� �Է��Ͻÿ�.");
		divisor = rd.nextInt();
		try {
		System.out.println(dividend+ "�� "+divisor+ "�� ������ ����"+dividend/divisor+"�Դϴ�.");
		} catch (ArithmeticException e) {
			System.out.println("0���� ���� �� �����ϴ�.");
		}
	} //e ���� ��� �Ƴ�
}
