package java0922;

public class Ex1 {
	public static void main(String[] args) {
		// Pubby��ü�� Puppy���������� �����ؼ� �޼ҵ� ȣ��ÿ���
		// ����(�����Ͻð�) ���ε��� �߻��Ѵ�.
//		Puppy puppy = new Puppy();
//		puppy.speak();
//		// Pubby��ü�� Animal���������� �����ؼ� �޼ҵ� ȣ��ÿ���
//		// �������ε� �� ����(����ð�) ���ε����� �߻��Ѵ�.
//		Animal animal = new Puppy();
//		
//		animal = new Cat();
//		
//		animal.speak(); //�۸�
		
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
	// �ɹ�����(�ʵ�)
	int age;
	String gender;


	// �޼ҵ�
	void speak() {
		System.out.println("�Ҹ�����~");
	}
}

class Puppy extends Animal implements Robot{
	
	public Puppy() {
		
	}
	
	public Puppy(int age, String gender) {
		super.age = age;
	}
	
	void speak() {
		System.out.println("�۸�~");
	}

	@Override
	public void guardAndRecord() {
		System.out.println("����Ű�� ��ȭ�ϱ�");
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
}

class Vet { //���ǻ�
	
//	void giveShot(Puppy puppy) { // �ֻ����
//		// ���������� �ֻ������ �������� ¢�´�.
//		puppy.speak();
//	}
//	
//	void giveShot(Cat cat) { // �ֻ����
//		// ��������� �ֻ������ ����̰� ���.
//		cat.speak();
//	}
	
	void giveShot(Animal Animal) { // �ֻ����
		// �������� �����ؼ� ����
		Animal.speak();
	}
}



class Cat extends Animal {
	
	
	void speak() {
		System.out.println("�߿�~");
	}
}

class Duck extends Animal {
	
	
	void speak() {
		System.out.println("�в�~");
	}
}

interface Robot {
	void guardAndRecord(); // ����Ű�� ��ȭ�ϱ� �߻�޼ҵ�
}


