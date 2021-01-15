package java0924;


class SharedData {
	
	private int num;
	
	// synchronized : ������ ����ȭ. ��ü������ ����ȭ.
	//  �� �����尡 synchronized �޼ҵ带 ���� ��ü�� �޼ҵ带
	//  ȣ���ϸ� ����� �� ��ü�� Lock(���)�� �ɸ�.
	//  �޼ҵ� ȣ��Ϸ��� Lock�� Ǯ�������� �ٸ��������
	//  ����ϰ� ��.
	synchronized public void up() {
		String threadName = Thread.currentThread().getName();
		System.out.print(threadName + "�� " + num + "�� ");
		num++;
		System.out.println(num + "�� ������Ŵ");
	}
	
	synchronized public void down() {
		String threadName = Thread.currentThread().getName();
		System.out.print(threadName + "�� " + num + "�� ");
		num--;
		System.out.println(num + "�� ���ҽ�Ŵ");
	}
} // class SharedData


class UpThread extends Thread {

	private SharedData sharedData;
	
	public UpThread(SharedData sharedData) {
		super();
		this.sharedData = sharedData;
	}

	@Override
	public void run() {
		// sharedData�� up() ȣ��
		for (int i=0; i<10; i++) {
			try {
				Thread.sleep(500); // 1�� = 1000�и���
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sharedData.up();
		} // for
	} // run()
} // class UpThread


class DownThread extends Thread {

	private SharedData sharedData;
	
	public DownThread(SharedData sharedData) {
		super();
		this.sharedData = sharedData;
	}

	@Override
	public void run() {
		// sharedData�� down() ȣ��
		for (int i=0; i<10; i++) {
			try {
				Thread.sleep(500); // 1�� = 1000�и���
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sharedData.down();
		} // for
	} // run()
} // class DownThread


public class Ex5 {

	public static void main(String[] args) {
		// ��ü ���Թ�� 2����
		//  1. �����ڸ� ���� ����
		//  2. �޼ҵ带 ���� ����
		
		// upThread�� downThread ��ü�� �Ѵ�
		// ������ sharedData��ü�� ������(sharedData��ü�� �ʵ尪�� ������)
		
		SharedData sharedData = new SharedData();
		
		UpThread upThread = new UpThread(sharedData);
		upThread.setName("Up������");
		
		DownThread downThread = new DownThread(sharedData);
		downThread.setName("down������");
		
		upThread.start(); // JVM�� ���ؼ� run()�� ȣ���
		downThread.start();
	} // main

}
