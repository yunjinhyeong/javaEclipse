import java.util.*;

public class practiceEx07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		if ((x>=100 & x<=200) && (y>=100 & y<=200)) {
			System.out.println("("+x+","+y+")�� �簢�� �ȿ� �ֽ��ϴ�.");
		} else
			System.out.println("("+x+","+y+")�� �簢�� �ȿ� �����ϴ�.");
		
	}

}
