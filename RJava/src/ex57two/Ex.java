package ex57two;

import ex57two.StaticSample;

public class Ex {

	public static void main(String[] args) {
		StaticSample.m = 10;
		
		StaticSample s1;
		s1 = new StaticSample();
		System.out.println(s1.m);
		s1.f();
		System.out.println(s1.m);
		StaticSample.f();
		System.out.println(s1.m);

	}

}
