package practice03;
import java.util.*;

public class ex15 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("���ϰ��� �ϴ� �� �� �Է� >>");
		try {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			System.out.println(n + "x" + m + "=" + n*m);
		}catch(InputMismatchException e) {
			System.out.println("������ �Է��ؾߵ˴ϴ�. �ٽ� �����Ͻÿ�");
		}
		scanner.close();
	}

}
