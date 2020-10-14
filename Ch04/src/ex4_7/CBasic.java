package ex4_7;

public class CBasic {

	public static void main(String[] args) 
	{
		Sample aClass = new Sample();
//		aClass.a = 10;//되고
		aClass.setA(10);
//		aClass.b = 10;//이게 정상!
		aClass.setB(22);
//		aClass.c = 10;//되고
		aClass.setC(30);
		
		System.out.println(aClass.getA());
		System.out.println(aClass.getB());
		System.out.println(aClass.getC());

	}

}
