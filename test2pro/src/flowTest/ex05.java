package flowTest;
import java.util.*;

public class ex05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("3���� ���� �Է��Ͻÿ�");
		int a1 = sc.nextInt();
		int a2 = sc.nextInt();
		int a3 = sc.nextInt();
		
		if ( (a1+a2 < a3) || (a2+a2 < a1) || (a1+a3 < a2))
			System.out.println("�ﰢ�� �ȵ˴ϴ�");
		else
			System.out.println("�ﰢ��");
	
	}

}
