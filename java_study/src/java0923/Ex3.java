package java0923;

class Test { // try catch 예제
	
	public void methodA() throws NullPointerException, Exception {
		System.out.println("methodA() 호출됨.");
		
		methodB();
	}
	public void methodB() throws NullPointerException, Exception { // 호출한놈이 책임
		System.out.println("methodB() 호출됨.");
		
		methodC(-1);
	}
	public void methodC(int num) throws NullPointerException, Exception {
		System.out.println("methodC() 호출됨.");
		// 명시적으로 예외발생시키는 코드
		if( num<0 ) {
			throw new Exception("num값이 음수입니다. 양수만 가능합니다.");
		}
		
	}
}

public class Ex3 {

	public static void main(String[] args) { // throws NullPointerException, Exception { // main을 호출하는건 JVM
		System.out.println("=== 프로그램 시작 ===");
		Test test = new Test();
		try {
			test.methodA();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("=== 프로그램 종료 ===");
	}

}
