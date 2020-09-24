package flowTest;

import java.util.Scanner;

public class ex07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("두점 입력 >>> ");
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		// 사각형 (100, 100) , (200, 200)
		
		if((x>=100 && x<=200) && (y>=100 && y<=200))
		{
			System.out.println("사각형안에 있음");
		} else
			System.out.println("사각형안에 없음");
	}

}
