package java0924;

class GoThread extends Thread {
		
	@Override
	public void run() { // 스레드의 시작메소드
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
	public void run() { // 스레드의 시작메소드
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
		// 멀티스레드 생성방법
		// 1. java.lang.Thread 클래스 상속
		//	run() 메소드 오버라이딩
		//	스래드객체의 start() 호출해서 스레드 시작시킴
		
		// 스레드 객체 생성, 스레드 객체당 스택이 준비됨.
		GoThread goThread = new GoThread();
		ComeThread comeThread = new ComeThread();
		
		goThread.start(); // JVM에게 스레드 시작을 부탁함 -> JVM이 스레드객체의 run()을 호출함
		comeThread.start();
	}

}
