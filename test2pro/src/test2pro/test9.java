package test2pro;
import java.util.*;

public class test9 {
	
	public static void main(String[] args) {
		System.out.print("���� �߽ɰ� ������ �Է�>>");
		Scanner a = new  Scanner(System.in);
		double x1 = a.nextDouble();
		double y1 = a.nextDouble();
		double radius = a.nextDouble();
		System.out.print("�� �Է�>>");
		double x2 = a.nextDouble();
		double y2 = a.nextDouble();
		
		double dist = Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
		
		if(dist <= radius)
			System.out.println("��("+x2+", "+y2+")�� �� �ȿ� �ִ�");
		else
			System.out.println("��("+x2+", "+y2+")�� �� �ۿ� �ִ�");
		a.close();
		
		
		
	}

}
