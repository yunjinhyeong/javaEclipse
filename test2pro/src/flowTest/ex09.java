package flowTest;
import java.util.Scanner;
	
public class ex09 {

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.print("원의 중심점 x,y와 반지름 radius 입력 >>> ");
			double x1 = sc.nextDouble();
			double y1 = sc.nextDouble();
			double radius = sc.nextDouble();
			
			System.out.print("임의의 한점 x1,y1 입력 >>> ");
			double x2 = sc.nextDouble();
			double y2 = sc.nextDouble();
			
			double length  = Math.sqrt( ((x2-x1)*(x2-x1)) + ((y2-y1)*(y2-y1)) );
			
			if(length > radius)
				System.out.println("임의의 점 (x2, y2)가 원 밖에 있습니다.");
			else
				System.out.println("임의의 점 (x2, y2)가 원 안에 있습니다.");
			sc.close();
		}
}
