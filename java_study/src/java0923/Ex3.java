package java0923;

class Test { // try catch ����
	
	public void methodA() throws NullPointerException, Exception {
		System.out.println("methodA() ȣ���.");
		
		methodB();
	}
	public void methodB() throws NullPointerException, Exception { // ȣ���ѳ��� å��
		System.out.println("methodB() ȣ���.");
		
		methodC(-1);
	}
	public void methodC(int num) throws NullPointerException, Exception {
		System.out.println("methodC() ȣ���.");
		// ��������� ���ܹ߻���Ű�� �ڵ�
		if( num<0 ) {
			throw new Exception("num���� �����Դϴ�. ����� �����մϴ�.");
		}
		
	}
}

public class Ex3 {

	public static void main(String[] args) { // throws NullPointerException, Exception { // main�� ȣ���ϴ°� JVM
		System.out.println("=== ���α׷� ���� ===");
		Test test = new Test();
		try {
			test.methodA();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("=== ���α׷� ���� ===");
	}

}
