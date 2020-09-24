package flowTest;

import java.util.Scanner;

public class ex11Switch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("월을 입력하시오 >>> ");
		int x = sc.nextInt();
		
		switch(x)
		{
			case 3:
			case 4:
			case 5:
				System.out.println("봄");
				break;
			case 6:
			case 7:
			case 8:
				System.out.println("여름");
				break;
			case 9:
			case 10:
			case 11:
				System.out.println("가을");
				break;
			case 1:
			case 2:
			case 12:
				System.out.println("겨울");
				break;
		}
		sc.close();
	}

}
