package ch02JavaExample;

import java.util.Scanner;

public class ch02_11 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("���� �Է��Ͻÿ�: ");
		int number = in.nextInt();
		
		if (number % 3 == 0)
			System.out.println("3�� ����Դϴ�.");
		else
			System.out.println("3�� ����� �ƴմϴ�.");
	}
}
