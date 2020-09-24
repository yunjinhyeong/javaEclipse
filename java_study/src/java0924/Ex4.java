package java0924;

public class Ex4 {

	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread(); // 스레드 타입 하나 리턴
		
		System.out.println(mainThread.getName()); // main
		System.out.println(mainThread.getPriority()); // 5(기본값)
		
		System.out.println(mainThread.MAX_PRIORITY); // 10
		System.out.println(mainThread.NORM_PRIORITY); // 5
		System.out.println(mainThread.MIN_PRIORITY); // 1
		
		mainThread.setPriority(7); // 스래드 객체에 대해 우선순위 선정
	}

}
