package ch02JavaExample;

import java.util.Scanner;

public class ch02_14 {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		char grade = a.next().charAt(0);
		switch (grade) {
		case 'A':
		case 'B':
			System.out.println("잘함");
			break;
		case 'C':
		case 'D':
			System.out.println("좀더");
			break;
		case 'F':
		System.out.println("다음학기");
			break;
		default:
			System.out.println("잘못됨");
		}
	}
}
