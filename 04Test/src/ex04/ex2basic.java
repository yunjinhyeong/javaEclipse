package ex04;

import java.util.Scanner;

public class ex2basic {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("����, ����, ���� ������ 3���� ���� �Է�>>");
		int math = scanner.nextInt();
		int science = scanner.nextInt();
		int english = scanner.nextInt();
		Grade me = new Grade(math, science, english);
		System.out.println("����� "+ me.average());
		scanner.close();
	}

}
