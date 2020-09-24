package test2pro;
import java.util.*;

public class test9 {
	
	public static void main(String[] args) {
		System.out.print("원의 중심과 반지름 입력>>");
		Scanner a = new  Scanner(System.in);
		double x1 = a.nextDouble();
		double y1 = a.nextDouble();
		double radius = a.nextDouble();
		System.out.print("점 입력>>");
		double x2 = a.nextDouble();
		double y2 = a.nextDouble();
		
		double dist = Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
		
		if(dist <= radius)
			System.out.println("점("+x2+", "+y2+")는 원 안에 있다");
		else
			System.out.println("점("+x2+", "+y2+")는 원 밖에 있다");
		a.close();
		
		
		
	}

}
