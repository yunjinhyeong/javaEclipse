package java0922;

import java.util.ArrayList;
import java.util.List;

public class Ex3 {

	public static void main(String[] args) {
		// List : ����ũ�� �迭
		
		List<Integer> numList = new ArrayList<>();
		
		// �׳� add�� �������� ��� �߰�
		numList.add(100); // �ε��� 0��°
		numList.add(200); // �ε��� 1��°
		numList.add(300); // �ε��� 2��°
		//Ư����ü�� ��һ���
		numList.add(1, 400); // ������°� �ƴ϶� 1���� 400�� �ͼ� ������ �ִ°͵��� ��ĭ�� �̵���
		System.out.println(numList.toString());
		for(int i = 0 ; i<numList.size() ; i++) {
			int num = numList.get(i);
			System.out.println(num);
		}
		
		System.out.println("///////////////////////////");
//		for(Integer num : numList) {
//			System.out.println(num);
//		}
		
//		numList.set(0, 1000); 0��° 1000���� ����
//		numList.remove(2); //2��°��
//		numList.clear(); //�����
		for(Integer num : numList) {
			System.out.println(num);
		}
		// int -> Integer : �ڽ�
		// Integer -> int : ��ڽ�
			
	}

}
