package java0922;

public class Ex1 {
	public static void main(String[] args) {
		// Pubby객체를 Puppy참조변수로 저장해서 메소드 호출시에는
		// 정적(컴파일시간) 바인딩만 발생한다.
//		Puppy puppy = new Puppy();
//		puppy.speak();
//		// Pubby객체를 Animal참조변수로 저장해서 메소드 호출시에는
//		// 정적바인딩 후 동적(실행시간) 바인딩까지 발생한다.
//		Animal animal = new Puppy();
//		
//		animal = new Cat();
//		
//		animal.speak(); //멍멍
		
		System.out.println("/////////////////////////");
		
		Vet vet = new Vet();
		Puppy poodle = new Puppy();
		
		vet.giveShot(poodle);
		
		Cat tom = new Cat();
		vet.giveShot(tom);
		
		Duck duck = new Duck();
		vet.giveShot(duck);
	
		Robot puppyRobot = new Puppy();
		puppyRobot.guardAndRecord();
		
		Animal ani = (Animal) puppyRobot;
		ani.speak();
	}
}

class Animal {
	// 맴버변수(필드)
	int age;
	String gender;


	// 메소드
	void speak() {
		System.out.println("소리내기~");
	}
}

class Puppy extends Animal implements Robot{
	
	public Puppy() {
		
	}
	
	public Puppy(int age, String gender) {
		super.age = age;
	}
	
	void speak() {
		System.out.println("멍멍~");
	}

	@Override
	public void guardAndRecord() {
		System.out.println("집지키고 녹화하기");
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
}

class Vet { //수의사
	
//	void giveShot(Puppy puppy) { // 주사놓기
//		// 강아지한테 주사놓으면 강아지가 짖는다.
//		puppy.speak();
//	}
//	
//	void giveShot(Cat cat) { // 주사놓기
//		// 고양이한테 주사놓으면 고양이가 운다.
//		cat.speak();
//	}
	
	void giveShot(Animal Animal) { // 주사놓기
		// 다형성을 적용해서 구현
		Animal.speak();
	}
}



class Cat extends Animal {
	
	
	void speak() {
		System.out.println("야옹~");
	}
}

class Duck extends Animal {
	
	
	void speak() {
		System.out.println("꽥꽥~");
	}
}

interface Robot {
	void guardAndRecord(); // 집지키고 녹화하기 추상메소드
}


