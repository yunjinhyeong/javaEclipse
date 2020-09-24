package practice03;

import java.util.Scanner;

public class ex14 {

	public static void main(String[] args) {
		String course[] = {"java", "C++", "HTML5", "컴퓨터 구조", "안드로이드"};
		int score[] = {95, 88, 76, 62, 55};
		Scanner sc = new Scanner(System.in);
		for( int i=0 ; i<5 ; i++) {
			System.out.print("과목 이름 >> ");
			String name = sc.next();
			if(course[i].equals(name)) {
				int n = score[i];
				System.out.println(name+"의 점수는 "+n+"입니다.");
			} else
				System.out.println("없는 과목입니다.");
		}
		
	}

}
