package java0922;

import java.util.HashMap;
import java.util.Map;

public class Ex4 {

	public static void main(String[] args) {
		// Map 컬렉션 : 키와 값의 쌍으로 데이터 관리하는 자료구조
		
		Map<String, Animal> animalMap = new HashMap<>();
		
		animalMap.put("푸들", new Puppy());
		animalMap.put("고양이", new Cat());
		animalMap.put("오리", new Duck());

		
	}

}
