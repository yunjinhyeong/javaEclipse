package java0922;

class Parent {
	int num;
	
	
	Parent(int num) {
		this.num =num;
	}
}

class Child extends Parent {
	String str;
	
	Child() {
		//�����Ϸ��� ������ ��� �ȿ���
		//������ ù���ο� �θ�Ŭ������ �⺻������ ȣ�⹮�� ������
		super(10);
//		setNum(10);
	}
}
public class Ex5 {

	public static void main(String[] args) {
		Child chd = new Child();

	}

}