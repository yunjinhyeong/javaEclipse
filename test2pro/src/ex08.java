import java.util.Scanner;

public class ex08 {

	public static boolean inRect(int x, int y, int rect_x1, int rect_y1, int rect_x2, int rect_y2) {
		if((x>=rect_x1 && x<=rect_x2) && (y>=rect_y1 && y<=rect_y2)) {
		return true;
		} else {
		return false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("4개 입력");
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		
		if(	    inRect(x1, y1, 100, 100, 200, 200)
			||  inRect(x1, y2, 100, 100, 200, 200) 
			||  inRect(x2, y1, 100, 100, 200, 200) 
			||  inRect(x2, y2, 100, 100, 200, 200)) {
			System.out.println("겹친다");
		} else if(  inRect(100, 200, x1, y1, x2, y2)
			    &&  inRect(100, 200, x1, y1, x2, y2) 
			    &&  inRect(100, 200, x1, y1, x2, y2) 
			    &&  inRect(100, 200, x1, y1, x2, y2))
			System.out.println("완전 겹친다");
		else
			System.out.println("XXXXXXXXXXX");
		sc.close();
	}
}
