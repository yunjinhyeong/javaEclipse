package CopyEx0109;

import java.util.Scanner;

public class DicApp {
	Scanner sc = new Scanner(System.in);
	String word;
	
	public void Run() {
		while(true) {
			System.out.print("�ѱ� �ܾ�?");
			word = sc.next();
			if(word.equals("�׸�")) {
				break;
			}
			String result = Dictionary.kor2Eng(word);
			if(result==(null))
				System.out.println(word+"��(��) ���� ������ �����ϴ�.");
			else
				System.out.println(word+"��(��) "+result);
		}
	}
	public static void main(String[] args) {
		DicApp dicapp = new DicApp();
		System.out.println("�ѿ� �ܾ� �˻� ���α׷��Դϴ�.");
		dicapp.Run();
	}
}
