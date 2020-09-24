package test2pro;
import java.util.*;

public class test10 {
	
	public static void main(String[] args) {
		System.out.print("첫번째 원의 중심과 반지름 입력>>");
		Scanner a = new  Scanner(System.in);
		int x1 = a.nextInt();
		int y1 = a.nextInt();
		int radius1 = a.nextInt();
		System.out.print("두번째 원의 중심과 반지름 입력>>");
		int x2 = a.nextInt();
		int y2 = a.nextInt();
		int radius2 = a.nextInt();
		
		double dist = Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
		
		double radius_sum = radius1+ radius2;
		
		if(dist<radius_sum) {
			System.out.println("두 원은 서로 겹친다.");
		} else {
			System.out.println("두 원은 서로 안 겹친다.");
		}
	}

}
