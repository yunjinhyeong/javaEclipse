package CopyEx0109;

import java.util.Scanner;

public class DicApp {
	Scanner sc = new Scanner(System.in);
	String word;
	
	public void Run() {
		while(true) {
			System.out.print("한글 단어?");
			word = sc.next();
			if(word.equals("그만")) {
				break;
			}
			String result = Dictionary.kor2Eng(word);
			if(result==(null))
				System.out.println(word+"은(는) 저의 사전에 없습니다.");
			else
				System.out.println(word+"은(는) "+result);
		}
	}
	public static void main(String[] args) {
		DicApp dicapp = new DicApp();
		System.out.println("한영 단어 검색 프로그램입니다.");
		dicapp.Run();
	}
}
