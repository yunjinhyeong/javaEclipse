package ex04;

import java.util.Scanner;

public class DicApp {
	Scanner sc = new Scanner(System.in);
	private String name;
	
	public void run() {
		System.out.println("�ѿ� �ܾ� �˻� ���α׷� �Դϴ�.");
		while(true) {
			System.out.print("�ѱ� �ܾ�?>>");
			name = sc.next();
			if(name.equals("�׸�"))
				break;
			String result = Dictionary.kor2Eng(name);
			if(result==(null))
				System.out.println(name+"��(��) ���� ������ �����ϴ�.");
			else
				System.out.println(result);
		}
	}
	
	public static void main(String[] args) {
		DicApp dicapp = new DicApp();
		dicapp.run();

	}

}
