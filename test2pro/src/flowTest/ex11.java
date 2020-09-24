package flowTest;

import java.util.Scanner;

public class ex11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("월을 입력하시오 >>> ");
		int x = sc.nextInt();
		
		if(x>=3 && x<=5)
			System.out.println("봄");
		else if(x>=6 && x<=8)
			System.out.println("여름");
		else if(x>=9 && x<=11)
			System.out.println("가을");
		else if(x==12 || x>=1 && x<=2)
			System.out.println("겨울");
		else
			System.out.println("잘못입력됨");
		
	
	}

}
