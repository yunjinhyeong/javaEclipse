package ex04;

import java.util.Scanner;

public class DicApp {
	Scanner sc = new Scanner(System.in);
	private String name;
	
	public void run() {
		System.out.println("한영 단어 검색 프로그램 입니다.");
		while(true) {
			System.out.print("한글 단어?>>");
			name = sc.next();
			if(name.equals("그만"))
				break;
			String result = Dictionary.kor2Eng(name);
			if(result==(null))
				System.out.println(name+"은(는) 저의 사전에 없습니다.");
			else
				System.out.println(result);
		}
	}
	
	public static void main(String[] args) {
		DicApp dicapp = new DicApp();
		dicapp.run();

	}

}
