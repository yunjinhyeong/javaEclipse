package java0923;

public class Ex1 {

	public static void main(String[] args) {
		// ������ ����: ����(Error), ����(Exception)
		
		// ���� : ��ǻ�� �ϵ���� ���� ������ ���� JVM ����.
		//        ���� �Ұ����� �ɰ��� ����.
		
		// ���� : ���α׷� ������� �߸��� ���� �Ǵ�
		//        �߸��� �ڵ����� ���� �߻��ϴ� ���α׷� ����.
		//        ���α׷� ������ �߻��Ҽ� �ִ� ����ġ���� ������ ����.
		
		System.out.println("=== ���α׷� ���� ===");
		
		// ����ó��
		int a = 10, b = 0, c = 0;
		
		if (b == 0) {
			System.out.println("0���� ������ �����ϴ�.");
		} else { // b != 0
			c = a / b;
		}
		
		System.out.println("c = " + c);
		
		System.out.println("=== ���α׷� ���� ===");
	} // main

}
