package practice03;

import java.util.Scanner;

public class ex14 {

	public static void main(String[] args) {
		String course[] = {"java", "C++", "HTML5", "��ǻ�� ����", "�ȵ���̵�"};
		int score[] = {95, 88, 76, 62, 55};
		Scanner sc = new Scanner(System.in);
		for( int i=0 ; i<5 ; i++) {
			System.out.print("���� �̸� >> ");
			String name = sc.next();
			if(course[i].equals(name)) {
				int n = score[i];
				System.out.println(name+"�� ������ "+n+"�Դϴ�.");
			} else
				System.out.println("���� �����Դϴ�.");
		}
		
	}

}
