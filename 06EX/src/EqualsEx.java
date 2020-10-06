class Rect {
	int width;
	int height;
	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
	}
	public boolean equals(Object obj) {
		Rect p = (Rect)obj;
		if(width*height == p.width*p.height)
			return true;
		else
			return false;			
	}
}
// 3����
//class Point {
//	int x,y;
//	public Point(int x, int y) {
//		this.x = x; this.y=y;
//	}
//	public boolean equals(Object obj) {
//		Point p = (Point)obj;
//		if(x==p.x && y ==p.y)return true;
//		else return false;
//	}
//}
public class EqualsEx {

	public static void main(String[] args) {
		Rect a = new Rect(2,3);
		Rect b = new Rect(2,3);
		Rect c = new Rect(3,4);
		if(a.equals(b))
			System.out.println("a is equal to b");
		if(a.equals(c))
			System.out.println("a is equal to c");
		if(b.equals(c))
			System.out.println("b is equal to c");
		//3����
//		Point a = new Point(2,3);
//		Point b = new Point(2,3);
//		Point c = new Point(3,4);
//		
//		if(a==b) //false
//			System.out.println("a==b");
//		if(a.equals(b)) //true
//			System.out.println("a is equal to b");
//		if(a.equals(c)) // false
//			System.out.println("a is equal to c");
//		// == �� �ּҰ��� �������� equals�� ������ ���Ѵ�.
	}

}
