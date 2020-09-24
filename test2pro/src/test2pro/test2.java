package test2pro;
import java.util.*;

public class test2 {

	public static void main(String[] args) {
		System.out.println("2자리수 정수 입력(10~99)>>");
		Scanner a = new Scanner(System.in);
		int result = a.nextInt();
		switch(result % 11) {
			case 0:
				System.out.println("Yes! 10의 자리와 1의 자리가 같습니다.");
				break;
			default:
				System.out.println("No! 10의 자리와 1의 자리가 같지 않습니다.");
				break;
		}
	}

}
