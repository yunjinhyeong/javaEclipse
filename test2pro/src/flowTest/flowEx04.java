package flowTest;
import java.util.*;

public class flowEx04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("3���� ���� �Է��Ͻÿ�");
		int a1 = sc.nextInt();
		int a2 = sc.nextInt();
		int a3 = sc.nextInt();
		
		int middle=0;
		// a2<a1<a3 or a3<a1<a2
		if((a1>=a2 && a1<=a3) || (a1>=a3 && a1<=a2))
			middle = a1;
		else if((a2>=a1 && a2<=a3) || (a2>=a3 && a2<=a1))
			middle = a2;
		else if((a3>=a1 && a3<=a2) || (a3>=a2 && a3<=a1))
			middle = a3;
		
		System.out.println("�߰�����?"+middle);
		
		sc.close();
	}
}
