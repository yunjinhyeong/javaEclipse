package ex4_4;

public class CBasic4 {

	//��ü�� ����ϴ� ��ġ main()
	public static void main(String args[]) 
	{
		char c[] = { 'T', 'h', 'i', 's', ' ', 'i', 's', ' ', 'a', ' ', 'p', 'e', 'n', 'c', 'i', 'l', '.' };

		//1.��ü�� ���� �Ŀ�, ��ü�� �޼ҵ带 ���
		ArrayUtil au1 = new ArrayUtil();
//		au1.printCharArray(c); //��ü.�޼ҵ�()
//		au1.replaceSpace(c); //call by reference -> c[]�迭�� �޼ҵ�� ������. 
//		au1.printCharArray(c);
				
//		//2.Ŭ������ ���� (static �޼��� ��� ����)
//		ArrayUtil.printCharArray(c);//Ŭ������.�޼ҵ�()
//		ArrayUtil.replaceSpace(c);
//		ArrayUtil.printCharArray(c);
		
		//1.����
		int n = 10;
		au1.printPlusOne(n);		
		System.out.println("main�� n��� -> "+n);
		
		//2.�迭
		int nArr[] = {10,20,30};		
		au1.printPlusOneArr(nArr);
		System.out.println("main�� nArr[0]��� -> "+nArr[0]);
	}

}
