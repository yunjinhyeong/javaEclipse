package ex57;

public class Ex {

	public static void main(String[] args) {
		StaticSample s1, s2;
		s1 = new StaticSample();
		s1.n=5;
		s1.g();//m=20
		System.out.println(s1.m);
		s1.m=50;
		System.out.println(s1.m);
		s2 = new StaticSample();
		s2.n = 8;
		s2.h();//m=30
		System.out.println(s1.m);
		s2.f();//m=5
		System.out.println(s1.m);
		System.out.println(s1.m);

	}

}
