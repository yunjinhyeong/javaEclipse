package java0922;

import java.util.HashMap;
import java.util.Map;

public class Ex4 {

	public static void main(String[] args) {
		// Map �÷��� : Ű�� ���� ������ ������ �����ϴ� �ڷᱸ��
		
		Map<String, Animal> animalMap = new HashMap<>();
		
		animalMap.put("Ǫ��", new Puppy());
		animalMap.put("�����", new Cat());
		animalMap.put("����", new Duck());

		
	}

}
