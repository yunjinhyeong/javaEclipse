package flowTest;
import java.util.Scanner;
	
public class ex09 {

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.print("���� �߽��� x,y�� ������ radius �Է� >>> ");
			double x1 = sc.nextDouble();
			double y1 = sc.nextDouble();
			double radius = sc.nextDouble();
			
			System.out.print("������ ���� x1,y1 �Է� >>> ");
			double x2 = sc.nextDouble();
			double y2 = sc.nextDouble();
			
			double length  = Math.sqrt( ((x2-x1)*(x2-x1)) + ((y2-y1)*(y2-y1)) );
			
			if(length > radius)
				System.out.println("������ �� (x2, y2)�� �� �ۿ� �ֽ��ϴ�.");
			else
				System.out.println("������ �� (x2, y2)�� �� �ȿ� �ֽ��ϴ�.");
			sc.close();
		}
}
