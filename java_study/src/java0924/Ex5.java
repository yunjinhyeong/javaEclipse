package java0924;

class SharedData {
	private int num;
	
	synchronized public void up() { // synchronized : 스레드 동기화
		// 한 스레드가 synchronized 메소드를 가진 객체의 메소드를 호출하면 그 즉시 이 객체에 lock이 걸린다.
		// 메소드 호출완료후 lock이 풀릴때까지 다른 스레드는 대기하게 됨.
		String threadName = Thread.currentThread().getName();
		System.out.print(threadName+"가"+num+"을");
		num ++;
		System.out.println(num+"으로 증가시킴");
	}
	synchronized public void down() {
		String threadName = Thread.currentThread().getName();
		System.out.print(threadName+"가"+num+"을");
		num --;
		System.out.println(num+"으로 감소시킴");
	}
}

class UpThread extends Thread { // Thread상속받으면 이 클래스는 걍 스레드가 됨
	
	private SharedData sharedData;
	
	public UpThread(SharedData sharedData) {
		super();
		this.sharedData = sharedData;
	}
	
	@Override
	public void run() {
		// sharedData의 up() 호출
		for( int i=0 ; i<10 ; i++ ) {
			try {
				Thread.sleep(500); // 1초 1000밀리초
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sharedData.up();
		} // for
	} // run()
	
} // class UpThread

class DownThread extends Thread { // Thread상속받으면 이 클래스는 걍 스레드가 됨
	
	private SharedData sharedData;
	
	public DownThread(SharedData sharedData) {
		super();
		this.sharedData = sharedData;
	}
	
	@Override
	public void run() {
		// sharedData의 up() 호출
		for( int i=0 ; i<10 ; i++ ) {
			try {
				Thread.sleep(500); // 1초 1000밀리초
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
		// 객체 주입방법 2가지있다
		// 첫번째 생성자를 통한 주입
		// UpThread upThread = new UpThread(sharedData);
		// 두번째 메소드를 통한 주입
		// UpThread upThread = new UpThread();
		// upThread.setSharedData(sharedData);
		
		// UpThread와 DownThread 객체는 둘다 동일한 sharedData객체를 공유함(sharedData객체의 필드값을 공유함)
		UpThread upThread = new UpThread(sharedData);
		upThread.setName("Up스레드");
		
		DownThread downThread = new DownThread(sharedData);
		downThread.setName("Down스레드");
		
		upThread.start(); // JVM에 의해서 run()이 호출됨
		downThread.start();
	}
}
