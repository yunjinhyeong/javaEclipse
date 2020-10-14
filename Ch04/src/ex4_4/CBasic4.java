package ex4_4;

public class CBasic4 {

	//객체를 사용하는 위치 main()
	public static void main(String args[]) 
	{
		char c[] = { 'T', 'h', 'i', 's', ' ', 'i', 's', ' ', 'a', ' ', 'p', 'e', 'n', 'c', 'i', 'l', '.' };

		//1.객체를 만든 후에, 객체의 메소드를 사용
		ArrayUtil au1 = new ArrayUtil();
//		au1.printCharArray(c); //객체.메소드()
//		au1.replaceSpace(c); //call by reference -> c[]배열을 메소드로 보낸다. 
//		au1.printCharArray(c);
				
//		//2.클래스로 접근 (static 메소일 경우 가능)
//		ArrayUtil.printCharArray(c);//클래스명.메소드()
//		ArrayUtil.replaceSpace(c);
//		ArrayUtil.printCharArray(c);
		
		//1.변수
		int n = 10;
		au1.printPlusOne(n);		
		System.out.println("main의 n출력 -> "+n);
		
		//2.배열
		int nArr[] = {10,20,30};		
		au1.printPlusOneArr(nArr);
		System.out.println("main의 nArr[0]출력 -> "+nArr[0]);
	}

}
