package page06;

public class Point {
	private int x, y; //�� ���� �����ϴ� x, y ��ǥ
	public void set(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public void showPoint() {
		System.out.println("("+x+","+y+")");
	}
}
