package java0924;

class GoTask implements Runnable {
	
	@Override
	public void run() { // �������� ���۸޼ҵ�
		Thread goTaskThread = Thread.currentThread(); // thread1�� ������ ��ü��
		System.out.println(goTaskThread.getName());
		//go();
	}

	void go() {
		while (true) {
			System.out.println("go");
		}
	}
}

class ComeTask implements Runnable {
	
	@Override
	public void run() {
		//come();
	}

	void come() {
		while (true) {
			System.out.println("come");
		}
	}
}

public class Ex3 {

	public static void main(String[] args) {
		// ��Ƽ������ �������
		// 2. java.lang.Runnable �������̽� ������ �۾�Ŭ���� ����.
		//    run() �޼ҵ� �������̵�
		//    �����尴ü ���� �� Runnable ������ü�� �����ϰ�
		//    start() ȣ���ؼ� ������ ���۽�Ŵ
		
		// �����尴ü(�ϲ�)�� �غ��ϰ� ����(Runnable������ü)�� ������
		GoTask goTask = new GoTask(); // ����
		Thread thread1 = new Thread(goTask); // �ϲۿ��� ������ ������
		thread1.setName("Go������");
		
		Thread thread2 = new Thread(new ComeTask());
		
		thread1.start();
		thread2.start();
		
	} // main
}