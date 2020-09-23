package java0923;

public class Ex2 {

	public static void main(String[] args) {
		// 오류의 종류: 에러(Error), 예외(Exception)
		
		// 에러 : 컴퓨터 하드웨어 고장 등으로 인한 JVM 오류, 심각한 오류.
		//		 복구 불가능한 심각한 오류.
		
		// 예외 : 프로그램 사용자의 잘못된 조작 또는
		// 	     잘못된 코딩으로 인해 발생하는 프로그램 오류.
		// 		 프로그램 실행중 발생할 수 있는 예기치 못한 오류를 말함.
		
		System.out.println("=== 프로그램 시작 ===");
		
		// 예외처리
		int a = 10, b = 0, c = 0;
		
		int[] arrNum = {1, 2, 3};
		
		String str = null;
		
		try {
			// c = a / b;
			System.out.println(str.length());
			arrNum[5] = 50;
			System.out.println(arrNum[5]);
		} catch(NullPointerException e) {
			e.printStackTrace();
		} catch(ArithmeticException e) {
			e.printStackTrace();
		} catch(RuntimeException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(c);
		
		System.out.println("=== 프로그램 종료 ===");
	}

}
