package ex04;

class TV {
	private String a;
	private int b;
	private int c;
	
	public TV (String a, int b, int c){
		this.a=a;
		this.b=b;
		this.c=c;
	}
	
	public void show() {
		System.out.println(a+"에서 만든 "+b+"년형 "+c+"인치  TV");
	}
}
