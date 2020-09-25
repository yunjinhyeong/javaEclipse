package ex04;

import java.util.Scanner;

public class ex03basic {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("년도 국적 가수 타이틀 순으로 입력>>>");
		int year = sc.nextInt();
		String country = sc.next();
		String artist = sc.next();
		String title = sc.next();
		song so = new song(year,country,artist,title);
		so.show();
	}

}
