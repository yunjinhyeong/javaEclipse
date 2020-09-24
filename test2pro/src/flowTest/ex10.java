package flowTest;

import java.util.Scanner;

public class ex10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째(x1, y1) 원의 중심과 반지름 입력 >>> ");
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int radius1 = sc.nextInt();
		
		System.out.print("두번째(x2, y2) 원의 중심과 반지름 입력 >>> ");
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		int radius2 = sc.nextInt();
		
		double length = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
		
		if (radius1+radius2 < length && radius1+radius2 < y2-y1) {
			System.out.println("안겹침");
		} else if (radius1+radius2 >= length && radius1+radius2 >= y2-y1){
			System.out.println("겹침");
		} else
			System.out.println("먼가 에러");
			
		

	}

}
