package ch02JavaExample;

import java.util.Scanner;

public class ch02_14 {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		char grade = a.next().charAt(0);
		switch (grade) {
		case 'A':
		case 'B':
			System.out.println("����");
			break;
		case 'C':
		case 'D':
			System.out.println("����");
			break;
		case 'F':
		System.out.println("�����б�");
			break;
		default:
			System.out.println("�߸���");
		}
	}
}
