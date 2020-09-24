package example3;
import java.util.*;

public class ex06 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = 0;
		int sum = 0;
		
		while (true) {
			if (in.nextInt() == -1)
				break;
			num++;
			sum=sum+num;
		}
		System.out.println("입력된 숫자 개수는 " +num+ "합계는 " +sum);
		
		in.close();
	}
}
