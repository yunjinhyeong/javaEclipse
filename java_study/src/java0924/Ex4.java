package java0924;

public class Ex4 {

	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread(); // ������ Ÿ�� �ϳ� ����
		
		System.out.println(mainThread.getName()); // main
		System.out.println(mainThread.getPriority()); // 5(�⺻��)
		
		System.out.println(mainThread.MAX_PRIORITY); // 10
		System.out.println(mainThread.NORM_PRIORITY); // 5
		System.out.println(mainThread.MIN_PRIORITY); // 1
		
		mainThread.setPriority(7); // ������ ��ü�� ���� �켱���� ����
	}

}
