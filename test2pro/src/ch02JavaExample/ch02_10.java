package ch02JavaExample;

import java.util.Scanner;

public class ch02_10 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("������ �Է��Ͻÿ�: ");
		int score = in.nextInt();
		if(score >= 80)
			System.out.println("�����մϴ�! �հ��Դϴ�.");
	}
}
