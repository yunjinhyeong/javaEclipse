package example3;
import java.util.*;

public class ex02 {

	public static void main(String[] args) {
		Scanner rd = new Scanner(System.in);
		int n = 0;
		double sum = 0;
		int i = 0;
		while ((i = rd.nextInt()) != 0) {
			sum += i;
			n++;
		}
		System.out.println("�Էµ� ���� ������ " +n+ "���̸� ����� " +sum/n+ "�Դϴ�.");
	}
}
