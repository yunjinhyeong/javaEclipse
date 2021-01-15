package java0924;


class GoThread extends Thread {
	
	@Override
	public void run() { // �������� ���۸޼ҵ�
		go();
	}

	void go() {
		while (true) {
			System.out.println("go");
		}
	}
}

class ComeThread extends Thread {
	
	@Override
	public void run() {
		come();
	}

	void come() {
		while (true) {
			System.out.println("come");
		}
	}
}

public class Ex2 {

	public static void main(String[] args) {
		// ��Ƽ������ �������
		// 1. java.lang.Thread Ŭ���� ���
		//    run() �޼ҵ� �������̵�
		//    �����尴ü�� start() ȣ���ؼ� ������ ���۽�Ŵ
		
		// ������ ��ü����. �����尴ü�� ������ �Ѱ��� �غ��.
		// �����尴ü�� �ϲۿ� �ش���.
		GoThread goThread = new GoThread();
		ComeThread comeThread = new ComeThread();
		
		// JVM���� ������ ������ ��Ź�� -> JVM�� �����尴ü�� run() ȣ����.
		goThread.start();
		comeThread.start();
	} // main
	
	
	

}
