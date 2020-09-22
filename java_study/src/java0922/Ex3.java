package java0922;

import java.util.ArrayList;
import java.util.List;

public class Ex3 {

	public static void main(String[] args) {
		// List : 가변크기 배열
		
		List<Integer> numList = new ArrayList<>();
		
		// 그냥 add는 마지막에 요소 추가
		numList.add(100); // 인덱스 0번째
		numList.add(200); // 인덱스 1번째
		numList.add(300); // 인덱스 2번째
		//특정위체에 요소삽입
		numList.add(1, 400); // 사라지는게 아니라 1번에 400이 와서 기존에 있는것들은 한칸씩 이동됨
		System.out.println(numList.toString());
		for(int i = 0 ; i<numList.size() ; i++) {
			int num = numList.get(i);
			System.out.println(num);
		}
		
		System.out.println("///////////////////////////");
//		for(Integer num : numList) {
//			System.out.println(num);
//		}
		
//		numList.set(0, 1000); 0번째 1000으로 수정
//		numList.remove(2); //2번째꺼
//		numList.clear(); //모든요소
		for(Integer num : numList) {
			System.out.println(num);
		}
		// int -> Integer : 박싱
		// Integer -> int : 언박싱
			
	}

}
