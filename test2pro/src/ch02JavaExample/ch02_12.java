package ch02JavaExample;

import java.util.Scanner;

public class ch02_12 {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		//char grade='C';
		char grade = a.next().charAt(0);
		switch(grade) {
			case 'A':
				System.out.println("�� ���Ͽ����ϴ�.");
				break;
			case 'C':
			case 'D':
				System.out.println("�� �� ����ϼ���.");
				break;
			case 'F':
				System.out.println("���� �б⿡ �ٽ� �����ϼ���.");
				break;
			default:
				System.out.println("�߸��� �����Դϴ�.");
		}
	}
}
