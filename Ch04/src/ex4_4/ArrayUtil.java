package ex4_4;

public class ArrayUtil 
{
	//1.������� - ����
	//2.������ - ����, �����Ǿ���.

	//3.�޼ҵ�
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
	
	//1.�Ű������� "����"
	void printPlusOne(int n)
	{
		n++;
		System.out.println("ArrayUtilŬ������ printPlusOne �޼ҵ� ��-> "+n);
	}
	
	//2.�Ű������� "�迭" 
	void printPlusOneArr(int nArr[])
	{
		nArr[0]++;
		System.out.println("ArrayUtilŬ������ printPlusOneArr �޼ҵ� ��-> "+nArr[0]);
	}
	
	
	
}
