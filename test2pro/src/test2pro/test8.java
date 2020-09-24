package test2pro;
import java.util.*;

public class test8 {
	
	public static boolean inRect(int x, int y, int rect_x1, int rect_y1, int rect_x2, int rect_y2) {
		if((x>=rect_x1 && x<=rect_x2) && (y>=rect_y1 && y <= rect_y2)) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("4자리 입력");
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		
		if((inRect(100,100,x1,y1,x2,y2)==false && inRect(100,200,x1,y1,x2,y2)==false)
				&& (inRect(200,100,x1,y1,x2,y2)==false && inRect(200,200,x1,y1,x2,y2)==false))
		{
			System.out.println("삼각형이 않습니다.");
		} else
			System.out.println("삼각형이 겹칩니다.");
		
		sc.close();
			
		}
}
