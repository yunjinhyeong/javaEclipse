package practice03;

import java.util.Scanner;

public class ex04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("소문자 알파벳 하나를 입력하시오>> ");
		String s = sc.next();
		char c = s.charAt(0);
		
		for ( char i = 'a' ; i<=c ; c--, System.out.println()) {
			for ( char j = 'a' ; j<=c ; j++) {
				System.out.print(j);
			}
		}
		
	}

}
