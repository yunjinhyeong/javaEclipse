package practice03;
import java.util.*;

public class ex15 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("곱하고자 하는 두 수 입력 >>");
		try {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			System.out.println(n + "x" + m + "=" + n*m);
		}catch(InputMismatchException e) {
			System.out.println("정수를 입력해야됩니다. 다시 실행하시오");
		}
		scanner.close();
	}

}
