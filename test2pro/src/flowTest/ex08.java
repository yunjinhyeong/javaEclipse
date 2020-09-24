package flowTest;
import java.util.Scanner;

public class ex08 {

	public static boolean inRect(int x, int y, int rect_x1, int rect_y1, int rect_x2, int rect_y2) {
		if((x>=rect_x1 && x<=rect_x2) && (y>=rect_y1 && y <= rect_y2)) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("x1 y1 x2 y2 입력 >>> ");
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		
		if(		inRect(x1, y1, 100, 100, 200, 200)
			||	inRect(x1, y2, 100, 100, 200, 200)
			||	inRect(x2, y1, 100, 100, 200, 200)
			||	inRect(x2, y2, 100, 100, 200, 200)) {
			System.out.println("사각형이 겹친다");
		} else if(	inRect(100, 100, x1, y1, x2, y2)
				&&	inRect(100, 100, x1, y1, x2, y2)
				&&	inRect(100, 100, x1, y1, x2, y2)
				&&	inRect(100, 100, x1, y1, x2, y2))
			System.out.println("내가만든 사각형이 기존사각형을 겹친다");
		else
			System.out.println("안겹친다");
		sc.close();
	}
}
