package java0923;

public class Ex2 {

	public static void main(String[] args) {
		// ������ ����: ����(Error), ����(Exception)
		
		// ���� : ��ǻ�� �ϵ���� ���� ������ ���� JVM ����, �ɰ��� ����.
		//		 ���� �Ұ����� �ɰ��� ����.
		
		// ���� : ���α׷� ������� �߸��� ���� �Ǵ�
		// 	     �߸��� �ڵ����� ���� �߻��ϴ� ���α׷� ����.
		// 		 ���α׷� ������ �߻��� �� �ִ� ����ġ ���� ������ ����.
		
		System.out.println("=== ���α׷� ���� ===");
		
		// ����ó��
		int a = 10, b = 0, c = 0;
		
		int[] arrNum = {1, 2, 3};
		
		String str = null;
		
		try {
			// c = a / b;
			System.out.println(str.length());
			arrNum[5] = 50;
			System.out.println(arrNum[5]);
		} catch(NullPointerException e) {
			e.printStackTrace();
		} catch(ArithmeticException e) {
			e.printStackTrace();
		} catch(RuntimeException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(c);
		
		System.out.println("=== ���α׷� ���� ===");
	}

}
