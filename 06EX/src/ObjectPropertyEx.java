// ���� 2���̶� ���ļ�
//class Point {
//	int x, y;
//	public Point(int x, int y) {
//		this.x=x;
//		this.y=y;
//	}
//}

public class ObjectPropertyEx {
	public static void print(Object obj) {
		System.out.println(obj.getClass().getName());// Ŭ���� �̸�
		System.out.println(obj.hashCode());// �ؽ� �ڵ� ��
		System.out.println(obj.toString());// ��ü�� ���ڿ��� ����� ���
		System.out.println(obj);// ��ü ���
		
		
	}

	public static void main(String[] args) {
		// ���� 2���̶� ���ļ�
//		Point p = new Point(2,3);
//		print(p);

	}

}
