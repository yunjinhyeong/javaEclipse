package java0924;

class SharedData {
	private int num;
	
	synchronized public void up() { // synchronized : ������ ����ȭ
		// �� �����尡 synchronized �޼ҵ带 ���� ��ü�� �޼ҵ带 ȣ���ϸ� �� ��� �� ��ü�� lock�� �ɸ���.
		// �޼ҵ� ȣ��Ϸ��� lock�� Ǯ�������� �ٸ� ������� ����ϰ� ��.
		String threadName = Thread.currentThread().getName();
		System.out.print(threadName+"��"+num+"��");
		num ++;
		System.out.println(num+"���� ������Ŵ");
	}
	synchronized public void down() {
		String threadName = Thread.currentThread().getName();
		System.out.print(threadName+"��"+num+"��");
		num --;
		System.out.println(num+"���� ���ҽ�Ŵ");
	}
}

class UpThread extends Thread { // Thread��ӹ����� �� Ŭ������ �� �����尡 ��
	
	private SharedData sharedData;
	
	public UpThread(SharedData sharedData) {
		super();
		this.sharedData = sharedData;
	}
	
	@Override
	public void run() {
		// sharedData�� up() ȣ��
		for( int i=0 ; i<10 ; i++ ) {
			try {
				Thread.sleep(500); // 1�� 1000�и���
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sharedData.up();
		} // for
	} // run()
	
} // class UpThread

class DownThread extends Thread { // Thread��ӹ����� �� Ŭ������ �� �����尡 ��
	
	private SharedData sharedData;
	
	public DownThread(SharedData sharedData) {
		super();
		this.sharedData = sharedData;
	}
	
	@Override
	public void run() {
		// sharedData�� up() ȣ��
		for( int i=0 ; i<10 ; i++ ) {
			try {
				Thread.sleep(500); // 1�� 1000�и���
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sharedData.down();
		} // for
	} // run()
	
} // class UpThread

public class Ex5 {

	public static void main(String[] args) {
		
		SharedData sharedData = new SharedData();
		// ��ü ���Թ�� 2�����ִ�
		// ù��° �����ڸ� ���� ����
		// UpThread upThread = new UpThread(sharedData);
		// �ι�° �޼ҵ带 ���� ����
		// UpThread upThread = new UpThread();
		// upThread.setSharedData(sharedData);
		
		// UpThread�� DownThread ��ü�� �Ѵ� ������ sharedData��ü�� ������(sharedData��ü�� �ʵ尪�� ������)
		UpThread upThread = new UpThread(sharedData);
		upThread.setName("Up������");
		
		DownThread downThread = new DownThread(sharedData);
		downThread.setName("Down������");
		
		upThread.start(); // JVM�� ���ؼ� run()�� ȣ���
		downThread.start();
	}
}
