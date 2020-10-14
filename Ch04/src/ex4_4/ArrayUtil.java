package ex4_4;

public class ArrayUtil 
{
	//1.멤버변수 - 없음
	//2.생성자 - 없음, 생략되었다.

	//3.메소드
	static void replaceSpace(char a[]) {
		for (int i = 0; i < a.length; i++)
			if (a[i] == ' ')
				a[i] = ',';
	}

	static void printCharArray(char a[]) 
	{
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i]);
		System.out.println();
	}
	
	//1.매개변수가 "변수"
	void printPlusOne(int n)
	{
		n++;
		System.out.println("ArrayUtil클래스의 printPlusOne 메소드 안-> "+n);
	}
	
	//2.매개변수가 "배열" 
	void printPlusOneArr(int nArr[])
	{
		nArr[0]++;
		System.out.println("ArrayUtil클래스의 printPlusOneArr 메소드 안-> "+nArr[0]);
	}
	
	
	
}
